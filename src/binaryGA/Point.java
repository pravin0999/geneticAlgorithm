
package binaryGA;

/**
 * The Class Dash is used to model a point
 */
public class Point {
	
	/** The x coordinate.
	 * x can be of type double
	 */
	
	private int x;
	
	/** The y coordinate.
	 * y can be of type double
	 */
	private int y;

	/**
	 * Instantiates a new point.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Gets the x coordinate.
	 *
	 * @return x the x coordinate. 
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y coordinate.
	 *
	 * @return y the y coordinate.
	 */
	public int getY() {
		return y;
	}
}
