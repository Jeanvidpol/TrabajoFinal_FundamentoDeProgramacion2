package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductoBase {
    private String codigo;
    private String nombre;
    private int stock;
    private boolean activo;

    public ProductoBase(String codigo, String nombre, int stock, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.activo = activo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void mostrarProducto() {
        System.out.println("Codigo: " + codigo + ", Nombre: " + nombre + ", Stock: " + stock + ", Activo: " + (activo ? "Sí":"No"));
    }

    @Override
    public String toString() {
        return
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", activo=" + activo ;
    }
}
