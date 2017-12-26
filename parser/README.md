The assignment task was relatively straightforward. The ANTLR grammar of the language was supplied, and our task was to write the actions corresponding to those productions in order to generate the Abstract Syntax Tree(AST). To do so, we referred to the supplied AST.java for the required details of the various AST node classes. The assignment made special mention of the let construct, requiring that the AST model a multiple variable let expression as a series of nested lets, which was appropriately done through an action. For test cases, we used some of the test cases we submitted for previous assignments.

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

INCORRECT PROGRAMS
wrong1.cl
It contains a syntax error at line 6 which has ';' in place of ':' while match the attribute.

wrong2.cl
It contains the main function with no braces which raises a syntax error at line 6

wrong3.cl
It contains an error matching else without if in line 14 

wrong4.cl
Missing a loop tag in while raises a syntax error

wrong5.cl
Missing semicolon after a method equal in line 7 raises a semantic error
