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
- [Contribution](#contribution)
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

![ConsumerExplanationOnWhiteBoard](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/resources/ConsumerExplanation.jpeg)

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

**Stream()**: A sequence of elements supporting sequential and parallel aggregate operations. n simple words, a stream is a very nice, fancy iterator. Characteristics of a stream: sized, ordered/unordered, distinct, sorted.

To perform a computation, stream operations are composed into a __stream pipeline__. A stream pipeline consists of a _source_ (which might be an array, a collection, a generator function, an I/O channel, etc), zero or more intermediate operations (which transform a stream into another stream, such as _filter(Predicate)_), and a terminal operation (which produces a result or side-effect, such as _count()_ or _forEach(Consumer)_). 

Streams are __lazy__; computation on the source data is __only performed when the terminal operation is initiated__, and source elements are consumed only as needed. 

**Reference:** The source code for the Stream is present in [_Stream.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/com/umer/javafunctional/streams/_Stream.java) class.

## Explanation Parallel Stream

In simple words, when a parallel stream is executed, multiple threads are created that work on the stream pipeline. 

For example, 

```java

System.out.println("The end result with declarative approach WITH PARALLEL STREAM plus call of method is: "+
				numbers.parallelStream()
				.filter(e -> e%2==0)
				.mapToInt(e -> Sample.compute(e))
				.sum())
		);
		
```

Due to the nature of parallel stream, computations may not behave in intended way due to multiple threads being present. Hence, use it with _caution._

**Reference:** The source code for the Parallel Stream is present in [Sample.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/com/umer/javafunctional/streams/Sample.java) class.

## Explanation Combinator Pattern

Combinator pattern is a pattern in which complex structures are built by defining a small set of very simple 'primitives', and a set of 'combinators' for combining them into more complicated structures.  It's somewhat similar to the _Composition pattern_ found in object-oriented programming.

This pattern is very useful for doing validation as it helps increase as well as decrease the validation on an object within the business logic. It is implemented inside _combinatorpattern_ package within _CustomerRegistrationValidator_ interface which extends Function<Customer, ValidationResult> where _Customer_ is the business object on which validation is applied whereas _ValidationResult_ is an enum which indicates the possible outcomes of the validation.

**Reference:** The source code for the Combinator pattern is present in [CustomerRegistrationValidatorSet.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/combinatorpattern/CustomerRegistrationValidatorSet.java) class and it is used in [Main.java](https://github.com/syedumerahmedcode/java-functional-programming/blob/master/src/main/java/combinatorpattern/Main.java) class.

 
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

**Some methods used in the project**:     

These are coming from Stream API.
- **collect()**: Performs some kind of reduction operation on the elements of the stream. In our case, we are using Collector API from Stream.  
- **forEach()**: Performs an action for each element of this stream. 
- **noneMatch()**: Returns whether no elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then true is returned and the predicate is not evaluated. 
- **allMatch()**: Returns whether all elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then true is returned and the predicate is not evaluated. 
- **anyMatch()**: Returns whether any elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then false is returned and the predicate is not evaluated. 




**filter()**: Like the names suggests, this is only used for filtering. This is a replacement of if statement from imperative programming. Parameter: Stream<T> takes Predicate<T>.
**map()**: Map is a transforming function i.e. it transforms values. Here, number of output == number of input. Please note that there is no guarantee on the type of the output with respect to the type of the input. Parameter: Stream<T> map takes Function<T,R> to return Stream<R>.

Both filter and map stay within their swim lanes i.e. They are only concerned with the value at hand and are not considering any values before or after the value in question for their operation.

**reduce()**: reduce on Stream<T> takes two parameters:
first parameter is of type T. 
Second parameter is of type BiFunction<R, T, R> to produce a result of R.  

reduce cuts across swim lanes. For example, it can be use to do summation of number or in other words, any operation which is concerned with the previous or the next value compared to the value currently under progress. Another example, accumulation of a series of numbers or products of all numbers in a series. 
In reduce() the output becomes the input for the next operation i.e. a feedback effect whereas in map() and filter(), there is no feedback effect.

Consider the following diagram:

```java

		filter			map			reduce
									0.0
									 \
x1		  |							  \
----------------------------		   \
x2		  ->			x2'			->		+
----------------------------			 \
x3		  |								  \
----------------------------			   \
x4 		  ->			x4'				->		+
----------------------------				 \
											  \


Visualization: multiplication of numbers in a series using reduce.
	 1	  	   2		 3		   4		  ...
	 |	  	   | 		 |		   |
1 -> * -> 1 -> * -> 2 -> * -> 6 -> * -> 24 -> ...

```

**collect()**: It is a reduce operation as well. Collect() function allows us to avoid shared mutability.



## Technologies Used

- Java 11

## Prerequisities

None

## Commands

Since there are multiple classes containing main() method, each of which is targeted at highlighting one specific feature of functional programming in Java, one needs to navigate to the specific main() method and run it in an IDE. 

## Contribution

Feature requests, issues, pull requests and questions are welcome.

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
- [11](https://wiki.haskell.org/Combinator_pattern): Combinator pattern **(Haskell Wiki)**



## Contact Information

How to reach me? At [github specific gmail account](mailto:syedumerahmedcode@gmail.com?subject=%5BGitHub%5D%20Hello%20from%20Github). Additionally, you can reach me via [Linkedin](https://www.linkedin.com/in/syed-umer-ahmed-a346a746/) or at [Xing](https://www.xing.com/profile/SyedUmer_Ahmed/cv)
