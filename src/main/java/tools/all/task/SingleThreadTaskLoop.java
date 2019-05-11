package tools.all.task;

import io.netty.util.internal.PlatformDependent;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import tools.all.thread.ThreadPools;

/**
 * 功能描述:  <p>一个无锁自旋的任务队列，支持定时触发任务执行</p>
 */
public class SingleThreadTaskLoop implements TaskLoop {

    private Executor executor;
    private ScheduledExecutorService scheduledExecutor;

    private Task harvestTask;
    private Queue<Task> taskQueue = PlatformDependent.newMpscQueue();

    private volatile Semaphore semaphore = new Semaphore(0);
    private AtomicBoolean wakeup = new AtomicBoolean(false);

    private AtomicBoolean started = new AtomicBoolean(false);

    private DelaySupplier delaySupplier;

    public SingleThreadTaskLoop(String name) {
        executor = ThreadPools.newSingleThreadExecutor("taskloop-" + name);
        scheduledExecutor = ThreadPools.newSingleThreadScheduledExecutor("taskloop-" + name);
    }

    @Override
    public void start() {
        if (started.compareAndSet(false, true)) {
            startConsuming();
            scheduleExecuteHarvestTask();
        }
    }

    @Override
    public void submitTask(Task task) {
        taskQueue.offer(task);
        if (wakeup.compareAndSet(true, false)) {
            wakeup();
        }
    }

    private void wakeup() {
        semaphore.release();
    }

    @Override
    public void registerHarvestTask(Task task) {
        harvestTask = task;
    }

    @Override
    public void setDelaySupplier(DelaySupplier delaySupplier) {
        this.delaySupplier = delaySupplier;
    }

    private void startConsuming() {
        executor.execute(() -> {
            for (; ; ) {
                Task task = taskQueue.poll();
                if (task != null) {
                    safeExecute(task);
                } else {
                    wakeup.set(true);
                    waitForSubmitTask();
                }
            }
        });
    }

    private void waitForSubmitTask() {
        try {
            semaphore.tryAcquire(1, TimeUnit.MILLISECONDS);
        } catch (Exception ignored) {
        }
    }

    private void scheduleExecuteHarvestTask() {
        scheduledExecutor.scheduleAtFixedRate(() -> submitTask(harvestTask),
            delaySupplier.getInitialDelay(), delaySupplier.getPeriod(),
            delaySupplier.getTimeUnit());
    }

    private void safeExecute(Task task) {
        try {
            task.exec();
        } catch (Exception e) {
        }
    }

    @Override
    public long getBlockedTask() {
        return taskQueue.size();
    }
}
