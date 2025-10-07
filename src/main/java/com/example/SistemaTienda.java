package com.example;

public class SistemaTienda {
    public static void main(String[] args) {
    ProductoElectronico laptop = new ProductoElectronico(
        "Laptop Gamer", 2500000.0, "PROD-0001", 5, "Electronica",
        24, "MarcaX", 110.0, true);

    ProductoAlimenticio leche = new ProductoAlimenticio(
        "Leche Entera", 4500.0, "PROD-0002", 20, "Alimenticio",
        true, "L-20251006", 5);

    System.out.println("Precio base laptop: " + laptop.obtenerPrecioBase());
    System.out.println("Precio laptop (electronico): " + laptop.calcularPrecioElectronico());

    System.out.println("Precio base leche: " + leche.obtenerPrecioBase());
    System.out.println("Precio leche (alimenticio): " + leche.calcularPrecioAlimenticio());

    laptop.vender(2);
    laptop.vender(10);

    laptop.reabastecer(5);

    double voltajeLocal = 120.0;
    System.out.println("Laptop compatible con " + voltajeLocal + "V? " + laptop.compatibleVoltaje(voltajeLocal));

    leche.vender(5);
    System.out.println("Estado frescura leche: " + leche.estadoFrescura());
    System.out.println("Perdida por vencimiento leche: " + leche.calcularPerdidaPorVencimiento());

    leche.establecerDiasParaVencer(0);
    System.out.println("Estado frescura leche (actualizado): " + leche.estadoFrescura());
    System.out.println("Perdida por vencimiento leche (ahora vencido): " + leche.calcularPerdidaPorVencimiento());

    System.out.println("Laptop - costo de garantia: " + laptop.calcularCostoGarantia());
    System.out.println("Laptop - garantia extendida? " + laptop.garantiaExtendida());
    System.out.println("Leche - esta proximo a vencer? " + leche.proximoAVencer());
    }
}
