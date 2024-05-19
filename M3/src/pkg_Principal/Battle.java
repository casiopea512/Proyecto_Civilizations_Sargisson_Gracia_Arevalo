package pkg_Principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import interfaces.MilitaryUnit;
import interfaces.Variables;
import pkg_AttackUnit.*;
import pkg_DefenseUnit.*;
import pkg_SpecialUnit.*;

public class Battle implements Variables {
	
	// array de arraylists's
	private ArrayList<MilitaryUnit>[] civilizationArmy;
	private ArrayList<MilitaryUnit>[] enemyArmy;
	
	

	// arraylist de las dos arraylist de las unidades: la array de civilization y enemy es la que me pasan
//	private ArrayList armies = new ArrayList();
	private ArrayList[][] armies = new ArrayList[2][9];
//	private  ArrayList[][] armies1 = new ArrayList[2][9];
	//private int[] nombre = new int[2];

	// cantidad  unidades civilización
	private int[] initialArmiesCivilization = new int[9]; // [swordsman, spearman, crossbow, cannon, || arrorT, catapult, rocketLT, ||magician, priest]
	// cantidad  unidades enemy
	private int[] initialArmiesEnemy = new int[4];

	// varible initialArmies bidimensiona: conteo unidades incial
	private int[][] initialArmies = new int[2][];


	// costes de la flota civilización
	private int[] initialCostFleetCivilization = new int[3]; // [comida, madera, hierro]
	// costes de la flota enemy
	private int[] initialCostFleetEnemy = new int[3];

	// variable initialCostFleet bidimensional: costes de las flotas
	private int[][] initialCostFleet = new int[2][];

	// residuos generados en la batalla
	private int[] wasteWoodIron = new int[2];
	
	// unidades caídas
	private int[] civilizationDrops = new int[9];
	private int[] enemyDrops = new int[4];
	
	//array bidimensional drops y ponderacion
	private int[][] resourcesLooses = new int[2][];
	
	
	// VARIABLES TOTAL UNIDADES: cuantificar el total de unidades que hay
	private int initialNumberUnitsCivilization=0;
	private int initialNumberUnitsEnemy=0;
	// para el conteo durante la batalla y controlar el bucle while
	private int num_actualUnitsCivilization;
	private int num_actualUnitsEnemy;

	// conteo unidades actuales: para la BATALLA
	private int[] actualNumberUnitsCivilization;
	private int[] actualNumberUnitsEnemy;

	
	// booleando para saber quién ha ganado
	private boolean bool_civiWin = false;
	
	// String de reporte paso a paso
	private String reportePasos = "";
	

	// AÑADIR A VARIABLES
	private double porcentajeFinBatalla = 0.20; // 20%


	// Constructor
	public Battle(ArrayList<MilitaryUnit>[] civilizationArmy, ArrayList<MilitaryUnit>[] enemyArmy) {
		this.civilizationArmy = civilizationArmy;
		this.enemyArmy = enemyArmy;

		// inicializar ArrayList armies
		this.initArmy();

		// calcular cantidad unidades y coste de éstas
		this.initInitialArmies_initInitialCostFleet();

		// calcular en número total inicial de unidades
		this.calcInitialNumberUnits();

		// inicializar array actualNumberUnits
		this.initActualNumberUnits();
		
		// inicializar array resourcesLooses y armyDrops
		this.initResourcesLooses();
		
		// batalla
		this.goBattle();
		
		// restablecer la armadura
		this.resetArmyArmor();
		
		// añadirles experiencia
		this.updateExperience();
		
		// actualizar Drops y resourcesLooses
		this.updateDrops_resourcesLooses();
		
		// comprobar quién ha ganado
		this.checkWin();
		
	}


	
	
	
	// inicializar ArrayList armies
	public void initArmy() {
//		this.armies.add(civilizationArmy);
//		this.armies.add(enemyArmy);
		
		armies[0] = civilizationArmy;
		armies[1] = enemyArmy;

//		System.out.println(    (((ArrayList<MilitaryUnit>[]) (armies.get(0))) [0]).get(0) );
		
//		armies1[0] = civilizationArmy;
//		armies1[1] = enemyArmy;		
//		System.out.println(armies1[0][0].get(0));
		//System.out.println(civilizationArmy[0]);
		//String[] strings = (String[]) objects[0];
	}

