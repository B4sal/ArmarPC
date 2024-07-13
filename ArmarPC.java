/* Equipo 4 4SA  
 * 
 * Abraham Israel Pech Puch
 * Jafeth Daniel Gamboa Baas
 * Brandonn Roblelo Luna
 * Russell Sleither Perez Santana
 * 
 * */


// importamos librerias
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;


public class ArmarPC extends JFrame implements ActionListener 
{
	// declaramos variables
    private JComboBox<String> comboMarcaProcesador; 
    private JComboBox<String> comboProcesador; 
    private final JComboBox<String> comboMemoria;
    private final JComboBox<String> comboDisco;
    private final JComboBox<String> comboTarjetaVideo;
    private final JComboBox<String> comboFuente;
    private final JComboBox<String> comboMother;
    private final JComboBox<String> comboChip;
    private final JButton btnAgregar;
    private final JButton btnEliminar;
    private final JButton btnRegresar;
    private final JButton btnVerBD;
    
    public ArmarPC()  
    { 
        setTitle("Equipo 4 Armar PC"); // nombramos la ventana 
        
        setSize(800, 400); //establecemos el tamano de la ventana
        setUndecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //colocamos la equis para cerrar la ventana
        
        setLocationRelativeTo(null);

        
        JPanel panel = new JPanel(new GridLayout(10, 1)); //delimitamos la tabla
        

        JLabel lblMarcaProcesador = new JLabel("Marca Procesador:");  // creamos una etiqueta
        comboMarcaProcesador = new JComboBox<>(new String[]{"---", "Intel", "AMD Ryzen"}); //le colocamos valores a la etiqueta anterior
        JLabel lblProcesador = new JLabel("Procesador:"); // creamos una etiqueta
        comboProcesador = new JComboBox<>(new String[]{"---"});  // le colocamos un valor neutro a esta lista
        
        comboMarcaProcesador.addActionListener((ActionEvent x1) -> // creamos un metodo de evento
        {
            if (comboMarcaProcesador.getSelectedItem().equals("AMD Ryzen"))  //  desicion para saber que seleccionamos ryzen
            {
                comboProcesador.setModel(new DefaultComboBoxModel<>(new String[]{"---", "AMD Ryzen 5", "AMD Ryzen 7", "AMD Ryzen 9"}));
            }
            
            else  //sino eligen ryzen es intel
            {
                comboProcesador.setModel(new DefaultComboBoxModel<>(new String[]{"---","Intel i5", "Intel i7", "Intel i9"}));
            }
        } // objeto de combo marca procesador que interpreta una accion
        );
        
        JLabel lblMemoria = new JLabel(" RAM:");  //creamos el apartado de RAM y abajo se rellena la lista
        comboMemoria = new JComboBox<>(new String[]{"---", "8GB", "16GB", "32GB"});
        JLabel lblDisco = new JLabel("Disco:"); //creamos el apartado de Almacenamiento  y abajo se rellena la lista
        comboDisco = new JComboBox<>(new String[]{"---", "SSD 256GB", "SSD 512GB", "HDD 1TB", "M.2 512GB",});
        JLabel lblTarjetaVideo = new JLabel("Tarjeta grafica:"); //creamos el apartado de Graficas  y abajo se rellena la lista
        comboTarjetaVideo = new JComboBox<>(new String[]{"---", "Nvidia GTX 1650", "Nvidia GTX 1650s", "Nvidia GTX 1660", "Nvidia GTX 1660s",  "Nvidia RTX 3060", "Nvidia RTX 4090" });
        JLabel lblFuente = new JLabel("Fuente de poder:"); //creamos el apartado de fuentes de poder y abajo se rellena la lista
        comboFuente = new JComboBox<>(new String[]{"---", "500W", "650W", "750W", "1000W"});
        JLabel lblMother = new JLabel("Formato de la Motherboard:");
        comboMother = new JComboBox<>(new String[]{"---", "Micro ATX", "Mini ATX", "ATX ", "ETX"});
        JLabel lblChip = new JLabel("Chipset de la motherboard");
        comboChip = new JComboBox<>(new String[]{"---", "X570", "Z590"}); //Z intel X Amd
        btnAgregar = new JButton("Agregar");  
        btnEliminar = new JButton("Eliminar");
        btnRegresar = new JButton("Regresar");
        btnVerBD = new JButton("Guardados");
        
        btnAgregar.addActionListener(this); // se crea una accion para el boton agregar 
        btnEliminar.addActionListener(this);
        btnRegresar.addActionListener(this);// se crea una accion para el boton eliminar 
        btnVerBD.addActionListener(this);// se crea una accion para el boton guardados 

        //Le ponemos color a la vida

        comboProcesador.setBackground(new Color(162,192,254)); 
        comboMarcaProcesador.setBackground(new Color(162,192,254)); 
        comboMemoria.setBackground(new Color(162,192,254));
        comboDisco.setBackground(new Color(162,192,254));
        comboTarjetaVideo.setBackground(new Color(162,192,254));
        comboFuente.setBackground(new Color(162,192,254));
        comboMother.setBackground(new Color(162,192,254));
        comboChip.setBackground(new Color(162,192,254));
        btnAgregar.setBackground(new Color(162,192,254));
        btnRegresar.setBackground(new Color(162,192,254));
        btnEliminar.setBackground(new Color(162,192,254));
        btnVerBD.setBackground(new Color(162,192,254));
        panel.setBackground(new Color(156,168,184));

        //intento de poner color a las letras
        lblMemoria.setForeground(Color.BLACK);
        lblProcesador.setForeground(Color.BLACK);
        lblMemoria.setForeground(Color.BLACK);
        lblDisco.setForeground(Color.BLACK);
        lblTarjetaVideo.setForeground(Color.BLACK);
        lblFuente.setForeground(Color.BLACK);
        lblMother.setForeground(Color.BLACK);
        lblChip.setForeground(Color.BLACK);
        lblMarcaProcesador.setForeground(Color.BLACK);
        // se agrega todo al panel


        panel.add(lblMarcaProcesador);
        panel.add(comboMarcaProcesador);
        panel.add(lblProcesador);
        panel.add(comboProcesador);
        panel.add(lblMemoria);
        panel.add(comboMemoria);
        panel.add(lblDisco);
        panel.add(comboDisco);
        panel.add(lblTarjetaVideo);
        panel.add(comboTarjetaVideo);
        panel.add(lblFuente);
        panel.add(comboFuente);
        panel.add(lblMother);
        panel.add(comboMother);
        panel.add(lblChip);
        panel.add(comboChip);

        panel.add(btnAgregar);
        panel.add(btnEliminar);
        panel.add(btnRegresar);
        panel.add(btnVerBD);
        
        PonerLogo();

        add(panel);  // lo anadimos al panel
        setVisible(true); //se establece visible
    
    }
    
