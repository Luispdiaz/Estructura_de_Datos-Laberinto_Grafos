/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_recupe;

/**
 * Esta clase define la creacion del grafo con las listas de adyacencia.
 * @author Luis Pernia, Sebastian Rodriguez y Frank Caicedo.
 */
public class Grafo {
    Lista ListaFinal;

    public Grafo(Lista ListaFinal) {
        this.ListaFinal = ListaFinal;
    }

    public Lista getListaFinal() {
        return ListaFinal;
    }

    public void setListaFinal(Lista ListaFinal) {
        this.ListaFinal = ListaFinal;
    }
    
    
}
