package binaryGA;

import java.util.ArrayList;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Population.
 */
public class Population {
	
	/** The size of the population which says 
	 *  the no. of chromosomes in the population
	 */
	private int size;
	

	/** The population of chromosomes. */
	ArrayList<Chromosome> population = new ArrayList<Chromosome>();
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Gets the population.
	 *
	 * @return the population
	 */
	public ArrayList<Chromosome> getPopulation() {
		return population;
	}

	/**
	 * Sets the population.
	 *
	 * @param population the new population
	 */
	public void setPopulation(ArrayList<Chromosome> population) {
		this.population = population;
	}
	
	/**
	 * Instantiates a new population.
	 *
	 * @param size the size of the population
	 */
	Population(int size){
		setSize(size);
		for(int i = 0; i< size ; i++){
			//add(new Chromosome());
			Chromosome ch = new Chromosome();
			
			for (int j = 0; j < 10; j++)
			{
				//randomly create chromosome values
				if (randomDouble() < 0.5)
				{
					ch.getChromosome()[j] = 0;
				}
				else
				{
					ch.getChromosome()[j] = 1;
				}
			}
//			ch.fitness = 0;
//			ch.rank += 1;
//			ch.index += 1;
			add(ch);
			
		}
	}
	
	/**
	 * Adds the chromosome to the population.
	 *
	 * @param anIndividual the chromosome to be added
	 */
	void add(Chromosome anIndividual){
		population.add(anIndividual);
	}
	
	/**
	 * this method returns a random number n such that
	 * 0.0 <= n <= 1.0
	 *
	 * @return the double
	 */
	static double randomDouble()
	{
		Random r = new Random();
		return r.nextInt(1000) / 1000.0;
	}
	
	/**
	 * Prints the population.
	 */
	void PrintPopulation(){
		
			System.out.println(population.toString()); 
			
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		
		StringBuilder populationAsString = new StringBuilder();
		
		for(int i = 0 ;i<population.size() ;i++){
			populationAsString.append((population.get(i)).toString() + "\n");
		}
		return populationAsString.toString();
		
	}


}
