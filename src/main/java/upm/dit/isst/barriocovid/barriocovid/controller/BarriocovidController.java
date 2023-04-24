package upm.dit.isst.barriocovid.barriocovid.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import upm.dit.isst.barriocovid.barriocovid.model.Comprador;
import upm.dit.isst.barriocovid.barriocovid.model.LineaPedido;
import upm.dit.isst.barriocovid.barriocovid.model.Pedido;
import upm.dit.isst.barriocovid.barriocovid.model.Producto;
import upm.dit.isst.barriocovid.barriocovid.model.Tienda;
import upm.dit.isst.barriocovid.barriocovid.model.Voluntario;
import upm.dit.isst.barriocovid.barriocovid.repository.CompradorRepository;
import upm.dit.isst.barriocovid.barriocovid.repository.LienaPedidoRepository;
import upm.dit.isst.barriocovid.barriocovid.repository.PedidoRepository;
import upm.dit.isst.barriocovid.barriocovid.repository.ProductoRepository;
import upm.dit.isst.barriocovid.barriocovid.repository.RoleRepository;
import upm.dit.isst.barriocovid.barriocovid.repository.TiendaRepository;
import upm.dit.isst.barriocovid.barriocovid.repository.UsuarioRepository;
import upm.dit.isst.barriocovid.barriocovid.repository.VoluntarioRepository;

@RestController
public class BarriocovidController {

    private final CompradorRepository compradorRepository;
    private final LienaPedidoRepository lienaPedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;
    private final RoleRepository roleRepository;
    private final TiendaRepository tiendaRepository;
    private final UsuarioRepository usuarioRepository;
    private final VoluntarioRepository voluntarioRepository;

    public static final Logger log = LoggerFactory.getLogger(BarriocovidController.class);

    public BarriocovidController(CompradorRepository compradorRepository, LienaPedidoRepository lienaPedidoRepository,
            PedidoRepository pedidoRepository, ProductoRepository productoRepository, RoleRepository roleRepository,
            TiendaRepository tiendaRepository, UsuarioRepository usuarioRepository,
            VoluntarioRepository voluntarioRepository) {
        this.compradorRepository = compradorRepository;
        this.lienaPedidoRepository = lienaPedidoRepository;
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
        this.roleRepository = roleRepository;
        this.tiendaRepository = tiendaRepository;
        this.usuarioRepository = usuarioRepository;
        this.voluntarioRepository = voluntarioRepository;
    }

    @GetMapping("/tiendas")
    List<Tienda> verListaTiendas() {
        return (List<Tienda>) tiendaRepository.findAll();
    }

    @GetMapping("/tiendas/{id}")
    List<Producto> getProductosPorTienda(@PathVariable Long id) {
        Tienda tienda = tiendaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tienda no encontrada"));
        return tienda.getCatalogo();
    }

    @PostMapping("/micarrito/{id}")
    public ResponseEntity<Pedido> crearPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Comprador comprador = compradorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comprador no encontrado"));

        // Asociar cada linea del pedido al producto correspondiente
        for (LineaPedido lineaPedido : pedido.getTicket()) {
            Producto producto = productoRepository.findById(lineaPedido.getProducto().getProductoId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
            lineaPedido.setProducto(producto);
        }

        // Asociar el Pedido con la Tienda correspondiente
        List<Producto> productos = pedido.getTicket().stream()
                .map(LineaPedido::getProducto)
                .collect(Collectors.toList());
        Tienda tienda = productos.get(0).getTienda();
        if (productos.stream().anyMatch(producto -> !producto.getTienda().equals(tienda))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Los productos del pedido no pertenecen a la misma tienda");
        }
        pedido.setTienda(tienda);

        pedido.setComprador(comprador);
        pedido.setHoraDeRecogida(LocalDateTime.now());
        Pedido pedidoGuardado = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoGuardado);
    }

    @PostMapping("/micomercio/{id}")
    ResponseEntity<Producto> crearProducto(@PathVariable Long id, @RequestBody Producto nuevoProducto) {
        Producto productoGuardado = productoRepository.save(nuevoProducto);
        return ResponseEntity.ok().body(productoGuardado);
    }

    @GetMapping("/micomercio/{id}")
    List<Producto> getProductosMiTienda(@PathVariable Long id) {
        Tienda tienda = tiendaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tienda no encontrada"));
        return tienda.getCatalogo();
    }

    @GetMapping("/tienda/{id}")
    ResponseEntity<Map<String, Object>> getProductosYPedidosPorTienda(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        Tienda tienda = tiendaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tienda no encontrada"));

        List<Producto> productos = tienda.getCatalogo();
        List<Pedido> pedidos = pedidoRepository.pedidosTienda(id);

        response.put("productos", productos);
        response.put("pedidos", pedidos);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/voluntario/{id}")
    List<Pedido> verPedidosVoluntario(@PathVariable Long id) {
        return (List<Pedido>) pedidoRepository.pedidosVoluntario(id);
    }

    @GetMapping("/comprador/{id}")
    List<Pedido> verPedidosComprador(@PathVariable Long id) {
        return (List<Pedido>) pedidoRepository.pedidosComprador(id);
    }

}
