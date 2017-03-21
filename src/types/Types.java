package types;

import crossover.CrossOver;
import mutation.Mutation;
import selection.Selection;


/**
 * The Class Types which has abstract features for the Type creation.
 */
abstract public class Types {
	
//	private int[][] p;
//	private int loser;
	
/**
 * Createcrossover creates CrossOver object at runtime and returns to GA.
 *
 * @param population the population
 * @param winner the winner
 * @param loser the loser
 * @return the cross over
 */
abstract public CrossOver createcrossover(int[][] population, int winner, int loser);
	
	/**
	 * Createmutation creates Mutation object at runtime and returns to GA.
	 *
	 * @param population the population
	 * @param loser the loser
	 * @return the mutation
	 */
	abstract public Mutation createmutation(int[][] population, int loser);
	
	/**
	 * Createselection creates Selection object at runtime and returns to GA.
	 *
	 * @param population the population
	 * @return the selection
	 */
	abstract public Selection createselection(int[][] population);
	

}
