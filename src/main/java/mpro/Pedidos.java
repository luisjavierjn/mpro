package mpro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import daos.ClienteDAO;
import entidades.ModeloCliente;
import ngc.IArepaNgc;

@RestController
@RequestMapping("/arepas")
public class Pedidos {

	@Autowired
	@Qualifier("arepaUser")
	private IArepaNgc arepaNgcImpl;

	@Autowired
	@Qualifier("clienteDao")
	private ClienteDAO clienteDao;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/listaClientes", method=RequestMethod.GET)
    public @ResponseBody List<ModeloCliente> obtenerClientes() {
		return this.clienteDao.getAll();
    }
	
	@RequestMapping(value="/insertarCliente", method=RequestMethod.PUT)
	public void insertarCliente(@RequestBody ModeloCliente modeloCliente) {
		System.out.println(modeloCliente);
		this.clienteDao.insertarCliente(modeloCliente);
	}	
	
	@RequestMapping(value="/listadearepas", method=RequestMethod.GET)
    public List<Arepa> pedidos() {
		List<Arepa> listaDeArepas = new ArrayList<>();
		listaDeArepas.add(new Arepa("Pelua", 6000));
		listaDeArepas.add(new Arepa("Reina", 6000));
		listaDeArepas.add(new Arepa("Perico", 5500));
        return listaDeArepas;
    }
	
	@RequestMapping(value="/aceptarpedido", method=RequestMethod.POST)
	public void aceptar(@RequestBody List<Arepa> lista) {
		
		for(Arepa arepa: lista) {
			System.out.println(arepa.getNombre() + " " + arepa.getPrecio());
		}
	}
	
	@RequestMapping(value="/aceptarpedido2", method=RequestMethod.POST)
	public List<Arepa> aceptar2(@RequestBody List<Arepa> lista) {
		
		for(Arepa arepa: lista) {
			System.out.println(arepa.getNombre() + " " + arepa.getPrecio());
		}
		
		return lista;
	}
	
	@RequestMapping(value="/aceptarpedido3", method=RequestMethod.POST)
	public void aceptar3(@RequestBody Arepa arepa) {
		
		System.out.println(arepa.getNombre() + " " + arepa.getPrecio());
	}
	
	@RequestMapping(value="/aceptarpedido4", method=RequestMethod.POST)
	public void aceptar4(@RequestParam String nombre, @RequestParam double precio) {
		
		System.out.println(nombre + " " + precio);
	}			

	@RequestMapping(value="/aceptarpedido6", method=RequestMethod.POST)
	public void aceptar6(@RequestParam String cliente, @RequestBody Arepa arepa) {
		
		System.out.println(arepa.getNombre() + " " + arepa.getPrecio() + " " + cliente);
	}				

	//---- esto no funciona porque solo puede haber una variable @RequestBody 
	@RequestMapping(value="/aceptarpedido7", method=RequestMethod.POST)
	public void aceptar7(@RequestBody Arepa arepa, @RequestBody Arepa arepa2, @RequestParam String cliente) {
		
		System.out.println(arepa.getNombre() + " " + arepa.getPrecio() + " " + cliente + " " + arepa2.getNombre() + " " + arepa2.getPrecio());
	}
	
	@RequestMapping(value="/aceptarpedido8", method=RequestMethod.POST)
	public void aceptar8(@RequestBody ArepaYCliente arepadelcliente) {
		
		System.out.println(arepadelcliente.getArepa().getNombre() + " " + arepadelcliente.getCliente().getNombre());
	}
	
	@RequestMapping(value="/aceptarpedido9", method=RequestMethod.DELETE)
	public void aceptar9(@RequestBody Cliente cliente) {
		arepaNgcImpl.almacenarArepa();
		System.out.println("Borrando a " + cliente.getNombre());
	}
	
	@RequestMapping(value="/updateCliente", method=RequestMethod.POST)
	public void updateCliente(@RequestBody ModeloCliente modeloCliente) {
		System.out.println(modeloCliente);
		this.clienteDao.updateCliente(modeloCliente);
	}	
	
	@RequestMapping(value="/deleteCliente", method=RequestMethod.DELETE)
	public void aceptar9(@RequestBody ModeloCliente modeloCliente) {
		this.clienteDao.deleteCliente(modeloCliente);
		System.out.println("Borrando a " + modeloCliente.getNombre());
	}

	@RequestMapping(value="/getClienteById", method=RequestMethod.GET)
    public @ResponseBody ModeloCliente obtenerCliente(long id) {
		ModeloCliente modeloCliente = this.clienteDao.getById(id);
		return modeloCliente;
    }
}
