package manager;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
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
	 	
	 	String fileName = null;
	 	String sortType = null;
	 	String sortAlgorithm = null;
	 	for(int i=0; i<args.length; i++) {
	 		String arg= args[i].toLowerCase();
	 		if(arg.startsWith("-f")) {
	 			if(arg.length()>2) {
	 			fileName = arg.substring(2);
	 			}else {
	 				System.out.println("No file name provided after -f");
	 			}
	 		}
	 		if(arg.startsWith("-t")) {
	 			if(arg.length()>2) {
	 			sortType  = arg.substring(2);
	 			}else {
	 				System.out.println("No file name provided after -t");
	 			}
	 		}
	 		if(arg.startsWith("-s")) {
	 			if(arg.length()>2) {
	 			sortAlgorithm = arg.substring(2);
	 			}else {
	 				System.out.println("No sort algorithm provided after -s");
	 			}
	 		}
	 	}
	 	
	 	loadShapes(fileName);
	 	Comparator<Shape> comparator = null;
	 	switch(sortType) {
	 	case "v":
	 		comparator= new VolumeComparator();
	 		break;
	 	case "h":
	 		comparator = null;
	 		break;
	 	case "a":
	 		comparator = new BaseAreaComparator();
	 		break;
	 	}
	 	System.err.println(sortAlgorithm);
	 	switch(sortAlgorithm) {
	 	case "b":
	 		if(comparator == null) {
	 			Sort.bubbleSort(shapes);
	 		}else {
	 			Sort.bubbleSort(shapes, comparator);
	 		}
	 		break;
	 	case "s":
	 		if(comparator ==null) {
	 			Sort.selectionSort(shapes);
	 		}else {
	 			Sort.selectionSort(shapes, comparator);
	 		}
	 		break;
	 	case "i":
	 		if(comparator ==null) {
	 			Sort.insertionSort(shapes);
	 		}else {
	 			Sort.insertionSort(shapes, comparator);
	 		}
	 		break;
	 	case "m":
	 		if(comparator ==null) {
	 			Sort.mergeSort(shapes);
	 		}else {
	 			Sort.mergeSort(shapes, comparator);
	 		}
	 		break;
	 	case "q":
	 		if(comparator == null) {
	 			Sort.quickSort(shapes, 0, shapes.length-1);
	 		}else {
	 			Sort.quickSort(shapes, comparator, 0, shapes.length-1);
	 		}
	 		break;
	 	default:
	 		System.out.println("Invalid sorting algorithm. Use 'b', 's', 'i', 'm', or 'q'.");
	 		return;
	 	}
	 	
 System.out.println("after sort:");
 for (int j = 0; j < shapes.length; j++) {
	    System.out.println(shapes[j]);
	}
	
 }
 
 
public static void loadShapes(String fileName) {
	
	File inputFile = new File(fileName);
	try (Scanner sc = new Scanner(inputFile)) {
		if(sc.hasNextLine()) {
		String firstLine = sc.nextLine();
		int size = Integer.parseInt(firstLine.trim());
		shapes= new Shape[size];
		for(int i=0; i<size; i++) {
			String[] elements= sc.nextLine().split(" ");
			String shapeType=elements[0];
			double height = Double.parseDouble(elements[1]);
			switch(shapeType) {
			case "Cone":
				double radiusCone = Double.parseDouble(elements[2]);
				shapes[i]= new Cone(height, radiusCone);
				break;
			case "Cylinder":
				double radiusCy = Double.parseDouble(elements[2]);
				shapes[i]= new Cylinder(height, radiusCy);
				break;
			case "Pyramid":
				double lengthPy =  Double.parseDouble(elements[2]);
				shapes[i]= new Pyramid(height, lengthPy);
				break;
			case "SquarePrism":
				double lengthSq =  Double.parseDouble(elements[2]);
				shapes[i]= new SquarePrism(height, lengthSq);
				break;
			case "TriangularPrism":
				double lengthTr =  Double.parseDouble(elements[2]);
				shapes[i]= new TriangularPrism(height, lengthTr);
				break;
			case "PentagonalPrism":
				double lengthPe =  Double.parseDouble(elements[2]);
				shapes[i]= new PentagonalPrism(height, lengthPe);
				break;
			case "OctagonalPrism":
				double lengthOc =  Double.parseDouble(elements[2]);
				shapes[i]= new OctagonalPrism(height, lengthOc);
				break;
			}		
		}

		}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (NumberFormatException e) {
		
		e.printStackTrace();
	}
	
	

}



}
