package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class ModeloPedido {

	@Id
	@Column(name="pk_pedido")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pk_pedido;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="fk_persona")
	private ModeloCliente persona;

	@ManyToOne(optional=false)
	@JoinColumn(name="fk_arepa")
	private ModeloArepa arepa;
	
	@Column(name="cantidad",nullable=false)
	private int cantidad;

	public ModeloPedido() {
		super();
	}

	public long getPk_pedido() {
		return pk_pedido;
	}

	public void setPk_pedido(long pk_pedido) {
		this.pk_pedido = pk_pedido;
	}

	public ModeloCliente getPersona() {
		return persona;
	}

	public void setPersona(ModeloCliente persona) {
		this.persona = persona;
	}

	public ModeloArepa getArepa() {
		return arepa;
	}

	public void setArepa(ModeloArepa arepa) {
		this.arepa = arepa;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
