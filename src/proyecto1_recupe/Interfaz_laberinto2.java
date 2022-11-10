/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_recupe;

import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author Luisp
 */
public class Interfaz_laberinto2 {
    private int fila = 0; //Aqui indico las dimensiones dle laberinto
    private int columna = 0;
    private final int numeroFilas = Interfaz_inicio.numero_filas;
    private final int numeroColumnas = Interfaz_inicio.numero_columnas ;
    private final int altoBloque = 40;
    private final int anchoBloque = 40;

    // Metodo para colorear los cuadros del laberinto 5x5
    public void paint(Graphics grafico) {
        int[][] laberinto = obtieneLaberinto();
        
        //Este primer for trabaja las filas y el anidado las columnas
        for (fila = 0; fila < numeroFilas; fila++) {
            for (columna = 0; columna < numeroColumnas; columna++) {
                if(laberinto[fila][columna] == 2){
                    grafico.setColor(Color.blue);
                    grafico.fillRect(columna*40, fila*40, anchoBloque, altoBloque); //El 40 es para agrandar la forma
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna*40, fila*40, anchoBloque, altoBloque); 
                }
                else if (laberinto[fila][columna] == 3) {
                grafico.setColor(Color.green);
                    grafico.fillRect(columna*40, fila*40, anchoBloque, altoBloque); //El 40 es para agrandar la forma
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna*40, fila*40, anchoBloque, altoBloque);
                }
                else if (laberinto[fila][columna] == 4) {
                grafico.setColor(Color.red);
                    grafico.fillRect(columna*40, fila*40, anchoBloque, altoBloque); //El 40 es para agrandar la forma
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna*40, fila*40, anchoBloque, altoBloque);
                }
            }
        }
    }
        //Metodo para obtener el laberinto
    // Se toman los Estados de los vertices adyacentes para imprimirlos.
    public int[][] obtieneLaberinto() {
    int laberinto[][]={}; 
    for (int i=0;i != numeroFilas;i++){
    if (i==0){
    for (int j=0;j!=numeroColumnas;j++){
    laberinto[i][j]=2;
    }
    }
    else if(i==numeroFilas-2){
    for (int j=0;j!=numeroColumnas;j++){
    laberinto[i][j]=2;
    }   
    }
    else{
    for (int j=0;j!=numeroColumnas;j++){
    if(j==0){
    laberinto[i][j]=2;
    }
    else if(j==numeroColumnas-2){
    laberinto[i][j]=2;
    }
    else{
    int variable1 = i-1;
    int variable2 = numeroColumnas * variable1;
    int variable3 = variable2 + j;
    laberinto[i][j]=Interfaz_inicio.listagrande.buscar(variable3).getEstado();
    }
    }
    }
    }
    return laberinto;
    }
    
}
