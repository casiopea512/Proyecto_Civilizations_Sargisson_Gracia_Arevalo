package intGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import exceptions.ResourceException;
import interfaces.Variables;

import exceptions.ResourceException;
import interfaces.MilitaryUnit;
import interfaces.Variables;
import pkg_AttackUnit.AttackUnit;
import pkg_DefenseUnit.DefenseUnit;
import pkg_Principal.Battle;
import pkg_Principal.Main;



public class JTabbedPaneUno extends JFrame implements Variables {

	// LÓGICA TIMER
	private Timer timer;
	private boolean pauseGame;

	// INTERFAZ 

	private JTabbedPane tabbedPane;
	private JPanel panelInternoUno, panelInternoDos, panelInternoTres, panelInternoCuatro;
	//////////////////////////////////////////////////////////////////////////////////////////
	private JPanel panelTotalEti3,panel1, panel2, panel3, panel4, panelPrincipal,panel11,panel22,panel33,panelNorte,panel1Central,panelSud;
	private JPanel panelEti1,panelEti2,panelEti4,panelEti5,panelEti6,panelEti7,panelEti8,panelEti9,panelEti10,panelEti3,panelTotalEti;
	private JLabel etiqueta1, civili, mtower, church,mtower2,church2,farm,farm2,smithy,smithy2,carprntry,carpentry2;
	private JLabel tec,alevel,alevel2,dlevel,dlevel2,battle,battle2;
	private BufferedImage imagenMapa, escoreWood, escoreIron, escoreMana,imageIcon;
	private JTabbedPane  panelJPMenu;
	private JPanel panelTotalEti2,panelEti11,panelEti12,panelEti13,panelEti14,panelEti15,panelEti16,panelEti17,panelEti18,panelEti19,panelEti20,panelEti21,panelEti22,panelEti23,panelEti24,panelEti25,panelEti26,panelEti27,panelEti28,panelEti29,panelEti30,panelEti31,panelEti32;
	private JLabel attack,sword,spearman,crosbow,cannon,deffense,tower,catapult,rocket,special,magician,priest;
	private JLabel sword2,spearman2,crosbow2,cannon2,tower2,catapult2,rocket2,magician2,priest2;
	private JLabel current,food,wood,iron,mana,resources,foodd,woodd,ironn,manaa,food2,wood2,iron2,mana2,foodd2,woodd2,ironn2,manaa2;;

	//private Civilization civilization;

	// RECURSOS PANEL 

	// ICONOS REUTILIZABLES
	private ImageIcon iconFood, iconWood, iconIron, iconMana;

	// RECURSOS PANEL EDIFICIOS
	private JPanel panelRecursosEdificios, panelPrincipalEdificios;
	private JLabel foodEdificios, woodEdificios, ironEdificios, manaEdificios;

	// RECURSOS PANEL UNIDADES
	private JPanel panelRecursosUnits, panelPrincipalUnidades;
	private JLabel foodUnits, woodUnits, ironUnits, manaUnits;

	// BARRA INFERIOR 
	private JPanel panelInferior;

	private JButton viewthreat, pause, save, exit; // REUTILIZABLES

	private JLabel battleCountdownMenuPrincipal;
	private JLabel battleCountdownEdificios;
	private JLabel battleCountdownUnidades;
	private JLabel battleCountdownBattle;

	// INICIALIZACION LABELS BUILDINGS
	private JLabel attentionLabelBuilding;
	private ArrayList<JLabel> arrayCostDefenseTechnology;
	private ArrayList<JLabel> arrayCostAttackTechnology;

	// INICIALIZACION LABELS UNIDADES
	private JLabel attentionLabelUnits;
	private ArrayList<JLabel> damageUnitsArrayLabel;
	private ArrayList<JLabel> armorUnitsArrayLabel;
	private ArrayList<JLabel> totalUnitsArrayLabel;

