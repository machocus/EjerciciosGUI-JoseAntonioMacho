/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1GUI_JoseAntonioMacho;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author aguil
 */
public class Test {

    public static void main(String[] args) {

        JFrame ventanaPrincipal = new JFrame("Jose Antonio Macho");

        // Establecemos tamaño y posición
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setLocationRelativeTo(null);

        // Hacemos visible la ventana
        ventanaPrincipal.setVisible(true);

        // Acción por defecto al pulsar el botón de cierre de la ventana
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecemos el layout del JFrame
        ventanaPrincipal.setLayout(new BorderLayout());

        // La ventana no se puede redimensionar
        ventanaPrincipal.setResizable(false);

        // Añadimos los paneles en cada posición del BorderLayout
        // Añadir panel rojo en la posición superior (NORTH)
        // Añadir panel verde en la posición izquierda (WEST)
        MiPanel naranja = new MiPanel(Color.orange);
        naranja.getEtiqueta().setText("Este va de naranja");
        ventanaPrincipal.add(naranja, BorderLayout.WEST);

        // Añadir panel cián en la posición derecha (EAST)
        MiPanel darkGrey = new MiPanel(Color.DARK_GRAY);
        darkGrey.getEtiqueta().setText("Este va de color gris oscuro");
        ventanaPrincipal.add(darkGrey, BorderLayout.EAST);

        // Añadir panel rojo en la posición inferior (SOUTH)
        MiPanel amarillo = new MiPanel(Color.yellow);
        amarillo.getEtiqueta().setText("Color amarillo");
        ventanaPrincipal.add(amarillo, BorderLayout.SOUTH);

        // Añadir panel amarillo en la posición central (CENTER)
        MiPanel rosa = new MiPanel(Color.pink);
        rosa.getEtiqueta().setText("Este va de color rosa");
        ventanaPrincipal.add(rosa, BorderLayout.CENTER);
        
        MiPanel azul = new MiPanel(Color.BLUE);
        azul.getEtiqueta().setText("Esto es una prueba");
        ventanaPrincipal.add(azul, BorderLayout.NORTH);
    }
}
