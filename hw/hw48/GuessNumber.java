/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

// Derek Song
// APCS1 - pd1
// HW#48 - Keep Guessing
// 2017 - 12 - 6

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	if (a > b) {
	    _hi = a;
	    _lo = b;
	}
	else {
	    _hi = b;
	    _lo = a;
	}
	_guessCtr = 1;
	_target = (int) ((Math.random() * b) + a); // range [a, b]
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
	System.out.println ("Take you guess from [" + _lo + ", " +  _hi + "]");
	int UserGuess = Keyboard.readInt();
	_guessCtr++; // needs to increase with every guess but why would we start at one in the Constructor then? shouldn't we start at 0?
	if (UserGuess == _target) {
	    System.out.println ("It took you " + _guessCtr + " guesses! Good job!");
	    System.out.println ("Thanks for playing!");
	    System.out.println ("See you next time!!");
	    return; // need to break from recursion
	}
	else {
	    if ((UserGuess > _hi || UserGuess < _lo)) {
		System.out.println ("KEEP WITHIN THE RANGE");
		//was going to take it out of the recursion but realized that they should be able to try again
	    }
	    if ((UserGuess > _target) && (UserGuess < _hi)) {
		_hi = UserGuess - 1; // if the guess was bigger than the target, then the high can then be reduced to that guess.
	    }
	    if ((UserGuess < _target) && (UserGuess > _lo)) {
		_lo = UserGuess + 1; //same as the previous if statement, if the guess was smaller than the target then the low can be increased to that guess
	    }
	}
	playRec(); // Call it again!
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	int UserGuess = 0;
	while (UserGuess != _target) { //preferred because we are just doing this until they get the number. Thus, there is a singular BE that needs to be followed
	    System.out.println ("Take you guess from [" + _lo + ", " +  _hi + "]");
	    UserGuess = Keyboard.readInt();
	    _guessCtr++;
	    if ((UserGuess > _hi || UserGuess < _lo)) {
		System.out.println ("KEEP WITHIN THE RANGE");
	    }
	    else {
		if (UserGuess > _target) { //  && (UserGuess < _hi)) { <- not needed because it would not have reached this statement if it was outside the range
		    _hi = UserGuess - 1; // if the guess was bigger than the target, then the high can then be reduced to that guess.
		}
		if (UserGuess < _target) { //  && (UserGuess > _lo)) { <- same reasoning as before
		    _lo = UserGuess + 1; //same as the previous if statement, if the guess was smaller than the target then the low can be increased to that guess
		}
	    }
	}
	System.out.println ("It took you " + _guessCtr + " tries!!!");
	System.out.println ("Thanks for playing!");
	System.out.println ("See you next time!!");
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	playRec();
	//playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {

	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class
