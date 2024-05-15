package pkg_DefenseUnit;

import interfaces.MilitaryUnit;
import interfaces.Variables;

public class Catapult extends DefenseUnit {
	
	public Catapult(int armor, int baseDamage) {
	    super(armor, armor, baseDamage); // Llamada al constructor de la clase padre
	}
	
	// IMPLEMENTACION INTERFAZ MilitaryUnit
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
    	return "Catapult";
    }

    public int getFoodCost() {
        return FOOD_COST_CATAPULT;
    }

    public int getWoodCost() {
        return WOOD_COST_CATAPULT;
    }

    public int getIronCost() {
        return IRON_COST_CATAPULT;
    }

    public int getManaCost() {
        return MANA_COST_CATAPULT;
    }

    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATNG_WASTE_CATAPULT;
    }

    public int getChanceAttackAgain() {
        return CHANCE_ATTACK_AGAIN_CATAPULT;
    }

    public void resetArmor() {
        this.setArmor(this.getInitialArmor()); // Restablecer la armadura a su valor inicial
    }
}

