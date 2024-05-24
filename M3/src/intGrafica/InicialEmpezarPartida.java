package intGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import exceptions.ResourceException;
import interfaces.Variables;
import pkg_Principal.Battle;
import pkg_Principal.Main;

public class InicialEmpezarPartida extends JFrame implements Variables {

	public static void main(String[] args) {
		new InicialEmpezarPartida();

	}
	
	InicialEmpezarPartida(){
			
			setSize(900, 750);
			setDefaultCloseOperation(EXIT_ON_CLOSE); 
			
			initComponents();
			
			setVisible(true); 
		}
		
	public void initComponents(){
			
			JPanel panel = new JPanel();
			JButton boton = new JButton("Empezar partida");
			panel.add(boton);
			this.add(panel);
			
			boton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					 
					Main principal = new Main();
					
					principal.setCurrentCivilization(principal.loadCivilization(2));
					principal.setCurrentCivilizationID(2);

					
					JTabbedPaneUno ventanaPrincipal = new JTabbedPaneUno(principal);
					
					Timer timer = new Timer();
					// =============================================================================
			        int primerTiempoInicial = principal.getCurrentCivilization().getTimeLeft();  // GET del atributo timer de la civilizacion
			     
			        // =============================================================================
			        int tiempoInicial = 179000;

			        // Crear la tarea del temporizador
			        TimerTask task = new TimerTask() {
			        	
			            int tiempoRestante = primerTiempoInicial;
			            boolean primeraEjecucion = true;
			            boolean pause = false;
			            
			            public void run() {
			            	System.out.println(tiempoRestante);
			            	
			            	//"BATTLE COUNTDOWN: " + "120 seconds" + " "
			               	ventanaPrincipal.getBattleCountdownMenuPrincipal().setText("BATTLE COUNTDOWN: " + tiempoRestante/1000 + " seconds ");
			            	ventanaPrincipal.getBattleCountdownEdificios().setText("BATTLE COUNTDOWN: " + tiempoRestante/1000 + " seconds ");
			            	ventanaPrincipal.getBattleCountdownUnidades().setText("BATTLE COUNTDOWN: " + tiempoRestante/1000 + " seconds ");
			               	ventanaPrincipal.getBattleCountdownBattle().setText("BATTLE COUNTDOWN: " + tiempoRestante/1000 + " seconds ");
			            	
			            	if (!pause) {
			            		System.out.println("TIEMPO RESTANTE EN MILISEGUNDOS " + tiempoRestante);
			                	if (tiempoRestante > 0) {
			                        // Imprimir el tiempo restante en segundos
			                        System.out.println("Tiempo restante: " + tiempoRestante / 1000 + " segundos");
			                          // Decrementar en 1 segundo (1000 milisegundos)
			                        
			                        // COMPROBACIÓN
			                        if (principal.getEnemyUnits() == null) {
			                        	System.out.println("No hay ejercito enemigo cargado");
			                        }
			                        
			                        if (tiempoRestante % 30000 == 0) { // cada 30 segundos
			                        	System.out.println("=/".repeat(100));
			                        	System.out.println("TIEMPO RESTANTE DENTRO DEL GENERADOR DE RECURSOS " + tiempoRestante);
			                        	System.out.println("=".repeat(100));
			            				System.out.println("ANTES");
			            				System.out.println("Food = " + principal.getCurrentCivilization().getFood());
			            				System.out.println(" + " + CIVILIZATION_FOOD_GENERATED);
			            				System.out.println(" + " + principal.getCurrentCivilization().getFarm() + " * " + CIVILIZATION_FOOD_GENERATED_PER_FARM + " = " + CIVILIZATION_FOOD_GENERATED_PER_FARM * principal.getCurrentCivilization().getFarm());
			            				System.out.println("Wood = " + principal.getCurrentCivilization().getWood());
			               				System.out.println(" + " + CIVILIZATION_WOOD_GENERATED);
			               				System.out.println(" + " + principal.getCurrentCivilization().getCarpentry() + " * " + CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY + " = " + CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY * principal.getCurrentCivilization().getCarpentry());
			            				System.out.println("Iron = " + principal.getCurrentCivilization().getIron());
			               				System.out.println(" + " + CIVILIZATION_IRON_GENERATED);
			               				System.out.println(" + " + principal.getCurrentCivilization().getSmithy() + " * " + CIVILIZATION_IRON_GENERATED_PER_SMITHY + " = " + CIVILIZATION_IRON_GENERATED_PER_SMITHY * principal.getCurrentCivilization().getSmithy());
			            				System.out.println("Mana = " + principal.getCurrentCivilization().getMana());
			            				System.out.println(" + " + principal.getCurrentCivilization().getMagicTower() + " * " + CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER + " = " + CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER * principal.getCurrentCivilization().getMagicTower());
			            				
			            				principal.getCurrentCivilization().setFood(principal.getCurrentCivilization().getFood()+ CIVILIZATION_FOOD_GENERATED + CIVILIZATION_FOOD_GENERATED_PER_FARM * principal.getCurrentCivilization().getFarm());
			            				principal.getCurrentCivilization().setWood(principal.getCurrentCivilization().getWood()+ CIVILIZATION_WOOD_GENERATED + CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY * principal.getCurrentCivilization().getCarpentry());
			            				principal.getCurrentCivilization().setIron(principal.getCurrentCivilization().getIron()+ CIVILIZATION_IRON_GENERATED + CIVILIZATION_IRON_GENERATED_PER_SMITHY * principal.getCurrentCivilization().getSmithy());
			            				principal.getCurrentCivilization().setMana(principal.getCurrentCivilization().getMana()+ CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER * principal.getCurrentCivilization().getMagicTower());
			            				
			            				ventanaPrincipal.getFoodEdificios().setText(String.valueOf(principal.getCurrentCivilization().getFood()));
			            				ventanaPrincipal.getFoodUnits().setText(String.valueOf(principal.getCurrentCivilization().getFood()));
			            				ventanaPrincipal.getWoodEdificios().setText(String.valueOf(principal.getCurrentCivilization().getWood()));
			            				ventanaPrincipal.getWoodUnits().setText(String.valueOf(principal.getCurrentCivilization().getWood()));
			            				ventanaPrincipal.getIronEdificios().setText(String.valueOf(principal.getCurrentCivilization().getIron()));
			            				ventanaPrincipal.getIronUnits().setText(String.valueOf(principal.getCurrentCivilization().getIron()));
			            				ventanaPrincipal.getManaEdificios().setText(String.valueOf(principal.getCurrentCivilization().getMana()));
			            				ventanaPrincipal.getManaUnits().setText(String.valueOf(principal.getCurrentCivilization().getMana()));
			            				
			            				System.out.println("-".repeat(100));
			            				
			            				System.out.println("DESPUES");
			            				System.out.println("Food = " + principal.getCurrentCivilization().getFood());
			            				System.out.println("Wood = " + principal.getCurrentCivilization().getWood());
			            				System.out.println("Iron = " + principal.getCurrentCivilization().getIron());
			            				System.out.println("Mana = " + principal.getCurrentCivilization().getMana());
			            				System.out.println("=".repeat(100));
			                        	System.out.println("SE HAN GENERADO RECURSOS");
			                        	System.out.println("=/".repeat(100));
			                        }
			                        
			                        if (principal.getEnemyUnits() == null && primeraEjecucion && tiempoRestante < 120000) {
			                        	System.out.println("=/".repeat(100));
			                        	System.out.println("TIEMPO RESTANTE DENTRO DEL GENERADOR DE ENEMIGOS " + tiempoRestante);
			                        	
			                        	principal.setEnemyUnits(principal.createEnemyArmy(principal.getCurrentCivilization()));
			                        	principal.getEnemyUnits()[0].size();
			                        	
			                        	System.out.println("EN EL EJERCITO ENEMIGO HAY:");
			                        	System.out.println("Swordsman = " + principal.getEnemyUnits()[0].size());
			                        	System.out.println("Spearman = " + principal.getEnemyUnits()[1].size());
			                        	System.out.println("Crossbow = " + principal.getEnemyUnits()[2].size());
			                        	System.out.println("Cannon = " + principal.getEnemyUnits()[3].size());
			                        	
			                        	/*
			                        	for (ArrayList<MilitaryUnit> unidades : principal.getEnemyUnits()) {
			    	       					System.out.println(unidades.size());
			    	       					for (MilitaryUnit unidad : unidades) {
			    	       						System.out.println(unidad.getClass().toString());
			    	       					}
			    	       				}
			    	       				*/
			                        	
			                        	System.out.println("SE HA GENERADO EJERCITO ENEMIGO en carga de partida");
			                        	System.out.println("=/".repeat(100));
			                        }
			                        
			                        if (tiempoRestante == 120000) {
			                        	System.out.println("=/".repeat(100));
			                        	System.out.println("TIEMPO RESTANTE DENTRO DEL GENERADOR DE ENEMIGOS " + tiempoRestante);
			                        	principal.setEnemyUnits(principal.createEnemyArmy(principal.getCurrentCivilization()));
			                        	System.out.println("EN EL EJERCITO ENEMIGO HAY:");
			                        	System.out.println("Swordsman = " + principal.getEnemyUnits()[0].size());
			                        	System.out.println("Spearman = " + principal.getEnemyUnits()[1].size());
			                        	System.out.println("Crossbow = " + principal.getEnemyUnits()[2].size());
			                        	System.out.println("Cannon = " + principal.getEnemyUnits()[3].size());
			                        	
			    	       				// SOLAMENTE ES PARA VER RESULTADOS
			                        	/*
			    	       				for (ArrayList<MilitaryUnit> unidades : principal.getEnemyUnits()) {
			    	       					System.out.println(unidades.size());
			    	       					for (MilitaryUnit unidad : unidades) {
			    	       						System.out.println(unidad.getClass().toString());
			    	       					}
			    	       				}
			    	       				*/
			    	       				 
			    	       				 // Se ejecuta ventana viewThreat
			                        	principal.viewthreat(principal.getEnemyUnits());
			    	                    System.out.println("SE HA GENERADO EJERCITO ENEMIGO");
			    	                    System.out.println("=/".repeat(100));
			    	                }
			                    	tiempoRestante -= 1000;
			                    	principal.getCurrentCivilization().setTimeLeft(tiempoRestante);
			                    	
			                    } else {
			                    	
			                    	if (principal.getEnemyUnits() == null && primeraEjecucion) {
			                        	System.out.println("=/".repeat(100));
			                        	System.out.println("TIEMPO RESTANTE DENTRO DEL GENERADOR DE ENEMIGOS " + tiempoRestante);
			                        	
			                        	principal.setEnemyUnits(principal.createEnemyArmy(principal.getCurrentCivilization()));
			                        	principal.getEnemyUnits()[0].size();
			                        	
			                        	System.out.println("EN EL EJERCITO ENEMIGO HAY:");
			                        	System.out.println("Swordsman = " + principal.getEnemyUnits()[0].size());
			                        	System.out.println("Spearman = " + principal.getEnemyUnits()[1].size());
			                        	System.out.println("Crossbow = " + principal.getEnemyUnits()[2].size());
			                        	System.out.println("Cannon = " + principal.getEnemyUnits()[3].size());
			                        	
			                        	/*
			                        	for (ArrayList<MilitaryUnit> unidades : principal.getEnemyUnits()) {
			    	       					System.out.println(unidades.size());
			    	       					for (MilitaryUnit unidad : unidades) {
			    	       						System.out.println(unidad.getClass().toString());
			    	       					}
			    	       				}
			    	       				*/
			                        	
			                        	System.out.println("SE HA GENERADO EJERCITO ENEMIGO en carga de partida");
			                        	System.out.println("=/".repeat(100));
			                        }
			                    	
			                        // Ejecutar la tarea del temporizador
			                    	System.out.println("=/".repeat(100));
			                        System.out.println("¡Ejecutando tarea del temporizador!");
			                        System.out.println("--".repeat(100));
			                        System.out.println("Se ha generado batalla dentro del timer");
			                        
			                        
			                        // AQUI SE IMPLEMENTA LA BATALLA
			                        
			                        Battle bt = new Battle(principal.getCurrentCivilization().getArmy(),principal.getEnemyUnits());
			        				
			                        // insertar en la BBDD la batalla y sus reportes
			                        principal.updateBattle(principal.getCurrentCivilizationID(),bt.getReportePasos(), bt.getReporte());
			                        
			                        
			        				int[] resourcesWin = bt.getWasteWoodIron();
			        				boolean civilizationWin = bt.getBool_civiWin();
			        				
			        				if(civilizationWin) {
			        					principal.addResourcesCivilization(resourcesWin, principal.getCurrentCivilization());
			        				}
			        				
			        				new BattleOcurred(civilizationWin, resourcesWin);
			        				// guardar el juego
			        				principal.saveGame(principal.getCurrentCivilizationID(), principal.getCurrentCivilization());
			                        
			                        //
			                        
			                        System.out.println("=/".repeat(100));
			                        principal.setEnemyUnits(null);
			                        // Reiniciar el tiempo restante
			                        if (primeraEjecucion) {
			                            primeraEjecucion = false;
			                        } 
			                        tiempoRestante = tiempoInicial;
			                        principal.getCurrentCivilization().setTimeLeft(tiempoRestante);
			                    }
			            	}
			            	
			            }
			        };
			        
			        // Programar el temporizador para ejecutar la tarea cada segundo
			        timer.scheduleAtFixedRate(task, 0, 1000);  // Ejecutar la tarea inmediatamente y luego cada segundo
					
				}
				
			});
		
		}
	

}
