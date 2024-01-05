package busqueda;

import java.lang.reflect.Method;

class Comparador {

    private String tipoDato;
    private Method[] metodos;
    private Object objeto;

    public Comparador(String atributo, Object tipo) {
        this.objeto = tipo;
        inzMetodos(atributo);
    }

    public int run(Object o1, Object o2) {

        if (tipoDato.equals("Integer") || tipoDato.equals("Double")) {

            return Double.compare(((Number) getValue(o1)).doubleValue(), ((Number) o2).doubleValue());

        }

        return Integer.compare(getValue(o1).toString().compareToIgnoreCase(o2.toString()), 0);
    }

    public int comparar(Object o1, Object o2) {
        
        if (tipoDato.equals("Integer") || tipoDato.equals("Double")) {
            return Double.compare(((Number) getValue(o1)).doubleValue(), ((Number) o2).doubleValue());
        }
        
        if(getValue(o1).toString().startsWith(o2.toString())){
            return 0;
        }
        
        return -2;
    }

    private void inzMetodos(String atributo) {

        String[] atributos = atributo.split("\\.");

        metodos = new Method[atributos.length];

        for (int i = 0; i < metodos.length; i++) {
            try {

                String nombreMetodo = "get" + atributos[i];
                metodos[i] = objeto.getClass().getDeclaredMethod(nombreMetodo);
                objeto = metodos[i].invoke(objeto);

            } catch (ReflectiveOperationException e) {
                System.err.println("Error al obtener o invocar el metodo: " + e.getMessage());
            }
        }

        tipoDato = objeto.getClass().getSimpleName();

    }

    private Object getValue(Object elemento) {

        Object resultado = elemento;

        for (Method metodo : metodos) {
            try {

                resultado = metodo.invoke(resultado);

            } catch (ReflectiveOperationException e) {
                System.err.println("Error al invocar el metodo: " + e.getMessage());
            }
        }

        return resultado;
    }

}
