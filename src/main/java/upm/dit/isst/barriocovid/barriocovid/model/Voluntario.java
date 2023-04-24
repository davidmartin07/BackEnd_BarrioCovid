package upm.dit.isst.barriocovid.barriocovid.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "voluntarios")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "voluntarioId")
public class Voluntario extends Usuario {

    private static final long serialVersionUID = 1L;

    @OneToMany
    @JoinColumn(name = "voluntario_id")
    private List<Pedido> pedidos;

    public Voluntario() {
        super();
    }

    public Voluntario(String username, String password, String nombre, String apellido, String email,
            List<Role> roles) {
        super(username, password, nombre, apellido, email, roles);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Voluntario [pedidos=" + pedidos + "]";
    }

}
