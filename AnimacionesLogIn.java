/* Equipo 4 4SA  
 * 
 * Abraham Israel Pech Puch
 * Jafeth Daniel Gamboa Baas
 * Brandonn Roblelo Luna
 * Russell Sleither Perez Santana
 * 
 * */
//importamos librerias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel; 

public class AnimacionesLogIn extends JFrame 
{

    JLabel screen; //creamos la variable para el salvapantashas


    public AnimacionesLogIn() 
    {
    	
    	SalvaPantalla(); //llamamos a nuestro metodos salvapantalla
    	reproducirMusic() ; 
    	PonerLogo();

    	
    }
    
    public void PonerLogo () //aca creamos un metodo para poder poner el logo a gusto
    {
    	// Cargar la imagen del archivo "logo.png"
        ImageIcon icono = new ImageIcon("logo.png");
        Image logo = icono.getImage();
        
        // Establecer la imagen como icono de la ventana
        setIconImage(logo);
    }
    
    private boolean musicaSonando = true;

    public void reproducirMusic() 
    {
        new Thread(new Runnable() {
            public void run() {
                try {
                    // obtenemos el archivo beeb.wav, nota solo solo .wav es compatible
                    File archivoVienBenido = new File("bienvenido.wav");
                    
                    // Crear un objeto Clip para reproducir el archivo de sonido
                    Clip musicaa = AudioSystem.getClip();
                    
                    // Abrir el archivo de sonido y cargar sus datos en el objeto Clip
                    musicaa.open(AudioSystem.getAudioInputStream(archivoVienBenido));
                    
                    // Reproducir el sonido en un loop infinito hasta que la bandera sea falsa
                    musicaa.loop(Clip.LOOP_CONTINUOUSLY);
                    
                    while (musicaSonando) 
                    {
                        Thread.sleep(1000); // Pausa de 1 segundo para evitar consumir recursos innecesarios
                    }
                    
                    // Cuando la bandera sea falsa, detener la música
                    musicaa.stop();
                    
                } catch (Exception sopas) {
                    sopas.printStackTrace();
                }
            }
        }).start();
    }


    

    private void SalvaPantalla() //metodo que contiene el hilo
    {
    	
    	setSize(400, 350); //delimitamos el tamanio de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //evitamos que la cierren manualmente
        setResizable(false); //evitamos que la redimencionen
        setUndecorated(true); //le quitamos la barra de arriba para cerrar con la equis
        setAlwaysOnTop(true); //sobreponemos este metodo a todo lo demas
        setLocationRelativeTo(null); //permitimos que se ponga donde esta la ventana original
        JPanel jp = new JPanel();
        jp.setBackground(new Color(54,4,62));
        add(jp);

        addMouseListener(new MouseAdapter()  //escucha nuestro raton, mouse, el periferico, no un raton
        {
            @Override
            public void mouseClicked(MouseEvent arg0) 
            {
            	musicaSonando = false; // Detener la música
            	dispose(); //cerramos al hacer clic
            }
        });

        addKeyListener(new KeyAdapter() 
        {
          
            public void keyReleased(KeyEvent arg0) 
            {
            	musicaSonando = false; // Detener la música
            	dispose(); //escucha nuestro teclado
            			   //por algun motivo no sirve dependientemente, hay que darle clic antes
            	
            }
        });

        screen = new JLabel("");
        screen.setVerticalTextPosition(JLabel.CENTER); //colocamos el texto en el centro
        screen.setHorizontalAlignment(0); //lo aliniamos en el centro horizontal del contenedor
        screen.setLayout(new java.awt.BorderLayout()); 
        screen.setFont(new java.awt.Font("Serif", 1, 30)); //colocamos un tipo de letra
        screen.setForeground(Color.WHITE); //le ponemos color
        screen.setBackground(Color.GREEN);
        jp.add(screen); //agregamos todo a nuestro jp jpanel
        
        


        Thread t = new Thread(new Runnable()  //hilo
        {

            public void run() 
            {
            	
            	
            	//creamos dos variables alfanumericas con la ayuda de html
                String mensa1 = "<html><br><br>";
                String mensa2 = "</html>";
                
                while (true) //while de toda la vida, el cual hara con un for un ciclo sin fin
                {
                    for (int i = 0; true; i++) //for
                    { 
                        switch (i) //con el switch le damos diferentes etapas al mensaje
                        { 
                            case 1:
                            	screen.setText(mensa1 + "<font color='GREEN'>Bienvenid@ a</font> Viatec" + mensa2);
                                
                            	break;
                            case 2:
                            	screen.setText(mensa1 + "Tu <font color='GREEN'>via</font> a la tecnologia" + mensa2);
                                break;
                            case 3:
                            	screen.setText(mensa1 + "yo amo la <font color='GREEN'>tec</font>nologia" + mensa2);
                                break;
                            default:
                                i = 0;
                        }
                        try 
                        {
                            Thread.sleep(2000); //el tiempo que tarda en cambiar en cada etapa
                        } 
                        catch (Exception e) //le agregamos la excepcion
                        {
                        }
                    }
                }
            }
        });
        t.start(); //iniciamos t, nuestro hilo
        
    	JLabel imagenc = new JLabel( new ImageIcon ("Icono8.png")); // crea un obj de la clase label para cargar una imagen
      //  imagenc.setBounds(1, 1, 100, 100); //coloca la imagen en los pixeles necesarios donde X, Y, Ancho, largo
       jp.add(imagenc, BorderLayout.AFTER_LINE_ENDS);
//        jp.add(imagenc); //hace visible la imagen 
        
    }

    
    public static void main(String uwu[]) 
    {

        new AnimacionesLogIn().setVisible(true); 
    }
}