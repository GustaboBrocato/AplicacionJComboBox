package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.*;

public class Formas extends JFrame implements ActionListener {
    private final JComboBox<String> imagenesJComboBox;
    private final JComboBox<String> formulasJComboBox;
    private final JLabel etiqueta;
    private String png = ".png";
    public int tForma, tFormula;
    private JLabel instrucciones;
    private static final String tipoFormula[] = {"Perimetro","Area"};
    private static final String nombres[] =
            {"Cuadrado", "Rectangulo", "Triangulo", "Circulo"};
    private JButton Aplicar,regresar;
    private final Icon[] iconos = {
            new ImageIcon(getClass().getResource(nombres[0]+png)),
            new ImageIcon(getClass().getResource(nombres[1]+png)),
            new ImageIcon(getClass().getResource(nombres[2]+png)),
            new ImageIcon(getClass().getResource(nombres[3]+png))};

    public Formas(){
        super("Formas Geometricas");
        setLayout(null);

        instrucciones = new JLabel("Haga click en la flechita para ver las opciones de formas geometricas disponibles");
        instrucciones.setBounds(10,10,480,30);
        add(instrucciones);
        imagenesJComboBox = new JComboBox<String>(nombres);
        imagenesJComboBox.setMaximumRowCount(4);
        imagenesJComboBox.setBounds(200,40,100,30);

        imagenesJComboBox.addItemListener(
                new ItemListener()
                {
                    @Override
                    public void itemStateChanged(ItemEvent evento)
                    {
                        if (evento.getStateChange() == ItemEvent.SELECTED){
                            etiqueta.setIcon(iconos[
                                    imagenesJComboBox.getSelectedIndex()]);
                            tForma=imagenesJComboBox.getSelectedIndex();
                        }
                    }
                }
        );
        add(imagenesJComboBox);
        etiqueta = new JLabel(iconos[0]);
        etiqueta.setBounds(150,50,200,200);
        add(etiqueta);
        formulasJComboBox = new JComboBox<String>(tipoFormula);
        formulasJComboBox.setMaximumRowCount(2);
        formulasJComboBox.setBounds(200,220,100,30);
        formulasJComboBox.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent evento) {
                        if(evento.getStateChange() == ItemEvent.SELECTED){
                            tFormula=formulasJComboBox.getSelectedIndex();
                        }
                    }
                }
        );
        add(formulasJComboBox);

        Aplicar = new JButton("Obtener Formula");
        Aplicar.setBounds(10,280,150,30);
        add(Aplicar);
        Aplicar.addActionListener(this);
        regresar = new JButton("Regresar");
        regresar.setBounds(375,280,150,30);
        add(regresar);
        regresar.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==Aplicar){
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int xPos = dim.width/2-this.getSize().width/2;
            int yPos = dim.height/2-this.getSize().height/2;
            Formula formula1=new Formula(tForma,tFormula,nombrarFormula(tForma,tFormula));
            formula1.setBounds(xPos,yPos,350,200);
            formula1.setVisible(true);
            formula1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        } else if(e.getSource()==regresar){
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int xPos = dim.width/2-this.getSize().width/2;
            int yPos = dim.height/2-this.getSize().height/2;
            VentanaPrincipal Ventana1=new VentanaPrincipal();
            Ventana1.setBounds(xPos,yPos,450,200);
            Ventana1.setVisible(true);
            Ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        }
    }
    public String nombrarFormula(int tipoForma,int tipoFormula){
        String f = null;
        switch(tipoForma){
            case 0:
                if(tipoFormula==0){
                    f = "perimetro de un cuadrado";
                }else if(tipoFormula==1){
                    f = "area de un cuadrado";
                }
                break;
            case 1:
                if(tipoFormula==0){
                    f = "perimetro de un rectangulo";
                }else if(tipoFormula==1){
                    f = "area de un cuadrado";
                }
                break;
            case 2:
                if(tipoFormula==0){
                    f = "perimetro de un triangulo";
                }else if(tipoFormula==1){
                    f = "area de un triangulo";
                }
                break;
            case 3:
                if(tipoFormula==0){
                    f = "perimetro de un circulo";
                }else if(tipoFormula==1){
                    f = "area de un circulo";
                }
                break;
        }

        return f;
    }
}
