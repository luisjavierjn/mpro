package daos;

import java.util.List;

import entidades.ModeloCliente;

public interface ClienteDAO {
	
	public List getAll();
	
	public void insertarCliente(ModeloCliente modeloCliente);
	
	public void updateCliente(ModeloCliente modeloCliente);
	
	public void deleteCliente(ModeloCliente modeloCliente);

	public ModeloCliente getById(long id);
}
