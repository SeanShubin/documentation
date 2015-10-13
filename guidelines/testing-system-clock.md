# Testing System Clock

- First see if you can pass time in the parameter list instead
    - This will usually work if you only access the system clock once
    - This will not work if you need to wait until a certain point within your method to get the time
    - This will not work if you are trying to get a duration, because you have to check the clock twice
- If you do need to see what time it is from within your method
    - As always, any time you depend on something non-deterministic, put it behind a contract
    - In the case of Java 8, there already exists a contract that will work for this purpose
        - java.time.Clock
    - [Stopwatch](../core/src/main/java/com/seanshubin/documentation/core/Stopwatch.java)
    - [StopwatchTest](../core/src/test/java/com/seanshubin/documentation/core/StopwatchTest.java)
