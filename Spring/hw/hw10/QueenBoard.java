// Derek Song
// APCS2 - pd8
// HW#10 - [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
// 2018 - 2 - 27

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
    private int[][] _board;
    
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }

  
    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     */
    public boolean solve()
    {
	if (_board.length == 1) {
	    addQueen(0, 0);
	    System.out.println();
	    printSolution();
	    return true; // possible
	}
	if ((_board.length == 2) || (_board.length == 3)) {
	    System.out.println();
	    return false;
	}
	solveH(0); // begin solving
	System.out.println();
	printSolution();
	return true;
    }

  
    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	if (col == _board.length)
	    return true;
	for (int row = 0; row < _board.length; row++) {
	    if (addQueen(row, col)) // attempts to add a queen at (row, col)
		if (solveH(col + 1)) // continues to place until it does not work
		    return true;
		else
		    removeQueen(row, col); // we do this if it is placed in an invalid space
	}
	return false;
    }


    public void printSolution()
    {
	String ret = "";
	for (int row = 0; row < _board.length; row++) {
	    for (int col = 0; col < _board[0].length; col++) {
		if (_board[row][col] < 1) { // not a Queen
		    ret +=  "_\t";
		}
		else { // a Queen
		    ret += "Q\t";
		}
	    }
	    ret += "\n";
	}
	System.out.println(ret);
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * <General description>
     * precondition: A board must be initialized. Row > _board.length && Col > _board[0].length
     * postcondition: At the coordinated specified, a 1 is placed. Places where it is impossible to place another queen are marked.
     */
    private boolean addQueen(int row, int col){
	if(_board[row][col] != 0){
	    return false;
	}
	_board[row][col] = 1;
	int offset = 1;
	while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
		_board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
		_board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: Board exists.
     * postcondition: The queen at (row, col) is removed. Surrounding spaces are updated.
     */
    private boolean removeQueen(int row, int col){
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;

	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: 
     * postcondition: 
     */
    public String  toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard b = new QueenBoard(5);
	System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
	System.out.println(b);
	b.removeQueen(3,0);
	System.out.println(b);

	// new Chessboards

	QueenBoard one = new QueenBoard(1);
	System.out.println ("1x1");
	one.solve();
	System.out.println(one);
	
	QueenBoard two = new QueenBoard(2);
	System.out.println ("2x2");
	two.solve();

	System.out.println(two);
	
	QueenBoard three = new QueenBoard(3);
	System.out.println ("3x3");
	three.solve();

	System.out.println(three);
	
	QueenBoard nine = new QueenBoard(9);
	System.out.println ("9x9");
	nine.solve();
	System.out.println(nine);
	
	QueenBoard ten = new QueenBoard(10);
	System.out.println ("10x10");
	ten.solve();
	System.out.println(ten);
    }
    
}//end class
