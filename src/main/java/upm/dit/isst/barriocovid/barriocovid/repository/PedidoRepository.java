package upm.dit.isst.barriocovid.barriocovid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import upm.dit.isst.barriocovid.barriocovid.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    List<Pedido> findByPedidoId (Long pedidoId);

    @Query("select p from Pedido p where p.voluntario.id=?1")
    List<Pedido> pedidosVoluntario (Long voluntarioId);

    @Query("select p from Pedido p where p.comprador.id=?1")
    List<Pedido> pedidosComprador (Long compradorId);

    @Query("select p from Pedido p where p.tienda.id=?1")
    List<Pedido> pedidosTienda (Long tiendaId);

}
