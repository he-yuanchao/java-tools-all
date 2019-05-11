package tools.all.task;

import java.util.concurrent.TimeUnit;


public interface DelaySupplier {

    long getInitialDelay();

    int getPeriod();

    TimeUnit getTimeUnit();
}
