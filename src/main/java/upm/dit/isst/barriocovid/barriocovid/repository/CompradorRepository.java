package upm.dit.isst.barriocovid.barriocovid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import upm.dit.isst.barriocovid.barriocovid.model.Comprador;

public interface CompradorRepository extends JpaRepository<Comprador, Long>{

    List<Comprador> findByCp(Long cp);

    @Query("select c from Comprador c where c.direccion=?1")
    Comprador findOneByDireccion(String direccion);

    @Query("select c from Comprador c where c.direccion like %?1%")
    List<Comprador> findByDireccion(String direccion);
    
}
