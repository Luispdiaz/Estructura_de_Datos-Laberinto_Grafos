/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_recupe;

/**
 *
 * @author Frank Caicedo
 */

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Frank Caicedo
 */
public class Interfaz_Juego extends JPanel { //Esta clase va a heredar los atributos de JPanel
    Interfaz_Laberinto1 laberinto = new Interfaz_Laberinto1();
    
   @Override //Esto indica que hereda de JPanel (metodo)
    public void paint(Graphics grafico){//Esto nos permite dibujar en el JPanel
        laberinto.paint_1(grafico);   
    }
    
    
    //Esta es la ventana 
    public static void main(String[] args){
        JFrame miventana = new JFrame("Laberinto");
        Interfaz_Juego game = new Interfaz_Juego();
        miventana.add(game);
        miventana.setSize(400,400); //Tamanio de la ventana
        miventana.setVisible(true);
        miventana.setLocationRelativeTo(null);
        miventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
