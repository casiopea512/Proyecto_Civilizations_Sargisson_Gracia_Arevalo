package pkg_SpecialUnit;

import interfaces.MilitaryUnit;

public class Priest extends SpecialUnit implements MilitaryUnit {
	//constructores
	public Priest(int armor, int baseDamage) {
		super(armor,baseDamage);
		this.setInitialArmor(armor);//armadura inicial al crear uni
		this.setExperience(0);//batalla ganada +1
		
		
	}
	
	
	
	

}