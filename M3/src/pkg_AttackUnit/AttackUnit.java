package pkg_AttackUnit;


import interfaces.MilitaryUnit;
import interfaces.Variables;

public abstract class AttackUnit implements MilitaryUnit, Variables {
	private int armor;//armadura restante
	private int initialArmor;//armadura inicial al crear uni
	private int baseDamage;//poder de ataque inicial
	private int experience;
	private boolean sanctified;// si esta o no
	
	//constructores
	
	
	public AttackUnit(int armor, int initialArmor, int baseDamage, int experience, boolean sanctified) {
		super();
		this.armor = armor;
		this.initialArmor = initialArmor;
		this.baseDamage = baseDamage;
		this.experience = experience;
		this.sanctified = sanctified;
	}
	
	public AttackUnit() {
		super();
	}

	//set and get

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
	
	
	
	

}
