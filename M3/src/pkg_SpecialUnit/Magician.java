package pkg_SpecialUnit;

import interfaces.MilitaryUnit;

public class Magician extends SpecialUnit implements MilitaryUnit {

	public Magician(int armor, int baseDamage) {
		super(armor,baseDamage);
		this.setInitialArmor(armor);//armadura inicial al crear uni
		this.setExperience(0);//batalla ganada +1
		
		
	}
	
	

}
