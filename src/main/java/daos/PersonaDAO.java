package daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import entidades.ModeloCliente;
import entidades.ModeloPedido;

@Transactional
public interface PersonaDAO extends CrudRepository<ModeloCliente, Long>{
	
	public ModeloPedido findByPK(Integer pk_pedido);

}
