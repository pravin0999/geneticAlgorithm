package selection;

import binaryGA.BinaryGA;

/**
 * The Class SteadyStateSelection performs Steady state selection where we will pick 
 * two random chromosomes from the population.
 */
public class SteadyStateSelection extends Selection {
	
	/** The Steady State Selection instance. */
	private static SteadyStateSelection _instance;

	/**
	 * Instantiates a new steady state selection.
	 *
	 * @param p the population
	 */
	private SteadyStateSelection(int[][] p) {
		this.setP(p);
	}

	/**
	 * Gets the steady state selection instance.
	 *
	 * @param p the population
	 * @return the steady state selection instance
	 */
	public static Selection getSteadyStateSelectionInstance(int[][] p)
	{
		if(_instance == null)
		{	
			_instance = new SteadyStateSelection(p);
			
		}
		
		return _instance;


	}
	
	/* (non-Javadoc)
	 * @see selection.Selection#selection()
	 */
	@Override
	public int[] selection() {
		setA((int)(29 * BinaryGA.randomDouble()));
		do {setB((int)(29 * BinaryGA.randomDouble()));} while(getA()==getB());
		int[] sample = new int[2];
		sample[0] = getA();
		sample[1] = getB();
		
		if (BinaryGA.evalSolution(getA()) > BinaryGA.evalSolution(getB()))
		{
			sample[0] = getA(); //winner
			sample[1] = getB(); //loser
		}
		else
		{
			sample[0] = getA();
			sample[1] = getB();
		}

		
		return sample;
	}

}
