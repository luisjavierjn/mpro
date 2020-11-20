package ngc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import daos.ClienteDAO;
import entidades.ModeloCliente;
import mpro.Cliente;


@Repository
@Transactional
@Component("clienteDao")
public class ClienteDAOImpl implements ClienteDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	 @SuppressWarnings("unchecked")
	  public List getAll() {
	    return entityManager.createQuery("from ModeloCliente").getResultList();
	  }
	 
	 public void insertarCliente(ModeloCliente modeloCliente){
		 this.entityManager.persist(modeloCliente);
	 }
	 
	 public void updateCliente(ModeloCliente modeloCliente){
		 this.entityManager.merge(modeloCliente);
	 }

	 //http://stackoverflow.com/questions/19078264/removing-a-detached-instance-error-on-delete
	 public void deleteCliente(ModeloCliente modeloCliente){
		 if (this.entityManager.contains(modeloCliente))
	      this.entityManager.remove(modeloCliente);
	    else
	      this.entityManager.remove(this.entityManager.merge(modeloCliente));
	    return;		 
	 }	 
	 
	 public ModeloCliente getById(long id) {
		    return entityManager.find(ModeloCliente.class, id);
	  }

}
