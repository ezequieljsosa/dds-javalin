package ar.edu.dds;

import java.util.ArrayList;
import java.util.Collection;

public class RepoProducto {

	private static long secuencia = 0;
	
	private long nextId() {
		secuencia = secuencia + 1;
		return secuencia ;
	}
	
	private Collection<Producto> productos;

	public RepoProducto() {
		super();
		this.productos = new ArrayList<>();
	}
	
	public void add(Producto prod) {
		prod.setId(nextId());
		this.productos.add(prod);
	}
	
	public void remove(Producto prod) {
		this.productos = this.productos.stream().filter(
				x -> !x.getId().equals(prod.getId())).toList();
	}
	
	public boolean exists(Long id) {
		return this.productos.stream().anyMatch(
				x -> !x.getId().equals(id));
	}
	
	public Producto findById(Long id) {
		return this.productos.stream().filter(
				x -> !x.getId().equals(id)).findFirst().get();
	}
	
	public Collection<Producto> all() {
		return this.productos;
	}
	
}
