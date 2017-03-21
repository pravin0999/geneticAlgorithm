package binaryGA;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import types.Types;
import typesFactory.TypesAbstractFactory;
import typesFactory.TypesConcreteFactory;
 

/**
 * The Class BinaryGA demonstrates the genetic algorithm which predict which line segments are 
 * suppose to join to form a large line segment where 
 * we conduct as many trials as possible to get a desired result.
 */
public class BinaryGA
{	
	
	/** The population size. */
	private static int popSize = 30;
	
	//length of the chromosome
	//private static int chromLength = 10;
	
	/** Radius of colinearity. */
	private static double roc = 0.5; 

	/** Min dist between two dashes to be considered adjacent! */
	private static double dash_separation = 1.5;

	/**  Max no. of trials */
	private static double maxNoTour = 1000;
     
	//coordinates of the input line segments
	/** The dash 1. */
	private static Dash d1  = new Dash(new Point(2,6),new Point(4,6)); 
	
	/** The dash 2. */
	private static Dash d2  = new Dash(new Point(5,6),new Point(7,6));
	
	/** The dash 3. */
	private static Dash d3  = new Dash(new Point(8,6),new Point(10,6)); 
	
	/** The dash 4. */
	private static Dash d4  = new Dash(new Point(11,6),new Point(13,6)); 
	
	/** The dash 5. */
	private static Dash d5  = new Dash(new Point(14,6),new Point(16,6)); 
	
	/** The dash 6. */
	private static Dash d6  = new Dash(new Point(2,2),new Point(4,2)); 
	
	/** The dash 7. */
	private static Dash d7  = new Dash(new Point(5,2),new Point(7,2)); 
	
	/** The dash 8. */
	private static Dash d8  = new Dash(new Point(8,2),new Point(10,2)); 
	
	/** The dash 9. */
	private static Dash d9  = new Dash(new Point(11,2),new Point(13,2)); 
	
	/** The dash 10. */
	private static Dash d10 = new Dash(new Point(14,2),new Point(16,2)); 
      
	// an array of the input line segments
	/** The dashes combine. */
	private static Dash[] dashes = {d1,d6,d2,d7,d3,d8,d4,d9,d5,d10};
	
	
	/** The chromosomes array, 30 members, 10 line segments each */
	private static int[][] population = new int[getPopSize()][Chromosome.getChromLength()];
	
	/**
	 *  
	 * Returns the population size.
	 *
	 * @return popSize the population size
	 */
	public static int getPopSize() {
		return popSize;
	}
	
	/**
	 *  
	 * Sets population's size.
	 *
	 * @param popSize the size of the population
	 */
	public static void setPopSize(int popSize) {
		BinaryGA.popSize = popSize;
	}

	/**
	 *  Returns the radius of colinearity.
	 *
	 * @return roc the radius of colinearity.
	 */
	public static double getRoc() {
		return roc;
	}

	/**
	 *  
	 * Sets the radius of colinearity.
	 *
	 * @param roc the new radius of colinearity.
	 */
	public static void setRoc(double roc) {
		BinaryGA.roc = roc;
	}

	/**
	 * Returns the max no. of tours(trials) 
	 *
	 * @return maxNoTour the max no. of tours
	 */
	public static double getMaxNoTour() {
		return maxNoTour;
	}

	/**
	 *  Sets the max no. of tours(trials) 
	 *
	 * @param maxNoTour the new max no. of tours
	 */
	public static void setMaxNoTour(double maxNoTour) {
		BinaryGA.maxNoTour = maxNoTour;
	}

	/**
	 *  Returns the population of chromosomes
	 *
	 * @return population the population of chromosomes
	 */
	public static int[][] getPopulation() {
		return population;
	}

	/**
	 *  Sets the population of chromosomes 
	 *
	 * @param population the new population
	 */
	public static void setPopulation(int[][] population) {
		BinaryGA.population = population;
	}

	/**
	 *  The starting point for the program
	 *  
	 * @param args the arguments
	 */
	public static void main(String[] args){
		runGA();
	}
	
	/**
	 *  
	 * Prints out coordinate of a dash.
	 *
	 * @param a the Dash
	 */
	static void printDash(Dash a){

		Point p1 = a.getP1();
		Point p2 = a.getP2();
		int x1 = p1.getX(); int y1 = p1.getY(); 
		int x2 = p2.getX(); int y2 = p2.getY(); 
		System.out.println("Dash: ("+x1+","+y1+")"+",("+x2+","+y2+")");      

	}
	
