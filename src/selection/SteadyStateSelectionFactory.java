package selection;

/**
 * A factory for creating SteadyStateSelection objects.
 */
public class SteadyStateSelectionFactory extends SelectionFactory {
	

	 /**
 	 * Instantiates a new steady state selection factory.
 	 *
 	 * @param p the population
 	 */
 	public SteadyStateSelectionFactory(int[][] p) {
 			this.setP(p);
		}
	
	/* (non-Javadoc)
	 * @see selection.SelectionFactory#createselection()
	 */
	@Override
	public Selection createselection() {
		selection = SteadyStateSelection.getSteadyStateSelectionInstance(getP());
		selection.setParents(selection.selection());
		return selection;
	}
	
	

}