	JTabbedPaneUno(Main main){

		setSize(900, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 

		initComponents(main);

		setResizable(true);
		setVisible(true); 


		// TIMER

		timer = new Timer();
		// =============================================================================
		int primerTiempoInicial = main.getCurrentCivilization().getTimeLeft();  // GET del atributo timer de la civilizacion
		// =============================================================================

		int tiempoInicial = 179000;
		pauseGame = false;

		// Crear la tarea del temporizador
		TimerTask task = new TimerTask() {

			int tiempoRestante = primerTiempoInicial;
			boolean primeraEjecucion = true;


			public void run() {

				System.out.println(tiempoRestante);

				//"BATTLE COUNTDOWN: " + "120 seconds" + " "
				battleCountdownMenuPrincipal.setText("NEXT BATTLE IN " + tiempoRestante/1000 + " SECONDS ");
				battleCountdownEdificios.setText("NEXT BATTLE IN " + tiempoRestante/1000 + " SECONDS ");
				battleCountdownUnidades.setText("NEXT BATTLE IN " + tiempoRestante/1000 + " SECONDS ");
				battleCountdownBattle.setText("NEXT BATTLE IN " + tiempoRestante/1000 + " SECONDS ");

				if (!pauseGame) {
					System.out.println("TIEMPO RESTANTE EN MILISEGUNDOS " + tiempoRestante);
					if (tiempoRestante > 0) {
						// Imprimir el tiempo restante en segundos
						System.out.println("Tiempo restante: " + tiempoRestante / 1000 + " segundos");
						// Decrementar en 1 segundo (1000 milisegundos)

						// COMPROBACIÓN
						if (main.getEnemyUnits() == null) {
							System.out.println("No hay ejercito enemigo cargado");
						}


						// guardar el juego: IF !TIEMPO RESTANTE && 179000
						if (!primeraEjecucion) {
                            if (tiempoRestante == 179000) {
                                main.saveGame(main.getCurrentCivilizationID(), main.getCurrentCivilization());
                            }
                        }

						if (tiempoRestante % 30000 == 0) { // cada 30 segundos

							//                        	System.out.println("=/".repeat(100));
							//                        	System.out.println("TIEMPO RESTANTE DENTRO DEL GENERADOR DE RECURSOS " + tiempoRestante);
							//                        	System.out.println("=".repeat(100));
							//            				System.out.println("ANTES");
							//            				System.out.println("Food = " + main.getCurrentCivilization().getFood());
							//            				System.out.println(" + " + CIVILIZATION_FOOD_GENERATED);
							//            				System.out.println(" + " + main.getCurrentCivilization().getFarm() + " * " + CIVILIZATION_FOOD_GENERATED_PER_FARM + " = " + CIVILIZATION_FOOD_GENERATED_PER_FARM * principal.getCurrentCivilization().getFarm());
							//            				System.out.println("Wood = " + main.getCurrentCivilization().getWood());
							//               				System.out.println(" + " + CIVILIZATION_WOOD_GENERATED);
							//               				System.out.println(" + " + main.getCurrentCivilization().getCarpentry() + " * " + CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY + " = " + CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY * principal.getCurrentCivilization().getCarpentry());
							//            				System.out.println("Iron = " + main.getCurrentCivilization().getIron());
							//               				System.out.println(" + " + CIVILIZATION_IRON_GENERATED);
							//               				System.out.println(" + " + main.getCurrentCivilization().getSmithy() + " * " + CIVILIZATION_IRON_GENERATED_PER_SMITHY + " = " + CIVILIZATION_IRON_GENERATED_PER_SMITHY * principal.getCurrentCivilization().getSmithy());
							//            				System.out.println("Mana = " + main.getCurrentCivilization().getMana());
							//            				System.out.println(" + " + main.getCurrentCivilization().getMagicTower() + " * " + CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER + " = " + CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER * principal.getCurrentCivilization().getMagicTower());

							main.getCurrentCivilization().setFood(main.getCurrentCivilization().getFood()+ CIVILIZATION_FOOD_GENERATED + CIVILIZATION_FOOD_GENERATED_PER_FARM * main.getCurrentCivilization().getFarm());
							main.getCurrentCivilization().setWood(main.getCurrentCivilization().getWood()+ CIVILIZATION_WOOD_GENERATED + CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY * main.getCurrentCivilization().getCarpentry());
							main.getCurrentCivilization().setIron(main.getCurrentCivilization().getIron()+ CIVILIZATION_IRON_GENERATED + CIVILIZATION_IRON_GENERATED_PER_SMITHY * main.getCurrentCivilization().getSmithy());
							main.getCurrentCivilization().setMana(main.getCurrentCivilization().getMana()+ CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER * main.getCurrentCivilization().getMagicTower());

							updateResourceLabels(main);

							//            				System.out.println("-".repeat(100));
							//            				
							//            				System.out.println("DESPUES");
							//            				System.out.println("Food = " + main.getCurrentCivilization().getFood());
							//            				System.out.println("Wood = " + main.getCurrentCivilization().getWood());
							//            				System.out.println("Iron = " + main.getCurrentCivilization().getIron());
							//            				System.out.println("Mana = " + main.getCurrentCivilization().getMana());
							//            				System.out.println("=".repeat(100));
							//                        	System.out.println("SE HAN GENERADO RECURSOS");
							//                        	System.out.println("=/".repeat(100));

						}

						if (main.getEnemyUnits() == null && primeraEjecucion && tiempoRestante < 120000) {

							//                        	System.out.println("=/".repeat(100));
							//                        	System.out.println("TIEMPO RESTANTE DENTRO DEL GENERADOR DE ENEMIGOS " + tiempoRestante);

							main.setEnemyUnits(main.createEnemyArmy(main.getCurrentCivilization()));
							main.getEnemyUnits()[0].size();

							//                        	System.out.println("EN EL EJERCITO ENEMIGO HAY:");
							//                        	System.out.println("Swordsman = " + main.getEnemyUnits()[0].size());
							//                        	System.out.println("Spearman = " + main.getEnemyUnits()[1].size());
							//                        	System.out.println("Crossbow = " + main.getEnemyUnits()[2].size());
							//                        	System.out.println("Cannon = " + main.getEnemyUnits()[3].size());
							//                        	
							//                        	
							//                        	for (ArrayList<MilitaryUnit> unidades : principal.getEnemyUnits()) {
							//    	       					System.out.println(unidades.size());
							//    	       					for (MilitaryUnit unidad : unidades) {
							//    	       						System.out.println(unidad.getClass().toString());
							//    	       					}
							//    	       				}
							//    	       				
							//                        	
							//                        	System.out.println("SE HA GENERADO EJERCITO ENEMIGO en carga de partida");
							//                        	System.out.println("=/".repeat(100));
						}

						if (tiempoRestante == 120000) {
							//                        	System.out.println("=/".repeat(100));
							//                        	System.out.println("TIEMPO RESTANTE DENTRO DEL GENERADOR DE ENEMIGOS " + tiempoRestante);

							main.setEnemyUnits(main.createEnemyArmy(main.getCurrentCivilization()));

							//                        	System.out.println("EN EL EJERCITO ENEMIGO HAY:");
							//                        	System.out.println("Swordsman = " + main.getEnemyUnits()[0].size());
							//                        	System.out.println("Spearman = " + main.getEnemyUnits()[1].size());
							//                        	System.out.println("Crossbow = " + main.getEnemyUnits()[2].size());
							//                        	System.out.println("Cannon = " + main.getEnemyUnits()[3].size());
							// SOLAMENTE ES PARA VER RESULTADOS

							for (ArrayList<MilitaryUnit> unidades : main.getEnemyUnits()) {
								System.out.println(unidades.size());
								for (MilitaryUnit unidad : unidades) {
									System.out.println(unidad.getClass().toString());
								}
							}


							// Se ejecuta ventana viewThreat
							main.viewthreat(main.getEnemyUnits());

							//    	                    System.out.println("SE HA GENERADO EJERCITO ENEMIGO");
							//    	                    System.out.println("=/".repeat(100));
						}
						tiempoRestante -= 1000;
						main.getCurrentCivilization().setTimeLeft(tiempoRestante);

					} else {

						if (main.getEnemyUnits() == null && primeraEjecucion) {
							//                        	System.out.println("=/".repeat(100));
							//                        	System.out.println("TIEMPO RESTANTE DENTRO DEL GENERADOR DE ENEMIGOS " + tiempoRestante);

							main.setEnemyUnits(main.createEnemyArmy(main.getCurrentCivilization()));
							main.getEnemyUnits()[0].size();

							//                        	System.out.println("EN EL EJERCITO ENEMIGO HAY:");
							//                        	System.out.println("Swordsman = " + main.getEnemyUnits()[0].size());
							//                        	System.out.println("Spearman = " + main.getEnemyUnits()[1].size());
							//                        	System.out.println("Crossbow = " + main.getEnemyUnits()[2].size());
							//                        	System.out.println("Cannon = " + main.getEnemyUnits()[3].size());

							/*
                        	for (ArrayList<MilitaryUnit> unidades : principal.getEnemyUnits()) {
    	       					System.out.println(unidades.size());
    	       					for (MilitaryUnit unidad : unidades) {
    	       						System.out.println(unidad.getClass().toString());
    	       					}
    	       				}
							 */

							//                        	System.out.println("SE HA GENERADO EJERCITO ENEMIGO en carga de partida");
							//                        	System.out.println("=/".repeat(100));
						}

						// Ejecutar la tarea del temporizador
						System.out.println("=/".repeat(100));
						System.out.println("¡Ejecutando tarea del temporizador!");
						System.out.println("--".repeat(100));
						System.out.println("Se ha generado batalla dentro del timer");


						// AQUI SE IMPLEMENTA LA BATALLA

						Battle bt = new Battle(main.getCurrentCivilization().getArmy(),main.getEnemyUnits());

						System.out.println("El reporte general es:\n"+bt.getReporte());
						System.out.println("El reporte PaP es:\n"+bt.getReportePasos());

						// insertar en la BBDD la batalla y sus reportes
						main.updateBattle(main.getCurrentCivilizationID(),bt.getReportePasos(), bt.getReporte());


						int[] resourcesWin = bt.getWasteWoodIron();
						boolean civilizationWin = bt.getBool_civiWin();

						if(civilizationWin) {
							main.addResourcesCivilization(resourcesWin, main.getCurrentCivilization());
						}

						new BattleOcurred(civilizationWin, resourcesWin);

						// actualizar el número de batallas
						main.getCurrentCivilization().setBattles(main.getCurrentCivilization().getBattles()+1);


						//updates visuales
						updateResourceLabels(main);
						updateUnitsLabel(main);
						updateTechnologyLabels(main);
						updateBattleCounter(main);
						updateBuildingsLabel(main);

						//

						System.out.println("=/".repeat(100));
						main.setEnemyUnits(null);
						// Reiniciar el tiempo restante
						if (primeraEjecucion) {
							primeraEjecucion = false;
						} 
						tiempoRestante = tiempoInicial;
						main.getCurrentCivilization().setTimeLeft(tiempoRestante);
					}
				}

			}
		};

		// Programar el temporizador para ejecutar la tarea cada segundo
		timer.scheduleAtFixedRate(task, 0, 1000);  // Ejecutar la tarea inmediatamente y luego cada segundo

	}

	public void initComponents(Main main){

		tabbedPane = new JTabbedPane();
		this.setTitle("CIVILIZATION");
		initMainMenu(main);
		initBuildingsAndTechnologyPanel(main);
		initUnitsPanel(main);
		initBattlePanel(main);
		add(tabbedPane);
	}


	// RECURSOS

	// RECURSOS PANEL 


	public JLabel getFoodEdificios() {
		return foodEdificios;
	}

	public void setFoodEdificios(JLabel food) {
		this.foodEdificios = food;
	}

	public JLabel getWoodEdificios() {
		return woodEdificios;
	}

	public void setWoodEdificios(JLabel wood) {
		this.woodEdificios = wood;
	}

	public JLabel getIronEdificios() {
		return ironEdificios;
	}

	public void setIronEdificios(JLabel iron) {
		this.ironEdificios = iron;
	}

	public JLabel getManaEdificios() {
		return manaEdificios;
	}

	public void setManaEdificios(JLabel mana) {
		this.manaEdificios = mana;
	}
	// RECURSOS PANEL EDIFICIOS

	public void initResourcesEdificiosPanel(Main main) {


		panelRecursosEdificios = new JPanel();
		panelRecursosEdificios.setLayout(new BoxLayout(panelRecursosEdificios, BoxLayout.X_AXIS));
		panelRecursosEdificios.setBackground(Color.BLACK);

		iconFood = createScaledImageIcon("./imagenes/food.png", 40, 40);
		iconWood = createScaledImageIcon("./imagenes/wood.png", 40, 40);
		iconIron = createScaledImageIcon("./imagenes/iron.png", 40, 40);
		iconMana = createScaledImageIcon("./imagenes/mana.png", 40, 40);

		foodEdificios = new JLabel(String.valueOf(main.getCurrentCivilization().getFood()), iconFood, SwingConstants.CENTER);
		foodEdificios.setForeground(Color.WHITE);
		foodEdificios.setFont(new Font("Arial", Font.BOLD, 20));
		foodEdificios.setHorizontalAlignment(JLabel.CENTER);
		woodEdificios = new JLabel(String.valueOf(main.getCurrentCivilization().getWood()), iconWood, SwingConstants.CENTER);
		woodEdificios.setForeground(Color.WHITE);
		woodEdificios.setFont(new Font("Arial", Font.BOLD, 20));
		woodEdificios.setHorizontalAlignment(JLabel.CENTER);
		ironEdificios = new JLabel(String.valueOf(main.getCurrentCivilization().getIron()), iconIron, SwingConstants.CENTER);
		ironEdificios.setForeground(Color.WHITE);
		ironEdificios.setHorizontalAlignment(JLabel.CENTER);
		ironEdificios.setFont(new Font("Arial", Font.BOLD, 20));
		manaEdificios = new JLabel(String.valueOf(main.getCurrentCivilization().getMana()), iconMana, SwingConstants.CENTER);
		manaEdificios.setForeground(Color.WHITE);
		manaEdificios.setFont(new Font("Arial", Font.BOLD, 20));
		manaEdificios.setHorizontalAlignment(JLabel.CENTER);

		panelRecursosEdificios.add(Box.createHorizontalGlue()); 
		panelRecursosEdificios.add(foodEdificios);
		panelRecursosEdificios.add(Box.createHorizontalGlue()); 
		panelRecursosEdificios.add(woodEdificios);
		panelRecursosEdificios.add(Box.createHorizontalGlue()); 
		panelRecursosEdificios.add(ironEdificios);
		panelRecursosEdificios.add(Box.createHorizontalGlue()); 
		panelRecursosEdificios.add(manaEdificios);
		panelRecursosEdificios.add(Box.createHorizontalGlue());

	}

	// RECURSOS PANEL UNIDADES

	public void initResourcesUnitsPanel(Main main) {

		panelRecursosUnits = new JPanel();
		panelRecursosUnits.setLayout(new BoxLayout(panelRecursosUnits, BoxLayout.X_AXIS));
		panelRecursosUnits.setBackground(Color.BLACK);

		foodUnits = new JLabel(String.valueOf(main.getCurrentCivilization().getFood()), iconFood, SwingConstants.CENTER);
		foodUnits.setForeground(Color.WHITE);
		foodUnits.setFont(new Font("Arial", Font.BOLD, 20));
		foodUnits.setHorizontalAlignment(JLabel.CENTER);
		woodUnits = new JLabel(String.valueOf(main.getCurrentCivilization().getWood()), iconWood, SwingConstants.CENTER);
		woodUnits.setForeground(Color.WHITE);
		woodUnits.setFont(new Font("Arial", Font.BOLD, 20));
		woodUnits.setHorizontalAlignment(JLabel.CENTER);
		ironUnits = new JLabel(String.valueOf(main.getCurrentCivilization().getIron()), iconIron, SwingConstants.CENTER);
		ironUnits.setForeground(Color.WHITE);
		ironUnits.setHorizontalAlignment(JLabel.CENTER);
		ironUnits.setFont(new Font("Arial", Font.BOLD, 20));
		manaUnits = new JLabel(String.valueOf(main.getCurrentCivilization().getMana()), iconMana, SwingConstants.CENTER);
		manaUnits.setForeground(Color.WHITE);
		manaUnits.setFont(new Font("Arial", Font.BOLD, 20));
		manaUnits.setHorizontalAlignment(JLabel.CENTER);

		panelRecursosUnits.add(Box.createHorizontalGlue()); // Spacer for equal distribution
		panelRecursosUnits.add(foodUnits);
		panelRecursosUnits.add(Box.createHorizontalGlue()); // Spacer for equal distribution
		panelRecursosUnits.add(woodUnits);
		panelRecursosUnits.add(Box.createHorizontalGlue()); // Spacer for equal distribution
		panelRecursosUnits.add(ironUnits);
		panelRecursosUnits.add(Box.createHorizontalGlue()); // Spacer for equal distribution
		panelRecursosUnits.add(manaUnits);
		panelRecursosUnits.add(Box.createHorizontalGlue());

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////


	public void initBarraMenuPrincipal(Main main) {

		panelInferior = new JPanel();
		panelInferior.setBackground(Color.BLACK);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));

		JPanel panelCountdown = new JPanel();
		panelCountdown.setBackground(Color.BLACK);
		battleCountdownMenuPrincipal = new JLabel("NEXT BATTLE IN " + main.getCurrentCivilization().getTimeLeft() + " SECONDS ");
		battleCountdownMenuPrincipal.setForeground(Color.WHITE);
		battleCountdownMenuPrincipal.setFont(new Font("Arial", Font.BOLD, 30));
		viewthreat = new JButton("VIEW THREAT");
		viewthreat.setBackground(Color.RED);
		viewthreat.setForeground(Color.WHITE);
		panelCountdown.add(battleCountdownMenuPrincipal);
		panelCountdown.add(viewthreat);
		panelInferior.add(panelCountdown);

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		panelBotones.setBackground(Color.BLACK);
		pause = new JButton("PAUSE GAME");
		pause.setBackground(Color.BLUE);
		pause.setForeground(Color.WHITE);
		save = new JButton("SAVE GAME");
		save.setBackground(Color.BLUE);
		save.setForeground(Color.WHITE);
		exit = new JButton("EXIT GAME");
		exit.setBackground(Color.BLUE);
		exit.setForeground(Color.WHITE);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(pause);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(save);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(exit);
		panelBotones.add(Box.createHorizontalGlue());
		panelInferior.add(panelBotones);

		viewthreat.addActionListener(new EventoViewthreath(main));

		pause.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (pauseGame) {
					System.out.println("RESTART");
					pauseGame = false;
				} else {
					System.out.println("PAUSE");
					pauseGame = true;
				}

			}

		});

		save.addActionListener(new EventoSave(main));

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				main.saveGame(main.getCurrentCivilizationID(), main.getCurrentCivilization());
				timer.cancel();
				dispose();
				new PantallaPrincipal();
			}

		});
	}

	public void initBarraInferiorEdificios(Main main) {
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.BLACK);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));

		JPanel panelCountdown = new JPanel();
		panelCountdown.setBackground(Color.BLACK);
		battleCountdownEdificios = new JLabel("NEXT BATTLE IN " + main.getCurrentCivilization().getTimeLeft() + " SECONDS ");
		battleCountdownEdificios.setForeground(Color.WHITE);
		battleCountdownEdificios.setFont(new Font("Arial", Font.BOLD, 30));
		viewthreat = new JButton("VIEW THREAT");
		viewthreat.setBackground(Color.RED);
		viewthreat.setForeground(Color.WHITE);
		panelCountdown.add(battleCountdownEdificios);
		panelCountdown.add(viewthreat);
		panelInferior.add(panelCountdown);

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		panelBotones.setBackground(Color.BLACK);
		pause = new JButton("PAUSE GAME");
		pause.setBackground(Color.BLUE);
		pause.setForeground(Color.WHITE);
		save = new JButton("SAVE GAME");
		save.setBackground(Color.BLUE);
		save.setForeground(Color.WHITE);
		exit = new JButton("EXIT GAME");
		exit.setBackground(Color.BLUE);
		exit.setForeground(Color.WHITE);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(pause);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(save);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(exit);
		panelBotones.add(Box.createHorizontalGlue());
		panelInferior.add(panelBotones);

		viewthreat.addActionListener(new EventoViewthreath(main));

		pause.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (pauseGame) {
					System.out.println("RESTART");
					pauseGame = false;
				} else {
					System.out.println("PAUSE");
					pauseGame = true;
				}

			}

		});

		save.addActionListener(new EventoSave(main));

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				main.saveGame(main.getCurrentCivilizationID(), main.getCurrentCivilization());
				timer.cancel();
				dispose();
				new PantallaPrincipal();

			}

		});
	}

	public void initBarraInferiorUnidades(Main main) {

		panelInferior = new JPanel();
		panelInferior.setBackground(Color.BLACK);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));

		JPanel panelCountdown = new JPanel();
		panelCountdown.setBackground(Color.BLACK);
		battleCountdownUnidades = new JLabel("NEXT BATTLE IN " + main.getCurrentCivilization().getTimeLeft() + " SECONDS ");
		battleCountdownUnidades.setForeground(Color.WHITE);
		battleCountdownUnidades.setFont(new Font("Arial", Font.BOLD, 30));
		viewthreat = new JButton("VIEW THREAT");
		viewthreat.setBackground(Color.RED);
		viewthreat.setForeground(Color.WHITE);
		panelCountdown.add(battleCountdownUnidades);
		panelCountdown.add(viewthreat);
		panelInferior.add(panelCountdown);

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		panelBotones.setBackground(Color.BLACK);
		pause = new JButton("PAUSE GAME");
		pause.setBackground(Color.BLUE);
		pause.setForeground(Color.WHITE);
		save = new JButton("SAVE GAME");
		save.setBackground(Color.BLUE);
		save.setForeground(Color.WHITE);
		exit = new JButton("EXIT GAME");
		exit.setBackground(Color.BLUE);
		exit.setForeground(Color.WHITE);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(pause);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(save);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(exit);
		panelBotones.add(Box.createHorizontalGlue());
		panelInferior.add(panelBotones);

		viewthreat.addActionListener(new EventoViewthreath(main));

		pause.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (pauseGame) {
					System.out.println("RESTART");
					pauseGame = false;
				} else {
					System.out.println("PAUSE");
					pauseGame = true;
				}

			}

		});

		save.addActionListener(new EventoSave(main));

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				main.saveGame(main.getCurrentCivilizationID(), main.getCurrentCivilization());
				timer.cancel();
				dispose();
				new PantallaPrincipal();
			}

		});
	}

	public void initBarraInferiorBattle(Main main) {
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.BLACK);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));

		JPanel panelCountdown = new JPanel();
		panelCountdown.setBackground(Color.BLACK);
		battleCountdownBattle = new JLabel("NEXT BATTLE IN " + main.getCurrentCivilization().getTimeLeft() + " SECONDS ");
		battleCountdownBattle.setForeground(Color.WHITE);
		battleCountdownBattle.setFont(new Font("Arial", Font.BOLD, 30));
		viewthreat = new JButton("VIEW THREAT");
		viewthreat.setBackground(Color.RED);
		viewthreat.setForeground(Color.WHITE);
		panelCountdown.add(battleCountdownBattle);
		panelCountdown.add(viewthreat);
		panelInferior.add(panelCountdown);

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		panelBotones.setBackground(Color.BLACK);
		pause = new JButton("PAUSE GAME");
		pause.setBackground(Color.BLUE);
		pause.setForeground(Color.WHITE);
		save = new JButton("SAVE GAME");
		save.setBackground(Color.BLUE);
		save.setForeground(Color.WHITE);
		exit = new JButton("EXIT GAME");
		exit.setBackground(Color.BLUE);
		exit.setForeground(Color.WHITE);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(pause);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(save);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(exit);
		panelBotones.add(Box.createHorizontalGlue());
		panelInferior.add(panelBotones);

		viewthreat.addActionListener(new EventoViewthreath(main));

		pause.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (pauseGame) {
					System.out.println("RESTART");
					pauseGame = false;
				} else {
					System.out.println("PAUSE");
					pauseGame = true;
				}

			}

		});

		save.addActionListener(new EventoSave(main));

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				main.saveGame(main.getCurrentCivilizationID(), main.getCurrentCivilization());
				timer.cancel();
				dispose();
				new PantallaPrincipal();
			}

		});
	}



	// PANELES PRINCIPALES

	public void initMainMenu(Main main) {
		panelInternoUno = new JPanel();
		panelInternoUno.setBackground(Color.BLUE);
		panelInternoUno.setLayout(new BorderLayout());
		//////////////////////////////////////////////////////////////////////////////////////////

		ArrayList<JPanel> panels = new ArrayList<>();


		//	        for (int i = 0; i < 50; i++) {
		//	            JPanel panel = new JPanel();
		//	            panel.setName("panelEti" + (i + 1)); 
		//	            panel.setLayout(new FlowLayout(FlowLayout.LEFT,20,0)); 
		//	            //panels.add(panel); 
		//	        }

		panelEti1 = new JPanel();
		panelEti2 = new JPanel();
		panelEti3 = new JPanel();
		panelEti4 = new JPanel();
		panelEti5 = new JPanel();
		panelEti6 = new JPanel();
		panelEti7 = new JPanel();
		panelEti8 = new JPanel();
		panelEti9 = new JPanel();
		panelEti10 = new JPanel();

		panelEti11 = new JPanel();
		panelEti12 = new JPanel();
		panelEti13 = new JPanel();
		panelEti14 = new JPanel();
		panelEti15 = new JPanel();
		panelEti16 = new JPanel();
		panelEti17 = new JPanel();
		panelEti18 = new JPanel();
		panelEti19 = new JPanel();
		panelEti20 = new JPanel();
		panelEti21 = new JPanel();
		panelEti22 = new JPanel();
		panelEti23 = new JPanel();
		panelEti24 = new JPanel();
		panelEti25 = new JPanel();
		panelEti26 = new JPanel();
		panelEti27 = new JPanel();
		panelEti28 = new JPanel();
		panelEti29 = new JPanel();
		panelEti30 = new JPanel();
		panelEti31 = new JPanel();
		panelEti32 = new JPanel();




		panelTotalEti = new JPanel();
		panelTotalEti2 = new JPanel();
		panelTotalEti3 = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panelPrincipal = new JPanel();

		panel11 = new JPanel();
		panel22 = new JPanel();
		panel33 = new JPanel();



		panel1Central = new JPanel();
		panelJPMenu = new JTabbedPane();
		panelEti1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEti2.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti3.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti4.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti5.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti6.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti7.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEti8.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti9.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti10.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));

		panelEti11.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEti12.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti13.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti14.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti15.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti16.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEti17.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti18.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti19.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti20.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEti21.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti22.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti23.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEti24.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti25.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti26.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti27.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti28.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEti29.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti30.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti31.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		panelEti32.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));






		//PANEL111

		civili = new JLabel("CIVILIZATION BUILDINGS");
		civili.setFont(new Font("Times New Roman", Font.BOLD, 30));
		civili.setForeground(Color.BLACK);
		civili.setAlignmentX(Component.LEFT_ALIGNMENT);
		//civili.setPreferredSize(new Dimension(300, 50));
		panelEti1.add(civili);

		mtower = new JLabel("Magic Towers: ");
		int cantidadTower = main.getCurrentCivilization().getMagicTower(); 
		mtower2 = new JLabel(String.valueOf(cantidadTower));
		mtower.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mtower.setForeground(Color.BLACK);
		mtower2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mtower2.setForeground(Color.BLACK);
		panelEti2.add(mtower);
		panelEti2.add(mtower2);


		church = new JLabel("Church: ");
		int cantidadChurch = main.getCurrentCivilization().getChurch(); 
		church2 = new JLabel(String.valueOf(cantidadChurch));
		church.setFont(new Font("Times New Roman", Font.BOLD, 20));
		church.setForeground(Color.BLACK);
		church2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		church2.setForeground(Color.BLACK);
		panelEti3.add(church);
		panelEti3.add(church2);

		farm = new JLabel("Farm: ");
		int cantidadfarm = main.getCurrentCivilization().getFarm(); 
		farm2 = new JLabel(String.valueOf(cantidadfarm));
		farm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		farm.setForeground(Color.BLACK);
		farm2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		farm2.setForeground(Color.BLACK);
		panelEti4.add(farm);
		panelEti4.add(farm2);

		smithy = new JLabel("Smithy: ");
		int cantidadsmithy = main.getCurrentCivilization().getSmithy(); 
		smithy2 = new JLabel(String.valueOf(cantidadsmithy));
		smithy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		smithy.setForeground(Color.BLACK);
		smithy2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		smithy2.setForeground(Color.BLACK);
		panelEti5.add(smithy);
		panelEti5.add(smithy2);

		carprntry = new JLabel("Carperntry: ");
		int cantidadcarprntry =main.getCurrentCivilization().getCarpentry(); 
		carpentry2 = new JLabel(String.valueOf(cantidadcarprntry));
		carprntry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		carprntry.setForeground(Color.BLACK);
		carpentry2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		carpentry2.setForeground(Color.BLACK);
		panelEti6.add(carprntry);
		panelEti6.add(carpentry2);

		tec = new JLabel("TECHNOLOGY");
		tec.setFont(new Font("Times New Roman", Font.BOLD, 30));
		tec.setForeground(Color.BLACK);
		panelEti7.add(tec);

		alevel = new JLabel("Technology Attack: ");
		int cantidadalevel= main.getCurrentCivilization().getTechnologyAttack(); 
		alevel2 = new JLabel(String.valueOf(cantidadalevel));
		alevel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		alevel.setForeground(Color.BLACK);
		alevel2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		alevel2.setForeground(Color.BLACK);
		panelEti8.add(alevel);
		panelEti8.add(alevel2);

		dlevel = new JLabel("Technology Defense: ");
		int cantidaddlevel= main.getCurrentCivilization().getTechnologyDefense(); 
		dlevel2 = new JLabel(""+cantidaddlevel);
		dlevel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		dlevel.setForeground(Color.BLACK);
		dlevel2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		dlevel2.setForeground(Color.BLACK);
		panelEti9.add(dlevel);
		panelEti9.add(dlevel2);

		battle = new JLabel("BATTLE COUNTER: ");
		int cantidadbattle = main.getCurrentCivilization().getBattles(); 
		battle2 = new JLabel(String.valueOf(cantidadbattle));
		battle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		battle.setForeground(Color.BLACK);
		battle2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		battle2.setForeground(Color.BLACK);
		panelEti10.add(battle);
		panelEti10.add(battle2);


		panelTotalEti.setLayout(new BoxLayout(panelTotalEti, BoxLayout.Y_AXIS));
		//panelTotalEti.add(Box.createVerticalStrut(100));

		// Margen entre los paneles y el borde del panelTotalEti
		int margenEntrePaneles = 70;
		panelTotalEti.setBorder(BorderFactory.createEmptyBorder(margenEntrePaneles, margenEntrePaneles, margenEntrePaneles, margenEntrePaneles));

		panelTotalEti.add(panelEti1);
		panelTotalEti.add(panelEti2);
		panelTotalEti.add(panelEti3);
		panelTotalEti.add(panelEti4);
		panelTotalEti.add(panelEti5);
		panelTotalEti.add(panelEti6);
		panelTotalEti.add(panelEti7);
		panelTotalEti.add(panelEti8);
		panelTotalEti.add(panelEti9);
		panelTotalEti.add(panelEti10);


		panel11.setLayout(new BorderLayout());
		panel11.add(panelTotalEti, BorderLayout.CENTER);


		//PANEL122

		civili = new JLabel("ATTACK UNITS");
		civili.setFont(new Font("Times New Roman", Font.BOLD, 30));
		civili.setForeground(Color.BLACK);
		civili.setAlignmentX(Component.LEFT_ALIGNMENT);
		//civili.setPreferredSize(new Dimension(300, 50));
		panelEti11.add(civili);

		sword = new JLabel("Swordsman: ");
		int swordsman = (main.getCurrentCivilization().getArmy())[0].size(); 
		sword2 = new JLabel(String.valueOf(swordsman));
		sword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sword.setForeground(Color.BLACK);
		sword2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sword2.setForeground(Color.BLACK);
		panelEti12.add(sword);
		panelEti12.add(sword2);


		spearman = new JLabel("Spearman: ");
		int spearmann =(main.getCurrentCivilization().getArmy())[1].size();
		spearman2 = new JLabel(String.valueOf(spearmann));
		spearman.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spearman.setForeground(Color.BLACK);
		spearman2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spearman2.setForeground(Color.BLACK);
		panelEti13.add(spearman);
		panelEti13.add(spearman2);

		crosbow = new JLabel("Crosbow: ");
		int crosboww =(main.getCurrentCivilization().getArmy())[2].size();
		crosbow2 = new JLabel(String.valueOf(crosboww));
		crosbow.setFont(new Font("Times New Roman", Font.BOLD, 20));
		crosbow.setForeground(Color.BLACK);
		crosbow2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		crosbow2.setForeground(Color.BLACK);
		panelEti14.add(crosbow);
		panelEti14.add(crosbow2);

		cannon = new JLabel("Cannon: ");
		int cannonn =(main.getCurrentCivilization().getArmy())[3].size();
		cannon2 = new JLabel(String.valueOf(cannonn));
		cannon.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cannon.setForeground(Color.BLACK);
		cannon2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cannon2.setForeground(Color.BLACK);
		panelEti15.add(cannon);
		panelEti15.add(cannon2);

		deffense = new JLabel("DEFFENSE UNITS");
		deffense.setFont(new Font("Times New Roman", Font.BOLD, 30));
		deffense.setForeground(Color.BLACK);
		deffense.setAlignmentX(Component.LEFT_ALIGNMENT);
		//civili.setPreferredSize(new Dimension(300, 50));
		panelEti16.add(deffense);

		tower = new JLabel("Arrow Tower: ");
		int towerr =(main.getCurrentCivilization().getArmy())[4].size(); 
		tower2 = new JLabel(String.valueOf(towerr));
		tower.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tower.setForeground(Color.BLACK);
		tower2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tower2.setForeground(Color.BLACK);
		panelEti17.add(tower);
		panelEti17.add(tower2);

		catapult = new JLabel("Catapult: ");
		int catapultt =(main.getCurrentCivilization().getArmy())[5].size(); 
		catapult2 = new JLabel(String.valueOf(catapultt));
		catapult.setFont(new Font("Times New Roman", Font.BOLD, 20));
		catapult.setForeground(Color.BLACK);
		catapult2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		catapult2.setForeground(Color.BLACK);
		panelEti18.add(catapult);
		panelEti18.add(catapult2);

		rocket = new JLabel("Rocket Lancher Tower: ");
		int rockett =(main.getCurrentCivilization().getArmy())[6].size(); 
		rocket2 = new JLabel(String.valueOf(rockett));
		rocket.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rocket.setForeground(Color.BLACK);
		rocket2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rocket2.setForeground(Color.BLACK);
		panelEti19.add(rocket);
		panelEti19.add(rocket2);

		special = new JLabel("SPECIAL UNITS");
		special.setFont(new Font("Times New Roman", Font.BOLD, 30));
		special.setForeground(Color.BLACK);
		special.setAlignmentX(Component.LEFT_ALIGNMENT);
		//civili.setPreferredSize(new Dimension(300, 50));
		panelEti20.add(special);

		magician = new JLabel("Magician: ");
		int magiciann =(main.getCurrentCivilization().getArmy())[7].size(); 
		magician2 = new JLabel(String.valueOf(magiciann));
		magician.setFont(new Font("Times New Roman", Font.BOLD, 20));
		magician.setForeground(Color.BLACK);
		magician2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		magician2.setForeground(Color.BLACK);
		panelEti21.add(magician);
		panelEti21.add(magician2);

		priest = new JLabel("Priest: ");
		int priestt =(main.getCurrentCivilization().getArmy())[8].size();
		priest2 = new JLabel(String.valueOf(priestt));
		priest.setFont(new Font("Times New Roman", Font.BOLD, 20));
		priest.setForeground(Color.BLACK);
		priest2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		priest2.setForeground(Color.BLACK);
		panelEti22.add(priest);
		panelEti22.add(priest2);


		panelTotalEti2.add(panelEti11);
		panelTotalEti2.add(panelEti12);
		panelTotalEti2.add(panelEti13);
		panelTotalEti2.add(panelEti14);
		panelTotalEti2.add(panelEti15);
		panelTotalEti2.add(panelEti16);
		panelTotalEti2.add(panelEti17);
		panelTotalEti2.add(panelEti18);
		panelTotalEti2.add(panelEti19);
		panelTotalEti2.add(panelEti20);
		panelTotalEti2.add(panelEti21);
		panelTotalEti2.add(panelEti22);

		panelTotalEti2.setLayout(new BoxLayout(panelTotalEti2, BoxLayout.Y_AXIS));
		//panelTotalEti.add(Box.createVerticalStrut(100));

		// Margen entre los paneles y el borde del panelTotalEti
		//int margenEntrePaneles2 = 70;
		panelTotalEti2.setBorder(BorderFactory.createEmptyBorder(margenEntrePaneles, margenEntrePaneles, margenEntrePaneles, margenEntrePaneles));

		panel22.setLayout(new BorderLayout());
		panel22.add(panelTotalEti2, BorderLayout.CENTER);


		//panel133

		current = new JLabel("CURRENT RESOURCES");
		current.setFont(new Font("Times New Roman", Font.BOLD, 30));
		current.setForeground(Color.BLACK);
		current.setAlignmentX(Component.LEFT_ALIGNMENT);
		//civili.setPreferredSize(new Dimension(300, 50));
		panelEti23.add(current);

		food = new JLabel("Food: ");
		int ffood = main.getCurrentCivilization().getFood(); 
		food2 = new JLabel(String.valueOf(ffood));
		food.setFont(new Font("Times New Roman", Font.BOLD, 20));
		food.setForeground(Color.BLACK);
		food2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		food2.setForeground(Color.BLACK);
		panelEti24.add(food);
		panelEti24.add(food2);


		wood = new JLabel("Wood: ");
		int wwood =main.getCurrentCivilization().getWood(); 
		wood2 = new JLabel(String.valueOf(wwood));
		wood.setFont(new Font("Times New Roman", Font.BOLD, 20));
		wood.setForeground(Color.BLACK);
		wood2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		wood2.setForeground(Color.BLACK);
		panelEti25.add(wood);
		panelEti25.add(wood2);

		iron = new JLabel("Iron: ");
		int iiron =main.getCurrentCivilization().getIron(); 
		iron2 = new JLabel(String.valueOf(iiron));
		iron.setFont(new Font("Times New Roman", Font.BOLD, 20));
		iron.setForeground(Color.BLACK);
		iron2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		iron2.setForeground(Color.BLACK);
		panelEti26.add(iron);
		panelEti26.add(iron2);

		mana = new JLabel("Mana: ");
		int mmana =main.getCurrentCivilization().getMana(); 
		mana2 = new JLabel(String.valueOf(mmana));
		mana.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mana.setForeground(Color.BLACK);
		mana2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mana2.setForeground(Color.BLACK);
		panelEti27.add(mana);
		panelEti27.add(mana2);


		resources = new JLabel("RESOURCE GENERATION");
		resources.setFont(new Font("Times New Roman", Font.BOLD, 30));
		resources.setForeground(Color.BLACK);
		resources.setAlignmentX(Component.LEFT_ALIGNMENT);
		//civili.setPreferredSize(new Dimension(300, 50));
		panelEti28.add(resources);
		
