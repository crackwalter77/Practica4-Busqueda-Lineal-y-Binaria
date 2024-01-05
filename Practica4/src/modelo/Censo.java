package modelo;

public class Censo {
    
    private Integer id;
    private Persona censador;
    private Persona censado;
    private String tipo;
    private String motivo;
    private String fechaSeparacion;
    private String estadoEmosional;

    public Censo() {
    }

    public Censo(Persona censador, Persona censado, String tipo, String motivo, String fechaSeparacion, String estadoEmosional) {
        this.censador = censador;
        this.censado = censado;
        this.tipo = tipo;
        this.motivo = motivo;
        this.fechaSeparacion = fechaSeparacion;
        this.estadoEmosional = estadoEmosional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getCensador() {
        return censador;
    }

    public void setCensador(Persona censador) {
        this.censador = censador;
    }

    public Persona getCensado() {
        return censado;
    }

    public void setCensado(Persona censado) {
        this.censado = censado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFechaSeparacion() {
        return fechaSeparacion;
    }

    public void setFechaSeparacion(String fechaSeparacion) {
        this.fechaSeparacion = fechaSeparacion;
    }

    public String getEstadoEmosional() {
        return estadoEmosional;
    }

    public void setEstadoEmosional(String estadoEmosional) {
        this.estadoEmosional = estadoEmosional;
    }

    @Override
    public String toString() {
        return "Censo{" + "id=" + id + ", censador=" + censador.getNombre() + ", censado=" + censado.getNombre() + ", tipo=" + tipo + ", motivo=" + motivo + ", fechaSeparacion=" + fechaSeparacion + ", estadoEmosional=" + estadoEmosional + '}';
    }
 
    
}
