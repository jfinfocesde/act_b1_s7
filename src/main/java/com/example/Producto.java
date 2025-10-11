package com.example;

public class Producto {
    protected String nombre;
    protected double precioBase;
    protected String codigo;
    protected int cantidadStock;
    protected String categoria;
    protected boolean activo;

    public Producto(String nombre, double precioBase, String codigo, int cantidadStock, String categoria) {
        this.nombre = nombre;
        setPrecioBase(precioBase);
        setCodigo(codigo);
        setCantidadStock(cantidadStock);
        this.categoria = categoria;
        this.activo = true;
    }

    public String getNombre() { return nombre; }
    public double getPrecioBase() { return precioBase; }
    public String getCodigo() { return codigo; }
    public int getCantidadStock() { return cantidadStock; }
    public String getCategoria() { return categoria; }
    public boolean isActivo() { return activo; }

    public void setPrecioBase(double precioBase) {
        if (precioBase > 0) this.precioBase = precioBase;
    }

    public void setCodigo(String codigo) {
        if (codigo.matches("PROD-\\d{4}")) this.codigo = codigo;
    }

    public void setCantidadStock(int cantidadStock) {
        if (cantidadStock >= 0) this.cantidadStock = cantidadStock;
    }

    public double calcularPrecioFinal() {
        return precioBase * 1.19;
    }

    public boolean hayStock(int cantidad) {
        return activo && cantidadStock >= cantidad;
    }

    public void vender(int cantidad) {
        if (hayStock(cantidad)) {
            cantidadStock -= cantidad;
            System.out.println("Venta exitosa: " + cantidad + " unidades de " + nombre);
        } else {
            System.out.println("Error: Stock insuficiente");
        }
    }

    public void reabastecer(int cantidad) {
        cantidadStock += cantidad;
        System.out.println("Reabastecimiento exitoso: +" + cantidad + " unidades de " + nombre);
    }

    public double calcularDescuento() {
        return 0.0;
    }
}
