# End to End Tests

## Consensus
- most of us think we have consensus
- the ideas of what the consensus was is different depending on who you ask

## Obvious problems
- slow
- flaky
- hard to parallelize

## Subtle problem
- not test driven design

## Types of tests
- unit, verify the insides
- integration, verify boundaries
- health, verify the outsides

## Are there legitimate reasons write new ones?
- overcome limitation of compiler?
- entry point?
- legacy code?
- feeling productive?

## What we are doing

## How we should change
- get on the same page
    - always allow
    - only allow for certain reasons
    - never allow
- enumerate what we consider good reasons

## Notes
we are continually adding more e2e test

what is the tradeoff if we shut them all off

balance freedom of implementation choice against responsibility not to make code more difficult to maintain. 

hello sample

e2e tests make you feel productive in the same sense that not testing at all makes you feel productive
