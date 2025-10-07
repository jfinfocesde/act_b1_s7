package com.example;

  public class SistemaTienda {
    public static void main(String[] args) {

        ProductoElectronico laptop = new ProductoElectronico(
                "Laptop Gamer", 2500000, "PROD-0001", 5, "Electrónicos",
                24, "ASUS", 110, true
        );

        ProductoElectronico celular = new ProductoElectronico(
                "Celular Alta Gama", 1800000, "PROD-0002", 3, "Electrónicos",
                12, "Samsung", 120, false
        );

        ProductoAlimenticio leche = new ProductoAlimenticio(
                "Leche Entera", 4500, "PROD-0003", 20, "Alimentos",
                true, "L202510", 5
        );

        ProductoAlimenticio pan = new ProductoAlimenticio(
                "Pan Integral", 3000, "PROD-0004", 0, "Alimentos",
                false, "L202509", 2
        );

        System.out.println("\n=== INVENTARIO INICIAL ===");
        laptop.mostrarInfo();
        celular.mostrarInfo();
        leche.mostrarInfo();
        pan.mostrarInfo();

        System.out.println("\n=== PRUEBAS DE VENTA ===");
        laptop.vender(2);
        laptop.vender(10);
        pan.vender(1);

        System.out.println("\n=== REABASTECIMIENTO ===");
        pan.reabastecer(15);
        pan.vender(5);

        System.out.println("\n=== CÁLCULOS DE PRECIOS ===");
        System.out.println("Precio base Laptop: $" + laptop.getPrecioBase());
        System.out.println("Precio electrónico Laptop: $" + laptop.calcularPrecioElectronico());
        System.out.println("Precio base Leche: $" + leche.getPrecioBase());
        System.out.println("Precio alimenticio Leche: $" + leche.calcularPrecioAlimenticio());

        System.out.println("\n=== COMPATIBILIDAD DE VOLTAJE ===");
        double voltajeLocal = 120;
        System.out.println("¿Laptop compatible con " + voltajeLocal + "V?: " + (laptop.esCompatibleVoltaje(voltajeLocal) ? "Sí" : "No"));
        System.out.println("¿Celular compatible con " + voltajeLocal + "V?: " + (celular.esCompatibleVoltaje(voltajeLocal) ? "Sí" : "No"));

        System.out.println("\n=== ESTADO DE FRESCURA ===");
        System.out.println("Leche (" + leche.getNombre() + "): " + leche.obtenerEstadoFrescura());
        System.out.println("Pan (" + pan.getNombre() + "): " + pan.obtenerEstadoFrescura());

        System.out.println("\n=== PÉRDIDAS POR VENCIMIENTO ===");
        System.out.println("Leche: $" + leche.calcularPerdidaPorVencimiento());
        System.out.println("Pan: $" + pan.calcularPerdidaPorVencimiento());

        System.out.println("\n=== FUNCIONALIDADES ESPECÍFICAS ===");
        System.out.println("¿Laptop con garantía extendida?: " + (laptop.esGarantiaExtendida() ? "Sí" : "No"));
        System.out.println("Descuento Laptop por garantía: " + (laptop.calcularDescuentoGarantia() * 100) + "%");
        System.out.println("Descuento Leche por vencimiento: " + (leche.calcularDescuentoVencimiento() * 100) + "%");

        // Error lógico 1: Se vende una cantidad negativa (no debería permitirse)
        laptop.vender(-3);

        // Error lógico 2: Se establece un precio base inválido (0) pero el setter lo permite indirectamente
        leche.setPrecioBase(0);

        System.out.println("\n=== ESTADO FINAL ===");
        laptop.mostrarInfo();
        leche.mostrarInfo();
    }
}
