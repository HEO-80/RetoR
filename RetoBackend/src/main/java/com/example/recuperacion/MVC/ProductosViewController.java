package com.example.recuperacion.MVC;

import com.example.recuperacion.Controllers.PedidosController;
import com.example.recuperacion.Controllers.ProductosController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
// @RestController
@RequestMapping("/")
public class ProductosViewController {

    @GetMapping("/lproductos")
    public ModelAndView verProductos() {
        ModelAndView m = new ModelAndView("listaProductos");
        m.addObject("pedido", PedidosController.pedidos);
        m.addObject("productos", ProductosController.productos);
        return m;
    }
    /*
     * @GetMapping("/lpedidos")
     * public ModelAndView verPedidos() {
     * ModelAndView m = new ModelAndView("detallePedidos");
     * m.addObject("pedido", PedidosController.pedidos);
     * m.addObject("productos", ProductosController.productos);
     * return m;
     * }
     */

    @GetMapping(value = "/lpedidos")
    public ModelAndView mostrarProductos(
            @RequestParam(name = "idPedido", required = false, defaultValue = "0") int idPedido,
            Model model) {
        ModelAndView mv = new ModelAndView("detallePedidos");
        mv.addObject("pedidos", PedidosController.pedidos);
        mv.addObject("productos", ProductosController.productos);
        return mv;
    }

    @GetMapping("/lpedidos/{idPedido}")
    public ModelAndView GetAllPedidos(
            @RequestParam(name = "idPedido", required = false, defaultValue = "0") int idPedido) {
        ModelAndView mv = new ModelAndView("detallePedidos");
        mv.addObject("pedido", PedidosController.getPedidosByIdPedido(idPedido));
        mv.addObject("productos", ProductosController.productos);
        if (PedidosController.pedidos.size() == 0) {
            PedidosController.addPedido();
        }
        return mv;
    }

}