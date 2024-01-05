package estructura.lista;

public class Lista<E> {
    
    private Nodo<E> cabeza;
    private Nodo<E> cola;
    private int longitud;

    public Lista(){
        this.cabeza = null;
        this.cola = null;
        this.longitud = 0;
    }
    
    public int longitud() {
        return longitud;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void limpiar() {
        cabeza = cola = null;
        longitud = 0;
    }
    
    public void agregarPrimero(E elemento) {

        longitud++;

        if (estaVacia()) {
            Nodo<E> aux = new Nodo<>(elemento);
            cabeza = cola = aux;
            return;
        }

        Nodo<E> aux = new Nodo<>(elemento, cabeza);
        cabeza = aux;

    }

    public void agregar(E elemento) {

        if (estaVacia()) {
            agregarPrimero(elemento);
            return;
        }

        Nodo<E> aux = new Nodo<>(elemento);
        cola.setSiguiente(aux);
        cola = aux;

        longitud++;

    }

    public void agregar(E elemento, int idx) {

        if (idx < 0 || idx >= longitud) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }

        if (idx == 0 || estaVacia()) {
            agregarPrimero(elemento);
            return;
        }
        
        if(idx == (longitud - 1)){
            agregar(elemento);
            return;
        }

        Nodo<E> anterior = obtenerNodo(idx - 1); 
        anterior.setSiguiente(new Nodo<>(elemento, anterior.getSiguiente()));

        longitud++;

    }


    private Nodo<E> obtenerNodo(int idx) {

        if (idx == 0) {
            return cabeza;
        }

        if (idx == (longitud - 1)) {
            return cola;
        }

        Nodo<E> aux = cabeza;

        int contador = 0;

        while (contador < idx) {
            aux = aux.getSiguiente();
            contador++;
        }

        return aux;
    }

    public E obtenerPrimero() {

        if (estaVacia()) {
            throw new NullPointerException("Lista vacia");
        }

        return cabeza.getDato();

    }

    public E obtenerUltimo() {

        if (estaVacia()) {
            throw new NullPointerException("Lista vacia");
        }

        return cola.getDato();

    }

    public E obtener(int idx) {

        if (estaVacia()) {
            throw new NullPointerException("Lista vacia");
        }

        if (idx < 0 || idx > (longitud - 1)) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }

        if (idx == 0) {
            return obtenerPrimero();
        }

        if (idx == (longitud - 1)) {
            return obtenerUltimo();
        }

        return obtenerNodo(idx).getDato();
    }


    public E eliminarPrimero() {

        if (estaVacia()) {
            throw new NullPointerException("Lista vacia");
        }

        Nodo<E> elemento = cabeza;

        longitud--;

        if (longitud == 0) {
            cabeza = cola = null;
            return elemento.getDato();
        }

        cabeza = cabeza.getSiguiente();

        return elemento.getDato();

    }

    public E eliminarUltimo() {

        if (estaVacia()) {
            throw new NullPointerException("Lista vacia");
        }

        Nodo<E> elemento = cola;

        longitud--;

        if (longitud == 0) {
            cabeza = cola = null;
            return elemento.getDato();
        }

        Nodo<E> aux = obtenerNodo(longitud - 2);
        aux.setSiguiente(null);
        cola = aux;

        return elemento.getDato();
    }

    public E eliminar(int idx) {

        if (estaVacia()) {
            throw new NullPointerException("Lista vacia");
        }

        if (idx < 0 || idx >= longitud) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }

        if (idx == 0) {
            return eliminarPrimero();
        }

        if (idx == (longitud - 1)) {
            return eliminarUltimo();
        }

        Nodo<E> anterior = obtenerNodo(idx - 1);
        Nodo<E> elemento = anterior.getSiguiente();
        anterior.setSiguiente(anterior.getSiguiente().getSiguiente());

        longitud--;

        return elemento.getDato();

    }


    public void actualizar(E elemento, int idx){

        if(estaVacia()){
            throw new NullPointerException("Lista vacia");
        }

        if (idx < 0 || idx >= longitud) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }

        Nodo<E> tmp = obtenerNodo(idx);

        tmp.setDato(elemento);
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        if (estaVacia()) {
            sb.append("Lista vacia");
            return sb.toString();
        }

        Nodo<E> aux = cabeza;

        while (aux != null) {
            sb.append(aux.getDato().toString()).append("\n");
            aux = aux.getSiguiente();
        }

        return sb.toString();
    }


    public E[] toArreglo() {

        E[] array = null;

        if (longitud == 0) {
            return array;
        }

        array = (E[]) java.lang.reflect.Array.newInstance(this.cabeza.getDato().getClass(), longitud);

        Nodo<E> tmp = this.cabeza;

        for (int i = 0; i < longitud; i++) {
            array[i] = tmp.getDato();
            tmp = tmp.getSiguiente();
        }

        return array;

    }

    public void toLista(E[] array) {

        limpiar();

        for (E e : array) {
            this.agregar(e);
        }

    }
    
}
