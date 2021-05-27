package com.company;

import javax.swing.JFrame;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        int ancho=450;
        int altura=200;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = dim.width/2-ancho/2;
        int yPos = dim.height/2-altura/2;

        VentanaPrincipal Ventana1=new VentanaPrincipal();
        Ventana1.setBounds(xPos,yPos,ancho,altura);
        Ventana1.setVisible(true);
        Ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
