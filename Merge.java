import java.util.Arrays;

public class Merge implements SortingAlgorithms{
	String name="Merge";
	@Override
	public int[] sort(int[] data) {
		// TODO Auto-generated method stub
		//while the list has more than one element, divide
		if(data.length>1){
			//set the midpoint
			int mp=data.length/2;
			//create a left list and a right list either side of the midpoint to be recursively split and then
			//conquered once they are of length one
			int[]ll= Arrays.copyOfRange(data, 0, mp);
			int[]rl= Arrays.copyOfRange(data, mp, data.length);
			sort(ll);
			sort(rl);
			//initialise the counter variables
			int i=0;
			int j=0;
			int k=0;
			//i holds the position for the right list, j for the left list
			//use a while loop to check that elements are still left in each list
			//k holds the position of the conquered array
			while(i<ll.length && j<rl.length){
				//conquer array by adding the smallest element from the leftlist or rightlist until 
				//one of the lists is empty, in which case add the rest of the elements of the non empty list
				if (ll[i]<=rl[j]){
					data[k]=ll[i];
					i+=1;
				}
				else{
					data[k]=rl[j];
					j+=1;
				}
				k+=1;
			}
			
			while(i<ll.length){
				data[k]=ll[i];
				i+=1;
				k+=1;
			}
			while (j<rl.length){
				data[k]=rl[j];
				j+=1;
				k+=1;
				
			}
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
