package SistemaGestionProductos;

public class ProductoPorcino extends ProductoBase{
    private String tipo;
    private String peso;

    public ProductoPorcino(String codigo, String nombre, int stock, boolean activo, String tipo, String peso) {
        super(codigo, nombre, stock, activo);
        this.tipo = tipo;
        this.peso = peso;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void ListarProductoPorcino() {
        System.out.println("ProductoPorcino{" + super.toString() +
                " tipo='" + tipo + '\'' +
                ", peso='" + peso + '\'' +
                '}');
    }
}
