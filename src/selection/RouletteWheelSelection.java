package selection;

import binaryGA.BinaryGA;


/**
 * The Class RouletteWheelSelection performs Roulette wheel selection where we will pick two chromosomes
 * randomly based on the Roulette wheel method and return them to GA.
 */
public class RouletteWheelSelection extends Selection {
	
	
	/** The Roulette Wheel Selection instance. */
	private static RouletteWheelSelection _instance;
	
	
	/**
	 * Instantiates a new roulette wheel selection.
	 *
	 * @param p the population
	 */
	private RouletteWheelSelection(int[][] p) {
		this.setP(p);
	}

	/**
	 * Gets the roulette wheel selection instance.
	 *
	 * @param p the population
	 * @return the roulette wheel selection instance
	 */
	public static Selection getRouletteWheelSelectionInstance(int[][] p)
	{
		if(_instance == null)
		{	
			_instance = new RouletteWheelSelection(p);
			
		}
		
		return _instance;


	}

	
//	/**
//	 * Select chromosome member using roulette wheel.
//	 *
//	 * @return the chromosome
//	 */
//	public int selectMemberUsingRouletteWheel() {
//		int totalSum = 0;
//		for (int x = getP().length-1 ; x >= 0 ; x--) {
//			totalSum += evalSolution(p[x]);
//		}
//		//System.out.println("totSum: "+totalSum);
//		int rand = BinaryGA.randomNumber(0,totalSum);
//		int partialSum = 0;
//		for (int x=getP().length-1 ; x >= 0 ; x--) {
//			partialSum += evalSolution(p[x]);
//			if (partialSum > rand) {  
//				return x; 
//			}
//		}
//		return -1;
//
//	}

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
