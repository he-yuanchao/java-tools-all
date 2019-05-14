package tools.all.corn;

import tools.all.corn.support.CronSequenceGenerator;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-13
 * @since java-tools-all 1.0
 */
public interface CronTask {

    /**
     * 要被定时调度的任务
     */
    Runnable getRunnable();

    /**
     * 任务调度的频率，该类存在于org.springframework.scheduling.support.CronSequenceGenerator
     * 接受一个cron表达式
     */
    CronSequenceGenerator getCron();
}
