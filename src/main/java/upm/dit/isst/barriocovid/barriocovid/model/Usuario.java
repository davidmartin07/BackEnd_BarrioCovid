package upm.dit.isst.barriocovid.barriocovid.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.InheritanceType;


@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioId;

	@Column(unique = true, length = 20)
	private String username;

	@Column(length = 60)
	private String password;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@Column(unique = true)
	private String email;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="usuarios_roles", joinColumns= @JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"usuario_id", "role_id"})})
	private List<Role> roles;

	public Usuario(String username, String password, String nombre, String apellido, String email,
			List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.roles = roles;
	}
	
	

	public Usuario() {
		super();
	}



	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long id) {
		this.usuarioId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + ", username=" + username + ", password=" + password 
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", roles=" + roles + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(usuarioId);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(usuarioId, other.usuarioId);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
