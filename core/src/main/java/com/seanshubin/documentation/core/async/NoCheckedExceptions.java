package com.seanshubin.documentation.core.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class NoCheckedExceptions {
    public static void awaitTermination(ExecutorService executorService, int timeout, TimeUnit seconds) {
        try {
            executorService.awaitTermination(timeout, seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
