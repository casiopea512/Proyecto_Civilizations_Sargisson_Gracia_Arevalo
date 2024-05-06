package pkg_Principal;

import java.util.ArrayList;

import interfaces.MilitaryUnit;
import pkg_AttackUnit.Spearman;



public class Civilization {
	private int technologyDefense;
	private int technologyAtack;
	
	private int wood;
	private int iron;
	private int food;
	private int mana;
	
	private int magicTower;
	private int church;
	private int farm;
	private int smithy;
	private int carpentry;
	
	private int battles;
	private ArrayList<MilitaryUnit> army = new ArrayList<MilitaryUnit>(9);//puede ser un array
	
	//constructor
	public Civilization(int technologyDefense, int technologyAtack, int wood, int iron, int food, int mana,
			int magicTower, int church, int farm, int smithy, int carpentry, int battles,
			ArrayList<MilitaryUnit> army) {
		super();
		this.technologyDefense = technologyDefense;
		this.technologyAtack = technologyAtack;
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
		this.army = army;
		
		
		
	}

	public int getTechnologyDefense() {
		return technologyDefense;
	}

	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}

	public int getTechnologyAtack() {
		return technologyAtack;
	}

	public void setTechnologyAtack(int technologyAtack) {
		this.technologyAtack = technologyAtack;
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

	public int getBattles() {
		return battles;
	}

	public void setBattles(int battles) {
		this.battles = battles;
	}

	public ArrayList<MilitaryUnit> getArmy() {
		return army;
	}

	public void setArmy(ArrayList<MilitaryUnit> army) {
		this.army = army;
	}
	
	
	
	//metodos
	
	void newChurch() {
		
		if (getFood() > 10000 ||getWood() > 20000 ||
				getIron()> 24000 || getMana()>10000 ) {
			this.church+= 1;
			
		}else {
			//llama clase exception BuildingException
		}
	}
	
	void newMagicTower() {
		
	}
	
	void newFarm() {
		
	}
	
	void newCarpentry() {
		
	}
	
	void newSmithy() {
		
	}
	
	void upgradeTechnologyDefense() {
		
	}
	
	void upgradeTechnologyAttack() {
		
	}
	
	void newSwordsman(int n, Spearman sp) {
		
	}
	void newSpearman(int n) {
		
	}
	
	void newCrossbow(int n) {
		
	}
	
	void newCannon(int n) {
		
	}
	
	void newArrowTower(int n) {
		
	}
	
	void newCatapult(int n) {
		
	}
	
	void newRocketLauncher(int n) {
		
	}
	
	void newMagician(int n) {
		
	}
	
	void newPriest(int n) {
		
	}
	
	void printStats() {
	
		
	}

	
	
	
	
	
	

}
