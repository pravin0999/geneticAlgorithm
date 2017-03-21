package selection;


/**
 * A factory for creating Selection objects.
 */
abstract public class SelectionFactory {

	/** The population. */
	private int[][] p;
	
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
	 * Gets the selection.
	 *
	 * @return the selection
	 */
	public Selection getSelection() {
		return selection;
	}

	/**
	 * Sets the selection.
	 *
	 * @param selection the new selection
	 */
	public void setSelection(Selection selection) {
		this.selection = selection;
	}

	/**
	 * Creates a new Selection object.
	 *
	 * @return the selection
	 */
	abstract public Selection createselection();
	
	/** The selection. */
	public Selection selection;
	
}
