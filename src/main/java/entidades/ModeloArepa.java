package entidades;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arepas")
public class ModeloArepa {

	@Id
	@Column(name="pk_arepa")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pk_arepa;

	@Column(name="nombre",nullable=false,precision=45)
	private String nombre;
	
	@Column(name="descripcion",nullable=true,precision=45)
	private String descripcion;
	
	@Column(name="precio",nullable=false)
	private double precio;
	
	public ModeloArepa() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Arepa [pId=" + pk_arepa + ", arepaName=" + nombre + ", arepaDescripcion=" + descripcion + "]";
	}
	
}
