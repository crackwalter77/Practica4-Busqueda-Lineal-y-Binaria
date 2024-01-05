package vista.tabla;

import estructura.lista.Lista;
import javax.swing.table.AbstractTableModel;
import modelo.Censo;

public class TablaCenso extends AbstractTableModel {

    private Lista<Censo> datos;

    public Lista<Censo> getDatos() {
        return datos;
    }

    public void setDatos(Lista<Censo> datos) {
        this.datos = datos;
    }
    
    @Override
    public int getRowCount() {
        return datos.longitud();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int row, int column) {
        
        Censo c = datos.obtener(row);

        switch (column) {
            case 0:
                return c.getCensador().getNombre() + " " + c.getCensador().getApellido();
            case 1:
                return c.getCensado().getNombre() + " " + c.getCensado().getApellido();
            case 2:
                return c.getTipo();
            case 3:
                return c.getMotivo();
            case 4:
                return c.getFechaSeparacion();
            case 5:
                return c.getEstadoEmosional();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        
        switch (column) {
            case 0:
                return "CENSADOR";
            case 1:
                return "CENSADO";
            case 2:
                return "TIPO";
            case 3:
                return "MOTIVO";
            case 4:
                return "FECHA";
            case 5:
                return "ESTADO EMOSIONAL";
            default:
                throw null;
        }
                
    }
    
}
