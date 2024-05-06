package pkg_AttackUnit;

import interfaces.MilitaryUnit;
import interfaces.Variables;

public class Spearman extends AttackUnit implements MilitaryUnit, Variables {
	
	//CONSTRUCTORES EN PRUEBAS
    // Constructor1
	//PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY ==nivel de tecnologia
	public Spearman(int armor, int baseDamage) {
	    super(); // Llamada al constructor de la clase padre
	     // Obtener nivel de tecnología de defensa
	    int armorWithTech = armor + (armor * PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY / 100);
	    this.setArmor(armorWithTech); // Establecer la armadura con tecnología
	    this.setInitialArmor(armorWithTech); // Establecer la armadura inicial
	    int damageWithTech = baseDamage + (baseDamage * PLUS_ATTACK_SWORDSMAN_BY_TECHNOLOGY * PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY / 100);
	    this.setBaseDamage(damageWithTech); // Establecer el daño base con tecnología
	    this.setExperience(0); // Establecer la experiencia inicial
	    this.setSanctified(false); // Establecer si está santificado o no
	}

    //constructor2
	
	// Constructor adicional para Constructor 2
	public Spearman() {
	    super(); // Llamada al constructor de la clase padre
	    int armor = ARMOR_SWORDSMAN; // Obtener armadura base
	    int baseDamage = BASE_DAMAGE_SWORDSMAN; // Obtener daño base
	    this.setArmor(armor); // Establecer la armadura
	    this.setInitialArmor(armor); // Establecer la armadura inicial
	    this.setBaseDamage(baseDamage); // Establecer el daño base
	    this.setExperience(0); // Establecer la experiencia inicial
	    this.setSanctified(false); // Establecer si está santificado o no
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
        return FOOD_COST_SWORDSMAN;
    }

    @Override
    public int getWoodCost() {
        return WOOD_COST_SWORDSMAN;
    }

    @Override
    public int getIronCost() {
        return IRON_COST_SWORDSMAN;
    }

    @Override
    public int getManaCost() {
        return MANA_COST_SWORDSMAN;
    }

    @Override
    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATNG_WASTE_SWORDSMAN;
    }

    @Override
    public int getChanceAttackAgain() {
        return CHANCE_ATTACK_AGAIN_SWORDSMAN;
    }

    @Override
    public void resetArmor() {
        this.setArmor(this.getInitialArmor()); // Restablecer la armadura a su valor inicial
    }

//    experiencia existe como metodo abstracto y como atributo/////////////////////////////////////////
    
    public void setExperience(int n) {
        this.setExperience(n); // Establecer la experiencia
    }

    @Override
    public void getExperience() {
        this.getExperience(); // Obtener la experiencia
    }
}
