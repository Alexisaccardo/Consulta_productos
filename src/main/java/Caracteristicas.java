import java.util.Date;

public class Caracteristicas {
    public String codigo;
    public String tipo;
    public String nombre;
    public String valor;
    public String caracteristicasfisicas;
    public String caracteristicasfabricacion;

    public Caracteristicas(String codigo, String tipo, String nombre, String valor, String caracteristicasfisicas, String caracteristicasfabricacion) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;
        this.caracteristicasfisicas = caracteristicasfisicas;
        this.caracteristicasfabricacion = caracteristicasfabricacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCaracteristicasfisicas() {
        return caracteristicasfisicas;
    }

    public void setCaracteristicasfisicas(String caracteristicasfisicas) {
        this.caracteristicasfisicas = caracteristicasfisicas;
    }

    public String getCaracteristicasfabricacion() {
        return caracteristicasfabricacion;
    }

    public void setCaracteristicasfabricacion(String caracteristicasfabricacion) {
        this.caracteristicasfabricacion = caracteristicasfabricacion;
    }


}
