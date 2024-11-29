package SistemaGestionProductos;

public class ProductoVacuno extends ProductoBase{
    private String tipo;
    private String peso;

    public ProductoVacuno(String codigo, String nombre, int stock, boolean activo, String tipo, String peso) {
        super(codigo, nombre, stock, activo);
        this.tipo = tipo;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void ListarProductoVacuno() {
        System.out.println("ProductoVacuno{" + super.toString() +
                " tipo='" + tipo + '\'' +
                ", peso='" + peso + '\'' +
                '}');
    }
}
