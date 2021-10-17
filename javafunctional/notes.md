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

# references:
- [1](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html#package.description): Java functional package **(JavaDoc)**
- [2](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html): Java Stream **(JavaDoc)**
- [3](https://www.youtube.com/watch?v=rPSL1alFIjI): Functional Programming in Java - Full Course
- Timestamp: 01:19:02

