package tools.all.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * 功能描述:  <p>用于构造线程池</p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-08
 * @since java-tools-all 1.0
 */
public class ThreadPools {

    private static final String SCHEDULE_PREFIX = "schedule-";

    /**
     * 创建单线程
     *
     * @param clazz 线程创建的类
     */
    public static ExecutorService newSingleThreadExecutor(Class clazz) {
        return newSingleThreadExecutor(clazz.getSimpleName());

    }

    /**
     * 创建单线程
     *
     * @param name 待创建的线程名称
     */
    public static ExecutorService newSingleThreadExecutor(String name) {
        return new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(5000), getCommonThreadFactory(name),
            new ThreadPoolExecutor.DiscardPolicy());
    }

    /**
     * 创建定时任务单线程
     *
     * @param clazz 线程创建的类
     */
    public static ScheduledExecutorService newSingleThreadScheduledExecutor(Class clazz) {
        return newSingleThreadScheduledExecutor(clazz.getSimpleName());
    }

    /**
     * 创建定时任务单线程
     *
     * @param name 待创建的线程名称
     */
    public static ScheduledExecutorService newSingleThreadScheduledExecutor(String name) {
        return new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern(SCHEDULE_PREFIX + name + "-%d")
                .daemon(true).build());
    }

    /**
     * 创建定时任务线程
     *
     * @param name 待创建的线程名称
     */
    public static ScheduledExecutorService newThreadScheduledExecutor(String name, int coreSize) {
        return new ScheduledThreadPoolExecutor(coreSize,
            new BasicThreadFactory.Builder().namingPattern(SCHEDULE_PREFIX + name + "-%d")
                .daemon(true).build());
    }

    /**
     * 固定线程个数的线程池
     */
    public static ExecutorService newFixedThreadPool(String name, int nThread) {
        return new ThreadPoolExecutor(nThread, nThread, 0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(5000), getCommonThreadFactory(name));
    }

    /**
     * 创建线程池
     *
     * @param name 线程池名称
     * @param keepAliveTime 存活时间
     * @param corePoolSize the number of threads to keep in the pool
     * @param maxPollSize the maximum number of threads to allow in the pool
     * @param queueSize the queue to use for holding tasks before they are executed.
     */
    public static ThreadPoolExecutor newThreadPool(String name, int corePoolSize, int maxPollSize,
        long keepAliveTime, int queueSize) {
        return new ThreadPoolExecutor(corePoolSize, maxPollSize, keepAliveTime, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(queueSize), getCommonThreadFactory(name));
    }

    private static ThreadFactory getCommonThreadFactory(String name) {
        return new ThreadFactoryBuilder().setNameFormat(name + "-%d").build();
    }
}
