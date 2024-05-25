package intGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import intGrafica.BattleOcurred.BackgroundPanel;
import interfaces.MilitaryUnit;

public class EnemiesIncoming extends JFrame{
	
	private BackgroundPanel panelPrincipal;
	
    private JLabel labelTitle, labelWin, labelCollect;
    
    private JButton exit;
    private BufferedImage imagen;
    

    
    public EnemiesIncoming(ArrayList<MilitaryUnit>[] enemyUnit) {

        this.setTitle("ENEMIES INCOMING!");
        this.setSize(500, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.initComponents(enemyUnit);
        
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void initComponents(ArrayList<MilitaryUnit>[] enemyUnit) {
        // cargar imagen de fondo
        try {
            imagen = ImageIO.read(new File("./imagenes/enemies_incoming.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        panelPrincipal = new BackgroundPanel(imagen);
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        
        labelTitle = new JLabel("ENEMIES INCOMING!");
        
        JLabel labelAttention = new JLabel("Careful! There are enemies nearby your civilization!");
		//JLabel labelMessage = new JLabel("The following units have been sighted: ");
		JLabel labelSwordsman = new JLabel("Swordsman: " + enemyUnit[0].size());
		JLabel labelSpearman = new JLabel("Spearman: " + enemyUnit[1].size());
		JLabel labelCrossbow = new JLabel("Crossbow: " + enemyUnit[2].size());
		JLabel labelCannon = new JLabel("Cannon: " + enemyUnit[3].size());
        
        
        labelTitle.setFont(new Font("Arial", Font.BOLD, 20));
        labelAttention.setFont(new Font("Arial", Font.BOLD, 15));
        labelSwordsman.setFont(new Font("Arial", Font.BOLD, 15));
        labelSpearman.setFont(new Font("Arial", Font.BOLD, 15));
        labelCrossbow.setFont(new Font("Arial", Font.BOLD, 15));
        labelCannon.setFont(new Font("Arial", Font.BOLD, 15));
        
        exit = new JButton("Exit");
        
        panelPrincipal.add(Box.createRigidArea(new Dimension(100, 60)));
        panelPrincipal.add(labelTitle);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(labelAttention);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(labelSwordsman);
        panelPrincipal.add(labelSpearman);
        panelPrincipal.add(labelCrossbow);
        panelPrincipal.add(labelCannon);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(exit);
        
        this.add(panelPrincipal, BorderLayout.CENTER);
        
        exit.addActionListener(e -> dispose());
    }
    
    // Clase interna para el panel con fondo de imagen
    class BackgroundPanel extends JPanel {
    	private BufferedImage image;
        
        public BackgroundPanel(BufferedImage image) {
            this.image = image;
        }
        
       
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
