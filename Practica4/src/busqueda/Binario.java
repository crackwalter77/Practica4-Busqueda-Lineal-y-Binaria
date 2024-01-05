package busqueda;

import estructura.lista.Lista;
import ordenamiento.Merge;

public class Binario<E> {
    
    private Comparador comparador;
    private Merge<E> merge = new Merge<>();

    public E buscar(Lista<E> lista, String atributo, Object elemento){

        if(lista.estaVacia()){
            throw new NullPointerException("Lista Vacia");
        }
        merge.ordenar(lista, atributo, true);
        E[] arreglo = lista.toArreglo();
        comparador = new Comparador(atributo, lista.obtenerPrimero());
        Integer idx = binario(arreglo, elemento, 0, arreglo.length - 1);
        comparador = null;
        if (idx == -1) {
            return null;
        }
        return lista.obtener(idx);
    }
    private int binario(E[] arreglo, Object elemento, Integer menor, Integer mayor) {
        if (mayor >= menor) {
            Integer mid = menor + (mayor - menor) / 2;
            if (comparador.run(arreglo[mid], elemento) == 0) {
                return mid;
            }
            if (comparador.run(arreglo[mid], elemento) > 0) {
                return binario(arreglo, elemento, menor, mid - 1);
            }
            return binario(arreglo, elemento, mid + 1, mayor);
        }
        return -1;
    }
}
