package com.seanshubin.documentation.core.async.testable;

import java.util.ArrayList;
import java.util.List;

class NotificationsStub implements Notifications {
    List<String> taskNames = new ArrayList<>();

    @Override
    public void taskResolved(String name) {
        taskNames.add(name);
    }
}