	// calcular cantidad unidades y coste de éstas
	public void initInitialArmies_initInitialCostFleet() {

		// Civilización: conteo unidades y costes
		System.out.println("Civilización----\n");
		for(int i=0; i<initialArmiesCivilization.length;i++) { // 9 veces
			System.out.println("El índie "+i+" es el army "+civilizationArmy[i]);
			this.initialArmiesCivilization[i] += this.civilizationArmy[i].size(); // sumar al array cuántas unidades hay

			for( int j=0; j<civilizationArmy[i].size(); j++) { // tantas como unidades haya
				System.out.println("El elemento "+j+" = "+civilizationArmy[i].get(j));

				//sumar los costes de la unidad
				this.initialCostFleetCivilization[0] += FOOD_COST_UNITS[i];
				this.initialCostFleetCivilization[1] += WOOD_COST_UNITS[i];
				this.initialCostFleetCivilization[2] += IRON_COST_UNITS[i];
			}
			System.out.println("");
		}
		for (int i=0;i<initialCostFleetCivilization.length;i++) {
			System.out.println("El coste de "+i+" es de "+initialCostFleetCivilization[i]);
		}


		// Enemy: conteo unidades y costes
		System.out.println("\n\nEnemy----\n");
		for(int i=0; i<initialArmiesEnemy.length;i++) { // 4 veces
			System.out.println("El índie "+i+" es el army "+enemyArmy[i]);
			this.initialArmiesEnemy[i] += this.enemyArmy[i].size(); // sumar al array cuántas unidades hay

			for( int j=0; j<enemyArmy[i].size(); j++) { // tantas como unidades haya				
				System.out.println("El elemento "+j+" = "+enemyArmy[i].get(j));

				//sumar los costes de la unidad
				this.initialCostFleetEnemy[0] += FOOD_COST_UNITS[i];
				this.initialCostFleetEnemy[1] += WOOD_COST_UNITS[i];
				this.initialCostFleetEnemy[2] += IRON_COST_UNITS[i];
			}
			System.out.println("");
		}
		for (int i=0;i<initialCostFleetEnemy.length;i++) {
			System.out.println("El coste de "+i+" es de "+initialCostFleetEnemy[i]);
		}


		// varible initialArmies bidimensiona
		System.out.println("\n\nArray initialArmies----");
		this.initialArmies[0] = initialArmiesCivilization;
		this.initialArmies[1] = initialArmiesEnemy;

		for (int i = 0; i < this.initialArmies.length; i++) {
			System.out.print("Array " + i + ": ");
			for (int j = 0; j < this.initialArmies[i].length; j++) {
				System.out.print(this.initialArmies[i][j] + " ");
			}
			System.out.println();
		}


		// variable initialCostFleet bidimensional
		System.out.println("\n\nArray initialCostFleet----");
		this.initialCostFleet[0] = initialCostFleetCivilization;
		this.initialCostFleet[1] = initialCostFleetEnemy;

		for (int i = 0; i < this.initialCostFleet.length; i++) {
			System.out.print("Array " + i + ": ");
			for (int j = 0; j < this.initialCostFleet[i].length; j++) {
				System.out.print(this.initialCostFleet[i][j] + " ");
			}
			System.out.println();
		}
	}


	// calcular en número total inicial de unidades
	public void calcInitialNumberUnits() {

		// civilización
		for(int i=0; i<initialArmiesCivilization.length; i++) {
			this.initialNumberUnitsCivilization+= this.initialArmiesCivilization[i];
		}

		//enemigos
		for(int i=0; i<initialArmiesEnemy.length; i++) {
			this.initialNumberUnitsEnemy+= this.initialArmiesEnemy[i];
		}
		
		// inicializar el actualUnits
		num_actualUnitsCivilization = initialNumberUnitsCivilization;
		num_actualUnitsEnemy = initialNumberUnitsEnemy;


		System.out.println("\n\nInitialNumberUnits----");
		System.out.println("Hay "+initialNumberUnitsCivilization+" unidades en total en la civilización");
		System.out.println("Hay "+initialNumberUnitsEnemy+" unidades en total en el enemigo");

	}


