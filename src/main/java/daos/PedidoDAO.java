package daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import entidades.ModeloPedido;

@Transactional
public interface PedidoDAO extends CrudRepository<ModeloPedido, Long>{
	
	public ModeloPedido findByPedido(Integer pk_pedido);

}
