public class MFDriver {
    
    public static void main ( String[] args ) {
	
	int i = 10; // beginning matrix size (i x i)

	MatrixFinder arr = new MatrixFinder();
		
	while (i < 100000) {
	    
	    long start, elapsed;
	    int [][] array = new int [i][i];

	    arr.populate(array);
	    //arr.printArray(array);
	    
	    start = System.nanoTime();
	    
	    arr.finder(array, (int) (Math.random() * 10000));

	    elapsed = System.nanoTime() - start;
	    
	    System.out.println (elapsed);
	    
	    i+= 100;
	}
    }
}
