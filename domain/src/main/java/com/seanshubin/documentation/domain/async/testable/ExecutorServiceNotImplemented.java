package com.seanshubin.documentation.domain.async.testable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

abstract class ExecutorServiceNotImplemented implements ExecutorService {
    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public boolean isShutdown() {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public boolean isTerminated() {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public Future<?> submit(Runnable task) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void execute(Runnable command) {
        throw new UnsupportedOperationException("Not Implemented!");
    }
}
