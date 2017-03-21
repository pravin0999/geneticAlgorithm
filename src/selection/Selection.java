package selection;



/**
 * The Class Selection which handles selection operation for us.
 */
abstract public class Selection {
	
	/**  The a,b are used to select the appropriate chromosomes from the population. */
	private int a,b;
	
	/**  The population. */
	private int[][] p;
	
	/**  The Parents is the collection of the indexes of chromosome which has been selected. */
	private int[] Parents = new int[2];

	/**
	 * Selection which is overridden
	 * by other subclasses and the performs the required selection operation..
	 *
	 * @return the selected chromosome's index in the population
	 */
	abstract public int[] selection();

	/**
	 * Gets the a.
	 *
	 * @return the a
	 */
	public int getA() {
		return a;
	}

	/**
	 * Sets the a.
	 *
	 * @param a the new a
	 */
	public void setA(int a) {
		this.a = a;
	}

	/**
	 * Gets the b.
	 *
	 * @return the b
	 */
	public int getB() {
		return b;
	}

	/**
	 * Sets the b.
	 *
	 * @param b the new b
	 */
	public void setB(int b) {
		this.b = b;
	}

	/**
	 * Gets the population.
	 *
	 * @return the population
	 */
	public int[][] getP() {
		return p;
	}

	/**
	 * Sets the population.
	 *
	 * @param p the new population
	 */
	public void setP(int[][] p) {
		this.p = p;
	}

	/**
	 * Gets the parents.
	 *
	 * @return the parents
	 */
	public int[] getParents() {
		return Parents;
	}

	/**
	 * Sets the parents.
	 *
	 * @param parents the new parents
	 */
	public void setParents(int[] parents) {
		Parents = parents;
	}
	

}
