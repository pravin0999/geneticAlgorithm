package crossover;

/**
 * A factory for creating TwoPointCrossover objects.
 */
public class TwoPointCrossoverFactory extends CrossOverFactory {

	
	/**
	 * Instantiates a new two point crossover factory.
	 *
	 * @param p the population
	 * @param winner the winner
	 * @param loser the loser
	 */
	public TwoPointCrossoverFactory(int[][] p, int winner ,int loser) {
		this.setP(p);
		this.setLoser(loser);
		this.setWinner(winner);
	}

	/* (non-Javadoc)
	 * @see crossover.CrossOverFactory#createcrossover()
	 */
	@Override
	public CrossOver createcrossover() {
		crossover = TwoPointCrossover.getTwoPointCrossoverInstance(getP(),getLoser(),getWinner());
		crossover.setChromosome(crossover.crossOver());
		return crossover;
	}

}
