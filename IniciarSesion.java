/* Equipo 4 4SA  
 * 
 * Abraham Israel Pech Puch
 * Jafeth Daniel Gamboa Baas
 * Brandonn Roblelo Luna
 * Russell Sleither Perez Santana
 * 
 * */

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class IniciarSesion extends JFrame implements ActionListener
{

    // Componentes de la interfaz
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin;
    private JButton btnSalir;

    // Constructor
    public IniciarSesion() 
    {
        // Configuración de la ventana
        setTitle("Iniciar Sesión");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true); //le quitamos la barra de arriba, donde minimizar, maximizar o cerrar


        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(22,26,32)); // Cambiar el color de fondo aquí

        // Etiqueta de usuario
        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setBounds(50, 50, 100, 30);
        lblUser.setForeground(Color.WHITE); // Cambiar el color del texto aquí
        panel.add(lblUser);

        // Campo de texto para usuario
        txtUser = new JTextField();
        txtUser.setBounds(150, 50, 200, 30);
        panel.add(txtUser);

        // Etiqueta de contraseña
        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(50, 100, 100, 30);
        lblPass.setForeground(Color.WHITE); // Cambiar el color del texto aquí
        panel.add(lblPass);

        // Campo de texto para contraseña
        txtPass = new JPasswordField();
        txtPass.setBounds(150, 100, 200, 30);
        panel.add(txtPass);

        // Botón de inicio de sesión
        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBounds(150, 150, 200, 30);
        btnLogin.addActionListener(this);
        panel.add(btnLogin);
        
        // Botón de salir
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(150, 250, 200, 30);
        btnSalir.addActionListener(this);
        panel.add(btnSalir);
     
        // Botón para crear usuario
        JButton btnCrearUsuario = new JButton("Crear Usuario");
        btnCrearUsuario.setBounds(150, 200, 200, 30);
        btnCrearUsuario.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	crearUsuario();
            }
        });
        panel.add(btnCrearUsuario);
        
         JLabel imagenc = new JLabel( new ImageIcon ("candado.png")); // crea un obj de la clase label para cargar una imagen
        imagenc.setBounds(50, 160, 75, 75); //coloca la imagen en los pixeles necesarios donde X, Y, Ancho, largo
        add(imagenc); //hace visible la imagen 

        // Agregar el panel a la ventana
        add(panel);
        //llama al metodo del logo
        PonerLogo ();
        
        AnimacionesLogin();
        //

    }
            
 
    // Método para abrir el programa ArmarPC
    private void AnimacionesLogin() 
    {
    	AnimacionesLogIn AnimacionesLogIn = new AnimacionesLogIn();
    	AnimacionesLogIn.setVisible(true);

    }
    
    public void reproducirSonidoBotones() 
    {
        try {
            // obtenemos el archivo beeb.wav, nota solo solo .wav es compatible
            File archivoBeep = new File("beep.wav");
            
            // Creamos un objeto Sonidito para reproducir el archivo de sonido
            Clip sonidito = AudioSystem.getClip();
            
            // abrimos el archivo de sonido y cargar sus datos en el objeto Sonidito
            sonidito.open(AudioSystem.getAudioInputStream(archivoBeep));
            
            // con esto reproducimos el sonido
            sonidito.start();
        } catch (Exception awa) {
            awa.printStackTrace();
        }
    }

    
    public void PonerLogo () //aca creamos un metodo para poder poner el logo a gusto
    {
    	// Cargar la imagen del archivo "logo.png"
        ImageIcon icono = new ImageIcon("logo.png");
        Image logo = icono.getImage();
        
        // Establecer la imagen como icono de la ventana
        setIconImage(logo);
    }
    
    // Método para validar usuario y contraseña
    private boolean validarContrasenas(String username, char[] confirmPassword)
    {
    	  boolean valid = false;

    	    try {
    	        // Leer el archivo de usuarios
    	        File file = new File("usuarios.txt");
    	        Scanner scanner = new Scanner(file);

    	        // Buscar la línea que contiene el nombre de usuario
    	        while (scanner.hasNextLine()) {
    	            String line = scanner.nextLine();
    	            if (line.startsWith(username)) {
    	                // Obtener la contraseña guardada en el archivo
    	                String[] parts = line.split(":");
    	                String savedPassword = parts[1].trim();

    	                // Verificar que la contraseña ingresada por el usuario coincide con la contraseña guardada
    	                String enteredPassword = String.valueOf(confirmPassword);
    	                valid = savedPassword.equals(enteredPassword);
    	                break;
    	            }
    	        }

    	        scanner.close();
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }

    	    return valid;
    }


    // Método para abrir el programa ArmarPC
    private void TiendaTecnologiaUI() 
    {
    	TiendaTecnologiaUI ventanaTiendaTecnologiaUI = new TiendaTecnologiaUI();
    	ventanaTiendaTecnologiaUI.setVisible(true);

    }
    
    // Método para manejar eventos de botones
    public void actionPerformed(ActionEvent e) 
    {

        
    	if (e.getSource() == btnLogin) 
        {
    		reproducirSonidoBotones();
        	String username = txtUser.getText();
            char[] password = txtPass.getPassword();

            if (validarContrasenas(username, password)) 
            { 
            	reproducirSonidoBotones();
            	HiloTiendaUI();
                dispose(); // Cerrar la ventana de inicio de sesión
            } else 
            	{
            	reproducirSonidoBotones();
            	JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            	}
        }
        if  (e.getSource() == btnSalir)
        {
        	reproducirSonidoBotones();
        	dispose(); 
        }
          
    }
    
 // Método para crear un nuevo usuario
    private void crearUsuario() 
    {
        // Crear una nueva ventana para ingresar los datos del usuario
        JFrame ventanaCrearUsuario = new JFrame("Crear Usuario");
        ventanaCrearUsuario.setSize(400, 300);
        ventanaCrearUsuario.setResizable(false);
        ventanaCrearUsuario.setLocationRelativeTo(null);
        ventanaCrearUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaCrearUsuario.setUndecorated(true);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(22,26,32)); // Cambiar el color de fondo aquí

        // Etiqueta de nombre de usuario
        JLabel lblNuevoUser = new JLabel("Nombre de usuario:");
        lblNuevoUser.setBounds(50, 50, 150, 30);
        lblNuevoUser.setForeground(Color.WHITE); // Cambiar el color del texto aquí
        panel.add(lblNuevoUser);

        // Campo de texto para el nombre de usuario
        JTextField txtNuevoUser = new JTextField();
        txtNuevoUser.setBounds(200, 50, 150, 30);
        panel.add(txtNuevoUser);

        // Etiqueta de contraseña
        JLabel lblNuevaPass = new JLabel("Contraseña:");
        lblNuevaPass.setBounds(50, 100, 150, 30);
        lblNuevaPass.setForeground(Color.WHITE); // Cambiar el color del texto aquí
        panel.add(lblNuevaPass);

        // Campo de texto para la contraseña
        JPasswordField txtNuevaPass = new JPasswordField();
        txtNuevaPass.setBounds(200, 100, 150, 30);
        panel.add(txtNuevaPass);

        // Botón para crear el usuario
        JButton btnCrearUsuario = new JButton("Crear Usuario");
        btnCrearUsuario.setBounds(125, 175, 150, 30);
        btnCrearUsuario.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	reproducirSonidoBotones();
            	String username = txtNuevoUser.getText();
                String password = String.valueOf(txtNuevaPass.getPassword());

                try {
                	
                    // Crear un nuevo archivo de usuarios si no existe
                    File file = new File("usuarios.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    // Verificar que el usuario no existe ya en el archivo
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) 
                    {
                        String line = scanner.nextLine();
                        if (line.startsWith(username)) 
                        {
                            JOptionPane.showMessageDialog(ventanaCrearUsuario, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                            scanner.close();
                            return;
                        }
                    }
                    scanner.close();

                    // Escribir el nuevo usuario en el archivo
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(username + ": " + password + "\n");
                    bw.close();

                    JOptionPane.showMessageDialog(ventanaCrearUsuario, "El usuario ha sido creado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    reproducirSonidoBotones();
                    ventanaCrearUsuario.dispose(); // Cerrar la ventana de creación de usuario

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(btnCrearUsuario);

        // Agregar el panel a la ventana
        ventanaCrearUsuario.add(panel);

        // Mostrar la ventana de creación de usuario
        ventanaCrearUsuario.setVisible(true);
        reproducirSonidoBotones();
    } 
    

    public void HiloTiendaUI() 
    {
        
    	JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280, 100);
        //frame.setBackground(Color.BLUE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setUndecorated(true); //le quitamos la barra de arriba, donde minimizar, maximizar o cerrar

        
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.BLACK);
        frame.setContentPane(panel);
        
        
        JLabel label = new JLabel("Cargando...");
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(Color.MAGENTA);
        label.setBounds(100, 40, 150, 25);
        frame.add(label);
        

        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(70, 60, 150, 15);
        progressBar.setForeground(Color.MAGENTA);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        frame.add(progressBar);

        Thread thread = new Thread(new Runnable() 
        {
        	
            public void run() 
            {
                for (int i = 0; i <= 100; i++) 
                {
                    try 
                    {
                        Thread.sleep(50);
                    } 
                    catch (InterruptedException e) 
                    {
                        e.printStackTrace();
                    }
                    progressBar.setValue(i);
                    if (i == 100) 
                    {
                        frame.dispose();
                        TiendaTecnologiaUI();
                        
                    }
                }
            }
        });

        thread.start();

        frame.setVisible(true);

    }



    // Método main para iniciar la aplicación
    public static void main(String[] args) 
    {
        IniciarSesion login = new IniciarSesion();
        login.setVisible(true);
    }
}