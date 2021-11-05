package punto2;

import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolABB;
import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.arbolesbinariosyheaps.NodoArbolBinario;
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
        var padre = this.obtenerNodoPadre(nodo.getValor());
        //Si no tiene hijos
        if (nodo.getCantidadHijos() == 0 && nodo.esHijoIzquierdo(padre)) {
            padre.setHijoIzquierdo(null);
        } else {
            padre.setHijoDerecho(null);
        }
        //Si tiene solamente un hijo
        if (nodo.tieneHijoDerecho() ^ nodo.tieneHijoIzquierdo()) {
            if (nodo.tieneHijoDerecho() && nodo.esHijoIzquierdo(padre)) {
                padre.setHijoIzquierdo(nodo.getHijoDerecho());
            } else if (nodo.tieneHijoDerecho() && !nodo.esHijoIzquierdo(padre)){
                padre.setHijoDerecho(nodo.getHijoIzquierdo());
            }
            if (nodo.tieneHijoIzquierdo() && !nodo.esHijoIzquierdo(padre)) {
                padre.setHijoDerecho(nodo.getHijoDerecho());
            } else if (nodo.tieneHijoIzquierdo() && !nodo.esHijoIzquierdo(padre)){
                padre.setHijoIzquierdo(nodo.getHijoIzquierdo());
            }
            
        }

    }

    @Override
    public NodoABB<T> menorAntecesorComun(NodoABB<T> x, NodoABB<T> y) {

        return null;

    }

    public NodoABB<T> obtenerNodoPadre(T valor) {
        var nodo = this.raiz;
        var iterador = this.iteradorEnPreOrden();
        while (iterador.existeSiguiente()) {
            if (nodo.getHijoIzquierdo().getValor().compareTo(valor) > 1) {
                if (nodo.getHijoIzquierdo().getValor().compareTo(valor) == 0) {
                    return nodo.getHijoIzquierdo();
                }
                nodo = nodo.getHijoIzquierdo();
            } else if (nodo.getHijoDerecho().getValor().compareTo(valor) < 1) {
                if (nodo.getHijoDerecho().getValor().compareTo(valor) == 0) {
                    return nodo.getHijoDerecho();
                }

                nodo = nodo.getHijoDerecho();
            } else {
                return nodo;
            }

            iterador.siguiente();
        }

        return null;
    }

}