	// inicializar array actualNumberUnits
	public void initActualNumberUnits() {

		// civilización
		this.actualNumberUnitsCivilization = this.initialArmiesCivilization.clone();
		//enemigos
		this.actualNumberUnitsEnemy = this.initialArmiesEnemy.clone();

		System.out.println("\n\nArray actualNumberUnits----\n" +
				"Civilization: "+Arrays.toString(actualNumberUnitsCivilization)+"\n"+
				"Enemy: "+Arrays.toString(actualNumberUnitsEnemy));

	}

	
	// inicializar array resourcesLooses
	public void initResourcesLooses() {
		for (int i=0; i<resourcesLooses.length; i++) {
			resourcesLooses[i] = new int[4];
		}
	}
	
	
	
	
	// donde se realiza la batalla
	public void goBattle() {
		// gestión del turno
		int turno = (int)(Math.random()*2); // 0: civ - 1:enemy
		System.out.println("\n\nNumero Aleatorio para la gestión del turno es: "+turno+"\n");

		// WHILE
		
		boolean continueBattle = true;
		boolean repeatAttack = true;
		
		int limiteCivilization = (int) (porcentajeFinBatalla * initialNumberUnitsCivilization);
		int limiteEnemy = (int) (porcentajeFinBatalla * initialNumberUnitsEnemy);
		
		System.out.println("El límite de Civilización es: "+limiteCivilization+"\nEl límite del Enemy es: "+limiteEnemy);
		
		while (num_actualUnitsCivilization > limiteCivilization && num_actualUnitsEnemy > limiteEnemy) {
			System.out.println("\n\n******************* Change attacker *****************************\n");
			
			this.reportePaP("\n********************************CHANGE ATTACKER********************************\n");
			repeatAttack = false;

			if(turno==0) { // defendemos
				System.out.println("\nTurno: "+turno+"\n");
				
				// escoger unidad
				MilitaryUnit defensor = this.getGroupDefender(actualNumberUnitsCivilization,0); // 0: civ - 1:enemy
				MilitaryUnit atacante = this.getGroupAttacker(actualNumberUnitsEnemy,1); // 0: civ - 1:enemy
				
				// reporte paso a paso
				this.reportePaP("Attacks army enemy: "+atacante.getName()+" attacks "+defensor.getName());

				// que se ataquen: devuelve true si se tiene que volver a repetir la batalla
				repeatAttack = this.atacarse(defensor, atacante, civilizationArmy,0);
				
				while (repeatAttack && (num_actualUnitsCivilization > limiteCivilization && num_actualUnitsEnemy > limiteEnemy)) {
					System.out.println("SE REPITE LA BATALLA------------------------------------------------------");
					// volver a cargar el número de unidades
					this.updateActualNumberUnits();
					this.updateNumActualUnits();
					
					
					defensor = this.getGroupDefender(actualNumberUnitsCivilization,0);
					
					System.out.println("\n------------\nLe paso el defensor: "+defensor+"\nY el atacante: "+atacante+"\n--------------");
					repeatAttack = this.atacarse(defensor, atacante, civilizationArmy,0);
					
					
				}

				// cambio de turno
				turno =1;
			}
			else if(turno==1) { // atacamos
				System.out.println("\nTurno: "+turno+"\n");
				
				// escoger unidad
				MilitaryUnit defensor = this.getGroupDefender(actualNumberUnitsEnemy,1); // 0: civ - 1:enemy
				MilitaryUnit atacante = this.getGroupAttacker(actualNumberUnitsCivilization,0); // 0: civ - 1:enemy

				// reporte paso a paso
				this.reportePaP("Attacks Civilization: "+atacante.getName()+" attacks "+defensor.getName());
				
				// que se ataquen: devuelve true si se tiene que volver a repetir la batalla
				repeatAttack = this.atacarse(defensor, atacante, enemyArmy,1);

				while(repeatAttack && (num_actualUnitsCivilization > limiteCivilization && num_actualUnitsEnemy > limiteEnemy)) {
					System.out.println("SE REPITE LA BATALLA------------------------------------------------------");
					// volver a cargar el número de unidades
					this.updateActualNumberUnits();
					this.updateNumActualUnits();
					
					
					defensor = this.getGroupDefender(actualNumberUnitsEnemy,1);
					
					System.out.println("\n------------\nLe paso el defensor: "+defensor+"\nY el atacante: "+atacante+"\n--------------");
					repeatAttack = this.atacarse(defensor, atacante, enemyArmy,1);
					
					
				}

				// cambio de turno
				turno =0;
			}
			
			
			System.out.println("\n\nFin de los if, vuelta a empezar\n\n");
			
			// volver a cargar el número de unidades
			this.updateActualNumberUnits();
			this.updateNumActualUnits();
			
						
			// para pasar el turno manual: QUITAR !!!!!!!!!!!!!!!!!!!!!!!
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
		}
	}

	
	

	// actualizar los array actualNumberUnits
	public void updateActualNumberUnits() {

		System.out.println("\n\nActualizar el array de conteo unidades (actualNumberUnitsC/E)");

		// civilización
		System.out.println("\nCivilización");
		for (int i=0; i<actualNumberUnitsCivilization.length; i++) { // 9 veces
			System.out.println("El índice "+i+" es el army "+civilizationArmy[i]);
			this.actualNumberUnitsCivilization[i] = this.civilizationArmy[i].size();
		}
		System.out.println("El array actualNumberUnitsCivilziation es: "+Arrays.toString(this.actualNumberUnitsCivilization));


		// enemy
		System.out.println("\nEnemy");
		for (int i=0; i<actualNumberUnitsEnemy.length; i++) { // 4 veces
			System.out.println("El índice "+i+" es el army "+enemyArmy[i]);
			this.actualNumberUnitsEnemy[i] = this.enemyArmy[i].size();
		}
		System.out.println("El array actualNumberUnitsEnemy es: "+Arrays.toString(this.actualNumberUnitsEnemy));

	}

