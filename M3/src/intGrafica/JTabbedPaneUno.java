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
import pkg_Principal.Main;



public class JTabbedPaneUno extends JFrame implements Variables {
	
	private JTabbedPane tabbedPane;
	private JPanel panelInternoUno, panelInternoDos, panelInternoTres, panelInternoCuatro;
	//////////////////////////////////////////////////////////////////////////////////////////
	private JPanel panel1, panel2, panel3, panel4, panelPrincipal,panel11,panel22,panel33,panelNorte,panel1Central,panelSud;
    private JPanel panelEti1,panelEti2,panelEti4,panelEti5,panelEti6,panelEti7,panelEti8,panelEti9,panelEti10,panelEti3,panelTotalEti;
    private JLabel etiqueta1, civili, mtower, church,mtower2,church2,farm,farm2,smithy,smithy2,carprntry,carpentry2;
    private JLabel tec,alevel,alevel2,dlevel,dlevel2,battle,battle2;
    private BufferedImage imagenMapa, escoreWood, escoreIron, escoreMana;
    private JTabbedPane  panelJPMenu;
    //private Civilization civilization;

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
	private ImageIcon iconFood, iconWood, iconIron, iconMana;
	
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

		exit.addActionListener(new EventoExit(main, this));
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

		exit.addActionListener(new EventoExit(main, this));
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

		exit.addActionListener(new EventoExit(main, this));
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

