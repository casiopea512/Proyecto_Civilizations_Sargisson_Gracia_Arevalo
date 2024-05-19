package pkg_Principal;

import java.util.ArrayList;

import interfaces.MilitaryUnit;
import interfaces.Variables;
import pkg_AttackUnit.Cannon;
import pkg_AttackUnit.Crossbow;
import pkg_AttackUnit.Spearman;
import pkg_AttackUnit.Swordsman;
import pkg_SpecialUnit.Priest;

public class Battle_ejecutable implements Variables {
	public static void main(String[] args) {
		
		// Creación unidades militares y arraylist
		ArrayList<MilitaryUnit>[] civilizationArmy = new ArrayList[9];
		for( int i=0; i<civilizationArmy.length; i++) {
			civilizationArmy[i] = new ArrayList<>();
		}


		for(int i=0;i<2;i++) {
			civilizationArmy[1].add(new Spearman());
			civilizationArmy[2].add(new Crossbow());
			civilizationArmy[3].add(new Cannon());
			civilizationArmy[8].add(new Priest(50, 10000));
		}

		
		for(int i=0;i<10;i++) {
			civilizationArmy[0].add(new Swordsman());
		}



		ArrayList<MilitaryUnit>[] enemyArmy = new ArrayList[4];
		for (int i = 0; i < enemyArmy.length; i++) {
			enemyArmy[i] = new ArrayList<>();
		}	


		for(int i=0; i<10; i++) {
			enemyArmy[0].add(new Swordsman());
			enemyArmy[1].add(new Spearman());
			enemyArmy[2].add(new Crossbow());
		}

		for(int i=0;i<2;i++) {
			enemyArmy[3].add(new Cannon());
		}
		
		// BATALLA
		Battle bt = new Battle(civilizationArmy,enemyArmy);
		
		
		System.out.println("\n\n\n\n");
		System.out.println(bt.getReportePasos());
		
		
		System.out.println("\n\n\n");
		System.out.println(bt.getReporte());
	}
}
