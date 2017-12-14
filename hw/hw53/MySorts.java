// Team Kappa (Woosuk Lee and Derek Song)
// APCS1 - pd1
// HW#54 - One File to Bring Them All
// 2017 - 12 - 13

public class MySorts{
    public static void bubbleSort( ArrayList<Comparable> data )
    {
	Comparable temp;
	for(int i = 0; i < data.size() - 1; i++){ //loop one less than the length of the array times
	    for(int j = data.size()-1; j > i ; j--){ 
		if(data.get(j).compareTo(data.get(j-1)) < 0){ //compare two adjacent numbers
		    temp = data.get(j);
		    data.set(j,data.get(j-1));
		    data.set(j-1,temp);
		    //switch the two numbers when necessary
		}
	    }
	}
    }//end bubbleSort
    
    public static void selectionSort( ArrayList<Comparable> data ) 
  {
    /* YOUR IMPLEMENTATION HERE */
      int min; //set a variable that stores the index the minimum value which will be switched with the current item in the index
      for(int i = 0; i < data.size() - 1; i++){
          min = i; //set min equal to the value of i
          for(int j = i; j < data.size(); j++){
              //each successive pass can just start from the index that is one greater than the previous one
              if(data.get(min).compareTo(data.get(j)) > 0){
                  //if the value at index min is greater than that in index j, replace it.
                  min = j;
              }
          }
          data.set(i,data.set(min,data.get(i))); //change the values after the loop
      }      
  }//end selectionSortV
    

    public static void insertionSort( ArrayList<Comparable> data )
  {
    /* YOUR IMPLEMENTATION HERE */
    int inspect; //set a variable "inspect" that basically keeps track of the partition between the "sorted" area and the "non-sorted" area
    for(int i = 1; i < data.size() ; i++){
        inspect = i; //set inspect to equal i in each successive loop
        while(data.get(inspect-1).compareTo(data.get(inspect)) > 0){
            data.set(inspect,data.set(inspect-1,data.get(inspect))); //keep shifting the data over one if it is smaller than the element in the index right before it
            inspect--; //decrement inspect
            if(inspect == 0) break; //if inspect is 0, break the loop in order to prevent ArrayIndexOutOfBoundsException
        }
    }
  }//end insertionSortV

}
