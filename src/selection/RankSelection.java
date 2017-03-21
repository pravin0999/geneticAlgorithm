package selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import binaryGA.BinaryGA;



/**
 * The Class RankSelection performs Rank based selection where we take top two chromosomes 
 * bases on the rank of fitness and return it to the GA.
 */
public class RankSelection extends Selection {
	
	/** The Rank Selection instance. */
	private static RankSelection _instance;
	
	/**  The rank maps each chromosome with their rank. */
	HashMap<Integer, Integer> rank=new HashMap<Integer,Integer>();
	
	/**
 * Instantiates a new rank selection.
 *
 * @param p the population
 */
private RankSelection(int[][] p) {
		this.setP(p);
	}

/**
 * Gets the Rank Selection instance.
 *
 * @param p the population
 * @return the rank selection instance
 */
public static Selection getRankSelectionInstance(int[][] p)
{
	if(_instance == null)
	{	
		_instance = new RankSelection(p);
		
	}
	_instance.setP(p);
	
	return _instance;


}

/**
 * Rank determines the top two chromosomes in the population and return them to the GA.
 *
 * @return the indexes of top two chromosomes in the population according to their fitness.
 */
int[] rank(){
	System.out.println("RankSelection");
	for(int i=0;i<30;i++){
		rank.put((BinaryGA.evalSolution(i)), i);
	}
	
	ArrayList<Integer> sortedKeys=new ArrayList<Integer>(rank.keySet());
	Collections.sort(sortedKeys);
	ArrayList<Integer> top2 = new ArrayList<Integer>(sortedKeys.subList(sortedKeys.size() -2, sortedKeys.size()));
	int top01 = rank.get(top2.get(0));
	int top02 = rank.get(top2.get(1));
	
	int[] sample = new int[2];
	sample[0] = top01;
	sample[1] = top02;
	
	
	return sample;
	
}
	
	/* (non-Javadoc)
	 * @see selection.Selection#selection()
	 */
	@Override
	public int[] selection() {
		
		return rank();
	}

}
