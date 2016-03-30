# End to End Tests

## Obvious problems
- slow
- flaky
- creates extra system load when parallelizing
- affects all involved with same build pipeline

## Subtler problems
- no pressure on design
- reduces pressure to add other types of tests
- unnecessary

## [Other types of tests](http://seanshubin.com/types-of-tests.svg)
- unit, verify the insides
- integration, verify boundaries
- health, verify the outsides

## Entry points
- should only have one entry point, and it should never change
    - [console application](https://github.com/SeanShubin/hello/blob/master/src/main/scala/com/seanshubin/hello/ConsoleApplication.scala)
    - [web application](https://github.com/SeanShubin/hello-war/blob/master/src/main/scala/com/seanshubin/hello/war/EntryPointServlet.scala)
    - [web.xml](https://github.com/SeanShubin/hello-war/blob/master/src/main/webapp/WEB-INF/web.xml)
- this obviates the need for an end to end test