//		String.valueOf(CIVILIZATION_FOOD_GENERATED + CIVILIZATION_FOOD_GENERATED_PER_FARM * main.getCurrentCivilization().getFarm()));
//		String.valueOf(CIVILIZATION_WOOD_GENERATED + CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY * main.getCurrentCivilization().getCarpentry()));
//		String.valueOf(CIVILIZATION_IRON_GENERATED + CIVILIZATION_IRON_GENERATED_PER_SMITHY * main.getCurrentCivilization().getSmithy()));
//		String.valueOf(CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER * main.getCurrentCivilization().getMagicTower()));

		foodd = new JLabel("Food: ");
		int fffood = CIVILIZATION_FOOD_GENERATED + CIVILIZATION_FOOD_GENERATED_PER_FARM * main.getCurrentCivilization().getFarm();
		foodd2 = new JLabel(String.valueOf(fffood));
		foodd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		foodd.setForeground(Color.BLACK);
		foodd2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		foodd2.setForeground(Color.BLACK);
		panelEti29.add(foodd);
		panelEti29.add(foodd2);


		woodd = new JLabel("Wood: ");
		int wwwood = CIVILIZATION_WOOD_GENERATED + CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY * main.getCurrentCivilization().getCarpentry();
		woodd2 = new JLabel(String.valueOf(wwwood));
		woodd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		woodd.setForeground(Color.BLACK);
		woodd2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		woodd2.setForeground(Color.BLACK);
		panelEti30.add(woodd);
		panelEti30.add(woodd2);

		ironn = new JLabel("Iron: ");
		int iiiron = CIVILIZATION_IRON_GENERATED + CIVILIZATION_IRON_GENERATED_PER_SMITHY * main.getCurrentCivilization().getSmithy();
		ironn2 = new JLabel(String.valueOf(iiiron));
		ironn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ironn.setForeground(Color.BLACK);
		ironn2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ironn2.setForeground(Color.BLACK);
		panelEti31.add(ironn);
		panelEti31.add(ironn2);

		manaa = new JLabel("Mana: ");
		int mmmana = CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER * main.getCurrentCivilization().getMagicTower(); 
		manaa2 = new JLabel(String.valueOf(mmmana));
		manaa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		manaa.setForeground(Color.BLACK);
		manaa2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		manaa2.setForeground(Color.BLACK);
		panelEti32.add(manaa);
		panelEti32.add(manaa2);



		panelTotalEti3.add(panelEti23);
		panelTotalEti3.add(panelEti24);
		panelTotalEti3.add(panelEti25);
		panelTotalEti3.add(panelEti26);
		panelTotalEti3.add(panelEti27);
		panelTotalEti3.add(panelEti28);
		panelTotalEti3.add(panelEti29);
		panelTotalEti3.add(panelEti30);
		panelTotalEti3.add(panelEti31);
		panelTotalEti3.add(panelEti32);

		panelTotalEti3.setLayout(new BoxLayout(panelTotalEti3, BoxLayout.Y_AXIS));
		//panelTotalEti.add(Box.createVerticalStrut(100));

		// Margen entre los paneles y el borde del panelTotalEti
		//int margenEntrePaneles2 = 70;
		panelTotalEti3.setBorder(BorderFactory.createEmptyBorder(margenEntrePaneles, margenEntrePaneles, margenEntrePaneles, margenEntrePaneles));

		panel33.setLayout(new BorderLayout());
		panel33.add(panelTotalEti3, BorderLayout.CENTER);







		ImageIcon imagenMapa;
		imagenMapa = createScaledImageIcon1("./imagenes/mapa.jpg", 1300, 980);
		etiqueta1 = new JLabel(imagenMapa);


		//panel1.add(etiqueta1);
		panelPrincipal.setLayout(new BorderLayout());

