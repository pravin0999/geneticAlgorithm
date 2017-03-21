package crossover;



/**
 * A factory for creating CrossOver objects.
 */
abstract public class CrossOverFactory {
	
	/**  The population. */
	private int[][] p;
	
	/** The winner. */
	private int winner;
	
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
	 * Gets the winner.
	 *
	 * @return the winner
	 */
	public int getWinner() {
		return winner;
	}

	/**
	 * Sets the winner.
	 *
	 * @param winner the new winner
	 */
	public void setWinner(int winner) {
		this.winner = winner;
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
	 * Gets the crossover.
	 *
	 * @return the crossover
	 */
	public CrossOver getCrossover() {
		return crossover;
	}

	/**
	 * Sets the crossover.
	 *
	 * @param crossover the new crossover
	 */
	public void setCrossover(CrossOver crossover) {
		this.crossover = crossover;
	}

	/** The abstract crossover reference to play with. */
	protected CrossOver crossover;
	
	/**
	 * Creates a new CrossOver object.
	 *
	 * @return the cross over
	 */
	abstract public CrossOver createcrossover();

}
