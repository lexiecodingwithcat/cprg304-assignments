package appliances;
import java.util.Scanner;

public abstract class Appliance {
  private int itemNumber;
  private String brand;
  private int quantity;
  private int wattage;
  private String color;
  private Double price;
  
  //getters and setters
  public int getItemNumber() {
	  return itemNumber;
  }
  public void setItemNumber(int number) {
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
  //constructor
  public Appliance(int itemNumber, String brand, int quantity,int wattage, String color,Double price)
  {
	  this.itemNumber = itemNumber;
	  this.brand = brand;
	  this.quantity = quantity;
	  this.wattage = wattage;
	  this.color = color;
	  this.price = price;
  }
  
}
