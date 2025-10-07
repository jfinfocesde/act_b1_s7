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

	// Getters y setters
	public int obtenerGarantiaMeses() { return garantiaMeses; }
	public void establecerGarantiaMeses(int garantiaMeses) { this.garantiaMeses = garantiaMeses; }
	public String obtenerMarca() { return marca; }
	public void establecerMarca(String marca) { this.marca = marca; }
	public double obtenerVoltaje() { return voltaje; }
	public void establecerVoltaje(double voltaje) { this.voltaje = voltaje; }
	public boolean esImportado() { return esImportado; }
	public void establecerEsImportado(boolean esImportado) { this.esImportado = esImportado; }

	public double calcularDescuentoGarantia() {
		if (garantiaMeses >= 24) return 0.10;
		if (garantiaMeses >= 12) return 0.05;
		return 0.0;
	}

	public boolean garantiaExtendida() {
		return garantiaMeses > 12;
	}

	public double calcularCostoGarantia() {
		return precioBase * 0.02 * garantiaMeses;
	}

	public boolean compatibleVoltaje(double voltajeLocal) {
		double diff = Math.abs(this.voltaje - voltajeLocal);
		return diff <= (Math.abs(voltajeLocal) * 0.10);
	}

	public double calcularPrecioElectronico() {
		double precio = calcularPrecioFinal();
		if (esImportado) {
			precio += precioBase * 0.05;
		}
		double descuento = calcularDescuentoGarantia();
		precio = precio - (precio * descuento);
		return precio;
	}
}