	// actualizar el total de unidades de cada civilización
	public void updateNumActualUnits() {
		System.out.println("\n\nActualización del total (num_actualUnitsC/E)");
		
		int new_num_UnitsCivilization = 0;
		int new_num_UnitsEnemy = 0;
		
		// civilización
		for(int i=0; i<actualNumberUnitsCivilization.length; i++) {
			new_num_UnitsCivilization += actualNumberUnitsCivilization[i];
		}
		// enemigo
		for (int i=0; i<actualNumberUnitsEnemy.length; i++) {
			new_num_UnitsEnemy += actualNumberUnitsEnemy[i];
		}
		
		num_actualUnitsCivilization = new_num_UnitsCivilization;
		num_actualUnitsEnemy = new_num_UnitsEnemy;
		
		
		System.out.println("\nHay "+num_actualUnitsCivilization+" unidades en total en la civilización");
		System.out.println("Hay "+num_actualUnitsEnemy+" unidades en total en el enemigo");
	}
	
	
	
	// elegir defensor
	public MilitaryUnit getGroupDefender(int[] actualNumberUnits, int def) {

		System.out.println("\nElegir el Grupo defensor----\n");

		// calcular el total de unidades
		int sumTotalUnidades_def = 0;
		for (int unidades : actualNumberUnits) {
			sumTotalUnidades_def += unidades;
		}
		System.out.println("La suma total de unidades defensivas es: "+sumTotalUnidades_def+"\n");


		// calcular un número aleatorio en base al total de unidades: nos servirá como umbral
		int numAleatorio_def = (int) (Math.random()*sumTotalUnidades_def)+1;
		System.out.println("El número al azar en base al total de unidades es: "+numAleatorio_def);


		// elegir GRUPO: a través de una suma acumulativa del total de unidades de cada grupo eligiremos la que pase del umbral calculado
		int sumaAcumulativa = 0;
		int indiceGrupo_def = 0; // indica qué grupo es el escogido
		for (int i=0; i<actualNumberUnits.length; i++) { // tantas veces como grupos haya
			sumaAcumulativa += actualNumberUnits[i];

			if (sumaAcumulativa >= numAleatorio_def) { // cuando la suma pase el umbral
				indiceGrupo_def = i;
				break;
			}
		}
		System.out.println("El grupo elegido es el del índice: "+indiceGrupo_def+" ("+actualNumberUnits[indiceGrupo_def]+")" );


		// elegir UNIDAD: de manera aleatoria
		int indiceUnidad_def = (int) (Math.random()*actualNumberUnits[indiceGrupo_def]);
		System.out.println("La unidad elegida es la del índice: "+indiceUnidad_def);


		MilitaryUnit defensor = null;

		// civilización
		if (def==0) {
			System.out.println("Unidad escogida finalmente de la CIVILIZACIÓN: "+ civilizationArmy[indiceGrupo_def].get(indiceUnidad_def));
			defensor= civilizationArmy[indiceGrupo_def].get(indiceUnidad_def);
		}
		// enemy
		else if(def==1) {
			System.out.println("Unidad escogida finalemnte del ENEMIGO: "+enemyArmy[indiceGrupo_def].get(indiceUnidad_def));
			defensor= enemyArmy[indiceGrupo_def].get(indiceUnidad_def);
		}

		System.out.println("Fin getGroupDefender\n\n");
		return defensor;

	}

