package com.seanshubin.documentation.core.async.testable;

import java.util.concurrent.ExecutorService;

class ExecutorServiceFutureRunner implements FutureRunner {
    private final ExecutorService executorService;

    ExecutorServiceFutureRunner(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void runInFuture(Runnable runnable) {
        executorService.execute(runnable);
    }
}
