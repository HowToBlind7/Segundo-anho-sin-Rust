package ar.edu.info.unlp.ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Balanza {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private List<Producto> productos;
	
	public Balanza() {
		precioTotal = 0;
		pesoTotal = 0;
		cantidadDeProductos = 0;
		productos = new ArrayList<Producto>();
	}

	public void agregarProducto(Producto producto) {
		precioTotal += producto.getPrecio();
		pesoTotal += producto.getPeso();
		cantidadDeProductos++;
		productos.add(producto);
	}
	
	public Ticket emitirTicket() {
		Ticket ticket = new Ticket(LocalDate.now());
		ticket.setCantidadDeProductos(cantidadDeProductos);
		ticket.setPesoTotal(pesoTotal);
		ticket.setPrecioTotal(precioTotal);
		return ticket;
	}

	public void ponerEnCero() {
		precioTotal = 0;
		pesoTotal = 0;
		cantidadDeProductos = 0;
		productos.clear();
	}
	
	// -> Para los tests ->
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}
	//Ejercicio 4
	public List<Producto> getProductos() {
		return productos;
	}

}
