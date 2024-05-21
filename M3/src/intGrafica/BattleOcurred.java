package intGrafica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BattleOcurred extends JFrame{
	
	private JPanel panelPrincipal;
	private JLabel labelTitle, labelWin, labelCollect;
	private JButton exit;
	
	private boolean civilizationWin;
	private int[] wasteWoodIron;
	
	
	public BattleOcurred(boolean civilizationWin, int[] wasteWoodIron) {
		this.civilizationWin = civilizationWin;
		this.wasteWoodIron = wasteWoodIron;
		
		this.setTitle("BATTLE JUST OCURRED");
		this.setSize(500,300);
		this.setResizable(false);
		
		this.initComponents();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public void initComponents() {
		panelPrincipal = new  JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		labelTitle = new JLabel("A battle just ocurred");
		labelWin = new JLabel();
		labelCollect = new JLabel();
		
		if (civilizationWin) {
			labelWin.setText("Civilization won the battle");
			labelCollect.setText("We collect "+wasteWoodIron[0]+" wood and "+wasteWoodIron[1]+" iron");
		}
		else {
			labelWin.setText("Enemy won the battle");
			labelCollect.setText("");
		}
		
		exit = new JButton("Exit");
		
		panelPrincipal.add(labelTitle);
		panelPrincipal.add(labelWin);
		panelPrincipal.add(labelCollect);
		panelPrincipal.add(exit);
		
		this.add(panelPrincipal,BorderLayout.CENTER);
		
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
}
