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



public class Civilization {
	private int technologyDefense;
	private int technologyAttack;

	private float wood;
	private float iron;
	private float food;
	private float mana;

	private int magicTower;
	private int church;
	private int farm;
	private int smithy;
	private int carpentry;

	private int battles;

	private ArrayList<MilitaryUnit>[] army = new ArrayList[9];//ES DE 8 O DE 9(SOLO HAY NUEVE UNIDADES Y EL 0 SE CUENTA)



	//constructor

	public Civilization(int technologyDefense, int technologyAttack, float wood, float iron, float food, float mana,
			int magicTower, int church, int farm, int smithy, int carpentry, int battles,
			ArrayList<MilitaryUnit>[] army) {
		super();
		this.technologyDefense = technologyDefense;
		this.technologyAttack = technologyAttack;
		this.wood = wood;
		this.iron = iron;
		this.food = food;
		this.mana = mana;
		this.magicTower = magicTower;
		this.church = church;
		this.farm = farm;
		this.smithy = smithy;
		this.carpentry = carpentry;
		this.battles = battles;

		// Inicializar todas las listas en el arreglo army
		for (int i = 0; i < army.length; i++) {
			army[i] = new ArrayList<>();
		}


		this.army = army;
	}

	//metodos

	public int getTechnologyDefense() {
		return technologyDefense;
	}



	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}



	public float getWood() {
		return wood;
	}




	public void setWood(float wood) {
		this.wood = wood;
	}




	public float getIron() {
		return iron;
	}




	public void setIron(float iron) {
		this.iron = iron;
	}




	public float getFood() {
		return food;
	}




	public void setFood(float food) {
		this.food = food;
	}




	public float getMana() {
		return mana;
	}




	public void setMana(float mana) {
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




	public int getBattles() {
		return battles;
	}




	public void setBattles(int battles) {
		this.battles = battles;
	}


	public int getTechnologyAttack() {
		return technologyAttack;
	}



	public void setTechnologyAttack(int technologyAttack) {
		this.technologyAttack = technologyAttack;
	}



	public ArrayList<MilitaryUnit>[] getArmy() {
		return army;
	}



	public void setArmy(ArrayList<MilitaryUnit>[] army) {
		this.army = army;
	}



	//metodo para construir iglesia
	void newChurch() throws ResourceException {
		//aseguramos que se tengan los recursos 
		if (getFood() > 10000 && getWood() > 20000 &&
				getIron()> 24000 && getMana()>10000 ) {
			//resto recursos
			this.setFood(food-10000);
			this.setWood(wood-20000);
			this.setIron(iron-24000);
			this.setMana(mana-10000);
			this.church+= 1;//suma una 

		}else {
			throw new ResourceException("You do not have enough resources to build a church");//se controla la falta de recursos
		}
	}
	//metodo para construir torre magica
	void newMagicTower() throws ResourceException {
		//aseguramos que se tengan los recursos 
		if (getFood() > 10000 && getWood() > 20000 &&
				getIron()> 24000 ){
			//resto recursos
			this.setFood(food-10000);
			this.setWood(wood-20000);
			this.setIron(iron-24000);
			this.magicTower+= 1;//suma una 
			this.setMana(mana+3000);//incremento en mana
		}else {
			//se controla la falta de recursos
			throw new ResourceException("You do not have enough resources to build a Magic Tower");
		}

	}

	void newFarm() throws ResourceException {
		//aseguramos que se tengan los recursos 
		if (getFood() > 5000 && getWood() > 10000 &&
				getIron()> 12000){
			//resto recursos
			this.setFood(food-5000);
			this.setWood(wood-10000);
			this.setIron(iron-12000);
			this.farm+= 1;//suma una farm
			this.setFood(food+(float)(food*0.05));//incremento en food
		}else {
			//se controla la falta de recursos
			throw new ResourceException("You do not have enough resources to build a Farm");
		}

	}

	void newCarpentry() throws ResourceException {
		//aseguramos que se tengan los recursos 
		if (getFood() > 5000 && getWood() > 10000 &&
				getIron()> 12000){
			//resto recursos
			this.setFood(food-5000);
			this.setWood(wood-10000);
			this.setIron(iron-12000);
			this.farm+= 1;//suma una farm
			this.setWood(wood+(float)(wood*0.05));//incremento en wood
		}else {
			//se controla la falta de recursos
			throw new ResourceException("You do not have enough resources to build a Carpentry");
		}


	}

	void newSmithy() throws ResourceException {
		//aseguramos que se tengan los recursos 
		if (getFood() > 5000 && getWood() > 10000 &&
				getIron()> 12000){
			//resto recursos
			this.setFood(food-5000);
			this.setWood(wood-10000);
			this.setIron(iron-12000);
			this.farm+= 1;//suma una farm
			this.setIron(iron + (float)(iron*0.05));//incremento del 5%
		}else {
			//se controla la falta de recursos
			throw new ResourceException("You do not have enough resources to build a Carpentry");
		}

	}


	void upgradeTechnologyDefense() throws ResourceException {
		if (technologyDefense == 0) {//se paga el valor tec inicial
			if (getFood() > 100 && getWood() > 200 &&
					getIron()> 2000){
				//resta recursos
				this.setFood(food-100);
				this.setWood(wood-200);
				this.setIron(iron-2000);
				this.technologyDefense+= 1;//sumamos uno

			}else {
				//se controla la falta de recursos
				throw new ResourceException("You do not have resources to improve your defense technology");
			}
		}else {//se calcula la cantidad a pagar dependiendo del nivel tec
			if (getFood() > 100 + 100*(0.1*technologyDefense) && getWood() > 200*(0.15*technologyDefense) &&
					getIron()> 2000*(0.2*technologyDefense)){
				this.technologyDefense+= 1;//sumamos uno
				//resta recursos con aumento segun nivel
				this.setFood(food-100 + 100*(float)(0.1*technologyDefense));
				this.setWood(wood-200*(float)(0.15*technologyDefense));
				this.setIron(iron-2000*(float)(0.2*technologyDefense));

			}else {
				//se controla la falta de recursos
				throw new ResourceException("You do not have resources to improve your defense technology");
			}

		}

	}

	void upgradeTechnologyAttack() throws ResourceException {
		if (technologyAttack == 0) {//se paga el valor tec inicial
			if (getFood() > 100 && getWood() > 200 &&
					getIron()> 2000){
				//resta recursos
				this.setFood(food-100);
				this.setWood(wood-200);
				this.setIron(iron-2000);
				this.technologyAttack+= 1;//sumamos uno

			}else {
				//se controla la falta de recursos
				throw new ResourceException("You do not have resources to improve your attack technology");
			}
		}else {//se calcula la cantidad a pagar dependiendo del nivel tec
			if (getFood() > 100 + 100*(0.1*technologyAttack) && getWood() > 200*(0.15*technologyAttack) &&
					getIron()> 2000*(0.2*technologyAttack)){
				this.technologyAttack+= 1;//sumamos uno
				//resta recursos segun nivel tec
				this.setFood(food-100 + 100*(float)(0.1*technologyAttack));
				this.setWood(wood-200*(float)(0.15*technologyAttack));
				this.setIron(iron-2000*(float)(0.2*technologyAttack));

			}else {
				//se controla la falta de recursos
				throw new ResourceException("You do not have resources to improve your attack technology");
			}

		}

	}




	void newSwordsman(int n) throws ResourceException {

		for (int i = 0; i < n; i++) { 
			//comprobar si tenemos los recursos unidad a unidad
			if (getFood() > 8000 && getWood() > 3000 &&
					getIron()> 50){
				//se resta los recursos de la unidad creada
				this.setFood(food-8000);
				this.setWood(wood-3000);
				this.setIron(iron-50);
				//se crean variables de creacion de uni
				int newArmor = Variables.ARMOR_SWORDSMAN+(getTechnologyDefense()+
						Variables.PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY)*Variables.ARMOR_SWORDSMAN/100;
				int newDamage = Variables.BASE_DAMAGE_SWORDSMAN+(getTechnologyAttack()+
						Variables.PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_SWORDSMAN/100;
				Swordsman newSwordsman = new Swordsman(newArmor,newDamage);//se pasa las variables con los valores
				army[0].add(newSwordsman);//se añade al array que le pertoca

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Swordsman, has been created "+i);
			}


		}
	}

	void newSpearman(int n) throws ResourceException {
		for (int i = 0; i < n; i++) { 
			if (getFood() > 5000 && getWood() > 6500 &&
					getIron()> 50){
				this.setFood(food-5000);
				this.setWood(wood-6500);
				this.setIron(iron-50);
				int newArmor = Variables.ARMOR_SPEARMAN+(getTechnologyDefense()+
						Variables.PLUS_ARMOR_SPEARMAN_BY_TECHNOLOGY)*Variables.ARMOR_SPEARMAN/100;
				int newDamage = Variables.BASE_DAMAGE_SPEARMAN+(getTechnologyAttack()+
						Variables.PLUS_ARMOR_SPEARMAN_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_SPEARMAN/100;
				Spearman newSpearman = new Spearman(newArmor,newDamage);
				army[1].add(newSpearman);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Spearman, has been created "+i);
			}
		}
	}

	void newCrossbow(int n) throws ResourceException {
		for (int i = 0; i < n; i++) { 
			if (getFood() > 0 && getWood() > 45000 &&
					getIron()> 7000){
				this.setWood(wood-45000);
				this.setIron(iron-7000);
				int newArmor = Variables.ARMOR_CROSSBOW+(getTechnologyDefense()+
						Variables.PLUS_ARMOR_CROSSBOW_BY_TECHNOLOGY)*Variables.ARMOR_CROSSBOW/100;
				int newDamage = Variables.BASE_DAMAGE_CROSSBOW+(getTechnologyAttack()+
						Variables.PLUS_ARMOR_CROSSBOW_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_CROSSBOW/100;
				Crossbow newCrossbow = new Crossbow(newArmor,newDamage);
				army[2].add(newCrossbow);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Crossbow, has been created "+i);
			}
		}
	}


	void newCannon(int n) throws ResourceException {
		for (int i = 0; i < n; i++) { 
			if (getFood() > 0 && getWood() > 30000 &&
					getIron()> 15000){
				this.setWood(wood-30000);
				this.setIron(iron-15000);
				int newArmor = Variables.ARMOR_CANNON+(getTechnologyDefense()+
						Variables.PLUS_ARMOR_CANNON_BY_TECHNOLOGY)*Variables.ARMOR_CANNON/100;
				int newDamage = Variables.BASE_DAMAGE_CANNON+(getTechnologyAttack()+
						Variables.PLUS_ARMOR_CANNON_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_CANNON/100;
				Cannon newCannon = new Cannon(newArmor,newDamage);
				army[3].add(newCannon);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Cannon, has been created "+i);
			}
		}
	}


	void newArrowTower(int n) throws ResourceException {

		for (int i = 0; i < n; i++) { 
			if (getWood() > 2000){
				this.setWood(wood-2000);
				int newArmor = Variables.ARMOR_ARROWTOWER+(getTechnologyDefense()+
						Variables.PLUS_ARMOR_ARROWTOWER_BY_TECHNOLOGY)*Variables.ARMOR_ARROWTOWER/100;
				int newDamage = Variables.BASE_DAMAGE_ARROWTOWER+(getTechnologyAttack()+
						Variables.PLUS_ARMOR_ARROWTOWER_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_ARROWTOWER/100;
				ArrowTower newArrowTower = new ArrowTower(newArmor,newDamage);
				army[4].add(newArrowTower);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" ArrowTower, has been created "+i);
			}
		}
	}


	void newCatapult(int n) throws ResourceException {

		for (int i = 0; i < n; i++) { 
			if (getWood() > 4000 && getIron()> 500){
				this.setWood(wood-4000);
				this.setIron(iron-500);
				int newArmor = Variables.ARMOR_CATAPULT+(getTechnologyDefense()+
						Variables.PLUS_ARMOR_CATAPULT_BY_TECHNOLOGY)*Variables.ARMOR_CATAPULT/100;
				int newDamage = Variables.BASE_DAMAGE_CATAPULT +(getTechnologyAttack()+
						Variables.PLUS_ARMOR_CATAPULT_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_CATAPULT/100;
				Catapult newCatapult = new Catapult(newArmor,newDamage);
				army[5].add(newCatapult);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Catapult, has been created "+i);
			}
		}
	}


	void newRocketLauncherTower(int n) throws ResourceException {

		for (int i = 0; i < n; i++) { 
			if (getWood() > 50000 && getIron()> 5000){
				this.setWood(wood-50000);
				this.setIron(iron-5000);
				int newArmor = Variables.ARMOR_ROCKETLAUNCHERTOWER+(getTechnologyDefense()+
						Variables.PLUS_ARMOR_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY)*Variables.ARMOR_ROCKETLAUNCHERTOWER/100;
				int newDamage = Variables.BASE_DAMAGE_ROCKETLAUNCHERTOWER +(getTechnologyAttack()+
						Variables.PLUS_ARMOR_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_ROCKETLAUNCHERTOWER/100;
				RocketLauncherTower newRocketLauncher = new RocketLauncherTower(newArmor,newDamage);
				army[6].add(newRocketLauncher);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" RocketLauncher, has been created "+i);
			}
		}
	}



	void newMagician(int n) throws ResourceException {


		for (int i = 0; i < n; i++) { 
			if (getFood() > 12000 && getWood() > 2000 &&
					getMana()> 5000){
				this.setWood(wood-2000);
				this.setFood(food-1200);
				this.setMana(mana-5000);
				int newArmor = 0;
				int newDamage = Variables.BASE_DAMAGE_MAGICIAN +(getTechnologyAttack()+
						Variables.PLUS_ARMOR_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY)*Variables.BASE_DAMAGE_MAGICIAN/100;
				Magician newMagician = new Magician(newArmor,newDamage);
				army[7].add(newMagician);

			}else {
				//se controla la falta de recursos
				throw new ResourceException("you do not have enough resources to create "+n+" Magician, has been created "+i);
			}
		}
	}


	void newPriest(int n) throws ResourceException {
		for (int i = 0; i < n; i++) { 
			if (getFood() > 15000 && getMana()> 15000){
				this.setFood(food-15000);
				this.setMana(mana-15000);
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

	void printStats() {

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
