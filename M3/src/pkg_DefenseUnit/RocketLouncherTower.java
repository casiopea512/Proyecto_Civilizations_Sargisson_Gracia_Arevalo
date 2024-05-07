package pkg_DefenseUnit;

import interfaces.MilitaryUnit;
import interfaces.Variables;

public class RocketLouncherTower extends DefenseUnit implements MilitaryUnit, Variables{

	public RocketLouncherTower(int armor, int baseDamage) {
	    super(armor, armor, baseDamage, false); // Llamada al constructor de la clase padre
	}
	
}

