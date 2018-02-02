/*****************************************************
 * class Slots
 * simulates a slot machine in your very own terminal
 * Clyde "Thluffy" Sinclair
 * APCS1 pd00
 * HW26 -- Shmoney
 * 2017-11-07
 *****************************************************/

// Derek Song
// APCS1 - pd1
// HW#26 - Spin Class
// 2017-11-5

public class Slots {

    private static final String[] FRUITS = {
	"lime", "lime", "lime", 
	"lemon", "lemon", "lemon", 
	"cherry", "cherry", "cherry", 
	"orange", "orange", "orange", 
	"grapefruit", "grapefruit", "grapefruit", 
	"tangerine", "tangerine", "tangerine", 
	"ugli", "ugli", "ugli",
	"peach", "peach", "peach"
    };
  
    private String[] _fruits; //to be init'd by each instance


    /*=====================================
      Slots() -- default constructor
      pre:  constant array FRUITS exists, has been initialized
      post: mutable array _fruits contains same elements as FRUITS
      =====================================*/
    
    public Slots() {
	//allocate memory for _fruits based on size of FRUITS:
	_fruits = new String[FRUITS.length];
	//copy elements of FRUITS into _fruits:
	for (int x = 0; x < FRUITS.length; x++) {
	    _fruits[x] = FRUITS[x];
	}
    }


    /*=====================================
      String toString() -- overrides inherited toString()
      pre:  
      post: returns String of elements in slots 0 thru 2, separated by tabs
      =====================================*/
    
    public String toString() {
	/* YOUR IMPLEMENTATION HERE */
	return "Slot 0: " + _fruits[0] + "\tSlot 1: " + _fruits[1] + "\tSlot 2: " + _fruits[2];
    }


    /*=====================================
      void swap(int,int) -- array swap util fxn
      pre:  _fruits array exists
      post: elements at indices i, j are swapped
      =====================================*/
    
    private void swap( int i, int j ) {
	String hold = _fruits[i]; // if we don't do this then the _fruits[j] will be itself
	_fruits[i] = _fruits[j]; // this and the next line changes the values
	_fruits[j] = hold; // uses the value in hold to change with
    }


    /*=====================================
      void spinOnce() -- simulate a pull of the slot machine lever
      pre:  _fruits array exists
      post: randomized order of elements in _fruits array
      =====================================*/
    
    public void spinOnce() {
	for (int eachSlot = 0; eachSlot < _fruits.length; eachSlot++ ) {
	    swap ((int) (Math.random() * 24), (int) (Math.random() * 24)); // swaps each slot with a different value
	}
    }


    /*=====================================
      boolean jackpot() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      false otherwise
      =====================================*/
    
    public boolean jackpot() {
	if ((_fruits[0].equals(_fruits[1])) && (_fruits[0].equals(_fruits[2]))) { //_fruits[2] would equal _fruits[1] because if they're both equal to _fruits[0] then they're equal to each other as well
	    return true;
	}
	return false;
    }


    /*=====================================
      boolean miniWin() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      or if first 3 slots mutually distinct, 
      false otherwise
      =====================================*/
    
    public boolean miniWin() {
	if ((jackpot()) || (_fruits[0] != _fruits[1] && _fruits[0] != _fruits[1] && _fruits[0] != _fruits[1])) {
	    return true;
	}
	return false;
    }


    //main() method for testing
    public static void main( String[] args ) {
	//usage: move bar below down 1 line at a time to test functionality...
	Slots machine01 = new Slots();
	Slots machine02 = new Slots();

	//test to verify slot machines function indepently
	System.out.println();
	System.out.println( "Machine01 initial state:\t" + machine01 );
	System.out.println( "Machine02 initial state:\t" + machine02 );

	System.out.println( "\nSpinning machine01...\n" );

	machine01.spinOnce();

	System.out.println();
	System.out.println( "Machine01 state:\t" + machine01 );
	System.out.println( "Machine02 state:\t" + machine02 );
	System.out.println();

	
	//test gamble-until-you-win mechanism

	System.out.println( "Preparing to spin until a mini win! . . ." );
	System.out.println( "------------------------------------" );

	//if you haven't won, spin again until you win!
	while( machine01.miniWin() == false ) {
	System.out.println( "Your spin..." + "\t" + machine01 );
	System.out.println( "LOSE\n" );
	machine01.spinOnce();
	}


	System.out.println( "====================================" );
	System.out.println( "Your spin..." + "\t" + machine01 );
	System.out.println( "WIN\n" );



	System.out.println( "Preparing to spin until...jackpot! . . ." );
	System.out.println( "------------------------------------" );

	//if you haven't won, spin again until you win!
	while( machine01.jackpot() == false ) {
	System.out.println( "Your spin..." + "\t" + machine01 );
	System.out.println( "LOSE\n" );
	machine01.spinOnce();
	}

	System.out.println( "====================================" );
	System.out.println( "Your spin..." + "\t" + machine01 );
	System.out.println( "JACKPOT!\n" );
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class Slots