		exit.addActionListener(new EventoExit(main, this));
	}
	
	// INICIALIZACION DE PANELES PRINCIPALES
	
	// PANELES PRINCIPALES
	
	public void initMainMenu(Main main) {
		panelInternoUno = new JPanel();
		panelInternoUno.setBackground(Color.BLUE);
		panelInternoUno.setLayout(new BorderLayout());
		//////////////////////////////////////////////////////////////////////////////////////////
		
		
//		JPanel[] panels = new JPanel[10];
//   	 for (int i = 0; i < 10; i++) {
//            panels[i] = new JPanel();
//            panels[i].setName("panelEti" + (i + 1)); // Asignar nombre dinámico al panel
//            panels[i].setLayout(new FlowLayout()); // Cambiar el layout a FlowLayout
//            // Opcional: Puedes configurar otras propiedades del panel aquí si es necesario
//        }
   	 
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
   	 
   	 
   	panelTotalEti = new JPanel();
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
       int cantidadChurch =main.getCurrentCivilization().getChurch(); 
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
       
       battle = new JLabel("Battle Currents: ");
       int cantidadbattle= main.getCurrentCivilization().getBattles(); 
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
       int margenEntrePaneles = 50;
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
      
       ImageIcon imagenMapa;
       imagenMapa = createScaledImageIcon("./imagenes/mapa.jpg", 1000, 950);
       etiqueta1 = new JLabel(imagenMapa);
       
      
       //panel1.add(etiqueta1);
       panelPrincipal.setLayout(new BorderLayout());
       

       
       //menu pestañas principal
       // Establecer UIManager para cambiar colores de pestañas
       UIManager.put("TabbedPane.selected", Color.WHITE);
       UIManager.put("TabbedPane.background", Color.BLACK);
       UIManager.put("TabbedPane.foreground", Color.WHITE);
       UIManager.put("TabbedPane.unselectedBackground", Color.BLACK);
       UIManager.put("TabbedPane.selectedForeground", Color.BLACK);
      
      

       // Personalizar la fuente y tamaño de los títulos de las pestañas
       Font tabFont = new Font("Arial", Font.BOLD, 20);
       panelJPMenu.setFont(tabFont);

       // Inicialmente actualizar los colores
       updateTabColors(panelJPMenu);
       // Listener para actualizar colores al seleccionar una pestaña
       panelJPMenu.addChangeListener(e -> {
           updateTabColors(panelJPMenu);
      });


       // Inicialmente actualizar los colores
       //updateTabColors(panelCentral);
       //panelCentral.setBorder(null); // Eliminar bordes del JScrollPane
       
       panel11.setBackground(Color.DARK_GRAY);
       panel22.setBackground(Color.DARK_GRAY);
       panel33.setBackground(Color.DARK_GRAY);
       
       // Configurar las pestañas
       panelJPMenu.addTab(" Civilization ", panel11);
       panelJPMenu.addTab(" Units ", panel22);
       panelJPMenu.addTab(" Civilization ", panel33);
     

       // Personalizar la fuente y tamaño de los títulos de las pestañas
       Font tabFont2 = new Font("Arial", Font.BOLD, 20);
       panelJPMenu.setFont(tabFont2);
       // Inicialmente actualizar los colores
       
       // Listener para actualizar colores al seleccionar una pestaña
       

       // Establecer tamaño preferido para panelJPMenu
       panelJPMenu.setPreferredSize(new Dimension(915, 1000));
       
      
       
       
     
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


       //this.setSize(1200, 900);
       this.setTitle("");
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
		
	

	private void updateTabColors(JTabbedPane tabbedPane) {
	    for (int i = 0; i < tabbedPane.getTabCount(); i++) {
	        if (tabbedPane.getSelectedIndex() == i) {
	            tabbedPane.setForegroundAt(i, Color.BLACK);
	            tabbedPane.setBackgroundAt(i, Color.WHITE);
	        } else {
	            tabbedPane.setForegroundAt(i, Color.WHITE);
	            tabbedPane.setBackgroundAt(i, Color.BLACK);
	        }
	    }
	}

	
	// PanelPrincipalEdificios tiene(declarado internamente)
	// - PanelPrincipalSuperior
	// - PanelErrores
	
	JLabel attentionLabelBuilding;
	ArrayList<JLabel> arrayCostDefenseTechnology;
    ArrayList<JLabel> arrayCostAttackTechnology;
    
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
					updateTechnologyLabels(main);
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
            arrayCostDefenseTechnology.add(technologyCost);
            panelPrincipalSuperior.add(technologyCost, gbc);
        }
        
        defenseButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
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
	ArrayList<JLabel> damageUnitsArrayLabel;
	ArrayList<JLabel> armorUnitsArrayLabel;
	ArrayList<JLabel> totalUnitsArrayLabel;
	
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
		String[] unitHeaders = {"ARMOR", "DAMAGE"};
		

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
		
		totalUnitsArrayLabel = new ArrayList<JLabel>();
		
		for (int i = 0; i < totalUnitsArray.length; i++) {
			gbc.gridy = i + 1;
		    gbc.gridx = 1;
		    JLabel totalUnitsLabel = new JLabel(String.valueOf(totalUnitsArray[i]));
		    totalUnitsArrayLabel.add(totalUnitsLabel);
		    panelPrincipalSuperior.add(totalUnitsLabel, gbc);
		}
		
		// ARMOR_SWORDSMAN +(main.getCurrentCivilization().getTechnologyDefense() * PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY/100 * ARMOR_SWORDSMAN);
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
		
		armorUnitsArrayLabel = new ArrayList<JLabel>();
		
		for (int i = 0; i < units.length; i++) {
			gbc.gridy = i + 1;
		    gbc.gridx = 2;
		    JLabel armorUnitsLabel = new JLabel(String.valueOf(armorUnitsArray[i]));
		    armorUnitsArrayLabel.add(armorUnitsLabel);
		    panelPrincipalSuperior.add(armorUnitsLabel, gbc);
		}
		
		// BASE_DAMAGE_SWORDSMAN +(main.getCurrentCivilization().getTechnologyAttack() * PLUS_ATTACK_SWORDSMAN_BY_TECHNOLOGY/100 * BASE_DAMAGE_SWORDSMAN);
		
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
		
		damageUnitsArrayLabel = new ArrayList<JLabel>();
		
		for (int i = 0; i < units.length; i++) {
			gbc.gridy = i + 1;
		    gbc.gridx = 3;
		    JLabel damageUnitsLabel = new JLabel(String.valueOf(damageUnitsArray[i]));
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
		    JButton createButton = new JButton("Add");
		    createButtonUnitsArray.add(createButton);
		    panelPrincipalSuperior.add(createButton, gbc);
		}
		
        // ERROR
        // Attention message
		
        JPanel panelError = new JPanel();
        attentionLabelUnits = new JLabel("");
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
		
		// EVENTOS DE LOS BOTONES ADD DE LA CREACION DE UNIDADES
		
		createButtonUnitsArray.get(0).addActionListener(new ActionListener() {
		
					
					public void actionPerformed(ActionEvent e) {
						
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
	                   
	                    System.out.println("");
	                    System.out.println("HAY PRIEST = " + (main.getCurrentCivilization().getArmy())[8].size());
	                    System.out.println("HAY PRIEST = " + (main.getCurrentCivilization().getArmy())[8].size());
	                    System.out.println("HAY PRIEST = " + (main.getCurrentCivilization().getArmy())[8].size());
	                    System.out.println("");
	                    // Se santifican unidades
	                    if ((main.getCurrentCivilization().getArmy())[8].size() > 0) {
	                    	System.out.println("UNIDADES SANTIFICADA / HAY PRIEST = " + (main.getCurrentCivilization().getArmy())[8].size());
	                    	for (ArrayList<MilitaryUnit> unidades : main.getCurrentCivilization().getArmy()) {
	            				System.out.println(unidades.size());
	            				for (MilitaryUnit unidad : unidades) {
	            					
	            					if (unidad instanceof AttackUnit) {
	            						 System.out.println("UNIDAD DE ATAQUE SANTIFICADA");
	            						((AttackUnit) unidad).setSanctified(true);
	            		
	            					} else if (unidad instanceof DefenseUnit) {
	            						 System.out.println("UNIDAD DE DEFENSA SANTIFICADA");
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
		panelI.add(Box.createRigidArea(new Dimension(0,20)), gbc);
		
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
	
	
	// CARGADOR DE ICONOS
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
	
	// UPDATES VISUALES
	
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
		
		
			// GENERACIÓN ACTUAL
			
		
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
		
		// LABELS PAU MAIN MENU
		
		mtower2.setText(String.valueOf((main.getCurrentCivilization().getMagicTower())));
		church2.setText(String.valueOf((main.getCurrentCivilization().getChurch())));
		farm2.setText(String.valueOf((main.getCurrentCivilization().getFarm())));
		smithy2.setText(String.valueOf((main.getCurrentCivilization().getSmithy())));
		carpentry2.setText(String.valueOf((main.getCurrentCivilization().getCarpentry())));
		
		
		
		
	}
	
	public void updateTechnologyLabels(Main main) {
		
		// LABELS WILLIAM
		
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
		alevel2.setText(String.valueOf((main.getCurrentCivilization().getTechnologyAttack())));
		dlevel2.setText(String.valueOf((main.getCurrentCivilization().getTechnologyDefense())));
			// MAIN MENU
	}
	
	public void updateBattleCounter(Main main) {
		
		// MAIN MENU
		battle2.setText(String.valueOf((main.getCurrentCivilization().getBattles())));
		
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
		main.saveGame(main.getCurrentCivilizationID(), main.getCurrentCivilization());
	}
	
}

class EventoExit implements ActionListener {
	Main main;
	JFrame frame;
	
	EventoExit(Main main, JFrame frame){
		this.main = main;
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		main.saveGame(main.getCurrentCivilizationID(), main.getCurrentCivilization());
		frame.dispose();
		new PantallaPrincipal();
	}
	
}



