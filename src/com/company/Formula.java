package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formula extends JFrame implements ActionListener {
    private JLabel descripcion;
    private JLabel formulaJLabel;
    private JButton regresar;


    public Formula(int tForma,int tFormula,String nFormula){
        super("Formula");
        setLayout(null);

        descripcion = new JLabel("La formula del "+nFormula+" es:",SwingConstants.CENTER);
        descripcion.setBounds(10,10,300,30);
        add(descripcion);
        formulaJLabel = new JLabel(obtenerFormula(tForma,tFormula),SwingConstants.CENTER);
        formulaJLabel.setBounds(10,40,300,30);
        add(formulaJLabel);
        regresar = new JButton("Regresar");
        regresar.setBounds(110,120,100,30);
        add(regresar);
        regresar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()== regresar){
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int xPos = dim.width/2-this.getSize().width/2;
            int yPos = dim.height/2-this.getSize().height/2;
            Formas forma1=new Formas();
            forma1.setBounds(xPos,yPos,550,350);
            forma1.setVisible(true);
            forma1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        }

    }

    public String obtenerFormula(int tipoForma,int tipoFormula){
        String f = null;
        switch(tipoForma){
            case 0:
                if(tipoFormula==0){
                    f = "La suma de todos sus lados";
                }else if(tipoFormula==1){
                    f = "a^2";
                }
                break;
            case 1:
                if(tipoFormula==0){
                    f = "La suma de todos sus lados";
                }else if(tipoFormula==1){
                    f = "Base * Altura";
                }
                break;
            case 2:
                if(tipoFormula==0){
                    f = "La suma de todos sus lados";
                }else if(tipoFormula==1){
                    f = "Base*Altura/2";
                }
                break;
            case 3:
                if(tipoFormula==0){
                    f = "2*π*r";
                }else if(tipoFormula==1){
                    f = "π*r^2";
                }
                break;
            default:
        }

        return f;
    }
}
