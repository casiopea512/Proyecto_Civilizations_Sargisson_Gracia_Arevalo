package pkg_DefenseUnit;

import interfaces.MilitaryUnit;
import interfaces.Variables;


// unidades militares defensivas

public abstract class DefenseUnit implements MilitaryUnit, Variables {
	private int armor; //armadura restante
	private int initialArmor; //armadura inicial al crear uni
	private int baseDamage; //poder de ataque inicial
	private int experience; // experiencia que le mejorará los stats
	private boolean sanctified; // si esta o no santificado


	//constructores
	public DefenseUnit(int armor, int initialArmor, int baseDamage) {
		super();
		this.armor = armor;
		this.initialArmor = armor;
		this.baseDamage = baseDamage;
		this.experience = 0;
		this.sanctified = false;
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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public boolean isSanctified() {
		return sanctified;
	}

	public void setSanctified(boolean sanctified) {
		this.sanctified = sanctified;
	}

}