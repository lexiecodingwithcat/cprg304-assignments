package shapes;
/**
 * Represent a cone object
 */
public class Cone extends Shape
{
 private double radius;
 

/**
 * Create a Cone with specific height and radius
 * @param height the height
 * @param radius the radius
 */
public Cone(double height, double radius) {
	super(height);
	this.radius = radius;
}

/**
 * Return the Cone's radius
 * @return the radius
 */
public double getRadius() {
	return radius;
}

/**
 * Set the Cone's radius
 * @param radius the radius to set
 */
public void setRadius(double radius) {
	this.radius = radius;
}

/**
 * Calculate the Cone's base area by specific radius
 * @return base area
 */
@Override
public double calcBaseArea() {
	return Math.PI*radius*radius;
}
 
/**
 * Calculate the Cone's volume by specific radius and height
 * @return volume
 */
@Override
public double calcVolume() {
	return calcBaseArea()*getHeight()/3;
}

@Override
public String toString() {
	return "Cone [getRadius()=" + getRadius() + ", calcBaseArea()="
			+ calcBaseArea() + ", calcVolume()=" + calcVolume() + "]";
}



}
