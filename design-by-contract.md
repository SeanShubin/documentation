# Design by contract


## Definitions from Structured Design
- identifier: the name, address, label, or distinguishing index of an object in a program
- statement: a line, sentence, or other similar well-defined construct of a programming language that defines, describes, or directs one step or part of the solution of hte problem
- boundary element: a statement or other element of a language which serves to define the lexical limits of groups of statements and allows the statements so bounded to be used as a single entity for some purpose
- module: a contiguous sequence of program statements, bounded by boundary elements, having an aggregate identifier
- coupling: a measure of strength of interconnection between one module and another
- cohesion: the degree of functional relatedness of processing elements within a single module


## coupling
- what
    - a measure of strength of interconnection between one module and another 
    - a coupling is when one thing knows about another
    - the number and types of coupling affect the comprehensibility of the code

## cohesion
- what
    - the degree of functional relatedness of processing elements within a single module
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