	// elegir atacante
	public MilitaryUnit getGroupAttacker(int[] actualNumberUnits, int atack) {

		System.out.println("\nElegir el Grupo atacante----\n\n");


		int probAcumulada =0;
		int indiceGrupo_atack =0;

		boolean unidadElegida=false;
		while(!unidadElegida) {
			
			System.out.println("\n\n---------------\nEl grupo elegido tiene cero unidades, se volverá a intentar\n-------------------\n\n");
			
			// generar un número aleatorio entre 0 y 9(inclusive). Ya que, la probabilidad siempre será sobre 100
			int numAleatorio_atacante = (int) (Math.random()*100);
			System.out.println("Numero aleatorio para elegir el atacante es = "+numAleatorio_atacante);


			// SWORDSMAN, SPEARMAN, CROSSBOW, CANNON, ARROWTOWER, CATAPULT, ROCKETLAUNCHERTOWER, MAGICIAN, PRIEST
			// civilización -- CHANCE_ATTACK_CIVILIZATION_UNITS = {4,9,13,37,4,9,14,10,0};
			if(atack==0) {

				// GRUPO

				// iterar sobre el array de probabilidad
				for (int i=0; i<CHANCE_ATTACK_CIVILIZATION_UNITS.length; i++) {
					probAcumulada += CHANCE_ATTACK_CIVILIZATION_UNITS[i];

					if (numAleatorio_atacante <= probAcumulada && actualNumberUnits[i] > 0) { // si supera el umbral y hay al menos una unidad
						indiceGrupo_atack = i;
						System.out.println("El grupo atacante elegido es: "+i+" ("+actualNumberUnits[indiceGrupo_atack]+")");
						unidadElegida = true;
						break;
					}
				}
			}

			// SWORDSMAN, SPEARMAN, CROSSBOW, CANNON
			// enemy -- CHANCE_ATTACK_ENEMY_UNITS = {10,20,30,40};
			else if(atack==1) {

				// GRUPO

				// iterar sobre el array de probabilidad
				for( int i=0; i<CHANCE_ATTACK_ENEMY_UNITS.length; i++) {
					probAcumulada += CHANCE_ATTACK_ENEMY_UNITS[i];

					if (numAleatorio_atacante <= probAcumulada && actualNumberUnits[i] >0) { // si supera el umbral y hay una unidad al menos
						indiceGrupo_atack = i;
						System.out.println("El grupo atacante elegido es: "+i+" ("+actualNumberUnits[indiceGrupo_atack]+")");
						unidadElegida = true;
						break;
					}
				}
			}
		}


		// UNIDAD
		int indiceUnidad_atack = (int) (Math.random()*actualNumberUnits[indiceGrupo_atack]);
		System.out.println("La unidad atacante elegida es la del índice: "+indiceUnidad_atack);

		MilitaryUnit atacante = null;

		// civilización
		if(atack==0) {
			System.out.println("Unidad escogida finalmente de la CIVILIZACIÓN: "+civilizationArmy[indiceGrupo_atack].get(indiceUnidad_atack));
			atacante = civilizationArmy[indiceGrupo_atack].get(indiceUnidad_atack);
		}
		// enemy
		else if(atack==1) {
			System.out.println("Unidad escogida finalmente del ENEMIGO: "+enemyArmy[indiceGrupo_atack].get(indiceUnidad_atack));
			atacante = enemyArmy[indiceGrupo_atack].get(indiceUnidad_atack);
		}

		System.out.println("Fin getGroupAttacker\n\n");
		return atacante;

	}

	
	
	// atacarse entre ellos
	public boolean atacarse(MilitaryUnit defensor, MilitaryUnit atacante, ArrayList<MilitaryUnit>[] armyToRemove, int def) {
		System.out.println("\n\nATAQUE----\n");
		
		//que reciba daño
		
		// reporte paso a paso
		this.reportePaP("\n"+atacante.getName()+" generates the damage = "+atacante.attack());

		System.out.println(defensor+" recibe un daño de "+atacante.attack()+" por parte de "+atacante);

		defensor.takeDamage(atacante.attack());
		
		// reporte paso a paso
		this.reportePaP("\n"+defensor.getName()+" stays with armor = "+ defensor.getActualArmor());
		
		System.out.println(defensor+" tiene "+defensor.getActualArmor()+" de armadura restante");


		if(defensor.getActualArmor()<=0) {
			
			// reporte paso a paso
			this.reportePaP("\nwe eliminate "+defensor.getName());
			
			System.out.println("La unidad defensiva "+defensor+" ha sido eliminada :(");
			
			// comprobar si es un sacerdote y ver si hay más
			this.checkPriest(defensor);
			
			// comprobar si genera residuos
			this.generateResources(defensor);

			// elimina la unidad
			for(int i=0; i<armyToRemove.length; i++) {
				for (int j=0; j<armyToRemove[i].size(); j++) {
					if ( (armyToRemove[i].get(j)).equals(defensor) ) {
						armyToRemove[i].remove(j);

						// retroceder una iteración !!!! porque estamos eliminando un objeto
						j--;
					}
				}
			}

			System.out.println("\nPara comporbar que ha sido eliminado correctamente:");
			for(int i=0; i<armyToRemove.length; i++) {				
				System.out.println("El índe "+i+" es el grupo: "+armyToRemove[i]);
			}

		}


		// comprobar si puede atacar de nuevo

		boolean chanceAttackAgain = this.canAtackAgain(atacante);

		return chanceAttackAgain;

	}

