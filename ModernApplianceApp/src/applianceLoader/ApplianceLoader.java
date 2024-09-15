package applianceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import appliances.Appliance;
import appliances.Refrigerator;
import appliances.Vacuum;
import appliances.Microwave;
import appliances.Dishwasher;

//class to load the list of different appliances
public class ApplianceLoader {
	//we must initialize the list. otherwise it will point to null
		// and null cannot use .add
	public List<Appliance> appliances = new ArrayList<>();
	
	
	
	
	public List<Appliance> loadAppliances(){
	File inputFile = new File("res/appliances.txt");
	Scanner input = null;
	try {
		input = new Scanner(inputFile);
		while(input.hasNext()) {
			String line = input.nextLine();
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
	}finally {
		input.close();
	}
	return appliances;
	}

}
