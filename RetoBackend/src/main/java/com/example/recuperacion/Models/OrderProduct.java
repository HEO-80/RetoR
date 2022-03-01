package com.example.recuperacion.Models;

public class OrderProduct {

    public Productos Productos;
    public int CantProductos;

    public OrderProduct(Productos productos, int cantProductos) { // int idProducto?
        Productos = productos;
        CantProductos = cantProductos;
    }

    public Productos getProductos() {
        return Productos;
    }

    public void setProductos(Productos productos) {
        Productos = productos;
    }

    public int getCantProductos() {
        return CantProductos;
    }

    public void setCantProductos(int cantProductos) {
        CantProductos = cantProductos;
    }

    public void autoCantidad() {
        CantProductos++;
    }

    public void restaCantidad() {
        CantProductos--;
    }

}
