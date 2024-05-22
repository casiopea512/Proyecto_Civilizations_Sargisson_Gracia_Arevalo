package pkg_Principal;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import interfaces.Variables;



public class JTabbedPaneUno extends JFrame implements Variables {
	
	Main mainObject;
	
	private JTabbedPane tabbedPane;
	private JPanel panelInternoUno, panelInternoDos, panelInternoTres, panelInternoCuatro;

	JTabbedPaneUno(Main main){
		
		setSize(900, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		initComponents(main);
		
		setVisible(true); 
	}
	
	public void initComponents(Main main){
		
		tabbedPane = new JTabbedPane();
		initMainMenu();
		initBuildingsAndTechnologyPanel(main);
		initUnitsPanel(main);
		initBattlePanel();
		add(tabbedPane);
	}
	
	public void initMainMenu() {
		panelInternoUno = new JPanel();
		panelInternoUno.setBackground(Color.BLUE);
		tabbedPane.addTab("Main menu", panelInternoUno);
	}
	
	JPanel panelRecursos, panelPrincipalEdificios, panelInferior;
	JLabel food, wood, iron, mana;
	ImageIcon iconFood, iconWood, iconIron, iconMana;
	JLabel battleCountdown;
	JButton viewthreat, pause, save, exit;
	
	public void initResourcesPanel(Main main) {
		
		panelRecursos = new JPanel();
		panelRecursos.setLayout(new BoxLayout(panelRecursos, BoxLayout.X_AXIS));
		panelRecursos.setBackground(Color.BLACK);
		
		iconFood = createScaledImageIcon("./src/food.png", 40, 40);
        iconWood = createScaledImageIcon("./src/wood.png", 40, 40);
        iconIron = createScaledImageIcon("./src/iron.png", 40, 40);
        iconMana = createScaledImageIcon("./src/mana.png", 40, 40);
		
		food = new JLabel(String.valueOf(main.getCurrentCivilization().getFood()), iconFood, SwingConstants.CENTER);
		food.setForeground(Color.WHITE);
		food.setFont(new Font("Arial", Font.BOLD, 20));
		food.setHorizontalAlignment(JLabel.CENTER);
		wood = new JLabel(String.valueOf(main.getCurrentCivilization().getWood()), iconWood, SwingConstants.CENTER);
		wood.setForeground(Color.WHITE);
		wood.setFont(new Font("Arial", Font.BOLD, 20));
		wood.setHorizontalAlignment(JLabel.CENTER);
		iron = new JLabel(String.valueOf(main.getCurrentCivilization().getIron()), iconIron, SwingConstants.CENTER);
		iron.setForeground(Color.WHITE);
		iron.setHorizontalAlignment(JLabel.CENTER);
		iron.setFont(new Font("Arial", Font.BOLD, 20));
		mana = new JLabel(String.valueOf(main.getCurrentCivilization().getMana()), iconMana, SwingConstants.CENTER);
		mana.setForeground(Color.WHITE);
		mana.setFont(new Font("Arial", Font.BOLD, 20));
		mana.setHorizontalAlignment(JLabel.CENTER);
		
		panelRecursos.add(Box.createHorizontalGlue()); // Spacer for equal distribution
		panelRecursos.add(food);
		panelRecursos.add(Box.createHorizontalGlue()); // Spacer for equal distribution
        panelRecursos.add(wood);
        panelRecursos.add(Box.createHorizontalGlue()); // Spacer for equal distribution
        panelRecursos.add(iron);
        panelRecursos.add(Box.createHorizontalGlue()); // Spacer for equal distribution
        panelRecursos.add(mana);
        panelRecursos.add(Box.createHorizontalGlue());
		
	}
	
	public void initBarraInferior(Main main) {
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.BLACK);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		JPanel panelCountdown = new JPanel();
		panelCountdown.setBackground(Color.BLACK);
		battleCountdown = new JLabel("BATTLE COUNTDOWN: " + "120 seconds" + " ");
		battleCountdown.setForeground(Color.WHITE);
		battleCountdown.setFont(new Font("Arial", Font.BOLD, 30));
		viewthreat = new JButton("VIEW THREAT");
		panelCountdown.add(battleCountdown);
		panelCountdown.add(viewthreat);
		panelInferior.add(panelCountdown);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		panelBotones.setBackground(Color.BLACK);
		pause = new JButton("PAUSE");
		save = new JButton("SAVE");
		exit = new JButton("EXIT");
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(pause);
		panelBotones.add(Box.createHorizontalGlue());
		panelBotones.add(save);
		panelBotones.add(exit);
		panelBotones.add(Box.createHorizontalGlue());
		panelInferior.add(panelBotones);
		
		viewthreat.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				System.out.println("ViewThreat");
				
			}
			
		});
		
		pause.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				System.out.println("Pause");
				
			}
			
		});
		
		save.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				System.out.println("Save");
				
			}
			
		});
		
		exit.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				System.out.println("Exit");
				
			}
			
		});
	}
	
	public void initBuildingsAndTechnologyPanel(Main main) {
		panelInternoDos = new JPanel();
		panelInternoDos.setBackground(Color.YELLOW);
		panelInternoDos.setLayout(new BorderLayout());
		
		// PANEL DE RECURSOS
		initResourcesPanel(main);
		
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
            panelPrincipalSuperior.add(resourceLabels[i], gbc);
        }

        // EDIFICIOS
        String[] buildings = {"    Farm", "    Carpentry", "    Smithy", "    Magic Tower", "    Church"};
        int[] quantityBuildings = {5, 8, 7, 3, 1};
        int[][] costBuildings =
            {{FOOD_COST_FARM, WOOD_COST_FARM, IRON_COST_FARM, 0},
             {FOOD_COST_CARPENTRY, WOOD_COST_CARPENTRY, IRON_COST_CARPENTRY, 0},
             {FOOD_COST_SMITHY, WOOD_COST_SMITHY, IRON_COST_SMITHY, 0},
             {FOOD_COST_MAGICTOWER, WOOD_COST_MAGICTOWER, IRON_COST_MAGICTOWER, 0},
             {FOOD_COST_CHURCH, WOOD_COST_CHURCH, IRON_COST_CHURCH, 10000}};

        for (int i = 0; i < buildings.length; i++) {
            JLabel buildingLabel = new JLabel(buildings[i]);
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 0.1;
            gbc.weighty = 0.1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panelPrincipalSuperior.add(buildingLabel, gbc);

            JButton addButton = new JButton("+");
            gbc.gridx = 1;
            gbc.gridy = i + 1;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 0.1;
            gbc.weighty = 0.1;
            gbc.fill = GridBagConstraints.NONE;
            panelPrincipalSuperior.add(addButton, gbc);

            JLabel totalLabel = new JLabel("Total: " + quantityBuildings[i]);
            gbc.gridx = 2;
            gbc.gridy = i + 1;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 0.1;
            gbc.weighty = 0.1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panelPrincipalSuperior.add(totalLabel, gbc);

            for (int j = 0; j < costBuildings[0].length; j++) {
                JLabel resourceValue = new JLabel(String.valueOf(costBuildings[i][j]));
                gbc.gridx = j + 3;
                gbc.gridy = i + 1;
                gbc.weightx = 0.1;
                gbc.weighty = 0.1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                panelPrincipalSuperior.add(resourceValue, gbc);
            }
        }

        // TITULOS

        JLabel buildingsLabel = new JLabel("BUILDINGS");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipalSuperior.add(buildingsLabel, gbc);

        JLabel technologyLabel = new JLabel("TECHNOLOGY");
        gbc.gridx = 0;
        gbc.gridy = buildings.length + 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
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
        panelPrincipalSuperior.add(attackLabel, gbc);

        JButton attackButton = new JButton("+");
        gbc.gridx = 1;
        gbc.gridy = buildings.length + 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.NONE;
        panelPrincipalSuperior.add(attackButton, gbc);

        JLabel attackLevelLabel = new JLabel("Current level: " + 2);
        gbc.gridx = 2;
        gbc.gridy = buildings.length + 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipalSuperior.add(attackLevelLabel, gbc);

        int[] costAttackTechnology = {12323232, 111111, 32323232, 0};
        for (int i = 0; i < costAttackTechnology.length; i++) {
            JLabel technologyCost = new JLabel(String.valueOf(costAttackTechnology[i]));
            gbc.gridx = i + 3;
            gbc.gridy = buildings.length + 2;
            gbc.weightx = 0.1;
            gbc.weighty = 0.1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panelPrincipalSuperior.add(technologyCost, gbc);
        }

        // TECNOLOGIA DE DEFENSA
        JLabel defenseLabel = new JLabel("    Defense Level");
        gbc.gridx = 0;
        gbc.gridy = buildings.length + 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipalSuperior.add(defenseLabel, gbc);

        JButton defenseButton = new JButton("+");
        gbc.gridx = 1;
        gbc.gridy = buildings.length + 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.NONE;
        panelPrincipalSuperior.add(defenseButton, gbc);

        JLabel defenseLevelLabel = new JLabel("Current level: " + 3);
        gbc.gridx = 2;
        gbc.gridy = buildings.length + 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipalSuperior.add(defenseLevelLabel, gbc);

        int[] costDefenseTechnology = {22222222, 333333333, 1111111, 0};
        for (int i = 0; i < costDefenseTechnology.length; i++) {
            JLabel technologyCost = new JLabel(String.valueOf(costDefenseTechnology[i]));
            gbc.gridx = i + 3;
            gbc.gridy = buildings.length + 3;
            gbc.weightx = 0.1;
            gbc.weighty = 0.1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panelPrincipalSuperior.add(technologyCost, gbc);
        }

        // ERROR
        // Attention message
        
        JPanel panelError = new JPanel();
        JLabel attentionLabel = new JLabel("ATTENTION: You don't have enough resources to create the new building!");
        attentionLabel.setForeground(Color.RED);
        panelError.add(attentionLabel);

        panelPrincipalEdificios.add(panelPrincipalSuperior, BorderLayout.CENTER);
        panelPrincipalEdificios.add(panelError, BorderLayout.SOUTH);
        
		// PANEL INFERIOR
        
		initBarraInferior(main);
		
		panelInternoDos.add(panelRecursos, BorderLayout.NORTH);
		panelInternoDos.add(panelPrincipalEdificios, BorderLayout.CENTER);
		panelInternoDos.add(panelInferior, BorderLayout.SOUTH);
		tabbedPane.addTab("Buildings and Technology", panelInternoDos);
		
	}
	
	JPanel panelPrincipalUnidades;
	
	public void initUnitsPanel(Main main) {
		panelInternoTres =  new JPanel();
		panelInternoTres.setBackground(Color.GREEN);
		panelInternoTres.setLayout(new BorderLayout());
		
		initResourcesPanel(main);
		
        // PANEL CENTRAL
        
		panelPrincipalUnidades = new JPanel();
		panelPrincipalUnidades.setLayout(new BorderLayout());
       
		JPanel panelPrincipalSuperior = new JPanel();
		panelPrincipalSuperior.setLayout(new GridBagLayout());

		String[] units = {
		        "Swordsman", "Spearman", "Crossbow", "Cannon", "Arrow Tower",
		        "Catapult", "Rocket Launcher Tower", "Magician", "Priest"
		};
		String[] headers = {"ARMOR", "DAMAGE", "", "", "FOOD", "WOOD", "IRON", "MANA"};
		int armor = 50;
		int damage = 75;
		int[] resources = {100, 200, 300, 400};

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH; // Adjusts both width and height
		gbc.weightx = 1.0; // Components grow horizontally
		gbc.weighty = 1.0; // Components grow vertically
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST; // Center components within their cells

		// Add headers
		gbc.gridy = 0;
		gbc.gridx = 0;
		panelPrincipalSuperior.add(new JLabel("UNITS"), gbc);
		gbc.gridx = 1;
		panelPrincipalSuperior.add(new JLabel("TOTAL UNITS"), gbc);

		for (int i = 0; i < headers.length; i++) {
		    gbc.gridx = i + 2;
		    JLabel headerLabel = new JLabel(headers[i]);
		    panelPrincipalSuperior.add(headerLabel, gbc);
		}

		// Add unit rows
		for (int i = 0; i < units.length; i++) {
		    gbc.gridy = i + 1;
		    gbc.gridx = 0;
		    panelPrincipalSuperior.add(new JLabel(units[i]), gbc);

		    gbc.gridx = 1;
		    JLabel totalUnitsLabel = new JLabel("50");
		    panelPrincipalSuperior.add(totalUnitsLabel, gbc);

		    gbc.gridx = 2;
		    panelPrincipalSuperior.add(new JLabel(String.valueOf(armor)), gbc);

		    gbc.gridx = 3;
		    panelPrincipalSuperior.add(new JLabel(String.valueOf(damage)), gbc);

		    gbc.gridx = 4;
		    JTextField quantityField = new JTextField("10", 5);
		    quantityField.setHorizontalAlignment(JTextField.CENTER);
		    panelPrincipalSuperior.add(quantityField, gbc);

		    gbc.gridx = 5;
		    JButton createButton = new JButton("Create");
		    panelPrincipalSuperior.add(createButton, gbc);

		    createButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int currentTotal = Integer.parseInt(totalUnitsLabel.getText());
		                int quantityToAdd = Integer.parseInt(quantityField.getText());
		                if (quantityToAdd < 0) {
		                    JOptionPane.showMessageDialog(panelPrincipalSuperior, "Quantity must be non-negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
		                    return;
		                }
		                totalUnitsLabel.setText(String.valueOf(currentTotal + quantityToAdd));
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(panelPrincipalSuperior, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    });

		    for (int j = 0; j < resources.length; j++) {
		        gbc.gridx = 6 + j;
		        JLabel resourceLabel = new JLabel(String.valueOf(resources[j]));
		        panelPrincipalSuperior.add(resourceLabel, gbc);
		    }
		}

        // ERROR
        // Attention message
        
        JPanel panelError = new JPanel();
        JLabel attentionLabel = new JLabel("ATTENTION: You don't have enough resources to create the new building!");
        attentionLabel.setForeground(Color.RED);
        panelError.add(attentionLabel);

        panelPrincipalUnidades.add(panelPrincipalSuperior, BorderLayout.CENTER);
        panelPrincipalUnidades.add(panelError, BorderLayout.SOUTH);
        
		// PANEL INFERIOR
        
		initBarraInferior(main);
		
		panelInternoTres.add(panelRecursos, BorderLayout.NORTH);
		panelInternoTres.add(panelPrincipalUnidades, BorderLayout.CENTER);
		panelInternoTres.add(panelInferior, BorderLayout.SOUTH);
		tabbedPane.addTab("Units", panelInternoTres);
	}
	
	public void initBattlePanel() {
		panelInternoCuatro =  new JPanel();
		panelInternoCuatro.setBackground(Color.BLACK);
		tabbedPane.addTab("Battle", panelInternoCuatro);
	}
	
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
	
}