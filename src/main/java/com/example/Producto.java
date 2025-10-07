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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase > 0) {
            this.precioBase = precioBase;
        } else {
            System.out.println("Error: El precio base debe ser mayor que 0.");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && codigo.matches("PROD-\\d{4}")) {
            this.codigo = codigo;
        } else {
            System.out.println("Error: El código debe tener el formato 'PROD-XXXX'.");
        }
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        if (cantidadStock >= 0) {
            this.cantidadStock = cantidadStock;
        } else {
            System.out.println("Error: La cantidad en stock no puede ser negativa.");
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
            System.out.println("Error: Stock insuficiente o producto inactivo.");
        }
    }

    public void reabastecer(int cantidad) {
        if (cantidad > 0) {
            cantidadStock += cantidad;
            System.out.println("Reabastecimiento exitoso: +" + cantidad + " unidades de " + nombre);
        } else {
            System.out.println("Error: La cantidad de reabastecimiento debe ser positiva.");
        }
    }

    public double calcularDescuento() {
        return 0.0;
    }

    public void mostrarInfo() {
        System.out.println("=== Información del Producto ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Categoría: " + categoria);
        System.out.println("Precio base: $" + precioBase);
        System.out.println("Precio final (IVA 19%): $" + calcularPrecioFinal());
        System.out.println("Stock: " + cantidadStock);
        System.out.println("Activo: " + (activo ? "Sí" : "No"));
        System.out.println("================");
    }
}
