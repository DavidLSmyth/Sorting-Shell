
public class Heap implements SortingAlgorithms {
	String name="Heap";
	private static int X;
	@Override
	public int[] sort(int[] data) {
	        //build a heap from the data list with the maxheap function
	        buildMaxHeap(data);    
	        //swap the 
	        for (int i = X; i > 0; i--){
	            int tmp = data[0];
		        data[0] = data[i];
		        data[i] = tmp;
	            X --;
	            maxheap(data, 0);
	        }
			return data;
	    }     
	    //buildMaxHeap builds the heap  
	    public static void buildMaxHeap(int array[]){
	    	//set x as the position of the final element
	        X= array.length-1;
	        for (int i = X/2; i >= 0; i--)
	            maxheap(array, i);        
	    }
	    //maxheap swaps the largest element in the heap      
	    public static void maxheap(int array[], int i)
	    { 
	        int left = 2*i ;
	        int right = 2*i + 1;
	        int max = i;
	        if (left <= X && array[left] > array[i])
	            max = left;
	        if (right <= X && array[right] > array[max])        
	            max = right;
	 
	        if (max != i)
	        {
	            //swap(array, i, max);
	            int tmp = array[i];
		        array[i] = array[max];
		        array[max] = tmp;
	            maxheap(array, max);
	        }
	    }    
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void name(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

}
