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

## Sean's proposal
- Any test other than a logic, boundary, or configuration test will not be added until the floor has been made aware of perceived reason for such a test and had a chance to respond.
- Responses may include opposing reasons, help with refactoring the design to eliminate the need for another type of test, help with knowledge of how it could be tested differently.

## More precise definitions
- logic, boundary, and configuration tests
    - a set of three types of tests with no overlapping concerns, that when taken together, are in principle able to detect any problem with the application code and/or configuration at the earliest possible moment.
- logic test
    - a test of application logic that is deterministic and fast because it relies only on the rules of the programming language.
- boundary test
    - a test that verifies nothing that could be verified with a logic test, but rather verifies interaction between the application and non-configuration-specific behavior of a single collaborator beyond the applications control, such as the file system, system clock, system properties, network, database, etc.
- configuration test
    - a test that does nothing that could be done with a logic or boundary test, but rather verifies the configuration is such that dependant services are visible and responsive.
