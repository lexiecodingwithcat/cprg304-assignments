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

}