    public void reproducirSonidoBotonAPC() 
    {
        try {
            // obtenemos el archivo beeb.wav, nota solo solo .wav es compatible
            File archivoSonidoBoton = new File("beep.wav");
            
            // Creamos un objeto sonidoBoton para reproducir el archivo de sonido
            Clip sonidoBoton = AudioSystem.getClip();
            
            // Abrimos el archivo de sonido y cargar sus datos en el objeto sonidoBoton
            sonidoBoton.open(AudioSystem.getAudioInputStream(archivoSonidoBoton));
            
            // Reproducir el sonido
            sonidoBoton.start();
        } catch (Exception supa) {
        	supa.printStackTrace();
        }
    }
    
    //metodo para poner la imagen
    public void PonerLogo () //aca creamos un metodo para poder poner el logo a gusto
    {
    	// Cargar la imagen del archivo "logo.png"
        ImageIcon icono = new ImageIcon("logo.png");
        Image logo = icono.getImage();
        
        // Establecer la imagen como icono de la ventana
        setIconImage(logo);
    }
    
    private void abrirTiendaTecnologiaUI() 
    {
    	TiendaTecnologiaUI ventanaTiendaTecnologiaUI = new TiendaTecnologiaUI();
    	ventanaTiendaTecnologiaUI.setVisible(true);
    }
    
    
    private void abrirBaseDeDatosUI() 
    {
    	BaseDeDatosUI ventanaBaseDeDatosUI = new BaseDeDatosUI();
    	ventanaBaseDeDatosUI.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)   // se enlazan las acciones con los botones previamente creador en tipo lista para desplegar mensajes
    {	
    	 
    	if (e.getSource() == btnRegresar) 
        {
    		reproducirSonidoBotonAPC();
    		int respuesta = JOptionPane.showConfirmDialog(this, "Quieres regresar a la pestana principal", "confirma eleccion", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION)  // verifica que digas que si uwu
            	{
            		reproducirSonidoBotonAPC();
            		JOptionPane.showMessageDialog(this, "Regresando al inicio");
            		reproducirSonidoBotonAPC();
            		abrirTiendaTecnologiaUI();
                    dispose(); //cierra la ventana en curso
            	}

        } 
    	if (e.getSource() == btnAgregar)  // verificamos que la eleccion del usuario sea el boton agregar
        {	// corrobora la seleccion de la marca de los componentes
    		reproducirSonidoBotonAPC();
    		String Marcaprocesador = (String) comboMarcaProcesador.getSelectedItem(); 
            String Chip = (String) comboChip.getSelectedItem();
            
            

            
            if (Marcaprocesador.equals("Intel") && Chip.equals("X570")) // confirmamos que hayan elegido intel y un chip incorrecto
            {
                JOptionPane.showMessageDialog(this, "la marca procesador " + comboMarcaProcesador.getSelectedItem() + " y el Chipset de la motherboard: " + comboChip.getSelectedItem() + " seleccionada son incompatibles");
                reproducirSonidoBotonAPC();
            } 
            else { 
            	
            	if(Marcaprocesador.equals("AMD Ryzen") && Chip.equals("Z590")) // confirmamos que hayan elegido ryzen y un chip incorrecto
                {
                    JOptionPane.showMessageDialog(this, "la marca procesador " + comboMarcaProcesador.getSelectedItem() + " y el Chipset de la motherboard: " + comboChip.getSelectedItem() + " seleccionada son incompatibles");
                    reproducirSonidoBotonAPC();
                }
            	else  
            		{ 
            		
            		
            		//desplegamos la lista de los componentes
            		
            		String mensaje = "Se ha agregado una PC con los siguientes componentes:\n";
            		mensaje += "Procesador: " + comboProcesador.getSelectedItem() + "\n";
            		mensaje += "Memoria: " + comboMemoria.getSelectedItem() + "\n";
            		mensaje += "Disco: " + comboDisco.getSelectedItem() + "\n";
            		mensaje += "Tarjeta de video: " + comboTarjetaVideo.getSelectedItem() + "\n";
            		mensaje += "Fuente de poder: " + comboFuente.getSelectedItem() + "\n";
            		mensaje += "Formato de la Motherboard: " + comboMother.getSelectedItem() + "\n";
            		mensaje += "Chipset de la motherboard: " + comboChip.getSelectedItem() + "\n";
            		mensaje += "Marcas pueden variar segun disponibilidad";
            		
            		
            		JOptionPane.showMessageDialog(this, mensaje);
            			reproducirSonidoBotonAPC();
            			HiloGuardando();
            		}
            }
        } else if (e.getSource() == btnEliminar)   //reseteo de la lista
        	{ 
        	reproducirSonidoBotonAPC();
        	//aca de pregunta si estas seguro, si lo catafixias o no
            int respuesta = JOptionPane.showConfirmDialog(this, "Estas seguro de eliminar la PC seleccionada?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION)  // verifica que digas que si uwu
            	{
                	JOptionPane.showMessageDialog(this, "La PC ha sido eliminada.");
                	reproducirSonidoBotonAPC();
            	}
        	}
    	
        else if (e.getSource() == btnVerBD)  
    	{ //aca de pregunta si estas seguro, si lo catafixias o no
        
        	reproducirSonidoBotonAPC();
        	abrirBaseDeDatosUI();
            dispose(); //cierra la ventana en curso
        	
    	}
    }
    
    public void HiloGuardando() 
    {
    	JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360,200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
      frame.setUndecorated(true);
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(22,26,32));
        
        JLabel imagenpcgi = new JLabel( new ImageIcon ("pcgirando2.gif")); // crea un obj de la clase label para cargar una imagen
        imagenpcgi.setBounds(100,-100, 150,300); //coloca la imagen en los pixeles necesarios donde X, Y, Ancho, largo
        panel.add(imagenpcgi);
        	

        
        frame.setContentPane(panel);
        
        
        JLabel label = new JLabel("Guardando...");
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(new Color(156,168,184));
        label.setBounds(130, 110, 150, 25);
        frame.add(label);
        

        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(100, 140, 150, 15);
        progressBar.setForeground(new Color(156,168,184));
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        frame.add(progressBar);
        


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                         
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.setValue(i);
                    if (i == 100) {
                        frame.dispose();
               
                    }
                }
            }
        });

        thread.start();

        frame.setVisible(true);

    }
    
    public static void main(String[] args) 
    {	
    	
        ArmarPC armarPC = new ArmarPC(); // un obj
    }
}
