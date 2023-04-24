package upm.dit.isst.barriocovid.barriocovid.model;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long productoId;

	@NotEmpty(message ="no puede estar vacio")
    @Column(length = 25, nullable = false)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private Float precio;

    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false, columnDefinition = "long default 0")
    private Long stock;

    @Column
    private String foto;

	@ManyToOne
    @JoinColumn(name = "catalogo_id")
    private Tienda tienda;

	public Producto(@NotEmpty(message = "no puede estar vacio") String nombre, String descripcion,
			@NotEmpty(message = "no puede estar vacio") Float precio,
			@NotEmpty(message = "no puede estar vacio") Long stock, String foto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.foto = foto;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Producto() {
		super();
	}

	@Override
	public String toString() {
		return "Producto [productoId=" + productoId + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", stock=" + stock + ", foto=" + foto + ", tienda=" + tienda + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(productoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(productoId, other.productoId);
	}
    
}
