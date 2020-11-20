package mpro;

public class ArepaYCliente {
	private Arepa arepa;
	private Cliente cliente;
	
	public ArepaYCliente() {
		// empty
	}
	
	public ArepaYCliente(Arepa arepa, Cliente cliente) {
		super();
		this.arepa = arepa;
		this.cliente = cliente;
	}

	public Arepa getArepa() {
		return arepa;
	}

	public void setArepa(Arepa arepa) {
		this.arepa = arepa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}		
}
