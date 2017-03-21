package typesFactory;

import java.util.Random;

import types.Type01;
import types.Type02;
import types.Type03;
import types.Type04;
import types.Type05;
import types.Type06;
import types.Type07;
import types.Type08;
import types.Type09;
import types.Type10;
import types.Type11;
import types.Type12;
import types.Types;


/**
 * A factory for creating TypesConcrete objects.
 */
public class TypesConcreteFactory extends TypesAbstractFactory{

	/** The Types reference. */
	private Types type;
	
	/** The Random object which return random values based on the primitive type we give */
	private Random r = new Random();
	
	
	/* (non-Javadoc)
	 * @see typesFactory.TypesAbstractFactory#chooseTypes()
	 */
	@Override
	public
	Types chooseTypes() {
		int check = r.nextInt(11)+1;
		
		if(check>0){
		
		if(check==1)
			type = new Type01();
		if(check==2)
			type = new Type02();
		if(check==3)
			type = new Type03();
		if(check==4)
			type = new Type04();
		if(check==5)
			type = new Type05();
		if(check==6)
			type = new Type06();
		if(check==7)
			type = new Type07();
		if(check==8)
			type = new Type08();
		if(check==9)
			type = new Type09();
		if(check==10)
			type = new Type10();
		if(check==11)
			type = new Type11();
		if(check==12)
			type = new Type12();
		
		
		return type;
		}else return null;
		
	}

}
