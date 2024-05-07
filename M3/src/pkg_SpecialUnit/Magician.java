package pkg_SpecialUnit;

import interfaces.MilitaryUnit;

public class Magician extends SpecialUnit implements MilitaryUnit {

	//constructores
	// Armor siempre tiene que 0
	public Magician(int armor, int baseDamage) {
	    super(armor, armor, baseDamage); // Llamada al constructor de la clase padre
	}
	
	

}
