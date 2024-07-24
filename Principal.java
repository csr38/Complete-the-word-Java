public class Principal {
    public static void main(String[] args) {

        Vista v=new Vista();
        v.vistaPrincipal();
        Modelo m = new Modelo();
        m.escogerPosicionPalabra();
        m.escogerPalabra();
        Controlador ct = new Controlador(m,v);
        ct.iniciarVista();
        
  
    }
}
