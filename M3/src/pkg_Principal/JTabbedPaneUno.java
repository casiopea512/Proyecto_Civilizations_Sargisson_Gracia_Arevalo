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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.ResourceException;
import interfaces.Variables;



public class JTabbedPaneUno extends JFrame implements Variables {
	
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
		this.setTitle("CIVILIZATION");
		initMainMenu(main);
		initBuildingsAndTechnologyPanel(main);
		initUnitsPanel(main);
		initBattlePanel(main);
		add(tabbedPane);
	}

	
	// RECURSOS
	
	// RECURSOS PANEL 
	
	// ICONOS REUTILIZABLES
	ImageIcon iconFood, iconWood, iconIron, iconMana;
	
	JPanel panelRecursosEdificios, panelPrincipalEdificios;
	JLabel foodEdificios, woodEdificios, ironEdificios, manaEdificios;
	

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

	public void initResourcesEdificiosPanel(Main main) {

		
		panelRecursosEdificios = new JPanel();
		panelRecursosEdificios.setLayout(new BoxLayout(panelRecursosEdificios, BoxLayout.X_AXIS));
		panelRecursosEdificios.setBackground(Color.BLACK);
		
		iconFood = createScaledImageIcon("./src/food.png", 40, 40);
        iconWood = createScaledImageIcon("./src/wood.png", 40, 40);
        iconIron = createScaledImageIcon("./src/iron.png", 40, 40);
        iconMana = createScaledImageIcon("./src/mana.png", 40, 40);
		
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
	
	JPanel panelRecursosUnits, panelPrincipalUnidades;
	JLabel foodUnits, woodUnits, ironUnits, manaUnits;

	public JLabel getFoodUnits() {
		return foodUnits;
	}

	public void setFoodUnits(JLabel foodUnits) {
		this.foodUnits = foodUnits;
	}

	public JLabel getWoodUnits() {
		return woodUnits;
	}

	public void setWoodUnits(JLabel woodUnits) {
		this.woodUnits = woodUnits;
	}

	public JLabel getIronUnits() {
		return ironUnits;
	}

	public void setIronUnits(JLabel ironUnits) {
		this.ironUnits = ironUnits;
	}

	public JLabel getManaUnits() {
		return manaUnits;
	}

	public void setManaUnits(JLabel manaUnits) {
		this.manaUnits = manaUnits;
	}

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
	
	// BARRA INFERIOR 
	JPanel panelInferior;
	
	
	JButton viewthreat, pause, save, exit; // REUTILIZABLES
	
	
	JLabel battleCountdownMenuPrincipal;

	public JLabel getBattleCountdownMenuPrincipal() {
		return battleCountdownMenuPrincipal;
	}

	public void BattleCountdownMenuPrincipal(JLabel battleCountdownMenuPrincipal) {
		this.battleCountdownMenuPrincipal = battleCountdownMenuPrincipal;
	}

	public void initBarraMenuPrincipal(Main main) {

		panelInferior = new JPanel();
		panelInferior.setBackground(Color.BLACK);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		JPanel panelCountdown = new JPanel();
		panelCountdown.setBackground(Color.BLACK);
		battleCountdownMenuPrincipal = new JLabel("BATTLE COUNTDOWN: " + main.getCurrentCivilization().getTimeLeft() + " ");
		battleCountdownMenuPrincipal.setForeground(Color.WHITE);
		battleCountdownMenuPrincipal.setFont(new Font("Arial", Font.BOLD, 30));
		viewthreat = new JButton("VIEW THREAT");
		panelCountdown.add(battleCountdownMenuPrincipal);
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
		
		viewthreat.addActionListener(new EventoViewthreath(main));
		
		pause.addActionListener(new EventoPause(main));

		save.addActionListener(new EventoSave(main));

		exit.addActionListener(new EventoExit(main));
	}
	
	
	
	JLabel battleCountdownEdificios;
	
	public JLabel getBattleCountdownEdificios() {
		return battleCountdownEdificios;
	}

	public void setBattleCountdownEdificios(JLabel battleCountdownEdificios) {
		this.battleCountdownEdificios = battleCountdownEdificios;
	}

	public void initBarraInferiorEdificios(Main main) {
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.BLACK);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		JPanel panelCountdown = new JPanel();
		panelCountdown.setBackground(Color.BLACK);
		battleCountdownEdificios = new JLabel("BATTLE COUNTDOWN: " + main.getCurrentCivilization().getTimeLeft() + " ");
		battleCountdownEdificios.setForeground(Color.WHITE);
		battleCountdownEdificios.setFont(new Font("Arial", Font.BOLD, 30));
		viewthreat = new JButton("VIEW THREAT");
		panelCountdown.add(battleCountdownEdificios);
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
		
		viewthreat.addActionListener(new EventoViewthreath(main));
		
		pause.addActionListener(new EventoPause(main));

		save.addActionListener(new EventoSave(main));

		exit.addActionListener(new EventoExit(main));
	}
	
	
	
	JLabel battleCountdownUnidades;
 
	public JLabel getBattleCountdownUnidades() {

		return battleCountdownUnidades;
	}

	public void setBattleCountdownUnidades(JLabel battleCountdownUnidades) {

		this.battleCountdownUnidades = battleCountdownUnidades;
	}

	public void initBarraInferiorUnidades(Main main) {

		panelInferior = new JPanel();
		panelInferior.setBackground(Color.BLACK);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		JPanel panelCountdown = new JPanel();
		panelCountdown.setBackground(Color.BLACK);
		battleCountdownUnidades = new JLabel("BATTLE COUNTDOWN: " + main.getCurrentCivilization().getTimeLeft() + " ");
		battleCountdownUnidades.setForeground(Color.WHITE);
		battleCountdownUnidades.setFont(new Font("Arial", Font.BOLD, 30));
		viewthreat = new JButton("VIEW THREAT");
		panelCountdown.add(battleCountdownUnidades);
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
		
		viewthreat.addActionListener(new EventoViewthreath(main));
		
		pause.addActionListener(new EventoPause(main));

		save.addActionListener(new EventoSave(main));

		exit.addActionListener(new EventoExit(main));
	}
	
	
	
	JLabel battleCountdownBattle;
	 
	public JLabel getBattleCountdownBattle() {
		return battleCountdownBattle;
	}

	public void setBattleCountdownBattle(JLabel battleCountdownBattle) {
		this.battleCountdownBattle = battleCountdownBattle;
	}

	public void initBarraInferiorBattle(Main main) {
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.BLACK);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		JPanel panelCountdown = new JPanel();
		panelCountdown.setBackground(Color.BLACK);
		battleCountdownBattle = new JLabel("BATTLE COUNTDOWN: " + main.getCurrentCivilization().getTimeLeft() + " ");
		battleCountdownBattle.setForeground(Color.WHITE);
		battleCountdownBattle.setFont(new Font("Arial", Font.BOLD, 30));
		viewthreat = new JButton("VIEW THREAT");
		panelCountdown.add(battleCountdownBattle);
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
		
		viewthreat.addActionListener(new EventoViewthreath(main));
		
		pause.addActionListener(new EventoPause(main));

		save.addActionListener(new EventoSave(main));

		exit.addActionListener(new EventoExit(main));
	}
	
	// INICIALIZACION DE PANELES PRINCIPALES
	
	// PANELES PRINCIPALES
	
	public void initMainMenu(Main main) {
		panelInternoUno = new JPanel();
		panelInternoUno.setBackground(Color.BLUE);
		panelInternoUno.setLayout(new BorderLayout());
		
		// INTEGRACION DE PANEL SUPERIOR CENTRAL
		
			JPanel panelPrincipal = new JPanel();
			panelPrincipal.setBackground(Color.ORANGE);
		
		// 
		
		initBarraMenuPrincipal(main);
		
		panelInternoUno.add(panelPrincipal, BorderLayout.CENTER);
		panelInternoUno.add(panelInferior, BorderLayout.SOUTH);
		tabbedPane.addTab("Main menu", panelInternoUno);
		
	}
	
	// PanelPrincipalEdificios tiene(declarado internamente)
	// - PanelPrincipalSuperior
	// - PanelErrores
	
	JLabel attentionLabelBuilding;
	
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
            arrayJLabel.add(totalLabel);
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
        
        // EVENTOS DE LOS BOTONES
        
        arrayButtons.get(0).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					main.getCurrentCivilization().newFarm();
					arrayJLabel.get(0).setText("Total: " + main.getCurrentCivilization().getFarm());
					updateResourceLabels(main);
				} catch (ResourceException e1) {
					attentionLabelBuilding.setText(e1.getMessage());
					
				}
			}
        	
        });
        arrayButtons.get(1).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					main.getCurrentCivilization().newCarpentry();
					arrayJLabel.get(1).setText("Total: " + main.getCurrentCivilization().getCarpentry());
					updateResourceLabels(main);
				} catch (ResourceException e1) {
					attentionLabelBuilding.setText(e1.getMessage());
					
				}
			}
        	
        });
        arrayButtons.get(2).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					main.getCurrentCivilization().newSmithy();
					arrayJLabel.get(2).setText("Total: " + main.getCurrentCivilization().getSmithy());
					updateResourceLabels(main);
				} catch (ResourceException e1) {
					attentionLabelBuilding.setText(e1.getMessage());
					
				}
			}
        	
        });
        arrayButtons.get(3).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					main.getCurrentCivilization().newMagicTower();
					arrayJLabel.get(3).setText("Total: " + main.getCurrentCivilization().getMagicTower());
					updateResourceLabels(main);
				} catch (ResourceException e1) {
					attentionLabelBuilding.setText(e1.getMessage());
					
				}
			}
        	
        });
        arrayButtons.get(4).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					main.getCurrentCivilization().newChurch();
					arrayJLabel.get(4).setText("Total: " + main.getCurrentCivilization().getChurch());
					updateResourceLabels(main);
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
        
        JLabel attackLevelLabel = new JLabel("Current level: " + main.getCurrentCivilization().getTechnologyAttack());
        gbc.gridx = 2;
        gbc.gridy = buildings.length + 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipalSuperior.add(attackLevelLabel, gbc);
        
       
        ArrayList<JLabel> arrayCostAttackTechnology = new ArrayList<JLabel>();
        int[] costAttackTechnology = {12323232, 111111, 32323232, 0};
        for (int i = 0; i < costAttackTechnology.length; i++) {
            JLabel technologyCost = new JLabel(String.valueOf(costAttackTechnology[i]));
            gbc.gridx = i + 3;
            gbc.gridy = buildings.length + 2;
            gbc.weightx = 0.1;
            gbc.weighty = 0.1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            arrayCostAttackTechnology.add(technologyCost);
            panelPrincipalSuperior.add(technologyCost, gbc);
        }
        
        attackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					main.getCurrentCivilization().upgradeTechnologyAttack();;
					attackLevelLabel.setText("Current level: " + main.getCurrentCivilization().getTechnologyAttack());
					updateResourceLabels(main);
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
        panelPrincipalSuperior.add(defenseLevelLabel, gbc);
        
       
        ArrayList<JLabel> arrayCostDefenseTechnology = new ArrayList<JLabel>();
        int[] costDefenseTechnology = {22222222, 333333333, 1111111, 0};
      
        for (int i = 0; i < costDefenseTechnology.length; i++) {
            JLabel technologyCost = new JLabel(String.valueOf(costDefenseTechnology[i]));
            gbc.gridx = i + 3;
            gbc.gridy = buildings.length + 3;
            gbc.weightx = 0.1;
            gbc.weighty = 0.1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            arrayCostDefenseTechnology.add(technologyCost);
            panelPrincipalSuperior.add(technologyCost, gbc);
        }
        
        defenseButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					main.getCurrentCivilization().upgradeTechnologyDefense();;
					defenseLevelLabel.setText("Current level: " + main.getCurrentCivilization().getTechnologyDefense());
					updateResourceLabels(main);
					
					int[] costDefenseTechnology = {55555, 5555, 5555, 55555};
					arrayCostDefenseTechnology.get(0).setText(String.valueOf(costDefenseTechnology[0]));
					arrayCostDefenseTechnology.get(1).setText(String.valueOf(costDefenseTechnology[1]));
					arrayCostDefenseTechnology.get(2).setText(String.valueOf(costDefenseTechnology[2]));
					arrayCostDefenseTechnology.get(3).setText(String.valueOf(costDefenseTechnology[3]));
					
				} catch (ResourceException e1) {
					attentionLabelBuilding.setText(e1.getMessage());
				}
			}
        	
        });

        // ERROR
        // Attention message
        
        JPanel panelError = new JPanel();
        attentionLabelBuilding = new JLabel("");
        attentionLabelBuilding.setForeground(Color.RED);
        panelError.add(attentionLabelBuilding);

        panelPrincipalEdificios.add(panelPrincipalSuperior, BorderLayout.CENTER);
        panelPrincipalEdificios.add(panelError, BorderLayout.SOUTH);
        
		// PANEL INFERIOR
        
        initBarraInferiorEdificios(main);
		
		panelInternoDos.add(panelRecursosEdificios, BorderLayout.NORTH);
		panelInternoDos.add(panelPrincipalEdificios, BorderLayout.CENTER);
		panelInternoDos.add(panelInferior, BorderLayout.SOUTH);
		tabbedPane.addTab("Buildings and Technology", panelInternoDos);
		
	}
	
	
	// PanelPrincipalUnidades tiene (declarado internamente)
	// - PanelPrincipalSuperior
	// - PanelErrores
	
	JLabel attentionLabelUnits;
	
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
		        "Swordsman", "Spearman", "Crossbow", "Cannon", "Arrow Tower",
		        "Catapult", "Rocket Launcher Tower", "Magician", "Priest"
		};
		String[] unitHeaders = {"ARMOR", "DAMAGE", "", "", "FOOD", "WOOD", "IRON", "MANA"};
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

		for (int i = 0; i < unitHeaders.length; i++) {
		    gbc.gridx = i + 2;
		    JLabel headerLabel = new JLabel(unitHeaders[i]);
		    panelPrincipalSuperior.add(headerLabel, gbc);
		}
		
		// NOMBRES
		for (int i = 0; i < units.length; i++) {
			 gbc.gridy = i + 1;
			 gbc.gridx = 0;
			 panelPrincipalSuperior.add(new JLabel(units[i]), gbc);
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
		
		ArrayList<JLabel> totalUnitsArrayLabel = new ArrayList<JLabel>();
		
		for (int i = 0; i < totalUnitsArray.length; i++) {
			gbc.gridy = i + 1;
		    gbc.gridx = 1;
		    JLabel totalUnitsLabel = new JLabel(String.valueOf(totalUnitsArray[i]));
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
		
		ArrayList<JLabel> armorUnitsArrayLabel = new ArrayList<JLabel>();
		
		for (int i = 0; i < units.length; i++) {
			gbc.gridy = i + 1;
		    gbc.gridx = 2;
		    JLabel armorUnitsLabel = new JLabel(String.valueOf(armorUnitsArray[i]));
		    armorUnitsArrayLabel.add(armorUnitsLabel);
		    panelPrincipalSuperior.add(armorUnitsLabel, gbc);
		}
		
		// BASE_DAMAGE_SWORDSMAN +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_SWORDSMAN_BY_TECHNOLOGY/100 * BASE_DAMAGE_SWORDSMAN);
		
		int[] damageUnitsArray = {
				BASE_DAMAGE_SWORDSMAN +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ATTACK_SWORDSMAN_BY_TECHNOLOGY/100 * ARMOR_SWORDSMAN),
				BASE_DAMAGE_SPEARMAN +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ATTACK_SPEARMAN_BY_TECHNOLOGY/100 * ARMOR_SPEARMAN),
				BASE_DAMAGE_CROSSBOW +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ATTACK_CROSSBOW_BY_TECHNOLOGY/100 * ARMOR_CROSSBOW),
				BASE_DAMAGE_CANNON +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ATTACK_CANNON_BY_TECHNOLOGY/100 * ARMOR_CANNON),
				BASE_DAMAGE_ARROWTOWER +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ATTACK_ARROWTOWER_BY_TECHNOLOGY/100 * ARMOR_ARROWTOWER),
				BASE_DAMAGE_CATAPULT +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ATTACK_CATAPULT_BY_TECHNOLOGY/100 * ARMOR_CATAPULT),
				BASE_DAMAGE_ROCKETLAUNCHERTOWER +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ATTACK_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY/100 * ARMOR_ROCKETLAUNCHERTOWER),
				BASE_DAMAGE_MAGICIAN +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ATTACK_MAGICIAN_BY_TECHNOLOGY/100 * BASE_DAMAGE_MAGICIAN),
				0,
		};
		
		ArrayList<JLabel> damageUnitsArrayLabel = new ArrayList<JLabel>();
		
		for (int i = 0; i < units.length; i++) {
			gbc.gridy = i + 1;
		    gbc.gridx = 3;
		    JLabel damageUnitsLabel = new JLabel(String.valueOf(damageUnitsArray[i]));
		    damageUnitsArrayLabel.add(damageUnitsLabel);
		    panelPrincipalSuperior.add(damageUnitsLabel, gbc);
		}
		
		// Add unit rows
		for (int i = 0; i < units.length; i++) {
			
			gbc.gridy = i + 1;
		    gbc.gridx = 4;
		    JTextField quantityField = new JTextField("", 4);
		    quantityField.setHorizontalAlignment(JTextField.CENTER);
		    panelPrincipalSuperior.add(quantityField, gbc);

		    gbc.gridx = 5;
		    JButton createButton = new JButton("Create");
		    panelPrincipalSuperior.add(createButton, gbc);
		    
		    /*
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
			*/
		    
		    for (int j = 0; j < resources.length; j++) {
		        gbc.gridx = 6 + j;
		        JLabel resourceLabel = new JLabel(String.valueOf(resources[j]));
		        panelPrincipalSuperior.add(resourceLabel, gbc);
		    }
		}

        // ERROR
        // Attention message
        
        JPanel panelError = new JPanel();
        attentionLabelUnits = new JLabel("ATTENTION: You don't have enough resources to create the new building!");
        attentionLabelUnits.setForeground(Color.RED);
        panelError.add(attentionLabelUnits);

        panelPrincipalUnidades.add(panelPrincipalSuperior, BorderLayout.CENTER);
        panelPrincipalUnidades.add(panelError, BorderLayout.SOUTH);
        
		// PANEL INFERIOR
        
		initBarraInferiorUnidades(main);
		
		panelInternoTres.add(panelRecursosUnits, BorderLayout.NORTH);
		panelInternoTres.add(panelPrincipalUnidades, BorderLayout.CENTER);
		panelInternoTres.add(panelInferior, BorderLayout.SOUTH);
		tabbedPane.addTab("Units", panelInternoTres);
	}
	
	public void initBattlePanel(Main main) {
		
		panelInternoCuatro =  new JPanel();
		panelInternoCuatro.setBackground(Color.BLACK);
		panelInternoCuatro.setLayout(new BorderLayout());
		
		// INTEGRACION DE PANEL SUPERIOR CENTRAL
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.ORANGE);
		
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
	
	public void updateResourceLabels(Main main) {
		foodEdificios.setText(String.valueOf(main.getCurrentCivilization().getFood()));
		foodUnits.setText(String.valueOf(main.getCurrentCivilization().getFood()));
		woodEdificios.setText(String.valueOf(main.getCurrentCivilization().getWood()));
		woodUnits.setText(String.valueOf(main.getCurrentCivilization().getWood()));
		ironEdificios.setText(String.valueOf(main.getCurrentCivilization().getIron()));
		ironUnits.setText(String.valueOf(main.getCurrentCivilization().getIron()));
		manaEdificios.setText(String.valueOf(main.getCurrentCivilization().getMana()));
		manaUnits.setText(String.valueOf(main.getCurrentCivilization().getMana()));
	}
	
}


// EVENTOS DEL PANEL INFERIOR ESTANDARIZADOS

class EventoViewthreath implements ActionListener {
	Main main;
	
	EventoViewthreath(Main main) {
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		main.viewthreat(main.getEnemyUnits());
	}
	
}

class EventoPause implements ActionListener {
	Main main;
	
	EventoPause(Main main){
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Pause button in class");
	}
	
}

class EventoSave implements ActionListener {
	Main main;
	
	EventoSave(Main main){
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Save button in class");
	}
	
}

class EventoExit implements ActionListener {
	Main main;
	
	EventoExit(Main main){
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Exit button in class");
	}
	
}



