package types;

import crossover.CrossOver;
import crossover.SinglePointCrossoverFactory;
import mutation.BitInversionFactory;
import mutation.Mutation;
import selection.RouletteWheelSelectionFactory;
import selection.Selection;


/**
 * The Class Type05 has a collection of SinglePoint crossover,BitInversion mutation,RouletteWheel selection.
 */
public class Type05 extends Types {
	
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
		
		return (new RouletteWheelSelectionFactory(population)).createselection();
	}

	

}