	// comprobar si es un sacerdote y ver si hay más
	public void checkPriest(MilitaryUnit defensor) {
		if(defensor instanceof Priest) {
			
			System.out.println("\nLa unidad defensiva es un Priest");
			
			// si el número actual de unidades de priest es uno, es decir el que acaban de eliminar: desantificar
			if( actualNumberUnitsCivilization[8] ==1 ) {
				
				// reporte paso a paso
				this.reportePaP(", it was the last one.\nYour units are not longer sanctified");
				
				System.out.println("SE DESANTIFICAN LAS UNIDADES ENTERAS");
				
				for (int i=0; i<civilizationArmy.length; i++) {
					System.out.println("\nEl índie "+i+" corresponde a: "+civilizationArmy[i]);
					
					for( int j=0; j<civilizationArmy[i].size(); j++) {
						
						if (civilizationArmy[i].get(j) instanceof AttackUnit) {
							System.out.println("La unidad es atacante");
							((AttackUnit) civilizationArmy[i].get(j)).setSanctified(false);
							System.out.println(((AttackUnit) civilizationArmy[i].get(j)).isSanctified());
							System.out.println("La unidad "+civilizationArmy[i].get(j)+" ha sido desantificada");
						}
						
						else if(civilizationArmy[i].get(j) instanceof DefenseUnit) {
							System.out.println("La unidad es defensiva");
							((DefenseUnit) civilizationArmy[i].get(j)).setSanctified(false);
							System.out.println("La unidad "+civilizationArmy[i].get(j)+" ha sido desantificada");
						}
					}
				}
				
			}
		}
	}
	
	// comprobar si genera recursos la unidad eliminada
	public void generateResources(MilitaryUnit defensor) {

		
		System.out.println("\n\nComprobar generación de recursos\n");
		
		int probabilidadGenerarRecursos = defensor.getChanceGeneratinWaste();
		int costeMadera = defensor.getWoodCost();
		int costeHierro = defensor.getIronCost();

		System.out.println("La probabilidad de generar recursos es: "+probabilidadGenerarRecursos);

		// numero aletario
		int numAleatorio = (int) (Math.random()*100);
		System.out.println("El número aleatorio es: "+numAleatorio);
		
		if (probabilidadGenerarRecursos >= numAleatorio) {
			System.out.println("\nSe generarán los siguientes recursos:");
			
			int recursosMadera = (int)(costeMadera * PERCENTATGE_WASTE/100);
			int recursosHierro = (int)(costeHierro * PERCENTATGE_WASTE/100);
			
			System.out.println("De Madera: "+recursosMadera+"\nDe Hierro: "+recursosHierro);;
			
			
			// añadir los recursos generados al array general de perdidas
			wasteWoodIron[0] += recursosMadera;
			wasteWoodIron[1] += recursosHierro;
			
			System.out.println("Se ha actualizado el array de perdidas generales: "+Arrays.toString(wasteWoodIron));

		}
		
	}
	
	// comprobar si puede atacar de nuevo: estoy segura que hay una manera sin comprobar uno por uno
	public boolean canAtackAgain(MilitaryUnit atacante) {
		boolean probabilidad = false;		
		int probabilidadAtacar = atacante.getChanceAttackAgain();

		System.out.println("La probabilidad de atacar de nuevo es: "+probabilidadAtacar);

		// numero aletario
		int numAleatorio = (int) (Math.random()*100);
		System.out.println("El número aleatorio es: "+numAleatorio);

		// si el número es menor a la probabilidad atacará de nuevo
		if(probabilidadAtacar >= numAleatorio) {
			probabilidad = true;
			System.out.println("\nSÍ Atacará de nuevo\n");
		}
		else if (numAleatorio > probabilidadAtacar) {
			probabilidad = false;
			System.out.println("\nNO atacará de nuevo\n");
		}

		return probabilidad;


	}

	
	// restablecer la armadura
	public void resetArmyArmor() {
		System.out.println("\nRESTABLECER EL ARMOR\n");
		
		System.out.println("Civilización");
		for (int i=0; i<civilizationArmy.length; i++) {
			for (int j = 0; j < civilizationArmy[i].size(); j++) {
				civilizationArmy[i].get(j).resetArmor();
				System.out.println("La unidad "+civilizationArmy[i].get(j)+" ha sido restablecida: "+civilizationArmy[i].get(j).getActualArmor());
			}
		}
		
		System.out.println("\nEnemy");
		for (int i=0; i<enemyArmy.length; i++) {
			for (int j = 0; j < enemyArmy[i].size(); j++) {
				enemyArmy[i].get(j).resetArmor();
				System.out.println("La unidad "+enemyArmy[i].get(j)+" ha sido restablecidad: "+enemyArmy[i].get(j).getActualArmor());
			}
		}
	}
	
	
	// añadirles experiencia
	public void updateExperience() { //// error
		
		System.out.println("\n\nUpdate Experiencia de las unidades\n");
		
		for (int i=0; i<civilizationArmy.length; i++) {
			
			System.out.println("El índice i es: "+i+ " Corresponde a: "+civilizationArmy[i]);
			
			for (int j=0; j<civilizationArmy[i].size(); j++) {
				
				System.out.println("El índice j es: "+j);
				
				System.out.println("El civ[i].get(j) es: "+civilizationArmy[i].get(j));
				
				civilizationArmy[i].get(j).setExperience(1);
				
				System.out.println("La unidad "+civilizationArmy[i].get(j)+" ha aumentado 1exp: "+civilizationArmy[i].get(j));
			}
		}
	}
	
