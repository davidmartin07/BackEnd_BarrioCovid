package upm.dit.isst.barriocovid.barriocovid.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import upm.dit.isst.barriocovid.barriocovid.model.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Long>{

    @Query("select t from Tienda t where t.nombreTienda like %?1%")
    Tienda findByNombreTienda(String nombreTienda);

    @Query("select t from Tienda t where t.direccionTienda like %?1%")
    List<Tienda> findByDireccionTienda(String direccionTienda);

    List<Tienda> findByCp(Object cp);
    
}
