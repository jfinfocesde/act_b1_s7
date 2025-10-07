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
		establecerPrecioBase(precioBase);
		establecerCodigo(codigo);
		establecerCantidadStock(cantidadStock);
		this.categoria = categoria;
		this.activo = true;
	}

	public String obtenerNombre() { return nombre; }
	public double obtenerPrecioBase() { return precioBase; }
	public String obtenerCodigo() { return codigo; }
	public int obtenerCantidadStock() { return cantidadStock; }
	public String obtenerCategoria() { return categoria; }
	public boolean estaActivo() { return activo; }

	public void establecerNombre(String nombre) { this.nombre = nombre; }

	public void establecerPrecioBase(double precioBase) {
		if (precioBase <= 0) {
			throw new IllegalArgumentException("El precio base debe ser mayor que 0");
		}
		this.precioBase = precioBase;
	}

	public void establecerCodigo(String codigo) {
		if (codigo == null || !codigo.matches("PROD-\\d{4}")) {
			throw new IllegalArgumentException("El codigo debe seguir el formato 'PROD-XXXX'");
		}
		this.codigo = codigo;
	}

	public void establecerCantidadStock(int cantidadStock) {
		if (cantidadStock < 0) {
			throw new IllegalArgumentException("La cantidad de stock no puede ser negativa");
		}
		this.cantidadStock = cantidadStock;
	}

	public void establecerCategoria(String categoria) { this.categoria = categoria; }
	public void establecerActivo(boolean activo) { this.activo = activo; }

	public double calcularPrecioFinal() {
		return precioBase * 1.19;
	}

	public boolean hayStock(int cantidad) {
		return activo && cantidadStock >= cantidad;
	}

	public void vender(int cantidad) {
		if (cantidad <= 0) {
			System.out.println("Error: La cantidad a vender debe ser mayor que 0");
			return;
		}
		if (hayStock(cantidad)) {
			cantidadStock -= cantidad;
			System.out.println("Venta exitosa: " + cantidad + " unidades de " + nombre);
		} else {
			System.out.println("Error: Stock insuficiente");
		}
	}

	public void reabastecer(int cantidad) {
		if (cantidad <= 0) {
			System.out.println("Error: La cantidad a reabastecer debe ser mayor que 0");
			return;
		}
		cantidadStock += cantidad;
		System.out.println("Reabastecimiento exitoso: +" + cantidad + " unidades de " + nombre);
	}

	public double calcularDescuento() {
		return 0.0;
	}
}
