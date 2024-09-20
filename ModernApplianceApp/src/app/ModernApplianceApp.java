
package app;

import manager.ApplianceManager;

/**
 * The {@code ModernApplianceApp} class is the entry point for the appliance management
 * application. It initializes an instance of the {@code ApplianceManager} class and
 * displays the application menu to the user.
 * 
 
 * 
 * @author Tianzi Cui
 * @since 2024-09-19
 * 
 * Some part of this documentation was assisted and modified by chatGPT.
 */
public class ModernApplianceApp {


	public static void main(String[] args) {
     ApplianceManager manager = new ApplianceManager();
     manager.displayMenu();
		
		
		
	}

}
