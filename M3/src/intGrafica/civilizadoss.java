package intGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



public class civilizadoss{
	public static void main(String[] args) {
		new PantallaPrincipal();
	}
	
}


class PantallaPrincipal extends JFrame {
	
	private JPanel panel,panelImagenes,panelTitulo,panelBotones;
	private JButton botonPlay,botonSalir,botonPG;
	private ArrayList<BufferedImage> imagenes;
	private BufferedImage imageIcon;
	
	   public PantallaPrincipal() {
	    
			panel = new JPanel();
			panelImagenes = new JPanel();
			panelTitulo = new JPanel();
			panelBotones = new JPanel();
			
			botonPlay = new JButton("Play");
			botonPlay.setFont(new Font("Arial", Font.BOLD, 18)); // Asegúrate de importar java.awt.Font
			botonPlay.setBackground(Color.BLUE);
			botonPlay.setForeground(Color.WHITE);
			botonSalir = new JButton("Exit");
			botonSalir.setFont(new Font("Arial", Font.BOLD, 18)); // Asegúrate de importar java.awt.Font
			botonSalir.setBackground(Color.BLUE);
			botonSalir.setForeground(Color.WHITE);
			botonPG = new JButton("Saved Games");
			botonSalir.setFont(new Font("Arial", Font.BOLD, 18)); // Asegúrate de importar java.awt.Font
			botonSalir.setBackground(Color.BLUE);
			botonSalir.setForeground(Color.WHITE);
			
			panelBotones.add(botonPlay);
			panelBotones.add(botonPG);
			panelBotones.add(botonSalir);

	     
	
			panel.setLayout(new BorderLayout());
			
			 
			
			
			botonSalir.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					dispose();//salir
					
				}
			});

			imagenes = new ArrayList<BufferedImage>();
			for (int i=1;i<=6;i++) {
				try {
					imagenes.add(ImageIO.read(new File("./imagenesProyecto/Images"+i+".JPG")));
				} catch (IOException e) {
					System.out.println("error");
				}
			}
			
			try {
				imageIcon = ImageIO.read(new File("./imagenesProyecto/Images0.JPG"));//le dices donde esta la imagen
			} catch (IOException e) {
				System.out.println("El archivo no se encuentra");
				
			}
			
			 // Mostrar una imagen aleatoria al iniciar el programa
	        int indiceAleatorio = (int) (Math.random() * imagenes.size());
	        BufferedImage imagenAleatoria = imagenes.get(indiceAleatorio);
	        JLabel labelImagen = new JLabel(new ImageIcon(imagenAleatoria));
	        panelImagenes.add(labelImagen);
	        
	        panel.add(panelBotones,BorderLayout.SOUTH);
			panel.add(panelImagenes,BorderLayout.CENTER);
			
			
			
			
			this.add(panel,BorderLayout.CENTER);//se mete el panel con todos los objetos en el centro
			
			 //propiedades de la ventana
	        setSize(500, 500);
	        setTitle("Pantalla de Inicio");
	        setIconImage(imageIcon);
	        setResizable(false);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	        
	      
	    
	  
			
			
			
			

					
				
		
	   
	  

	            
	        }
}
