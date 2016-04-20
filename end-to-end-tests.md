# End to End Tests
- what is our goal?

## Simplicity (more important listed earlier)
- Meet Customer Need
- **Easy To Maintain**
- Clearly Express Intent
- No Duplicate Code
- Concise As Possible

## Early Feedback (better listed earlier)
- Instant
- Compile
- Unit Test
- Integration Test
- **End to End Test**
- Deployment Manual Test
- Customer Feedback

## Obvious problems with end to end tests
- slow
- flaky
- hard to tell exactly where the problem is 
- creates extra system load when parallelizing
- affects all involved with same build pipeline
- difficult to run locally

## Subtler problems with end to end tests
- no pressure on design
- reduces pressure to add other types of tests
- unnecessary

## Entry points
- should only have one entry point, and it should never change
    - [console application](https://github.com/SeanShubin/hello/blob/master/src/main/scala/com/seanshubin/hello/ConsoleApplication.scala)
    - [web application](https://github.com/SeanShubin/hello-war/blob/master/src/main/scala/com/seanshubin/hello/war/EntryPointServlet.scala)
    - [web.xml](https://github.com/SeanShubin/hello-war/blob/master/src/main/webapp/WEB-INF/web.xml)
- this obviates the need for an end to end test on an entry point
- the problem happens when you mix behavior with entry points

## Other types of tests
- [types of tests](http://seanshubin.com/types-of-tests.svg)
    - logic, verify the insides
        - logical unit, not compilation unit
    - boundary, verify boundaries
    - configuration, verify the outsides
- important note about types of tests
    - no overlapping concerns
    - boundary test does not check more than 1 boundary 

