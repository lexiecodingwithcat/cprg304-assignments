package shapes;

public class Pyramid extends Shape
{
private double side;
/**
 * Create a Pyramid with specified height and side
* @param height the height
* @param side the side
*/
public Pyramid(double height, double side) {
		super(height);
		this.side = side;
}
	
/**Get Pyramid's side
 * @return the side
 */
public double getSide() {
	return side;
}

/**
 * Set Pyramid's side
 * @param side the side to set
 */
public void setSide(double side) {
	this.side = side;
}

@Override
public double calcBaseArea() {
	return getSide()* getSide();
}

@Override
public double calcVolume() {
	return calcBaseArea()*getHeight()/3;
}

@Override
public String toString() {
	return "Pyramid---Height: " + getHeight() +
	           ", Side: " + getSide() +
	           ", Base Area: " + calcBaseArea() +
	           ", Volume: " + calcVolume();
}






}
