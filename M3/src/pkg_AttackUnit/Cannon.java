package pkg_AttackUnit;

import interfaces.MilitaryUnit;
import interfaces.Variables;

public class Cannon extends AttackUnit implements MilitaryUnit, Variables {
	
		// valores del constructor: int armor, int initialArmor, int baseDamage, boolean sanctified
	  	// Constructor1
		public Cannon(int armor, int baseDamage) {
		    super(armor, armor, baseDamage, false); // Llamada al constructor de la clase padre
		}
	
	    //constructor2
		public Cannon() {
			super(ARMOR_CANNON, ARMOR_CANNON, BASE_DAMAGE_CANNON, false);
			
		}
		

	    // Implementación de métodos de la interfaz MilitaryUnit
	    @Override
	    public int attack() {
	        return this.getBaseDamage(); // Obtener el daño base
	    }

	    @Override
	    public void takeDamage(int receivedDamage) {
	        int currentArmor = this.getArmor(); // Obtener la armadura actual
	        currentArmor -= receivedDamage; // Reducir la armadura según el daño recibido
	        if (currentArmor < 0) {
	            currentArmor = 0;
	        }
	        this.setArmor(currentArmor); // Establecer la nueva armadura
	    }

	    @Override
	    public int getActualArmor() {
	        return this.getArmor(); // Obtener la armadura actual
	    }

	    @Override
	    public int getFoodCost() {
	        return FOOD_COST_CANNON;
	    }

	    @Override
	    public int getWoodCost() {
	        return WOOD_COST_CANNON;
	    }

	    @Override
	    public int getIronCost() {
	        return IRON_COST_CANNON;
	    }

	    @Override
	    public int getManaCost() {
	        return MANA_COST_CANNON;
	    }

	    @Override
	    public int getChanceGeneratinWaste() {
	        return CHANCE_GENERATNG_WASTE_CANNON;
	    }

	    @Override
	    public int getChanceAttackAgain() {
	        return CHANCE_ATTACK_AGAIN_CANNON;
	    }

	    @Override
	    public void resetArmor() {
	        this.setArmor(this.getInitialArmor()); // Restablecer la armadura a su valor inicial
	    }

//			    experiencia existe como metodo abstracto y como atributo/////////////////////////////////////////
	    
	    public void setExperience(int n) {
	        this.setExperience(n); // Establecer la experiencia
	    }

	    @Override
	    public void getExperience() {
	        this.getExperience(); // Obtener la experiencia
	    }
	}
