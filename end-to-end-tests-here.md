# End to End Tests Here

## Common Arguments for End to End tests
- But end to end tests are easier!
    - Easier for a single person to write once, but harder everyone to maintain perpetually
- But we don't want to over-regulate!
    - Software engineering happens in objective reality, there are objectively better and worse ways of doing things.
    - We have collective code ownership and a shared pipeline, certain types of decisions affect everyone else.
    - Do we value developer autonomy so much that we allow individuals to slow the pace of the entire department? 

## What we are doing
- constantly adding new end to end tests
- many cases we assume it goes without saying that we need an end to end test

## How we should change
- get on the same page regarding what we should do with end to end tests
    - always allow
    - only allow for certain reasons
    - never allow
    - actively remove
- enumerate what we consider reasons to tolerate an end to end test, including a plan to obviate such reasons in the future

## Proposed addition to standards
- Before adding any test other than a logic, boundary, or configuration test, make the floor aware of the reasons you think it is necessary.
- Only add the test if the floor is unable to give you adequate support to address those reasons.
- Types of support
    - Technical, if you don't know how to get proper coverage with a logic, boundary, or configuration test
    - Refactoring, if the reason for the test is to compensate for an architectural issue.

## More precise definitions
- logic, boundary, and configuration tests
    - a set of three types of tests with no overlapping concerns, that when taken together, are in principle able to detect any problem with the application code and/or configuration at the earliest possible moment.
- logic test
    - a test of application logic that is deterministic and fast because it relies only on the rules of the programming language.
    - for example, a logic test may verify that a service invokes a data access object with the proper parameters, using a stub to represent interaction with the database.  
- boundary test
    - a test that verifies nothing that could be verified with a logic test, but rather verifies interaction between the application and non-configuration-specific behavior of a single collaborator beyond the applications control, such as the file system, system clock, system properties, network, database, etc.
    - for example, a boundary test may verify that a data access object can read back what it writes into a live database spun up for testing, but would not be checking any logic. 
- configuration test
    - a test that does nothing that could be done with a logic or boundary test, but rather verifies the configuration is such that external services are reachable and responsive.
    - for example, a configuration test may verify that the database that a data access object depends on is up an running, but would not verify any particular behavior.

