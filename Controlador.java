
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class Controlador  implements ActionListener{
    private Modelo modelo;
    private Vista vista;
    private String palabraBuscar;
    private int validadorAntiEntero;
    private char caracterPasar;
    private String intentoBuenos;
    
    public  Controlador(Modelo modelo, Vista vista){
        this.vista=vista;
        this.modelo=modelo;
        
        this.vista.botonJugar.addActionListener(this);
        this.vista.textoEntrada.addActionListener(this);
    }
    
    
    public void iniciarVista() {
        vista.setDefaultCloseOperation(EXIT_ON_CLOSE);
        vista.setSize(1000, 500);
        vista.setTitle("Juego - Adivina la palabra");
        vista.setLayout(null);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setVisible(true);
        palabraBuscar = modelo.palabraTransformada();
        vista.textoPalabra.setText(palabraBuscar);
        vista.textoNumeroIntentos.setText("0");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.botonJugar){
            
            try{
                String Caracteres = vista.textoEntrada.getText(); 
                if(Caracteres.length()>=2){ 
                    JOptionPane.showMessageDialog(null, "Ingrese solamente un caracter");
                }
                try{
                    validadorAntiEntero=Integer.parseInt(Caracteres);
                     JOptionPane.showMessageDialog(null, "No se permiten entero");
                }catch(Exception en){
                    Caracteres=Caracteres.toLowerCase();
                    char caracterPasar = Caracteres.charAt(0);
                    modelo.letraEscogidad(caracterPasar);
                    palabraBuscar = modelo.actualizarPalabra();
                    vista.textoPalabra.setText(palabraBuscar);
                    intentoBuenos = modelo.actualizarIntentos();
                    vista.textoNumeroIntentos.setText(intentoBuenos);
                    
                }
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Ocurrio un error");
            }
            vista.textoEntrada.setText("");
            
            
        }
    }
}
