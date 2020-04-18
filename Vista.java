import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista extends JFrame{
    JPanel panelPrincipal, panelUno, panelDos;
    JLabel textoIngresar, textoLaPalabraEs, textoPalabra,textoIntentos, textoNumeroIntentos;
    JTextField textoEntrada;
    JButton botonJugar;
    
    public void vistaPrincipal(){
        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(0, 0, 1000, 500);
        panelPrincipal.setBackground(Color.white);
        panelPrincipal.setLayout(null);
        
        //=========================PANEL UNO=============
        panelUno = new JPanel();
        panelUno.setBounds(0, 0, 350, 500);
        panelUno.setBackground(Color.LIGHT_GRAY);
        panelUno.setLayout(null);
        
        textoIngresar = new JLabel("Ingrese una Letra");
        textoIngresar.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 36));
        textoIngresar.setBounds(10,30,340,50);
        textoIngresar.setForeground(Color.black);
        
        textoEntrada =new JTextField();
        textoEntrada.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 90));
        textoEntrada.setBounds(120, 140, 110,110);
        
        botonJugar = new JButton("jugar");
        botonJugar.setBounds(120, 300, 110,50);
        botonJugar.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 25));
        
        //======================PANEL DOS=============================
        panelDos =new JPanel();
        panelDos.setBounds(350, 0, 650, 500);
        panelDos.setBackground(Color.white);
        panelDos.setLayout(null);
        
        textoLaPalabraEs = new JLabel("La palabra es:");
        textoLaPalabraEs.setBounds(10,32,300,50);
        textoLaPalabraEs.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 25));
        textoLaPalabraEs.setForeground(Color.black);
        
        textoPalabra = new JLabel();
        textoPalabra.setBounds(20,150,620,100);
        textoPalabra.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 60));
        textoPalabra.setForeground(Color.black);
        
        textoIntentos = new JLabel("Intentos: ");
        textoIntentos.setBounds(400,370,200,100);
        textoIntentos.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
        textoIntentos.setForeground(Color.black);
        
        textoNumeroIntentos = new JLabel();
        textoNumeroIntentos.setBounds(500,370,200,100);
        textoNumeroIntentos.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
        textoNumeroIntentos.setForeground(Color.black);
        
                
        panelUno.add(botonJugar);
        panelUno.add(textoIngresar);
        panelUno.add(textoEntrada);
        
        panelDos.add(textoPalabra);
        panelDos.add(textoLaPalabraEs);
        panelDos.add(textoIntentos);
        panelDos.add(textoNumeroIntentos);
        
        panelPrincipal.add(panelDos);
        panelPrincipal.add(panelUno);
        
        add(panelPrincipal);
        
    }

    public void letraEscogidad(Character caracter) {
        bandera = 0;
        for (int i = 0; i < arregloLetraEscogida.size(); i++) {
            if (caracter == arregloLetraEscogida.get(i)) {
                bandera++;
            }
        }
        if (bandera == 1) {
            JOptionPane.showMessageDialog(null, "Ese caracter ya lo escogio");
        } else if (bandera == 0) {
            arregloLetraEscogida.add(caracter);
            intentos--;
            Character ch = '_';
            for (int i = 0; i < arregloPalabra.size(); i++) {
                if (arregloPalabra.get(i).equals(caracter)) {
                    if (arregloPalabraModificada.get(i).equals(ch)) {
                        arregloPalabraModificada.set(i, caracter);
                        aciertos++;
                    }
                    if (i == 0) {
                        intentos++;
                    }
                }
            }
        }
    }
    
}
