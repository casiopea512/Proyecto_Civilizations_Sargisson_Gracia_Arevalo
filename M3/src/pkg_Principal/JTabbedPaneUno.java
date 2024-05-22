package pkg_Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class JTabbedPaneUno extends JFrame {
	
	private JTabbedPane tabbedPane;
	private JPanel panelInternoUno, panelInternoDos, panelInternoTres, panelInternoCuatro;

	JTabbedPaneUno(){
		
		setSize(900, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		initComponents();
		
		setVisible(true); 
	}
	
	public void initComponents(){
		
		tabbedPane = new JTabbedPane();
		initMainMenu();
		initBuildingsAndTechnology();
		initUnits();
		initBattle();
		add(tabbedPane);
	}
	
	public void initMainMenu() {
		panelInternoUno = new JPanel();
		panelInternoUno.setBackground(Color.BLUE);
		tabbedPane.addTab("Main menu", panelInternoUno);
	}
	
	JPanel panelRecursos, panelPrincipal, panelInferior;
	JLabel food, wood, iron, mana;
	JLabel battleCountdown, seconds;
	JButton viewthreat, pause, save, exit;
	
	public void initBuildingsAndTechnology() {
		panelInternoDos = new JPanel();
		panelInternoDos.setBackground(Color.YELLOW);
		panelInternoDos.setLayout(new BorderLayout());
		
		// PANEL DE RECURSOS
		panelRecursos = new JPanel();
		panelRecursos.setBackground(Color.BLACK);
		
		food = new JLabel("15000");
		food.setForeground(Color.WHITE);
		food.setFont(new Font("Arial", Font.BOLD, 20));
		wood = new JLabel("25000");
		wood.setForeground(Color.WHITE);
		wood.setFont(new Font("Arial", Font.BOLD, 20));
		iron = new JLabel("750");
		iron.setForeground(Color.WHITE);
		iron.setFont(new Font("Arial", Font.BOLD, 20));
		mana = new JLabel("1500");
		mana.setForeground(Color.WHITE);
		mana.setFont(new Font("Arial", Font.BOLD, 20));
		
		panelRecursos.add(food);
		panelRecursos.add(wood);
		panelRecursos.add(iron);
		panelRecursos.add(mana);
		
		// PANEL INFERIOR
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.BLACK);
		
		battleCountdown = new JLabel("BATTLE COUNTDOWN");
		battleCountdown.setForeground(Color.WHITE);
		battleCountdown.setFont(new Font("Arial", Font.BOLD, 30));
		seconds = new JLabel("120 seconds");
		seconds.setForeground(Color.WHITE);
		seconds.setFont(new Font("Arial", Font.BOLD, 20));
		
		viewthreat = new JButton("VIEW THREAT");
		pause = new JButton("PAUSE");
		save = new JButton("SAVE");
		exit = new JButton("EXIT");
		
		panelInferior.add(battleCountdown);
		panelInferior.add(seconds);
		panelInferior.add(viewthreat);
		panelInferior.add(pause);
		panelInferior.add(save);
		panelInferior.add(exit);
		
		panelInternoDos.add(panelRecursos, BorderLayout.NORTH);
		panelInternoDos.add(panelInferior, BorderLayout.SOUTH);
		tabbedPane.addTab("Buildings and Technology", panelInternoDos);
	}
	
	public void initUnits() {
		panelInternoTres =  new JPanel();
		panelInternoTres.setBackground(Color.GREEN);
		tabbedPane.addTab("Units", panelInternoTres);
	}
	
	public void initBattle() {
		panelInternoCuatro =  new JPanel();
		panelInternoCuatro.setBackground(Color.BLACK);
		tabbedPane.addTab("Battle", panelInternoCuatro);
	}
	
}