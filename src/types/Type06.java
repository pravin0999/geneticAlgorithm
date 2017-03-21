package types;

import crossover.CrossOver;
import crossover.SinglePointCrossoverFactory;
import mutation.BitInversionFactory;
import mutation.Mutation;
import selection.Selection;
import selection.SteadyStateSelectionFactory;


/**
 * The Class Type06 has a collection of SinglePoint crossover,BitInversion mutation,SteadyState selection.
 */
public class Type06 extends Types{

	/* (non-Javadoc)
	 * @see types.Types#createcrossover(int[][], int, int)
	 */
	@Override
	public CrossOver createcrossover(int[][] population, int winner, int loser) {
	
		return (new SinglePointCrossoverFactory(population , winner , loser)).createcrossover();
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
