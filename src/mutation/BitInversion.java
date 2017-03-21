package mutation;

import binaryGA.BinaryGA;

/**
 * The Class BitInversion which performs Bit inversion mutation where a chromosome(loser) is chosen 
 * and randomly we will invert the bits and return them to the population.
 */
public class BitInversion extends Mutation {

	/** The singleton instance. */
	private static BitInversion _instance;

	/**
	 * Instantiates a new bit inversion.
	 *
	 * @param p the population
	 */
	private BitInversion(int[][] p) {
		this.setP(p);
//		this.loser = loser;
	}

	/**
	 * Gets the bit inversion instance.
	 *
	 * @param p the population
	 * @param loser the loser
	 * @return the bit inversion instance
	 */
	public static Mutation getBitInversionInstance(int[][] p, int loser)
	{
		if(_instance == null)
		{	
			_instance = new BitInversion(p);
			
		}
		_instance.setLoser(loser);
		
		return _instance;
	
	
	}
	
	/* (non-Javadoc)
	 * @see mutation.Mutation#mutation()
	 */
	@Override
	int[] mutation() {
		for (int i = 0; i < 10; i++){
			if (BinaryGA.randomDouble() < getMutRate())
			p[getLoser()][i] = 1 - p[getLoser()][i];
		}
		return p[getLoser()];
		
	}
}
