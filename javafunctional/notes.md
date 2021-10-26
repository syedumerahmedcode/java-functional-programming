# These are rough notes

- Created a simple maven project.

- My project was not compiling, so I added the properties for _1.8 version_ as indicated in this link: https://facingissuesonit.com/2021/05/08/maven-error-source-option-5-is-no-longer-supported-use-6-or-later/

- A stream allows us to get in an abstract mode where we simple tell it what we want.

- Examples of functional programming:

// Assignment context
     Predicate<String> p = String::isEmpty;
     Here we specify the predicate as an empty strinng .
     Similar to String p="";

// Method invocation context
     stream.filter(e -> e.getSize() > 10)...
     Here e--> is the return type 
     e.size()>10 is the logic of the method
     

// Cast context
     stream.map((ToIntFunction) e -> e.getSize())...
     Here,  (ToIntFunction) is used to transform the return type to Integer.
     
Some methods used in the project:
     
- **Function<T,R>**: Represents a function that accepts one argument and produces a result.
- **BiFunction<T,U,R>**: Represents a function that accepts two arguments and produces a result.
- **Consumer<T>**: Represents an operation that accepts a single input argument and returns no result. It is similar to a void function when compared to imperative implementation.
- **BiConsumer<T,U>**: Represents an operation that accepts two input arguments and returns no result.
- **Predicate<T>**: Represents a predicate(boolean-valued function) of one argument.
- **BiPredicate<T,U>**: Represents a predicate (boolean-valued function) of two arguments.
- **Supplier<T>**: Represents a supplier of results.

These are coming from Stream API.
- **map()**: Used for the transformation of an object.  It returns a stream consisting of the results of applying the given function to the elements of this stream. What is returned depends on how the function is implemented inside map method.
- **collect()**: Performs some kind of reduction operation on the elements of the stream. In our case, we are using Collector API from Stream.  
- **forEach()**: Performs an action for each element of this stream. 
- **noneMatch()**: Returns whether no elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then true is returned and the predicate is not evaluated. 
- **allMatch()**: Returns whether all elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then true is returned and the predicate is not evaluated. 
- **anyMatch()**: Returns whether any elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then false is returned and the predicate is not evaluated. 

**Combinator Pattern**: This pattern is very useful for doing validation as it helps increase as well as decrease the validation on an object within the business logic. It is implemented inside _combinatorpattern_ package within _CustomerRegistrationValidator_ interface which extends Function<Customer, ValidationResult> where _Customer_ is the business object on which validation is applied whereas _ValidationResult_ is an enum which indicates the possible outcomes of the validation. **TODO**: Write separate section on **CustomerRegistrationValidator** interface.
The combinator pattern is used in the Main class inside combinatorpattern package.

**Stream()**: In simple words, a stream is a very nice, fancy iterator.
**filter()**: Like the names suggests, this is only used for filtering. This is a replacement of if statement from imperative programming. Parameter: Stream<T> takes Predicate<T>.
**map()**: Map is a transforming function i.e. it transforms values. Here, number of output == number of input. Please note that there is no guarantee on the type of the output with respect to the type of the input. Parameter: Stream<T> map takes Function<T,R> to return Stream<R>.

Both filter and map stay within their swim lanes i.e. They are only concerned with the value at hand and are not considering any values before or after the value in question for their operation.

**reduce()**: reduce cuts across swim lanes. For example, it can be use to do summation of number or in other words, any operation which is concerned with the previous or the next value compared to the value currently under progress. Another example, accumulation of a series of numbers or products of all numbers in a series.

Consider the following diagram:

		filter			map			reduce
									0.0
									 \
x1		  |							  \
----------------------------		   \
x2		  ->			x2'		->		+
----------------------------			 \
x3		  |								  \
----------------------------			   \
x4 		  ->			x4'		->			+
----------------------------				 \
											  \



**Rules for functional programming**

Pure functional programming has a set of rules that one must follow:

- No state, meaning that the function must not depend on or change the state of a variable/object outside the boundary of the function.
- Pure functions, meaning that the function should have everything encapsulated within it and it **should not** depend on something outside the boundary of the function, for example, some form of global state.
- No side effects outside of the boundary of the function.
- Higher order functions: A function is considered a higher order functions if one of the following two conditions is true.
1) The function takes one or more functions as parameters. For example, Callback
2) The function returns another function as result. For example, combinator pattern.

# references:
- [1](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html#package.description): Java functional package **(JavaDoc)**
- [2](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html): Java Stream **(JavaDoc)**
- [3](https://www.youtube.com/watch?v=rPSL1alFIjI): Functional Programming in Java - Full Course **(YouTube)**
- [4](https://www.youtube.com/watch?v=1xCxoOuDZuU): Java Optionals | Crash Course **(YouTube)**
- [5](https://www.youtube.com/watch?v=1OpAgZvYXLQ): Get a Taste of Lambdas and Get Addicted to Streams by Venkat Subramaniam **(Youtube)**
Time stamp: 1:29:17
- [6](https://www.youtube.com/watch?v=t1-YZ6bF-g0): Java 8 STREAMS Tutorial **(YouTube)**



