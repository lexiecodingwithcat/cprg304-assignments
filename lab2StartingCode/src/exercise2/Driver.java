package exercise2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Driver
{

	public static final int SIZE = 100;
	public static final int UPPER_BOUND = 10;

	public static void main( String[] args )
	{

		Integer[] nums = new Integer[SIZE];
		Random rand = new Random();
		int randnum = rand.nextInt( UPPER_BOUND );
		nums[0] = randnum;
		
		for( int i = 1; i < SIZE; i++ )
		{
			randnum = rand.nextInt( UPPER_BOUND );
			nums[i] = nums[i - 1] + randnum;
			
			}
		System.out.println(Arrays.toString(nums));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter an integer:");
		int target = sc.nextInt();
		sc.close();
		int indexVal = binarySearch(nums, target);
		System.out.println("The index of it is:"+indexVal);
		
	}
	
	public static int binarySearch(Integer[] nums, int target ) {
	
		//the left pointer
		int left = 0;
		//the right pointer
		int right = nums.length-1;
		int middle;
		
		
		while(left <= right) {
			middle = left + (right-left)/2;
			if(target == nums[middle]) {
				return middle;
			}else if(target > nums[middle]) {
				left = middle+1;
			}else {
				right = middle -1;
			}
		}
		
		return -1;
		
	}

}
