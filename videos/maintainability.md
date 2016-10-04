# Maintainability
- This is what I think is the most important concept in order to write maintainable code
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
