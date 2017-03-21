package types;

import crossover.CrossOver;
import crossover.TwoPointCrossoverFactory;
import mutation.BitInversionFactory;
import mutation.Mutation;
import selection.RankSelectionFactory;
import selection.Selection;


/**
 * The Class Type07 has a collection of TwoPoint crossover,BitInversion mutation,Rank selection.
 */
public class Type07 extends Types {
	
	/* (non-Javadoc)
	 * @see types.Types#createcrossover(int[][], int, int)
	 */
	@Override
	public CrossOver createcrossover(int[][] population, int winner, int loser) {
		
		return (new TwoPointCrossoverFactory(population , winner , loser)).createcrossover();
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
		
		return (new RankSelectionFactory(population)).createselection();
	}


}
