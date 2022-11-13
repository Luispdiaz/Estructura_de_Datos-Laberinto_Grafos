/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_recupe;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Sebas
 */
public class Interfaz_Laberinto1 {

    private int fila = 0; //Aqui indico las dimensiones dle laberinto
    private int columna = 0;
    private final int numeroFilas = Interfaz_inicio.numero_filas;
    private final int numeroColumnas = Interfaz_inicio.numero_columnas;
    private final int altoBloque = 40;
    private final int anchoBloque = 40;

    // Metodo para colorear los cuadros del laberinto 5x5
    public void paint_1(Graphics grafico) {
        int[][] laberinto = obtieneLaberinto();
        //Este primer for trabaja las filas y el anidado las columnas
        for (fila = 0; fila < numeroFilas; fila++) {
            for (columna = 0; columna < numeroColumnas; columna++) {
                if (laberinto[fila][columna] == 2) {
                    grafico.setColor(Color.blue);
                    grafico.fillRect(columna * 40, fila * 40, anchoBloque, altoBloque); //El 40 es para agrandar la forma
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna * 40, fila * 40, anchoBloque, altoBloque);
                } else if (laberinto[fila][columna] == 3) {
                    grafico.setColor(Color.green);
                    grafico.fillRect(columna * 40, fila * 40, anchoBloque, altoBloque); //El 40 es para agrandar la forma
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna * 40, fila * 40, anchoBloque, altoBloque);
                } else if (laberinto[fila][columna] == 4) {
                    grafico.setColor(Color.red);
                    grafico.fillRect(columna * 40, fila * 40, anchoBloque, altoBloque); //El 40 es para agrandar la forma
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna * 40, fila * 40, anchoBloque, altoBloque);
                }
            }
        }
    }
    //Metodo para obtener el laberinto
    // Se toman los Estados de los vertices adyacentes para imprimirlos.

    public int[][] obtieneLaberinto() {
        int laberinto[][] = new int[numeroFilas][numeroColumnas];
        int cont = 1;
        for (int i = 0; i != numeroFilas; i++) {
            if (i == 0) {
                for (int j = 0; j != numeroColumnas; j++) {
                    laberinto[i][j] = 2;
                }
            } else if (i == numeroFilas - 1) {
                for (int j = 0; j != numeroColumnas; j++) {
                    laberinto[i][j] = 2;
                }
            } else {
                for (int j = 0; j != numeroColumnas; j++) {
                    if (j == 0) {
                        laberinto[i][j] = 2;
                    } else if (j == numeroColumnas - 1) {
                        laberinto[i][j] = 2;
                    } else {
                        laberinto[i][j] = Interfaz_inicio.lista_disponible.buscar(cont).getEstado();
                        cont += 1;
                    }
                    }
                }
            }
        Random rnd = new Random();
        boolean auxboolean = rnd.nextBoolean();
        if (auxboolean) {
            int auxientrada = rnd.nextInt(1, numeroFilas-1);
            int auxisalida = rnd.nextInt(1, numeroFilas-1);
            int auxjentrada = 0;
            int auxjsalida = numeroColumnas - 1;
            laberinto[auxientrada][auxjentrada] = 3;
            laberinto[auxisalida][auxjsalida] = 4;
        } else {
            int auxjentrada = rnd.nextInt(1, numeroColumnas-1);
            int auxjsalida = rnd.nextInt(1, numeroColumnas-1);
            int auxientrada = 0;
            int auxisalida = numeroFilas - 1;
            laberinto[auxientrada][auxjentrada] = 3;
            laberinto[auxisalida][auxjsalida] = 4;    
    }
        return laberinto;
    }
}