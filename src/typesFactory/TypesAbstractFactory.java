package typesFactory;

import types.Types;


/**
 * A factory for creating TypesAbstract objects.
 */
abstract public class TypesAbstractFactory {
	

	/**
	 * ChooseTypes method selects Types object randomly and return to GA.
	 *
	 * @return the types
	 */
	public abstract Types chooseTypes();

	
}
