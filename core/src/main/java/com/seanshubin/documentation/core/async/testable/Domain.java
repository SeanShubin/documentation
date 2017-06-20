package com.seanshubin.documentation.core.async.testable;

class Domain {
    private final FutureRunner futureRunner;
    private final Notifications notifications;

    Domain(FutureRunner futureRunner, Notifications notifications) {
        this.futureRunner = futureRunner;
        this.notifications = notifications;
    }

    void run() {
        futureRunner.runInFuture(() -> notifications.taskResolved("a"));
        futureRunner.runInFuture(() -> notifications.taskResolved("b"));
    }
}
