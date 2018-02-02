// Derek Song
// APCS1 - pd1
// HW#25 - All Hallow's Eve
// 2017 - 11 - 01

public class Loopier {
    public static int[] populate (int[] array) {
	for (int x = 0; x < array.length; x++) {
	    array [x] = (int) (Math.random()*10);//*10 because Math.random gives a decimal
	}
	return array;
    }

    public static String ArrayStr (int[] array) {
	String newStr = "";
	for (int x = 0; x < array.length; x++) { 
	    newStr += Integer.toString(array[x]); // converts int to string
	}
	return newStr;
    }

    public static int linSearch (int[] a, int target) {
	int indexx = -1;
	for (int x = 0; x < a.length; x++) {
	    if (a[x] == target) {
		indexx = x;
		return x; // as you go up the original array return the first occurrence
		    }
	}
	return indexx;
    }

    // problem number 3 recursive
   public static int[] takeout (int[] a){ // helper method (takes out 1st element)
	int[] newArray = new int[a.length - 1]; 
	for (int i = 1; i < a.length; i++){ 
	    newArray[i-1] = a[i]; 
	}
	return newArray;
    }

    public static int linSearchR (int[] a, int target) { 
	if (a.length == 0) { 
	    return -1;
	}
	else if (a[0] == target) { 
	    return 0;
	}
	else if (linSearchR(takeout(a),target) == -1) { 
	    return -1;
	}
	else {
	    return 1 + linSearchR(takeout(a),target);
	}
    }

    public static int freq (int[] a, int target) {
	int counter = 0;
	for (int x = 0; x < a.length; x++) {
	    if (a[x] == target) {
		counter += 1;
	    }
	}
	return counter;
    }

     public static int freqRec (int[] a, int target) { 
	if (a.length == 0) { 
	    return 0;
	}
	else if (a[0] == target) { 
	    return 1 + freqRec(takeout(a), target);
	}
	else {
	    return freqRec(takeout(a), target); 
	}
    }
    
    public static void main (String [] args) {
	int[] test;
	test = new int[5];
	populate (test);
	System.out.println (ArrayStr (test));

	int[] test2 = {
	    1, 4, 5, 4, 2
	};
	
	System.out.println (linSearch (test2, 4));
	System.out.println (linSearchR (test2, 4));
	System.out.println (freq (test2, 4));
	System.out.println(freq(test2, 2));
      	System.out.println(freqRec(test2, 3));
	System.out.println(freqRec(test2, 4));
    }
}
