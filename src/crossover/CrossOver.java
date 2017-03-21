package crossover;


/**
 * The Class CrossOver.
 *
 * @author pravinkumar
 */
abstract public class CrossOver {
	
	/** The population. */
	protected int[][] p;
	
	/** The loser chromosome. */
	private int loser;
	
	/** The winner chromosome. */
	private int winner;
	
	/** The cross over rate. */
	private static double xoRate = 0.5;
	
	/** The chromosome to be created using the winner and the loser. */
	private int[] chromosome = new int[10];
	
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
	 * Gets the xo rate.
	 *
	 * @return the xo rate
	 */
	public static double getXoRate() {
		return xoRate;
	}

	/**
	 * Sets the xo rate.
	 *
	 * @param xoRate the new xo rate
	 */
	public static void setXoRate(double xoRate) {
		CrossOver.xoRate = xoRate;
	}

	/**
	 * Gets the chromosome.
	 *
	 * @return the chromosome
	 */
	public int[] getChromosome() {
		return chromosome;
	}

	/**
	 * Sets the chromosome.
	 *
	 * @param chromosome the new chromosome
	 */
	public void setChromosome(int[] chromosome) {
		this.chromosome = chromosome;
	}

	/**
	 * Cross over which is overridden
	 * by other subclasses and the performs the required cross over operation.
	 *
	 * @return the altered chromosome back to the population
	 */
	abstract int[] crossOver();
	
	

}
