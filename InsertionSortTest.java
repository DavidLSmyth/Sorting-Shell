import static org.junit.Assert.*;

import org.junit.Test;


public class InsertionSortTest {

	@Test
	public void testSort() {
		int[] data1= new int[]{3,4,6,78,65,4,534,545,75,47,54,34,2,25,6,7,5,64,632,2,657,658,687,345348,1};
		int[] data2=new int[]{1};
		int[] data3=new int[]{0,2};
		int[] data4=new int[]{-1};
		int[] data5=new int[]{-5,-6};
		int[] data6=new int[]{0};
		int[] dataverify1=new int[]{1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 25, 34, 47, 54, 64, 65, 75, 78, 534, 545, 632, 657, 658, 687, 345348};
		int[]dataverify5=new int[]{-6,-5};
		//int[][] data7=new int[][]{data1,data2,data3,data4,data5,data6};
		
		InsertionSort i=new InsertionSort();
		assertArrayEquals(i.sort(data1),dataverify1 );
		assertArrayEquals(i.sort(data2),data2);
		assertArrayEquals(i.sort(data3),data3);
		assertArrayEquals(i.sort(data4),data4);
		assertArrayEquals(i.sort(data5),dataverify5);
		assertArrayEquals(i.sort(data6),data6);
		//System.out.println(result,result1,result2,result3,result4,result5);
	}

	@Test
	public void testName() {
		InsertionSort i=new InsertionSort();
		String name="Insertion Sort";
		assertEquals(name,i.name());
	}

	@Test
	public void testNameString() {
		InsertionSort i=new InsertionSort();
		String name="sorter";
		i.name("sorter");
		assertEquals(name,i.name());
	}

}
