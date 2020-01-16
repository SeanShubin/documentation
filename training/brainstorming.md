Starting points
The rules
How to learn them
When to follow them
When to break them
When to make them
Foundational Principles 
Systems thinking
Leadership

Maintainable Code and Testing
Top Down Design
Test Driven Design
Dependency Inversion Principle
No end to end tests
Isolate non-determinism from logic
Pair Programming


if you set the boundaries properly, you can create a test from real data in prod to simulate a bug

Immutable Data

Dependency Structure
Api

Frameworks

Object Oriented & Functional Programming

reverse domain name notation


process
thought
technique


critical thinking
	understand why
separation of concerns
	high level, low level
	prototyping, red, green, refactor
initiative
empowerment
communication
compose concurrent
lambda architecture

push nondeterminisim to edges
logic, boundary, health





Target Audience
This is targeted to those who are thinking of becoming software engineers, but don’t have much experience writing code.  I will be focusing on what you really need to know early to accelerate your rate of learning as much as possible.  I also want to help you avoid mistakes and bad habits common in even very experienced software engineers.

Software engineering is “thought work”.  Your goal is to solve a customer’s problem, and your tool is your brain;  not code, not computers, your brain.  In fact, the best solutions you come up with will be the ones where no code was written.  

So, creative, critical thinking is the name of the game; your first inclination needs to be to think about the problem and question your assumptions.
Don’t assume that the problem is the same as one you’ve encountered before
don’t assume the experts know better

Critical Thinking, so you can properly think about what you are doing.
The importance of critical thinking can’t be stressed enough, but since I want to focus on software engineering I will gloss over it and leave to the reader to find material on this elsewhere.  

Critical Thinking
is not innate, so it must be learned
has very little to do with how smart you are
requires discipline
takes continual refinement over a lifetime
What you need to know as soon as possible about critical thinking is
appeal to authority (both the correct and fallacious versions)
appeal to ignorance (both the correct and fallacious versions)
confirmation bias
Eventually, you will want to understand
the scientific method
bayesian reasoning

Criteria for “simple”, in priority order (remember, “simple” does not mean “easy”)
Meet customer need
Safe to change
Clearly express intent
No duplicate code
Concise as possible

Top five skills
Test driven design
Design by contract
Extract method (refactoring)
Replace conditional with polymorphism (refactoring)
Don’t optimize

Meet Customer Need
This can be well expressed by a slight modification to a quote by Richard Feynman.  The original quote is “It does not make any difference how beautiful your guess is. It does not make any difference how smart you are, who made the guess, or what his name is – if it disagrees with experiment it is wrong. That is all there is to it.”.  My paraphrasing to relate this to software engineering is:
It does not make any difference how beautiful your code is. It does not make any difference how smart you are, who wrote the code, or what their name is.  It does not matter how closely it matches the specification, or if it is exactly what the customer asked for – if it does not meet the customer need, it is wrong. That is all there is to it.

Safe to change
How easy it is to write is mostly irrelevant.  Code is written once, but maintained for a very long time.  You will need to be able to make changes without breaking the code.  Test driven design will be your guide here.

Clearly Express Intent
You should be able to tell what code does by looking at it.  Code constructs should have names that correspond to what they represent.  A comment in code is a lie waiting to happen.  Design by contract helps with this.

No duplicate code.
The refactorings will help you with this.  It is especially important to note that this is lower priority than clearly expressing intent.

Concise as possible
Make sure you are not writing anything that does not meet the customer need.

Test Driven Design
If you write the code before you write the test you are coding backwards.  First, start with a test that fails because your code does not implement the feature.  By doing this, you are unambiguously defining what the code should do.  Once know with precision what the code should do, you are equipped to write it.  As you make design mistakes the tests will become hard to write and maintain.  This is a good thing.  It warns you that it is time to stop and think about your design before creating more code that is badly designed.

Design by Contract
The contract must be explicitly clear in the code.  For pure functions, the sole source of inputs is the signature, and the sole source of output is the return value.  There are no side effects, mutating state, or hidden inputs.  For side-effecting functions, the nature of the side effect is clearly expressed in the name.  Side-effecting functions should have no logic, and only do what their name implies.  For objects, all collaborators and configuration are sent via the constructor function, and all capabilities are encapsulated in the returned object.  Implementation details of the created object are hidden behind the proper programming language abstraction (such as an interface or protocol)

Extract Method (in this context, what applies to methods also applies to functions)
Functions allow you to give a human readable name to a block of code, making it much easier to understand.  It is perfectly fine to have all of your functions be only 2-4 lines of code.  Functions can also be used to refactor some types of duplication.

Replace conditional with polymorphism
See the refactoring book and practice on your own to master this.  It takes a while to figure out, but is one of your most important tools.  If you get good at this, you will automatically get good at object oriented design over time.  In fact, the object oriented designs you naturally evolve will be better than planned designs, as they will be based on what was actually needed rather than what someone expected to need.

Don’t optimize
Instead focus on simple, clean, easy to understand code.  Humans are terrible at predicting which code will be the real problem.  Optimizations will also never do better than designing away the need to invoke the code at all.  If there is a problem that seems to require optimization, put in metrics to verify where the problem really is.  Make sure the customer really needs the problem to be solved, sometimes an alternative design or flow will make the optimization unnecessary.  If the customer actually need the code to go faster, this becomes part of the requirements, and is treated accordingly.
