package com.example;

public class ProductoAlimenticio extends Producto {

	private boolean refrigerado;
	private String lote;
	private int diasParaVencer;

	public ProductoAlimenticio(String nombre, double precioBase, String codigo, int cantidadStock, String categoria,
							   boolean refrigerado, String lote, int diasParaVencer) {
		super(nombre, precioBase, codigo, cantidadStock, categoria);
		this.refrigerado = refrigerado;
		this.lote = lote;
		this.diasParaVencer = diasParaVencer;
	}

	public boolean esRefrigerado() { return refrigerado; }
	public void establecerRefrigerado(boolean refrigerado) { this.refrigerado = refrigerado; }
	public String obtenerLote() { return lote; }
	public void establecerLote(String lote) { this.lote = lote; }
	public int obtenerDiasParaVencer() { return diasParaVencer; }
	public void establecerDiasParaVencer(int diasParaVencer) { this.diasParaVencer = diasParaVencer; }

	public double calcularDescuentoVencimiento() {
		if (diasParaVencer <= 3) return 0.50;
		if (diasParaVencer <= 7) return 0.30;
		if (diasParaVencer <= 15) return 0.15;
		return 0.0;
	}

	public boolean proximoAVencer() {
		return diasParaVencer <= 7;
	}

	public boolean vencido() {
		return diasParaVencer <= 0;
	}

	public String estadoFrescura() {
		if (vencido()) return "VENCIDO";
		if (diasParaVencer <= 3) return "URGENTE";
		if (diasParaVencer <= 7) return "PRÓXIMO A VENCER";
		if (diasParaVencer <= 15) return "CONSUMIR PRONTO";
		return "FRESCO";
	}

	public double calcularPerdidaPorVencimiento() {
		if (vencido()) return precioBase * cantidadStock;
		return 0.0;
	}

	public double calcularPrecioAlimenticio() {
		double precio = calcularPrecioFinal();
		if (refrigerado) {
			precio += precioBase * 0.08;
		}
		double descuento = calcularDescuentoVencimiento();
		precio = precio - (precio * descuento);
		return precio;
	}
}
