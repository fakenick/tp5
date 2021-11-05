package punto2;

import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolABB;
import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import punto3.ArbolABBExtInterfaz;

/**
 *
 * @author Fernando Medvedovsky, Fernando Horta, Ian Klaric
 * @param <T>
 */
public class ArbolABBExt<T extends Comparable<? super T>> extends ArbolABB<T>
        implements ArbolABBExtInterfaz<T> {

    //Devuelve el valor del nodo con menor valor de clave.
    @Override
    public T min() {
        if (this.isEmpty()) {
            return null;
        }

        if (this.raiz.getCantidadHijos() == 0) {
            return this.raiz.getValor();
        }
        var iterador = this.iteradorEnPreOrden();
        var nodo = this.raiz.getHijoIzquierdo();
        var min = this.raiz.getHijoIzquierdo().getValor();
        while (iterador.existeSiguiente()) {
            if (nodo.tieneHijoIzquierdo()) {
                nodo = nodo.getHijoIzquierdo();
                min = nodo.getHijoIzquierdo().getValor();
            }
            iterador.siguiente();
        }

        return min;
    }

    @Override
    public T max() {
        if (this.isEmpty()) {
            return null;
        }

        if (this.raiz.getCantidadHijos() == 0) {
            return this.raiz.getValor();
        }
        var iterador = this.iteradorEnPreOrden();
        var nodo = this.raiz.getHijoDerecho();
        var max = this.raiz.getHijoDerecho().getValor();
        while (iterador.existeSiguiente()) {
            if (nodo.tieneHijoDerecho()) {
                nodo = nodo.getHijoDerecho();
                max = nodo.getHijoDerecho().getValor();
            }
            iterador.siguiente();
        }

        return max;

    }

    @Override
    public void eliminarRama(NodoABB<T> nodo) {
        var Padre = this.obtenerNodoPadre(nodo);
        this.borrarNodo(Padre, nodo);
    }

    /**
     * Devuelve el ancestro compartido por los nodos x e y que se encuentra más
     * lejos de la raíz (más profundo). En caso que alguno de los nodos no
     * pertenezca al árbol devuelve null.
     */
    @Override
    public NodoABB<T> menorAntecesorComun(NodoABB<T> x, NodoABB<T> y) {

        return null;

    }

    public NodoABB<T> obtenerNodoPadre(NodoABB<T> nodo) {
        var aux = this.raiz;
        var iterador = this.iteradorEnPreOrden();
        while (iterador.existeSiguiente()) {
            if (aux.getHijoIzquierdo().getValor().compareTo(nodo.getValor()) > 1) {
                if (aux.getHijoIzquierdo().getValor().compareTo(nodo.getValor()) == 0) {
                    return nodo.getHijoIzquierdo();
                }
                aux = nodo.getHijoIzquierdo();
            } else if (aux.getHijoDerecho().getValor().compareTo(nodo.getValor()) < 1) {
                if (aux.getHijoDerecho().getValor().compareTo(nodo.getValor()) == 0) {
                    return nodo.getHijoDerecho();
                }

                aux = nodo.getHijoDerecho();
            } else {
                return aux;
            }

            iterador.siguiente();
        }

        return null;
    }

    public NodoABB<T> obtenerNodoAntecesor(NodoABB<T> nodo) {
        nodo = nodo.getHijoIzquierdo();

        while (nodo.tieneHijoDerecho()) {
            nodo = nodo.getHijoDerecho();
        }

        return nodo;
    }
}
