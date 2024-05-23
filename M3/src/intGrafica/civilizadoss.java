package intGrafica;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import pkg_Principal.Main;

public class civilizadoss {
    public static void main(String[] args) {
        new PantallaPrincipal();        
    }
}


class PantallaPrincipal extends JFrame {
	Main principal = new Main();
    private JPanel panelImagenes, panelBotonesContainer,panelTitle,panelTitleBar;
    //private JButton botonPlay, botonSalir, botonPG;
    private ArrayList<BufferedImage> imagenes;
    private BufferedImage imageIcon,iconoPersonalizado;
    private JLabel titulo;
    //private ArrayList<Usuario> partidas;
    //private ArrayList<Usuario> partidas= new ArrayList<Usuario>();
    private String userName;//variable para guardar 
	private String civilizationName;//variable para guardar
	
    
    public PantallaPrincipal() {
        panelImagenes = new JPanel();
        panelBotonesContainer = new JPanel();
        panelTitle = new JPanel();
        panelImagenes = new JPanel();
        panelBotonesContainer = new JPanel();
        panelTitle = new JPanel();
        
        
        titulo = new GradientLabel("CIVILIZATION", Color.BLUE, Color.DARK_GRAY, 200);
        //titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font("Algerian", Font.BOLD, 200));
        
        //titulo.setBorder(new LineBorder(Color.RED, 1));
        RoundedButton botonPlay = new RoundedButton(" NEW GAME ");
        RoundedButton botonSalir = new RoundedButton(" EXIT ");
        RoundedButton botonPG = new RoundedButton(" SAVED GAMES ");
        
        //botonPlay = new JButton(" PLAY ");
        botonPlay.setFont(new Font("Arial", Font.BOLD, 25));
        botonPlay.setBackground(Color.BLACK);
        botonPlay.setForeground(Color.WHITE);
        
        //botonSalir = new JButton(" EXIT ");
        botonSalir.setFont(new Font("Arial", Font.BOLD, 25));
        botonSalir.setBackground(Color.BLACK);
        botonSalir.setForeground(Color.WHITE);
        //botonPG = new JButton(" SAVED GAMES ");
        botonPG.setFont(new Font("Arial", Font.BOLD, 25));
        botonPG.setBackground(Color.BLACK);
        botonPG.setForeground(Color.WHITE);
        
       
        
        try {
        	iconoPersonalizado = ImageIO.read(new File("./imagenes/icono.jpg"));
        } catch (IOException e) {
            System.out.println("El archivo no se encuentra");
        }
        
        
        botonPG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Connection conn = null;
            	Statement stmt = null;
                int pkIDcivilization = -1;
                String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
                String USER = "Civilization";
                String PASS = "civilization";
                try {
                	
                	// INSERT EN BBDD
        			Class.forName("oracle.jdbc.driver.OracleDriver");
        			conn = DriverManager.getConnection(DB_URL, USER, PASS);
        			System.out.println("CONEXIÓN ESTABLECIDA");
        			//select count(civilization_id) from civilization_stats;
        			String select = "select count(civilization_id) from civilization_stats";
        			stmt = conn.createStatement();
        			ResultSet rs = stmt.executeQuery(select);
	    	        rs.next();
            	if(rs.getInt(1)==0) {
            		System.out.println(rs.getInt(1));
            		Object[] options = {"OK"};
                    JOptionPane.showOptionDialog(null,
                            "There are no saved games",
                            "Error",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon(iconoPersonalizado),
                            options,
                            options[0]); // El botón p
            	}else {
            		//new PartidasGuardadas();//boton partidas guardadas
            		System.out.println("hay partidas");
            		dispose();
            	}
                
        		} catch (ClassNotFoundException ee) {
        			ee.printStackTrace();
        		} catch (SQLException ee) {
        			ee.printStackTrace();
        		}
            }
        });
        
        botonPlay.addActionListener(new ActionListener() {//RECUPERAR
			public void actionPerformed(ActionEvent e) {
				new VentanaUsuario();
				dispose();//cierra la ventana principal el apretar play
			}
        });
         //Se agrega el título a la barra de título
       
        panelTitle.add(titulo);
        
        panelTitle.setOpaque(false);
        
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
       
       

        imagenes = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            try {
                imagenes.add(ImageIO.read(new File("./imagenes/Images" + i + ".JPG")));
            } catch (IOException e) {
                System.out.println("error2");
            }
        }

        try {
            imageIcon = ImageIO.read(new File("./imagenes/images.png"));
        } catch (IOException e) {
            System.out.println("El archivo no se encuentra");
        }

        int indiceAleatorio = (int) (Math.random() * imagenes.size());
        BufferedImage imagenAleatoria = imagenes.get(indiceAleatorio);
        ImageIcon foto = new ImageIcon(imagenAleatoria);
       

        
        JPanelConFondo panelImagenes = new JPanelConFondo(foto.getImage());
        
        panelImagenes.setLayout(new BorderLayout());
        
        //panelBotonesContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotonesContainer.setLayout(new FlowLayout(FlowLayout.CENTER,140, 100)); // Espaciado horizontal y vertical entre botones
        panelBotonesContainer.setBackground(Color.BLACK);
        panelBotonesContainer.add(botonPlay);
        panelBotonesContainer.add(botonPG);
        panelBotonesContainer.add(botonSalir);
        panelBotonesContainer.setOpaque(false);

        setLayout(new BorderLayout());
        

       
        setUndecorated(true); //poner cabecera por defecto o no
        getRootPane().setBorder(new LineBorder(Color.BLACK, 10)); // Establece un borde de línea azul con grosor 20 alrededor de la ventana

        
        add(panelImagenes, BorderLayout.CENTER);
        panelImagenes.add(panelTitle, BorderLayout.NORTH);
        panelImagenes.add(panelBotonesContainer, BorderLayout.SOUTH);

        setSize(1400, 900);
        setTitle("Pantalla de Inicio");
        this.setIconImage(imageIcon);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    class JPanelConFondo extends JPanel {
        private Image imagenDeFondo;
        
        

        public JPanelConFondo(Image imagenDeFondo) {
            this.imagenDeFondo = imagenDeFondo;
        }
       
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar la imagen de fondo
            g.drawImage(imagenDeFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
    /////////////////////////////////////////////////////////////////////////////
    
    class PartidasGuardadas extends JFrame {//RECUPERAR
        private JLabel etiPG;
        private BufferedImage imagenFondo2, imageIcon3;
        private JPanel penel, panelPlay, panelEti, panelCentral, panelBack;
        private JScrollPane tablaPartidas;
        private JButton batonBack;

        public PartidasGuardadas() {
            etiPG = new JLabel("PARTIDAS GUARDADAS");
            etiPG.setFont(new Font("Times New Roman", Font.BOLD, 35));
            etiPG.setForeground(Color.BLACK);

            // Botón redondeado al sur del frame
            RoundedButton batonBack = new RoundedButton("  Back  ");
            batonBack.setFont(new Font("Times New Roman", Font.BOLD, 25));
            batonBack.setBackground(Color.BLACK);
            batonBack.setForeground(Color.WHITE);

            batonBack.addActionListener(new ActionListener() {
                // Botón back, vuelve a pantalla principal
                public void actionPerformed(ActionEvent e) {
                    new PantallaPrincipal(); // Llama pantalla principal
                    dispose(); // Cierra pantalla actual
                }
            });

            penel = new JPanel();
            panelPlay = new JPanel();
            panelEti = new JPanel();
            panelCentral = new JPanel();
            panelBack = new JPanel();
            // panelCentral.setOpaque(false);

            panelEti.add(etiPG);
            panelEti.setOpaque(false);

            panelBack.add(batonBack);
            panelBack.setOpaque(false);

            try {
                imageIcon3 = ImageIO.read(new File("./src/imagenes/play.png"));
            } catch (IOException e) {
                System.out.println("El archivo no se encuentra");
            }

            ImageIcon play = new ImageIcon(imageIcon3);

            panelCentral.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 10, 10, 10); // Margen entre componentes
            //////////////////////////////////////////////////////////////////////////////////
            //ENCONTRAR MANERA DE INSTANCIAR LOS BOTONES CON LOS DATOS DE LA BBDD

            for (int i = 0; i < partidas.size(); i++) {
                JPanel panel2 = new JPanel(new BorderLayout());
                panel2.setOpaque(false);

                Usuario usuario = partidas.get(i);
                String jugadores = usuario.getName() + "  -  " + usuario.getCivi() + ": ";

                JLabel nombreUsuario = new JLabel(jugadores);
                nombreUsuario.setFont(new Font("Times New Roman", Font.BOLD, 35));
                nombreUsuario.setForeground(Color.BLACK);
                nombreUsuario.setPreferredSize(new Dimension(400, 50)); // Tamaño fijo para las etiquetas
                panel2.add(nombreUsuario, BorderLayout.CENTER); // Alinear JLabel al centro

                RoundedButton boton = new RoundedButton(" Erease ");
                boton.setName("BotonBorrar" + i);
                boton.setFont(new Font("Times New Roman", Font.BOLD, 25));
                boton.setForeground(Color.BLACK);
                boton.setBackground(Color.RED);
                boton.addActionListener(new ActionListener() {//crea el evento de los botones
	                public void actionPerformed(ActionEvent e) {
	                    //principal.deleteCivilization(civilizationID);
	                	
	                }
	            });
                
                //boton.setBackground(new Color(255, 255, 255, 0)); // Fondo transparente
                panel2.add(boton, BorderLayout.EAST);

                JButton boton2 = new JButton(play);
                boton2.setName("BotonPlay" + i);
                boton2.setFont(new Font("Times New Roman", Font.BOLD, 0));
                boton2.setBackground(Color.WHITE);
                boton2.setForeground(Color.WHITE);
                boton2.setOpaque(false);
                boton2.setBorderPainted(false); // Ocultar los bordes del botón
                boton2.addActionListener(new ActionListener() {//crea el evento de los botones
	                public void actionPerformed(ActionEvent e) {
	                   System.out.println(nombreUsuario.getText()); 
	                   //PARA CARGAR PARTIDA
	                	
	                }
	            });
                panel2.add(boton2, BorderLayout.WEST);
               

                gbc.gridy = i; // Incrementar la fila para cada nueva entrada
    		panelCentral.add(panel2, gbc);
            }

            panelCentral.setOpaque(false);
           

            try {
                imagenFondo2 = ImageIO.read(new File("./src/imagenes/pergamino.jpg"));
            } catch (IOException e) {
                System.out.println("El archivo no se encuentra");
            }

           // Crear un ImageIcon a partir de la imagen de fondo
            ImageIcon foto = new ImageIcon(imagenFondo2);
            // Crear el panel de fondo con la imagen
            JPanelConFondo panelImagen2 = new JPanelConFondo(foto.getImage());
            panelImagen2.setLayout(new BorderLayout());

            tablaPartidas = new JScrollPane(panelCentral);
            tablaPartidas.setOpaque(false);
            
            tablaPartidas.getViewport().setOpaque(false);
            tablaPartidas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            panelImagen2.add(panelEti, BorderLayout.NORTH);
            panelImagen2.add(tablaPartidas, BorderLayout.CENTER);
            panelImagen2.add(panelBack, BorderLayout.SOUTH);
            panelImagen2.setOpaque(false);

            // Agregar el panel de imágenes al JFrame
            this.add(panelImagen2);

            // Indicaciones estándar para una ventana de crear usuario
            this.setSize(800, 1000);
            this.setTitle("Partidas Guardadas");
            this.setIconImage(imageIcon);
            this.setResizable(false); // No cambiar tamaño marco
            this.setLocationRelativeTo(null); // Sale en medio
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Se para el programa al cerrar
            this.setVisible(true); // Para verla
        }

   }

    	
	class VentanaUsuario extends JFrame {
		private BufferedImage imagenFondo;
		private JLabel etiqueta1,etiCivi,etiqueta2,etiqueta00;
		private JTextField texto1,texto2;
		private JButton  botonGuardar, botonComenzar, botonSalir;
		private JPanel panel,panelB,panelTexto,panelSalir,panelEti,panelEti0,panelEtiv;

		public VentanaUsuario() {
			
			etiqueta1 = new JLabel("Enter a username:            ");
			
			etiqueta1.setFont(new Font("Arial", Font.ITALIC, 18));
			
			etiCivi = new JLabel("Name of your civilization: ");
			etiCivi.setFont(new Font("Arial", Font.ITALIC, 18));
			etiqueta2 = new JLabel("");//relleno para centrar
			etiqueta00 = new JLabel("");
			
			texto1 = new JTextField(10);
			texto2 = new JTextField(10);

			
			RoundedButton botonComenzar = new RoundedButton("  Start  ");
			botonComenzar.setFont(new Font("Arial", Font.BOLD, 25));
			botonComenzar.setBackground(Color.BLACK);
			botonComenzar.setForeground(Color.WHITE);
			
			RoundedButton botonSalir = new RoundedButton("  Back  ");
			botonSalir.setFont(new Font("Arial", Font.BOLD, 25));
			botonSalir.setBackground(Color.BLACK);
			botonSalir.setForeground(Color.WHITE);
			
			panel = new JPanel();
			panelB = new JPanel();
			panelTexto = new JPanel();
			panelSalir = new JPanel();
			panelEti = new JPanel();
			panelEti0 = new JPanel();//
			panelEtiv = new JPanel();
			
			panelEtiv.add(etiqueta00);//
			
			panelEtiv.setOpaque(false);
			
			panelEti0.add(etiqueta1);//
			panelEti0.add(texto1);
			panelEti0.setOpaque(false);
			
			panelTexto.add(etiCivi);
			panelTexto.add(texto2);
			panelTexto.setOpaque(false);
			panelSalir.add(botonSalir);
			panelSalir.setOpaque(false);
			panelEti.add(etiqueta2);
			panelEti.setOpaque(false);
			
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setOpaque(false);
			//panelB.add(botonGuardar);
			panelB.add(botonComenzar);//en el panel metemos dos botones para que ocupen una sola posicion en una fila
			panelB.setOpaque(false);

			botonComenzar.addActionListener(//creamos aqui mismo el evento
					new botonComenzar());
			
			
			botonSalir.addActionListener(new ActionListener() {//evento creado directamente
				
				public void actionPerformed(ActionEvent e) {
					new PantallaPrincipal();
					  dispose();//cierra el programa al apretar salir
				}
			});
			
		try {
		    imagenFondo = ImageIO.read(new File("./imagenes/libro.jpg"));
		} catch (IOException e) {
		    System.out.println("El archivo no se encuentra");
		}

		// Crear un ImageIcon a partir de la imagen de fondo
		ImageIcon foto = new ImageIcon(imagenFondo);

		// Crear el panel de fondo con la imagen
		JPanelConFondo panelImagenes = new JPanelConFondo(foto.getImage());

		panelImagenes.setLayout(new BorderLayout());
		

			panel.add(panelEtiv);
			panel.add(panelEti0);//
			panel.add(panelTexto);
			panel.add(panelB);
			panel.add(panelEti);//el panel eti es el de la excepcion, lo ponemos en panel para que cuando pintemos la etiqueta de yellow solo se pinte la etiqueta
			panel.add(panelSalir);
			panel.setOpaque(false);
			
			panelImagenes.add(panel,BorderLayout.CENTER);
			
			// Agregar el panel de imágenes al JFrame
			this.add(panelImagenes, BorderLayout.CENTER);

			//se meten las indicaciones estandar para una ventana de crear usuario
			this.setSize(800,600);
			this.setTitle("Crear Usuario");
			this.setIconImage(imageIcon);
			this.setResizable(false);//no cambiar tamaño marco
			this.setLocationRelativeTo(null);//sale en medio
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//se para el programa al cerrar
			this.setVisible(true);//para verla
		}
		
		class MiException extends Exception {//se crea una excepcion personalizada
			public MiException(String message) {
				super(message);
			}
			public MiException() {
				System.out.println("Error");
				etiqueta2.setText("The name and civilization must meet the established parameters");//se cambia el texto de la etiqueta2 que esta en blanco
	        	etiqueta2.setOpaque(true);//se fuerza que se vea la etiqueta
	        	etiqueta2.setBackground(Color.YELLOW);//se cambia el color de la etiqueta y no del panel
	        	//al estar en un panel solo se pinta el texto si no fuera asi se pintaria toda la linea
				
			}
		}
		class MiException2 extends Exception {//se crea una excepcion personalizada(la segunda
			public MiException2(String message) {
				super(message);
			}
			public MiException2() {
				System.out.println("Error");
				etiqueta2.setText("Before starting, create your username and civilization");//se cambia el texto de la etiqueta2 que esta en blanco
	        	etiqueta2.setOpaque(true);//se fuerza que se vea la etiqueta
	        	etiqueta2.setBackground(Color.YELLOW);//se cambia el color de la etiqueta y no del panel
	        	//al estar en un panel solo se pinta el texto si no fuera asi se pintaria toda la linea
				
			}
}
		
		class botonComenzar implements ActionListener {//boton guardar pantalla crear usuario
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("wwwww");
				userName = texto1.getText().toLowerCase();
				civilizationName = texto2.getText().toLowerCase();
				try {//.toLowerCase()indiferencia mayusculas y minusculas
					if (userName.isEmpty()&& civilizationName.isEmpty())  {//verifica que la palabra no esta vacia
		                throw new MiException();
		            
		            }
					
		            // Verifica si la palabra contiene solo letras
		            for (char c : userName.toCharArray()) {//miramos que lo introducido sea todo letras, si no la excepcion
		                if (!Character.isLetter(c)) {
		                	userName = "";
		                	throw new MiException();//llamar excepcion
		                }
		            }
		            System.out.println(userName);//prueba
		            
		            
		            
		            if (civilizationName.length() >= 1 && civilizationName.length() <= 10) {
		            	System.out.println(civilizationName);//prueba
		            	
		            	principal.createCivilization(userName,civilizationName,principal); 
		            	
		            	
		            	
		            	
		            	
		            	
		            	
		            	
			        	dispose();
			        	//////////////////////////////////
		            } else {
		            	throw new MiException();
		            }
		            
		        } catch (MiException mi) {//si excepcion se hace lo de aqui
		        	System.out.println("error");
    		        }
    			}
    		
    		}
    	}
	
    }
    
