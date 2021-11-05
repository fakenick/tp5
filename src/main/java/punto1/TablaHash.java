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

    /**
     * ingresa un elemento a la clave pasando por parametro clave y valor
     * @param clave
     * @param valor 
     */
    @Override
    public void put(K clave, T valor) {
        if (!isFull()) {
            Map.entry(clave, valor);
        }
    }

    /**
     * remueve elemento pasandole la clave por parametro
     * @param clave
     */
    @Override
    public void remove(K clave) {
        if (tablaHash.containsKey(clave)) {
            tablaHash.remove(clave);
        }

    }

    /**
     * obtiene un elemento pasando la clave del elemento a consultar
     * @param clave
     * @return
     */
    @Override
    public T get(K clave) {
        return (T) tablaHash.get(clave);
    }

    /**
     * devuelve un bool para verificar si el elemento con la clave pasada por parametro esta en la tabla
     * @param clave
     * @return
     */
    @Override
    public boolean contains(K clave) {
        if (tablaHash.containsKey(clave)) {
            return true;
        }
        return false;
    }

    /**
     * vacia la tabla
     */
    @Override
    public void makeEmpty() {
        tablaHash.clear();
    }

    /**
     * devuelve el tamaño de la tabla
     * @return 
     */
    @Override
    public int size() {
        return tablaHash.size();
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "";
    }
}
