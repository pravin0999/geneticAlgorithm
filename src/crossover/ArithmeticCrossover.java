package crossover;

import binaryGA.BinaryGA;

/**
 * The Class ArithmeticCrossover performs Arithmetic crossover 
 * where some arithmetic operation is performed between loser and winner
 * to make a new offspring and added them back to the population.
 */
public class ArithmeticCrossover extends CrossOver {
	
	/** The ArithmeticCrossover instance. */
	private static ArithmeticCrossover _instance;
	
	/**
	 * Instantiates a new Arithmetic crossover.
	 * 
	 * @param p the actual population of chromosomes
	 * 
	 */
	private ArithmeticCrossover(int[][] p) {
		setP(p);
//		this.loser = loser;
//		this.winner=winner;
	}

	/**
	 * Gets the arithmetic crossover instance.
	 *
	 * @param p the population
	 * @param loser the loser
	 * @param winner the winner
	 * @return the arithmetic crossover instance
	 */
	public static CrossOver getArithmeticCrossoverInstance(int[][] p, int loser, int winner)
	{
		if(_instance == null)
		{	
			_instance = new ArithmeticCrossover(p);
			
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
			p[getLoser()][i] = p[getLoser()][i]*p[getWinner()][i];
		}
		return p[getLoser()];
		
		//return null;
		
	}

}
