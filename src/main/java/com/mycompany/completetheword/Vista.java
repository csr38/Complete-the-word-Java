package com.mycompany.completetheword;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista extends JFrame {
    // Componentes de la vista
    JPanel panelPrincipal, panelUno, panelDos;
    JLabel textoIngresar, textoLaPalabraEs, textoPalabra, textoIntentos, textoNumeroIntentos;
    JTextField textoEntrada;
    JButton botonJugar;

    // Constructor
    public Vista() {
        // Configurar la ventana principal
        setTitle("Juego - Adivina la Palabra");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }

    // Método para configurar la vista
    public void vistaPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(0, 0, 1000, 500);
        panelPrincipal.setBackground(Color.white);
        panelPrincipal.setLayout(null);
        
        // Configuración del Panel Uno
        panelUno = new JPanel();
        panelUno.setBounds(0, 0, 350, 500);
        panelUno.setBackground(Color.LIGHT_GRAY);
        panelUno.setLayout(null);

        textoIngresar = new JLabel("Ingrese una Letra");
        textoIngresar.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 36));
        textoIngresar.setBounds(10, 30, 330, 50);
        textoIngresar.setForeground(Color.black);

        textoEntrada = new JTextField();
        textoEntrada.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 90));
        textoEntrada.setBounds(120, 140, 110, 110);
        textoEntrada.setHorizontalAlignment(JTextField.CENTER);

        botonJugar = new JButton("Jugar");
        botonJugar.setBounds(70, 270, 210, 50);
        botonJugar.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 25));
        botonJugar.setBackground(new Color(100, 150, 255));
        botonJugar.setForeground(Color.white);

        // Configuración del Panel Dos
        panelDos = new JPanel();
        panelDos.setBounds(350, 0, 650, 500);
        panelDos.setBackground(Color.white);
        panelDos.setLayout(null);

        textoLaPalabraEs = new JLabel("La palabra es:");
        textoLaPalabraEs.setBounds(20, 30, 300, 50);
        textoLaPalabraEs.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 25));
        textoLaPalabraEs.setForeground(Color.black);

        textoPalabra = new JLabel();
        textoPalabra.setBounds(20, 100, 600, 100);
        textoPalabra.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 60));
        textoPalabra.setForeground(Color.black);

        textoIntentos = new JLabel("Intentos:");
        textoIntentos.setBounds(400, 370, 200, 50);
        textoIntentos.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
        textoIntentos.setForeground(Color.black);

        textoNumeroIntentos = new JLabel();
        textoNumeroIntentos.setBounds(550, 370, 100, 50);
        textoNumeroIntentos.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
        textoNumeroIntentos.setForeground(Color.black);

        // Añadir componentes a los paneles
        panelUno.add(textoIngresar);
        panelUno.add(textoEntrada);
        panelUno.add(botonJugar);

        panelDos.add(textoLaPalabraEs);
        panelDos.add(textoPalabra);
        panelDos.add(textoIntentos);
        panelDos.add(textoNumeroIntentos);

        panelPrincipal.add(panelUno);
        panelPrincipal.add(panelDos);

        add(panelPrincipal);
    }

    // Métodos getter para acceder a los componentes (si es necesario)
    public JTextField getTextoEntrada() {
        return textoEntrada;
    }

    public JButton getBotonJugar() {
        return botonJugar;
    }

    public JLabel getTextoPalabra() {
        return textoPalabra;
    }

    public JLabel getTextoNumeroIntentos() {
        return textoNumeroIntentos;
    }
}
