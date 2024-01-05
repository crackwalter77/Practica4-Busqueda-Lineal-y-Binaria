package busqueda;

import estructura.lista.Lista;

public class Lineal<E> {

    private Comparador comparador;
    public Lista<E> buscar(Lista<E> lista, String atributo, Object elemento) {
        if (lista.estaVacia()) {
            throw new NullPointerException("Lista Vacia");
        }
        comparador = new Comparador(atributo, lista.obtenerPrimero());
        Lista<E> resultado = new Lista<>();
        E[] aux = lista.toArreglo();
        for (E aux1 : aux) {
            if (comparador.comparar(aux1, elemento) == 0) {
                resultado.agregar(aux1);
            }
        }
        comparador = null;
        return resultado;
    }
}
