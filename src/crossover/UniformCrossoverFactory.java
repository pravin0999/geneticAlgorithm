package crossover;

/**
 * A factory for creating UniformCrossover objects.
 */
public class UniformCrossoverFactory extends CrossOverFactory {


	
	/**
	 * Instantiates a new uniform crossover factory.
	 *
	 * @param p the population
	 * @param winner the winner
	 * @param loser the loser
	 */
	public UniformCrossoverFactory(int[][] p, int winner, int loser) {
		this.setP(p);
		this.setLoser(loser);
		this.setWinner(winner);
	}

	/* (non-Javadoc)
	 * @see crossover.CrossOverFactory#createcrossover()
	 */
	@Override
	public CrossOver createcrossover() {
		crossover = UniformCrossover.getUniformCrossoverInstance(getP(),getLoser(),getWinner());
		crossover.setChromosome(crossover.crossOver());
		return crossover;
	}

}
