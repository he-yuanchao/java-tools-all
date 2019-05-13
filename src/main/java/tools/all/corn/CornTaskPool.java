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
public class CornTaskPool {

    private int poolSize;

    private Executor executor;

    private ScheduledExecutorService scheduled;

    private CornTaskPool() {
    }

    public static CornTaskPool newCornTaskPool(int poolSize, String poolName) {
        CornTaskPool taskPool = new CornTaskPool();
        taskPool.executor = ThreadPools.newFixedThreadPool(poolName, poolSize);
        taskPool.scheduled = ThreadPools.newSingleThreadScheduledExecutor("scheduled-" + poolName);
        return taskPool;
    }

    public void submit(CornTask cornTask) {
        scheduled.schedule(() -> safeExec(cornTask), getNextDelay(cornTask.getCorn()),
            TimeUnit.MILLISECONDS);
    }

    private void safeExec(CornTask cornTask) {
        try {
            executor.execute(cornTask.getRunnable());
            submit(cornTask);
        } catch (Exception e) {

        }
    }

    private long getNextDelay(CronSequenceGenerator corn) {
        return corn.next(new Date()).getTime() - System.currentTimeMillis();
    }
}
