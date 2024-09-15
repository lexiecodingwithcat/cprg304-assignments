
import java.util.Scanner;

public class ModernApplianceApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
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
			//check out 
			int checkOutNumber = scanner.nextInt();
			//based on the start of checknumber, call the relevant method 
			System.out.println(checkOutNumber);
			break;
		}
		
		scanner.close();
		
	}

}
