package com.example;

public class SistemaTienda {
    public static void main(String[] args) {
        ProductoElectronico laptop = new ProductoElectronico(
                "Laptop HP", 2500000, "PROD-0001", 5, "Electrónicos",
                24, "HP", 110, true);

        ProductoAlimenticio leche = new ProductoAlimenticio(
                "Leche Alpina", 4500, "PROD-0002", 20, "Alimentos",
                true, "L001", 5);

        System.out.println("Precio laptop: " + laptop.calcularPrecioElectronico());
        System.out.println("Precio leche: " + leche.calcularPrecioAlimenticio());

        laptop.vender(2);
        laptop.vender(10); // stock insuficiente
        leche.vender(5);

        laptop.reabastecer(3);
        System.out.println("¿Laptop compatible con 120V?: " + laptop.esCompatibleVoltaje(120));

        System.out.println("Estado leche: " + leche.obtenerEstadoFrescura());
        System.out.println("¿Leche próxima a vencer?: " + leche.estaProximoAVencer());
    }
}
