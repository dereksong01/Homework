// Derek Song
// APCS1 - pd1
// HW#56 - His Toe Grammar
// 2017 - 12 - 18

import java.util.ArrayList;

public class StatPrinter {
    
    private ArrayList <Integer> _frequency;

    //*************** QUESTION 02 **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data) + 1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]
    public StatPrinter( ArrayList <Integer> data ) 
    {
	_frequency = new ArrayList<Integer> ();
	int counter = 0;
	for (int i = 0; i <= max(data); i++) {
	    counter = 0;
	    for (Integer x:data) {
		if (x == i) { 
		    counter++;
		}
	    }
	    _frequency.add(counter);
	}
    }

    //*************** QUESTION 01 **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    public Integer max( ArrayList <Integer> data ) 
    { 
	Integer foo = data.get(0);
	for (Integer i:data) {
	    if (i > foo) {
		foo = i;
	    }
	}
	return foo; //return max
    }

    //*************** QUESTION 03 **************************
    //postcond: returns true if i > 0 and i < _frequency.size() - 1
    //          and _frequency.get( i - 1 ) < _frequency.get( i )
    //          and _frequency.get( i + 1 ) < _frequency.get( i )
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    public boolean isLocalMode( int i ) 
    { 
        if (i == 0 || i == _frequency.size() -1) {
	    return false;
	}
	if (_frequency.get(i-1) < _frequency.get(i) && _frequency.get(i+1) < _frequency.get(i)) {
	    return true;
	}
	return false;
    }

    //*************** QUESTION 04 **************************
    //postcond: returns list of modes in _frequency
    public ArrayList<Integer> getLocalModes() 
    {
	ArrayList<Integer> foo = new ArrayList<Integer> (); 
	for (int i = 0; i < _frequency.size(); i++) { 
	    if (isLocalMode(i)) {
		foo.add(i); 
	    }
	}
	return foo;
    }


    //*************** QUESTION 05 **************************
    //precond:  longestBar > 0
    public void printHistogram( int longestBar ) 
    {
	int foo = max(_frequency);
	double ratio = (double) longestBar/foo; 
	for (int i = 0; i < _frequency.size(); i++) {
	    System.out.print(i + ": ");
	    for (int x = 1; x <= (int) ( _frequency.get(i) * ratio); x++){ 
		System.out.print("*");
	    }
	    System.out.print("\n");
	}
    }
 
}//end class StatPrinter
