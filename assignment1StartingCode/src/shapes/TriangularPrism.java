package shapes;

public class TriangularPrism extends Prism
{

	/**
	 * Create TriangularPrism object
	 * @param height the height
	 * @param side the side
	 */
	public TriangularPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return getSide()*getSide()*Math.sqrt(3)/4;
	}

	@Override
	public String toString() {
		return  "TriangularPrism---Height: " + getHeight() +
		           ", Side: " + getSide() +
		           ", Base Area: " + calcBaseArea() +
		           ", Volume: " + calcVolume();
	}

	

}
