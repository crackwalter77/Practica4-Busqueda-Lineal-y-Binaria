package ordenamiento;

import estructura.lista.Lista;

public class Quick<E> {
    
    private Comparador comparador;

    public void ordenar(Lista<E> lista, String atributo, boolean tipoOrdenamiento) {
        
        if (lista.estaVacia()) {
            throw new NullPointerException();
        }

        if (lista.longitud() == 1) {
            return;
        }

        E[] arreglo = lista.toArreglo();

        comparador = new Comparador(atributo, lista.obtenerPrimero());

        quickSort(arreglo, 0, (arreglo.length - 1), tipoOrdenamiento);

        comparador = null;

        lista.toLista(arreglo);

    }

    private int particion(E[] arreglo, int bajo, int alto, boolean tipoOrdenamiento) {

        var pivot = arreglo[alto];

        int i = (bajo - 1);

        for (int j = bajo; j < alto; j++) {

            if (tipoOrdenamiento ? comparador.run(arreglo[j], pivot) <= 0 : comparador.run(arreglo[j], pivot) >= 0) {

                i++;
                var tmp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = tmp;

            }

        }

        var tmp = arreglo[i + 1];

        arreglo[i + 1] = arreglo[alto];

        arreglo[alto] = tmp;

        return i + 1;

    }

    private void quickSort(E[] arreglo, int bajo, int alto, boolean tipoOrdenamiento) {

        if (bajo < alto) {

            int pi = particion(arreglo, bajo, alto, tipoOrdenamiento);

            quickSort(arreglo, bajo, pi - 1, tipoOrdenamiento);

            quickSort(arreglo, pi + 1, alto, tipoOrdenamiento);

        }

    }
    
}
