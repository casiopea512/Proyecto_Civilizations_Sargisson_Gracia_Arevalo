package pkg_SpecialUnit;

import interfaces.MilitaryUnit;

public class Priest extends SpecialUnit {
	
	//constructores
	// ARMOR SIEMBRE TIENE QUE SER 0
	public Priest(int armor, int baseDamage) {
	    super(armor, armor, baseDamage); // Llamada al constructor de la clase padre
	}
	
    public int attack() {
        return this.getBaseDamage(); // Obtener el daño base
    }

    public void takeDamage(int receivedDamage) {
        int currentArmor = this.getArmor(); // Obtener la armadura actual
        currentArmor -= receivedDamage; // Reducir la armadura según el daño recibido
        if (currentArmor < 0) {
            currentArmor = 0;
        }
        this.setArmor(currentArmor); // Establecer la nueva armadura
    }

    public int getActualArmor() {
        return this.getArmor(); // Obtener la armadura actual
    }
    public String getName() {
    	return "Priest";
    }

    public int getFoodCost() {
        return FOOD_COST_PRIEST;
    }

    public int getWoodCost() {
        return WOOD_COST_PRIEST;
    }

    public int getIronCost() {
        return IRON_COST_PRIEST;
    }

    public int getManaCost() {
        return MANA_COST_PRIEST;
    }

    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATNG_WASTE_PRIEST;
    }

    public int getChanceAttackAgain() {
        return CHANCE_ATTACK_AGAIN_PRIEST;
    }

    public void resetArmor() {
        this.setArmor(this.getInitialArmor()); // Restablecer la armadura a su valor inicial
    }
	

}