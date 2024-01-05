package estructura.lista;

public class Nodo<E> {
    
    private E dato;
    private Nodo<E> siguiente;

    public Nodo() {
        siguiente = null;
    }

    public Nodo(E data) {
        this.dato = data;
        siguiente = null;
    }

    public Nodo(E data, Nodo<E> next) {
        this.dato = data;
        this.siguiente = next;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public Nodo<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }
    
}
