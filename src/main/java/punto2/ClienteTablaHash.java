/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto2;

import java.util.Map;
import punto1.TablaHash;

/**
 *
 * @author Usuario
 */
public class ClienteTablaHash {

    //agrega el main bobo xD
    public static void main(String[] args) {
        //Map<Integer, Integer> tablaHash =  new TablaHash<Integer, Integer>();       
        TablaHash<Integer, Integer> tablaHash =  new TablaHash<Integer, Integer>();
        tablaHash.put(1, 5);
        tablaHash.put(2, 33);
        tablaHash.put(3, 41);
        tablaHash.put(4, 72);
        tablaHash.put(1, 55);
        
        //Metodo toString()
        
        System.out.println("Metodo toString(): "+ tablaHash.toString());
        //Metodo remove()
        tablaHash.remove(1);
        System.out.println("Metodo remove(): "+ tablaHash.toString());

        //Metodo get()
        System.out.println("Metodo get(): "+ tablaHash.get(4));
        //Metodo contains()
        
        System.out.println("Metodo contains(): "+ tablaHash.contains(2));
        
        //Metodo size()
        System.out.println("Metodo size(): "+ tablaHash.size());
        //Metodo isFull()
        tablaHash.isFull();
        System.out.println("Metodo isFull(): "+ tablaHash.isFull());
        //Metodo makeEmpty()
        tablaHash.makeEmpty();
        System.out.println("Metodo makeEmpty(): "+ tablaHash.toString());
        
    }

}
