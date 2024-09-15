package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import applianceLoader.ApplianceLoader;
import appliances.Appliance;

public class ApplianceManager {
	
	public List<Appliance> loadedAppliances = new ArrayList<>();
	private Scanner scanner;
	
	public ApplianceManager() {
		this.scanner = new Scanner(System.in);
		loadAppliances();
	}
	
	public void loadAppliances() {
		ApplianceLoader loader = new ApplianceLoader();
		this.loadedAppliances = loader.loadAppliances();
	}
	
	public void displyMenu() {
//		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to modern appliances!");
		System.out.println("How May We Assist You?");
		System.out.println("1 – Check out appliance \r\n"
				+ "2 – Find appliances by brand \r\n"
				+ "3 – Display appliances by type \r\n"
				+ "4 – Produce random appliance list \r\n"
				+ "5 – Save & exit");
		System.out.println("Enter option:");
		int option = scanner.nextInt();
		switch(option) {
		case 1:
			checkoutAppliance();
		}
		
		
	}
	//checkout method
	public void checkoutAppliance() {
//		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the item number of an appliance:");
		String inputItemNumber = scanner.next();
		boolean founded = false;
		for(Appliance appliance: loadedAppliances) {
//			System.out.println(appliance.getItemNumber());
			if(inputItemNumber.equals(appliance.getItemNumber())) {
				 founded = true;
				int quantity = appliance.getQuantity();
				if(quantity > 0) {
					appliance.setQuantity(quantity-1);
					System.out.println("Appliance" + inputItemNumber +"has been checked out." );
				}
				else {
					System.out.println("The appliance is not available to be checked out.");
					
				}
			}
		}
		if(!founded) {
			System.out.println("No appliances found with that item number.");
		}
		
	}
	
	

}