	// actualizar Drops y resourcesLooses
	public void updateDrops_resourcesLooses() {
		
		System.out.println("\n\nEl ejército CIVILIZATION principal era: "+Arrays.toString(initialArmies[0])+
						   "\nEl ejército ENEMY principal era: "+Arrays.toString(initialArmies[1]));
		
		System.out.println("\nEl ejército CIVILIZATION que ha quedado es: "+Arrays.toString(actualNumberUnitsCivilization) +
						   "\nEl ejército ENEMY que ha quedado es: "+Arrays.toString(actualNumberUnitsEnemy));
		
		// CIVILIZATION DROPS
		for (int i=0; i<actualNumberUnitsCivilization.length; i++) {
			civilizationDrops[i] += initialArmies[0][i] - actualNumberUnitsCivilization[i];
		}
		// ENEMY DROPS
		for (int i=0; i<actualNumberUnitsEnemy.length; i++) {
			enemyDrops[i] += initialArmies[1][i] - actualNumberUnitsEnemy[i];
		}
		
		System.out.println("\n\nEl ejército CIVILIZATION ha tenido las siguientes pérdidas: "+Arrays.toString(civilizationDrops)+ 
				           "\nEl ejército ENEMY ha tenido las siguientes pérdidas: "+Arrays.toString(enemyDrops));
		
		// RESOURCES LOOSES UPDATE: añadir al resourcesLooses
		for (int i=0; i<resourcesLooses.length;i++) {
			System.out.println("\níndice i = "+i);
			
			// CIVILIZACIÓN
			if( i==0) {
				for (int j=0; j<civilizationDrops.length; j++) {
					resourcesLooses[i][0] += civilizationDrops[j] * FOOD_COST_UNITS[j];
					System.out.println("El array de rL[0] += "+civilizationDrops[j]+" * "+FOOD_COST_UNITS[j]);
					
					resourcesLooses[i][1] += civilizationDrops[j] * WOOD_COST_UNITS[j];
					System.out.println("El array de rL[1] += "+civilizationDrops[j]+" * "+WOOD_COST_UNITS[j]);
					
					resourcesLooses[i][2] += civilizationDrops[j] * IRON_COST_UNITS[j];
					System.out.println("El array de rL[2] += "+civilizationDrops[j]+" * "+IRON_COST_UNITS[j]);
				}
				
				resourcesLooses[i][3] = resourcesLooses[i][2] + resourcesLooses[i][1]*5 + resourcesLooses[i][0]*10;
			}
			
			// ENEMY
			if( i==1) {
				for (int j=0; j<enemyDrops.length; j++) {
					resourcesLooses[i][0] += enemyDrops[j] * FOOD_COST_UNITS[j];
					System.out.println("El array de rL[0] += "+enemyDrops[j]+" * "+FOOD_COST_UNITS[j]);
					
					resourcesLooses[i][1] += enemyDrops[j] * WOOD_COST_UNITS[j];
					System.out.println("El array de rL[1] += "+enemyDrops[j]+" * "+WOOD_COST_UNITS[j]);
					
					resourcesLooses[i][2] += enemyDrops[j] * IRON_COST_UNITS[j];
					System.out.println("El array de rL[2] += "+enemyDrops[j]+" * "+IRON_COST_UNITS[j]);
				}
				
				resourcesLooses[i][3] = resourcesLooses[i][2] + resourcesLooses[i][1]*5 + resourcesLooses[i][0]*10;
			}
			
			
			System.out.println("\nEl aarray rl["+i+"] ha sido actualizado: "+Arrays.toString(resourcesLooses[i]));
		}
		
		
	}
	
	
	// comprobar quién ha ganado
	public void checkWin() {
		System.out.println("\n\nVamos a ver quién ha ganado--------------------------------------------------------");

		System.out.println("La ponderación de la civi es: "+resourcesLooses[0][3]+"\nLa ponderación del enemy es: "+resourcesLooses[1][3]);
		
		if(resourcesLooses[0][3] > resourcesLooses[1][3]) {
			System.out.println("El enemigo ha ganado");
		}
		else {
			System.out.println("La civilización ha ganado");
			
			bool_civiWin = true;
			
			System.out.println("Civilización gana los residuos generados: Madera("+wasteWoodIron[0]+") Hierro("+wasteWoodIron[1]+")");
			
		}
	}
	
	
	// reporte paso a paso
	public void reportePaP(String reporte) {
		reportePasos += reporte;
	}
		
