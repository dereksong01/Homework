// Derek Song
// APCS2 - p8
// HW#16 - About Face
// 2018 - 3 - 7

public class Mysterion {

    /*
      The function itself is still a mystery. Although in class there was a hint that it might be a sort, I am baffled as to how to name this new sort. However, the start and end vars determine the area as to which to sort under comparison with the compareVal. 
    */
    public static int Mysterion (int[] arr, int start, int end, int compareIndex) {
	int compareVal = arr[compareIndex];
	int holder = arr[compareIndex];
	arr[compareIndex] = arr[end];
	arr[end] = holder;
	int s = start;
	for (int x = 0; x < end - 1; x++) {
	    if (arr[x] < compareVal) {
		holder = arr[s];
		arr[s] = arr[x];
		arr[x] = holder;
		s+=1;
	    }
	}
	holder = arr[end];
	arr[end] = arr[s];
	arr[s] = holder;
	return s;
    }


    public static void printArr (int[] arr) { // you want this to check against trace or visualizer.
	System.out.print("[");
	for (int x = 0; x < arr.length - 1; x++) // only to arr.length - 1 because there would be an extra comma at the end.
	    System.out.print(arr[x] + ",");
	System.out.print(arr[arr.length - 1] + "]\n");
    }
    

    public static void main(String [] args) {

	// ======== MAGIC NUMBERS =========
	System.out.println("\n Array 0");
	int[] arr0 = {7, 1, 5, 12, 3};
        System.out.println(Mysterion(arr0, 0, 4, 0));
	printArr(arr0);

	int[] arr1 = {7, 1, 5, 12, 3};
        System.out.println(Mysterion(arr1, 0, 4, 1));
	printArr(arr1);
	
	int[] arr2 = {7, 1, 5, 12, 3};
        System.out.println(Mysterion(arr2, 0, 4, 2));
	printArr(arr2);
	
	int[] arr3 = {7, 1, 5, 12, 3};
        System.out.println(Mysterion(arr3, 0, 4, 3));
	printArr(arr3);

	int[] arr4 = {7, 1, 5, 12, 3};
        System.out.println(Mysterion(arr4, 0, 4, 4));
	printArr(arr4);

	// ======== SORTED =========
	System.out.println("\n Array 1");
	int[] arr5 = {1, 2, 3, 4, 5};
	System.out.println(Mysterion(arr5, 0, 4, 0));
	printArr(arr5);
	
	int[] arr6 = {1, 2, 3, 4, 5};
	System.out.println(Mysterion(arr6, 0, 4, 1));
	printArr(arr6);

	int[] arr7 = {1, 2, 3, 4, 5};
	System.out.println(Mysterion(arr7, 0, 4, 2));
	printArr(arr7);

	int[] arr8 = {1, 2, 3, 4, 5};
	System.out.println(Mysterion(arr8, 0, 4, 3));
	printArr(arr8);

	int[] arr9 = {1, 2, 3, 4, 5};
	System.out.println(Mysterion(arr9, 0, 4, 4));
	printArr(arr9);

	// ======= DESCENDING =========
	System.out.println("\n Array 2");
	int[] arr10 = {5, 4, 3, 2, 1};
	System.out.println(Mysterion(arr10, 0, 4, 0));
	printArr(arr10);
	
	int[] arr11 = {5, 4, 3, 2, 1};
	System.out.println(Mysterion(arr11, 0, 4, 1));
	printArr(arr11);

	int[] arr12 = {5, 4, 3, 2, 1};
	System.out.println(Mysterion(arr12, 0, 4, 2));
	printArr(arr12);
	
	int[] arr13 = {5, 4, 3, 2, 1};
	System.out.println(Mysterion(arr13, 0, 4, 3));
	printArr(arr13);

	int[] arr14 = {5, 4, 3, 2, 1};
	System.out.println(Mysterion(arr14, 0, 4, 4));
	printArr(arr14);
	
        
    }
}
