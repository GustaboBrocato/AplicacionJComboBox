package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener{

    private JLabel Bienvenida, Instruccion;
    private JButton CrearColor, mostrarForma;

    public VentanaPrincipal(){
        setLayout(null);
        Bienvenida = new JLabel("Bienvenido!",SwingConstants.CENTER);
        Bienvenida.setBounds(10,10,400,30);
        add(Bienvenida);
        Instruccion = new JLabel("Porfavor haga click en el en el boton de la accion que desea realizar: ",SwingConstants.CENTER);
        Instruccion.setBounds(10,30,400,30);
        add(Instruccion);
        CrearColor = new JButton("Crear Color");
        CrearColor.setBounds(10,100,100,30);
        add(CrearColor);
        CrearColor.addActionListener(this);
        mostrarForma = new JButton("Formas Geometricas");
        mostrarForma.setBounds(250,100,160,30);
        add(mostrarForma);
        mostrarForma.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        int xPos;
        int yPos;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        xPos = dim.width/2-this.getSize().width/2;
        yPos = dim.height/2-this.getSize().height/2;
        if(e.getSource() == CrearColor){
            Formulario formulario1=new Formulario();
            formulario1.setBounds(xPos,yPos,550,300);
            formulario1.setVisible(true);
            formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        }else if(e.getSource() == mostrarForma){
            Formas forma1=new Formas();
            forma1.setBounds(xPos,yPos,550,350);
            forma1.setVisible(true);
            forma1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        }
    }

}
