package punto3;

import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;

/**
 *
 * @author Fernando Medvedovsky, Fernando Horta, Ian Klaric
 * @param <T>
 */
public interface ArbolABBExtInterfaz<T extends Comparable<? super T>> {

    /**
     * Devuelve el valor del nodo con menor valor de clave.
     *
     * @return
     */
    public T min();

    /**
     * Devuelve el valor del nodo con mayor valor de clave.
     *
     * @return
     */
    public T max();

    /**
     * Elimina la rama del árbol que tiene como raíz el nodo pasado por
     * parámetro.
     *
     * @param nodo
     */
    public void eliminarRama(NodoABB<T> nodo);

    /**
     * Devuelve el ancestro compartido por los nodos x e y que se encuentra más
     * lejos de la raíz (más profundo).En caso que alguno de los nodos no
     * pertenezca al árbol devuelve null.
     *
     * @param x
     * @param y
     * @return
     */
    public NodoABB<T> menorAntecesorComun(NodoABB<T> x, NodoABB<T> y);

}
