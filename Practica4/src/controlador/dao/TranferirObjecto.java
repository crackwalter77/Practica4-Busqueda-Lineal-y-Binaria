package controlador.dao;

import estructura.lista.Lista;

public interface TranferirObjecto<T> {

    public Boolean guardar(T data);

    public Boolean actualizar(T data, Integer index);

    public Lista<T> listar();

    public Boolean eliminar(Integer index);

}
