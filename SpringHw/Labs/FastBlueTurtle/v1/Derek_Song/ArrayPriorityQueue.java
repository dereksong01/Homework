// ALGO

// Put elements in the order they are inserted
// EnQ at the end
// DeQ = traverse the array comparing the value to each other
// Find the minimum value

// Derek Song
// APCS2 - pd8
// HW#46 - Arrr, There Be Priorities Here Matey
// 2018 - 5 - 9

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {

    ArrayList<String> arr;

    public ArrayPriorityQueue() {
	arr = new ArrayList<String>();
    }
    public void add(String str) {
	arr.add(str);
    }

    public boolean isEmpty() {
	if (arr.size() == 0)
	    return false;
	return true;
    }

    public String peekMin() {
	String min = "";

	for (int index = 0; index < arr.size(); index++) {
	    if ((arr.get(index).compareTo(arr.get(index + 1))) < 0) { // arr.get(x) is "less" than the next, thus meaning that it has higher priority
		min = arr.get(index);
	    }
	}

	return min;
    }
    
    public String removeMin() {
	String ret = arr.peekMin();
	int index = 0; // index of the minimum value
	
	if (arr.size() == 0)
	    return null;

	else {
	    for (int i = 0; i < arr.size(); i++) 
		if (arr.get(i).equals(ret))
		    index = i;
	    arr.remove(index); // removes the minimum value
	}
	
	return ret;
    }
    
    public static void main(String[] args) {

	ArrayPriorityQueue test = new ArrayPriorityQueue();

	System.out.println(test.isEmpty()); // true
	
	test.add("doo");
	test.add("eoo");
	test.add("roo");
	test.add("eoo");
	test.add("koo");

	System.out.println("Is the list empty?");
	System.out.println(test.isEmpty()); // false
	System.out.println(test); // doo eoo roo eoo koo

	test.removeMin();
	System.out.println(test); // eoo roo eoo koo
	
	test.removeMin();
	System.out.println(test); // roo eoo koo

	test.removeMin();
	System.out.println(test); // roo koo

	test.removeMin();
	System.out.println(test); // roo

	test.removeMin();
	System.out.println(test); //

	System.out.println("Is the list empty?");
	System.out.println(test.isEmpty()); // true
    }

}
