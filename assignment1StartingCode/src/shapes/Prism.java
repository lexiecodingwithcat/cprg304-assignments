/**
 * 
 */
package shapes;

/**
 * Represent a Prism
 */
public abstract class Prism extends Shape{
   private double side;

/**
 * Create Prism with specified height and side
 * @param height the height
 * @param side the side
 */
public Prism(double height, double side) {
	super(height);
	this.side = side;
}

/**
 * Return the Prism's side
 * @return the side
 */
public double getSide() {
	return side;
}

/**Set the Prism's side
 * @param side the side to set
 */
public void setSide(double side) {
	this.side = side;
}
   
@Override
public double calcVolume() {
	return calcBaseArea()*getHeight();
}


}
