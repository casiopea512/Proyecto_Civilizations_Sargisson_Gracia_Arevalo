package pkg_DefenseUnit;

import interfaces.MilitaryUnit;
import interfaces.Variables;

public class Catapult extends DefenseUnit implements MilitaryUnit, Variables{
	
	public Catapult(int armor, int baseDamage) {
	    super(armor, armor, baseDamage, false); // Llamada al constructor de la clase padre
	}
}

