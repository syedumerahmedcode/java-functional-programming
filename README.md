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

A container object which may or may not contain a non-null value. It contains several methods such as _isPresent()_ and _get()_.  If a value is present, _isPresent()_ will return true and _get()_ will return the value. 

Additional methods that depend on the presence or absence of a contained value are provided, such as _orElse()_ (return a default value if value not present) and _ifPresent()_ (execute a block of code if the value is present).

Optional is implemented in the _Optional_ class in the project. In the main method, the code 

```java

final Optional<Object> empty = Optional.empty();

```

means that Optional object is empty. Due to this, __isPresent()__ returns false whereas __isEmpty()__ returns true.

Similarly, the code 

```java

final Optional<String> hello = Optional.of("hello");

```


creates an optional object of hello. Due to this, __isPresent()__ returns true whereas __isEmpty()__ returns false.

The code

```java

final Optional<String> hello2 = Optional.ofNullable(null);

```

delivers a null value. Hence, when calling 

```java

hello2.orElse("World");

```

System.out.println() prints 'World' to command line.

**ifPresentOrElse()**: Using this method, one can define the logic if the value is present or respond accordingly if it is _null_. Logically speaking, it works like a ternary operator. 

**Reference:** The source code for the Optional is present in [_Optional.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/com/umer/javafunctional/functionalinterface/_Optional.java) class.


- Add a picture linking imperative and declarative approach together.

## Explanation Predicate

**Predicate<T>**: Represents a predicate(boolean-valued function) of one argument. Basically, it evaluates a condition to check if it results in true or false. Similarly, 

**BiPredicate<T,U>**: Represents a predicate (boolean-valued function) of two arguments.

Predicate is implemented in _Predicate_ class in the project. In the predicate class, a predicate object

```java

static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> 
				phoneNumber.startsWith("07") && 
				phoneNumber.length() == 11;

```

 is created which takes phone number as input and checks if the conditions are fulfilled. In the main method, the predicate is called via __test() function__. Please note that two or more predicates can be combined using __.and()__ or __.or() functions__. 

**Reference:** The source code for the Predicate is present in [_Predicate.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/com/umer/javafunctional/functionalinterface/_Predicate.java) class.

- Add a picture linking imperative and declarative approach together.

## Explanation Supplier

**Supplier<T>**: Represents a supplier of results. It takes no input and gives an object/list of objects as output. 


Supplier is implemented in _Supplier_ class in the project. In the supplier class, a supplier object

```java

static Supplier<String> getDBConnectionUrlsSupplier = () 
			-> DUMMY_DATABASE_CONNECTION_URL;

```

is created which nothing as input and delivers a String as output. In the main method, the supplier is called via __get() function__.

**Reference:** The source code for the Supplier is present in [_Supplier.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/com/umer/javafunctional/functionalinterface/_Supplier.java) class.

- Add a picture linking imperative and declarative approach together.

## Explanation Lambdas

provides a clear and concise way to represent one method interface using an expression. In simple words, the Lambda expression is used to provide the implementation of an interface which has functional interface. 

## Explanation Map

**map()**: Used for the transformation of an object.  It returns a stream consisting of the results of applying the given function to the elements of this stream. What is returned depends on how the function is implemented inside map method. In simple words, a __map() function__ called within __collect()__ is used to transform the data withikn the stream. 

**Reference:** The source code for the Map is present in [_Map.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/com/umer/javafunctional/streams/_Map.java) class.

## Explanation Stream

A sequence of elements supporting sequential and parallel aggregate operations. To perform a computation, stream operations are composed into a __stream pipeline__. A stream pipeline consists of a _source_ (which might be an array, a collection, a generator function, an I/O channel, etc), zero or more intermediate operations (which transform a stream into another stream, such as _filter(Predicate)_), and a terminal operation (which produces a result or side-effect, such as _count()_ or _forEach(Consumer)_). 

Streams are __lazy__; computation on the source data is __only performed when the terminal operation is initiated__, and source elements are consumed only as needed. 

**Reference:** The source code for the Stream is present in [_Stream.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/com/umer/javafunctional/streams/_Stream.java) class.

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
- [10](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html): Optional **(JavaDoc)**



## Contact Information

How to reach me? At [github specific gmail account](mailto:syedumerahmedcode@gmail.com?subject=%5BGitHub%5D%20Hello%20from%20Github). Additionally, you can reach me via [Linkedin](https://www.linkedin.com/in/syed-umer-ahmed-a346a746/) or at [Xing](https://www.xing.com/profile/SyedUmer_Ahmed/cv)
