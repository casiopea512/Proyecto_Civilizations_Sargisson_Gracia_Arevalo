package pkg_Principal;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import exceptions.ResourceException;
import intGrafica.EnemiesIncoming;
import interfaces.MilitaryUnit;
import interfaces.Variables;
import pkg_AttackUnit.*;
import pkg_DefenseUnit.*;
import pkg_SpecialUnit.*;


public class Main implements Variables {

	// variable que guarda el array de las unidades enemigas
	private Civilization currentCivilization;
	private int currentCivilizationID;
	private ArrayList<MilitaryUnit>[] enemyUnits;


	public Civilization getCurrentCivilization() {
		return currentCivilization;
	}

	public void setCurrentCivilization(Civilization currentCivilization) {
		this.currentCivilization = currentCivilization;
	}

	public int getCurrentCivilizationID() {
		return currentCivilizationID;
	}

	public void setCurrentCivilizationID(int currentCivilizationID) {
		this.currentCivilizationID = currentCivilizationID;
	}

	public ArrayList<MilitaryUnit>[] getEnemyUnits() {
		return enemyUnits;
	}

	public void setEnemyUnits(ArrayList<MilitaryUnit>[] enemyUnits) {
		this.enemyUnits = enemyUnits;
	}

	//	public static void main(String[] args) {
	//		
	//		
	//		
	//		
	//		
	//		
	//		
	//		// CREAR PARTIDA
	//		/*
	//		principal.createCivilization("ABCDEFGH", "Prueba", principal);
	//		// ESTE METODO YA ASIGNA AL MAIN LA PK (currentCivilizationID) Y CIVILIZACION (currentCivilization)

	//		// CARGADO DE PARTIDAS
	//		/*
	//		principal.setCurrentCivilizationID(principal.chooseCivilizations());
	//		principal.setCurrentCivilization(principal.loadCivilization(principal.getCurrentCivilizationID()));

	//	}


