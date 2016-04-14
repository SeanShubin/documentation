# End to End Tests Here

## Common Arguments for End to End tests
- But end to end tests are easier!
    - You may be thinking of a narrow sense in which they are easier for a single person to write initially.
    - However, they make it harder everyone to maintain perpetually.
- But we don't want to over-regulate!
    - We have collective code ownership and a shared pipeline.
    - We should not be taking time from and giving frustration to other engineers without giving them a chance to review your reasons for affecting them in such a manner.
- But I feel like I might be missing something, and I need an end to end test for confidence that it will catch anything I miss.
    - By using end to end tests as a crutch, you are making it impossible to address your architectural blind spots.
    - Experiment with introducing abstractions at boundaries that give you that confidence without an end to end test, and don't be afraid to ask for help.
- But I don't know how to test it without an end to end test!
    - Move your behavior out of entry points, and into places covered by logic, boundary, and configuration tests.
    - Now you know.
- But we aren't skilled enough coders to write in a way that does not need end to end tests!
    - Once you have to proper knowledge, it only requires paying attention and discipline.
    - This is a matter of asking for help if you are stuck, and providing feedback to others when they are stuck, both things we control.
- But this does not apply to dynamically typed languages!
    - Dynamic typing only prevents the compiler from catching mistakes.
    - It does not interfere with your ability to move logic out of entry points and into places covered by logic, boundary, and configuration tests.
- But I am absolutely certain that end to end tests are necessary, and I stand by this in spite of my complete inability to point a single example in the history of our code base that demonstrates this is true.
    - I suspect this is due to some architectural nonsense you have gone blind to due to your reliance on end to end tests.
    - Once a concrete example is provided, I will be happy to identify and explain where the architectural problem lies.
    - Unsubstantiated claims are time consuming to address, I ask that you limit your fervor and certainty for such claims to that which is warranted by the evidence you are willing to provide.

## What we are doing
- constantly adding new end to end tests
- many cases we assume it goes without saying that we need an end to end test

## How we should change
- get on the same page regarding what we should do with end to end tests
    - always allow
    - only allow for certain reasons
    - never allow
    - actively remove
- enumerate what we consider sufficient reasons to tolerate an end to end test, including a plan to obviate such reasons in the future

## Proposed addition to standards
- Before adding any test other than a logic, boundary, or configuration test, make the floor aware of the reasons you think it is necessary.
- Only add the test if the floor is unable to give you adequate support to address those reasons.
- Types of support
    - Technical, if you don't know how to get proper coverage with a logic, boundary, or configuration test
    - Refactoring, if some existing bad architecture is leaving you without good testing options

## More precise definitions
- logic, boundary, and configuration tests
    - a set of three types of tests with no overlapping concerns, that when taken together, are in principle able to detect any problem with the application code and/or configuration at the earliest possible moment.
- logic test
    - a test of application logic that is deterministic and fast because it relies only on the rules of the programming language.
    - for example, a logic test may verify that a service invokes a data access object with the proper parameters, using a stub to represent interaction with the database.  
- boundary test
    - a test that verifies nothing that could be verified with a logic test, but rather verifies interaction between the application and non-configuration-specific behavior of a single collaborator beyond the applications control, such as the file system, system clock, system properties, network, database, etc.
    - for example, a boundary test may verify that a data access object can read back what it writes into a live database spun up for testing, but would not be checking any application logic. 
- configuration test
    - a test that does nothing that could be done with a logic or boundary test, but rather verifies the configuration is such that external services are reachable and responsive.
    - for example, a configuration test may verify that the database that a data access object depends on is up and running, but would not verify any particular behavior.