	/** 
	 * Checks whether a list of Dashes forms a dashed line
	 * The idea is to compare the 1st element of the list against the 2nd,
	 * the 2nd against the 3rd and so on. We do these pairwise comparisons and
	 * check whether each pair is colinear and adjacent
	 * We count the number of colinear and adjacent pairs
	 * if the number is 4 then these line segments form a dashed line
	 * (remember we do 4 pairwise comparisons when we have 5 elements)
	 * @param lsList a list of Dashes
	 *
	 * @return value the number of consecutive colinear and adjacent LineSegments (dashes)
	 */
	public static int listIsDashedLine(List<Dash> lsList){
		int numColAdjLS = 0;
		for (int i = 0; i < (lsList.size()-1); i++) {
			Dash ls1 = lsList.get(i);
			Dash ls2 = lsList.get(i+1);      
			if(colinearDashes(ls1,ls2) && adjacentDashes(ls1,ls2))
				numColAdjLS++;
		}
		return numColAdjLS;
	}

	/**
	 *  
	 * Runs the Microbial GA to solve the problem domain
	 * Where the problem domain is specified as follows
	 * You have coordinates of 10 line segments
	 * You have to divide them into 2 groups each of which forms a dashed line.
	 */
	public static void runGA()
	{
		int Winner;
		int Loser;
		
		initPopulation();

		for (int tournamentNo = 0; tournamentNo < maxNoTour; tournamentNo++)
		{
			TypesAbstractFactory typeCreator = new TypesConcreteFactory();
			Types t = typeCreator.chooseTypes();
			
			int chromosomes[] = new int[2];
			//Selection
			
			chromosomes = (t.createselection(getPopulation())).getParents();
			Winner = chromosomes[0];
			Loser = chromosomes[1];
			
			//Crossover

			population[Loser]=(t.createcrossover(getPopulation(),Winner,Loser)).getChromosome();
			
			//Mutation
			population[Loser]=(t.createmutation(getPopulation(),Loser)).getChromosome();
			
			
				if (evalSolution(Loser) == -1)
				{
					displayResult(tournamentNo, Loser);
					System.exit(0);
				}
			}

		}
	

	/**
	 * This method displays the results. 
	 * @param tournaments : the current tournament loop number
	 * @param n : the nth member of the population. 
	 */ 
	private static void displayResult(int tournaments, int n)
	{
		System.out.println("\r\n==============================\r\n");
		System.out.println("After " + tournaments + 
				" tournaments, dashes forming one line are:");
		for (int i = 0; i < Chromosome.getChromLength(); i++) {
			if (population[n][i] == 0) {
				//System.out.println(i + 1);
				printDash(dashes[i]);
			}
		}
		System.out.println("\r\nAnd dashes forming the other line are:");
		for (int i = 0; i < Chromosome.getChromLength(); i++) {
			if (population[n][i] == 1) {
				//System.out.println(i + 1);
				printDash(dashes[i]);
			}
		}
	}

               
	/**
	 * This method evaluates the the nth member of the population
	 * If score is -1, then we have a good GA which has solved
	 * the problem domain 
	 * @param n the nth member of the population
	 * @return value the score for this member of the population
	 */ 
	public static int evalSolution(int n)
	{
		List<Dash> lsList1 = new ArrayList<Dash>();
		List<Dash> lsList2 = new ArrayList<Dash>();
		
		for (int i = 0; i < Chromosome.getChromLength(); i++)
		{
			if (population[n][i] == 0)
			{
				lsList1.add(dashes[i]);                    
			}
			else
			{                    
				lsList2.add(dashes[i]);                    
			}
		}
		System.out.print("Current chromosome: ");

		for (int j = 0; j < Chromosome.getChromLength(); j++)
		{
			System.out.print(population[n][j]+" ");                    
		}  
		System.out.println();  
		
		int res1 = listIsDashedLine(lsList1);
		int res2 = listIsDashedLine(lsList2);
		if(res1 == 4 && res2 == 4)
			return -1;//success!
		else
			return (res1 + res2);

	}

 
	/**
	 * This method initialises the population of chromosomes.
	 * Loops through population one chromosome at a time and
	 * randomly creates chromosome values
	 */ 
	private static void initPopulation()
	{
		Population p = new Population(30);
		
int i=0;
		
		for (Chromosome c: p.population){
			
			for (int j=0;j<10;j++){	
				population[i][j] = c.getChromosome()[j];
			}
				
//			for (int j=0;j<10;j++)
//			System.out.print(population[i][j]);
			
			i++;
//			System.out.println();
		}
		
	}

