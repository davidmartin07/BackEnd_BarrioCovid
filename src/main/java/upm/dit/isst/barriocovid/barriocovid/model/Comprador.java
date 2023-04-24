package upm.dit.isst.barriocovid.barriocovid.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "compradores")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "compradorId")
public class Comprador extends Usuario {

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 4, max = 25, message = "el tamaño tiene que estar entre 4 y 25")
    @Column(nullable = false)
    private String direccion;

    @NotEmpty(message = "no puede estar vacio")
    private Long cp;

    @OneToMany
    @JoinColumn(name = "comprador_id")
    private List<Pedido> pedidos;

    public Comprador() {
        super();
    }

    public Comprador(String username, String password, String nombre, String apellido, String email,
            List<Role> roles, String direccion, Long cp) {
        super(username, password, nombre, apellido, email, roles);
        this.direccion = direccion;
        this.cp = cp;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Comprador [direccion=" + direccion + ", cp=" + cp + "]";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getCp() {
        return cp;
    }

    public void setCp(Long cp) {
        this.cp = cp;
    }

    private static final long serialVersionUID = 1L;
}
