
public class InsertionSort implements SortingAlgorithms{
	String name="InsertionSort";
	@Override
	public int[] sort(int[] data) {
		// TODO Auto-generated method stub
		//loop over the data values
		for(int n=0;n<data.length;n++){
			//begin with a sorted list of length one
			//choose the nth data point which is unsorted
			int value=data[n];
			//set the value of position
			int position=n;
			while(position>0 && data[position-1]>value){
				//shift elements to the right if they are greater than the value that needs to be inserted 
				data[position]=data[position-1];
				position--;
			}
			//Insert the value at its determined position
			data[position]=value;
		}
		return data;
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
