package upm.dit.isst.barriocovid.barriocovid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import upm.dit.isst.barriocovid.barriocovid.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

    List<Producto> findByProductoId(Long productoId);

    @Query("select p from Producto p where p.nombre like %?1%")
    Producto findByNombre(String nombre);
    
}
