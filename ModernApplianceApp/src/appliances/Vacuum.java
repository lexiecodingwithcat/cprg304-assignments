package appliances;

public class Vacuum extends Appliance{
	private String grade;
	private int batteryVoltage;
	
	public Vacuum(String itemNumber, String brand, int quantity, int wattage, String color, Double price,String grade,int batteryVoltage) {
		super(itemNumber, brand, quantity, wattage, color, price);
		this.setBatteryVoltage(batteryVoltage);
		this.setGrade(grade);
		
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getBatteryVoltage() {
		return batteryVoltage;
	}
	public void setBatteryVoltage(int batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}
	
	public String displayBatteryVoltage() {
		switch(getBatteryVoltage()) {
		case 18:
			return "Low";
		case 24:
			return "High";
		default:
			return "No Battery Voltage matched.";
		}
	}
	
	@Override
	public String saveToString() {
		return String.format(
	            "%s;%s;%d;%d;%s;%.2f;%s;%d",
	            getItemNumber(),
	            getBrand(),
	            getQuantity(),
	            getWattage(),
	            getColor(),
	            getPrice(),
	            getGrade(),
	           getBatteryVoltage()
	        );
	}
	
	
	@Override
	public String toString() {
	String information = "ItemNumber:" + " "+ getItemNumber() + "\n"
	+ "Brand:"+ " " + getBrand() +"\n" 
	+ "Quantity:"+ " "+ getQuantity()+ "\n" 
	+ "Wattage:"+ " "+getWattage()+ "\n"
	+ "Color:"+ " " + getColor()+ "\n"
	+"Price:" + " "+getPrice() + "\n"
	+"Grade:" + " "+ grade + "\n"
	+ "BatteryVoltage:" + " "+ displayBatteryVoltage() + "\n";
		
	return information ;
	}

}
