package pkg_SpecialUnit;

import interfaces.MilitaryUnit;
import interfaces.Variables;

public class SpecialUnit implements MilitaryUnit, Variables {
	private int armor;//armadura restante
	private int initialArmor;//armadura inicial al crear uni
	private int baseDamage;//poder de ataque inicial
	private int experience;//batalla ganada +1
	
	//constructor
	public SpecialUnit(int armor, int baseDamage) {
		super();
		this.armor = armor;
		this.baseDamage = baseDamage;
	}
	
	
	

	public SpecialUnit() {
		
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

	//se borra el gerExp por el metodo que se ereda de MU

	public void setExperience(int experience) {
		this.experience = experience;
		
	}
	
	

	//metodos MilitaryUnit

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void takeDamage(int receivedDamage) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int getActualArmor() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int getFoodCost() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int getWoodCost() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int getIronCost() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int getManaCost() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void resetArmor() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void getExperience() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
