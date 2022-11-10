/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_recupe;

import java.util.Random;

/**
 *
 * @author Luisp
 */

// Se contruye la clase Lista con sus constructores
public class Lista {

    private Vertice pFirst;
    private Vertice pLast;
    private int cantidad;
    static Vertice vOrigen;
    static Vertice vFinal;

    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.cantidad = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Vertice getpFirst() {
        return pFirst;
    }

    public Vertice getpLast() {
        return pLast;
    }

    public void setpLast(Vertice pLast) {
        this.pLast = pLast;
    }

    public void setpFirst(Vertice pFirst) {
        this.pFirst = pFirst;
    }
    
    // Metodo para verificar si la lista esta vacia.
    public boolean vacio() {
        return this.getpFirst() == null;
    }
    
    // Metodo para insertar Vertice.
    public void insertar(Vertice nuevo) {
        if (!this.vacio()) {
            Vertice aux = this.getpLast();
            aux.setpNext(nuevo);
            this.setpLast(nuevo);
            this.getpLast().setpPrev(aux);
            this.setCantidad(this.getCantidad() + 1);
        } else {
            this.setpFirst(nuevo);
            this.setpLast(nuevo);
            this.setCantidad(1);
        }
    }
    
    // Metodo para buscar un Vertice.
    public Vertice buscar(int posicion) {
        Vertice aux = this.getpFirst();
        for (int i = 1; i < posicion; i++) {
            aux = aux.getpNext();
        }
        return aux;
    }
    
    // Metodo para buscar arriba.
    public Vertice buscarArriba(int numVertice, int input) {
        Vertice aux = this.getpFirst();
        while (aux != this.buscar(numVertice - input)) {
            aux = aux.getpNext();
        }
        return aux;
    }
    
    // Metodo para buscar abajo.
    public Vertice buscarAbajo(int numVertice, int input) {
        Vertice aux = this.getpFirst();
        while (aux != this.buscar(input + numVertice)) {
            aux = aux.getpNext();
        }
        return aux;
    }
    
    // Metodo random para obtener la esquina que sera el inicio del laberinto.
    public Vertice getEsquina(int constante, int input) {
        Random rnd = new Random();
        while (true) {
            int aux = rnd.nextInt(constante);
            if (aux == 1) {
                return this.buscar(aux);
            } else if (aux == input) {
                return this.buscar(aux);
            } else if (aux == input * input + 1 - input) {
                return this.buscar(aux);
            } else if (aux == input * input) {
                return this.buscar(aux);
            }
        }

    }
    
    // Metodo para encontrar la esquina contraria que sera el final del laberinto.
    public Vertice getEsquinacontraria(int constante, int input) {
        if (constante == 1) {
            return this.getpLast();
        } else if (constante == input) {
            return this.buscar(input * input + 1 - input);
        } else if (constante == input * input + 1 - input) {
            return this.buscar(input);
        } else if (constante == input * input) {
            return this.buscar(1);
        }
        return null;
    }
    
    // Algoritmo de prim.
    public Lista arbolExpMinPrim(int input) {
        int VerticesTotales = this.getCantidad();
        Lista listaadyacencia2 = new Lista();
        vOrigen = new Vertice(0, listaadyacencia2);
        vOrigen = this.getEsquina(VerticesTotales, input);
        vOrigen.setEstado(3);
        vFinal = new Vertice(0, listaadyacencia2);
        vFinal = this.getEsquinacontraria(vOrigen.getNumVertice(), input);
        vFinal.setEstado(4);
        Lista gNuevo = new Lista();
        for (Vertice i = this.getpFirst(); i != null; i = i.getpNext()) {
            Lista listaadyacencia = new Lista();
            Vertice nuevo = new Vertice(i.getNumVertice(), listaadyacencia);
            if (i.getEstado() != 2) {
                i.setEstado(1);
                OUTER:
                for (Vertice j = i.getlista_adyacencia().getpFirst(); j != null; j = j.getpNext()) {
                    Vertice aux = this.getpFirst();
                    while (aux.getNumVertice() != j.getNumVertice()) {
                        aux = aux.getpNext();
                    }
                    switch (aux.getEstado()) {
                        case 1 -> {
                            Vertice nuevoadyacencia2 = this.CopiarDato(j);
                            nuevo.getlista_adyacencia().insertar(nuevoadyacencia2);
                        }
                        case 2 -> {
                            break OUTER;
                        }
                        default -> {
                            Random rd = new Random();
                            boolean aux1 = rd.nextBoolean();
                            if (aux1 == true) {
                                Vertice nuevoadyacencia = this.CopiarDato(j);
                                nuevo.getlista_adyacencia().insertar(nuevoadyacencia);
                                Vertice aux3 = this.getpFirst();
                                while (aux3.getNumVertice() != j.getNumVertice()) {
                                    aux3 = aux3.getpNext();
                                }
                                aux3.setEstado(1);
                            } else {
                                Vertice aux2 = this.getpFirst();
                                while (aux2.getNumVertice() != j.getNumVertice()) {
                                    aux2 = aux2.getpNext();
                                }
                                aux2.setEstado(2);
                            }
                        }
                    }
                }
            }
            gNuevo.insertar(nuevo);
        }
        return gNuevo;
    }
    
    // Metodo para copiar los valores de un Vertice. 
    public Vertice CopiarDato(Vertice nodo) {
        Lista listaadyacencia = new Lista();
        Vertice nuevo = new Vertice(nodo.getNumVertice(), listaadyacencia);
        return nuevo;
    }
}
