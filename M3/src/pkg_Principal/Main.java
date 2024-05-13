package pkg_Principal;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.MilitaryUnit;
import interfaces.Variables;
import pkg_AttackUnit.*;
import pkg_DefenseUnit.*;
import pkg_SpecialUnit.*;


public class Main implements Variables {
	// variable estática que guarda el array de las unidades enemigas
	private static ArrayList<MilitaryUnit>[] enemyUnits;
	
	public static void main(String[] args) {
		
		// Esto son pruebas
		ArrayList<MilitaryUnit>[] civilizationUnits = new ArrayList[9];
		Civilization c1 =  new Civilization(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, civilizationUnits);
		
		// Se inicializa la unidad
		enemyUnits = new ArrayList[4];
		
		// Esto es el timer que se refiere a la creacion de tropas enemigas
		Timer timerAssignEnemyArmy = new Timer();
		TimerTask assignEnemyArmy = new TimerTask() {

			 public void run() {

				 enemyUnits = createEnemyArmy(c1);
				 
				 // SOLAMENTE ES PARA VER RESULTADOS
				 for (ArrayList<MilitaryUnit> unidades : enemyUnits) {
						System.out.println(unidades.size());
						for (MilitaryUnit unidad : unidades) {
							System.out.println(unidad.getClass().toString());
						}
					}
				 
				 // Se ejecuta ventana viewThreat
				 viewthreat(enemyUnits);

			 }
			 
		};
		// EL QUE VALE ES EL COMENTADO, el otro es para que vaya más rápido de pruebas	
		// timerAssignEnemyArmy.schedule(assignEnemyArmy, 60000, 180000);	CON CONTADOR CORRECTO	
		timerAssignEnemyArmy.schedule(assignEnemyArmy, 10000, 60000);	
		
          
        }
	
	public static ArrayList<MilitaryUnit>[] createEnemyArmy(Civilization civilization) {
		
		// Inicialización de los arraylist de las unidades
		ArrayList<MilitaryUnit>[] enemyUnits = new ArrayList[4];
		for (int i = 0; i < enemyUnits.length; i++) {
	        enemyUnits[i] = new ArrayList<MilitaryUnit>();
	    }
		
		// Recursos iniciales que usan los enemigos (+6% por cada batalla)
		int foodEnemyResource = FOOD_BASE_ENEMY_ARMY + (FOOD_BASE_ENEMY_ARMY * ENEMY_FLEET_INCREASE/100) * civilization.getBattles();
		int woodEnemyResource = WOOD_BASE_ENEMY_ARMY + (WOOD_BASE_ENEMY_ARMY * ENEMY_FLEET_INCREASE/100) * civilization.getBattles();
		int ironEnemyResource = IRON_BASE_ENEMY_ARMY + (IRON_BASE_ENEMY_ARMY * ENEMY_FLEET_INCREASE/100) * civilization.getBattles();
		
		System.out.println("\nRECURSOS INICIALES");
		System.out.println("Food = " + foodEnemyResource);
		System.out.println("Wood = " + woodEnemyResource);
		System.out.println("Iron = " + ironEnemyResource);
		System.out.println();
		System.out.println("COMIENZA LA GENERACIÓN DE TROPAS");
		System.out.println();
		
		// Mientras cumpla con los requisitos de crear un swordman, se generan unidades
		while(foodEnemyResource > FOOD_COST_SWORDSMAN && woodEnemyResource > WOOD_COST_SWORDSMAN && ironEnemyResource > IRON_COST_SWORDSMAN) {
			
			// Chance del 1 al 100
			int chance =  (int) (Math.random() * 100 + 1);
			
			if (chance <= 35) {
				
				// Si tiene los suficientes recursos... se genera unidad correspondiente
				if (foodEnemyResource > FOOD_COST_SWORDSMAN && woodEnemyResource > WOOD_COST_SWORDSMAN && ironEnemyResource > IRON_COST_SWORDSMAN) {
					System.out.println("Food = " + foodEnemyResource + " Coste = " + FOOD_COST_SWORDSMAN + " = " + (foodEnemyResource - FOOD_COST_SWORDSMAN));
					System.out.println("Wood = " + woodEnemyResource + " Coste = " + WOOD_COST_SWORDSMAN + " = " + (woodEnemyResource - WOOD_COST_SWORDSMAN));
					System.out.println("Iron = " + ironEnemyResource + " Coste = " + IRON_COST_SWORDSMAN + " = " + (ironEnemyResource - IRON_COST_SWORDSMAN));
					System.out.println("SWORDSMAN CREADO + " + chance);
					enemyUnits[0].add(new Swordsman());
					
					// Se restan recursos
					foodEnemyResource -= FOOD_COST_SWORDSMAN;
					woodEnemyResource -= WOOD_COST_SWORDSMAN;
					ironEnemyResource -= IRON_COST_SWORDSMAN;
				}
				
		    } else if (chance <= 60) {
		    	
		    	if (foodEnemyResource > FOOD_COST_SPEARMAN && woodEnemyResource > WOOD_COST_SPEARMAN && ironEnemyResource > IRON_COST_SPEARMAN) {
		    		System.out.println("Food = " + foodEnemyResource + " Coste = " + FOOD_COST_SPEARMAN + " = " + (foodEnemyResource - FOOD_COST_SPEARMAN));
					System.out.println("Wood = " + woodEnemyResource + " Coste = " + WOOD_COST_SPEARMAN + " = " + (woodEnemyResource - WOOD_COST_SPEARMAN));
					System.out.println("Iron = " + ironEnemyResource + " Coste = " + IRON_COST_SPEARMAN + " = " + (ironEnemyResource - IRON_COST_SPEARMAN));
			    	System.out.println("SPEARMAN CREADO + " + chance);
			    	enemyUnits[1].add(new Spearman());
			    	foodEnemyResource -= FOOD_COST_SPEARMAN;
					woodEnemyResource -= WOOD_COST_SPEARMAN;
					ironEnemyResource -= IRON_COST_SPEARMAN;
		    	}

		    	
		    } else if (chance <= 80) {
		    	
		    	if (foodEnemyResource > FOOD_COST_CROSSBOW && woodEnemyResource > WOOD_COST_CROSSBOW && ironEnemyResource > IRON_COST_CROSSBOW) {
		    		System.out.println("Food = " + foodEnemyResource + " Coste = " + FOOD_COST_CROSSBOW + " = " + (foodEnemyResource - FOOD_COST_CROSSBOW));
					System.out.println("Wood = " + woodEnemyResource + " Coste = " + WOOD_COST_CROSSBOW + " = " + (woodEnemyResource - WOOD_COST_CROSSBOW));
					System.out.println("Iron = " + ironEnemyResource + " Coste = " + IRON_COST_CROSSBOW + " = " + (ironEnemyResource - IRON_COST_CROSSBOW));
			    	System.out.println("CROSSBOW CREADO + " + chance);
			    	enemyUnits[2].add(new Crossbow());
			    	foodEnemyResource -= FOOD_COST_CROSSBOW;
					woodEnemyResource -= WOOD_COST_CROSSBOW;
					ironEnemyResource -= IRON_COST_CROSSBOW;
		    	}
		    	
		    } else {
		    	
		    	if (foodEnemyResource > FOOD_COST_CANNON && woodEnemyResource > WOOD_COST_CANNON && ironEnemyResource > IRON_COST_CANNON) {
		    		System.out.println("Food = " + foodEnemyResource + " Coste = " + FOOD_COST_CANNON + " = " + (foodEnemyResource - FOOD_COST_CANNON));
					System.out.println("Wood = " + woodEnemyResource + " Coste = " + WOOD_COST_CANNON + " = " + (woodEnemyResource - WOOD_COST_CANNON));
					System.out.println("Iron = " + ironEnemyResource + " Coste = " + IRON_COST_CANNON + " = " + (ironEnemyResource - IRON_COST_CANNON));
			    	System.out.println("CANNON CREADO + " + chance);
			    	enemyUnits[3].add(new Cannon());
			    	foodEnemyResource -= FOOD_COST_CANNON;
					woodEnemyResource -= WOOD_COST_CANNON;
					ironEnemyResource -= IRON_COST_CANNON;
		    	}
		    }
		}
		
			System.out.println("\nBUCLE DE CREACION CERRADO / RECURSOS SOBRANTES");
			System.out.println("Food = " + foodEnemyResource + " COSTE = " + FOOD_COST_SWORDSMAN);
			System.out.println("Wood = " + woodEnemyResource + " COSTE = " + WOOD_COST_SWORDSMAN);
			System.out.println("Iron = " + ironEnemyResource + " COSTE = " + IRON_COST_SWORDSMAN);
			
			return enemyUnits;
		}
	
