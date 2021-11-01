/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto1;

import java.util.Map;

/**
 *
 * @author Fernando Medvedovsky, Fernando Horta, Ian Klaric
 * @param <K>
 * @param <T>
 */
public class TablaHash<K, T> implements TablaHashInterfaz<K, T> {

    Map<Integer, Integer> tablaHash;

    @Override
    public void put(K clave, T valor) {
        if (!isFull()) {
            Map.entry(clave, valor);
        }
    }

    @Override
    public void remove(K clave) {
        
    }

    @Override
    public T get(K clave) {
        return (T) tablaHash.get(clave);
    }

    @Override
    public boolean contains(K clave) {
        if(tablaHash.containsKey(clave)){
            return true;
        }
        return false;
    }

    @Override
    public void makeEmpty() {
        tablaHash.
    }

    @Override
    public int size() {
        return tablaHash.size();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }
}
