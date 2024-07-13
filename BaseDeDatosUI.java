/* Equipo 4 4SA  
 * 
 * Abraham Israel Pech Puch
 * Jafeth Daniel Gamboa Baas
 * Brandonn Roblelo Luna
 * Russell Sleither Perez Santana
 * 
 * */
//importamos librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BaseDeDatosUI extends JFrame implements ActionListener 

 
{
	//creamos la tabla y boton
    private JTable tabla; 
    private DefaultTableModel modelo; 
    private JButton botonAgregar, botonEliminar, botonSalir, botonGuardar;

    public BaseDeDatosUI() 
    {
    	//parametros de la ventana
        setTitle("Equipos guardados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);


        // Crear la tabla y el modelo
        String[] columnas = {"Marca", "Tipo de procesador", "Memoria", "Disco", "Tarjeta de video", "Fuente", "Mother", "Chip de la mother"};
        modelo = new DefaultTableModel(columnas, 1);
        tabla = new JTable(modelo);
//        tabla.setBackground(Color.GRAY); 
        // Crear los botones
        botonAgregar = new JButton("Agregar");
        botonEliminar = new JButton("Eliminar");
        botonGuardar = new JButton("Guardar");
        botonSalir = new JButton("Salir");

        // Agregar los componentes a la interfaz
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAgregar);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonGuardar);
        panelBotones.add(botonSalir);

        JScrollPane scrollTabla = new JScrollPane(tabla);

        getContentPane().add(scrollTabla, "Center");
        getContentPane().add(panelBotones, "South");
        
        panelBotones.setBackground(Color.lightGray);

        //aplicamos las acciones
        botonAgregar.addActionListener((ActionListener) this);
        botonSalir.addActionListener((ActionListener) this);
        botonGuardar.addActionListener((ActionListener) this);
        botonEliminar.addActionListener((ActionListener) this);
        
        setVisible(true);
        
        
       

    }
    
    public void reproducirSonidoBotonesBD() 
    {
        try {
            // obtenemos el archivo beeb.wav, nota solo solo .wav es compatible
            File archivoBip = new File("beep.wav");
            
            // Creamos un objeto bip para reproducir el archivo de sonido
            Clip bip = AudioSystem.getClip();
            
            // Abrimos el archivo de sonido y cargar sus datos en el objeto bip
            bip.open(AudioSystem.getAudioInputStream(archivoBip));
            
         // con esto reproducimos el sonido
            bip.start();
        } catch (Exception eror) {
            eror.printStackTrace();
        }
    }
    
    //metodo para las acciones de los botones
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == botonAgregar) 
        {
        	reproducirSonidoBotonesBD();
        	modelo.addRow(new Object[]{"", "", "", "", "", "", "", ""});
        }
        
        if  (e.getSource() == botonSalir) 
        {
        	reproducirSonidoBotonesBD();
        	abrirArmarPC();
            dispose();
        }
        
        if (e.getSource() == botonEliminar) 
        {
        	 int filaSeleccionada = tabla.getSelectedRow();
        	    if (filaSeleccionada >= 0) { // Verificar que hay una fila seleccionada
                	reproducirSonidoBotonesBD();
        	    	modelo.removeRow(filaSeleccionada);
        	    }
        }
        
        if  (e.getSource() == botonGuardar) 
        {	
        	reproducirSonidoBotonesBD();
        	String mensaje = "Cambios guardados";
        	JOptionPane.showMessageDialog(this, mensaje);
        	reproducirSonidoBotonesBD();

        }
        
      
    }
    
    
    private void abrirArmarPC()  //metodo para abrir armarpc
    {
    	ArmarPC ventanaArmarPC = new ArmarPC();
    	ventanaArmarPC.setVisible(true);
    }

    public static void main(String[] args) //main
    {	
    	
    	BaseDeDatosUI BaseDeDatosUI = new BaseDeDatosUI(); // un obj
    }
}



