package appliances;
/**
 * The {@code Refrigerator} class represents a specific type of appliance that extends the {@code Appliance} class.
 * It adds additional attributes for number of doors, width and height, providing methods to manipulate and display 
 * those attributes. This class overrides the {@code saveToString} method to format the data for file storage.
 * Also overrides the {@code toString} method to make sure the format when printing out.
 * 
 * @author Tianzi Cui
 * @since 2024-09-19
 */
public class Refrigerator extends Appliance{

	private int numberOfDoors;
	private int width;
	private int height;
	//constructor
	public Refrigerator(String itemNumber, String brand, int quantity, int wattage, String color, Double price, int numberOfDoors, int width, int height) {
		super(itemNumber, brand, quantity, wattage, color, price);
		this.setNumberOfDoors(numberOfDoors);
		this.setWidth(width);
		this.setHeight(height);
	}
	//getter and setter
	public int getNumberOfDoors() {
		return numberOfDoors;
	}
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String saveToString() {
		return String.format(
	            "%s;%s;%d;%d;%s;%.2f;%d;%d;%d",
	            getItemNumber(),
	            getBrand(),
	            getQuantity(),
	            getWattage(),
	            getColor(),
	            getPrice(),
	            getNumberOfDoors(),
	            getWidth(),
	            getHeight()
	            
	        );
	}
	@Override
	public String toString() {
		String information = "ItemNumber:" + " "+ getItemNumber() + "\n"
				+ "Brand:" + " "+ getBrand() +"\n" 
				+ "Quantity:"+ " "+ getQuantity()+ "\n" 
				+ "Wattage:"+ " "+getWattage()+ "\n"
				+ "Color:" + " "+ getColor()+ "\n"
				+"Price:" + " "+ getPrice() + "\n"
				+ "NumberofDoors:"+ " " + numberOfDoors + "\n"
				+ "Width:" + " "+ width + "\n"
				+"Height:" + " "+height + "\n";
		
		return information ;
	}
	
}
