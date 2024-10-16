package exercise3;


import java.util.Arrays;
import java.util.Random;

public class Driver
{

	public static final int SIZE = 100;
	public static final int UPPER_BOUND = 1000;

	public static void main( String[] args )
	{

		Integer[] nums = new Integer[SIZE];
		Random rand = new Random();

		System.out.println("before:");
		for( int i = 0; i < SIZE; i++ )
		{
			nums[i] = rand.nextInt( UPPER_BOUND );
			
		}
		System.out.println(Arrays.toString(nums));
		
		if(args.length > 0 && args[0].charAt(0) == 'q') {
		quickSort(nums, 0, SIZE-1);
		System.out.println("after:");
		System.out.println(Arrays.toString(nums));
		}else if(args.length > 0 && (args[0].charAt(0) == 's'|| args[0].charAt(0) == 'b'|| args[0].charAt(0) == 'i')) {
			System.out.println("please use q for quicksort");
		}
		

	}
	
//reference: https://www.youtube.com/watch?v=h8eyY7dIiN4
//@author: Coding with John
	
	public static void quickSort(Integer[] nums, int lowIndex, int highIndex) {
		if(lowIndex >= highIndex) {
			return;
		}
		
		int pivot =nums[highIndex];
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		while (leftPointer < rightPointer) {
			while(nums[leftPointer]<= pivot && leftPointer < rightPointer ) {
				//keep increasing the left pointer until it equals to the right pointer
				//OR it is greater than pivot
				leftPointer++;
			}
			while(nums[rightPointer] >= pivot && rightPointer > leftPointer) {
				rightPointer--;
			}
			swap(nums, leftPointer, rightPointer);
		}
			
		//when the left pointer and right pointer are equal
		swap(nums, leftPointer, highIndex);
		
		//sort the left partition
		quickSort(nums, lowIndex, leftPointer-1);
		//sort the right partition
		quickSort(nums, leftPointer+1,highIndex);
		
		
	}
	
	private static void swap(Integer[] nums, int index1, int index2) {
		int temp;
		temp = nums[index2];
		nums[index2]= nums[index1];
		nums[index1] = temp;
	}
	

}
