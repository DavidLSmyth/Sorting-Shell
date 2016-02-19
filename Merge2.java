import java.util.Arrays;
import java.util.Random;
public class Merge2 {
//	static int[] data=new int[100];
//	static{
//		Random r=new Random(50);
//		for(int i=0;i<100;i++){
//			data[i]=r.nextInt()/10000000;
//		}
//		System.out.println(Arrays.toString(data));
//	}
//	public static void main(String[] args){
//		Merge2 m=new Merge2();
//		System.out.println(data);
//		//System.out.println("length"+m.sort(data).length);
//		System.out.println(Arrays.toString(m.sort(data)));
//	}
		public int[] sort(int[] d) {
			// TODO Auto-generated method stub
			//while the list has more than one element, divide
			if(d.length<=1)
				return d;
				//set the midpoint
				int mp=d.length/2;
				//create a left list and a right list either side of the midpoint to be recursively split and then
				//conquered once they are of length one
				int[]ll= Arrays.copyOfRange(d, 0, mp);
				int[]rl= Arrays.copyOfRange(d, mp, d.length);
				ll=sort(ll);
				rl=sort(rl);
				return merge(ll,rl);
			
		}
		public int[] merge(int[] ll,int[] rl){
				//System.out.println(Arrays.toString(ll));
				//System.out.println(Arrays.toString(rl));
				int[] data1=new int[ll.length+rl.length];
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
						data1[k]=ll[i];
						i+=1;
					}
					else{
						data1[k]=rl[j];
						j+=1;
					}
					k+=1;
				}
				
				while(i<ll.length){
					data1[k]=ll[i];
					i+=1;
					k+=1;
				}
				while (j<rl.length){
					data1[k]=rl[j];
					j+=1;
					k+=1;
					
				}
			return data1;
		}

}
