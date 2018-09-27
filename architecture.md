# Architecture

## Richard Feynman Quote
If, in some cataclysm, all of scientific knowledge were to be destroyed, and only one sentence passed on to the next generation of creatures, what statement would contain the most information in the fewest words? I believe it is the atomic hypothesis that

`all things are made of atoms — little particles that move around in perpetual motion, attracting each other when they are a little distance apart, but repelling upon being squeezed into one another.`

In that one sentence, you will see, there is an enormous amount of information about the world, if just a little imagination and thinking are applied.

## Data
category 1
- immutable
- simple (raw data, no computations)
- durable

category 2
- mutable
- complex (possibly derived)
- restorable (safe to delete, automatically recomputed)
## Code
empirically drive design to isolate non determinism
- single entry point
- test driven design
- top down design
- dependency inversion principle
- libraries over frameworks
## Testing
- logic tests
- boundary tests
- configuration tests
    - health checks (no domain knowledge)
    - single smoke test runs every health check
- manual test
    - single manual test of code that never has reason to change
- no end to end tests
## Asynchronous
event loop
- input
    - old state
    - event
- output
    - new state
    - sequence of effects (side effects, new events)
