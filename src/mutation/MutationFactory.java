package mutation;


/**
 * A factory for creating Mutation objects.
 */
abstract public class MutationFactory {
	
	/** The population. */
	private int[][] p;
	
	/** The loser. */
	private int loser;
	
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
	 * Gets the loser.
	 *
	 * @return the loser
	 */
	public int getLoser() {
		return loser;
	}

	/**
	 * Sets the loser.
	 *
	 * @param loser the new loser
	 */
	public void setLoser(int loser) {
		this.loser = loser;
	}

	/**
	 * Creates a new Mutation object.
	 *
	 * @return the mutation
	 */
	abstract public Mutation createmutation();
	

	
}
