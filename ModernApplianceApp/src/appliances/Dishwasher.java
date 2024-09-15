package appliances;

public class Dishwasher extends Appliance {
private String feature;
private String soundRating;
	public Dishwasher(int itemNumber, String brand, int quantity, int wattage,
			String color, Double price, String feature, String soundRating) {
		super(itemNumber, brand, quantity, wattage, color, price);
		
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

}
