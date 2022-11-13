/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_recupe;

/**
 * Esta clase tiene los atributos necesarios para la creacion de cada uno de los vertices. 
 * @author Sebastian Rodriguez, Frank Caicedo y Luis Pernia.
 */
// Creamos la clase vertice con sus constructores.
public class Vertice {
    private int numVertice;
    private Vertice pNext;
    private Vertice pPrev;
    private Lista lista_adyacencia;
    private int estado;

    public Vertice(int numVertice, Lista lista_adyacencia) {
        this.numVertice = numVertice;
        this.lista_adyacencia = lista_adyacencia;
        this.pNext = null;
        this.pPrev = null;
        this.estado = 0;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Vertice getpPrev() {
        return pPrev;
    }

    public void setpPrev(Vertice pPrev) {
        this.pPrev = pPrev;
    }

    public Vertice getpNext() {
        return pNext;
    }

    public void setpNext(Vertice pNext) {
        this.pNext = pNext;
    }

    public Lista getlista_adyacencia() {
        return lista_adyacencia;
    }

    public void setlista_adyacencia(Lista lista_adyacencia) {
        this.lista_adyacencia = lista_adyacencia;
    }
    

    public int getNumVertice() {
        return numVertice;
    }

    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }
    
    
}
