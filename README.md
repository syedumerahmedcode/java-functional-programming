# java-functional-programming

## Table of content
- [Introduction](#introduction)
- [Out Of Scope](#out-of-scope)
- [Explanation Declarative Approach](#explanation-declarative-approach)
- [Explanation Functional Interface](#explanation-functional-interface)
- [Explanation Callback](#explanation-callback)
- [Explanation Consumer](#explanation-consumer)
- [Explanation Function](#explanation-function)
- [Explanation Optional](#explanation-optional)
- [Explanation Predicate](#explanation-predicate)
- [Explanation Supplier](#explanation-supplier)
- [Explanation Lambdas](#explanation-lambdas)
- [Explanation Map](#explanation-map)
- [Explanation Stream](#explanation-stream)
- [Explanation Parallel Stream](#explanation-parallel-stream)
- [Explanation Combinator Pattern](#explanation-combinator-pattern)
- [Explanation Other important Points](#explanation-other-important-points)
- [Technologies Used](#technologies-used)
- [Prerequisities](#prerequisities)
- [Commands](#commands)
- [References](#references)
- [Contact Information](#contact-information)


## Introduction

The aim of this project is to show case the differences between Imperative and declarative approach of coding. Another focus is on different functions available in the Stream API as well as some pros and cons of some of these approaches.

## Out Of Scope

Since only basic implementation of various functions from stream API is targeted for this project and the main idea is just to see them in action, unit tests are out of scope.

## Explanation Declarative Approach

Our normal approach before Java 8 was to program via Imperative Programming but lambdas work via Declarative programming. 

__Declarative programming:__ Declarative programming is a programming paradigm that expresses the logic of a computation without describing its control flow. In simple words, Declarative Programming is like asking your friend to draw a landscape. You don’t care how they draw it, that’s up to them.

whereas 

__Imperative Programming:__ imperative programming is a programming paradigm that uses statements that changes a program's state. In simple words, Imperative Programming is like your friend listening to Bob Ross telling them how to paint a landscape. While good ole Bob Ross isn’t exactly commanding, he is giving them step by step directions to get the desired result.

   
## Explanation Functional Interface

A functional interface is an interface which has exactly one abstract method.

Please note the following from JavaDoc:

Since _default methods_ have an implementation, they are not abstract. If an interface declares an abstract method overriding one of the public methods of java.lang.Object, that also does not count toward the interface's abstract method count since any implementation of the interface will have an implementation from java.lang.Object or elsewhere.  


Let us see the six basic function interfaces.

|Interface|Signature|Examples|
| --- | --- | --- |
|UnaryOperator<T> T|apply(T t)|String::toLowerCase, Math::tan|
|BinaryOperator<T> T|apply(T t1, T t2)|BigInteger::add, Math::pow|
Function<T, R>	R|apply(T t)|Arrays::asList, Integer::toBinaryString|
Predicate<T, U>	boolean|test(T t, U u)|String::isEmpty, Character::isDigit|
Supplier<T>	T|get()|LocalDate::now, Instant::now|
Consumer<T>	void|accept(T t)|System.out::println, Error::printStackTrace|

**Rules for functional programming**

Pure functional programming has a set of rules that one must follow:

- No state, meaning that the function must not depend on or change the state of a variable/object outside the boundary of the function.
- Pure functions, meaning that the function should have everything encapsulated within it and it **should not** depend on something outside the boundary of the function, for example, some form of global state.
- No side effects outside of the boundary of the function.
- Higher order functions: A function is considered a higher order functions if one of the following two conditions is true.
1) The function takes one or more functions as parameters. For example, Callback
2) The function returns another function as result. For example, combinator pattern.

## Explanation Callback

A callback is some code that you pass to a given method, so that it can be called at a later time.

**Reference:** The source code for the Callback is present in [Callback.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/com/umer/javafunctional/callback/Callback.java) class.

## Explanation Consumer

**Consumer<T>**: Represents an operation that accepts a single input argument and returns no result. It is similar to a void function when compared to imperative implementation.

**BiConsumer<T,U>**: Represents an operation that accepts two input arguments and returns no result.

Consumer is implemented in _Consumer_ class in the project. In the consumer class, a consumer object is created which takes Customer as input and prints the information on the command line. In the main method, the consumer is called via __accept() function__.

**Reference:** The source code for the Consumer is present in [_Consumer.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/com/umer/javafunctional/functionalinterface/_Consumer.java) class.

- Add a picture linking imperative and declarative approach together.

## Explanation Function

**Function<T,R>**: Represents a function that accepts one argument and produces a result.

**BiFunction<T,U,R>**: Represents a function that accepts two arguments and produces a result.

Function is implemented in the _Function_ class in the project. In the function class, a function object _multiplyByTen_ is created which takes integer as input and returns a Integer as output. In the main method, the function is utilized by calling __apply() function.__

Similarly, a BiFunction _incrementByOneAndMultiplyBiFunction_ is also created which takes two integers as input and returns an output.In the main method, __andThen() along with apply() function__.

**Reference:** The source code for the Function is present in [_Function.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/com/umer/javafunctional/functionalinterface/_Function.java) class.

- Add a picture linking imperative and declarative approach together.

## Explanation Optional

- Add a picture linking imperative and declarative approach together.

## Explanation Predicate

- Add a picture linking imperative and declarative approach together.

## Explanation Supplier

- Add a picture linking imperative and declarative approach together.

## Explanation Lambdas

- To be defined

## Explanation Map

- To be defined

## Explanation Stream

- To be defined

## Explanation Parallel Stream

- To be defined

## Explanation Combinator Pattern

- To be defined

 
## Explanation Other Important Points

- Created a simple maven project.

- My project was not compiling, so I added the properties for _1.8 version_ as indicated in this link: https://facingissuesonit.com/2021/05/08/maven-error-source-option-5-is-no-longer-supported-use-6-or-later/

- A stream allows us to get in an abstract mode where we simple tell it what we want.

- Examples of functional programming:

// Assignment context
     Predicate<String> p = String::isEmpty;
     Here we specify the predicate as an empty string .
     Similar to String p="";

// Method invocation context
     stream.filter(e -> e.getSize() > 10)...
     Here e--> is the return type 
     e.size()>10 is the logic of the method
     

// Cast context
     stream.map((ToIntFunction) e -> e.getSize())...
     Here,  (ToIntFunction) is used to transform the return type to Integer.





## Technologies Used

- Java 11
- To be defined


## Prerequisities

- To be defined 

## Commands

- To be defined

## References

- [1](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html#package.description): Java functional package **(JavaDoc)**
- [2](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html): Java Stream **(JavaDoc)**
- [3](https://www.youtube.com/watch?v=rPSL1alFIjI): Functional Programming in Java - Full Course **(YouTube)**
- [4](https://www.youtube.com/watch?v=1xCxoOuDZuU): Java Optionals | Crash Course **(YouTube)**
- [5](https://www.youtube.com/watch?v=1OpAgZvYXLQ): Get a Taste of Lambdas and Get Addicted to Streams by Venkat Subramaniam **(Youtube)**
- [6](https://www.youtube.com/watch?v=t1-YZ6bF-g0): Java 8 STREAMS Tutorial **(YouTube)**
- [7](https://codeburst.io/declarative-vs-imperative-programming-a8a7c93d9ad2): Declarative vs Imperative Programming
- [8](https://mkyong.com/tutorials/java-8-tutorials/): Java 8 Tutorials(From Mkyong)
- [9](https://stackoverflow.com/questions/8736378/what-is-a-callback-in-java): What is a callback function?



## Contact Information

How to reach me? At [github specific gmail account](mailto:syedumerahmedcode@gmail.com?subject=%5BGitHub%5D%20Hello%20from%20Github). Additionally, you can reach me via [Linkedin](https://www.linkedin.com/in/syed-umer-ahmed-a346a746/) or at [Xing](https://www.xing.com/profile/SyedUmer_Ahmed/cv)
