package mutation;



/**
 * The Class Mutation which handles mutation operation for us.
 */
abstract public class Mutation {
	
	/** The population. */
	protected int[][] p;
	
	/** The loser. */
	private int loser;
	
	/** The mutation rate. */
	private static double mutRate = 0.1;
	
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
	 * Gets the mutation rate.
	 *
	 * @return the mutation rate
	 */
	public static double getMutRate() {
		return mutRate;
	}

	/**
	 * Sets the mutation rate.
	 *
	 * @param mutRate the new mutation rate
	 */
	public static void setMutRate(double mutRate) {
		Mutation.mutRate = mutRate;
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

	/** The chromosome. */
	private int[] chromosome = new int[10];
	
	/**
	 * Mutation which is overridden
	 * by other subclasses and the performs the required mutation operation.
	 *
	 * @return the int[]
	 */
	abstract int[] mutation();


}
