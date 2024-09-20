package appliances;

public class Microwave extends Appliance {
	private Double capacity;
	private char roomType;
	
    public Microwave(String itemNumber, String brand, int quantity,int wattage, String color,Double price, Double capacity, char roomType) {
	super( itemNumber, brand, quantity,wattage, color,price);
	this.capacity = capacity;
	this.roomType = roomType;
}
public Double getCapacity() {
	return capacity;
}
public void setCapacity(Double capacity) {
	this.capacity = capacity;
}
public char getRoomType() {
	return roomType;
}
public void setRoomType(char roomType) {
	this.roomType = roomType;
}

@Override
public String saveToString() {
		return String.format(
	            "%s;%s;%d;%d;%s;%.2f;%.1f;%c",
	            getItemNumber(),
	            getBrand(),
	            getQuantity(),
	            getWattage(),
	            getColor(),
	            getPrice(),
	            getCapacity(),
	            getRoomType()
	        );
	}

@Override
public String toString() {
	String information = "ItemNumber:" + " "+ getItemNumber() + "\n"
	+ "Brand:" + " "+ getBrand() +"\n" 
	+ "Quantity:"+ " "+ getQuantity()+ "\n" 
	+ "Wattage:"+ " "+getWattage()+ "\n"
	+ "Color:"+ " " + getColor()+ "\n"
	+"Price:" + " "+ getPrice() + "\n"
	+ "Capacity:"+ " "+ capacity + "\n"
	+"RoomType:"+ " " + roomType + "\n";
	return information ;
}
}
