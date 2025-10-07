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

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        if (garantiaMeses >= 0) {
            this.garantiaMeses = garantiaMeses;
        } else {
            System.out.println("Error: La garantía no puede ser negativa.");
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(double voltaje) {
        if (voltaje > 0) {
            this.voltaje = voltaje;
        } else {
            System.out.println("Error: El voltaje debe ser mayor que 0.");
        }
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }

    public double calcularDescuentoGarantia() {
        if (garantiaMeses >= 24) {
            return 0.10;
        } else if (garantiaMeses >= 12) {
            return 0.05;
        } else {
            return 0.0;
        }
    }

    public double calcularPrecioElectronico() {
        double precio = calcularPrecioFinal();
        if (esImportado) {
            precio += precioBase * 0.05;
        }
        double descuento = calcularDescuentoGarantia();
        precio -= precio * descuento;
        return precio;
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

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Marca: " + marca);
        System.out.println("Garantía: " + garantiaMeses + " meses");
        System.out.println("Voltaje: " + voltaje + "V");
        System.out.println("Importado: " + (esImportado ? "Sí" : "No"));
        System.out.println("Garantía extendida: " + (esGarantiaExtendida() ? "Sí" : "No"));
        System.out.println("Costo de garantía: $" + calcularCostoGarantia());
        System.out.println("Precio final electrónico: $" + calcularPrecioElectronico());
        System.out.println("===============================");
    }
}

