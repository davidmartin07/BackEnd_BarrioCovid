package upm.dit.isst.barriocovid.barriocovid.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lineaPedidos")
public class LineaPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineaPedidoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Producto producto;

    @Column(nullable = false)
    private Float precioTotalLinea;

    public LineaPedido() {
        super();
    }

    public LineaPedido(Producto producto, Float precioTotalLinea) {
        super();
        this.producto = producto;
        this.precioTotalLinea = precioTotalLinea;
    }

    public Long getLineaPedidoId() {
        return lineaPedidoId;
    }

    public void setLineaPedidoId(Long lineaPedidoId) {
        this.lineaPedidoId = lineaPedidoId;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Float getPrecioTotalLinea() {
        return precioTotalLinea;
    }

    public void setPrecioTotalLinea(Float precioTotalLinea) {
        this.precioTotalLinea = precioTotalLinea;
    }

    @Override
    public String toString() {
        return "LineaPedido [lineaPedidoId=" + lineaPedidoId + ", producto=" + producto + ", precioTotalLinea="
                + precioTotalLinea + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineaPedidoId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LineaPedido other = (LineaPedido) obj;
        return Objects.equals(lineaPedidoId, other.lineaPedidoId);
    }

}
