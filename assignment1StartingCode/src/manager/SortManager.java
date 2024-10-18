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

//	private static Shape[] shapes;
	
 
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
	 				System.out.println("Error: No file name provided after -f");
	 			}
	 		}
	 		if(arg.startsWith("-t")) {
	 			if(arg.length()>2) {
	 			sortType  = arg.substring(2);
	 			}else {
	 				System.out.println("Error: No file name provided after -t");
	 			}
	 		}
	 		if(arg.startsWith("-s")) {
	 			if(arg.length()>2) {
	 			sortAlgorithm = arg.substring(2);
	 			}else {
	 				System.out.println("Error:No sort algorithm provided after -s");
	 			}
	 		}
	 	}
	 	//check invalid sort type
	 	if(!sortType.equals("v") && !sortType.equals("h") && sortType.equals("a")) {
	 		System.out.println("Error: invalid sort type");
	 		printUsage();
	 		return;
	 	}
	 	//check invalid sort algorithm 
	 	if(!sortAlgorithm.equals("b")&& !sortAlgorithm.equals("i")&& !sortAlgorithm.equals("s")&&!sortAlgorithm.equals("q")&&!sortAlgorithm.equals("m")) {
	 		System.out.println("Error: invalid sort algorithm");
	 		printUsage();
	 		return;
	 	}
	 	
	 	Shape[] shapes = loadShapes(fileName);
	 	sortAndBenchMark(shapes, sortType, sortAlgorithm);

	 	
 System.out.println("after sort:");
 for (int j = 0; j < shapes.length; j++) {
	    System.out.println(shapes[j]);
	}
	
 }
 
 
private static Shape[] loadShapes(String fileName) {
	Shape[] shapes = null;
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
			double sideOrRadius = Double.parseDouble(elements[2]);
			shapes[i] = createShape(shapeType, height, sideOrRadius);
		}
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (NumberFormatException e) {
		e.printStackTrace();
	}
	return shapes;

}

//create new shape
private static Shape createShape(String shapeType, double height, double sideOrRadius) {
	switch(shapeType) {
	case "Cone":
		return new Cone(height, sideOrRadius);
	case "Cylinder":
		return new Cylinder(height, sideOrRadius);
	case "Pyramid":
		return new Pyramid(height, sideOrRadius);
	case "SquarePrism":
		return new SquarePrism(height, sideOrRadius);
	case "TriangularPrism":
		return new TriangularPrism(height, sideOrRadius);
	case "PentagonalPrism":
		return new PentagonalPrism(height, sideOrRadius);
	case "OctagonalPrism":
		return new OctagonalPrism(height, sideOrRadius);
		
	}
	return null;		
	
}

//sort the shapes 
private static void sortAndBenchMark(Shape[] shapes, String sortType, String sortAlgorithm) {
	
	Comparator<Shape> comparator = null;
	if(sortType =="h") {
		switch(sortAlgorithm) {
		case "b":
			Sort.bubbleSort(shapes);
			break;
		case "i":
			Sort.insertionSort(shapes);
			break;
		case "s":
			Sort.selectionSort(shapes);
			break;
		case "q":
			Sort.quickSort(shapes, 0, shapes.length-1);
			break;
		case "m":
			Sort.mergeSort(shapes);
			break;
		}
	}else {
		switch(sortType) {
		case "v": 
			 comparator= new VolumeComparator();
			 break;
		case "a":
			comparator = new BaseAreaComparator();
			break;
		}
		switch(sortAlgorithm) {
		case "b":
			Sort.bubbleSort(shapes, comparator);
			break;
		case "i":
			Sort.insertionSort(shapes, comparator);
			break;
		case "s":
			Sort.selectionSort(shapes, comparator);
			break;
		case "q":
			Sort.quickSort(shapes,comparator, 0, shapes.length-1);
			break;
		case "m":
			Sort.mergeSort(shapes,comparator);
			break;
		}
		
	}

}

private static void printUsage() 
{
    System.out.println("Usage:");
    System.out.println("java -jar Sort.jar -f<file_name> -t[v/h/a] -s[b/s/i/m/q/z]");
    System.out.println("Options:");
    System.out.println("-f or -F: specify the file name with path (e.g., -f\"res\\shapes1.txt\")");
    System.out.println("-t or -T: specify 'v' for volume, 'h' for height, or 'a' for base area (e.g., -tH)");
    System.out.println("-s or -S: specify sorting algorithm 'b' (bubble), 's' (selection), 'i' (insertion), 'm' (merge), 'q' (quick), 'z' (custom) (e.g., -sB)");
}



}
