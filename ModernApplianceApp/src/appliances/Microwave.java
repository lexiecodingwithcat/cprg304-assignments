package appliances;

public class Microwave extends Appliance {
	private int capacity;
	private String roomType;
    public Microwave(int itemNumber, String brand, int quantity,int wattage, String color,Double price, int capacity, String roomType) {
	super( itemNumber, brand, quantity,wattage, color,price);
	this.capacity = capacity;
	this.roomType = roomType;
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public String getRoomType() {
	return roomType;
}
public void setRoomType(String roomType) {
	this.roomType = roomType;
}
}
