# These are rough notes


     
Some methods used in the project:
     

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
Characteristics of a stream: sized, ordered/unordered, distinct, sorted.
**filter()**: Like the names suggests, this is only used for filtering. This is a replacement of if statement from imperative programming. Parameter: Stream<T> takes Predicate<T>.
**map()**: Map is a transforming function i.e. it transforms values. Here, number of output == number of input. Please note that there is no guarantee on the type of the output with respect to the type of the input. Parameter: Stream<T> map takes Function<T,R> to return Stream<R>.

Both filter and map stay within their swim lanes i.e. They are only concerned with the value at hand and are not considering any values before or after the value in question for their operation.

**reduce()**: reduce on Stream<T> takes two parameters:
first parameter is of type T. 
Second parameter is of type BiFunction<R, T, R> to produce a result of R.  

reduce cuts across swim lanes. For example, it can be use to do summation of number or in other words, any operation which is concerned with the previous or the next value compared to the value currently under progress. Another example, accumulation of a series of numbers or products of all numbers in a series. 
In reduce() the output becomes the input for the next operation i.e. a feedback effect whereas in map() and filter(), there is no feedback effect.

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


Visualization: multiplication of numbers in a series using reduce.
	 1	  	   2		 3		   4		  ...
	 |	  	   | 		 |		   |
1 -> * -> 1 -> * -> 2 -> * -> 6 -> * -> 24 -> ...

**collect()**: It is a reduce operation as well. Collect() function allows us to avoid shared mutability.




