### solutions
- measure negative consequences
- detectable via tooling
- easy to fix if detected right away
- harder to fix the longer it goes undetected

### methodology
- quantify problem
- fail build if quantity increases
- fix single instance of a problem
- lower quantity threshold

### plans
- nondeterministic class loading
- detangler
    - designed to keep the architecture from continually becoming harder to maintain
        - Cohesion
        - Coupling
        - Design by Contract
        - Dependency Inversion Principle
        - Stable Dependencies Principle
        - Acyclic Dependencies Principle
    - reads directly out of class files
    - constant values are [inlined](https://docs.oracle.com/javase/specs/jls/se8/html/jls-13.html#jls-13.1)
    - concerned with the final binaries
    - stable dependencies principle
    - dependency cycles
- large files in version control
- too many third party dependencies
    - unstable apis
    - overlapping concerns
    - conflicting transitive dependencies
- particular method invocations
- particular coding patterns
