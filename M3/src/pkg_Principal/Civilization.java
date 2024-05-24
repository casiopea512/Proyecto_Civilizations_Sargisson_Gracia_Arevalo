package pkg_Principal;

import java.util.ArrayList;


import exceptions.ResourceException;
import interfaces.MilitaryUnit;
import interfaces.Variables;
import pkg_AttackUnit.Cannon;
import pkg_AttackUnit.Crossbow;
import pkg_AttackUnit.Spearman;
import pkg_AttackUnit.Swordsman;
import pkg_DefenseUnit.ArrowTower;
import pkg_DefenseUnit.Catapult;
import pkg_DefenseUnit.RocketLauncherTower;
import pkg_SpecialUnit.Magician;
import pkg_SpecialUnit.Priest;



public class Civilization implements Variables {
	
	private String name;
	private String username;
	
	private int wood;
	private int iron;
	private int food;
	private int mana;

	private int magicTower;
	private int church;
	private int farm;
	private int smithy;
	private int carpentry;
	
	private int technologyDefense;
	private int technologyAttack;

	private int battles;

	private ArrayList<MilitaryUnit>[] army = new ArrayList[9];//ES DE 8 O DE 9(SOLO HAY NUEVE UNIDADES Y EL 0 SE CUENTA)

	private int timeLeft;

	//constructor
	public Civilization(String name, String username, int wood, int iron, int food, int mana, int magicTower,
			int church, int farm, int smithy, int carpentry, int technologyDefense, int technologyAttack, int battles, int timeLeft) {
		super();
		this.name = name;
		this.username = username;
		this.wood = wood;
		this.iron = iron;
		this.food = food;
		this.mana = mana;
		this.magicTower = magicTower;
		this.church = church;
		this.farm = farm;
		this.smithy = smithy;
		this.carpentry = carpentry;
		this.technologyDefense = technologyDefense;
		this.technologyAttack = technologyAttack;
		this.battles = battles;
		
		// Inicializar todas las listas en el arreglo army
		for (int i = 0; i < army.length; i++) {
			army[i] = new ArrayList<>();
		}

		this.timeLeft = timeLeft;
	}
	
	
	//set/get
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public int getWood() {
		return wood;
	}



	public void setWood(int wood) {
		this.wood = wood;
	}



	public int getIron() {
		return iron;
	}



	public void setIron(int iron) {
		this.iron = iron;
	}



	public int getFood() {
		return food;
	}



	public void setFood(int food) {
		this.food = food;
	}



	public int getMana() {
		return mana;
	}



	public void setMana(int mana) {
		this.mana = mana;
	}



	public int getMagicTower() {
		return magicTower;
	}



	public void setMagicTower(int magicTower) {
		this.magicTower = magicTower;
	}



	public int getChurch() {
		return church;
	}



	public void setChurch(int church) {
		this.church = church;
	}



	public int getFarm() {
		return farm;
	}



	public void setFarm(int farm) {
		this.farm = farm;
	}



	public int getSmithy() {
		return smithy;
	}



	public void setSmithy(int smithy) {
		this.smithy = smithy;
	}



	public int getCarpentry() {
		return carpentry;
	}



	public void setCarpentry(int carpentry) {
		this.carpentry = carpentry;
	}



	public int getTechnologyDefense() {
		return technologyDefense;
	}



	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}



	public int getTechnologyAttack() {
		return technologyAttack;
	}



	public void setTechnologyAttack(int technologyAttack) {
		this.technologyAttack = technologyAttack;
	}



	public int getBattles() {
		return battles;
	}



	public void setBattles(int battles) {
		this.battles = battles;
	}



	public ArrayList<MilitaryUnit>[] getArmy() {
		return army;
	}



	public void setArmy(ArrayList<MilitaryUnit>[] army) {
		this.army = army;
	}
	
	public int getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