	// metodo que ejecuta ventana de peligro enemigo
	public static void viewthreat(ArrayList<MilitaryUnit>[] enemyUnit) {
		
		new EnemiesIncoming(enemyUnit);
		
	}


}

class EnemiesIncoming extends JFrame {
	
	private JPanel panelPrincipal;
	private JLabel labelAttention, labelMessage, labelSwordsman, labelSpearman, labelCrossbow, labelCannon;
	private JButton salir;
	
	public EnemiesIncoming(ArrayList<MilitaryUnit>[] enemyUnit) {
		
		this.setTitle("ENEMIES INCOMING!");
		this.setSize(500, 300);
		// setResizable(false);
		this.setLocationRelativeTo(null); 
		
		initComponents(enemyUnit);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void initComponents(ArrayList<MilitaryUnit>[] enemyUnit) {
		
		JPanel panelPrincipal = new JPanel();
		JLabel labelAttention = new JLabel("Careful! There are enemies nearby your civilization!");
		JLabel labelMessage = new JLabel("The following units have been sighted: ");
		JLabel labelSwordsman = new JLabel("Swordsman: " + enemyUnit[0].size());
		JLabel labelSpearman = new JLabel("Spearman: " + enemyUnit[1].size());
		JLabel labelCrossbow = new JLabel("Crossbow: " + enemyUnit[2].size());
		JLabel labelCannon = new JLabel("Cannon: " + enemyUnit[3].size());
		JButton salir =  new JButton("Exit");
				
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		panelPrincipal.add(labelAttention);
		panelPrincipal.add(labelMessage);
		panelPrincipal.add(labelSwordsman);
		panelPrincipal.add(labelSpearman);
		panelPrincipal.add(labelCrossbow);
		panelPrincipal.add(labelCannon);
		panelPrincipal.add(salir);
		this.add(panelPrincipal);
		
		salir.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
		
	}
	
}

