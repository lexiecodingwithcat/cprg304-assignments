package shapes;

public class Cylinder extends Shape
{
private double radius;

/**
 * Create a cylinder with specified radius and height
 * @param height the height
 * @param radius the radius
 */
public Cylinder(double height, double radius) {
	super(height);
	this.radius = radius;
}

/**
 * Get cylinder's radius
 * @return the radius
 */
public double getRadius() {
	return radius;
}

/**
 * Set cylinder's radius
 * @param radius the radius to set
 */
public void setRadius(double radius) {
	this.radius = radius;
}


@Override
public double calcBaseArea() {
	
	return Math.PI*getRadius()*getRadius();
}

@Override
public double calcVolume() {
	return getHeight()* calcBaseArea();
}

@Override
public String toString() {
	return "Cylinder [getRadius()=" + getRadius() + ", calcBaseArea()="
			+ calcBaseArea() + ", calcVolume()=" + calcVolume()
			+ ", getHeight()=" + getHeight() + "]";
}

}
