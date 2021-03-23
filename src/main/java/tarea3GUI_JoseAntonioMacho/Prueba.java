/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3GUI_JoseAntonioMacho;

import javax.swing.JFrame;

/**
 *
 * @author aguil
 */
public class Prueba {

    public static void main(String[] args) {
 // Construimos la ventana        
        JFrame frame = new JFrame("App");
 // La ventana no se puede redimensionar         
        frame.setResizable(false);
// Posición de la ventana      
        frame.setLocationRelativeTo(null);
// Incluimos el panel en la ventana       
        frame.add(new Saludo());
// Ajusta el frame al contenido        
        frame.pack();
// Hacemos visible la ventana        
        frame.setVisible(true);
//Acción por defecto al pulsar el botón de cierre de la ventana        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
