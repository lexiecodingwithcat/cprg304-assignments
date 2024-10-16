package shapes;

public class OctagonalPrism extends Prism
{

	/**
	 * Create OtagonalPrism with specified height and side
	 * @param height the height
	 * @param side the side
	 */
	public OctagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
	
		return getSide()*getSide()*2*(1+Math.sqrt(2));
	}

	@Override
	public String toString() {
		return "OctagonalPrism---Height: " + getHeight() +
		           ", Side: " + getSide() +
		           ", Base Area: " + calcBaseArea() +
		           ", Volume: " + calcVolume();
	}

}
