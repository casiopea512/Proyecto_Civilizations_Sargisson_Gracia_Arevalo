package pkg_AttackUnit;

import interfaces.MilitaryUnit;
import interfaces.Variables;

public class Spearman extends AttackUnit implements MilitaryUnit, Variables {
		
		// valores del constructor: int armor, int initialArmor, int baseDamage, boolean sanctified
	  	// Constructor1
		public Spearman(int armor, int baseDamage) {
		    super(armor, armor, baseDamage); // Llamada al constructor de la clase padre
		}
	
	    //constructor2
		public Spearman() {
			super(ARMOR_SPEARMAN, ARMOR_SPEARMAN, BASE_DAMAGE_SPEARMAN);
			
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

	    public int getFoodCost() {
	        return FOOD_COST_SPEARMAN;
	    }

	    public int getWoodCost() {
	        return WOOD_COST_SPEARMAN;
	    }
	    
	    public int getIronCost() {
	        return IRON_COST_SPEARMAN;
	    }

	    public int getManaCost() {
	        return MANA_COST_SPEARMAN;
	    }

	    public int getChanceGeneratinWaste() {
	        return CHANCE_GENERATNG_WASTE_SPEARMAN;
	    }

	    public int getChanceAttackAgain() {
	        return CHANCE_ATTACK_AGAIN_SPEARMAN;
	    }

	    public void resetArmor() {
	        this.setArmor(this.getInitialArmor()); // Restablecer la armadura a su valor inicial
	    }

}
