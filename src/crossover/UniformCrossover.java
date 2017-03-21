package crossover;

import binaryGA.BinaryGA;

/**
 * The Class UniformCrossover performs Uniform crossover where we will choose 
 * two chromosomes (a winner and a loser) and bits are randomly copied from 
 * the winner to the loser.
 */
public class UniformCrossover extends CrossOver {
	
	/** The Uniform Crossover instance. */
	private static UniformCrossover _instance;
	
	/**
	 * Instantiates a new uniform crossover.
	 *
	 * @param p the actual population of chromosomes
	 * 
	 */
	private UniformCrossover(int[][] p) {
		this.p = p;
//		this.loser = loser;
//		this.winner = winner;
	}

	/**
	 * Gets the uniform crossover instance.
	 *
	 * @param p the population
	 * @param loser the loser
	 * @param winner the winner
	 * @return the uniform crossover instance
	 */
	public static CrossOver getUniformCrossoverInstance(int[][] p, int loser, int winner)
	{
		if(_instance == null)
		{	
			_instance = new UniformCrossover(p);
			
		}
		_instance.setLoser(loser);
		_instance.setWinner(winner);
		
		return _instance;
	
	
	}
	
	/* (non-Javadoc)
	 * @see crossover.CrossOver#crossOver()
	 */
	@Override
	int[] crossOver() {
		
		for (int i = 0; i < 10; i++){
			if (BinaryGA.randomDouble() < getXoRate())
			p[getLoser()][i] = p[getWinner()][i];
		}
		return p[getLoser()];
		
	}

}
