//Alvin Ye
//APCS2 pd8
//HW51--Heaping Piles of Sordidness
//2018-05-19

public class HeapSort{

	int[] _array;

	public HeapSort(int[] arr){
		_array = arr;
	}

	public void swap(int x, int y){
		int temp = _array[x];

		_array[x] = _array[y];
		_array[y] = temp;
	}

	public void hSortMin(){
		//index i is used to iterate from left to right of array
		//index j is used to represent partition btwn sorted and unsorted array
		for(int i = 0; i < _array.length - 1; i++){
			int j = i + 1;

			int temp = j;
			while(_array[temp] < _array[(temp-1)/2] && temp >= 0 && temp < _array.length){
				swap(temp, (temp-1)/2);
				temp = (temp - 1)/2;
			}
		}
	}//end

	public void hSortMax(){
		for(int i = 0; i < _array.length - 1; i++){
			int j = i + 1;

			int temp = j;
			while(_array[temp] > _array[(temp-1)/2] && temp >= 0 && temp < _array.length){
				swap(temp, (temp-1)/2);
				temp = (temp - 1)/2;
			}
		}
	}//end

	public String toString(){
		String retVal = "[";

		for(int i: _array){
			retVal += i + ",";
		}

		return retVal.substring(0, retVal.length() - 1) + "]";
	}

	public static void main(String[] args){
		int[] a0 = {7,1,5,12,3};
		int[] a1 = {66,52,101,3,12,7,9};
		int[] a2 = {1,2};

		HeapSort h = new HeapSort(a0);
		System.out.println("Original: " + h);
		h.hSortMin();
		System.out.println("MinSorted: " + h);
		h.hSortMax();
		System.out.println("MaxSorted: " + h);
		System.out.println();

		HeapSort k = new HeapSort(a1);
		System.out.println("Original: " + k);
		k.hSortMin();
		System.out.println("MinSorted: " + k);
		k.hSortMax();
		System.out.println("MaxSorted: " + k);
		System.out.println();

		HeapSort q = new HeapSort(a2);
		System.out.println("Original: " + q);
		q.hSortMin();
		System.out.println("MinSorted: " + q);
		q.hSortMax();
		System.out.println("MaxSorted: " + q);

	}
}