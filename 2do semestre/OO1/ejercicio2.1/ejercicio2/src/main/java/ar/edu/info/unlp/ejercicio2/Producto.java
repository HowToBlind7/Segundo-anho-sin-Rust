package ar.edu.info.unlp.ejercicio2;

public class Producto {
	private double peso;
	private double PrecioPorKilo;
	private String descripcion;
	
	public Producto(double peso,  double PrecioPorKilo, String descripcion) {
		this.peso = peso;
		this.PrecioPorKilo = PrecioPorKilo;
		this.descripcion = descripcion;
	}
	
	public Producto() {
	}

	public double getPrecio() {
		return PrecioPorKilo * peso;
	}
	// Puedo agregar este metodo?
	// ->
	public double getPeso() {
		return peso;
	}
	// -> Para los tests ->
	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrecioPorKilo() {
		return PrecioPorKilo;
	}

	public void setPrecioPorKilo(double precioPorKilo) {
		PrecioPorKilo = precioPorKilo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
