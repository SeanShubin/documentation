# Maintainability
- What is the most important concept for writing maintainable code?
- Properties of maintainable code
    - High Cohesion, closely related code in the same place
    - Low Coupling, limited dependencies on other code
    - Encapsulation, hidden implementation details
    - Design by Contract, favor the caller, not the implementor
    - Easy to Test, sufficient isolation to test parts individually
- Separate the parts you do control from the parts you don't

# Context
- We are talking about the code you are writing

# Definitions
- Referential Transparency
    - same inputs always get same output
    - no side effects
- Deterministic
    - defined by the rules of the programming language
    - not always referentially transparent
    - predictable within the context of the code you are writing
- [Types of Tests](http://seanshubin.com/types-of-tests.svg)

# What you control
- Defined by the rules of your programming language
- Conditional logic, loops
- Anything referentially transparent
- Anything built from only referentially transparent parts

# What you don't control
- Network
- File system
- System clock
- Launching the process
