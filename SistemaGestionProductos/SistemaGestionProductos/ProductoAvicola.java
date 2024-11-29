package SistemaGestionProductos;

public class ProductoAvicola extends ProductoBase{
    private String tipoAve;

    public ProductoAvicola(String codigo, String nombre, int stock, boolean activo, String tipoAve) {
        super(codigo, nombre, stock, activo);
        this.tipoAve = tipoAve;
    }

    public String getTipoAve() {
        return tipoAve;
    }

    public void setTipoAve(String tipoAve) {
        this.tipoAve = tipoAve;
    }

    public void ListarProductoAvicola() {
        System.out.println("ProductoAvicola{" + super.toString() +
                " tipoAve='" + tipoAve +
                '}');
    }
}
