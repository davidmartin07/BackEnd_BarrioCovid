package upm.dit.isst.barriocovid.barriocovid.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roleId;
	
	@Column(unique=true, length=20)
	private String nombre;
	
	public Role() {
		
	}
	
	public Role(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", nombre=" + nombre + "]";
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long id) {
		this.roleId = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