class RoundedButton extends JButton {

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false); // Hace que el área de contenido del botón no se pinte
        setFocusPainted(false); // Elimina el resaltado cuando el botón gana foco
        setBorderPainted(false); // Elimina el borde predeterminado del botón
        setOpaque(false); // Hace que el botón no sea opaco para que podamos pintar el fondo nosotros mismos
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.gray); // Color del fondo cuando el botón está presionado
        } else {
            g.setColor(getBackground());
        }
        // Dibuja un fondo redondeado para el botón
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

        super.paintComponent(g); // Pinta el contenido del botón (texto u otros componentes)
    }

    
    protected void paintBorder(Graphics g) {
        // No hacemos nada para evitar dibujar el borde predeterminado
    }

    // Método para establecer la apariencia de los bordes redondeados
    public Insets getInsets() {
        return new Insets(4, 8, 4, 8); // Margen interior para el texto dentro del botón
    }
}
//clase para difuminar color titulo pantalla principal
class GradientLabel extends JLabel {
    private Color startColor;
    private Color endColor;
    private int fontSize;

    public GradientLabel(String text, Color startColor, Color endColor, int fontSize) {
        super(text);
        this.startColor = startColor;
        this.endColor = endColor;
        this.fontSize = fontSize;
    }

  //metodo que implementa el difimune y marca la fuente, tamaño y etc...
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Crear el degradado para el texto
        GradientPaint gp = new GradientPaint(0, 0, startColor, getWidth(), 0, endColor);

        // Aplicar el degradado al texto
        g2d.setPaint(gp);
        g2d.setFont(new Font("Algerian", Font.BOLD, fontSize));
        g2d.drawString(getText(), 0, getHeight());

        g2d.dispose();
    }
}

    

