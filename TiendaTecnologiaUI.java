/* Equipo 4 4SA  
 * 
 * Abraham Israel Pech Puch
 * Jafeth Daniel Gamboa Baas
 * Brandonn Roblelo Luna
 * Russell Sleither Perez Santana
 * 
 * */

//importamos librerias
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


        public class TiendaTecnologiaUI extends JFrame  //creamos la clase que hereda el jframe
        {
            //creamos los botones como obj
            private JLabel feisbuk;
            private  JPanel panelBienvenida;
            private  JButton boton1 = new JButton("Armar PC");
            private  JButton boton2 = new JButton("Sucursales");
            private  JButton boton3 = new JButton("Productos");
            private  JButton boton4 = new JButton("Salir");



            
            public TiendaTecnologiaUI() //constructor no nulo principal
            {
                super("Tienda de Tecnologia"); //establece el nombre de la ventana
                

                
                //crea un panel
                panelBienvenida = new JPanel(); 
                panelBienvenida.setLayout(new BoxLayout(panelBienvenida, BoxLayout.Y_AXIS));
                
          /*      JLabel lblBienvenida = new JLabel("¡Bienvenido a la Tienda de Tecnologia!", SwingConstants.CENTER); //establece la ubicacion del txt
                lblBienvenida.setFont(new Font("Arial", Font.BOLD, 24)); // le colocamos formato
                panelBienvenida.add(lblBienvenida); //agrega el texto al panel */
                // Agregar el panel en la posición BorderLayout.NORTH
                add(panelBienvenida, BorderLayout.CENTER);
                
 
                // (x,y, ancho, altura)
                //agregamos los botones y ponemos los pixeles correspondientes
                boton1.setBounds(50, 400, 100, 90);
                add(boton1);
                boton2.setBounds(180, 400, 100, 90);
                add(boton2);
                boton3.setBounds(310, 400, 100, 90);
                add(boton3);
                boton4.setBounds(440, 400, 100, 90);
                add(boton4);
                
                //aplica el diseno invocando al metodo
                DisenoBotones(); 
                
                //// llama al metodo para poner una imagen
                ImportarImagen();
                
                //imagen interactiva
                ImagenInteractiva();
                
                //sonidos
                
  
                // se llama al metodo para poner el logo de la ventana
                PonerLogo ();
                
                add(panelBienvenida); 
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para poder cerrarse
                setSize(600, 550); //establece el tamano
                setLocationRelativeTo(null);
                setUndecorated(true);

                // panelBienvenida.setBackground(Color.magenta);

             panelBienvenida.setBackground(new Color(1,1,1)); //establece color al fondo 138,138,204

                setVisible(true); //pone todo visible
                
                // en lugar de crear un metodo actionlistener mejor creamos directamente la accion
                //usando el action listener puchamos los botones

                boton1.addActionListener(e -> { abrirArmarPC(); dispose(); reproducirSonidoBoton();}); 
                boton2.addActionListener(e -> {MapaSucursal(); reproducirSonidoBoton();});
                boton3.addActionListener(e -> {reproducirSonidoBoton(); JOptionPane.showMessageDialog(this, "Base de datos de articulos disponibles", "UWU", JOptionPane.INFORMATION_MESSAGE); reproducirSonidoBoton(); });                
                boton4.addActionListener(e -> {
                	reproducirSonidoBoton();
                    int respuesta = JOptionPane.showConfirmDialog(this, "Estas seguro que quieres salir?", "Se cerrara la sesion", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION)  // verifica que digas que si uwu
                    {
                        JOptionPane.showMessageDialog(this, "Cerrando Sesion.");
                        abrirIniciarSesion();
                        dispose(); //cierra la ventana en curso
                        reproducirSonidoBoton();
                    }
                });
                   
            }
            
            public void MapaSucursal()
            {
            	String url = "https://goo.gl/maps/hoDBe51GYLSxwt9Z7"; //creamos una cadena que tenga el link del mapa
            	
                 try 
            	{
                    Desktop.getDesktop().browse(new URI(url));
                } 
            	catch (Exception e) //agrega nuestra excepcion
            	{
                    e.printStackTrace();
                }  
            }



            public void reproducirSonidoBoton() 
            {
                try {
                    // obtenemos el archivo beeb.wav, nota solo solo .wav es compatible
                    File archivoSonido = new File("beep.wav");
                    
                    // Creamos un objeto sonido para reproducir el archivo de sonido
                    Clip sonido = AudioSystem.getClip();
                    
                    // Abrir el archivo de sonido y cargar sus datos en el objeto sonido
                    sonido.open(AudioSystem.getAudioInputStream(archivoSonido));
                    
                    // reproducimos el sonido
                    sonido.start();
                } catch (Exception owo) {
                    owo.printStackTrace();
                }
            }

            
            public void ImagenInteractiva() 
            {
                ImageIcon feis = new ImageIcon("feis.png");
                feisbuk = new JLabel(feis);
                feisbuk.setBounds(530, 150, 50, 50); //coloca la imagen en los pixeles necesarios donde X, Y, Ancho, largo
                add(feisbuk); // anadir al panel
                feisbuk.addMouseListener(new MouseAdapter() 
                {

                    public void mouseClicked(MouseEvent e) 
                    {

                    	 try 
                    	 {
							Desktop.getDesktop().browse(new URI("www.facebook.com"));
						 } 
                    	 catch (IOException e1) 
                    	 {
							// verifica que no marque error y al menos lo intenta 1 vez 
							e1.printStackTrace();
						} catch (URISyntaxException e1) 
                    	 {
							e1.printStackTrace();
						}
                    }
                });
            }
            
            public void PonerLogo () //aca creamos un metodo para poder poner el logo a gusto
            {
            	// Cargar la imagen del archivo "logo.png"
                ImageIcon icono = new ImageIcon("logo.png");
                Image logo = icono.getImage();
                
                // Establecer la imagen como icono de la ventana
                setIconImage(logo);
            }
            
            private void ImportarImagen()
            {
            	/// imagen de pc
                JLabel imagen = new JLabel( new ImageIcon ("Icono3.png")); // crea un obj de la clase label para cargar una imagen
                imagen.setBounds(1, -5, 600, 500); //coloca la imagen en los pixeles necesarios donde X, Y, Ancho, largo
                add(imagen); // lo agregamos al panel
                
                
            	/// imagen de bienvenida
                JLabel imagen2 = new JLabel( new ImageIcon ("Bienvenidos.png")); // crea un obj de la clase label para cargar una imagen
                imagen2.setBounds(1, -200, 600, 500); //coloca la imagen en los pixeles necesarios donde X, Y, Ancho, largo
                add(imagen2); //lo agregamos al panel
            }
          private void DisenoBotones()
          {
              // Establecer el diseño del botón 1
              boton1.setFont(new Font("Arial", Font.BOLD, 14));
              boton1.setForeground(Color.WHITE); //color letra
              boton1.setBackground(new Color(42,51,90)); //color del relleno del boton
              boton1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2)); // color del contorno del boton
              
              // Establecer el diseño del botón 2
              boton2.setFont(new Font("Arial", Font.BOLD, 14));
              boton2.setForeground(Color.WHITE);
              boton2.setBackground(new Color(42,51,90));
              boton2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
              
              // Establecer el diseño del botón 3
              boton3.setFont(new Font("Arial", Font.BOLD, 14));
              boton3.setForeground(Color.WHITE);
              boton3.setBackground(new Color(42,51,90));
              boton3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
              
              // Establecer el diseño del botón 4
              boton4.setFont(new Font("Arial", Font.BOLD, 14));
              boton4.setForeground(Color.WHITE);
              boton4.setBackground(new Color(42,51,90));
              boton4.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
          }
            private void abrirArmarPC()  //metodo para abrir armarpc
            {
            	ArmarPC ventanaArmarPC = new ArmarPC();
            	ventanaArmarPC.setVisible(true);
            }
            
            private void abrirIniciarSesion()     //metodo para abrir iniciar sesion
            {
            	IniciarSesion ventanaIniciarSesion = new IniciarSesion();
            	ventanaIniciarSesion.setVisible(true);
            }
            

            //main
            public static void main(String[] args) 
            {
                new TiendaTecnologiaUI(); 
            }
        }        