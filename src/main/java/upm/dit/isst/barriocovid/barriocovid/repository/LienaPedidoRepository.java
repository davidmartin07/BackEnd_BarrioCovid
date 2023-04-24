package upm.dit.isst.barriocovid.barriocovid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import upm.dit.isst.barriocovid.barriocovid.model.LineaPedido;

public interface LienaPedidoRepository extends JpaRepository<LineaPedido, Long>{

    List<LineaPedido> findByLineaPedidoId(Long lineaPedidoId);

    List<LineaPedido> findByPrecioTotalLinea(Float precioTotalLinea);
    
}
