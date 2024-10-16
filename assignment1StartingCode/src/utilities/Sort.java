package utilities;


import java.util.Comparator;

import shapes.Shape;

/**
 * 
 */
public class Sort {
	
	private static <T> void swap(T[] array, int index1, int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2]= temp;
		
	}
	//bubble sort

	public static <T extends Comparable<? super T>>void bubbleSort(T[] array) {
		//iterate all elements in the array
		for(int outer = 0; outer<array.length-1; outer++) {
			//compare adjacent elements 
			for(int inner = 0; inner<array.length-1-outer; inner++) {
				if((array[inner].compareTo(array[inner+1])<0)) {
					swap(array, inner, inner+1);
					
				}
			}
		}
		
	}
	
	public static <T extends Comparable<? super T>> void bubbleSort(T[] array,Comparator<? super T> comparator) {
		for(int outer = 0; outer<array.length-1; outer++) {
			//compare adjacent elements 
			for(int inner = 0; inner<array.length-1-outer; inner++) {
				if(comparator.compare(array[inner], array[inner+1])<0) {
					swap(array, inner, inner+1);
					
				}
			}
		}
		
	}
	
//insertion sort
	public static <T extends Comparable<? super T>>void insertionSort(T[] array) {
		for(int i = 1; i<array.length; i ++) {
			T key = array[i];
			int j = i-1;
			while(j>=0 && key.compareTo(array[j])>0) {
				//move elements that are smaller than key to right 
				swap(array, j, j+1);
				j--;
			}
			//insert the key
			array[j+1]= key;
		}	
	}
	public static <T extends Comparable<? super T>> void insertionSort(T[] array,Comparator<? super T> comparator) {
		for(int i = 1; i<array.length; i ++) {
			T key = array[i];
			int j = i-1;
			while(j>=0 && (comparator.compare(key, array[j]))>0) {
				//move elements that are smaller than key to right 
				swap(array, j, j+1);
				j--;
			}
			//insert the key
			array[j+1]= key;
		}	
	}
	
	//selection sort
	public static <T extends Comparable<? super T>>void selectionSort(T[] array){
		for(int i = 0; i<array.length; i++) {
//			assume the first one is the largest element
			int maxIndex = i;
			//find the largest element in unordered sub-array
			for(int j = i+1; j<array.length; j++) {
				if(array[maxIndex].compareTo(array[j])<0) {
					 maxIndex=j;
				}
			}
			swap(array, i, maxIndex);
		}
		
	}
	
	public static <T extends Comparable<? super T>> void selectionSort(T[] array,Comparator<? super T> comparator) {
		for(int i = 0; i<array.length; i++) {
			//assume the first one is the largest element
			int maxIndex = i;
			//find the largest element in unordered sub-array
			for(int j = i+1; j<array.length; j++) {
				if(comparator.compare(array[maxIndex], array[j])<0) {
					 maxIndex=j;
				}
			}
			swap(array, i, maxIndex);
		}
	}
	
	
	
