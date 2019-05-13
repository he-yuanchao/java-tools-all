package tools.all.corn;

import tools.all.corn.support.CronSequenceGenerator;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-13
 * @since java-tools-all 1.0
 */
public interface CornTask {

    Runnable getRunnable();

    CronSequenceGenerator getCorn();
}
