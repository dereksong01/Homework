// Derek Song
// APCS2 - pd8
// HW#17 - So So Fast
// 2018 - 3 - 10

/*
  My findY function uses the value that uses the value that partition gives back the index of the element originally at arr[c] (learned from the qaf), that would mean that there are that many values below it. Thus, if the value index is one less than the y, then we found the yth smallest number. 
*/
public class FastSelect {
    
    public int partition(int[] arr, int start, int end, int compareIndex) {
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

    public int findY(int[] arr, int valuePos) {
	for (int x = 0; x < arr.length - 1; x++) {
	    if (valuePos == (partition(arr, 0, arr.length - 1, x) + 1)) {
		return arr[x];
	    }
	}
	return arr[arr.length - 1];
    }

    public static void main(String [] args){
	int[] arr0 = {1, 2, 3, 4, 5}; // best situation is when it is sorted
	partition(arr0, 0 , 4, 4);
	System.out.println(findY(arr0, 3)); // finds the third smallest ; should be 3

	int[] arr1 = {2, 5, 4, 6, 1}; // worst situation is when all numbers are in arbitrary places
	partition(arr0, 0, 4, 4);
	System.outprintln(findY(arr1, 3)); // finds the third smallest ; should be 4
	
    }
    
}
