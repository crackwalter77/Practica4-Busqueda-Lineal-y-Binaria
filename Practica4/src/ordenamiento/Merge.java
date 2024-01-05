package ordenamiento;

import estructura.lista.Lista;

public class Merge<E> {
    
    private Comparador comparador;
    
    public void ordenar(Lista<E> lista, String atributo, boolean tipoOrdenamiento) {
        
        if (lista.estaVacia()) {
            throw new NullPointerException("Lista vacia");
        }

        if (lista.longitud()== 1) {
            return;
        }

        E[] array = lista.toArreglo();

        comparador = new Comparador(atributo, lista.obtenerPrimero());

        mergeSort(array, 0, (array.length - 1), tipoOrdenamiento);

        comparador = null;

        lista.toLista(array);

    }


    private void mergeSort(E[] arreglo, int l, int r, boolean tipoOrdenamiento) {

        if (l < r) {

            int m = l + (r - l) / 2;

            mergeSort(arreglo, l, m, tipoOrdenamiento);

            mergeSort(arreglo, m + 1, r, tipoOrdenamiento);

            merge(arreglo, l, m, r, tipoOrdenamiento);

        }

    }

    @SuppressWarnings("unchecked")
    private void merge(E[] arreglo, int l, int m, int r, boolean tipoOrdenamiento) {

        int n1 = m - l + 1;
        int n2 = r - m;

        E[] L = (E[]) java.lang.reflect.Array.newInstance(arreglo[0].getClass(), n1);

        E[] R = (E[]) java.lang.reflect.Array.newInstance(arreglo[0].getClass(), n2);

        for (int i = 0; i < n1; ++i)
            L[i] = arreglo[l + i];

        for (int j = 0; j < n2; ++j)
            R[j] = arreglo[m + 1 + j];

        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2) {

            if (tipoOrdenamiento ? comparador.run(L[i], R[j]) <= 0 : comparador.run(L[i], R[j]) >= 0) {

                arreglo[k] = L[i];
                i++;

            } else {

                arreglo[k] = R[j];
                j++;

            }

            k++;
        }

        while (i < n1) {
            arreglo[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arreglo[k] = R[j];
            j++;
            k++;
        }

    }
    
}
