package appliances;

public class Refrigerator extends Appliance{

	private int numberOfDoors;
	private int width;
	private int height;
	//constructor
	public Refrigerator(int itemNumber, String brand, int quantity, int wattage, String color, Double price, int numberOfDoors, int width, int height) {
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
}
