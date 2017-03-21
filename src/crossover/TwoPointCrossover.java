package crossover;

import binaryGA.BinaryGA;


/**
 * The Class TwoPointCrossover performs Two point crossover which is similar to the single point crossover 
 * but here we will consider two points instead of one.
 */
public class TwoPointCrossover extends CrossOver {
	
	/** The TwoPoint Crossover instance. */
	private static TwoPointCrossover _instance;
	
	/**
	 * Instantiates a new two point crossover.
	 *
	 * @param p the actual population of chromosomes
	 * 
	 */
	private TwoPointCrossover(int[][] p) {
		this.p = p;
//		this.loser = loser;
//		this.winner = winner;
	}
	
	/**
	 * Gets the two point crossover instance.
	 *
	 * @param p the population
	 * @param loser the loser
	 * @param winner the winner
	 * @return the two point crossover instance
	 */
	public static CrossOver getTwoPointCrossoverInstance(int[][] p, int loser, int winner)
	{
		if(_instance == null)
		{	
			_instance = new TwoPointCrossover(p);
			
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
		
		int a,b;
		a = (int)(10 * BinaryGA.randomDouble());
		do {b = (int)(10 * BinaryGA.randomDouble());} while(a==b);
		
		for (int i = 0; i < a; i++){
			
			p[getLoser()][i] = p[getWinner()][i];
		}
		for (int i = b; i < 10; i++){
			
			p[getLoser()][i] = p[getWinner()][i];
		}
		
		return p[getLoser()];
		
		//return null;
		
	}

}
