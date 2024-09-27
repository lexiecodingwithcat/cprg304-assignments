package shapes;

public class SquarePrism extends Prism
{

	/**
	 * Create a SquarePrism with sepcified height and side.
	 * @param height the height
	 * @param side the side
	 */
	public SquarePrism(double height, double side) 
	{
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		
		return getSide()*getSide();
	}

	@Override
	public String toString() {
		return "SquarePrism [calcBaseArea()=" + calcBaseArea() + ", getSide()="
				+ getSide() + ", calcVolume()=" + calcVolume()
				+ ", getHeight()=" + getHeight() + "]";
	}

	


}
