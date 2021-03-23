/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3GUI_JoseAntonioMacho;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author aguil
 */
public class Saludo extends JPanel implements ActionListener {

    private JButton botonNombre, botonApellido, generarAleatorio;
    private JTextArea texto;
    private JLabel etiqueta;

    public Saludo() {
        initComponents();
    }

    private void initComponents() {

        botonNombre = new JButton("Nombre");
        botonApellido = new JButton("Apellidos");
        generarAleatorio = new JButton("Generar Aleatorio");
        etiqueta = new JLabel("Número");
        texto = new JTextArea(1, 25);
        texto.setBackground(Color.ORANGE);

        this.setLayout(new FlowLayout());

        this.add(botonNombre);
        this.add(botonApellido);
        this.add(texto);
        this.add(generarAleatorio);
        this.add(etiqueta);

// Se le indica al objeto boton que escuche eventos tipo click
// y se pasa como argumento una referencia de tipo ActionListener
// En este caso se pasa this que es el panel sobre el 
// que está el botón y que implementa la interfaz ActionListener
        botonNombre.addActionListener(this);
        botonApellido.addActionListener(this);
        this.generarAleatorio(generarAleatorio);
        this.cambiarColor(generarAleatorio);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // Si el botón pulsado es botonSaludar
        if (ae.getSource() == botonNombre) {
            texto.setText("Jose Antonio");
            texto.setBackground(Color.white);
        }

        if (ae.getSource() == botonApellido) {
            texto.setText("Macho");
            texto.setBackground(Color.cyan);
        }
    }

    public void generarAleatorio(JButton boton) {
        Random random = new Random();
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                etiqueta.setText(String.valueOf(random.nextInt(10)));

            }
        });
    }
    
    public void cambiarColor(JButton boton){
      boton.addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent me) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void mousePressed(MouseEvent me) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void mouseReleased(MouseEvent me) {
            
          }

          @Override
          public void mouseEntered(MouseEvent me) {
              generarAleatorio.setBackground(Color.red);
          }

          @Override
          public void mouseExited(MouseEvent me) {
              generarAleatorio.setBackground(null);
          }
      });
    }

}
