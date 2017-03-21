package binaryGA;

/**
 * The Class Dash is used to model a line segment (dash)
 */
public class Dash {
	
	/** The point 1. 
	 * x and y can be of type double
	 */
	
	private Point p1;
	
	/** The point 2. 
	 * x and y can be of type double
	 */
	private Point p2;

	/**
	 * Instantiates a new dash.
	 *
	 * @param p1 the point 1
	 * @param p2 the point 2
	 */
	public Dash(Point p1, Point p2){
		this.p1=new Point(p1.getX(),p1.getY());
		this.p2=new Point(p2.getX(),p2.getY());
	}
	
	/**
	 * Gets the point 1.
	 *
	 * @return p1 the point 1
	 */
	public Point getP1() {
		return p1;
	}

	/**
	 * Gets the point 2.
	 *
	 * @return p2 the point 2
	 */
	public Point getP2() {
		return p2;
	}
}