//	Merge Sort
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void mergeComparable(Comparable[]array,Comparable[]leftHalf, Comparable[]rightHalf) {
		int leftLength = leftHalf.length;
		int rightLength = rightHalf.length;
		
		int left = 0;
		int right = 0;
		int arr = 0;
		while(left<leftLength && right<rightLength) {
			if((leftHalf[left]).compareTo(rightHalf[right])>=0) {
				array[arr]=leftHalf[left];
				left++;
			}else {
				array[arr]=rightHalf[right];
				right++;
			}
			arr++;
		}
		//clean up remaining elements in right/left half
		while(left<leftLength) {
			array[arr]=leftHalf[left];
			left++;
			arr++;
		}
		while(right<rightLength) {
			array[arr]=rightHalf[right];
			right++;
			arr++;	
		}
	}
	
	@SuppressWarnings({ "rawtypes" })
	public static void mergeSort(Comparable[] array){
		//divide arrays into parts array
		int length = array.length;
	
		if(length <2) {
			return;
		}
		int midIndex = length/2;
		//create sub array
		Comparable[] leftHalf = new Comparable[midIndex];
		Comparable[] rightHalf = new Comparable[length-midIndex];
		//put elements in array into sub arrays
		for(int i = 0; i<midIndex;i++) {
			leftHalf[i] = array[i];
		}
		for(int i = midIndex; i<length; i++) {
			rightHalf[i-midIndex]= array[i];
		}
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		mergeComparable(array, leftHalf, rightHalf);

	}
	
	//comparator
	@SuppressWarnings("rawtypes")
	private static void mergeComparator( Shape[]array,Comparator<Shape> comparator, Shape[] leftHalf, Shape[] rightHalf) {
		int leftLength = leftHalf.length;
		int rightLength = rightHalf.length;
		
		int left = 0;
		int right = 0;
		int arr = 0;
		while(left<leftLength && right<rightLength) {
			if(comparator.compare(leftHalf[left],rightHalf[right])>=0) {
				array[arr]=leftHalf[left];
				left++;
			}else {
				array[arr]=rightHalf[right];
				right++;
			}
			arr++;
		}
		//clean up remaining elements in right/left half
		while(left<leftLength) {
			array[arr]=leftHalf[left];
			left++;
			arr++;
		}
		while(right<rightLength) {
			array[arr]=rightHalf[right];
			right++;
			arr++;	
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void mergeSort(Shape[] array, Comparator<Shape> comparator){
		//divide arrays into parts array
		int length = array.length;
	
		if(length <2) {
			return;
		}
		int midIndex = length/2;
		//create sub array
		Shape[] leftHalf = new Shape[midIndex];
		Shape[] rightHalf = new Shape[length-midIndex];
		//put elements in array into sub arrays
		for(int i = 0; i<midIndex;i++) {
			leftHalf[i] = array[i];
		}
		for(int i = midIndex; i<length; i++) {
			rightHalf[i-midIndex]= array[i];
		}
		mergeSort(leftHalf, comparator);
		mergeSort(rightHalf, comparator);
		mergeComparator(array, comparator, leftHalf, rightHalf);

	}
	
	
	
	//Quick Sort
	public static <T extends Comparable<? super T>>void quickSort(T[] array, int low, int high){
		 if (low >= high) {
		        return;
		    }
		T pivot = array[high];
		int leftPointer = low;
		int rightPointer = high;
		while(leftPointer<rightPointer) {
			while(leftPointer<rightPointer && (array[leftPointer].compareTo(pivot)>=0)) {
				leftPointer++;
			}
			while(leftPointer<rightPointer && (array[rightPointer].compareTo(pivot))<=0 ) {
				rightPointer--;
			}
			
			swap(array, leftPointer, rightPointer);
		}
		swap(array, leftPointer,high);
		quickSort(array, low, leftPointer-1);
		quickSort(array, leftPointer+1,high );
		
	}
	
	
	
	
public static <T extends Comparable<? super T>> void quickSort(T[] array,Comparator<? super T> comparator, int low, int high) {
	
	if (low >= high) {
	        return;
	    }
	T pivot = array[high];
	int leftPointer = low;
	int rightPointer = high;
	while(leftPointer < rightPointer) {
		while(leftPointer < rightPointer && (comparator.compare(array[leftPointer], pivot)>= 0)) {
			leftPointer++;
		}
		while(leftPointer < rightPointer && (comparator.compare(array[rightPointer], pivot)<= 0) ) {
			rightPointer--;
		}
		if (leftPointer < rightPointer) {
		swap(array, leftPointer, rightPointer);
		}
	}
	swap(array, leftPointer, high);
	quickSort(array, comparator, low, leftPointer-1);
	quickSort(array, comparator, leftPointer+1, high );
	
	}

//heap sort

}


