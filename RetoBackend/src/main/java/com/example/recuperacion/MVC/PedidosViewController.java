package com.example.recuperacion.MVC;

import com.example.recuperacion.Controllers.PedidosController;
import com.example.recuperacion.Controllers.ProductosController;

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

    @GetMapping("/pedidos/new")
    public ModelAndView CreatePedido() {
        ModelAndView m = new ModelAndView("home");
        m.addObject("pedido", PedidosController.addPedido());
        m.addObject("productos", ProductosController.productos);
        return m;
    }
}