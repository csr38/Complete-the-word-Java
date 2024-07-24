/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.completetheword;

/**
 *
 * @author kelia
 */
public class CompleteTheWord {
    public static void main(String[] args) {
        // Crear la instancia de la vista
        Vista v = new Vista();
        // Configurar la vista
        v.vistaPrincipal();

        // Crear la instancia del modelo y configurar la palabra
        Modelo m = new Modelo();
        m.escogerPosicionPalabra();
        m.escogerPalabra();

        // Crear el controlador y pasarlo la vista y el modelo
        Controlador ct = new Controlador(m, v);
        // Iniciar la vista a través del controlador
        ct.iniciarVista();
    }
}
