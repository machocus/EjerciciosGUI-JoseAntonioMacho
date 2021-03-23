/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1GUI_JoseAntonioMacho;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aguil
 */
public class MiPanel extends JPanel {
    
// Añadimos un componente de tipo etiqueta (JLabel)
    private JLabel etiqueta;
    
    // Constructor pasando un color, que llama al método initComponents(), 
    public MiPanel(Color color){
           initComponents();
        cambiarColorFondo(color);
    }
    
    // Método que inicializa los elementos gráficos del formulario
    private void initComponents(){
        // Construimos la etiqueta con el texto que queremos que muestre
            etiqueta = new JLabel("Etiqueta de MiPanel");
        // Añade la etiqueta al contenedor MiPanel (al JPanel)
            this.add(etiqueta);
    }
    
    private void cambiarColorFondo(Color color){
        // Establece el color de fondo del panel
            this.setBackground(color);
    }

    // Método getter
    public JLabel getEtiqueta() {
            return etiqueta;
    }
}
