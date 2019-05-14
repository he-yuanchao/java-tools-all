package tools.all.corn;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import tools.all.corn.support.CronSequenceGenerator;
import tools.all.thread.ThreadPools;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-13
 * @since java-tools-all 1.0
 */
public class CronTaskPool {

    /**
     * 执行任务的线程池
     */
    private Executor executor;

    /**
     * 调度任务的线程池
     */
    private ScheduledExecutorService scheduled;

    private CronTaskPool() {
    }

    public static CronTaskPool newCornTaskPool(int poolSize, String poolName) {
        CronTaskPool taskPool = new CronTaskPool();
        taskPool.executor = ThreadPools.newFixedThreadPool(poolName, poolSize);
        taskPool.scheduled = ThreadPools.newSingleThreadScheduledExecutor("scheduled-" + poolName);
        return taskPool;
    }

    /**
     * 收到任务后计算距离下一次执行的时间，提交至ScheduledExecutorService中
     */
    public void submit(CronTask cronTask) {
        scheduled.schedule(() -> safeExec(cronTask), getNextDelay(cronTask.getCron()),
            TimeUnit.MILLISECONDS);
    }

    /**
     * 将Cron中的任务提交至Executor执行，生成下一个任务
     */
    private void safeExec(CronTask cronTask) {
        try {
            executor.execute(cronTask.getRunnable());
            submit(cronTask);
        } catch (Exception e) {

        }
    }

    /**
     * 计算当前时间距离下次执行的间隔
     */
    private long getNextDelay(CronSequenceGenerator corn) {
        return corn.next(new Date()).getTime() - System.currentTimeMillis();
    }

    private static void safeSleep(int seconds) {
        try {
            Thread.sleep(1000L * seconds);
        } catch (Throwable t) {

        }
    }

    public static void main(String[] args) {
        CronTaskPool taskPool = CronTaskPool.newCornTaskPool(1, "test");
        taskPool.submit(new CronTask() {
            @Override
            public Runnable getRunnable() {
                return () -> System.out.println(System.currentTimeMillis());
            }

            @Override
            public CronSequenceGenerator getCron() {
                return new CronSequenceGenerator("*/5 * * * * ?");
            }
        });

        safeSleep(100);
    }
}
