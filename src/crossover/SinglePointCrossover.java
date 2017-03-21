package crossover;

import binaryGA.BinaryGA;

/**
 * The Class SinglePointCrossover performs Single point crossover where one crossover 
 * point is selected, binary string from beginning 
 * of chromosome to the crossover point is copied 
 * from one parent (i.e loser), the rest is copied from the second parent (i.e winner) and 
 * create a new chromosome and place them in the population
 *  (Literally replacing theloser in the population).
 */
public class SinglePointCrossover extends CrossOver {
	
	/** The SinglePoint Crossover instance. */
	private static SinglePointCrossover _instance;
	
	/**
	 * Instantiates a new single point crossover.
	 *
	 * @param p the actual population of chromosomes
	 * 
	 */
	private SinglePointCrossover(int[][] p) {
		this.p = p;
//		this.loser = loser;
//		this.winner=winner;
	}
	
	/**
	 * Gets the single point crossover instance.
	 *
	 * @param p the population
	 * @param loser the loser
	 * @param winner the winner
	 * @return the arithmetic crossover instance
	 */
	public static CrossOver getSinglePointCrossoverInstance(int[][] p, int loser, int winner)
	{
		if(_instance == null)
		{	
			_instance = new SinglePointCrossover(p);
			
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
		
		int a;
		a = (int)(10 * BinaryGA.randomDouble());
		
		for (int i = 0; i < a; i++){
			
			p[getLoser()][i] = p[getWinner()][i];
		}
		return p[getLoser()];
		
		//return null;
		
	}

}
