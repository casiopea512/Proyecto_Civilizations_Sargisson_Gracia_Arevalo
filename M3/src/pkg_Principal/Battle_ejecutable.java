package pkg_Principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
//			civilizationArmy[2].add(new Crossbow());
//			civilizationArmy[3].add(new Cannon());
//			civilizationArmy[8].add(new Priest(50, 10000));
		}

		
		for(int i=0;i<2;i++) {
			civilizationArmy[0].add(new Swordsman());
		}



		ArrayList<MilitaryUnit>[] enemyArmy = new ArrayList[4];
		for (int i = 0; i < enemyArmy.length; i++) {
			enemyArmy[i] = new ArrayList<>();
		}	


		for(int i=0; i<2; i++) {
			enemyArmy[0].add(new Swordsman());
//			enemyArmy[1].add(new Spearman());
//			enemyArmy[2].add(new Crossbow());
		}

		for(int i=0;i<2;i++) {
			enemyArmy[3].add(new Cannon());
		}
		
		// BATALLA
		
		Map<String, String[]> mapaBatallas = new HashMap<>();
		
		Battle bt = new Battle(civilizationArmy,enemyArmy);
		
		//int numBatallas = principal.getCurrentCivilization().getBattles();
		int numBatallas = 2;
		String nombreClave = "batalla"+numBatallas;
		
		String[] informacionBatalla = {bt.getReporte(),bt.getReportePasos()};
		
		mapaBatallas.put(nombreClave, informacionBatalla);
		
		String[] arrayInfoBatalla = mapaBatallas.get("batalla2");
		
		System.out.println("\n\nQué quieres ver?\n1.Reporte General\n2.Reporte paso a paso\n->");
		
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()) {
			int opc = sc.nextInt();
			
			if(opc ==1) {
				System.out.println(arrayInfoBatalla[0]);
			}
			else if(opc==2) {
				System.out.println(arrayInfoBatalla[1]);
			}
		}
		
	}
}
