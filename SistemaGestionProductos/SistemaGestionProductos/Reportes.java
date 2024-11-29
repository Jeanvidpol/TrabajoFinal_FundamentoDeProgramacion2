package SistemaGestionProductos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reportes {

    public void ReporteDetalladoProductos(List<ProductoBase> productos, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("Categoría, Código, Nombre, Stock, Activo, Detalles\n");

            for (ProductoBase producto : productos) {
                String estadoActivo = producto.isActivo() ? "Sí" : "No";
                String detalles = "";
                String categoria = "";

                if (producto instanceof ProductoVacuno vacuno) {
                    categoria = "Vacuno";
                    detalles = "Tipo: " + vacuno.getTipo() + " y Peso: " + vacuno.getPeso();
                } else if (producto instanceof ProductoPorcino porcino) {
                    categoria = "Porcino";
                    detalles = "Tipo: " + porcino.getTipo() + " y Peso: " + porcino.getPeso();
                } else if (producto instanceof ProductoAvicola avicola) {
                    categoria = "Avícola";
                    detalles = " y Tipo de Ave: " + avicola.getTipoAve();
                }

                writer.write(categoria + ", "+ producto.getCodigo() + ", " + producto.getNombre() + ", " +
                        producto.getStock() + ", " + estadoActivo + ", " + detalles + "\n");

            }

            System.out.println("Reporte Detallado de Productos exportado a " + nombreArchivo + " exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al exportar el reporte detallado de productos a CSV: " + e.getMessage());
        }
    }

    public void ReporteInventario(List<ProductoBase> productos, String nombreArchivo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("Categoría, Código, Nombre, Stock, Activo\n");

            for (ProductoBase producto : productos) {
                String estadoActivo = producto.isActivo() ? "Sí" : "No";
                String categoria = "";

                if (producto instanceof ProductoVacuno vacuno) {
                    categoria = "Vacuno";
                } else if (producto instanceof ProductoPorcino porcino) {
                    categoria = "Porcino";
                } else if (producto instanceof ProductoAvicola avicola) {
                    categoria = "Avícola";
                }
                writer.write(categoria + ", "+ producto.getCodigo() + ", " + producto.getNombre() + ", " +
                        producto.getStock() + ", " + estadoActivo + "\n");
            }

            System.out.println("Reporte de Inventario exportado a " + nombreArchivo + " exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al exportar el Inventario a CSV: " + e.getMessage());
        }
    }

    public void generarReporteMovimientos(List<String> historialMovimientos, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Encabezado del archivo
            writer.write("Movimiento\n");

            // Verificar si hay movimientos
            if (historialMovimientos.isEmpty()) {
                System.out.println("No hay movimientos registrados en el historial.");
                return;
            }

            // Escribir cada movimiento en el archivo
            for (String movimiento : historialMovimientos) {
                writer.write(movimiento + "\n");
            }

            System.out.println("Reporte de movimientos exportado a " + nombreArchivo + " exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar el reporte de movimientos: " + e.getMessage());
        }
    }
}
