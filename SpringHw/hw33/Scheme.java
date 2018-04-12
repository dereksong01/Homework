// Derek Song
// APCS2 - pd8
// HW#33 - What a Racket
// 2018 - 4 - 12

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. ...
 *   5. Profit!
 *
 * STACK OF CHOICE: ____ by ____
 * b/c ...
 ******************************************************/

public class Scheme
{
    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	String[] arr = expr.split("\\s+"); // "\\s+" to be safe
	String ans = ""; // holds the answer
	String op = ""; // holds the operation
	
	for (int i = 1; i < arr.length; i++) { // we can start from 1 because it is a valid scheme expression
	    if (arr[i].equals("+"))
		op += "+";
	    if (arr[i].equals("-"))
		op += "-";
	    if (arr[i].equals("*"))
		op += "*";
	    if (!(arr[i].equals("+")) || (arr[i].equals("-")) ||
		(arr[i].equals("*")))
		
	}
    }//end evaluate()


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
    }//end unload()


    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
    try {
    Integer.parseInt(s);
    return true;
    }
    catch( NumberFormatException e ) {
    return false;
    }
    }
    */


    //main method for testing
    public static void main( String[] args )
    {

	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  String zoo1 = "( + 4 3 )";
	  System.out.println(zoo1);
	  System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	  //...7

	  String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	  System.out.println(zoo2);
	  System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	  //...17

	  String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	  System.out.println(zoo3);
	  System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	  //...29

	  String zoo4 = "( - 1 2 3 )";
	  System.out.println(zoo4);
	  System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	  //...-4
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//main

}//end class Scheme
