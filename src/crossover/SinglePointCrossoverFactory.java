package crossover;

/**
 * A factory for creating SinglePointCrossover objects.
 */
public class SinglePointCrossoverFactory extends CrossOverFactory {

	
	
	/**
	 * Instantiates a new single point crossover factory.
	 *
	 * @param p the population
	 * @param winner the winner
	 * @param loser the loser
	 */
	public SinglePointCrossoverFactory(int[][] p, int winner ,int loser) {
		this.setP(p);
		this.setLoser(loser);
		this.setWinner(winner);
	}

	/* (non-Javadoc)
	 * @see crossover.CrossOverFactory#createcrossover()
	 */
	@Override
	public CrossOver createcrossover() {
		crossover = SinglePointCrossover.getSinglePointCrossoverInstance(getP(),getLoser(),getWinner());
		crossover.setChromosome(crossover.crossOver());
		return crossover;
	}

}
