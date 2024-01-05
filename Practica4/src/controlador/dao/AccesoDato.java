package controlador.dao;

import com.thoughtworks.xstream.XStream;
import estructura.lista.Lista;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class AccesoDato<T> implements TranferirObjecto<T> {

    private XStream xstream;
    private Class<T> clase;
    private String URL;

    public AccesoDato(Class<T> clazz) {
        xstream = Conexion.getXstream();

        this.clase = clazz;

        URL = Conexion.getURL() + this.clase.getSimpleName() + ".json";

    }

    @Override
    public Boolean guardar(T elemento) {

        Lista<T> lista = listar();

        lista.agregar(elemento);
        
        try {

            xstream.toXML(lista, new FileOutputStream(URL)); //This porsiaca

        } catch (FileNotFoundException ex) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean actualizar(T elemento, Integer idx) {

        Lista<T> lista = listar();

        try {

            lista.actualizar(elemento, idx);

            xstream.toXML(lista, new FileOutputStream(URL));

        } catch (FileNotFoundException ex) {
            return false;
        }

        return true;

    }

    @Override
    public Lista<T> listar() {

        Lista<T> lista = new Lista<>();

        try {

            lista = (Lista<T>) xstream.fromXML(new FileReader(URL));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return lista;

    }

    @Override
    public Boolean eliminar(Integer index) {

        Lista<T> lista = listar();

        try {

            lista.eliminar(index);

            xstream.toXML(lista, new FileOutputStream(URL));

        } catch (FileNotFoundException ex) {
            return false;
        }

        return true;
    }

    public Integer generarId() {
        return listar().longitud() + 1;
    }

    public String getURL() {
        return URL;
    }

    public XStream getXStream() {
        return xstream;
    }

}
