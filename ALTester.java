// Derek Song
// APCS1 - pd1
// HW#46 - AI<B> Sorted!
// 2017 - 12 - 4

import java.util.ArrayList;

public class ALTester {

    //Different ArrayLists for different scenarios
    public static ArrayList <Comparable> OnlyUp = new ArrayList <Comparable>();
    public static ArrayList <Comparable> OnlyDown = new ArrayList <Comparable>();
    public static ArrayList <Comparable> AllSame = new ArrayList <Comparable>();
    public static ArrayList <Comparable> TwoEach = new ArrayList <Comparable>();
    public static ArrayList <Comparable> ThreeEach = new ArrayList <Comparable>();

    public static void populate() {
	
	//OnlyUp
	for (int x = 0; x < 23; x++) {
	    OnlyUp.add(x);
	}
	System.out.println("OnlyUp: " + OnlyUp);
	
	System.out.println(); //organizational purposes
	
	//OnlyDown
	for (int x = 22; x >= 0; x--) {
	    OnlyDown.add(x);
	}
	System.out.println("OnlyDown: " + OnlyDown);

	System.out.println();
	
	//AllSame
	for (int x = 0; x < 23; x++) {
	    AllSame.add(5);
	}
	System.out.println("AllSame: " + AllSame);

	System.out.println();

	//TwoEach
	for (int x = 0; x < 12; x++) {
	    TwoEach.add(x);
	    TwoEach.add(x);
	}
	System.out.println("TwoEach: " + TwoEach);

	System.out.println();
	
	//ThreeEach
	for (int x = 0; x < 12; x++) {
	    ThreeEach.add(x);
	    ThreeEach.add(x);
	    ThreeEach.add(x);
	}
	ThreeEach.add(12); //23 has 2 remaining when divided by 3
	ThreeEach.add(12);
	System.out.println("ThreeEach: " + ThreeEach);
    }

    public static boolean check(ArrayList<Comparable> List) {
	for (int checker = 1; checker < List.size(); checker++) { //start 1 because need to check 0 as well
	    if (List.get(checker).compareTo(List.get(checker - 1)) < 0) { //
		return false;
	    }
	}
	return true;
    }
    
    public static void main(String [] args) {
        populate();
	System.out.println();
	System.out.println(check(OnlyUp));
	System.out.println(check(OnlyDown));
	System.out.println(check(AllSame));
	System.out.println(check(TwoEach));
	System.out.println(check(ThreeEach));
    }
}
