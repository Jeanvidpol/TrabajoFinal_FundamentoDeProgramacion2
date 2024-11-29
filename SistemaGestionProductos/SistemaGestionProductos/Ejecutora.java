package SistemaGestionProductos;

//import java.util.List;
import java.util.Scanner;

public class Ejecutora {
    static Scanner scanner = new Scanner(System.in);
    private static GestionProductos gestionProductos = new GestionProductos();
    private static Reportes reportes = new Reportes();
    private static ControlInventario controlInventario = new ControlInventario();


    public static void main(String[] args) {
        MenuInicio();
    }

    public static void MenuInicio(){
        int opcion;

        do{
            System.out.println("Sistema de Gestión de Productos");
            System.out.println("Ingrese lo que desee realizar: ");
            System.out.println("1.- Módulo de Gestión de Productos");
            System.out.println("2.- Módulo de Control de Inventario");
            System.out.println("3.- Módulo de Reportes");
            System.out.println("4.- Salir");
            System.out.println("Opcion: ");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1: MenuModuloGestionProductos();
                    break;
                case 2: MenuModuloControlInventario();
                    break;
                case 3: MenuModuloReportes();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opción no valida. Por favor, ingrese una opción valida.");
            }
        }while (opcion != 4);
    }

    public static void MenuModuloGestionProductos(){
        int opcion;

        do {
            System.out.println("Módulo de Gestión de Productos");
            System.out.println("Ingrese la opción que desea realizar: ");
            System.out.println("1.- Añadir producto");
            System.out.println("2.- Actualizar producto");
            System.out.println("3.- Eliminar producto");
            System.out.println("4.- Cambiar estado (Activo / Inactivo)");
            System.out.println("5.- Regresar al menú principal");
            System.out.println("Opcion: ");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1: MenuAñadirProducto();
                    break;
                case 2: MenuActualizarProducto();
                    break;
                case 3: MenuEliminarProducto();
                    break;
                case 4: MenuCambiarEstadoProducto();
                    break;
                case 5: MenuInicio();
                    break;
                default:
                    System.out.println("Opción no valida. Por favor, ingrese una opción valida.");
            }
        }while (opcion!=5);
    }

    public static void MenuModuloControlInventario(){
        int opcion;

        do {
            System.out.println("Módulo de Control de Inventario");
            System.out.println("Ingrese la opción que desea realizar: ");
            System.out.println("1.- Tracking del stock actual");
            System.out.println("2.- Registro de movimientos (Entrada / Salida)");
            System.out.println("3.- Historial detallado de los movimientos de los productos");
            System.out.println("4.- Consulta de información de productos");
            System.out.println("5.- Regresar al menú principal");
            System.out.println("Opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    StockActual();  // Verificar stock actual.
                    break;
                case 2:
                    RegistroMovimientos();  // Registrar movimientos.
                    break;
                case 3:
                    MenuHistorialMovimientos();  // Mostrar historial.
                    break;
                case 4:
                    MenuInfoProductos();  // Consulta información de productos.
                    break;
                case 5:
                    MenuInicio();  // Regresar al menú principal.
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 5);
    }

    public static void MenuModuloReportes(){
        int opcion;

        do {
            System.out.println("Módulo de Reportes");
            System.out.println("Ingrese la opción que desea realizar: ");
            System.out.println("1.- Reporte de Inventario");
            System.out.println("2.- Reporte de movimientos de productos");
            System.out.println("3.- Reporte Detallado de Productos");
            System.out.println("4.- Regresar al menú principal");
            System.out.println("Opcion: ");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1: reportes.ReporteInventario(gestionProductos.getProductos(), "inventario_productos.csv");
                    break;
                case 2: ReporteMovimientosProductos();
                    break;
                case 3: reportes.ReporteDetalladoProductos(gestionProductos.getProductos(), "detallado_productos.csv");
                    break;
                case 4: MenuInicio();
                    break;
                default:
                    System.out.println("Opción no valida. Por favor, ingrese una opción valida.");
            }
        }while (opcion!=4);
    }

    public static void MenuAñadirProducto(){
        int opcion;
        do {
            System.out.println("Que desea ingresar:");
            System.out.println("1.- Vacuno");
            System.out.println("2.- Porcino");
            System.out.println("3.- Avícola");
            System.out.println("4.- Regresar al menú anteior");
            System.out.println("Opción: ");
            opcion = scanner.nextInt();

        }while (opcion<1 || opcion>4);
        switch (opcion){
            case 1: añadirProdVacuno();
                break;
            case 2: añadirProdPorcino();
                break;
            case 3: añadirProdAvicola();
                break;
            case 4: MenuModuloGestionProductos();
                break;

        }
    }

    public static void añadirProdVacuno(){
        scanner.nextLine();
        System.out.println("Ingrese el código: ");
        String codigo = scanner.nextLine();
        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el stock: ");
        int stock = scanner.nextInt();
        System.out.println("¿El producto está activo? (true/false): ");
        boolean activo = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Ingrese el tipo (e.g., Premium): ");
        String tipo = scanner.nextLine();
        System.out.println("Ingrese el peso (e.g., 2kg): ");
        String peso = scanner.nextLine();
        gestionProductos.agregarProductoVacuno(codigo, nombre, stock, activo, tipo, peso);
    }

    public static void añadirProdPorcino(){
        scanner.nextLine();
        System.out.println("Ingrese el código: ");
        String codigo = scanner.nextLine();
        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el stock: ");
        int stock = scanner.nextInt();
        System.out.println("¿El producto está activo? (true/false): ");
        boolean activo = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Ingrese el tipo (e.g., Ahumado): ");
        String tipo = scanner.nextLine();
        System.out.println("Ingrese el peso (e.g., 1.5kg): ");
        String peso = scanner.nextLine();
        gestionProductos.agregarProductoPorcino(codigo, nombre, stock, activo, tipo, peso);
    }

    public static void añadirProdAvicola(){
        scanner.nextLine();
        System.out.println("Ingrese el código: ");
        String codigo = scanner.nextLine();
        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el stock: ");
        int stock = scanner.nextInt();
        System.out.println("¿El producto está activo? (true/false): ");
        boolean activo = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Ingrese el tipo de ave (e.g., Gallina): ");
        String tipoAve = scanner.nextLine();
        gestionProductos.agregarProductoAvicola(codigo, nombre, stock, activo, tipoAve);
    }

    public static void MenuActualizarProducto(){
        int opcion;
        do {
            System.out.println("Que desea actualizar:");
            System.out.println("1.- Vacuno");
            System.out.println("2.- Porcino");
            System.out.println("3.- Avícola");
            System.out.println("4.- Regresar al menú anteior");
            System.out.println("Opción: ");
            opcion = scanner.nextInt();

        }while (opcion<1 || opcion>4);
        switch (opcion){
            case 1: actualizarProductoVacuno();
                break;
            case 2: actualizarProductoPorcino();
                break;
            case 3: actualizarProductoAvicola();
                break;
            case 4: MenuModuloGestionProductos();
                break;

        }
    }

    public static void actualizarProductoVacuno() {
        scanner.nextLine();
        System.out.println("Ingrese el código del producto vacuno: ");
        String codigo = scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre del producto vacuno: ");
        String nuevoNombre = scanner.nextLine();

        System.out.println("Ingrese el nuevo stock: ");
        int nuevoStock = scanner.nextInt();

        System.out.println("¿Está activo? (true/false): ");
        boolean nuevoActivo = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo tipo de carne vacuno: ");
        String nuevoTipo = scanner.nextLine();

        System.out.println("Ingrese el nuevo peso del producto vacuno: ");
        String nuevoPeso = scanner.nextLine();

        try {
            gestionProductos.actualizarProducto(codigo, nuevoNombre, nuevoStock, nuevoActivo, nuevoTipo, nuevoPeso, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarProductoPorcino() {
        scanner.nextLine();
        System.out.println("Ingrese el código del producto porcino: ");
        String codigo = scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre del producto porcino: ");
        String nuevoNombre = scanner.nextLine();

        System.out.println("Ingrese el nuevo stock: ");
        int nuevoStock = scanner.nextInt();

        System.out.println("¿Está activo? (true/false): ");
        boolean nuevoActivo = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo tipo de carne porcino: ");
        String nuevoTipo = scanner.nextLine();

        System.out.println("Ingrese el nuevo peso del producto porcino: ");
        String nuevoPeso = scanner.nextLine();

        try {
            gestionProductos.actualizarProducto(codigo, nuevoNombre, nuevoStock, nuevoActivo, nuevoTipo, nuevoPeso, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarProductoAvicola() {
        scanner.nextLine();
        System.out.println("Ingrese el código del producto avícola: ");
        String codigo = scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre del producto avícola: ");
        String nuevoNombre = scanner.nextLine();

        System.out.println("Ingrese el nuevo stock: ");
        int nuevoStock = scanner.nextInt();

        System.out.println("¿Está activo? (true/false): ");
        boolean nuevoActivo = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo tipo de ave: ");
        String nuevoTipoAve = scanner.nextLine();

        try {
            gestionProductos.actualizarProducto(codigo, nuevoNombre, nuevoStock, nuevoActivo, null, null,
                    nuevoTipoAve);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void MenuEliminarProducto() {
        int opcion;
        do {
            System.out.println("¿Qué tipo de producto desea eliminar?");
            System.out.println("1.- Producto Vacuno");
            System.out.println("2.- Producto Porcino");
            System.out.println("3.- Producto Avícola");
            System.out.println("4.- Regresar al menú anteior");
            System.out.println("Opción: ");
            opcion = scanner.nextInt();
        } while (opcion < 1 || opcion > 4);
        switch (opcion) {
            case 1:
                eliminarProductoVacuno();
                break;
            case 2:
                eliminarProductoPorcino();
                break;
            case 3:
                eliminarProductoAvicola();
                break;
            case 4: MenuModuloGestionProductos();
                break;
        }
    }

    public static void eliminarProductoVacuno() {
        scanner.nextLine();
        System.out.println("Ingrese el código del producto vacuno a eliminar: ");
        String codigo = scanner.nextLine();

        try {
            gestionProductos.eliminarProductoVacuno(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarProductoPorcino() {
        scanner.nextLine();
        System.out.println("Ingrese el código del producto porcino a eliminar: ");
        String codigo = scanner.nextLine();

        try {
            gestionProductos.eliminarProductoPorcino(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarProductoAvicola() {
        scanner.nextLine();
        System.out.println("Ingrese el código del producto avícola a eliminar: ");
        String codigo = scanner.nextLine();

        try {
            gestionProductos.eliminarProductoAvicola(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void MenuCambiarEstadoProducto() {
        int opcion;
        do {
            System.out.println("¿De qué tipo desea cambiar el estado?");
            System.out.println("1.- Vacuno");
            System.out.println("2.- Porcino");
            System.out.println("3.- Avícola");
            System.out.println("4.- Regresar al menú anterior");
            System.out.println("Opción: ");
            opcion = scanner.nextInt();
        } while (opcion < 1 || opcion > 4);

        if (opcion == 4) {
            MenuModuloGestionProductos();
            return;
        }

        System.out.println("Ingrese el código del producto:");
        String codigo = scanner.next();

        System.out.println("Ingrese el nuevo estado del producto (true/false):");
        boolean nuevoEstado = scanner.nextBoolean();

        try {
            gestionProductos.cambiarEstadoProducto(codigo, nuevoEstado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void StockActual(){
        System.out.println("Ingrese el código del producto:");
        String codigo = scanner.next();  // Solicitar el código del producto al usuario.
        try {
            // Llamar al metodo verificarStock de ControlInventario.
            controlInventario.verificarStock(codigo, gestionProductos);
        } catch (Exception e) {
            // Mostrar errores en caso de que el producto no se encuentre.
            System.out.println(e.getMessage());
        }

    }

    public static void RegistroMovimientos(){

        System.out.println("Ingrese el código del producto:");
        String codigo = scanner.next();  // Solicitar el código del producto.
        scanner.nextLine();

        System.out.println("¿Qué tipo de movimiento desea registrar? (entrada/salida):");
        String tipoMovimiento = scanner.next();  // Pedir al usuario el tipo de movimiento.

        System.out.println("Ingrese la cantidad:");
        int cantidad = scanner.nextInt();  // Pedir la cantidad.

        try {
            // Llamar al metodo registrarMovimiento de ControlInventario.
            controlInventario.registrarMovimiento(codigo, tipoMovimiento, cantidad, gestionProductos);
        } catch (Exception e) {
            // Mostrar errores si ocurren (ejemplo: stock insuficiente).
            System.out.println(e.getMessage());
        }

    }

    public static void MenuHistorialMovimientos(){
        // Llamar al metodo mostrarHistorial de ControlInventario.
        controlInventario.mostrarHistorial();

    }

    public static void MenuInfoProductos(){
        int opcion;

        do {
            System.out.println("Que desea listar:");
            System.out.println("1.- Vacuno");
            System.out.println("2.- Porcino");
            System.out.println("3.- Avícola");
            System.out.println("4.- Todos los productos");
            System.out.println("5.- Regresar al menú principal");
            System.out.println("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        } while (opcion<1 || opcion>6);

        switch (opcion) {
            case 1:
                gestionProductos.listarProductosVacuno();
                break;
            case 2:
                gestionProductos.listarProductosPorcino();
                break;
            case 3:
                gestionProductos.listarProductosAvicola();
                break;
            case 4:
                gestionProductos.listarTodosLosProductos();
                break;
            case 5:
                MenuModuloControlInventario();
                break;
        }
    }

//    public static void ReporteMovimientosProductos(){
//        System.out.println("Ingrese el nombre del archivo para el reporte (e.g., movimientos.csv): ");
//        scanner.nextLine(); // Consumir cualquier salto de línea pendiente
//        String nombreArchivo = scanner.nextLine();
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
//            // Encabezado del archivo
//            writer.write("Movimiento\n");
//
//            // Obtener y escribir el historial de movimientos
//            List<String> historialMovimientos = controlInventario.getHistorialMovimientos();
//            if (historialMovimientos.isEmpty()) {
//                System.out.println("No hay movimientos registrados en el historial.");
//                return;
//            }
//
//            for (String movimiento : historialMovimientos) {
//                writer.write(movimiento + "\n");
//            }
//
//            System.out.println("Reporte de movimientos exportado a " + nombreArchivo + " exitosamente.");
//        } catch (IOException e) {
//            System.out.println("Error al exportar el reporte de movimientos: " + e.getMessage());
//        }
//
//    }
      public static void ReporteMovimientosProductos() {
          System.out.println("Ingrese el nombre del archivo para el reporte (e.g., movimientos.csv): ");
          scanner.nextLine(); // Consumir cualquier salto de línea pendiente
          String nombreArchivo = scanner.nextLine();

          // Llamar al metodo de la clase Reportes
          reportes.generarReporteMovimientos(controlInventario.getHistorialMovimientos(), nombreArchivo);
    }

}
