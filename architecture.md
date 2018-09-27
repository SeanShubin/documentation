# Architecture
## Data
category 1
- immutable
- simple (raw data, no computations)
- durable

category 2
- mutable
- complex (possibly derived)
- restorable
## Asyncronous
handleEvent
- input
    - old state
    - event
- output
    - new state
    - sequence of effects
## Testing
- logic tests
- boundary tests
- configuration tests
    - health checks
    - single smoke test runs every health check
- manual test
    - single manual test of code that never has reason to change
## code architecture
empirically drive design to isolate non determinism
- single entry point
- test driven design
- top down design
- dependency inversion principle
- libraries over frameworks
