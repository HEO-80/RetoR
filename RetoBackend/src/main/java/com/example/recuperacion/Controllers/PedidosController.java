package com.example.recuperacion.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.recuperacion.Models.Pedidos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidosController {

    public static ArrayList<Pedidos> pedidos;

    // Devuelve el listado de pedidos con todos sus campos. No es necesario que se
    // Devuelva el número de productos de cada pedido.

    public PedidosController() {
        pedidos = new ArrayList<Pedidos>();
    }

    @GetMapping("Pedidos")
    public List<Pedidos> GetAllPedidos() {
        return pedidos;
    }

    @GetMapping("/v2/pedidos")
    public static Pedidos getAllPedidos(int idPedido, int idProducto) {
        return PedidosController.getAllPedidos(idProducto, idProducto);
    }

    
    @GetMapping("Pedidos/{idPedido}")
    public static Pedidos GetPedidosById(@PathVariable("idPedido") int idPedido) {
        // Error con los HttpServletRequest y HttpServletResponse
        var p = FindPedidosById(idPedido);
        return p;
    }

    public static Pedidos FindPedidosById(int idPedido) {
        for (Pedidos pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                return pedido;
            }
        }
        return null;
    }

    @GetMapping("/v2/Pedidos/new")
    public static Pedidos addPedido() {
        pedidos.add(new Pedidos());
        return pedidos.get(pedidos.size() - 1); // devuelve el ultimo elemento de la lista (el que hemos añadido)
    }

    @GetMapping("/v2/Pedidos/borrar/{idPedido}")
    public static void borrarPedido(@PathVariable("idPedido") int idPedido) {
        for (Pedidos pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                pedidos.remove(pedido);
                return;
            }
        }
    }

    @PutMapping("/v2/Pedidos/{idPedido}")
    public Pedidos UpdatePedidos(@RequestBody Pedidos updatePedidos,
            @PathVariable("idPedido") int idPedido) throws Exception {
        Pedidos p = FindPedidosById(idPedido);
        p.setIdPedido(updatePedidos.getIdPedido());
        return p;
    }

    @DeleteMapping("/v2/Pedidos/{idPedido}")
    public void DeletePedidos(@PathVariable("idPedido") int idPedido) throws Exception {
        Pedidos p = FindPedidosById(idPedido);
        pedidos.remove(p);
    }

    public static ArrayList<Pedidos> getPedidosByIdPedido(int idPedido) {
        ArrayList<Pedidos> p = pedidos;
        if (idPedido != 0) {
            p = new ArrayList<Pedidos>();
            for (Pedidos pedido : pedidos) {
                if (pedido.getIdPedido() == idPedido)
                    p.add(pedido);
            }
        }
        return p;
    }

}