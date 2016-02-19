public class Quick implements SortingAlgorithms {
	private String name="Quick";
	//@Override
	private void quicksort(int data[], int lo, int hi) {
        //data is sorted when the lo value overtakes the hi value
        if (lo >= hi) {
            return;
        }
        int pivot = data[lo];
        int i = lo - 1;
        int wall = hi + 1;
        //divide the list into two sublist, one with values less than the pivot
        //and one with values greater than the pivot
        while (i < wall) {
            // Keep increasing if the values are less than the pivot
            i++;
            while (data[i] < pivot){
            	i++; 
            }
            // Keep decreasing if the values are greater than the pivot
            wall--;
            while (data[wall] > pivot) { 
            	wall--; 
            }
            // swap the pivot with the value that was out of place
            if (i < wall) {
            	int temp = data[i];
                data[i] = data[wall];
                data[wall] = temp;
            }
        }
        
        // Use recursion to sort the values less than the pivot and greater than the pivot
        quicksort(data, lo, wall);
        quicksort(data, wall + 1, hi);
    }
	public int[] sort(int[] data) {
		quicksort(data,0,data.length-1);
		return data;
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void name(String name) {
		this.name=name;
		
	}

}