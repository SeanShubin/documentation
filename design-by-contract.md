# Design by contract

## coupling
- what
    - a coupling is when one thing knows about another
    - the number and types of coupling affect the comprehensibility of the code

## cohesion
- what
    - the extent to which similar functionality is grouped together
    - you should not have to make the same change in multiple places

## component
- what
    - given the contracts of its collaborators, return an implementation of a contract
    - it should be easy test a component in isolation from its collaborators

## collaborator
- what
    - a dependency of a component
    - collaborators should be known by their contracts, not their implementations

## contract
- what
    - the specification of capabilities
