package com.seanshubin.documentation.domain.async.untestable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Domain {
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    void run() {
        executorService.execute(() -> System.out.println("a"));
        executorService.execute(() -> System.out.println("b"));
    }
}
