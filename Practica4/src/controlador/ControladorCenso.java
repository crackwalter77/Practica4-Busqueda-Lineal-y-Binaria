package controlador;

import busqueda.Binario;
import busqueda.Lineal;
import estructura.lista.Lista;
import modelo.Censo;
import modelo.Persona;
import ordenamiento.Merge;
import ordenamiento.Quick;

public class ControladorCenso {

    private final CensoDAO censoDao;
    private Persona censador;
    private Persona censado;

    public ControladorCenso() {
        censoDao = new CensoDAO();
    }

    public void guardarPersonas(String nombreCdo, String apellidoCdo, String nombreCdor, String apellidoCdor) {

        if (censador != null && censado != null) {

            censador.setNombre(nombreCdor);
            censador.setApellido(apellidoCdor);

            censado.setNombre(nombreCdo);
            censado.setApellido(apellidoCdo);

            return;
        }

        censador = new Persona(nombreCdor, apellidoCdor);

        censado = new Persona(nombreCdo, apellidoCdo);

    }

    public void guardarCenso(String tipo, String motivo, String fechaSeparacion, String estadoEmosional) {

        if (censoDao.getCenso() != null) {

            censoDao.getCenso().setTipo(tipo);
            censoDao.getCenso().setMotivo(motivo);
            censoDao.getCenso().setFechaSeparacion(fechaSeparacion);
            censoDao.getCenso().setEstadoEmosional(estadoEmosional);

            actualizarCenso();

            return;
        }

        censoDao.guardarCenso(censador, censado, tipo, motivo, fechaSeparacion, estadoEmosional);

        censador = censado = null;

    }

    public void cargarCenso(Censo censo) {

        censoDao.setCenso(censo.getId() - 1);

        censador = censoDao.getCenso().getCensador();

        censado = censoDao.getCenso().getCensado();

    }

    private void actualizarCenso() {

        censoDao.actualizarCenso();

        censador = censado = null;

    }

    public void eliminarCenso(Censo censo) {

        censoDao.setCenso(censo.getId() - 1);

        censoDao.eliminarCenso();

    }

    public Lista<Censo> ordenarCensos(String atributo, String metodo, boolean tipoOrdenamiento) {

        Lista<Censo> resultado = censoDao.listar();

        if (atributo.equals("Censador") || atributo.equals("Censado")) {
            atributo = atributo + ".Nombre";
        }

        if (metodo.equals("QuickSort")) {

            Quick<Censo> quick = new Quick<>();

            quick.ordenar(resultado, atributo, tipoOrdenamiento);

            return resultado;
        }

        Merge<Censo> merge = new Merge<>();

        merge.ordenar(resultado, atributo, tipoOrdenamiento);

        return resultado;
    }

    public Lista<Censo> buscar(String atributo, Object elemento, boolean tipoBusqueda) {

        if (atributo.equals("Censador") || atributo.equals("Censado")) {
            atributo = atributo + ".Nombre";
        }

        if (tipoBusqueda) {

            Lista<Censo> resultado = new Lista<>();

            Binario<Censo> binario = new Binario<>();

            Censo aux = binario.buscar(censoDao.listar(), atributo, elemento);

            if (aux != null) {
                resultado.agregar(aux);
            }

            return resultado;
        }

        Lineal<Censo> lineal = new Lineal<>();

        return lineal.buscar(censoDao.listar(), atributo, elemento);
    }

    public String estadistica() {
        Lista<Censo> lista = censoDao.listar();

        int total = lista.longitud();

        int separados = 0, divorciados = 0;

        for (int i = 0; i < total; i++) {

            if (lista.obtener(i).getTipo().equals("Separado")) {
                separados++;
            } else {
                divorciados++;
            }

        }

        return "Personas Separadas(" + separados + ") \n Personas Divorciadas(" + divorciados + ")";
    }

    public Persona getCensador() {
        return censador;
    }

    public Persona getCensado() {
        return censado;
    }

    public Censo getCenso() {
        return censoDao.getCenso();
    }

    public Lista<Censo> getCensos() {
        return censoDao.listar();
    }

}
