package punto1;

/**
 * Interface Tabla Hash
 * @author Fernando Medvedovsky, Fernando Horta, Ian Klaric
 */
public interface TablaHashInterfaz<K, T> {

    public void put(K clave, T valor);

    public void remove(K clave);

    public T get(K clave);

    public boolean contains(K clave);

    public void makeEmpty();

    public int size();

    public boolean isFull();

    @Override
    public String toString();
}
