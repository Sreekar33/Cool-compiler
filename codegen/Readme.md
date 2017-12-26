As cool is an object oriented language we treat all the types as reference types. As a result, Int, String, Bool, IO, and Object are all modelled as classes in the code generation rather than primitive types. This results in some inefficiency in the generated code and extra memory allocation but makes the code generation uniform across all the types. For name mangling we take the class name and the method name and prepend them with their lengths before concatenating them..
The mangled name is m_(length of the classname)_classname_(length of the method name)_methodname.
We used null terminated strings but we did not count the null character when calculating the length of the strings, to preserve Cool semantics while allowing usage of printf/scanf internally.
In case of loop we have to utilize exhaustive phi functions in order to allow the code within the predicate and the code within the body to refer to the values produced by each other. Hence, unlike with conditional statements, the phi functions we emit for loops are far more than are necessary.
We do one separate pass to find all the string constants in the code.
We have implemented built-in functions by coding them by hand in LLVM IR.
We do not handle SELF_TYPE.
A function which accepts argument of a base type will not accept arguments of a derived type(our code does not handle this case properly). However, a function that returns values of a base type can have a body that returns arguments of a derived type, and assignments from derived types to base types are allowed, and hence this limitation can be worked around to some extent.
We detect division by zero and static dispatch on void errors. We also detect if the bounds of a substring call are illegal.
