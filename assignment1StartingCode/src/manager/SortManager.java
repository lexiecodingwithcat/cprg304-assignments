package manager;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import utilities.BaseAreaComparator;
import utilities.Sort;
import utilities.VolumeComparator;

public class SortManager {

	private static Shape[] shapes;
	
 public SortManager(String[] args) {
	 	shapes = loadShapes();
	 	BaseAreaComparator base = new BaseAreaComparator();
	 	VolumeComparator vm = new VolumeComparator();
	 	//bubble sort
	 	Sort.bubbleSort(shapes);
//	 	Sort.bubbleSort(shapeArr, base);
//	 	Sort.bubbleSort(shapeArr, vm);
	 	
	 	//insertion sort
//	 	Sort.insertionSort(shapeArr);
//	 	Sort.insertionSort(shapeArr, base);
//	 	Sort.insertionSort(shapeArr, vm);
	 	
	 	//selection sort
//	 	Sort.selectionSort(shapeArr);
//	 	Sort.selectionSort(shapeArr, base);
//	 	Sort.selectionSort(shapeArr, vm);
	 	
	 	//merge sort
//	 	Sort.mergeSort(shapeArr);
//	 	Sort.mergeSort(shapeArr, base);
//	 	Sort.mergeSort(shapeArr, vm);
	 	
	 	//quick Sort
//	 	Sort.quickSort(shapeArr, 0, shapeArr.length-1);
//	 	Sort.quickSort(shapeArr, base, 0, shapeArr.length-1);
//	 	Sort.quickSort(shapeArr, vm, 0, shapeArr.length-1);
	 	
	 	
 
 for (int j = 0; j < shapes.length; j++) {
	    System.out.println(shapes[j]);
	}
	
 }
 
 
public static Shape[] loadShapes() {
	Shape[] shapeArr = null;
	File inputFile = new File("res/shapes1.txt");
	try (Scanner sc = new Scanner(inputFile)) {
		if(sc.hasNextLine()) {
		String firstLine = sc.nextLine();
		int size = Integer.parseInt(firstLine.trim());
		shapeArr= new Shape[size];
		for(int i=0; i<size; i++) {
			String[] elements= sc.nextLine().split(" ");
			String shapeType=elements[0];
			double height = Double.parseDouble(elements[1]);
			switch(shapeType) {
			case "Cone":
				double radiusCone = Double.parseDouble(elements[2]);
				shapeArr[i]= new Cone(height, radiusCone);
				break;
			case "Cylinder":
				double radiusCy = Double.parseDouble(elements[2]);
				shapeArr[i]= new Cylinder(height, radiusCy);
				break;
			case "Pyramid":
				double lengthPy =  Double.parseDouble(elements[2]);
				shapeArr[i]= new Pyramid(height, lengthPy);
				break;
			case "SquarePrism":
				double lengthSq =  Double.parseDouble(elements[2]);
				shapeArr[i]= new SquarePrism(height, lengthSq);
				break;
			case "TriangularPrism":
				double lengthTr =  Double.parseDouble(elements[2]);
				shapeArr[i]= new TriangularPrism(height, lengthTr);
				break;
			case "PentagonalPrism":
				double lengthPe =  Double.parseDouble(elements[2]);
				shapeArr[i]= new PentagonalPrism(height, lengthPe);
				break;
			case "OctagonalPrism":
				double lengthOc =  Double.parseDouble(elements[2]);
				shapeArr[i]= new OctagonalPrism(height, lengthOc);
				break;
			}		
		}

		}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (NumberFormatException e) {
		
		e.printStackTrace();
	}
	
	return shapeArr;

}



}
