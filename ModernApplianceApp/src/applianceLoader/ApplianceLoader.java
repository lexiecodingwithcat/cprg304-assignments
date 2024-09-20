package applianceLoader;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import appliances.Appliance;
import appliances.Refrigerator;
import appliances.Vacuum;
import appliances.Microwave;
import appliances.Dishwasher;

/** 
 * The {@code ApplianceLoader} class is responsible for loading and saving a list of {@code Appliance}
 * objects from/to a text file.
 * @author Tianzi Cui
 * @since 2024-09-19
 */
public class ApplianceLoader {
	
	/** A list to store all loaded appliance
	 * It is initialized as an empty list to avoid null pointer exceptions.
	 */
	public List<Appliance> appliances = new ArrayList<>();
	
	/** 
     * Loads appliances from the file "res/appliances.txt".
     * <p>
     * This method reads each line from the file, splits it based on the semicolon (";")
     * delimiter, and converts the data into corresponding {@code Appliance} objects. 
     * The first character of the item number determines the type of the appliance.
     * </p>
     * 
     * @return a list of {@code Appliance} objects loaded from the file
     * 
     * @throws FileNotFoundException if the specified file does not exist
     * @throws NumberFormatException if there is an error in parsing numerical data (e.g. integers, doubles)
     */ 
	public List<Appliance> loadAppliances(){
	File inputFile = new File("res/appliances.txt");
	Scanner input = null;
	try {
		input = new Scanner(inputFile);
		while(input.hasNext()) {
			String line = input.nextLine();
			line = line.trim();
			String[] elements = line.split(";");
			String itemNumber = elements[0];
			String brand = elements[1];
			int quantity = Integer.parseInt(elements[2]);
			int wattage = Integer.parseInt(elements[3]);
			String color = elements[4];
			Double price = Double.parseDouble(elements[5]);
			char firstDigit = itemNumber.charAt(0);
			//add different type appliances based on the first digit
			switch(firstDigit) {
			case '1':
				int numOfDoors = Integer.parseInt(elements[6]);
				int width = Integer.parseInt(elements[7]);
				int height = Integer.parseInt(elements[8]);
		
				Refrigerator fridge = new Refrigerator(itemNumber, brand, quantity, wattage, color, price,numOfDoors, width, height);
			    appliances.add(fridge);
			    break;
			case '2':
				String grade = elements[6];
				int batteryVoltage = Integer.parseInt(elements[7]);
				
				Vacuum vacuum = new Vacuum(itemNumber, brand, quantity, wattage, color, price,grade, batteryVoltage);
				appliances.add(vacuum);
				break;
			case '3':
				Double capacity = Double.parseDouble(elements[6]);
				char roomType = elements[7].charAt(0);
				Microwave microwave = new Microwave(itemNumber, brand, quantity, wattage, color, price,capacity, roomType);
			    appliances.add(microwave);
			    break;
			case '4':
			case'5':
				String feature = elements[6];
				String soundRating = elements[7];
				Dishwasher dishwasher = new Dishwasher(itemNumber, brand, quantity, wattage, color, price, feature, soundRating);
				appliances.add(dishwasher);
				break;
			}
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (NumberFormatException e) {
	        System.err.println("Number format error: " + e.getMessage());
	    
	}finally {
		input.close();
	}
	return appliances;
	}
	
	 /**
     * Saves a list of {@code Appliance} objects to the file "res/appliances.txt".
     * <p>
     * Each appliance is converted to a formatted string using its {@code saveToString()} 
     * method, and written to the file with each appliance on a new line.
     * </p>
     * 
     * @param edittedAppliances the list of appliances to save to the file
     * 
     * @throws IOException if an I/O error occurs during writing
     */
	
	public void saveList(List<Appliance> edittedAppliances) {
	try (FileWriter fileWriter = new FileWriter("res/appliances.txt");
			BufferedWriter bfWriter = new BufferedWriter(fileWriter)) {
		for(Appliance appliance: edittedAppliances) {
			bfWriter.write(appliance.saveToString());
			bfWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {}
	}
	
	

}
