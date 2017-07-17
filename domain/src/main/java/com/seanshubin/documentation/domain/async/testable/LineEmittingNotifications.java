package com.seanshubin.documentation.domain.async.testable;

import java.util.function.Consumer;

class LineEmittingNotifications implements Notifications {
    private final Consumer<String> emit;

    LineEmittingNotifications(Consumer<String> emit) {
        this.emit = emit;
    }

    @Override
    public void taskResolved(String name) {
        emit.accept(name);
    }
}
