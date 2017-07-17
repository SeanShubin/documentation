package com.seanshubin.documentation.domain.async.testable;

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