//		tabbedPane.setForegroundAt(i, Color.WHITE);
//		tabbedPane.setBackgroundAt(i, Color.BLACK);
//	} else {
//		tabbedPane.setForegroundAt(i, Color.BLACK);
//		tabbedPane.setBackgroundAt(i, Color.WHITE);
//	}

		//menu pestañas principal
		
		// Establecer UIManager para cambiar colores de pestañas
//        UIManager.put("TabbedPane.selected", Color.BLACK);
//        UIManager.put("TabbedPane.background", Color.WHITE);
//        UIManager.put("TabbedPane.foreground", Color.BLACK);
//        UIManager.put("TabbedPane.unselectedBackground", Color.WHITE);
//        UIManager.put("TabbedPane.selectedForeground", Color.WHITE);


     // Establecer el LookAndFeel de la UI
//        try {
//            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
		// Personalizar la fuente y tamaño de los títulos de las pestañas
		Font tabFont = new Font("Arial", Font.BOLD, 20);
		 // Establecer color de fondo para todas las pestañas
		panelJPMenu.setBackground(Color.GRAY);

        // Establecer color del texto para todas las pestañas
        panelJPMenu.setForeground(Color.BLACK);
		panelJPMenu.setFont(tabFont);

		// Inicialmente actualizar los colores
		//updateTabColors(panelJPMenu);
		// Listener para actualizar colores al seleccionar una pestaña
		 //panelJPMenu.addChangeListener(e -> updateTabColors(panelJPMenu));


		// Inicialmente actualizar los colores
		//updateTabColors(panelCentral);
		//panelCentral.setBorder(null); // Eliminar bordes del JScrollPane

		panel11.setBackground(Color.DARK_GRAY);
		panel22.setBackground(Color.DARK_GRAY);
		panel33.setBackground(Color.DARK_GRAY);

		// Configurar las pestañas
		panelJPMenu.addTab(" Civilization ", panel11);
		panelJPMenu.addTab(" Units ", panel22);
		panelJPMenu.addTab(" Resources ", panel33);


		// Personalizar la fuente y tamaño de los títulos de las pestañas
		
		// Inicialmente actualizar los colores

		// Listener para actualizar colores al seleccionar una pestaña


		// Establecer tamaño preferido para panelJPMenu
		panelJPMenu.setPreferredSize(new Dimension(615, 980));





		// Agregar el contenedor al panel1
		//panel1Central.setLayout(new BorderLayout());
		panel1Central.add(etiqueta1);
		panel1Central.add(panelJPMenu);
		panel1Central.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel1Central.setBorder(BorderFactory.createEmptyBorder()); // Elimina los bordes del panel

		panel1Central.setBackground(Color.BLACK);
		panelPrincipal.add(panel1Central, BorderLayout.CENTER);
		//		panelPrincipal=new JPanel();
		//		panelPrincipal.setBackground(Color.CYAN);
		initBarraMenuPrincipal(main);

		panelInternoUno.add(panelPrincipal, BorderLayout.CENTER); // < todo mi p<nel central
		panelInternoUno.add(panelInferior, BorderLayout.SOUTH);
		tabbedPane.addTab("Main menu", panelInternoUno);
		try {
			imageIcon = ImageIO.read(new File("./imagenes/images.png"));
		} catch (IOException e) {
			System.out.println("El archivo no se encuentra");
		}

		//this.setSize(1200, 900);
		this.setTitle("CIVILIZATION");
		this.setIconImage(imageIcon);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);

		// INTEGRACION DE PANEL SUPERIOR CENTRAL

		//JPanel panelPrincipal = new JPanel();
		//panelPrincipal.setBackground(Color.ORANGE);
		//main.getCurrentCivilization().getCarpentry();
		// 




	}


