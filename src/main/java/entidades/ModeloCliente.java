package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class ModeloCliente {
	
	
	//el problema era q cuanto se manda auto, el espera un valor de algun lado, 
	//creo q de la db, mientras q con identity, la consulta sql se va sin la pk 
	//para q se la asigne mysql 
	
	//Basically, you have two major choices:You can generate the identifier 
	//yourself, in which case you can use an assigned identifier.You can use the 
	//@GeneratedValue annotation and Hibernate will assign the identifier for you.
	//For the generated identifiers you have two options:UUID identifiers.Numerical 
	//identifiers.For numerical identifiers you have three options:IDENTITYSEQUENCETABLEIDENTITY 
	//is only a good choice when you cannot use SEQUENCE (e.g. MySQL) because it disables JDBC 
	//batch updates.SEQUENCE is the preferred option, especially when used with an identifier 
	//optimizer like pooled or pooled-lo.TABLE is to be avoided at any cost since it uses a 
	//separate transaction to fetch the identifier and row-level locks which scales poorly. 
	
	@Id
	@Column(name="pk_persona")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pk_persona;
	
	@Column(name="nombre",nullable=false,precision=45)
	private String nombre;
	
	@Column(name="email",nullable=false,precision=45)
	private String email;
	
	@Column(name="clave",nullable=false,precision=45)
	private String clave;

	public ModeloCliente() {
		super();
	}

	public long getPk_persona() {
		return pk_persona;
	}

	public void setPk_persona(long pk_persona) {
		this.pk_persona = pk_persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "ModeloCliente [pk_persona=" + pk_persona + ", nombre=" + nombre + ", email=" + email + ", clave="
				+ clave + "]";
	}			
		
	
}
