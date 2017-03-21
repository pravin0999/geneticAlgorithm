package binaryGA;

/**
 * The Class Chromosome creates the chromosome.
 */
public class Chromosome {
	
	/** The chromosome length. */
	private static int chromLength = 10;
	
	/** The chromosome/solution/genotype  */
	private int[] chromosome = new int[getChromLength()];
//	int fitness;
//	int rank;
//	int index;
	
	/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
public String toString(){
		StringBuilder populationAsString = new StringBuilder();
		//populationAsString.append(chromosome.toString());// String.valueOf(chromosome));
		for(int i: chromosome){
			populationAsString.append(i);
		}
//		populationAsString.append(" " + new Integer(fitness).toString());
//		populationAsString.append(" " + new Integer(rank).toString());
//		populationAsString.append(" " + new Integer(index).toString());
		return populationAsString.toString();
	}

	/**
	 * Gets the chromosome length.
	 *
	 * @return chromLength the chromosome length.
	 */
	public static int getChromLength() {
		return chromLength;
	}

	/**
	 * Sets the chromosome length.
	 *
	 * @param chromLength the new the chromosome length.
	 */
	public static void setChromLength(int chromLength) {
		Chromosome.chromLength = chromLength;
	}

	/**
	 * Gets the chromosome
	 *
	 * @return the chromosome
	 */
	public int[] getChromosome() {
		return chromosome;
	}

	/**
	 * Sets the chromosome.
	 *
	 * @param chromosome the new chromosome
	 */
	public void setChromosome(int[] chromosome) {
		this.chromosome = chromosome;
	}
	
}
