package mutation;

/**
 * A factory for creating BitInversion objects.
 */
public class BitInversionFactory extends MutationFactory {
	
	
	/** The mutation reference to play with. */
	Mutation mutation;
	
	/**
	 * Instantiates a new bit inversion factory.
	 *
	 * @param p the population
	 * @param loser the loser
	 */
	public BitInversionFactory(int[][] p, int loser) {
		this.setP(p);
		this.setLoser(loser);
		
	}

	/* (non-Javadoc)
	 * @see mutation.MutationFactory#createmutation()
	 */
	@Override
	public Mutation createmutation() {
		
		mutation = BitInversion.getBitInversionInstance(getP(),getLoser());
		mutation.setChromosome(mutation.mutation());
		return mutation;
	}


}
