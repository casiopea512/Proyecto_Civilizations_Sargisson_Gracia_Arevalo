package pkg_DefenseUnit;

import interfaces.MilitaryUnit;
import interfaces.Variables;

public class RocketLouncherTower extends DefenseUnit implements MilitaryUnit, Variables{

	public RocketLouncherTower(int armor, int baseDamage) {
		super(armor, baseDamage);
		
		// ME LA INVENTOOOOOOOOOO
		int nivelTechDefense = 2;
		
		// establecer la armadura
		int armorUnit = ARMOR_ARROWTOWER;
		int armorPlusUnit = PLUS_ARMOR_ARROWTOWER_BY_TECHNOLOGY;
		
		
		int armorTech = armorUnit + (nivelTechDefense * armorPlusUnit)*armorUnit/100;
		
		
		// establecer el poder de ataque baseDamage
		
	}
	
}

