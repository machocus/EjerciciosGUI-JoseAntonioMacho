/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea4_Calculadora;

/**
 *
 * @author aguil
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;
    private String var1 = "";
    private int entradaSwitch;
    private double resultado = 0;
    private String array[];

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        // Si es un botón
        if (o instanceof JButton) {
            System.out.println(((JButton) o).getText());

            if (!((JButton) o).getText().equals("=")) {
                areaTexto.setText(areaTexto.getText() + ((JButton) o).getText());
            }
            //switch para que al pulsar el boton de operacion se desabiliten los demas
            switch (((JButton) o).getText()) {
                case "+":
                    for (int i = 11; i <= 13; i++) {
                        botonera.grupoBotones[i].setEnabled(false);
                    }
                    break;
                case "-":
                    botonera.grupoBotones[10].setEnabled(false);
                    botonera.grupoBotones[12].setEnabled(false);
                    botonera.grupoBotones[13].setEnabled(false);
                    break;
                case "*":
                    botonera.grupoBotones[10].setEnabled(false);
                    botonera.grupoBotones[11].setEnabled(false);
                    botonera.grupoBotones[13].setEnabled(false);
                    break;
                case "/":
                    for (int i = 10; i <= 12; i++) {
                        botonera.grupoBotones[i].setEnabled(false);
                    }
                    break;
                case "C":
                    for (int i = 10; i <= 13; i++) {
                        botonera.grupoBotones[i].setEnabled(true);
                    }
            }
            calcularResultado(((JButton) o));
        }
    }

    //metodo para calcular resultados
    public void calcularResultado(JButton bo) {

        //if para que filtran los botones para lueo dirigirlos a una estructura switch
        if (bo.getText().equals("=")) {
            if (areaTexto.getText().contains("+")) {
                entradaSwitch = 1;
            } else if (areaTexto.getText().contains("-")) {
                entradaSwitch = 2;
            } else if (areaTexto.getText().contains("*")) {
                entradaSwitch = 3;
            } else if (areaTexto.getText().contains("/")) {
                entradaSwitch = 4;
            }
            //estructura switch para realizar operaciones segun la operacion
            switch (entradaSwitch) {
                case 1:
                    bo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            var1 = areaTexto.getText().replace("+", "s");
                            array = var1.split("s");
                            for (int i = 0; i < array.length; i++) {
                                resultado += Double.parseDouble(array[i]);
                            }
                            areaTexto.setText(Double.toString(resultado));
                        }
                    });
                    break;
                case 2:
                    bo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            var1 = areaTexto.getText().replace("-", "r");
                            array = var1.split("r");
                            for (int i = 0; i < array.length; i++) {
                                resultado = Double.parseDouble(array[0]);
                                resultado -= Double.parseDouble(array[i]);
                            }
                            areaTexto.setText(Double.toString(resultado));
                        }
                    });
                    break;
                case 3:
                    bo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            var1 = areaTexto.getText().replace("*", "m");
                            array = var1.split("m");
                            resultado = 1;
                            for (int i = 0; i < array.length; i++) {
                                resultado *= Double.parseDouble(array[i]);
                            }
                            areaTexto.setText(Double.toString(resultado));
                        }
                    });
                    break;
                case 4:
                    bo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            var1 = areaTexto.getText().replace("/", "d");
                            array = var1.split("d");
                            for (int i = 0; i < array.length; i++) {
                                resultado = Double.parseDouble(array[0]);
                                resultado /= Double.parseDouble(array[i]);
//                                    resultado /= Double.parseDouble(array[i]);
                            }
                            areaTexto.setText(Double.toString(resultado));

                        }
                    });
                    break;
            }
            //al pulsar el boton C se resetea todo
        } else if (bo.getText().equals("C")) {
            var1 = "";
            areaTexto.setText("");
            resultado = 0;
            for (int i = 0; i < array.length; i++) {
                array[i] = "";
            }
            for (int i = 10; i <= 13; i++) {
                botonera.grupoBotones[i].setEnabled(true);
            }
        }

    }
}
