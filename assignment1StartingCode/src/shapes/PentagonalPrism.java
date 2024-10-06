package shapes;

public class PentagonalPrism extends Prism
{

	/**
	 * Create PentagonalPrism object
	 * @param height the height
	 * @param side the side
	 */
	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		
		return 5*getSide()*getSide()*Math.tan(Math.toRadians(54));
	}
	

}
