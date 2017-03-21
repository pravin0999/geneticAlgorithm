package types;

import crossover.CrossOver;
import crossover.UniformCrossoverFactory;
import mutation.BitInversionFactory;
import mutation.Mutation;
import selection.Selection;
import selection.SteadyStateSelectionFactory;


/**
 * The Class Type12 has a collection of Uniform crossover,BitInversion mutation,Steady State selection.
 */
public class Type12 extends Types{

	/* (non-Javadoc)
	 * @see types.Types#createcrossover(int[][], int, int)
	 */
	@Override
	public CrossOver createcrossover(int[][] population, int winner, int loser) {
		
		return (new UniformCrossoverFactory(population , winner , loser)).createcrossover();
	}

	/* (non-Javadoc)
	 * @see types.Types#createmutation(int[][], int)
	 */
	@Override
	public Mutation createmutation(int[][] population, int loser) {
		
		return (new BitInversionFactory(population,loser)).createmutation();
	}

	
	/* (non-Javadoc)
	 * @see types.Types#createselection(int[][])
	 */
	@Override
	public Selection createselection(int[][] population) {
		
		return (new SteadyStateSelectionFactory(population)).createselection();
	}
	
}
