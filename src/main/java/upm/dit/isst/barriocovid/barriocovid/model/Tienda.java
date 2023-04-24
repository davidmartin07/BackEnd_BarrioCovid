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
@Table(name = "tiendas")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "tiendaId")
public class Tienda extends Usuario {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 4, max = 25, message = "el tamaño tiene que estar entre 4 y 25")
    @Column(nullable = false)
    private String nombreTienda;

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 4, max = 25, message = "el tamaño tiene que estar entre 4 y 25")
    @Column(nullable = false)
    private String direccionTienda;

    @NotEmpty(message = "no puede estar vacio")
    private Long cp;

    @OneToMany
    @JoinColumn(name = "catalogo_id")
    private List<Producto> catalogo;

    public Tienda() {
        super();
    }

    public Tienda(String username, String password, String nombre, String apellido, String email,
            List<Role> roles,
            @NotEmpty(message = "no puede estar vacio") @Size(min = 4, max = 25, message = "el tamaño tiene que estar entre 4 y 25") String nombreTienda,
            @NotEmpty(message = "no puede estar vacio") Long cp,
            @NotEmpty(message = "no puede estar vacio") @Size(min = 4, max = 25, message = "el tamaño tiene que estar entre 4 y 25") String direccionTienda) {
        super(username, password, nombre, apellido, email, roles);
        this.nombreTienda = nombreTienda;
        this.cp = cp;
        this.direccionTienda = direccionTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getDireccionTienda() {
        return direccionTienda;
    }

    public void setDireccionTienda(String direccionTienda) {
        this.direccionTienda = direccionTienda;
    }

    public Long getCp() {
        return cp;
    }

    public void setCp(Long cp) {
        this.cp = cp;
    }

    public List<Producto> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Producto> catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public String toString() {
        return "Tienda [nombreTienda=" + nombreTienda + ", direccionTienda=" + direccionTienda + ", cp=" + cp
                + ", catalogo=" + catalogo + "]";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
