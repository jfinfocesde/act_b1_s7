package com.example;

public class ProductoElectronico extends Producto {
    private int garantiaMeses;
    private String marca;
    private double voltaje;
    private boolean esImportado;

    public ProductoElectronico(String nombre, double precioBase, String codigo, int cantidadStock, String categoria,
                               int garantiaMeses, String marca, double voltaje, boolean esImportado) {
        super(nombre, precioBase, codigo, cantidadStock, categoria);
        this.garantiaMeses = garantiaMeses;
        this.marca = marca;
        this.voltaje = voltaje;
        this.esImportado = esImportado;
    }

    public double calcularPrecioElectronico() {
        double precio = calcularPrecioFinal();
        if (esImportado) precio += precioBase * 0.05;
        double descuento = calcularDescuentoGarantia();
        precio -= precio * descuento;
        return precio;
    }

    public double calcularDescuentoGarantia() {
        if (garantiaMeses >= 24) return 0.10;
        if (garantiaMeses >= 12) return 0.05;
        return 0.0;
    }

    public boolean esGarantiaExtendida() {
        return garantiaMeses > 12;
    }

    public double calcularCostoGarantia() {
        return precioBase * 0.02 * garantiaMeses;
    }

    public boolean esCompatibleVoltaje(double voltajeLocal) {
        double diferencia = Math.abs(voltaje - voltajeLocal);
        return diferencia <= voltajeLocal * 0.10;
    }
}
