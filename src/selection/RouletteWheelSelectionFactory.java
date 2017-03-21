package selection;

/**
 * A factory for creating RouletteWheelSelection objects.
 */
public class RouletteWheelSelectionFactory extends SelectionFactory {
	 
	 
	 /**
 	 * Instantiates a new roulette wheel selection factory.
 	 *
 	 * @param p the population
 	 */
 	public RouletteWheelSelectionFactory(int[][] p) {
 			this.setP(p);
		}

		/* (non-Javadoc)
		 * @see selection.SelectionFactory#createselection()
		 */
		@Override
		public Selection createselection() {
			selection = RouletteWheelSelection.getRouletteWheelSelectionInstance(getP());
			selection.setParents(selection.selection());
			return selection;
		}

}
