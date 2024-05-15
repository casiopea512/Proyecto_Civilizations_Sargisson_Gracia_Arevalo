package intGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.MilitaryUnit;

public class EnemiesIncoming extends JFrame {
	
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
