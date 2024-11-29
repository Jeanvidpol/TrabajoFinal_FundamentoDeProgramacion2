package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.List;

public class ControlInventario {

    private List<String> historialMovimientos;

    public ControlInventario() {
        this.historialMovimientos = new ArrayList<>();
    }

    // Metodo para registrar un movimiento
    public void registrarMovimiento(String codigo, String tipoMovimiento, int cantidad, GestionProductos gestionProductos) throws Exception {
        ProductoBase producto = buscarProductoPorCodigo(codigo, gestionProductos);

        if (producto == null) {
            throw new Exception("Producto con código " + codigo + " no encontrado.");
        }

        if (tipoMovimiento.equalsIgnoreCase("entrada")) {
            producto.setStock(producto.getStock() + cantidad);
            registrarEnHistorial("Entrada: Código: " + codigo + ", Cantidad: " + cantidad);
        } else if (tipoMovimiento.equalsIgnoreCase("salida")) {
            if (producto.getStock() < cantidad) {
                throw new Exception("Stock insuficiente para realizar la salida.");
            }
            producto.setStock(producto.getStock() - cantidad);
            registrarEnHistorial("Salida: Código: " + codigo + ", Cantidad: " + cantidad);
        } else {
            throw new Exception("Tipo de movimiento inválido. Debe ser 'entrada' o 'salida'.");
        }
        System.out.println("Movimiento registrado exitosamente.");
    }

    // Metodo para verificar el stock actual de un producto
    public void verificarStock(String codigo, GestionProductos gestionProductos) throws Exception {
        ProductoBase producto = buscarProductoPorCodigo(codigo, gestionProductos);

        if (producto == null) {
            throw new Exception("Producto con código " + codigo + " no encontrado.");
        }

        System.out.println("Stock actual del producto (Código: " + codigo + "): " + producto.getStock());
    }

    // Metodo para guardar en el historial
    private void registrarEnHistorial(String movimiento) {
        historialMovimientos.add(movimiento);
    }

    // Metodo para mostrar el historial de movimientos
    public void mostrarHistorial() {
        if (historialMovimientos.isEmpty()) {
            System.out.println("No hay movimientos registrados en el historial.");
        } else {
            System.out.println("Historial de Movimientos:");
            for (String movimiento : historialMovimientos) {
                System.out.println(movimiento);
            }
        }
    }

    // Metodo auxiliar para buscar un producto por su código
    private ProductoBase buscarProductoPorCodigo(String codigo, GestionProductos gestionProductos) {
        for (ProductoBase producto : gestionProductos.getProductos()) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public List<String> getHistorialMovimientos() {
        return historialMovimientos;
    }
}
