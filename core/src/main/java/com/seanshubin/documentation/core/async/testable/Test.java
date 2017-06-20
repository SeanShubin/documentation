package com.seanshubin.documentation.core.async.testable;

public class Test {
    public static void main(String[] args) {
        new Test().run();
    }

    private void run() {
        testAB();
        testBA();
    }

    private void testAB() {
        ExecutorServiceStub executorService = new ExecutorServiceStub();
        FutureRunner futureRunner = new ExecutorServiceFutureRunner(executorService);
        NotificationsStub notifications = new NotificationsStub();
        new Domain(futureRunner, notifications).run();
        executorService.resolve(0);
        executorService.resolve(1);
        verify("ab task a", notifications.taskNames.get(0), "a");
        verify("ab task b", notifications.taskNames.get(1), "b");

    }

    private void testBA() {
        ExecutorServiceStub executorService = new ExecutorServiceStub();
        FutureRunner futureRunner = new ExecutorServiceFutureRunner(executorService);
        NotificationsStub notifications = new NotificationsStub();
        new Domain(futureRunner, notifications).run();
        executorService.resolve(1);
        executorService.resolve(0);
        verify("ba task b", notifications.taskNames.get(0), "b");
        verify("ba task a", notifications.taskNames.get(1), "a");
    }

    void verify(String caption, String actual, String expected) {
        if (expected.equals(actual)) {
            System.out.println(String.format("SUCCESS(%s): %s", caption, actual));
        } else {
            System.out.println(String.format("FAILURE(%s): expected '%s', but got '%s'", caption, expected, actual));
        }
    }

    void verify(String caption, int actual, int expected) {
        if (expected == actual) {
            System.out.println(String.format("SUCCESS(%s): %d", caption, actual));
        } else {
            System.out.println(String.format("FAILURE(%s): expected '%d', but got '%d'", caption, expected, actual));
        }
    }
}
