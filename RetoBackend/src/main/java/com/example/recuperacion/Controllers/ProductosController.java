package com.example.recuperacion.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.recuperacion.Models.Productos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductosController {
        public static ArrayList<Productos> productos = new ArrayList(Arrays.asList(

                        new Productos(1, "Teclado", 24,
                                        "https://m.media-amazon.com/images/I/71+zB0JohtS._AC_SY355_.jpg"),
                        new Productos(2, "Mouse", 15,
                                        "https://snpi.dell.com/snp/images/products/large/es-mx~570-AALK/570-AALKr1.jpg"),
                        new Productos(3, "Monitor", 210,
                                        "https://www.digitalavmagazine.com/wp-content/uploads/2020/08/Philips-279C9.jpg"),
                        new Productos(4, "Impresora", 115,
                                        "https://n6x9y4s3.rocketcdn.me/wp-content/uploads/2018/04/impresora.jpg"),
                        new Productos(5, "Proyector", 180, "https://i.blogs.es/4f2dc4/proyector-lg-ah215/450_1000.jpg"),
                        new Productos(6, "Pantalla", 300,
                                        "https://www.ecured.cu/images/9/99/Pantalla_LED.jpg"),
                        new Productos(7, "Móvil", 360.00, "	https://i.blogs.es/8daf7d/web/450_1000.jpg"),
                        new Productos(8, "Tablet", 80.00,
                                        "https://tecnopymes.cl/wp-content/uploads/2015/09/Tablets.jpg"),
                        new Productos(9, "Laptop", 500.00,
                                        "https://www.alebentelecom.es/sites/default/files/notebook.jpg")));

        @GetMapping("Productos")
        public List<Productos> GetAllProductos() {
                return productos;
        }
}