//
//	  private void updateTabColors(JTabbedPane tabbedPane) {
//	        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
//	            if (tabbedPane.getSelectedIndex() == i) {
//	                tabbedPane.setBackgroundAt(i, Color.BLACK);
//	                tabbedPane.setForegroundAt(i, Color.WHITE);
//	            } else {
//	                tabbedPane.setBackgroundAt(i, Color.WHITE);
//	                tabbedPane.setForegroundAt(i, Color.BLACK);
//	            }
//	        }
//	    }

	// PanelPrincipalEdificios tiene(declarado internamente)
	// - PanelPrincipalSuperior
	// - PanelErrores


	public void initBuildingsAndTechnologyPanel(Main main) {

		panelInternoDos = new JPanel();
		panelInternoDos.setBackground(Color.YELLOW);
		panelInternoDos.setLayout(new BorderLayout());

		// PANEL DE RECURSOS
		initResourcesEdificiosPanel(main);

		// PANEL CENTRAL

		panelPrincipalEdificios = new JPanel();
		panelPrincipalEdificios.setLayout(new BorderLayout());

		JPanel panelPrincipalSuperior = new JPanel();
		panelPrincipalSuperior.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 20, 10, 20); // Padding

		JLabel[] resourceLabels = {new JLabel("FOOD"), new JLabel("WOOD"), new JLabel("IRON"), new JLabel("MANA")};
		for (int i = 0; i < resourceLabels.length; i++) {
			gbc.gridx = 3 + i;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.WEST;
			resourceLabels[i].setFont(new Font("Arial", Font.BOLD, 25));
			panelPrincipalSuperior.add(resourceLabels[i], gbc);
		}

		// EDIFICIOS
		String[] buildings = {"    Farm", "    Carpentry", "    Smithy", "    Magic Tower", "    Church"};
		int[] quantityBuildings = {main.getCurrentCivilization().getFarm(), 

				main.getCurrentCivilization().getCarpentry(), 
				main.getCurrentCivilization().getSmithy(), 
				main.getCurrentCivilization().getMagicTower(), 
				main.getCurrentCivilization().getChurch()};

		int[][] costBuildings =
			{{FOOD_COST_FARM, WOOD_COST_FARM, IRON_COST_FARM, 0},
					{FOOD_COST_CARPENTRY, WOOD_COST_CARPENTRY, IRON_COST_CARPENTRY, 0},
					{FOOD_COST_SMITHY, WOOD_COST_SMITHY, IRON_COST_SMITHY, 0},
					{FOOD_COST_MAGICTOWER, WOOD_COST_MAGICTOWER, IRON_COST_MAGICTOWER, 0},
					{FOOD_COST_CHURCH, WOOD_COST_CHURCH, IRON_COST_CHURCH, 10000}};

		ArrayList<JButton> arrayButtons = new ArrayList<JButton>();
		ArrayList<JLabel> arrayJLabel = new ArrayList<JLabel>();

		for (int i = 0; i < buildings.length; i++) {
			JLabel buildingLabel = new JLabel(buildings[i]);
			gbc.gridx = 0;
			gbc.gridy = i + 1;
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.1;
			gbc.weighty = 0.1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			buildingLabel.setFont(new Font("Arial", Font.BOLD, 20));
			panelPrincipalSuperior.add(buildingLabel, gbc);

			JButton addButton = new JButton("+");
			gbc.gridx = 1;
			gbc.gridy = i + 1;
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.1;
			gbc.weighty = 0.1;
			gbc.fill = GridBagConstraints.NONE;
			arrayButtons.add(addButton);
			panelPrincipalSuperior.add(addButton, gbc);

			JLabel totalLabel = new JLabel("Total: " + quantityBuildings[i]);
			gbc.gridx = 2;
			gbc.gridy = i + 1;
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.1;
			gbc.weighty = 0.1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			totalLabel.setFont(new Font("Arial", Font.BOLD, 20));
			arrayJLabel.add(totalLabel);
			panelPrincipalSuperior.add(totalLabel, gbc);

			for (int j = 0; j < costBuildings[0].length; j++) {
				JLabel resourceValue = new JLabel(String.valueOf(costBuildings[i][j]));
				gbc.gridx = j + 3;
				gbc.gridy = i + 1;
				gbc.weightx = 0.1;
				gbc.weighty = 0.1;
				gbc.fill = GridBagConstraints.HORIZONTAL;
				resourceValue.setFont(new Font("Arial", Font.BOLD, 15));
				panelPrincipalSuperior.add(resourceValue, gbc);
			}
		}

		// EVENTOS DE LOS BOTONES

		arrayButtons.get(0).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try {
					main.getCurrentCivilization().newFarm();
					arrayJLabel.get(0).setText("Total: " + main.getCurrentCivilization().getFarm());
					updateResourceLabels(main);
					updateBuildingsLabel(main);
				} catch (ResourceException e1) {
					attentionLabelBuilding.setText(e1.getMessage());

				}
			}

		});

		arrayButtons.get(1).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try {
					main.getCurrentCivilization().newCarpentry();
					arrayJLabel.get(1).setText("Total: " + main.getCurrentCivilization().getCarpentry());
					updateResourceLabels(main);
					updateBuildingsLabel(main);
				} catch (ResourceException e1) {
					attentionLabelBuilding.setText(e1.getMessage());

				}
			}

		});

		arrayButtons.get(2).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try {
					main.getCurrentCivilization().newSmithy();
					arrayJLabel.get(2).setText("Total: " + main.getCurrentCivilization().getSmithy());
					updateResourceLabels(main);
					updateBuildingsLabel(main);
				} catch (ResourceException e1) {
					attentionLabelBuilding.setText(e1.getMessage());

				}
			}

		});

		arrayButtons.get(3).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try {
					main.getCurrentCivilization().newMagicTower();
					arrayJLabel.get(3).setText("Total: " + main.getCurrentCivilization().getMagicTower());
					updateResourceLabels(main);
					updateBuildingsLabel(main);
				} catch (ResourceException e1) {
					attentionLabelBuilding.setText(e1.getMessage());

				}
			}

		});

		arrayButtons.get(4).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try {
					main.getCurrentCivilization().newChurch();
					arrayJLabel.get(4).setText("Total: " + main.getCurrentCivilization().getChurch());
					updateResourceLabels(main);
					updateBuildingsLabel(main);
				} catch (ResourceException e1) {
					attentionLabelBuilding.setText(e1.getMessage());
				}
			}

		});


		// TITULOS

		JLabel buildingsLabel = new JLabel("BUILDINGS");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 1.0;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buildingsLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panelPrincipalSuperior.add(buildingsLabel, gbc);

		JLabel technologyLabel = new JLabel("TECHNOLOGY");
		gbc.gridx = 0;
		gbc.gridy = buildings.length + 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 1.0;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		technologyLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panelPrincipalSuperior.add(technologyLabel, gbc);

		gbc.gridwidth = 1; // Reset gridwidth after use


		// TECNOLOGIA DE ATAQUE

		JLabel attackLabel = new JLabel("    Attack Level");
		gbc.gridx = 0;
		gbc.gridy = buildings.length + 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		attackLabel.setFont(new Font("Arial", Font.BOLD, 20));
		panelPrincipalSuperior.add(attackLabel, gbc);

		JButton attackButton = new JButton("+");
		gbc.gridx = 1;
		gbc.gridy = buildings.length + 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.NONE;
		panelPrincipalSuperior.add(attackButton, gbc);

		JLabel attackLevelLabel = new JLabel("Current level: " + main.getCurrentCivilization().getTechnologyAttack());
		gbc.gridx = 2;
		gbc.gridy = buildings.length + 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		attackLevelLabel.setFont(new Font("Arial", Font.BOLD, 20));
		panelPrincipalSuperior.add(attackLevelLabel, gbc);


		arrayCostAttackTechnology = new ArrayList<JLabel>();
		int[] costAttackTechnology = {
				0, 
				UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST + (main.getCurrentCivilization().getTechnologyAttack() * UPGRADE_PLUS_ATTACK_TECHNOLOGY_WOOD_COST * UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST/100), 
				UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST + (main.getCurrentCivilization().getTechnologyAttack() * UPGRADE_PLUS_ATTACK_TECHNOLOGY_IRON_COST * UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST/100), 
				0};

		for (int i = 0; i < costAttackTechnology.length; i++) {
			JLabel technologyCost = new JLabel(String.valueOf(costAttackTechnology[i]));
			gbc.gridx = i + 3;
			gbc.gridy = buildings.length + 2;
			gbc.weightx = 0.1;
			gbc.weighty = 0.1;
			technologyCost.setFont(new Font("Arial", Font.BOLD, 15));
			gbc.fill = GridBagConstraints.HORIZONTAL;
			arrayCostAttackTechnology.add(technologyCost);
			panelPrincipalSuperior.add(technologyCost, gbc);
		}

		attackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try {
					main.getCurrentCivilization().upgradeTechnologyAttack();;
					attackLevelLabel.setText("Current level: " + main.getCurrentCivilization().getTechnologyAttack());
					updateResourceLabels(main);
					updateTechnologyLabels(main);
					int[] costAttackTechnology = {55555, 5555, 5555, 55555};
					arrayCostAttackTechnology.get(0).setText(String.valueOf(costAttackTechnology[0]));
					arrayCostAttackTechnology.get(1).setText(String.valueOf(costAttackTechnology[1]));
					arrayCostAttackTechnology.get(2).setText(String.valueOf(costAttackTechnology[2]));
					arrayCostAttackTechnology.get(3).setText(String.valueOf(costAttackTechnology[3]));
				} catch (ResourceException e1) {
					attentionLabelBuilding.setText(e1.getMessage());
				}
			}
		});


		// TECNOLOGIA DE DEFENSA

		JLabel defenseLabel = new JLabel("    Defense Level");
		gbc.gridx = 0;
		gbc.gridy = buildings.length + 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		defenseLabel.setFont(new Font("Arial", Font.BOLD, 20));
		panelPrincipalSuperior.add(defenseLabel, gbc);

		JButton defenseButton = new JButton("+");
		gbc.gridx = 1;
		gbc.gridy = buildings.length + 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.NONE;
		panelPrincipalSuperior.add(defenseButton, gbc);

		JLabel defenseLevelLabel = new JLabel("Current level: " + main.getCurrentCivilization().getTechnologyDefense());
		gbc.gridx = 2;
		gbc.gridy = buildings.length + 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		defenseLevelLabel.setFont(new Font("Arial", Font.BOLD, 20));
		panelPrincipalSuperior.add(defenseLevelLabel, gbc);

		arrayCostDefenseTechnology = new ArrayList<JLabel>();
		int[] costDefenseTechnology = {
                0, 
                UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST + (main.getCurrentCivilization().getTechnologyDefense() * UPGRADE_PLUS_DEFENSE_TECHNOLOGY_WOOD_COST * UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST/100), 
                UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST + (main.getCurrentCivilization().getTechnologyDefense() * UPGRADE_PLUS_DEFENSE_TECHNOLOGY_IRON_COST * UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST/100), 
                0};

        for (int i = 0; i < costDefenseTechnology.length; i++) {
            JLabel technologyCost = new JLabel(String.valueOf(costDefenseTechnology[i]));
            gbc.gridx = i + 3;
            gbc.gridy = buildings.length + 3;
            gbc.weightx = 0.1;
            gbc.weighty = 0.1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            technologyCost.setFont(new Font("Arial", Font.BOLD, 15));
            arrayCostDefenseTechnology.add(technologyCost);
            panelPrincipalSuperior.add(technologyCost, gbc);
        }

        defenseButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    updateErrorLabel();
                    main.getCurrentCivilization().upgradeTechnologyDefense();;
                    defenseLevelLabel.setText("Current level: " + main.getCurrentCivilization().getTechnologyDefense());
                    updateResourceLabels(main);
                    updateTechnologyLabels(main);

                } catch (ResourceException e1) {
                    attentionLabelBuilding.setText(e1.getMessage());
                }
            }

        });

		// ERROR
		// Attention message

		JPanel panelError = new JPanel();
		attentionLabelBuilding = new JLabel("");
		attentionLabelBuilding.setFont(new Font("Arial", Font.BOLD, 20));
		attentionLabelBuilding.setForeground(Color.RED);
		panelError.add(attentionLabelBuilding);

		panelPrincipalEdificios.add(panelPrincipalSuperior, BorderLayout.CENTER);
		panelPrincipalEdificios.add(panelError, BorderLayout.SOUTH);

		// PANEL INFERIOR

		initBarraInferiorEdificios(main);
		Font tabFont = new Font("Arial", Font.BOLD, 20);
		tabbedPane.setBackground(Color.GRAY);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setFont(tabFont);
		panelInternoDos.add(panelRecursosEdificios, BorderLayout.NORTH);
		panelInternoDos.add(panelPrincipalEdificios, BorderLayout.CENTER);
		panelInternoDos.add(panelInferior, BorderLayout.SOUTH);
		tabbedPane.addTab("Buildings and Technology", panelInternoDos);

	}


	public void initUnitsPanel(Main main) {
		panelInternoTres =  new JPanel();
		panelInternoTres.setBackground(Color.GREEN);
		panelInternoTres.setLayout(new BorderLayout());

		initResourcesUnitsPanel(main);

		// PANEL CENTRAL

		panelPrincipalUnidades = new JPanel();
		panelPrincipalUnidades.setLayout(new BorderLayout());

		JPanel panelPrincipalSuperior = new JPanel();
		panelPrincipalSuperior.setLayout(new GridBagLayout());

		String[] units = {
				"     Swordsman", "     Spearman", "     Crossbow", "     Cannon", "     Arrow Tower",
				"     Catapult", "     Rocket Launcher Tower", "     Magician", "     Priest"
		};
		String[] unitHeaders = {"ARMOR", "DAMAGE", "", ""};


		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH; // Adjusts both width and height
		gbc.weightx = 1.0; // Components grow horizontally
		gbc.weighty = 1.0; // Components grow vertically
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST; // Center components within their cells

		// Add headers
		gbc.gridy = 0;
		gbc.gridx = 0;
		JLabel labelUnits = new JLabel("UNITS");
		labelUnits.setFont(new Font("Arial", Font.BOLD, 27));
		panelPrincipalSuperior.add(labelUnits, gbc);
		gbc.gridx = 1;
		JLabel labelTotalUnits = new JLabel("TOTAL UNITS");
		labelTotalUnits.setFont(new Font("Arial", Font.BOLD, 27));
		panelPrincipalSuperior.add(labelTotalUnits, gbc);

		for (int i = 0; i < unitHeaders.length; i++) {
			gbc.gridx = i + 2;
			JLabel headerLabel = new JLabel(unitHeaders[i]);
			headerLabel.setFont(new Font("Arial", Font.BOLD, 27));
			panelPrincipalSuperior.add(headerLabel, gbc);
		}

		// NOMBRES
		for (int i = 0; i < units.length; i++) {
			gbc.gridy = i + 1;
			gbc.gridx = 0;
			JLabel unitsTitle = new JLabel(units[i]);
			unitsTitle.setFont(new Font("Arial", Font.BOLD, 24));
			panelPrincipalSuperior.add(unitsTitle, gbc);
		}

		int[] totalUnitsArray = {
				(main.getCurrentCivilization().getArmy())[0].size(),
				(main.getCurrentCivilization().getArmy())[1].size(),
				(main.getCurrentCivilization().getArmy())[2].size(),
				(main.getCurrentCivilization().getArmy())[3].size(),
				(main.getCurrentCivilization().getArmy())[4].size(),
				(main.getCurrentCivilization().getArmy())[5].size(),
				(main.getCurrentCivilization().getArmy())[6].size(),
				(main.getCurrentCivilization().getArmy())[7].size(),
				(main.getCurrentCivilization().getArmy())[8].size(),
		};

		totalUnitsArrayLabel = new ArrayList<JLabel>();

		for (int i = 0; i < totalUnitsArray.length; i++) {
			gbc.gridy = i + 1;
			gbc.gridx = 1;
			JLabel totalUnitsLabel = new JLabel(String.valueOf(totalUnitsArray[i]));
			totalUnitsLabel.setFont(new Font("Arial", Font.BOLD, 17));
			totalUnitsArrayLabel.add(totalUnitsLabel);
			panelPrincipalSuperior.add(totalUnitsLabel, gbc);
		}

		// ARMOR_SWORDSMAN +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY/100 * ARMOR_SWORDSMAN);
		int[] armorUnitsArray = {
				ARMOR_SWORDSMAN +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY/100 * ARMOR_SWORDSMAN),
				ARMOR_SPEARMAN +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_SPEARMAN_BY_TECHNOLOGY/100 * ARMOR_SPEARMAN),
				ARMOR_CROSSBOW +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_CROSSBOW_BY_TECHNOLOGY/100 * ARMOR_CROSSBOW),
				ARMOR_CANNON +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_CANNON_BY_TECHNOLOGY/100 * ARMOR_CANNON),
				ARMOR_ARROWTOWER +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_ARROWTOWER_BY_TECHNOLOGY/100 * ARMOR_ARROWTOWER),
				ARMOR_CATAPULT +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_CATAPULT_BY_TECHNOLOGY/100 * ARMOR_CATAPULT),
				ARMOR_ROCKETLAUNCHERTOWER +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY/100 * ARMOR_ROCKETLAUNCHERTOWER),
				0,
				0,
		};

		armorUnitsArrayLabel = new ArrayList<JLabel>();

		for (int i = 0; i < units.length; i++) {
			gbc.gridy = i + 1;
			gbc.gridx = 2;
			JLabel armorUnitsLabel = new JLabel(String.valueOf(armorUnitsArray[i]));
			armorUnitsLabel.setFont(new Font("Arial", Font.BOLD, 17));
			armorUnitsArrayLabel.add(armorUnitsLabel);
			panelPrincipalSuperior.add(armorUnitsLabel, gbc);
		}

		// BASE_DAMAGE_SWORDSMAN +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_SWORDSMAN_BY_TECHNOLOGY/100 * BASE_DAMAGE_SWORDSMAN);

		int[] damageUnitsArray = {
				BASE_DAMAGE_SWORDSMAN +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_SWORDSMAN_BY_TECHNOLOGY/100 * BASE_DAMAGE_SWORDSMAN),
				BASE_DAMAGE_SPEARMAN +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_SPEARMAN_BY_TECHNOLOGY/100 * BASE_DAMAGE_SPEARMAN),
				BASE_DAMAGE_CROSSBOW +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_CROSSBOW_BY_TECHNOLOGY/100 * BASE_DAMAGE_CROSSBOW),
				BASE_DAMAGE_CANNON +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_CANNON_BY_TECHNOLOGY/100 * BASE_DAMAGE_CANNON),
				BASE_DAMAGE_ARROWTOWER +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_ARROWTOWER_BY_TECHNOLOGY/100 * BASE_DAMAGE_ARROWTOWER),
				BASE_DAMAGE_CATAPULT +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_CATAPULT_BY_TECHNOLOGY/100 * BASE_DAMAGE_CATAPULT),
				BASE_DAMAGE_ROCKETLAUNCHERTOWER +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY/100 * BASE_DAMAGE_ROCKETLAUNCHERTOWER),
				BASE_DAMAGE_MAGICIAN +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_MAGICIAN_BY_TECHNOLOGY/100 * BASE_DAMAGE_MAGICIAN),
				0,
		};

		damageUnitsArrayLabel = new ArrayList<JLabel>();

		for (int i = 0; i < units.length; i++) {
			gbc.gridy = i + 1;
			gbc.gridx = 3;
			JLabel damageUnitsLabel = new JLabel(String.valueOf(damageUnitsArray[i]));
			damageUnitsLabel.setFont(new Font("Arial", Font.BOLD, 17));
			damageUnitsArrayLabel.add(damageUnitsLabel);
			panelPrincipalSuperior.add(damageUnitsLabel, gbc);
		}

		ArrayList<JTextField> insertDesiredUnitsArrayJTextField = new ArrayList<JTextField>();
		for (int i = 0; i < units.length; i++) {	
			gbc.gridy = i + 1;
			gbc.gridx = 4;
			JTextField quantityField = new JTextField("0", 4);
			quantityField.setHorizontalAlignment(JTextField.CENTER);
			insertDesiredUnitsArrayJTextField.add(quantityField);
			panelPrincipalSuperior.add(quantityField, gbc);
		}

		ArrayList<JButton> createButtonUnitsArray = new ArrayList<JButton>();
		for (int i = 0; i < units.length; i++) {
			gbc.gridy = i + 1;
			gbc.gridx = 5;
			JButton createButton = new JButton("ADD");
			createButtonUnitsArray.add(createButton);
			panelPrincipalSuperior.add(createButton, gbc);
		}



		/*
		int[][] costIndividualUn.get =
            {{FOOD_COST_FARM, WOOD_COST_FARM, IRON_COST_FARM, 0},
             {FOOD_COST_CARPENTRY, WOOD_COST_CARPENTRY, IRON_COST_CARPENTRY, 0},
             {FOOD_COST_SMITHY, WOOD_COST_SMITHY, IRON_COST_SMITHY, 0},
             {FOOD_COST_MAGICTOWER, WOOD_COST_MAGICTOWER, IRON_COST_MAGICTOWER, 0},
             {FOOD_COST_CHURCH, WOOD_COST_CHURCH, IRON_COST_CHURCH, 10000}};
		 */

		// ERROR
		// Attention message

		JPanel panelError = new JPanel();
		attentionLabelUnits = new JLabel("");
		attentionLabelUnits.setForeground(Color.RED);
		attentionLabelUnits.setFont(new Font("Arial", Font.BOLD, 20));
		panelError.add(attentionLabelUnits);

		panelPrincipalUnidades.add(panelPrincipalSuperior, BorderLayout.CENTER);
		panelPrincipalUnidades.add(panelError, BorderLayout.SOUTH);

		// PANEL INFERIOR

		initBarraInferiorUnidades(main);

		panelInternoTres.add(panelRecursosUnits, BorderLayout.NORTH);
		panelInternoTres.add(panelPrincipalUnidades, BorderLayout.CENTER);
		panelInternoTres.add(panelInferior, BorderLayout.SOUTH);
		tabbedPane.addTab("Units", panelInternoTres);

		createButtonUnitsArray.get(0).addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try { 

					int quantityToAdd = Integer.parseInt(insertDesiredUnitsArrayJTextField.get(0).getText());
					if (quantityToAdd < 0) {
						JOptionPane.showMessageDialog(panelPrincipalSuperior, "Quantity must be non-negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					JLabel title = new JLabel("You will need the following resources to generate the units you desire: ");

					JPanel panelCoste = new JPanel();
					panelCoste.setLayout(new BoxLayout(panelCoste, BoxLayout.Y_AXIS));

					int foodCost = quantityToAdd * FOOD_COST_SWORDSMAN;
					int woodCost = quantityToAdd * WOOD_COST_SWORDSMAN;
					int ironCost = quantityToAdd * IRON_COST_SWORDSMAN;
					int manaCost = quantityToAdd * MANA_COST_SWORDSMAN;

					JLabel espacioSuperior = new JLabel(" ");
					JLabel foodCostJLabel = new JLabel("  - Food: " + foodCost);
					JLabel woodCostJLabel = new JLabel("  - Wood: " + woodCost);
					JLabel ironCostJLabel = new JLabel("  - Iron: " + ironCost);
					JLabel manaCostJLabel = new JLabel("  - Mana: " + manaCost);
					JLabel espacioInferior = new JLabel(" ");

					panelCoste.add(espacioSuperior);
					panelCoste.add(foodCostJLabel);
					panelCoste.add(woodCostJLabel);
					panelCoste.add(ironCostJLabel);
					panelCoste.add(manaCostJLabel);
					panelCoste.add(espacioInferior);

					JPanel confirmation = new JPanel();
					confirmation.setLayout(new FlowLayout(FlowLayout.CENTER));
					JLabel confirmationLabel = new JLabel("Do you wish to continue?");
					confirmation.add(confirmationLabel);

					panel.add(title, BorderLayout.NORTH);
					panel.add(panelCoste, BorderLayout.CENTER);
					panel.add(confirmation, BorderLayout.SOUTH);

					int respuesta = JOptionPane.showConfirmDialog(null, panel, "Unit generation confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {

						System.out.println("SE HA SELECCIONADO SI");

						try {
							System.out.println("Unidades anteriores = " + (main.getCurrentCivilization().getArmy())[0].size());
							main.getCurrentCivilization().newSwordsman(quantityToAdd);
							System.out.println("Unidades posteriores = " + (main.getCurrentCivilization().getArmy())[0].size());

							updateResourceLabels(main);
							updateUnitsLabel(main);

						} catch (ResourceException e1) {

							attentionLabelUnits.setText(e1.getMessage());
							updateResourceLabels(main);
							updateUnitsLabel(main);

						}

					} 

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panelPrincipalSuperior, "Please, enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		createButtonUnitsArray.get(1).addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try { 
					int quantityToAdd = Integer.parseInt(insertDesiredUnitsArrayJTextField.get(1).getText());
					if (quantityToAdd < 0) {
						JOptionPane.showMessageDialog(panelPrincipalSuperior, "Quantity must be non-negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					JLabel title = new JLabel("You will need the following resources to generate the units you desire: ");

					JPanel panelCoste = new JPanel();
					panelCoste.setLayout(new BoxLayout(panelCoste, BoxLayout.Y_AXIS));

					int foodCost = quantityToAdd * FOOD_COST_SPEARMAN;
					int woodCost = quantityToAdd * WOOD_COST_SPEARMAN;
					int ironCost = quantityToAdd * IRON_COST_SPEARMAN;
					int manaCost = quantityToAdd * MANA_COST_SPEARMAN;

					JLabel espacioSuperior = new JLabel(" ");
					JLabel foodCostJLabel = new JLabel("  - Food: " + foodCost);
					JLabel woodCostJLabel = new JLabel("  - Wood: " + woodCost);
					JLabel ironCostJLabel = new JLabel("  - Iron: " + ironCost);
					JLabel manaCostJLabel = new JLabel("  - Mana: " + manaCost);
					JLabel espacioInferior = new JLabel(" ");

					panelCoste.add(espacioSuperior);
					panelCoste.add(foodCostJLabel);
					panelCoste.add(woodCostJLabel);
					panelCoste.add(ironCostJLabel);
					panelCoste.add(manaCostJLabel);
					panelCoste.add(espacioInferior);

					JPanel confirmation = new JPanel();
					confirmation.setLayout(new FlowLayout(FlowLayout.CENTER));
					JLabel confirmationLabel = new JLabel("Do you wish to continue?");
					confirmation.add(confirmationLabel);

					panel.add(title, BorderLayout.NORTH);
					panel.add(panelCoste, BorderLayout.CENTER);
					panel.add(confirmation, BorderLayout.SOUTH);

					int respuesta = JOptionPane.showConfirmDialog(null, panel, "Unit generation confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {

						System.out.println("SE HA SELECCIONADO SI");

						try {
							System.out.println("Unidades anteriores = " + (main.getCurrentCivilization().getArmy())[1].size());
							main.getCurrentCivilization().newSpearman(quantityToAdd);
							System.out.println("Unidades posteriores = " + (main.getCurrentCivilization().getArmy())[1].size());

							updateResourceLabels(main);
							updateUnitsLabel(main);

						} catch (ResourceException e1) {

							attentionLabelUnits.setText(e1.getMessage());
							updateResourceLabels(main);
							updateUnitsLabel(main);

						}

					} 

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panelPrincipalSuperior, "Please, enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		createButtonUnitsArray.get(2).addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try { 

					int quantityToAdd = Integer.parseInt(insertDesiredUnitsArrayJTextField.get(2).getText());
					if (quantityToAdd < 0) {
						JOptionPane.showMessageDialog(panelPrincipalSuperior, "Quantity must be non-negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					JLabel title = new JLabel("You will need the following resources to generate the units you desire: ");

					JPanel panelCoste = new JPanel();
					panelCoste.setLayout(new BoxLayout(panelCoste, BoxLayout.Y_AXIS));

					int foodCost = quantityToAdd * FOOD_COST_CROSSBOW;
					int woodCost = quantityToAdd * WOOD_COST_CROSSBOW;
					int ironCost = quantityToAdd * IRON_COST_CROSSBOW;
					int manaCost = quantityToAdd * MANA_COST_CROSSBOW;

					JLabel espacioSuperior = new JLabel(" ");
					JLabel foodCostJLabel = new JLabel("  - Food: " + foodCost);
					JLabel woodCostJLabel = new JLabel("  - Wood: " + woodCost);
					JLabel ironCostJLabel = new JLabel("  - Iron: " + ironCost);
					JLabel manaCostJLabel = new JLabel("  - Mana: " + manaCost);
					JLabel espacioInferior = new JLabel(" ");

					panelCoste.add(espacioSuperior);
					panelCoste.add(foodCostJLabel);
					panelCoste.add(woodCostJLabel);
					panelCoste.add(ironCostJLabel);
					panelCoste.add(manaCostJLabel);
					panelCoste.add(espacioInferior);

					JPanel confirmation = new JPanel();
					confirmation.setLayout(new FlowLayout(FlowLayout.CENTER));
					JLabel confirmationLabel = new JLabel("Do you wish to continue?");
					confirmation.add(confirmationLabel);

					panel.add(title, BorderLayout.NORTH);
					panel.add(panelCoste, BorderLayout.CENTER);
					panel.add(confirmation, BorderLayout.SOUTH);

					int respuesta = JOptionPane.showConfirmDialog(null, panel, "Unit generation confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {

						System.out.println("SE HA SELECCIONADO SI");

						try {
							System.out.println("Unidades anteriores = " + (main.getCurrentCivilization().getArmy())[2].size());
							main.getCurrentCivilization().newCrossbow(quantityToAdd);
							System.out.println("Unidades posteriores = " + (main.getCurrentCivilization().getArmy())[2].size());

							updateResourceLabels(main);
							updateUnitsLabel(main);

						} catch (ResourceException e1) {

							attentionLabelUnits.setText(e1.getMessage());
							updateResourceLabels(main);
							updateUnitsLabel(main);

						}

					} 

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panelPrincipalSuperior, "Please, enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		createButtonUnitsArray.get(3).addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try { 

					int quantityToAdd = Integer.parseInt(insertDesiredUnitsArrayJTextField.get(3).getText());
					if (quantityToAdd < 0) {
						JOptionPane.showMessageDialog(panelPrincipalSuperior, "Quantity must be non-negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					JLabel title = new JLabel("You will need the following resources to generate the units you desire: ");

					JPanel panelCoste = new JPanel();
					panelCoste.setLayout(new BoxLayout(panelCoste, BoxLayout.Y_AXIS));

					int foodCost = quantityToAdd * FOOD_COST_CANNON;
					int woodCost = quantityToAdd * WOOD_COST_CANNON;
					int ironCost = quantityToAdd * IRON_COST_CANNON;
					int manaCost = quantityToAdd * MANA_COST_CANNON;

					JLabel espacioSuperior = new JLabel(" ");
					JLabel foodCostJLabel = new JLabel("  - Food: " + foodCost);
					JLabel woodCostJLabel = new JLabel("  - Wood: " + woodCost);
					JLabel ironCostJLabel = new JLabel("  - Iron: " + ironCost);
					JLabel manaCostJLabel = new JLabel("  - Mana: " + manaCost);
					JLabel espacioInferior = new JLabel(" ");

					panelCoste.add(espacioSuperior);
					panelCoste.add(foodCostJLabel);
					panelCoste.add(woodCostJLabel);
					panelCoste.add(ironCostJLabel);
					panelCoste.add(manaCostJLabel);
					panelCoste.add(espacioInferior);

					JPanel confirmation = new JPanel();
					confirmation.setLayout(new FlowLayout(FlowLayout.CENTER));
					JLabel confirmationLabel = new JLabel("Do you wish to continue?");
					confirmation.add(confirmationLabel);

					panel.add(title, BorderLayout.NORTH);
					panel.add(panelCoste, BorderLayout.CENTER);
					panel.add(confirmation, BorderLayout.SOUTH);

					int respuesta = JOptionPane.showConfirmDialog(null, panel, "Unit generation confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {

						System.out.println("SE HA SELECCIONADO SI");

						try {

							main.getCurrentCivilization().newCannon(quantityToAdd);				
							updateResourceLabels(main);
							updateUnitsLabel(main);

						} catch (ResourceException e1) {

							attentionLabelUnits.setText(e1.getMessage());
							updateResourceLabels(main);
							updateUnitsLabel(main);
						}

					} 

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panelPrincipalSuperior, "Please, enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		createButtonUnitsArray.get(4).addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try { 

					int quantityToAdd = Integer.parseInt(insertDesiredUnitsArrayJTextField.get(4).getText());
					if (quantityToAdd < 0) {
						JOptionPane.showMessageDialog(panelPrincipalSuperior, "Quantity must be non-negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					JLabel title = new JLabel("You will need the following resources to generate the units you desire: ");

					JPanel panelCoste = new JPanel();
					panelCoste.setLayout(new BoxLayout(panelCoste, BoxLayout.Y_AXIS));

					int foodCost = quantityToAdd * FOOD_COST_ARROWTOWER;
					int woodCost = quantityToAdd * WOOD_COST_ARROWTOWER;
					int ironCost = quantityToAdd * IRON_COST_ARROWTOWER;
					int manaCost = quantityToAdd * MANA_COST_ARROWTOWER;

					JLabel espacioSuperior = new JLabel(" ");
					JLabel foodCostJLabel = new JLabel("  - Food: " + foodCost);
					JLabel woodCostJLabel = new JLabel("  - Wood: " + woodCost);
					JLabel ironCostJLabel = new JLabel("  - Iron: " + ironCost);
					JLabel manaCostJLabel = new JLabel("  - Mana: " + manaCost);
					JLabel espacioInferior = new JLabel(" ");

					panelCoste.add(espacioSuperior);
					panelCoste.add(foodCostJLabel);
					panelCoste.add(woodCostJLabel);
					panelCoste.add(ironCostJLabel);
					panelCoste.add(manaCostJLabel);
					panelCoste.add(espacioInferior);

					JPanel confirmation = new JPanel();
					confirmation.setLayout(new FlowLayout(FlowLayout.CENTER));
					JLabel confirmationLabel = new JLabel("Do you wish to continue?");
					confirmation.add(confirmationLabel);

					panel.add(title, BorderLayout.NORTH);
					panel.add(panelCoste, BorderLayout.CENTER);
					panel.add(confirmation, BorderLayout.SOUTH);

					int respuesta = JOptionPane.showConfirmDialog(null, panel, "Unit generation confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {

						System.out.println("SE HA SELECCIONADO SI");

						try {
							main.getCurrentCivilization().newArrowTower(quantityToAdd);
							updateResourceLabels(main);
							updateUnitsLabel(main);

						} catch (ResourceException e1) {

							attentionLabelUnits.setText(e1.getMessage());
							updateResourceLabels(main);
							updateUnitsLabel(main);

						}

					} 

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panelPrincipalSuperior, "Please, enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		createButtonUnitsArray.get(5).addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try { 

					int quantityToAdd = Integer.parseInt(insertDesiredUnitsArrayJTextField.get(5).getText());
					if (quantityToAdd < 0) {
						JOptionPane.showMessageDialog(panelPrincipalSuperior, "Quantity must be non-negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					JLabel title = new JLabel("You will need the following resources to generate the units you desire: ");

					JPanel panelCoste = new JPanel();
					panelCoste.setLayout(new BoxLayout(panelCoste, BoxLayout.Y_AXIS));

					int foodCost = quantityToAdd * FOOD_COST_CATAPULT;
					int woodCost = quantityToAdd * WOOD_COST_CATAPULT;
					int ironCost = quantityToAdd * IRON_COST_CATAPULT;
					int manaCost = quantityToAdd * MANA_COST_CATAPULT;

					JLabel espacioSuperior = new JLabel(" ");
					JLabel foodCostJLabel = new JLabel("  - Food: " + foodCost);
					JLabel woodCostJLabel = new JLabel("  - Wood: " + woodCost);
					JLabel ironCostJLabel = new JLabel("  - Iron: " + ironCost);
					JLabel manaCostJLabel = new JLabel("  - Mana: " + manaCost);
					JLabel espacioInferior = new JLabel(" ");

					panelCoste.add(espacioSuperior);
					panelCoste.add(foodCostJLabel);
					panelCoste.add(woodCostJLabel);
					panelCoste.add(ironCostJLabel);
					panelCoste.add(manaCostJLabel);
					panelCoste.add(espacioInferior);

					JPanel confirmation = new JPanel();
					confirmation.setLayout(new FlowLayout(FlowLayout.CENTER));
					JLabel confirmationLabel = new JLabel("Do you wish to continue?");
					confirmation.add(confirmationLabel);

					panel.add(title, BorderLayout.NORTH);
					panel.add(panelCoste, BorderLayout.CENTER);
					panel.add(confirmation, BorderLayout.SOUTH);

					int respuesta = JOptionPane.showConfirmDialog(null, panel, "Unit generation confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {

						System.out.println("SE HA SELECCIONADO SI");

						try {
							main.getCurrentCivilization().newCatapult(quantityToAdd);
							updateResourceLabels(main);
							updateUnitsLabel(main);

						} catch (ResourceException e1) {

							attentionLabelUnits.setText(e1.getMessage());
							updateResourceLabels(main);
							updateUnitsLabel(main);

						}

					} 

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panelPrincipalSuperior, "Please, enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		createButtonUnitsArray.get(6).addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try { 

					int quantityToAdd = Integer.parseInt(insertDesiredUnitsArrayJTextField.get(6).getText());
					if (quantityToAdd < 0) {
						JOptionPane.showMessageDialog(panelPrincipalSuperior, "Quantity must be non-negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					JLabel title = new JLabel("You will need the following resources to generate the units you desire: ");

					JPanel panelCoste = new JPanel();
					panelCoste.setLayout(new BoxLayout(panelCoste, BoxLayout.Y_AXIS));

					int foodCost = quantityToAdd * FOOD_COST_ROCKETLAUNCHERTOWER;
					int woodCost = quantityToAdd * WOOD_COST_ROCKETLAUNCHERTOWER;
					int ironCost = quantityToAdd * IRON_COST_ROCKETLAUNCHERTOWER;
					int manaCost = quantityToAdd * MANA_COST_ROCKETLAUNCHERTOWER;

					JLabel espacioSuperior = new JLabel(" ");
					JLabel foodCostJLabel = new JLabel("  - Food: " + foodCost);
					JLabel woodCostJLabel = new JLabel("  - Wood: " + woodCost);
					JLabel ironCostJLabel = new JLabel("  - Iron: " + ironCost);
					JLabel manaCostJLabel = new JLabel("  - Mana: " + manaCost);
					JLabel espacioInferior = new JLabel(" ");

					panelCoste.add(espacioSuperior);
					panelCoste.add(foodCostJLabel);
					panelCoste.add(woodCostJLabel);
					panelCoste.add(ironCostJLabel);
					panelCoste.add(manaCostJLabel);
					panelCoste.add(espacioInferior);

					JPanel confirmation = new JPanel();
					confirmation.setLayout(new FlowLayout(FlowLayout.CENTER));
					JLabel confirmationLabel = new JLabel("Do you wish to continue?");
					confirmation.add(confirmationLabel);

					panel.add(title, BorderLayout.NORTH);
					panel.add(panelCoste, BorderLayout.CENTER);
					panel.add(confirmation, BorderLayout.SOUTH);

					int respuesta = JOptionPane.showConfirmDialog(null, panel, "Unit generation confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {

						System.out.println("SE HA SELECCIONADO SI");

						try {

							main.getCurrentCivilization().newRocketLauncherTower(quantityToAdd);
							updateResourceLabels(main);
							updateUnitsLabel(main);

						} catch (ResourceException e1) {

							attentionLabelUnits.setText(e1.getMessage());
							updateResourceLabels(main);
							updateUnitsLabel(main);

						}

					} 

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panelPrincipalSuperior, "Please, enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		createButtonUnitsArray.get(7).addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try { 

					int quantityToAdd = Integer.parseInt(insertDesiredUnitsArrayJTextField.get(7).getText());
					if (quantityToAdd < 0) {
						JOptionPane.showMessageDialog(panelPrincipalSuperior, "Quantity must be non-negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					JLabel title = new JLabel("You will need the following resources to generate the units you desire: ");

					JPanel panelCoste = new JPanel();
					panelCoste.setLayout(new BoxLayout(panelCoste, BoxLayout.Y_AXIS));

					int foodCost = quantityToAdd * FOOD_COST_MAGICIAN;
					int woodCost = quantityToAdd * WOOD_COST_MAGICIAN;
					int ironCost = quantityToAdd * IRON_COST_MAGICIAN;
					int manaCost = quantityToAdd * MANA_COST_MAGICIAN;

					JLabel espacioSuperior = new JLabel(" ");
					JLabel foodCostJLabel = new JLabel("  - Food: " + foodCost);
					JLabel woodCostJLabel = new JLabel("  - Wood: " + woodCost);
					JLabel ironCostJLabel = new JLabel("  - Iron: " + ironCost);
					JLabel manaCostJLabel = new JLabel("  - Mana: " + manaCost);
					JLabel espacioInferior = new JLabel(" ");

					panelCoste.add(espacioSuperior);
					panelCoste.add(foodCostJLabel);
					panelCoste.add(woodCostJLabel);
					panelCoste.add(ironCostJLabel);
					panelCoste.add(manaCostJLabel);
					panelCoste.add(espacioInferior);

					JPanel confirmation = new JPanel();
					confirmation.setLayout(new FlowLayout(FlowLayout.CENTER));
					JLabel confirmationLabel = new JLabel("Do you wish to continue?");
					confirmation.add(confirmationLabel);

					panel.add(title, BorderLayout.NORTH);
					panel.add(panelCoste, BorderLayout.CENTER);
					panel.add(confirmation, BorderLayout.SOUTH);

					int respuesta = JOptionPane.showConfirmDialog(null, panel, "Unit generation confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {

						System.out.println("SE HA SELECCIONADO SI");

						try {
							main.getCurrentCivilization().newMagician(quantityToAdd);
							updateResourceLabels(main);
							updateUnitsLabel(main);

						} catch (ResourceException e1) {

							attentionLabelUnits.setText(e1.getMessage());
							updateResourceLabels(main);
							updateUnitsLabel(main);

						}


					} 

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panelPrincipalSuperior, "Please, enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		createButtonUnitsArray.get(8).addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				updateErrorLabel();
				try { 

					int quantityToAdd = Integer.parseInt(insertDesiredUnitsArrayJTextField.get(8).getText());
					if (quantityToAdd < 0) {
						JOptionPane.showMessageDialog(panelPrincipalSuperior, "Quantity must be non-negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					JLabel title = new JLabel("You will need the following resources to generate the units you desire: ");

					JPanel panelCoste = new JPanel();
					panelCoste.setLayout(new BoxLayout(panelCoste, BoxLayout.Y_AXIS));

					int foodCost = quantityToAdd * FOOD_COST_PRIEST;
					int woodCost = quantityToAdd * WOOD_COST_PRIEST;
					int ironCost = quantityToAdd * IRON_COST_PRIEST;
					int manaCost = quantityToAdd * MANA_COST_PRIEST;

					JLabel espacioSuperior = new JLabel(" ");
					JLabel foodCostJLabel = new JLabel("  - Food: " + foodCost);
					JLabel woodCostJLabel = new JLabel("  - Wood: " + woodCost);
					JLabel ironCostJLabel = new JLabel("  - Iron: " + ironCost);
					JLabel manaCostJLabel = new JLabel("  - Mana: " + manaCost);
					JLabel espacioInferior = new JLabel(" ");

					panelCoste.add(espacioSuperior);
					panelCoste.add(foodCostJLabel);
					panelCoste.add(woodCostJLabel);
					panelCoste.add(ironCostJLabel);
					panelCoste.add(manaCostJLabel);
					panelCoste.add(espacioInferior);

					JPanel confirmation = new JPanel();
					confirmation.setLayout(new FlowLayout(FlowLayout.CENTER));
					JLabel confirmationLabel = new JLabel("Do you wish to continue?");
					confirmation.add(confirmationLabel);

					panel.add(title, BorderLayout.NORTH);
					panel.add(panelCoste, BorderLayout.CENTER);
					panel.add(confirmation, BorderLayout.SOUTH);

					int respuesta = JOptionPane.showConfirmDialog(null, panel, "Unit generation confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {

						System.out.println("SE HA SELECCIONADO SI");

						try {

							main.getCurrentCivilization().newPriest(quantityToAdd);
							updateResourceLabels(main);
							updateUnitsLabel(main);

						} catch (ResourceException e1) {

							attentionLabelUnits.setText(e1.getMessage());
							updateResourceLabels(main);
							updateUnitsLabel(main);

						}

						// Se santifican unidades
						if ((main.getCurrentCivilization().getArmy())[8].size() > 0) {
							System.out.println("UNIDADES SANTIFICADA / HAY PRIEST = " + (main.getCurrentCivilization().getArmy())[8].size());
							for (ArrayList<MilitaryUnit> unidades : main.getCurrentCivilization().getArmy()) {
								System.out.println(unidades.size());
								for (MilitaryUnit unidad : unidades) {

									if (unidad instanceof AttackUnit) {
										((AttackUnit) unidad).setSanctified(true);

									} else if (unidad instanceof DefenseUnit) {
										((DefenseUnit) unidad).setSanctified(true);
									} 
								} 

							}
						}
					} 

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panelPrincipalSuperior, "Please, enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

	}


	public void initBattlePanel(Main main) {

		panelInternoCuatro =  new JPanel();
		panelInternoCuatro.setBackground(Color.BLACK);
		panelInternoCuatro.setLayout(new BorderLayout());

		// INTEGRACION DE PANEL SUPERIOR CENTRAL

		JPanel panelI = new JPanel(new GridBagLayout());

		// seleccionar batalla
		JLabel label_numeroBattle = new JLabel("Number of battle");
		label_numeroBattle.setFont(new Font("Aria",Font.PLAIN,20));

		int[] id5batallas = main.getIDLastBattles(main.getCurrentCivilizationID());

		System.out.println("Las últimas 5 batallas de la civilización "+main.getCurrentCivilizationID()+" son "+Arrays.toString(id5batallas));

		JComboBox cb_numBatalla = new JComboBox();

		for (int i : id5batallas) {
			cb_numBatalla.addItem(i);
		}

		cb_numBatalla.setFont(new Font("Arial",Font.PLAIN,20));
		cb_numBatalla.setPreferredSize(new Dimension(20, 20));// Establecer el tamaño

		// seleccionar reporte
		JLabel label_tipoReporte = new JLabel("Tipo of report");
		label_tipoReporte.setFont(new Font("Arial",Font.PLAIN,20));

		String[] tipoReportes = {"Paso a paso","General"};
		JComboBox<String> cb_tipoReporte = new JComboBox<String>(tipoReportes);
		cb_tipoReporte.setFont(new Font("Arial",Font.PLAIN,20));


		// botón ver reporte
		JButton boton_view = new JButton("View log");

		JButton boton_actualizar = new JButton("Update");

		boton_actualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int[] id5batallas = main.getIDLastBattles(main.getCurrentCivilizationID());

				System.out.println("Se ha actualizado el array de las batallas: "+Arrays.toString(id5batallas));

				cb_numBatalla.removeAllItems();

				for (int i : id5batallas) {
					cb_numBatalla.addItem(i);
				}

				System.out.println("Se ha actualizado el cb");
			}
		});



		// añadir al panel

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(10, 50, 10, 10); // padd
		gbc.anchor = GridBagConstraints.WEST;

		gbc.gridx = 0;

		gbc.gridy = 0;
		panelI.add(Box.createRigidArea(new Dimension(0,10)), gbc);
		gbc.gridy = 1;
		panelI.add(label_numeroBattle, gbc);
		gbc.gridy = 2;
		panelI.add(cb_numBatalla, gbc);
		gbc.gridy = 3;
		panelI.add(Box.createRigidArea(new Dimension(0,5)), gbc);
		gbc.gridy = 4;
		panelI.add(label_tipoReporte, gbc);
		gbc.gridy = 5;
		panelI.add(cb_tipoReporte, gbc);
		gbc.gridy = 6;
		panelI.add(Box.createRigidArea(new Dimension(0,20)), gbc);
		gbc.gridy = 7;
		panelI.add(boton_view, gbc);
		gbc.gridy = 8;
		panelI.add(Box.createRigidArea(new Dimension(0,10)), gbc);
		gbc.gridy = 9;
		panelI.add(boton_actualizar, gbc);
		gbc.gridy = 10;
		panelI.add(Box.createRigidArea(new Dimension(0,10)), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		panelI.add(Box.createRigidArea(new Dimension(20,0)), gbc);


		// panel de la derecha

		JScrollPane panelD = new JScrollPane();


		boton_view.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int selectedBattle = (int) cb_numBatalla.getSelectedItem();
				String selectedReportType = (String) cb_tipoReporte.getSelectedItem();



				if (selectedReportType.equals("General")) {
					// Crear JTextArea
					JTextArea mensaje = new JTextArea(main.getLogLastBattles(selectedBattle));
					mensaje.setFont(new Font("Arial", Font.PLAIN, 25));
					mensaje.setWrapStyleWord(true);
					mensaje.setLineWrap(true);
					mensaje.setEditable(false);

					panelD.setViewportView(mensaje);
				}

				else if (selectedReportType.equals("Paso a paso")) {
					// Crear JTextArea
					JTextArea mensaje = new JTextArea(main.getLogPaPLastBattles(selectedBattle));
					mensaje.setFont(new Font("Arial", Font.PLAIN, 25));
					mensaje.setWrapStyleWord(true);
					mensaje.setLineWrap(true);
					mensaje.setEditable(false);

					panelD.setViewportView(mensaje);


				}
			}
		});


		JSplitPane panelPrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelI, panelD);

		// 

		initBarraInferiorBattle(main);

		panelInternoCuatro.add(panelPrincipal, BorderLayout.CENTER); // AQUI LLAMAS AL PANEL CREADO
		panelInternoCuatro.add(panelInferior, BorderLayout.SOUTH);
		tabbedPane.addTab("Battle", panelInternoCuatro);

	}


	// CARGADOR DE INCONOS
	public static ImageIcon createScaledImageIcon(String path, int width, int height) {
		try {
			BufferedImage img = ImageIO.read(new File(path));
			Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			return new ImageIcon(scaledImg);
		} catch (IOException e) {
			System.err.println("Couldn't load file: " + path);
			return null;
		}
	}

	public static ImageIcon createScaledImageIcon1(String path, int width, int height) {
		try {
			BufferedImage img = ImageIO.read(new File(path));
			Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			return new ImageIcon(scaledImg);
		} catch (IOException e) {
			System.err.println("Couldn't load file: " + path);
			return null;
		}
	}

	// UPDATE DE LABELS DE RECURSOS
	public void updateResourceLabels(Main main) {

		foodEdificios.setText(String.valueOf(main.getCurrentCivilization().getFood()));
		foodUnits.setText(String.valueOf(main.getCurrentCivilization().getFood()));
		woodEdificios.setText(String.valueOf(main.getCurrentCivilization().getWood()));
		woodUnits.setText(String.valueOf(main.getCurrentCivilization().getWood()));
		ironEdificios.setText(String.valueOf(main.getCurrentCivilization().getIron()));
		ironUnits.setText(String.valueOf(main.getCurrentCivilization().getIron()));
		manaEdificios.setText(String.valueOf(main.getCurrentCivilization().getMana()));
		manaUnits.setText(String.valueOf(main.getCurrentCivilization().getMana()));

		// LABELS DE LA MAIN MENU

		// RECURSOS
		food2.setText(String.valueOf(main.getCurrentCivilization().getFood()));
		wood2.setText(String.valueOf(main.getCurrentCivilization().getWood()));
		iron2.setText(String.valueOf(main.getCurrentCivilization().getIron()));
		mana2.setText(String.valueOf(main.getCurrentCivilization().getMana()));

		// GENERACIÓN ACTUAL
		foodd2.setText(String.valueOf(CIVILIZATION_FOOD_GENERATED + CIVILIZATION_FOOD_GENERATED_PER_FARM * main.getCurrentCivilization().getFarm()));
		woodd2.setText(String.valueOf(CIVILIZATION_WOOD_GENERATED + CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY * main.getCurrentCivilization().getCarpentry()));
		ironn2.setText(String.valueOf(CIVILIZATION_IRON_GENERATED + CIVILIZATION_IRON_GENERATED_PER_SMITHY * main.getCurrentCivilization().getSmithy()));
		manaa2.setText(String.valueOf(CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER * main.getCurrentCivilization().getMagicTower()));

	}

	public void updateErrorLabel() {
		attentionLabelBuilding.setText("");
		attentionLabelUnits.setText("");
	};

	public void updateUnitsLabel(Main main) {

		totalUnitsArrayLabel.get(0).setText(String.valueOf((main.getCurrentCivilization().getArmy())[0].size()));
		totalUnitsArrayLabel.get(1).setText(String.valueOf((main.getCurrentCivilization().getArmy())[1].size()));
		totalUnitsArrayLabel.get(2).setText(String.valueOf((main.getCurrentCivilization().getArmy())[2].size()));
		totalUnitsArrayLabel.get(3).setText(String.valueOf((main.getCurrentCivilization().getArmy())[3].size()));
		totalUnitsArrayLabel.get(4).setText(String.valueOf((main.getCurrentCivilization().getArmy())[4].size()));
		totalUnitsArrayLabel.get(5).setText(String.valueOf((main.getCurrentCivilization().getArmy())[5].size()));
		totalUnitsArrayLabel.get(6).setText(String.valueOf((main.getCurrentCivilization().getArmy())[6].size()));
		totalUnitsArrayLabel.get(7).setText(String.valueOf((main.getCurrentCivilization().getArmy())[7].size()));
		totalUnitsArrayLabel.get(8).setText(String.valueOf((main.getCurrentCivilization().getArmy())[8].size()));
		
		sword2.setText(String.valueOf((main.getCurrentCivilization().getArmy())[0].size()));
		spearman2.setText(String.valueOf((main.getCurrentCivilization().getArmy())[1].size()));
		crosbow2.setText(String.valueOf((main.getCurrentCivilization().getArmy())[2].size()));
		cannon2.setText(String.valueOf((main.getCurrentCivilization().getArmy())[3].size()));
		tower2.setText(String.valueOf((main.getCurrentCivilization().getArmy())[4].size()));
		catapult2.setText(String.valueOf((main.getCurrentCivilization().getArmy())[5].size()));
		rocket2.setText(String.valueOf((main.getCurrentCivilization().getArmy())[6].size()));
		magician2.setText(String.valueOf((main.getCurrentCivilization().getArmy())[7].size()));
		priest2.setText(String.valueOf((main.getCurrentCivilization().getArmy())[8].size()));
	}

	public void updateBuildingsLabel (Main main) {
		
		// LABELS PAU MAIN MENU
		
		mtower2.setText(String.valueOf((main.getCurrentCivilization().getMagicTower())));
		church2.setText(String.valueOf((main.getCurrentCivilization().getChurch())));
		farm2.setText(String.valueOf((main.getCurrentCivilization().getFarm())));
		smithy2.setText(String.valueOf((main.getCurrentCivilization().getSmithy())));
		carpentry2.setText(String.valueOf((main.getCurrentCivilization().getCarpentry())));
	}
	
	public void updateTechnologyLabels(Main main) {

		// LABELS WILLIAM
		
		// actualizacion del armor/damage en en panel units cuando se aumenta tecnologia
		int[] armorUnitsArray = {
				ARMOR_SWORDSMAN +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY * ARMOR_SWORDSMAN/100),
				ARMOR_SPEARMAN +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_SPEARMAN_BY_TECHNOLOGY * ARMOR_SPEARMAN/100),
				ARMOR_CROSSBOW +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_CROSSBOW_BY_TECHNOLOGY * ARMOR_CROSSBOW/100),
				ARMOR_CANNON +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_CANNON_BY_TECHNOLOGY * ARMOR_CANNON/100),
				ARMOR_ARROWTOWER +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_ARROWTOWER_BY_TECHNOLOGY * ARMOR_ARROWTOWER/100),
				ARMOR_CATAPULT +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_CATAPULT_BY_TECHNOLOGY * ARMOR_CATAPULT/100),
				ARMOR_ROCKETLAUNCHERTOWER +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY * ARMOR_ROCKETLAUNCHERTOWER/100),
				0,
				0,
		};


		
		for (int i = 0; i < armorUnitsArrayLabel.size(); i++) {
			armorUnitsArrayLabel.get(i).setText(String.valueOf(armorUnitsArray[i]));
		}

		int[] damageUnitsArray = {
				BASE_DAMAGE_SWORDSMAN +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_SWORDSMAN_BY_TECHNOLOGY * BASE_DAMAGE_SWORDSMAN/100),
				BASE_DAMAGE_SPEARMAN +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_SPEARMAN_BY_TECHNOLOGY * BASE_DAMAGE_SPEARMAN/100),
				BASE_DAMAGE_CROSSBOW +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_CROSSBOW_BY_TECHNOLOGY * BASE_DAMAGE_CROSSBOW/100),
				BASE_DAMAGE_CANNON +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_CANNON_BY_TECHNOLOGY * BASE_DAMAGE_CANNON/100),
				BASE_DAMAGE_ARROWTOWER +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_ARROWTOWER_BY_TECHNOLOGY * BASE_DAMAGE_ARROWTOWER/100),
				BASE_DAMAGE_CATAPULT +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_CATAPULT_BY_TECHNOLOGY * BASE_DAMAGE_CATAPULT/100),
				BASE_DAMAGE_ROCKETLAUNCHERTOWER +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY/100 * BASE_DAMAGE_ROCKETLAUNCHERTOWER/100),
				BASE_DAMAGE_MAGICIAN +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_MAGICIAN_BY_TECHNOLOGY * BASE_DAMAGE_MAGICIAN/100),
				0,
		};
		
		for (int i = 0; i < damageUnitsArrayLabel.size(); i++) {
			damageUnitsArrayLabel.get(i).setText(String.valueOf(damageUnitsArray[i]));
		}

		// actualizacion del coste al añadir 1
		int[] costDefenseTechnology = {
				0, 
				UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST + ((main.getCurrentCivilization().getTechnologyDefense()) * UPGRADE_PLUS_DEFENSE_TECHNOLOGY_WOOD_COST * UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST/100), 
				UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST + ((main.getCurrentCivilization().getTechnologyDefense()) * UPGRADE_PLUS_DEFENSE_TECHNOLOGY_IRON_COST * UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST/100), 
				0};

		for (int i = 0; i < arrayCostDefenseTechnology.size(); i++) {
			arrayCostDefenseTechnology.get(i).setText(String.valueOf(costDefenseTechnology[i]));
		}


		int[] costAttackTechnology = {
				0, 
				UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST + ((main.getCurrentCivilization().getTechnologyAttack()) * UPGRADE_PLUS_ATTACK_TECHNOLOGY_WOOD_COST * UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST/100), 
				UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST + ((main.getCurrentCivilization().getTechnologyAttack()) * UPGRADE_PLUS_ATTACK_TECHNOLOGY_IRON_COST * UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST/100), 
				0};

		for (int i = 0; i < arrayCostAttackTechnology.size(); i++) {
			arrayCostAttackTechnology.get(i).setText(String.valueOf(costAttackTechnology[i]));
		}


		// LABELS PAU
		/*
		alevel2.setText(String.valueOf((main.getCurrentCivilization().getTechnologyAttack())));
		dlevel2.setText(String.valueOf((main.getCurrentCivilization().getTechnologyDefense())));
		*/
		// MAIN MENU
		
		alevel2.setText(String.valueOf(main.getCurrentCivilization().getTechnologyAttack()));
		dlevel2.setText(String.valueOf(main.getCurrentCivilization().getTechnologyDefense()));
	}	

	public void updateBattleCounter(Main main) {

		// MAIN MENU
		//battle2.setText(String.valueOf((main.getCurrentCivilization().getBattles())));
		battle2.setText(String.valueOf(main.getCurrentCivilization().getBattles()));
	}


}


// EVENTOS DEL PANEL INFERIOR ESTANDARIZADOS

class EventoViewthreath implements ActionListener {
	private Main main;

	EventoViewthreath(Main main) {
		this.main = main;
	}

	public void actionPerformed(ActionEvent e) {
		main.viewthreat(main.getEnemyUnits());
	}

}

class EventoSave implements ActionListener {
    Main main;

    EventoSave(Main main){
        this.main = main;
    }

    public void actionPerformed(ActionEvent e) {
        main.saveGame(main.getCurrentCivilizationID(), main.getCurrentCivilization());
    }

}




