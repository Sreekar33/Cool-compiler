Semantic analysis is the process of annotating the Abstract Syntax Tree with additional information, and checking the validity of the program. It is generally done in a bottom-up approach(we have opted for a simple post-order traversal in our implementation). The primary tasks carried out during semantic analysis are annotating the AST with types for the various nodes, and enforcing any semantic rules dictated by the language(for exaxmple, variables must be declared before they are used, and are accessible only within the scope of their declaration). Type annotations are done for all nodes that are of type "expression"(and its many subtypes), while the conditions to be enforced are the well-formedness of the inheritance graph, and the single definition of variables before they are used. The inheritance graph is checked and constructed in the first pass through the AST, and the error conditions are the usage of nonexistent types, inheriting illegally from built-in types, and cyclic inheritance. After the graph is constructed, the second pass performs type annotations and the other tasks. To check for definition before use and preventing multiple definitions,  we use a symbol table, implemented as an array of dictionaries. A separate table is used at each scope level to allow easy transition between scopes.

**Test Cases**
We have written tests cases to rigorously test the different parts of our code. We have also written at least 1 test case corresponding to every error message in order to verify that all errors are caught.



helloworld.cl
	Basic hello world program
	
prog1.cl

It matches the class and the program.
It contains three attributes that are declarations of the variables of the form OBJECTID COMMA TYPEID

Then it defines the main function which is matching with a method in feature which is of the form {OBJECTID '(' formal_list ')' which corresponds to main} COLON TYPEID '{' expressions '}'

Then it contains all the expressions which match dispatches and assignments.

prog2.cl

The matching of the expression "arg1 - 2*(arg1/2)" obeys the precedence rules of the grammar. This program also tests conditional statements.

prog3.cl
This checks for the correct behaviour with regard to features.
	arg1 : Int;
	result : Int <- 1;
These match the two types of attribute declarations: attributes with and without assigment.
This code also matches the loop constructs.

prog4.cl

It consists of 4 classes which matches all the four classes and matching the rule. It also tests the case statement.

prog5.cl

It matches the isvoid expression which is given inside the condition.

nontriv1.cl

This is a program that tests if a number is prime.

nontriv2.cl

This is a program that reads a string, converts it to an integer, and prints twice its value.

Both of the nontrivial programs test multiple aspects of the grammar.




**INCORRECT PROGRAMS**

wrong1.cl 
	7: Method outstring not found in Object
	10: Illegal assignment, Int does not subtype Bool

wrong2.cl 
	7: Equality operator on built-in type expects same type on both sides

wrong3.cl 
	7: Equality operator on built-in type expects same type on both sides

wrong4.cl 
	25: Specified type Aimal does not exist
	41: Method noise not found in Object
	41: Type mismatch between formal(String) and actual(Object) parameter

wrong5.cl 
	29: Illegal assignment, Int does not subtype Bool
	30: Binary arithmetic operator expects arguments of type Int,Int, found: Int,Bool
	41: Mismatch between number of formals(0) and actual(1) parameters 

wrong6.cl 
	41: Method nise not found in Object
	41: Type mismatch between formal(String) and actual(Object) parameter

wrong7.cl 
	4: Conditional predicate not of type Bool, found: Int
	23: Illegal assignment, Int does not subtype String
	24: Type CanFialgiven in new-expression does not exist
	24: Method init not found in Object
	
wrong8.cl 
	6: Class Main has multiple definitions

wrong9.cl 
	6: Class Col inherits from non-existent parent Min

wrong10.cl 
	11: Class Main1 is involved in a cyclic inheritance chain

wrong11.cl
	3: Redefinition of arg1 in class Main
	7: Illegal assignment, Int does not subtype String
	8: Binary arithmetic operator expects arguments of type Int,Int, found: String,Int
	8: Binary arithmetic operator expects arguments of type Int,Int, found: String,Int