	/**
	 * this method returns a random number n such that
	 * n is between 0.0 to 1.0
	 *
	 * @return a random number n between 0.0 to 1.0
	 */
	public static double randomDouble()
	{
		Random r = new Random();
		return r.nextInt(1000) / 1000.0;
	}

	
	/** 
	 * Returns the max element in a double array
	 * @param a an array of doubles        
	 * @return the max element in this double array
	 */
	public static double max(double[] a) {
		double max = a[0];   // assume fst element is the max
		//compare against remaining elements
		for (int i=1; i<a.length; i++) {
			if (a[i] > max) {
				max = a[i];   // new max
			}
		}
		return max;
	}

	/** 
	 * Finds and Returns the Euclidean distance between 2 Points
	 * @param p1 the 1st point
	 * @param p2 the 2nd point
	 * @return the Euclidean distance between the 2 Points
	 */
	public static double findDistance (Point p1, Point p2){
		int xDiff = p1.getX() - p2.getX();
		int yDiff = p1.getY() - p2.getY();
		double dist = Math.pow(xDiff, 2) + Math.pow(yDiff, 2);      
		double distance = Math.sqrt( dist );
		return distance;
	}

	
	/** 
	 * Returns the min element in a double array
	 * @param a an array of doubles        
	 * @return the min element in this double array
	 */
	public static double min(double[] a) {
		double min = a[0];   // assume fst element is the min
		//compare against remaining elements
		for (int i=1; i<a.length; i++) {
			if (a[i] < min) {
				min = a[i];   // new min
			}
		}
		return min;
	}


	
	/** 
	 * Computes the dot product AB . AC
	 * @param pointA the first coordinate of the line segment
	 * @param pointB the second coordinate of the line segment
	 * @param pointC the point in question
	 * @return the dot product AB . AC
	 */
	private static double DotProduct(Point pointA, Point pointB, Point pointC)
	{    
		int AB0 = pointB.getX() - pointA.getX();
		int AB1 = pointB.getY() - pointA.getY();
		int BC0 = pointC.getX() - pointB.getX();
		int BC1 = pointC.getY() - pointB.getY();
		double dot = AB0 * BC0 + AB1 * BC1;

		return dot;
	}


	
	/** 
	 * Computes the cross product AB x AC
	 * @param pointA the first coordinate of the line segment
	 * @param pointB the second coordinate of the line segment
	 * @param pointC the point in question
	 * @return the cross product AB x AC
	 */
	private static double CrossProduct(Point pointA, Point pointB, Point pointC)
	{    
		int AB0 = pointB.getX() - pointA.getX();
		int AB1 = pointB.getY() - pointA.getY();
		int AC0 = pointC.getX() - pointA.getX();
		int AC1 = pointC.getY() - pointA.getY();
		double cross = AB0 * AC1 - AB1 * AC0;

		return cross;
	}


	
	/** 
	 * Computes the distance between line AB to a point C
	 * if isSegment is true, AB is a segment, not a line.
	 * @param pointA the first coordinate of the line segment
	 * @param pointB the second coordinate of the line segment
	 * @param pointC the point in question
	 * @return the distance between line AB to the point C
	 */ 
	static double LineToPointDistance2D(Point pointA, Point pointB, Point pointC, boolean isSegment)
	{
		double dist = CrossProduct(pointA, pointB, pointC) / findDistance(pointA, pointB);
		if (isSegment)
		{
			double dot1 = DotProduct(pointA, pointB, pointC);
			if (dot1 > 0) 
				return findDistance(pointB, pointC);

			double dot2 = DotProduct(pointB, pointA, pointC);
			if (dot2 > 0) 
				return findDistance(pointA, pointC);
		}
		return Math.abs(dist);
	} 

	
	/** 
	 * Finds furthest points in 2 line segments
	 * @param ls1 the first line segment
	 * @param ls2 the second line segment
	 * @return an array of Points (having the two furthest points)
	 */
	public static Point[] findTwoFurthestPoints (Dash ls1, Dash ls2){
		//points of line seg 1
		Point p1ls1 = ls1.getP1();
		Point p2ls1 = ls1.getP2();
		//points of line seg 2
		Point p1ls2 = ls2.getP1();
		Point p2ls2 = ls2.getP2();
		//find distances between line points of diff line segs
		double d1 = findDistance (p1ls1, p1ls2);//p1 on ls1 and p1 on ls2
		double d2 = findDistance (p1ls1, p2ls2);
		double d3 = findDistance (p2ls1, p1ls2);
		double d4 = findDistance (p2ls1, p2ls2);
		double[] a = {d1,d2,d3,d4};
		double maxDist = max(a);//find highest distance
		//now find furthest 2 points
		Point fp1, fp2;
		if(maxDist == d1){
			fp1 = new Point(p1ls1.getX(),p1ls1.getY());
			fp2 = new Point(p1ls2.getX(),p1ls2.getY());
		} else
			if(maxDist == d2){
				fp1 = new Point(p1ls1.getX(),p1ls1.getY());
				fp2 = new Point(p2ls2.getX(),p2ls2.getY());
			} else
				if(maxDist == d3){
					fp1 = new Point(p2ls1.getX(),p2ls1.getY());
					fp2 = new Point(p1ls2.getX(),p1ls2.getY());
				} else             
					fp1 = new Point(p2ls1.getX(),p2ls1.getY());
		fp2 = new Point(p2ls2.getX(),p2ls2.getY());


		Point[] p = {fp1,fp2};
		return p;
	}

	
	/** 
	 * Checks whether 2 Line Segs are colinear
	 * finds the two furthest points of the 2 line segs, creates an imaginary line
	 * measure the dist between the other 2 points and this line
	 * compares the distance against radius of colinearity roc
	 * @param ls1 the 1st Dash
	 * @param ls2 the 1st Dash
	 *
	 * @return true or false
	 */
	public static boolean colinearDashes (Dash ls1, Dash ls2){
		//find the furthest 2 points in the line segments
		Point[] fPoints = findTwoFurthestPoints (ls1, ls2);
		Point fp1 = fPoints[0]; Point fp2 = fPoints[1];
		//find dist between al points and the line seg connecting the 2 furthest points
		Point p1 = ls1.getP1(); Point p2 = ls1.getP2();
		Point p3 = ls2.getP1(); Point p4 = ls2.getP2();
		double d1 = LineToPointDistance2D(fp1, fp2, p1, true);
		double d2 = LineToPointDistance2D(fp1, fp2, p2, true);
		double d3 = LineToPointDistance2D(fp1, fp2, p3, true);
		double d4 = LineToPointDistance2D(fp1, fp2, p4, true);
		//if all distances are <= roc then the two line segs are colinear
		if(d1 <= roc && d2 <= roc && d3 <= roc && d4 <= roc)//{     
			return true;   
		else
			return false;
	}


	
	/** 
	 * Checks whether 2 Line Segs are adjacent
	 * measures the distance between the 2 nearest point from the 2 Line segs
	 * compares the distance against dash separation!
	 * @param ls1 the 1st Dash
	 * @param ls2 the 1st Dash
	 *
	 * @return true or false
	 */
	public static boolean adjacentDashes (Dash ls1, Dash ls2){
		//if the shortest distance between endpoints of dashes < dash_separation
		//then the two dashes are adjacent
		//points of line seg 1
		Point p1ls1 = ls1.getP1();
		Point p2ls1 = ls1.getP2();
		//points of line seg 2
		Point p1ls2 = ls2.getP1();
		Point p2ls2 = ls2.getP2();
		//find distances between line points of diff line segs
		double d1 = findDistance (p1ls1, p1ls2);//p1 on ls1 and p1 on ls2
		double d2 = findDistance (p1ls1, p2ls2);
		double d3 = findDistance (p2ls1, p1ls2);
		double d4 = findDistance (p2ls1, p2ls2);

		if( d1 < dash_separation || d2 < dash_separation || d3 < dash_separation || d4 < dash_separation)//{    
			return true;
		else
			return false;      
	}


}


