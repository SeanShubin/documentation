# End to End Tests

## Early adopter of unit testing
- conventional wisdom was that you would get fired for writing tests instead of working on features
- turns out that the cost of unit tests was an illusion, as they give you the confidence you need to change code faster 

## Consensus
- most of us think we have consensus
- the ideas of what the consensus was is different depending on who you ask

## Obvious problems
- slow
- flaky
- creates extra system load when parallelizing
- affects entire floor

## Subtler problems
- not test driven design, so it hides design problems
- unnecessary
- reduces pressure to add other types of tests

## Types of tests
- unit, verify the insides
- integration, verify boundaries
- health, verify the outsides

## Entry points
- should only have one entry point, and it should never change
- this obviates the need for an end to end test

## What we are doing
- adding new end to end tests, without considering design implications

## Are there legitimate reasons write new ones?
- overcome limitation of compiler?
- entry point?
- legacy code?
- feeling productive?
- other reasons?  Let me know.

## End to end tests instead of other types of tests
- Gain productivity in the same sense that abandoning test driven design would save on typing
- In other words, not at all.  

## End to end tests in addition to other types of tests
- Slows down the entire pipeline
- Draws attention away from design decisions that could obviate the need for an end to end test

## How we should change
- get on the same page
    - always allow
    - only allow for certain reasons
    - never allow
    - actively remove
- enumerate what we consider good reasons
