package pkg_SpecialUnit;

import interfaces.MilitaryUnit;
import interfaces.Variables;

public class SpecialUnit implements MilitaryUnit, Variables {
	private int armor;//armadura restante
	private int initialArmor;//armadura inicial al crear uni
	private int baseDamage;//poder de ataque inicial
	private int experience;//batalla ganada +1
	
	// constructor
	// Armor / Initial_Armor siempre debe ser 0
	public SpecialUnit(int armor, int initialArmor, int baseDamage) {
		super();
		this.armor = armor;
		this.initialArmor = armor;
		this.baseDamage = baseDamage;
		this.experience = 0;
	}
	
	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getInitialArmor() {
		return initialArmor;
	}

	public void setInitialArmor(int initialArmor) {
		this.initialArmor = initialArmor;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
	public void setExperience(int experience) {
		this.experience = experience;
		
	}
	
	public int getExperience() {
		return this.experience;
	}

	
	//metodos MilitaryUnit
	
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void takeDamage(int receivedDamage) {
		// TODO Auto-generated method stub
		
	}

	public int getActualArmor() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getFoodCost() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getWoodCost() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getIronCost() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getManaCost() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void resetArmor() {
		// TODO Auto-generated method stub
		
	}

}
