package com.bayviewglen.daythree;

public class ExampleTwo {

	public static void main(String[] args) {

		// declare 3 integers
		int numberOne, numberTwo;		// notice the naming convention for variables (camelCase)
		//default number is 0 if not assigned too
		int sum;
		
		numberOne = 7;		// numberOne is assigned 7
		// 8 = numberOne;	left-hand side of an assignment must be a variable  *** error ***
		numberTwo = 12;
		
		sum = numberOne + numberTwo;     //BEDMAS then Assignment (=) is last
		
		System.out.println(sum);	// displays the value stored in the variable sum
		
		System.out.println(numberOne + "+" + numberTwo + "=" + sum);	// using string concatenation
		//String is a sequence of characters

	}

}
