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
}