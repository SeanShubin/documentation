package com.seanshubin.documentation.domain.async.testable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DependencyInjection {
    DependencyInjection(String[] args) {
        this.args = args;
    }

    private final String[] args;
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final FutureRunner futureRunner = new ExecutorServiceFutureRunner(executorService);
    private final Notifications notifications = new LineEmittingNotifications(System.out::println);
    final Domain domain = new Domain(futureRunner, notifications);
}
