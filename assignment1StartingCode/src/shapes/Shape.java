package shapes;

/**
 * Represents a shape object.
 * @author: Tianzi Cui
 * @version Sep.27, 2024
 */

//if shape is comparable, all shape classes will be comparable and inherit the compareTo method by default
public abstract class Shape implements Comparable<Shape>{

	private double height;
	
	/**
	 * Create a Shape with the specified height
	 * @param height the height
	 */
	public Shape(double height) {
		super();
		this.height = height;
	}
	
	/**
	 * Return the Shape's height
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Set the Shape's height
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	//the type of args should stay consistent with the one we declared in the class header
	@Override
	public int compareTo(Shape other) {
		if(this.height > other.height) return 1;
		if(this.height < other.height) return -1;
		return 0;
		
	}
	/**
	 * Returns the calculated base area of the Shape
	 * @return base area
	 */
	public abstract double calcBaseArea();
	
	/**
	 * Returns the calculated volume of the Shape
	 * @return volume
	 */
	public abstract double calcVolume();

	@Override
	public String toString() {
		return "height:" + getHeight() + ", base area:"
				+ calcBaseArea() + ", volume:" + calcVolume() ;
	}
	
	
	
	
	
	
}
