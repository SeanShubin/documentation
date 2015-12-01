# Design by contract

## How long have foundational concepts been around
- Coupling & Cohesion, Structured Design, Edward Yourdon/Larry Constantine, 1975
- Design by Contract, Object Oriented Software Construction, Bertrand Meyer, 1988
- Java 1.0, James Gosling, 1995

## Coupling
- When one part of the code depends on another
- The more couplings you have, the more you have to know to understand the code 

## Cohesion
- Organize code by responsibility
- No more than one responsibility per module
- Similar responsibilities should be grouped together
- You should not have to make the same change in multiple places

## Design By Contract
- Client is responsible for ensuring preconditions before invoking
- Supplier is responsible for ensuring postconditions before returning
- Exception is thrown if the supplier can not fulfil its contract
    - retry
    - organized panic, to the extent possible, undo side effects  

## Java
- In Java, use interfaces as the contract
- Rely on clear names of methods and parameters 
- Don't pass nulls in an argument list, don't return nulls
    - This does not mean use options instead of nulls, architect the issue away first and only use options if you would otherwise be forced to use a null

## Separate non-determinism from logic, and put it behind a contract
- this makes code easy to unit test
- non-determinism is anything outside control of your code, such as
    - system clock
    - file system
    - database
    - network
    - environment variables

## Definitions from Structured Design
- identifier: the name, address, label, or distinguishing index of an object in a program
- statement: a line, sentence, or other similar well-defined construct of a programming language that defines, describes, or directs one step or part of the solution of hte problem
- boundary element: a statement or other element of a language which serves to define the lexical limits of groups of statements and allows the statements so bounded to be used as a single entity for some purpose
- module: a contiguous sequence of program statements, bounded by boundary elements, having an aggregate identifier
- coupling: a measure of strength of interconnection between one module and another
- cohesion: the degree of functional relatedness of processing elements within a single module

## Definitions from Object Oriented Software Construction
- design by contract: A method of software construction that designs components of a system so that they will cooperate on the basis of precisely defined contracts
- defensive programming: A technique of fighting potential errors by making every module check for many possible consistency conditions, even if this causes redundancy of checks performed by clients and suppliers.  Contradicts Design by Contract.
- contract: The set fo precise conditions that govern the relations between a supplier class and its clients.  The contract for a class includes individual contracts for the exported routines of the class, represented by preconditions and postconditions, and the global class properties, represented by the class invariant 
- client: A class that uses features of another, it supplier, on the basis of the supplier's interface specification (contract).
- supplier: A class that provides another, its client, with features to be used through an interface specification (contract).
- class invariant: An assertion which must be satisfied on creation of every instance of the class, and preserved by every exported routine of the class, so that it will be satisfied by all instances of the class whenever they are externally observable.
- reusable software component: An element of software that can be used in many different applications. 
- module: A unit of software decomposition.  In the object oriented approach, classes provide the basic form of a module.
- postcondition: An assertion attached to a routine, which must be guaranteed by the routine's body on return from any call to the routine if the precondition was satisfied on entry.  Part of the contract governing the routine.
- precondition: An assertion attached to a routine, which must be guaranteed by every client prior to any call to the routine.  Part of the contract governing the routine.

## How to determine what is true
- Lets say you have two opinions, one that 2+2=4, and another that 2+2=6, here are some sample ways to determine the fact of the matter:
- Epistemological Relativism - There is no way to know what "+" and whole numbers are without appealing to authority, so both opinions must be equally right.
- Middle Ground - The truth must be between the two extremes, so 2+2 must be 5
- Objective Reality - With a little research, you can find out what "+" and whole numbers are, allowing you to determine that the answer is objectively 4