	public String getReportePasos() {
		return this.reportePasos;
	}
	
	public String getReporte() {
//	    String reporteG = String.format("Army plannet %10s", " Units    Drops",  " Initial Army %10s", "Enemy   Units  Drops\n"+
//	                                    "Swordsman: %10d %d", actualNumberUnitsCivilization[0], civilizationDrops[0]);
	    
//		String reporteG = String.format(
//	            "Army plannet %10s" + "Units    Drops   Initial Army Enemy %10s" +"Units  Drops\n" +
//	            "Swordsman: %10d %d",
//	            "",  // Para ajustar "Army plannet"
//	            "",  // Para ajustar "Initial Army"
//	            actualNumberUnitsCivilization[0], 
//	            civilizationDrops[0]
//	        );
		
		String cabecera = String.format("%-20s %-10s %-10s %-25s %-10s %-10s",
										"Army plannet","Units","Drops","Initial Army Enemy","Units","Drops"
				);

		
		
		String datos = String.format("%-15s %10d %10d %14s %21d %10d", "Swordsman",actualNumberUnitsCivilization[0], civilizationDrops[0], "Swordsman", actualNumberUnitsEnemy[0],enemyDrops[0]);
		
		datos +="\n"+ String.format("%-15s %10d %10d %13s %22d %10d", "Spearman",actualNumberUnitsCivilization[1], civilizationDrops[1], "Spearman", actualNumberUnitsEnemy[1],enemyDrops[1]);

		datos +="\n"+ String.format("%-15s %10d %10d %13s %22d %10d", "Crossbow",actualNumberUnitsCivilization[2], civilizationDrops[2], "Crossbow", actualNumberUnitsEnemy[2],enemyDrops[2]);

		datos +="\n"+ String.format("%-15s %10d %10d %11s %24d %10d", "Cannon",actualNumberUnitsCivilization[3], civilizationDrops[3], "Cannon", actualNumberUnitsEnemy[3],enemyDrops[3]);

		datos +="\n"+ String.format("%-15s %10d %10d", "Arrow Tower",actualNumberUnitsCivilization[4], civilizationDrops[4]);

		datos +="\n"+ String.format("%-15s %10d %10d", "Catapult",actualNumberUnitsCivilization[5], civilizationDrops[5]);

		datos +="\n"+ String.format("%-15s %4d %10d", "Rocket Launcher Tower",actualNumberUnitsCivilization[6], civilizationDrops[6]);

		datos +="\n"+ String.format("%-15s %10d %10d", "Magician",actualNumberUnitsCivilization[7], civilizationDrops[7]);

		datos +="\n"+ String.format("%-15s %10d %10d", "Priest",actualNumberUnitsCivilization[8], civilizationDrops[8])+"\n\n";
		
		for (int i = 0; i < 88; i++) {
		    datos += "*";
		}
		
		datos +="\n"+ String.format("%-15s %35s", "Cost Army Civilization","Cost Army Enemy")+"\n";

		datos +="\n"+ String.format("%-15s %10d %21s %15d", "Food:", initialCostFleet[0][0], "Food:", initialCostFleet[1][0]);
		datos +="\n"+ String.format("%-15s %10d %21s %15d", "Wood:", initialCostFleet[0][1], "Wood:", initialCostFleet[1][1]);
		datos +="\n"+ String.format("%-15s %10d %21s %15d", "Iron:", initialCostFleet[0][2], "Iron:", initialCostFleet[1][2])+"\n\n";

		for (int i = 0; i < 88; i++) {
		    datos += "*";
		}
		
		datos +="\n"+ String.format("%-15s %35s", "Looses Army Civilization","Looses Army Enemy")+"\n";

		datos +="\n"+ String.format("%-15s %10d %21s %15d", "Food:", resourcesLooses[0][0], "Food:", resourcesLooses[1][0]);
		datos +="\n"+ String.format("%-15s %10d %21s %15d", "Wood:", resourcesLooses[0][1], "Wood:", resourcesLooses[1][1]);
		datos +="\n"+ String.format("%-15s %10d %21s %15d", "Iron:", resourcesLooses[0][2], "Iron:", resourcesLooses[1][2])+"\n\n";

		for (int i = 0; i < 88; i++) {
		    datos += "*";
		}
		
		datos +="\n"+ "Waste Generated:"+"\n";

		datos +="\n"+ String.format("%-15s %10d", "Wood",wasteWoodIron[0]);
		datos +="\n"+ String.format("%-15s %10d", "Iron",wasteWoodIron[1])+"\n";
		
		if(bool_civiWin) {
			datos +="\nBattle Winned by Civilization, we collect rubble\n\n";
		}
		else {
			datos +="\nBattle Winned by Enemy";
		}
		
		
		return cabecera+"\n\n"+datos;
	}

}
