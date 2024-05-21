package intGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BattleOcurred extends JFrame{
	
	private BackgroundPanel panelPrincipal;
    private JLabel labelTitle, labelWin, labelCollect;
    private JButton exit;
    private BufferedImage imagen;
    
    private boolean civilizationWin;
    private int[] wasteWoodIron;
    
    public BattleOcurred(boolean civilizationWin, int[] wasteWoodIron) {
        this.civilizationWin = civilizationWin;
        this.wasteWoodIron = wasteWoodIron;
        
        this.setTitle("BATTLE JUST OCURRED");
        this.setSize(500, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.initComponents();
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void initComponents() {
        // cargar imagen de fondo
        try {
            imagen = ImageIO.read(new File("./imagenes/fondoPopUpBatalla.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        panelPrincipal = new BackgroundPanel(imagen);
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        
        labelTitle = new JLabel("A battle just ocurred");
        labelWin = new JLabel();
        labelCollect = new JLabel();
        
        if (civilizationWin) {
            labelWin.setText("Civilization won the battle");
            labelCollect.setText("We collect " + wasteWoodIron[0] + " wood and " + wasteWoodIron[1] + " iron");
        } else {
            labelWin.setText("Enemy won the battle");
            labelCollect.setText("");
        }
        
        labelTitle.setFont(new Font("Arial", Font.BOLD, 20));
        labelWin.setFont(new Font("Arial", Font.BOLD, 15));
        labelCollect.setFont(new Font("Arial", Font.BOLD, 15));
        
        exit = new JButton("Exit");
        
        panelPrincipal.add(Box.createRigidArea(new Dimension(100, 70)));
        panelPrincipal.add(labelTitle);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(labelWin);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(labelCollect);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 50)));
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
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
