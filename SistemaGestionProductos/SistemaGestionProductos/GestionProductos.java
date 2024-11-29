package SistemaGestionProductos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionProductos {
    private List<ProductoBase> productos;

    public GestionProductos() {
        this.productos = new ArrayList<>();
    }

    public List<ProductoBase> getProductos() {
        return productos;
    }

    public void agregarProductoVacuno(String codigo, String nombre, int stock, boolean activo, String tipo, String peso) {
        ProductoVacuno productoVacuno = new ProductoVacuno(codigo, nombre, stock, activo, tipo, peso);
        productos.add(productoVacuno);
        System.out.println("Producto vacuno agregado exitosamente.");
    }

    public void agregarProductoPorcino(String codigo, String nombre, int stock, boolean activo, String tipo, String peso) {
        ProductoPorcino productoPorcino = new ProductoPorcino(codigo, nombre, stock, activo, tipo, peso);
        productos.add(productoPorcino);
        System.out.println("Producto porcino agregado exitosamente.");
    }

    public void agregarProductoAvicola(String codigo, String nombre, int stock, boolean activo, String tipoAve) {
        ProductoAvicola productoAvicola = new ProductoAvicola(codigo, nombre, stock, activo, tipoAve);
        productos.add(productoAvicola);
        System.out.println("Producto avícola agregado exitosamente.");
    }

    public void eliminarProductoVacuno(String codigo) throws Exception {
        for (ProductoBase producto : productos) {
            if (producto instanceof ProductoVacuno && producto.getCodigo().equals(codigo)) {
                productos.remove(producto);
                System.out.println("Producto vacuno eliminado exitosamente.");
                return;
            }
        }
        throw new Exception("Producto vacuno con código " + codigo + " no encontrado.");
    }

    public void eliminarProductoPorcino(String codigo) throws Exception {
        for (ProductoBase producto : productos) {
            if (producto instanceof ProductoPorcino && producto.getCodigo().equals(codigo)) {
                productos.remove(producto);
                System.out.println("Producto porcino eliminado exitosamente.");
                return;
            }
        }
        throw new Exception("Producto porcino con código " + codigo + " no encontrado.");
    }

    public void eliminarProductoAvicola(String codigo) throws Exception {
        for (ProductoBase producto : productos) {
            if (producto instanceof ProductoAvicola && producto.getCodigo().equals(codigo)) {
                productos.remove(producto);
                System.out.println("Producto avícola eliminado exitosamente.");
                return;
            }
        }
        throw new Exception("Producto avícola con código " + codigo + " no encontrado.");
    }

    public void listarProductosVacuno() {
        System.out.println("\nLista de productos vacuno:");
        for (ProductoBase producto : productos) {
            if (producto instanceof ProductoVacuno) {
                ((ProductoVacuno) producto).ListarProductoVacuno();
            }
        }
    }

    public void listarProductosPorcino() {
        System.out.println("\nLista de productos porcino:");
        for (ProductoBase producto : productos) {
            if (producto instanceof ProductoPorcino) {
                ((ProductoPorcino) producto).ListarProductoPorcino();
            }
        }
    }

    public void listarProductosAvicola() {
        System.out.println("\nLista de productos avícola:");
        for (ProductoBase producto : productos) {
            if (producto instanceof ProductoAvicola) {
                ((ProductoAvicola) producto).ListarProductoAvicola();
            }
        }
    }

    public void listarTodosLosProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("\nLista de todos los productos:");
        for (ProductoBase producto : productos) {
            if (producto instanceof ProductoVacuno) {
                ((ProductoVacuno) producto).ListarProductoVacuno();
            } else if (producto instanceof ProductoPorcino) {
                ((ProductoPorcino) producto).ListarProductoPorcino();
            } else if (producto instanceof ProductoAvicola) {
                ((ProductoAvicola) producto).ListarProductoAvicola();
            }
        }
    }

    public void actualizarProducto(String codigo, String nuevoNombre, int nuevoStock, boolean nuevoActivo, String nuevoTipo, String nuevoPeso, String nuevoTipoAve) throws Exception {
        for (ProductoBase producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.setNombre(nuevoNombre);
                producto.setStock(nuevoStock);
                producto.setActivo(nuevoActivo);

                if (producto instanceof ProductoVacuno vacuno) {
                    vacuno.setTipo(nuevoTipo);
                    vacuno.setPeso(nuevoPeso);
                    System.out.println("Producto vacuno con código " + codigo + " ha sido actualizado exitosamente.");
                } else if (producto instanceof ProductoPorcino porcino) {
                    porcino.setTipo(nuevoTipo);
                    porcino.setPeso(nuevoPeso);
                    System.out.println("Producto porcino con código " + codigo + " ha sido actualizado exitosamente.");
                } else if (producto instanceof ProductoAvicola avicola) {
                    avicola.setTipoAve(nuevoTipoAve);
                    System.out.println("Producto avícola con código " + codigo + " ha sido actualizado exitosamente.");
                } else {
                    throw new Exception("El tipo de producto no es reconocido.");
                }
                return;
            }
        }
        throw new Exception("Producto con código " + codigo + " no encontrado.");
    }

    public void cambiarEstadoProducto(String codigo, boolean nuevoEstado) throws Exception {
        for (ProductoBase producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.setActivo(nuevoEstado);
                if (producto instanceof ProductoVacuno) {
                    System.out.println("Producto Vacuno con código " + codigo + " se ha cambiado a " + (nuevoEstado ? "Activo" : "Inactivo") + " exitosamente.");
                } else if (producto instanceof ProductoPorcino) {
                    System.out.println("Producto Porcino con código " + codigo + " se ha cambiado a " + (nuevoEstado ? "Activo" : "Inactivo") + " exitosamente.");
                } else if (producto instanceof ProductoAvicola) {
                    System.out.println("Producto Avícola con código " + codigo + " se ha cambiado a " + (nuevoEstado ? "Activo" : "Inactivo") + " exitosamente.");
                } else {
                    throw new Exception("Tipo de producto desconocido.");
                }

                return;
            }
        }
        throw new Exception("Producto con código " + codigo + " no encontrado.");
    }

}