//metodos

	//metodo para construir iglesia
	public void newChurch() throws ResourceException {
		//aseguramos que se tengan los recursos 
		if (getFood() >= FOOD_COST_CHURCH && getWood() >= WOOD_COST_CHURCH &&
				getIron()>= IRON_COST_CHURCH && getMana()>10000 ) {
			//resto recursos
			this.setFood(food-FOOD_COST_CHURCH);
			this.setWood(wood-WOOD_COST_CHURCH);
			this.setIron(iron-IRON_COST_CHURCH);
			this.setMana(mana-10000);// no hay variable para mana
			this.church+= 1;//suma una 

		}else {
			throw new ResourceException("You do not have enough resources to build a Church");//se controla la falta de recursos
		}
	}
	

	//metodo para construir torre magica
	public void newMagicTower() throws ResourceException {
		//aseguramos que se tengan los recursos 
		if (getFood() >= FOOD_COST_MAGICTOWER && getWood() >= WOOD_COST_MAGICTOWER &&
				getIron()>= IRON_COST_MAGICTOWER ){
			//resto recursos
			this.setFood(food-FOOD_COST_MAGICTOWER);
			this.setWood(wood-WOOD_COST_MAGICTOWER);
			this.setIron(iron-IRON_COST_MAGICTOWER);
			this.magicTower += 1;//suma una 
			this.setMana(mana+CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER);//incremento en mana
		} else {
			//se controla la falta de recursos
			throw new ResourceException("You do not have enough resources to build a Magic Tower");
		}

	}

	public void newFarm() throws ResourceException {
		//aseguramos que se tengan los recursos 
		if (getFood() >= FOOD_COST_FARM && getWood() >= WOOD_COST_FARM &&
				getIron()>= IRON_COST_FARM){
			//resto recursos
			this.setFood(food-FOOD_COST_FARM);
			this.setWood(wood-WOOD_COST_FARM);
			this.setIron(iron-IRON_COST_FARM);
			this.farm += 1;//suma una farm
			this.setFood(food+CIVILIZATION_FOOD_GENERATED_PER_FARM);//incremento en food
		} else {
			//se controla la falta de recursos
			throw new ResourceException("You do not have enough resources to build a Farm");
		}

	}

	public void newCarpentry() throws ResourceException {
		//aseguramos que se tengan los recursos 
		if (getFood() >= FOOD_COST_CARPENTRY && getWood() >= WOOD_COST_CARPENTRY &&
				getIron()>= IRON_COST_CARPENTRY){
			//resto recursos
			this.setFood(food-FOOD_COST_CARPENTRY);
			this.setWood(wood-WOOD_COST_CARPENTRY);
			this.setIron(iron-IRON_COST_CARPENTRY);
			this.carpentry += 1;//suma una farm
			this.setWood(wood+CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY);//incremento en wood
		} else {
			//se controla la falta de recursos
			throw new ResourceException("You do not have enough resources to build a Carpentry");
		}


	}

	public void newSmithy() throws ResourceException {
		//aseguramos que se tengan los recursos 
		if (getFood() >= FOOD_COST_SMITHY && getWood() >= WOOD_COST_SMITHY &&
				getIron()>= IRON_COST_SMITHY){
			//resto recursos
			this.setFood(food-FOOD_COST_SMITHY);
			this.setWood(wood-WOOD_COST_SMITHY);
			this.setIron(iron-IRON_COST_SMITHY);
			this.smithy += 1;//suma una farm
			this.setIron(iron + CIVILIZATION_IRON_GENERATED_PER_SMITHY);//incremento del 5%
		} else {
			//se controla la falta de recursos
			throw new ResourceException("You do not have enough resources to build a Smithy");
		}

	}


	public void upgradeTechnologyDefense() throws ResourceException {
		if (technologyDefense == 0) {//se paga el valor tec inicial
			if (getWood() >= UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST &&
				getIron()>= UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST){
				//resta recursos				
				this.setWood(wood-UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST);
				this.setIron(iron-UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST);
				this.technologyDefense+= 1;//sumamos uno

			}else {
				//se controla la falta de recursos
				throw new ResourceException("You do not have resources to improve your Defense Technology");
			}
		}else {//se calcula la cantidad a pagar dependiendo del nivel tec
			if (getWood() >= (UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST + (technologyDefense * UPGRADE_PLUS_DEFENSE_TECHNOLOGY_WOOD_COST * UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST/100)) &&
				getIron()>= (UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST + (technologyDefense * UPGRADE_PLUS_DEFENSE_TECHNOLOGY_IRON_COST * UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST/100))){
				this.technologyDefense+= 1;//sumamos uno
				//resta recursos con aumento segun nivel				
				this.setWood(wood-(UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST + (technologyDefense * UPGRADE_PLUS_DEFENSE_TECHNOLOGY_WOOD_COST * UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST/100)));
				this.setIron(iron-(UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST + (technologyDefense * UPGRADE_PLUS_DEFENSE_TECHNOLOGY_IRON_COST * UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST/100)));

			}else {
				//se controla la falta de recursos
				throw new ResourceException("You do not have resources to improve your Defense Technology");
			}

		}

	}
	
	

	public void upgradeTechnologyAttack() throws ResourceException {
		if (technologyAttack == 0) {//se paga el valor tec inicial
			if (getWood() >= UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST &&
					getIron()>= UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST){
				//resta recursos				
				this.setWood(wood-UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST);
				this.setIron(iron-UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST);
				this.technologyAttack+= 1;//sumamos uno

			}else {
				//se controla la falta de recursos
				throw new ResourceException("You do not have resources to improve your Attack Technology");
			}
		}else {//se calcula la cantidad a pagar dependiendo del nivel tec
			if (getWood() >= (UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST + (technologyAttack * UPGRADE_PLUS_ATTACK_TECHNOLOGY_WOOD_COST * UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST/100)) &&
					getIron()>= (UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST + (technologyAttack * UPGRADE_PLUS_ATTACK_TECHNOLOGY_IRON_COST * UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST/100))){
				this.technologyAttack+= 1;//sumamos uno
				//resta recursos segun nivel tec				
				this.setWood(wood-(UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST + (technologyAttack * UPGRADE_PLUS_ATTACK_TECHNOLOGY_WOOD_COST * UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST/100)));
				this.setIron(iron-(UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST + (technologyAttack * UPGRADE_PLUS_ATTACK_TECHNOLOGY_IRON_COST * UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST/100)));
			
			} else {
				//se controla la falta de recursos
				throw new ResourceException("You do not have resources to improve your Attack Technology");
			}

		}

	}




	public void newSwordsman(int n) throws ResourceException {

		for (int i = 0; i < n; i++) { 
			//comprobar si tenemos los recursos unidad a unidad
			if (getFood() >= FOOD_COST_SWORDSMAN && getWood() >= WOOD_COST_SWORDSMAN &&
					getIron()>= IRON_COST_SWORDSMAN){
				//se resta los recursos de la unidad creada
				this.setFood(food-FOOD_COST_SWORDSMAN);
				this.setWood(wood-WOOD_COST_SWORDSMAN);
				this.setIron(iron-IRON_COST_SWORDSMAN);
				//se crean variables de creacion de uni
				int newArmor = ARMOR_SWORDSMAN+(getTechnologyDefense()*
						PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY)*ARMOR_SWORDSMAN/100;
				int newDamage = BASE_DAMAGE_SWORDSMAN+(getTechnologyAttack()*
						PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY)*BASE_DAMAGE_SWORDSMAN/100;
				Swordsman newSwordsman = new Swordsman(newArmor,newDamage);//se pasa las variables con los valores
				army[0].add(newSwordsman);//se añade al array que le pertoca

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Swordsman, has been created "+i);
			}


		}
	}

	public void newSpearman(int n) throws ResourceException {
		for (int i = 0; i < n; i++) { 
			if (getFood() >= FOOD_COST_SPEARMAN && getWood() >= WOOD_COST_SPEARMAN &&
					getIron()>= IRON_COST_SPEARMAN){
				this.setFood(food-FOOD_COST_SPEARMAN);
				this.setWood(wood-WOOD_COST_SPEARMAN);
				this.setIron(iron-IRON_COST_SPEARMAN);
				int newArmor = ARMOR_SPEARMAN+(getTechnologyDefense()*
						PLUS_ARMOR_SPEARMAN_BY_TECHNOLOGY)*ARMOR_SPEARMAN/100;
				int newDamage = BASE_DAMAGE_SPEARMAN+(getTechnologyAttack()*
						PLUS_ARMOR_SPEARMAN_BY_TECHNOLOGY)*BASE_DAMAGE_SPEARMAN/100;
				Spearman newSpearman = new Spearman(newArmor,newDamage);
				army[1].add(newSpearman);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Spearman, has been created "+i);
			}
		}
	}

	public void newCrossbow(int n) throws ResourceException {
		for (int i = 0; i < n; i++) { 
			if ( getWood() >= WOOD_COST_CROSSBOW &&
					getIron()>= IRON_COST_CROSSBOW){
				this.setWood(wood-WOOD_COST_CROSSBOW);
				this.setIron(iron-IRON_COST_CROSSBOW);
				int newArmor = ARMOR_CROSSBOW+(getTechnologyDefense()*
						PLUS_ARMOR_CROSSBOW_BY_TECHNOLOGY)*ARMOR_CROSSBOW/100;
				int newDamage = BASE_DAMAGE_CROSSBOW+(getTechnologyAttack()*
						PLUS_ARMOR_CROSSBOW_BY_TECHNOLOGY)*BASE_DAMAGE_CROSSBOW/100;
				Crossbow newCrossbow = new Crossbow(newArmor,newDamage);
				army[2].add(newCrossbow);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Crossbow, has been created "+i);
			}
		}
	}


	public void newCannon(int n) throws ResourceException {
		for (int i = 0; i < n; i++) { 
			if (getWood() >= WOOD_COST_CANNON &&
					getIron()>= IRON_COST_CANNON){
				this.setWood(wood-WOOD_COST_CANNON);
				this.setIron(iron-IRON_COST_CANNON);
				int newArmor = ARMOR_CANNON+(getTechnologyDefense()*
						PLUS_ARMOR_CANNON_BY_TECHNOLOGY)*Variables.ARMOR_CANNON/100;
				int newDamage = BASE_DAMAGE_CANNON+(getTechnologyAttack()*
						PLUS_ARMOR_CANNON_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_CANNON/100;
				Cannon newCannon = new Cannon(newArmor,newDamage);
				army[3].add(newCannon);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Cannon, has been created "+i);
			}
		}
	}


	public void newArrowTower(int n) throws ResourceException {

		for (int i = 0; i < n; i++) { 
			if (getWood() >= WOOD_COST_ARROWTOWER){
				this.setWood(wood-WOOD_COST_ARROWTOWER);
				int newArmor = ARMOR_ARROWTOWER+(getTechnologyDefense()*
						PLUS_ARMOR_ARROWTOWER_BY_TECHNOLOGY)*ARMOR_ARROWTOWER/100;
				int newDamage = BASE_DAMAGE_ARROWTOWER+(getTechnologyAttack()*
						PLUS_ARMOR_ARROWTOWER_BY_TECHNOLOGY)*BASE_DAMAGE_ARROWTOWER/100;
				ArrowTower newArrowTower = new ArrowTower(newArmor,newDamage);
				army[4].add(newArrowTower);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" ArrowTower, has been created "+i);
			}
		}
	}


	public void newCatapult(int n) throws ResourceException {

		for (int i = 0; i < n; i++) { 
			if (getWood() >= WOOD_COST_CATAPULT && getIron()>= IRON_COST_CATAPULT){
				this.setWood(wood-WOOD_COST_CATAPULT);
				this.setIron(iron-IRON_COST_CATAPULT);
				int newArmor = ARMOR_CATAPULT+(getTechnologyDefense()*
						PLUS_ARMOR_CATAPULT_BY_TECHNOLOGY)*ARMOR_CATAPULT/100;
				int newDamage = BASE_DAMAGE_CATAPULT +(getTechnologyAttack()*
						PLUS_ARMOR_CATAPULT_BY_TECHNOLOGY)*BASE_DAMAGE_CATAPULT/100;
				Catapult newCatapult = new Catapult(newArmor,newDamage);
				army[5].add(newCatapult);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Catapult, has been created "+i);
			}
		}
	}


	public void newRocketLauncherTower(int n) throws ResourceException {

		for (int i = 0; i < n; i++) { 
			if (getWood() >= WOOD_COST_ROCKETLAUNCHERTOWER && getIron()>= IRON_COST_ROCKETLAUNCHERTOWER){
				this.setWood(wood-WOOD_COST_ROCKETLAUNCHERTOWER);
				this.setIron(iron-IRON_COST_ROCKETLAUNCHERTOWER);
				int newArmor = ARMOR_ROCKETLAUNCHERTOWER +(getTechnologyDefense()*
						PLUS_ARMOR_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY)*ARMOR_ROCKETLAUNCHERTOWER/100;
				int newDamage = BASE_DAMAGE_ROCKETLAUNCHERTOWER +(getTechnologyAttack()*
						PLUS_ARMOR_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY)*BASE_DAMAGE_ROCKETLAUNCHERTOWER/100;
				RocketLauncherTower newRocketLauncher = new RocketLauncherTower(newArmor,newDamage);
				army[6].add(newRocketLauncher);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" RocketLauncher, has been created "+i);
			}
		}
	}



	public void newMagician(int n) throws ResourceException {


		for (int i = 0; i < n; i++) { 
			if (getFood() >= FOOD_COST_MAGICIAN && getWood() >= WOOD_COST_MAGICIAN &&
					getIron()>= IRON_COST_MAGICIAN &&
					getMana()>= MANA_COST_MAGICIAN){
				this.setWood(wood-FOOD_COST_MAGICIAN);
				this.setFood(food-WOOD_COST_MAGICIAN);
				this.setIron(mana-IRON_COST_MAGICIAN);
				this.setMana(mana-MANA_COST_MAGICIAN);
				int newArmor = 0;
				int newDamage = BASE_DAMAGE_MAGICIAN +(getTechnologyAttack()*
						PLUS_ARMOR_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY)* BASE_DAMAGE_MAGICIAN/100;
				Magician newMagician = new Magician(newArmor,newDamage);
				army[7].add(newMagician);

			} else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Magician, has been created "+i);
			}
		}
	}


	public void newPriest(int n) throws ResourceException {
		for (int i = 0; i < n; i++) { 
			if (getFood() >= FOOD_COST_PRIEST && getMana()>= MANA_COST_PRIEST){
				this.setFood(food-FOOD_COST_PRIEST);
				this.setMana(mana-MANA_COST_PRIEST);
				int newArmor = 0;
				int newDamage = 0;
				Priest newPriest = new Priest(newArmor,newDamage);
				army[8].add(newPriest);
			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Magician, has been created "+i);

			}
		}
	}

	public void printStats() {

		System.out.println("           ******************************CIVILIZATION STATE******************************           ");
		System.out.println();
		System.out.println("----------------------------------------------TECHNOLOGY----------------------------------------------");
		System.out.println();
		System.out.printf("%80s%22s%n", "Attack","Defense" );
		System.out.printf("%80d%22d%n", getTechnologyDefense(), getTechnologyAttack());
		System.out.println();
		System.out.println("----------------------------------------------BUILDINGS-----------------------------------------------");
		System.out.println();
		System.out.printf("%14s%22s%22s%22s%22s%n", "Farm","Smithy","Carpentry","Magic Tower","Church" );
		System.out.printf("%14s%22s%22s%22s%22s%n", getFarm(), getSmithy(), getCarpentry(), getMagicTower(), getChurch());
		System.out.println();
		System.out.println("----------------------------------------------DEFENSES------------------------------------------------");
		System.out.println();
		System.out.printf("%58s%22s%22s%n", "Arrow Tower","Catapult","Rocket Launcher" );
		System.out.printf("%58s%22s%22s%n", army[4].size(), army[5].size(), army[6].size());
		System.out.println();
		System.out.println("----------------------------------------------ATTACK UNITS--------------------------------------------");
		System.out.println();
		System.out.printf("%36s%22s%22s%22s%n", "Swordsman","Spearman","Crosswob","Cannon");
		System.out.printf("%36s%22s%22s%22s%n", army[0].size(), army[1].size(), army[2].size(), army[3].size());
		System.out.println();
		System.out.println("----------------------------------------------ESPECIAL UNITS------------------------------------------");
		System.out.println();
		System.out.printf("%80s%22s%n", "Mague","Priest" );
		System.out.printf("%80d%22d%n", army[7].size(), army[8].size());
		System.out.println();
		System.out.println("----------------------------------------------RESOURCES-----------------------------------------------");
		System.out.println();
		System.out.printf("%36s%22s%22s%22s%n", "Food","Wood","Iron","Mana");
		System.out.printf("%36s%22s%22s%22s%n", (int)getFood(), (int)getWood(), (int)getIron(), (int)getMana());
		System.out.println();
		System.out.println("----------------------------------------------GENERATION RESOURCES------------------------------------");
		System.out.println();
		System.out.printf("%36s%22s%22s%22s%n", "Food","Wood","Iron","Mana");
		System.out.printf("%36s%22s%22s%22s%n", (int)(getFood()*0.05)*getFarm(), (int)(getWood()*0.05)*getCarpentry(), (int)(getIron()*0.05)*getSmithy(), (int)3000*getChurch());
	}
	
	

}
