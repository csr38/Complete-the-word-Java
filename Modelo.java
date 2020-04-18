//Descomentar linea 53 para pruebas
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Modelo extends Vista {
    protected int contador=0;
    protected int numEscogido;
    protected String cadena,result="";
    protected int binario, bandera;
    protected int intentos=0;
    protected String intentosParseado="";
    protected int aciertos=0;
    protected int porLograr=0;
    protected String archivos="archivo.txt";
    protected String archivoEscribir="saveData.txt";
    
    
    ArrayList<String> arregloLetrasBuscar = new ArrayList<String>();
    ArrayList<Character> arregloPalabra = new ArrayList<Character>();
    ArrayList<Character> arregloPalabraModificada = new ArrayList<Character>();
    ArrayList<Character> arregloLetraEscogida = new ArrayList<Character>();
    
    public void escogerPosicionPalabra(){
        try {
            FileReader lector = new FileReader(archivos);
            BufferedReader BR = new BufferedReader(lector);

            while ((cadena = BR.readLine()) != null) {
                contador++;
            }
            
            numEscogido = (int) (Math.random()*contador+ 1);
            BR.close();
            lector.close();
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "No se encontro el archivo");
             System.exit(0);
        }
    }
    
    public String escogerPalabra(){
        try{
 
            FileReader lector = new FileReader(archivos);
            BufferedReader BR = new BufferedReader(lector);
            for(int i=0;i<numEscogido;i++){
                cadena=BR.readLine();
            }
            //System.out.println(cadena);
            return cadena;
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "No se encontro el archivo");
             System.exit(0);
            return null;
        }
        
        
    }
    public String palabraTransformada(){
        for (int i =0;i<cadena.length();i++){
            arregloPalabra.add(cadena.charAt(i));
        }
        bandera =0;
        for(int i = 0;i<arregloPalabra.size();i++){
           
            binario = (int) (Math.random()*2);
            if(binario==1){
                arregloPalabraModificada.add(arregloPalabra.get(i));
            }else if(binario  ==0 ){
                Character ch = '_';
                arregloPalabraModificada.add(ch);
                bandera++;
                porLograr++;
            }
        }
        if(bandera==0){
            Character ch = '_';
            arregloPalabraModificada.set(0,ch);
            porLograr++;
        }
        for (int i=0;i<arregloPalabraModificada.size();i++){
            result = result+String.valueOf(arregloPalabraModificada.get(i));
        }
        return result;
    }
    
    public void letraEscogidad(Character caracter){
        bandera=0;
        for(int i=0;i<arregloLetraEscogida.size();i++){
            if(caracter==arregloLetraEscogida.get(i)){
                bandera++;
            }
        }
        
        if(bandera==1){
            JOptionPane.showMessageDialog(null, "Ese caracter ya lo escogio");
        }else if(bandera==0){
            
            arregloLetraEscogida.add(caracter);
            intentos++;
            Character ch = '_';
            for (int i=0;i<arregloPalabra.size();i++){
                
                if(arregloPalabra.get(i).equals(caracter)){
                    if(arregloPalabraModificada.get(i).equals(ch)){
                        
                        arregloPalabraModificada.set(i, caracter);
                        aciertos++;
                        
                    }
                }
            }
            
        }

    }
    public String actualizarPalabra(){
        result="";
        for (int i=0;i<arregloPalabraModificada.size();i++){
            result = result+String.valueOf(arregloPalabraModificada.get(i));
        }
        return result;
    }
    public String actualizarIntentos(){
        try{
            intentosParseado = Integer.toString(intentos);
            if(aciertos==porLograr){
                JOptionPane.showMessageDialog(null, "Ha logrado adivinar la palabra en: "+intentosParseado+" intentos");
                saveData();
            }
            return intentosParseado;
        }catch(Exception ex){
            return null;
        }
        
        
    }
    public void saveData() throws IOException{
        FileWriter ficheroGuardado = new FileWriter(archivoEscribir, true);
        ficheroGuardado.append("Palabra: "+cadena+" Intentos: "+intentosParseado+"\n");
        ficheroGuardado.close();
        System.exit(0);
    }
}
