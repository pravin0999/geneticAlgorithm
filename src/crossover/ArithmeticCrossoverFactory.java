package crossover;

/**
 * A factory for creating ArithmeticCrossover objects.
 */
public class ArithmeticCrossoverFactory extends CrossOverFactory {
	
	
	
	/**
	 * Instantiates a new arithmetic crossover factory.
	 *
	 * @param p the population
	 * @param winner the winner
	 * @param loser the loser
	 */
	public ArithmeticCrossoverFactory(int[][] p, int winner, int loser) {
		this.setP(p);
		this.setLoser(loser);
		this.setWinner(winner);
	}

	/* (non-Javadoc)
	 * @see crossover.CrossOverFactory#createcrossover()
	 */
	@Override
	public CrossOver createcrossover() {
		setCrossover(ArithmeticCrossover.getArithmeticCrossoverInstance(getP(),getLoser(),getWinner()));
		crossover.setChromosome(crossover.crossOver());
		return crossover;
	}

}
