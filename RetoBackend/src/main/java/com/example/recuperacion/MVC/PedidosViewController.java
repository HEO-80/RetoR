package com.example.recuperacion.MVC;

import com.example.recuperacion.Controllers.PedidosController;
import com.example.recuperacion.Controllers.ProductosController;
import com.example.recuperacion.Models.Pedidos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PedidosViewController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView m = new ModelAndView("index");
        m.addObject("pedido", PedidosController.addPedido());
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView m = new ModelAndView("home");
        m.addObject("pedido", PedidosController.addPedido());
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/detallePedidos")
    public ModelAndView verPedidos() {
        ModelAndView m = new ModelAndView("detallePedidos");
        m.addObject("pedido", PedidosController.getAllPedidos(0, 0));
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/pedidos/{idPedido}")
    public ModelAndView GetAllPedidos(
            @RequestParam(name = "idPedido", required = false, defaultValue = "0") int idPedido) {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedido", PedidosController.getPedidosByIdPedido(idPedido));
        mv.addObject("productos", ProductosController.productos);
        if (PedidosController.pedidos.size() == 0) {
            PedidosController.addPedido();
        }
        return mv;
    }

    // nuevo pedido
    @GetMapping("/pedidos/new")
    public ModelAndView CreatePedido() {
        ModelAndView m = new ModelAndView("home");
        m.addObject("pedido", PedidosController.addPedido());
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    // borrar pedido por id
    @GetMapping("/pedidos/borrar/{idPedido}")
    public ModelAndView DeleteOrder(@PathVariable int idPedido) {
        ModelAndView m = new ModelAndView("/home");
        PedidosController.borrarPedido(idPedido);
        Pedidos pedido = PedidosController.addPedido();
        m.addObject("prductos", ProductosController.GetProductosByPedidoId(idPedido));
        m.addObject("pedido", PedidosController.getPedidosByIdPedido(pedido.getIdPedido()).get(idPedido));
        m.addObject("favoritos", PedidosController.GetPedidosById(pedido.getIdPedido()).getListaFavoritos());
        return m;
    }

    // añadir producto a pedido
    @GetMapping("/pedidos/{idPedido}/add/{idProducto}")
    public static ModelAndView addProductoToPedido(@PathVariable("idPedido") int idPedido,
            @PathVariable("idProducto") int idProducto) {
        ModelAndView m = new ModelAndView("home");
        PedidosController.addProductoToPedidos(idPedido, idProducto);
        m.addObject("pedido", PedidosController.GetPedidosById(idPedido));
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    // borrar producto de pedido
    @GetMapping("/pedidos/{idPedido}/remove/{idProducto}")
    public static ModelAndView removeProductoFromPedido(@PathVariable("idPedido") int idPedido,
            @PathVariable("idProducto") int idProducto) {
        ModelAndView m = new ModelAndView("home");
        PedidosController.deleteProductoFromPedidos(idPedido, idProducto);
        m.addObject("pedido", PedidosController.GetPedidosById(idPedido));
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    // añadir a favoritos
    @GetMapping("/pedidos/{idPedido}/favoritos/add/{idProducto}")
    public ModelAndView addProductoToFavoritos(@PathVariable("idPedido") int idPedido,
            @PathVariable("idProducto") int idProducto) {
        ModelAndView m = new ModelAndView("home");
        PedidosController.addProductoAFavoritos(idPedido, idProducto);
        m.addObject("pedido", PedidosController.GetPedidosById(idPedido));
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    // borrar de favoritos
    @GetMapping("/pedidos/{idPedido}/favoritos/remove/{idProducto}")
    public static ModelAndView removeProductoFromFavoritos(@PathVariable("idPedido") int idPedido,
            @PathVariable("idProducto") int idProducto) {
        ModelAndView m = new ModelAndView("home");
        PedidosController.deleteProductoFromFavoritos(idPedido, idProducto);
        m.addObject("pedido", PedidosController.GetPedidosById(idPedido));
        m.addObject("productos", ProductosController.productos);
        return m;
    }
}