	public ArrayList<MilitaryUnit>[] createEnemyArmy(Civilization civilization) {

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
					// System.out.println("Food = " + foodEnemyResource + " Coste = " + FOOD_COST_SWORDSMAN + " = " + (foodEnemyResource - FOOD_COST_SWORDSMAN));
					// System.out.println("Wood = " + woodEnemyResource + " Coste = " + WOOD_COST_SWORDSMAN + " = " + (woodEnemyResource - WOOD_COST_SWORDSMAN));
					// System.out.println("Iron = " + ironEnemyResource + " Coste = " + IRON_COST_SWORDSMAN + " = " + (ironEnemyResource - IRON_COST_SWORDSMAN));
					System.out.println("SWORDSMAN CREADO + " + chance);
					enemyUnits[0].add(new Swordsman());

					// Se restan recursos
					foodEnemyResource -= FOOD_COST_SWORDSMAN;
					woodEnemyResource -= WOOD_COST_SWORDSMAN;
					ironEnemyResource -= IRON_COST_SWORDSMAN;
				}

			} else if (chance <= 60) {

				if (foodEnemyResource > FOOD_COST_SPEARMAN && woodEnemyResource > WOOD_COST_SPEARMAN && ironEnemyResource > IRON_COST_SPEARMAN) {
					// System.out.println("Food = " + foodEnemyResource + " Coste = " + FOOD_COST_SPEARMAN + " = " + (foodEnemyResource - FOOD_COST_SPEARMAN));
					// System.out.println("Wood = " + woodEnemyResource + " Coste = " + WOOD_COST_SPEARMAN + " = " + (woodEnemyResource - WOOD_COST_SPEARMAN));
					// System.out.println("Iron = " + ironEnemyResource + " Coste = " + IRON_COST_SPEARMAN + " = " + (ironEnemyResource - IRON_COST_SPEARMAN));
					System.out.println("SPEARMAN CREADO + " + chance);
					enemyUnits[1].add(new Spearman());
					foodEnemyResource -= FOOD_COST_SPEARMAN;
					woodEnemyResource -= WOOD_COST_SPEARMAN;
					ironEnemyResource -= IRON_COST_SPEARMAN;
				}


			} else if (chance <= 80) {

				if (foodEnemyResource > FOOD_COST_CROSSBOW && woodEnemyResource > WOOD_COST_CROSSBOW && ironEnemyResource > IRON_COST_CROSSBOW) {
					// System.out.println("Food = " + foodEnemyResource + " Coste = " + FOOD_COST_CROSSBOW + " = " + (foodEnemyResource - FOOD_COST_CROSSBOW));
					// System.out.println("Wood = " + woodEnemyResource + " Coste = " + WOOD_COST_CROSSBOW + " = " + (woodEnemyResource - WOOD_COST_CROSSBOW));
					// System.out.println("Iron = " + ironEnemyResource + " Coste = " + IRON_COST_CROSSBOW + " = " + (ironEnemyResource - IRON_COST_CROSSBOW));
					System.out.println("CROSSBOW CREADO + " + chance);
					enemyUnits[2].add(new Crossbow());
					foodEnemyResource -= FOOD_COST_CROSSBOW;
					woodEnemyResource -= WOOD_COST_CROSSBOW;
					ironEnemyResource -= IRON_COST_CROSSBOW;
				}

			} else {

				if (foodEnemyResource > FOOD_COST_CANNON && woodEnemyResource > WOOD_COST_CANNON && ironEnemyResource > IRON_COST_CANNON) {
					// System.out.println("Food = " + foodEnemyResource + " Coste = " + FOOD_COST_CANNON + " = " + (foodEnemyResource - FOOD_COST_CANNON));
					// System.out.println("Wood = " + woodEnemyResource + " Coste = " + WOOD_COST_CANNON + " = " + (woodEnemyResource - WOOD_COST_CANNON));
					// System.out.println("Iron = " + ironEnemyResource + " Coste = " + IRON_COST_CANNON + " = " + (ironEnemyResource - IRON_COST_CANNON));
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

		System.out.println("EN EL EJERCITO ENEMIGO HAY dentro del método:");
		System.out.println("Swordsman = " + enemyUnits[0].size());
		System.out.println("Spearman = " + enemyUnits[1].size());
		System.out.println("Crossbow = " + enemyUnits[2].size());
		System.out.println("Cannon = " + enemyUnits[3].size());

		return enemyUnits;
	}

	// metodo que ejecuta ventana de peligro enemigo
	public void viewthreat(ArrayList<MilitaryUnit>[] enemyUnit) {
		if (enemyUnits != null) {
			new EnemiesIncoming(enemyUnit);
		} else {
			JOptionPane.showMessageDialog(null, "Our guards have not yet found any trace of enemies.", "NO ENEMIES NEARBY", JOptionPane.DEFAULT_OPTION);
		}

	}


	// GESTION DE LA PARTIDA: CREACION, CARGA Y ELIMINACIÓN

	public void createCivilization(String civilizationName, String userName, Main main) {
		Connection conn = null;
		PreparedStatement ps = null;
		int pkIDcivilization = -1;
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "Civilization";
		String PASS = "civilization";
		try {

			// INSERT EN BBDD
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("CONEXIÓN ESTABLECIDA");
			String update = "INSERT INTO civilization_stats (name, username) VALUES (?, ?)";
			ps = conn.prepareStatement(update, new String[] {"civilization_id"});
			ps.setString(1, civilizationName);
			ps.setString(2, userName);
			ps.executeUpdate();

			/*
	        String name, String username, 
	        float wood, float iron, float food, float mana, 
	        int magicTower, int church, int farm, int smithy, int carpentry, 
	        int technologyDefense, int technologyAttack, int battles)	
			 */

			// se genera el objeto civilizacion
			main.setCurrentCivilization(new Civilization(civilizationName, userName, 0,0,0,0,0,0,0,0,0,0,0,0, 179000)); 

			// OBTENER PK generada
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (null != generatedKeys && generatedKeys.next()) {
				pkIDcivilization = generatedKeys.getInt(1);
				System.out.println("LA PK GENERADA ES " + pkIDcivilization);
				main.setCurrentCivilizationID(pkIDcivilization);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar la conexión y el CallableStatement
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public int chooseCivilizations() {

		Connection conn = null;
		Statement stmt = null;
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "Civilization";
		String PASS = "civilization";
		int choosenCivilizationID = 0;

		try {
			ArrayList arrayPartidas = new ArrayList();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("CONEXIÓN ESTABLECIDA");
			stmt = conn.createStatement();
			String QUERY = "select civilization_id, name, username, battles_counter from civilization_stats";
			ResultSet rs = stmt.executeQuery(QUERY);   	        

			while (rs.next()) {

				System.out.println("RS EJECUTADO");

				int civilization_id = rs.getInt(1);
				System.out.println(civilization_id + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getInt(4));
				arrayPartidas.add(civilization_id);

			}

			System.out.println(arrayPartidas.toString());

			// ATENCION!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			// FORZADO!!!!!
			// Esto se creará luego para cargarlo
			choosenCivilizationID = 1;


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return choosenCivilizationID;

	}

	// Cargar partida (ArrayMilitar + Civilizacion)
	public Civilization loadCivilization(int idChoosenCivilization) {

		//Civilizacion civilization = new Civilization();
		Connection conn = null;
		Statement stmt = null;
		Civilization civilization = null;
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "Civilization";
		String PASS = "civilization";

		// Creating Connection
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			if (conn != null) {
				stmt = conn.createStatement();

				// CARGAR TROPAS

				ArrayList<MilitaryUnit> arraySwordsman = new ArrayList<MilitaryUnit>(); 
				ArrayList<MilitaryUnit> arraySpearman = new ArrayList<MilitaryUnit>(); 
				ArrayList<MilitaryUnit> arrayCrossbow = new ArrayList<MilitaryUnit>(); 
				ArrayList<MilitaryUnit> arrayCannon = new ArrayList<MilitaryUnit>(); 
				ArrayList<MilitaryUnit> arrayArrowTower = new ArrayList<MilitaryUnit>(); 
				ArrayList<MilitaryUnit> arrayCatapult = new ArrayList<MilitaryUnit>(); 
				ArrayList<MilitaryUnit> arrayRocketLauncherTower = new ArrayList<MilitaryUnit>(); 
				ArrayList<MilitaryUnit> arrayMagician = new ArrayList<MilitaryUnit>(); 
				ArrayList<MilitaryUnit> arrayPriest = new ArrayList<MilitaryUnit>(); 


				// carga de unidades atacantes
				// System.out.println("ATTACK UNITS");
				// System.out.println("=".repeat(100));
				String QUERY = "select type, armor, base_damage, experience, sanctified from attack_units_stats where civilization_id = " + idChoosenCivilization;
				ResultSet rs = stmt.executeQuery(QUERY);
				// System.out.println(rs.getInt(1) + " | " + rs.getInt(2) + " | " + rs.getInt(3) + " | " + rs.getInt(4)); 
				while(rs.next()) {
					String unitType = rs.getString(1);
					if (unitType.equals("Swordsman")) {
						// System.out.println("Es Swordsman");
						Swordsman unit = new Swordsman(rs.getInt(2), rs.getInt(3));
						unit.setExperience(rs.getInt(4));
						if (rs.getInt(5) == 1) {
							System.out.println("Esta santificado");
							unit.setSanctified(true);
						}
						arraySwordsman.add(unit);
						// System.out.println("-".repeat(100));
					} else if (unitType.equals("Spearman")) {
						// System.out.println("Es Spearman");
						Spearman unit = new Spearman(rs.getInt(2), rs.getInt(3));
						unit.setExperience(rs.getInt(4));
						if (rs.getInt(5) == 1) {
							System.out.println("Esta santificado");
							unit.setSanctified(true);
						}
						arraySpearman.add(unit);
						// System.out.println("-".repeat(100));
					} else if (unitType.equals("Crossbow")) {
						// System.out.println("Es Crossbow");
						Crossbow unit = new Crossbow(rs.getInt(2), rs.getInt(3));
						unit.setExperience(rs.getInt(4));
						if (rs.getInt(5) == 1) {
							System.out.println("Esta santificado");
							unit.setSanctified(true);
						}
						arrayCrossbow.add(unit);
						// System.out.println("-".repeat(100));
					} else if (unitType.equals("Cannon")) {
						// System.out.println("Es Cannon");
						Cannon unit = new Cannon(rs.getInt(2), rs.getInt(3));
						unit.setExperience(rs.getInt(4));
						if (rs.getInt(5) == 1) {
							System.out.println("Esta santificado");
							unit.setSanctified(true);
						}
						arrayCannon.add(unit);
						// System.out.println("-".repeat(100));
					}
				}

				// unidades de defensa
				// System.out.println("DEFENSE UNITS");
				// System.out.println("=".repeat(100));
				QUERY = "select type, armor, base_damage, experience, sanctified from defense_units_stats where civilization_id = " + idChoosenCivilization;
				rs = stmt.executeQuery(QUERY);

				while(rs.next()) {
					// System.out.println(rs.getInt(1) + " | " + rs.getInt(2) + " | " + rs.getString(3) + " | " + rs.getInt(4)+ " | " + rs.getInt(5)+ " | " + rs.getInt(6)+ " | " + rs.getInt(7));
					String unitType = rs.getString(1);
					if (unitType.equals("ArrowTower")) {
						// System.out.println("Es ArrowTower");
						ArrowTower unit = new ArrowTower(rs.getInt(2), rs.getInt(3));
						unit.setExperience(rs.getInt(4));
						if (rs.getInt(5) == 1) {
							System.out.println("Esta santificado");
							unit.setSanctified(true);
						}
						arrayArrowTower.add(unit);
						// System.out.println("-".repeat(100));
					} else if (unitType.equals("Catapult")) {
						// System.out.println("Es Catapult");
						Catapult unit = new Catapult(rs.getInt(2), rs.getInt(3));
						unit.setExperience(rs.getInt(4));
						if (rs.getInt(5) == 1) {
							System.out.println("Esta santificado");
							unit.setSanctified(true);
						}
						arrayCatapult.add(unit);
						// System.out.println("-".repeat(100));
					} else if (unitType.equals("RocketLauncherTower")) {
						// System.out.println("Es RocketLauncher");
						RocketLauncherTower unit = new RocketLauncherTower(rs.getInt(2), rs.getInt(3));
						unit.setExperience(rs.getInt(4));
						if (rs.getInt(5) == 1) {
							System.out.println("Esta santificado");
							unit.setSanctified(true);
						}
						arrayRocketLauncherTower.add(unit);
						// System.out.println("-".repeat(100));
					} 
				}

				// unidades especiales
				// System.out.println("SPECIAL UNITS");
				// System.out.println("=".repeat(100));
				QUERY = "select type, armor, base_damage, experience from special_units_stats where civilization_id = " + idChoosenCivilization;
				rs = stmt.executeQuery(QUERY);
				while(rs.next()) {
					// System.out.println(rs.getInt(1) + " | " + rs.getInt(2) + " | " + rs.getString(3) + " | " + rs.getInt(4)+ " | " + rs.getInt(5)+ " | " + rs.getInt(6)+ " | " + rs.getInt(7));
					String unitType = rs.getString(1);
					if (unitType.equals("Magician")) {
						// System.out.println("Es Magician");
						Magician unit = new Magician(rs.getInt(2), rs.getInt(3));
						unit.setExperience(rs.getInt(4));
						arrayMagician.add(unit);
						// System.out.println("-".repeat(100));
					} else if (unitType.equals("Priest")) {
						// System.out.println("Es Priest");
						Priest unit = new Priest(rs.getInt(2), rs.getInt(3));
						unit.setExperience(rs.getInt(4));
						arrayPriest.add(unit);
						// System.out.println("-".repeat(100));
					} 
				}
				// System.out.println("=".repeat(100));

				ArrayList<MilitaryUnit>[] civilizationUnits = new ArrayList[9];
				civilizationUnits[0] = arraySwordsman;
				civilizationUnits[1] = arraySpearman;
				civilizationUnits[2] = arrayCrossbow;
				civilizationUnits[3] = arrayCannon;
				civilizationUnits[4] = arrayArrowTower;
				civilizationUnits[5] = arrayCatapult;
				civilizationUnits[6] = arrayRocketLauncherTower;
				civilizationUnits[7] = arrayMagician;
				civilizationUnits[8] = arrayPriest;

				/* COMPROBACIÓN
	    	        for (int i = 0 ; i < civilizationUnits.length ; i++) {
	    	        	for (MilitaryUnit unidad : civilizationUnits[i]) {
	    	        		System.out.println(unidad.getClass().toString());
	    	        		System.out.println("Armor = " + unidad.getActualArmor() + " | Experiencia = " + unidad.getExperience());
	    	        	}
	    	        }
				 */

				/*
	    	        String name, String username, 
	    	        float wood, float iron, float food, float mana, 
	    	        int magicTower, int church, int farm, int smithy, int carpentry, 
	    	        int technologyDefense, int technologyAttack, int battles, int timeLeft)	
				 */

				//Civilization loadedCivilizationn = new Civilization();

				QUERY = "select * from civilization_stats where civilization_id = " + idChoosenCivilization;
				rs = stmt.executeQuery(QUERY);
				rs.next();
				civilization =  new Civilization(rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9),rs.getInt(10), rs.getInt(11), rs.getInt(12),
						rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16));
				civilization.setArmy(civilizationUnits);
			} 

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return civilization;
	}

	// GESTION DEL UPDATE/GUARDADO PARTIDA

	public void updateResources(int civilizationID, Civilization civilization) {

		// UPDATE EN LA BBDD
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "Civilization";
		String PASS = "civilization";
		Connection conn = null;
		CallableStatement stmt = null;

		try {
			// Registrar el driver JDBC de Oracle
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establecer la conexión con la base de datos
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String callProcedure = "{call update_resources(?, ?, ?, ?, ?)}";
			stmt = conn.prepareCall(callProcedure);

			// Establecer los parámetros de entrada del procedimiento
			stmt.setInt(1, civilizationID);
			stmt.setInt(2, civilization.getFood());
			stmt.setInt(3, civilization.getWood());
			stmt.setInt(4, civilization.getIron());
			stmt.setInt(5, civilization.getMana());

			// Ejecutar el procedimiento almacenado
			stmt.execute();

			System.out.println("PROCEDIMIENTO update_resources OK");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar la conexión y el CallableStatement
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	};

	public void updateBuildingsAndTechnologies(int civilizationID, Civilization civilization) {


		// UPDATE EN LA BBDD
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "Civilization";
		String PASS = "civilization";
		Connection conn = null;
		CallableStatement stmt = null;

		try {
			// Registrar el driver JDBC de Oracle
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establecer la conexión con la base de datos
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String callProcedure = "{call update_buildingsAndTechnologies (?, ?, ?, ?, ?, ?, ?, ?)}";
			stmt = conn.prepareCall(callProcedure);

			// Establecer los parámetros de entrada del procedimiento  
			stmt.setInt(1, civilizationID);
			stmt.setInt(2, civilization.getMagicTower());
			stmt.setInt(3, civilization.getChurch());
			stmt.setInt(4, civilization.getFarm());
			stmt.setInt(5, civilization.getSmithy());
			stmt.setInt(6, civilization.getCarpentry());
			stmt.setInt(7, civilization.getTechnologyDefense());
			stmt.setInt(8, civilization.getTechnologyAttack());
			// Ejecutar el procedimiento almacenado
			stmt.execute();

			System.out.println("PROCEDIMIENTO update_buildingsAndTechnologies OK");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar la conexión y el CallableStatement
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateBattleAndTimerCounter(int civilizationID, Civilization civilization) {
		Connection conn = null;
		PreparedStatement ps = null;
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "Civilization";
		String PASS = "civilization";
		try {

			// INSERT EN BBDD
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("CONEXIÓN ESTABLECIDA");
			String update = "UPDATE civilization_stats SET battles_counter = (?) WHERE civilization_id = " + civilizationID;
			ps = conn.prepareStatement(update);
			ps.setInt(1, civilization.getBattles());
			ps.executeUpdate();
			System.out.println("Update de las batallas realizado correctamente");

			update = "UPDATE civilization_stats SET time_left = (?) WHERE civilization_id = " + civilizationID;
			ps = conn.prepareStatement(update);
			ps.setInt(1, civilization.getTimeLeft());
			ps.executeUpdate();
			System.out.println("Update del timeLeft realizado correctamente");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateUnits(int civilizationID, Civilization civilization) {

		Connection conn = null;
		CallableStatement stmt = null;
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "Civilization";
		String PASS = "civilization";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String callProcedure = "{call deleteUnits(?)}";
			stmt = conn.prepareCall(callProcedure);
			stmt.setInt(1, civilizationID);
			stmt.execute();
			System.out.println("PROCEDIMIENTO deleteUnits OK");

			for (ArrayList<MilitaryUnit> unidades : civilization.getArmy()) {
				System.out.println(unidades.size());
				for (MilitaryUnit unidad : unidades) {
					if (unidad instanceof AttackUnit) {

						//System.out.println("attack UNIT = " + unidad.getClass().getSimpleName());
						String update = "INSERT INTO attack_units_stats (civilization_id, type, armor, base_damage, experience, sanctified) VALUES (?, ?, ?, ?, ?, ?)";
						PreparedStatement ps = conn.prepareStatement(update);
						ps.setInt(1, civilizationID);
						ps.setString(2, unidad.getClass().getSimpleName());
						ps.setInt(3, unidad.getActualArmor());
						ps.setInt(4,3);
						ps.setInt(5, unidad.getExperience());

						if (((AttackUnit) unidad).isSanctified()) {
							System.out.println("Unidad santificada; SI");
							ps.setInt(6, 1);
						} else {
							System.out.println("Unidad santificada; NO");
							ps.setInt(6, 0);
						}

						ps.executeUpdate();

					} else if (unidad instanceof DefenseUnit) {
						//System.out.println("defense UNIT = " + unidad.getClass().getSimpleName());
						String update = "INSERT INTO defense_units_stats (civilization_id, type, armor, base_damage, experience, sanctified) VALUES (?, ?, ?, ?, ?, ?)";
						PreparedStatement ps = conn.prepareStatement(update);
						ps.setInt(1, civilizationID);
						ps.setString(2, unidad.getClass().getSimpleName());
						ps.setInt(3, unidad.getActualArmor());
						ps.setInt(4,3);
						ps.setInt(5, unidad.getExperience());

						if (((DefenseUnit) unidad).isSanctified()) {
							System.out.println("Unidad santificada; SI");
							ps.setInt(6, 1);
						} else {
							System.out.println("Unidad santificada; NO");
							ps.setInt(6, 0);
						}
						ps.executeUpdate();
					} else {
						//System.out.println("special UNIT = " + unidad.getClass().getSimpleName());
						String update = "INSERT INTO special_units_stats (civilization_id, type, armor, base_damage, experience) VALUES (?, ?, ?, ?, ?)";
						PreparedStatement ps = conn.prepareStatement(update);
						ps.setInt(1, civilizationID);
						ps.setString(2, unidad.getClass().getSimpleName());
						ps.setInt(3, unidad.getActualArmor());
						ps.setInt(4,3);
						ps.setInt(5, unidad.getExperience());
						ps.executeUpdate();
					}
				}
			} 

			System.out.println("INSERT de unidades CORRECTAMENTE");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar la conexión y el CallableStatement
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void saveGame(int civilizationID, Civilization civilization) {
		this.updateResources(civilizationID, civilization);
		this.updateBuildingsAndTechnologies(civilizationID, civilization);
		this.updateBattleAndTimerCounter(civilizationID, civilization);
		this.updateUnits(civilizationID, civilization);
	}


	// crear la batalla en la bd
	public void updateBattle(int civilizationID,ArrayList<String> log_pap, String logGeneral) {

		// insert into battle_stats(civil_id)

		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "Civilization";
		String PASS = "civilization";
		Connection conn = null;
		CallableStatement stmt = null;

		try {
			// Registrar el driver JDBC de Oracle
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establecer la conexión con la base de datos
			conn = DriverManager.getConnection(DB_URL, USER, PASS);


			// CREAR BATALLA
			String update = "INSERT INTO battle_stats (civilization_id) VALUES (?)";
			PreparedStatement ps = conn.prepareStatement(update, new String[] {"num_battle"});
			ps.setInt(1, civilizationID);
			ps.executeUpdate();

			System.out.println("\nSe ha insertado correctamente en la BBDD la batalla");


			// OBTENER PK generada
			int pKIdBattle = 0;
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (null != generatedKeys && generatedKeys.next()) {
				pKIdBattle = generatedKeys.getInt(1);
			}

			System.out.println("\nSe ha generado correctamente la PK de la batalla: "+ pKIdBattle);


			// UPDATE REPORTE PAOS A PASO
			update = "INSERT INTO battle_log_paso_a_paso (civilization_id, num_battle, log_entry) VALUES (?,?,?)";
			ps = conn.prepareStatement(update);

			for (String line : log_pap) {
				ps.setInt(1, civilizationID);
				ps.setInt(2, pKIdBattle);
				ps.setString(3, line);
				ps.executeUpdate();
			}

			System.out.println("\nSe ha insertado correctamente en la BBDD el reporte paso a paso");


			// UPDATE REPORTE GENERAL
			update = "INSERT INTO battle_log_reporte (civilization_id, num_battle, log_entry) VALUES (?,?,?)";
			ps = conn.prepareStatement(update);
			ps.setInt(1, civilizationID);
			ps.setInt(2, pKIdBattle);
			ps.setString(3, logGeneral);
			ps.executeUpdate();

			System.out.println("\nSe ha insertado correctamente en la BBDD el reporte general");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar la conexión y el CallableStatement
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// update resources de la civilización
	public void addResourcesCivilization(int[] wasteWoodIron, Civilization civilization) {

		System.out.println("Se van a añadir las ganancias de la batalla, este es el estado antes de añadir: "+civilization.getWood()+" | "+civilization.getIron());

		civilization.setWood(civilization.getWood() + wasteWoodIron[0]);
		civilization.setIron(civilization.getIron() + wasteWoodIron[1]);

		System.out.println("Se han añadido las perdidas de la batalla a la civilización: "+civilization.getWood()+" | "+civilization.getIron());
	}


	// obtener el reporte de las últimas cinco batallas
	public int[] getIDLastBattles(int idCiv) {

		int[] id5Batallas = new int[5];	

		Connection conn = null;
		int pkIDcivilization = -1;
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "Civilization";
		String PASS = "civilization";

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			//seleccionar el número de las últimas batallas
			String query = "select * from battle_stats where civilization_id = ? and ROWNUM <= 5 order by num_battle desc"; 
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, idCiv);
			ResultSet rs = ps.executeQuery();


			int numExponencial = 0;
			while(rs.next()) {
				id5Batallas[numExponencial] = rs.getInt(2);
				numExponencial ++;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id5Batallas;

	}

	public String getLogLastBattles(int idBattle) {
		
		
		int idCiv = this.getCurrentCivilizationID();
		String reporte = "";
		
		Connection conn = null;
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "Civilization";
		String PASS = "civilization";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			//seleccionar el número de las últimas batallas
			String query = "SELECT log_entry FROM battle_log_reporte WHERE civilization_id = ?  AND num_battle = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs;
			
			ps.setInt(1, idCiv);
			ps.setInt(2, idBattle);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				reporte = rs.getString(1);
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reporte;
	}
	
	public String getLogPaPLastBattles(int idBattle) {
		
		int idCiv = this.getCurrentCivilizationID();
		String reportePasos ="";
		
		Connection conn = null;
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "Civilization";
		String PASS = "civilization";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "SELECT log_entry FROM battle_log_paso_a_paso WHERE civilization_id = ?  AND num_battle = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs;

				
				ps.setInt(1, idCiv);
				ps.setInt(2, idBattle);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					reportePasos += rs.getString(1);
				}
				
				
			
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reportePasos;
	}
}


