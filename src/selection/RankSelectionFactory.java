package selection;

/**
 * A factory for creating RankSelection objects.
 */
public class RankSelectionFactory extends SelectionFactory {
	

	/**
	 * Instantiates a new rank selection factory.
	 *
	 * @param p the population
	 */
	public RankSelectionFactory(int[][] p) {
		this.setP(p);
	}

	/* (non-Javadoc)
	 * @see selection.SelectionFactory#createselection()
	 */
	@Override
	public Selection createselection() {
		selection = RankSelection.getRankSelectionInstance(getP());
		selection.setParents(selection.selection());
		return selection;
	}

}
