package pkg_DefenseUnit;

import interfaces.MilitaryUnit;
import interfaces.Variables;

// unidades militares defensivas

public class DefenseUnit implements MilitaryUnit, Variables {
	private int armor; //armadura restante
	private int initialArmor; //armadura inicial al crear uni
	private int baseDamage; //poder de ataque inicial
	private int experience; // experiencia que le mejorará los stats
	private boolean sanctified; // si esta o no santificado


	//constructores
	public DefenseUnit(int armor, int baseDamage) {
		super();
		this.armor = armor;
		this.baseDamage = baseDamage;
	}


	// getters - setters
	
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


	public boolean isSanctified() {
		return sanctified;
	}


	public void setSanctified(boolean sanctified) {
		this.sanctified = sanctified;
	}

	
	// Military Units

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


	public void setExperience(int n) {
		// TODO Auto-generated method stub
		
	}


	public void getExperience() {
		// TODO Auto-generated method stub
		
	}

}