package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import applianceLoader.ApplianceLoader;
import appliances.Appliance;
import appliances.Dishwasher;
import appliances.Microwave;
import appliances.Refrigerator;
import appliances.Vacuum;
/**
 * The {@code ApplianceManager} class is responsible for managing a collection of appliances,
 * including displaying a user menu, and processing user requests to check out appliances, find appliances by brand, display appliances by type,
 * and produce a random list of appliances.
 * 
 * <p>This class utilizes an {@code ApplianceLoader} to load and save appliance data.</p>
 * 
 * @author Tianzi Cui
 * @since 2024-09-19
 */
public class ApplianceManager {
	
	public  List<Appliance> loadedAppliances = new ArrayList<>();
	public ApplianceLoader loader = new ApplianceLoader();
	private Scanner scanner;
	private boolean keepShowingMenu = true;
	private int applianceLength;
/**
* Constructs a new {@code ApplianceManager} instance, initializing the scanner
* and loading appliances from the file.
* */
	public ApplianceManager() {
		this.scanner = new Scanner(System.in);
		loadAppliances();
	}
	
/**
* Loads appliances from the file using the {@code ApplianceLoader}.
*/
public void loadAppliances() {
		
		loadedAppliances = loader.loadAppliances();
		applianceLength = loadedAppliances.size();
	}
/**
 * Displays the main menu and processes user input to perform different actions based on it.
 */
public void displayMenu() {
		while(keepShowingMenu) {
		System.out.println("\n");
		System.out.println("Welcome to modern appliances!");
		System.out.println("How May We Assist You?");
		System.out.println("1 – Check out appliance \n"
				+ "2 – Find appliances by brand \n"
				+ "3 – Display appliances by type \n"
				+ "4 – Produce random appliance list \n"
				+ "5 – Save & exit");
		System.out.println("Enter option:");
		int option = scanner.nextInt();
		switch(option) {
		case 1:
			checkoutAppliance();
			break;
		case 2:
			findApplianceByBrand();
			break;
		case 3:
			displayApplianceByType();
			break;
		case 4:
			randomApplianceList();
			break;
		case 5:
			saveAndExit();
			break;
		}
		
		}
	}


/**
 * Checks out an appliance based on the user's input item number.
 */
	public void checkoutAppliance() {
		System.out.println("Enter the item number of an appliance:");
		String inputItemNumber = scanner.next();
		boolean founded = false;
		for(Appliance appliance: loadedAppliances) {
			if(inputItemNumber.equals(appliance.getItemNumber())) {
				 founded = true;
				int quantity = appliance.getQuantity();
				if(quantity > 0) {
					appliance.setQuantity(quantity-1);
					System.out.println("Appliance " + "\""+ inputItemNumber+"\"" +" has been checked out." );
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
	
	/**
     * Finds and displays appliances based on brand.
     */
	public void findApplianceByBrand() {
		System.out.println("Enter brand to search for:" );
		boolean found = false;
		String inputBrand = scanner.next();
		System.out.println("\nMatching Appliances: ");
		for(Appliance appliance : loadedAppliances) {
			if(inputBrand.equalsIgnoreCase(appliance.getBrand())) {
				found = true;
				System.out.println(appliance.toString());
			}
		}
		if(!found) {
			System.out.println("No appliance found with brand" + " "+ inputBrand);
		}
		
	}
	
/**
* Displays appliances based on their type, allowing the user to specify additional filters based on the appliance's attributes.
*/
	public void displayApplianceByType() {
		System.out.println("Appliance Types \n"
				+ "1 – Refrigerators \n"
				+ "2 – Vacuums \n"
				+ "3 – Microwaves \n"
				+ "4 – Dishwashers \n"
				+ "\n"
				+ "Enter type of appliance: ");
		char inputType = scanner.next().charAt(0);
		switch(inputType) {
		case '1':
			System.out.println("Enter number of doors: 2 (double door), 3 (three doors) or 4 (four doors):");
			int inputNumOfDoors = scanner.nextInt();
			boolean foundMatchingFrige = false;
			for(Appliance appliance: loadedAppliances) {
				//find frige
				if(appliance instanceof Refrigerator) {
					//change current appliance instance to the frige 
					Refrigerator refrigerator = (Refrigerator) appliance;
					if(inputNumOfDoors == refrigerator.getNumberOfDoors()) {
						if(!foundMatchingFrige) {
							System.out.println("\nMatching refrigerators:\n");
							foundMatchingFrige = true;
						}
						
						System.out.println(refrigerator.toString());
					}
				}
			}
			break;
		case '2':
			System.out.println("Enter battery voltage value. 18 V (low) or 24 V (high) ");
			int inputBatteryVoltage = scanner.nextInt();
			boolean foundMatchingVacuum = false;
			for(Appliance appliance: loadedAppliances) {
				//find vacuum
				if(appliance instanceof Vacuum) {
					Vacuum vacuum = (Vacuum) appliance;
					if(inputBatteryVoltage == vacuum.getBatteryVoltage()) {
						
						if(!foundMatchingVacuum) {
							System.out.println("\nMatching vacuums:\n");
							foundMatchingVacuum = true;
						}
						
						System.out.println(vacuum.toString());
					}
				}
			}
			break;
		case '3':
			System.out.println("Room where the microwave will be installed: K (kitchen) or W (work site):");
			char inputRoomType = scanner.next().charAt(0);
			boolean foundMatchingMicro = false;
			for(Appliance appliance: loadedAppliances) {
				if(appliance instanceof Microwave) {
					Microwave microwave = (Microwave) appliance;
					if(Character.toUpperCase(inputRoomType)==(microwave.getRoomType())
							) {
						if(!foundMatchingMicro) {
							System.out.println("\nMatching microwaves:\n");
							foundMatchingMicro = true;
						}
	
						System.out.println(microwave.toString());
					}
				}
			}
			break;
		case '4':
			System.out.println("Enter the sound rating of the dishwasher: Qt (Quietest), Qr (Quieter), Qu(Quiet) or M (Moderate): ");
			String inputSoundRating = scanner.next();
			boolean foundMatchingDishwasher = false;
			for(Appliance appliance: loadedAppliances) {
				if(appliance instanceof Dishwasher) {
					Dishwasher dishwasher = (Dishwasher) appliance;
					if(inputSoundRating.equalsIgnoreCase(dishwasher.getSoundRating()) ) {
						if(!foundMatchingDishwasher) {
							System.out.println("\nMatching dishwashers:\n");
							foundMatchingDishwasher = true;
						}
						
						System.out.println(dishwasher.toString());
					}
				}
			}
			break;	
	}
}
	
/**
* Produces and displays a random list of appliances based on user input.
*/
	public void randomApplianceList() {
		System.out.println("Enter number of appliances: ");
		int inputNumber = scanner.nextInt();
		if(inputNumber > applianceLength) {
			System.out.println(applianceLength);
			System.out.println("Sorry. We only have"+" " + applianceLength + " "+"appliances");
		}else {
			System.out.println("\nRandom appliances:\n");
		Random random = new Random();
		//array list to store the number
		for(int i = 0 ;i< inputNumber; i++ ) {
			int randomNumber = random.nextInt(applianceLength + 1);
			Appliance app = loadedAppliances.get(randomNumber);
			System.out.println(app.toString());		
		}}
	}
	

/**
* Saves the current list of appliances and exits the application.
*/
	public void saveAndExit() {
		//write back the list to file
		loader.saveList(loadedAppliances);
		keepShowingMenu = false;
		System.out.println("Thank you for using Modern Appliances!");	
	}

}
