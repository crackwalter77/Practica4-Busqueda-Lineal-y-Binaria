package controlador;

import controlador.dao.AccesoDato;
import modelo.Censo;
import modelo.Persona;

public class CensoDAO extends AccesoDato<Censo>{
    
    private Censo censo;
    
    public CensoDAO(){
        super(Censo.class);
    }

    public Censo getCenso() {
        return censo;
    }
    
    public void setCenso(Integer idx){
        censo = listar().obtener(idx);
    }
    
    public void guardarCenso(Persona censador, Persona censado, String tipo, String motivo, String fechaSeparacion, String estadoEmosional){
        
        censo = new Censo(censador, 
                          censado, 
                          tipo, 
                          motivo, 
                          fechaSeparacion, 
                          estadoEmosional);
        
        censo.setId(generarId());
        
        guardar(censo);
        
        resetCenso();
        
    }
    
    public void actualizarCenso(){
        
        actualizar(censo, censo.getId() - 1);
        
        resetCenso();
        
    }
    
    public void eliminarCenso(){
        
        eliminar(censo.getId() - 1);
        
        resetCenso();
        
    }
    
    private void resetCenso(){
        censo = null;
    }
}
