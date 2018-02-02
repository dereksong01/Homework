// Derek Song
// APCS1 pd1
// HW#16 -- Get It While You Can
// 2017-10-15

/***
  driver for class Coin
  ~~~ SUGGESTED WORKFLOW: ~~~
  1. Compile this file and run.
  2. Move the "TOP" line below the first statement. 
  (with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
  3. Compile and run again. 
  4. Resolve errors 1 at a time until it works
  5. Repeat 2-4 until TOP meets BOTTOM
***/

public class Driver {
    
    public static void main( String[] args ) {
	    //build Objects from blueprint specified by class Coin

	    //test default constructor
	    Coin mine = new Coin();

	    //test 1st overloaded constructor
	    Coin yours = new Coin( "quarter" );

	    //test 2nd overloaded constructor
	    Coin wayne = new Coin( "dollar", "heads" );
	    
	    // flips until "thedate" number of heads come up
	    wayne.flipCtr = 0;
	    yours.flipCtr = 0;
	    wayne.headsCtr = 0;
	    yours.headsCtr = 0;
	    wayne.tailsCtr = 0;
	    yours.tailsCtr = 0;	    

	    int thedate = 27;
	    while (yours.headsCtr < thedate) {
		yours.flip();
	    }

	    System.out.println ("yours has flipped " + yours.flipCtr +
			      " times and got heads " + thedate + " times");
	    
	    // flips until a certain number of flips occur
	    wayne.flipCtr = 0;
	    yours.flipCtr = 0;
	    wayne.headsCtr = 0;
	    yours.headsCtr = 0;
	    wayne.tailsCtr = 0;
	    yours.tailsCtr = 0;

	    int minimum = 5;
	    int MATCHEEE = 0;
	    while (MATCHEEE < minimum) {
		wayne.flip ();
		yours.flip ();
		if (wayne.upFace == yours.upFace) {
		    MATCHEEE += 1;
		}
	    }

	    System.out.println ("We have done " + wayne.flip() + " flips and we have " + minimum + " matches");

	    // 13000+ LOOPS AND DIVISIBLE YEAR OF OUR BIRTHHH
	    wayne.flipCtr = 0;
	    wayne.headsCtr = 0;
	    wayne.tailsCtr = 0;
	    yours.flipCtr = 0;
	    yours.headsCtr = 0;
	    yours.tailsCtr = 0;

	    int ouryr = 2001;
	    int numbermatches = 0;
	    while (((numbermatches < 13001) ||
		    (numbermatches % ouryr != 0)) == true) {
        	wayne.flip();
		yours.flip();
		if (wayne.upFace == yours.upFace) {
		    numbermatches += 1;
		}

	    }

	    System.out.println ("There have been " + wayne.flipCtr
				+ " flips and " + numbermatches + " matches");
	    /* not this hw

	    //test toString() methods of each Coin
	    System.out.println("mine: " + mine);
	    System.out.println("yours: " + yours);
	    System.out.println("wayne: " + wayne);

	    //test flip() method
	    System.out.println("\nAfter flipping...");
	    yours.flip();
	    wayne.flip();
	    System.out.println("yours: " + yours);
	    System.out.println("wayne: " + wayne);

	    //test equals() method
	    if ( yours.equals(wayne)) { 
		System.out.println( "Matchee matchee!" );
	    }
	    else {
		System.out.println( "No match. Firestarter you can not be." );
	    }
	    */
	}
}
//end main()
//end class
