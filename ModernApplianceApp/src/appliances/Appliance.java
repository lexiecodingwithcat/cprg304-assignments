package appliances;

/**
 * The {@code Appliance} class is an abstract class of other specific devices.
 * It contains common attributes itemNumber, brand, quantity, wattage, color and price.
 * 
 * @author Tianzi Cui
 * @since 2024-09-19
 */
public abstract class Appliance {
  protected String itemNumber;
  protected String brand;
  protected int quantity;
  protected int wattage;
  protected String color;
  protected Double price;
  
 
  public String getItemNumber() {
	  return itemNumber;
  }
  public void setItemNumber(String number) {
	  this.itemNumber = number;
  }
  public String getBrand() {
	  return brand;
  }
  public void setBrand(String brand) {
	  this.brand = brand;
  }
  public int getQuantity() {
	  return quantity;
  }
  public void setQuantity(int quantity) {
	  this.quantity = quantity;
  }
  
  public int getWattage() {
	  return wattage;
  }
  public void setWattage(int wattage) {
	  this.wattage = wattage;
  }
  public String getColor() {
	  return color;
  }
  public void setColor(String color) {
	  this.color = color;
  }
  public Double getPrice() {
	  return price;
  }
  public void setPrice(Double price) {
	  this.price = price;
  }
  
  public Appliance(String itemNumber, String brand, int quantity,int wattage, String color,Double price)
  {
	  this.itemNumber = itemNumber;
	  this.brand = brand;
	  this.quantity = quantity;
	  this.wattage = wattage;
	  this.color = color;
	  this.price = price;
  }
public abstract String saveToString();
  


  
}
