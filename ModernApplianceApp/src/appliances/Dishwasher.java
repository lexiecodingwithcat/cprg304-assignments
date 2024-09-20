package appliances;

public class Dishwasher extends Appliance {
private String feature;
private String soundRating;
	public Dishwasher(String itemNumber, String brand, int quantity, int wattage,
			String color, Double price, String feature, String soundRating) {
		super(itemNumber, brand, quantity, wattage, color, price);
		this.feature = feature;
		this.soundRating = soundRating;
		
	}
	public String getSoundRating() {
		return soundRating;
	}
	public void setSoundRating(String soundRating) {
		this.soundRating = soundRating;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String displaySoundRating() {
		switch(getSoundRating()) {
		case "Qt":
			return "Quietest";
		case "Qr":
			return "Quieter";
		case "Qu":
			return "Quiet";
		case "M":
		return "Moderate";
		default:
			return "No sound rating macthed";
		}
	}
	@Override
	public String saveToString() {
		return String.format(
	            "%s;%s;%d;%d;%s;%.2f;%s;%s",
	            getItemNumber(),
	            getBrand(),
	            getQuantity(),
	            getWattage(),
	            getColor(),
	            getPrice(),
	            getFeature(),
	            getSoundRating()
	        );
	}
	
	@Override
	public String toString() {
		String information = "ItemNumber:"+ " " + getItemNumber() + "\n"
	+ "Brand:"+ " " + getBrand() +"\n" 
	+ "Quantity:"+ " "+ getQuantity()+ "\n" 
	+ "Wattage:"+ " "+getWattage()+ "\n"
	+ "Color:" + " "+ getColor()+ "\n"
	+"Price:" + " "+ getPrice() + "\n"
	+"Feature:" + " "+ feature + "\n"
	+ "SoundRating:"+ " " + displaySoundRating() + "\n";
		
		return information ;
	}
	
	

}
