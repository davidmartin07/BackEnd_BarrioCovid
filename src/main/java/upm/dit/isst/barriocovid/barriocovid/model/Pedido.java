package upm.dit.isst.barriocovid.barriocovid.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    @NotEmpty(message = "no puede estar vacio")
    @Column(nullable = false)
    private LocalDateTime horaDeRecogida;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<LineaPedido> ticket;

    @ManyToOne
    @JoinColumn(name = "voluntario_id")
    private Voluntario voluntario;

    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private Comprador comprador;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;

    public Pedido() {

    }

    public Pedido(@NotEmpty(message = "no puede estar vacio") LocalDateTime horaDeRecogida, List<LineaPedido> ticket,
            Voluntario voluntario, Comprador comprador, Tienda tienda) {
        this.horaDeRecogida = horaDeRecogida;
        this.ticket = ticket;
        this.voluntario = voluntario;
        this.comprador = comprador;
        this.tienda = tienda;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public LocalDateTime getHoraDeRecogida() {
        return horaDeRecogida;
    }

    public void setHoraDeRecogida(LocalDateTime horaDeRecogida) {
        this.horaDeRecogida = horaDeRecogida;
    }

    public List<LineaPedido> getTicket() {
        return ticket;
    }

    public void setTicket(List<LineaPedido> ticket) {
        this.ticket = ticket;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public String toString() {
        return "Pedido [pedidoId=" + pedidoId + ", horaDeRecogida=" + horaDeRecogida + ", ticket=" + ticket
                + ", voluntario=" + voluntario + ", comprador=" + comprador + ", tienda=" + tienda + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pedidoId == null) ? 0 : pedidoId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (pedidoId == null) {
            if (other.pedidoId != null)
                return false;
        } else if (!pedidoId.equals(other.pedidoId))
            return false;
        return true;
    }

}
