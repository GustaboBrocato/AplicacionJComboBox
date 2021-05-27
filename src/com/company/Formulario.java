package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Formulario extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, instrucciones;
    private JComboBox<String> combo1, combo2, combo3;
    private JButton boton1,regresar;

    public Formulario() {
        super("Crear un Color");
        setLayout(null);
        instrucciones = new JLabel("Utilize las differentes cajitas para escojer un numero entre 0 y 255 y precione Fijar Color",SwingConstants.CENTER);
        instrucciones.setBounds(10,10,500,30);
        add(instrucciones);
        label1 = new JLabel("Rojo:");
        label1.setBounds(10, 60, 100, 30);
        add(label1);
        combo1 = new JComboBox<String>();
        combo1.setBounds(420, 60, 50, 30);
        for (int f = 0; f <= 255; f++) {
            combo1.addItem(String.valueOf(f));
        }
        add(combo1);
        label2 = new JLabel("Verde:");
        label2.setBounds(10, 100, 100, 30);
        add(label2);
        combo2 = new JComboBox<String>();
        combo2.setBounds(420, 100, 50, 30);
        for (int f = 0; f <= 255; f++) {
            combo2.addItem(String.valueOf(f));
        }
        add(combo2);
        label3 = new JLabel("Azul:");
        label3.setBounds(10, 140, 100, 30);
        add(label3);
        combo3 = new JComboBox<String>();
        combo3.setBounds(420, 140, 50, 30);
        for (int f = 0; f <= 255; f++) {
            combo3.addItem(String.valueOf(f));
        }
        add(combo3);
        boton1 = new JButton("Fijar Color");
        boton1.setBounds(200, 180, 100, 50);
        add(boton1);
        boton1.addActionListener(this);
        regresar = new JButton("Regresar");
        regresar.setBounds(390,190,120,30);
        add(regresar);
        regresar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            String cad1 = (String) combo1.getSelectedItem();
            String cad2 = (String) combo2.getSelectedItem();
            String cad3 = (String) combo3.getSelectedItem();
            int rojo = Integer.parseInt(cad1);
            int verde = Integer.parseInt(cad2);
            int azul = Integer.parseInt(cad3);
            Color color1 = new Color(rojo, verde, azul);
            boton1.setBackground(color1);
        } else if(e.getSource() == regresar){
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
}
