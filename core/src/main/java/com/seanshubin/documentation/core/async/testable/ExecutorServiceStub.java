package com.seanshubin.documentation.core.async.testable;

import java.util.ArrayList;
import java.util.List;

class ExecutorServiceStub extends ExecutorServiceNotImplemented {
    List<Runnable> commands = new ArrayList<>();

    void resolve(int index) {
        commands.get(index).run();
    }

    @Override
    public void execute(Runnable command) {
        commands.add(command);
    }
}
