package carritodecompras;

public class Principal {
    public static void main(String[] args) {
        CarritoDeCompras carrito = new CarritoDeCompras();
        
        carrito.agregarProducto(new Producto("Coca-Cola 350ml", 10, TipoProducto.BEBIDA ));
        carrito.agregarProducto(new Producto("Coca-Cola 350ml", 12, TipoProducto.BEBIDA ));
        carrito.agregarProducto(new Producto("Coca-Cola 350ml", 10, TipoProducto.BEBIDA ));
        carrito.agregarProducto(new Producto("Doritos Nachos 150g", 12, TipoProducto.FRITURA));
        carrito.agregarProducto(new Producto("Mirinda 350ml", 8.5, TipoProducto.BEBIDA ));
        carrito.agregarProducto(new Producto("Pollo fresco 500g", 50, TipoProducto.CARNES_FRIAS ));
        carrito.agregarProducto(new Producto("Pollo fresco 500g", 50, TipoProducto.CARNES_FRIAS ));
        carrito.agregarProducto(new Producto("Libreta Prof. 100 hojas Scribe", 20.5, TipoProducto.PAPELERIA ));
        carrito.agregarProducto(new Producto("Libreta Fran. 90 hojas Scribe", 26, TipoProducto.PAPELERIA ));
        carrito.agregarProducto(new Producto("Libreta Fran. 90 hojas Scribe", 25, TipoProducto.PAPELERIA ));
        
              
        System.out.println("Total del carrito: " + carrito.calcularTotal());                      
        
        System.out.println("\nLos artículos de papelería en el carrito son: " + 
                            carrito.filtrarProductosPorTipo(TipoProducto.PAPELERIA));
        
        System.out.println("\nLos tipos de producto distintos en el carrito son: " +
                            carrito.obtenerTiposDeProductoDistintos());
        
        System.out.println("\nLos productos distintos en el carrito son: " +
                            carrito.obtenerProductosDistintos());
        
        System.out.println("\nLos productos en el carrito de compras por orden, son: " + 
                            carrito.obtenerProductosOrdenados());
        
        System.out.println("\nAplicar un 10% de descuento a los productos de PAPELERIA" +
                            carrito.obtenerProductosAplicandoDescuento(10,TipoProducto.PAPELERIA));
        
        System.out.println("\nLa lista de productos de carrito en formato JSON: " +
                            carrito.obtenerProductosFormatoJSON());
        
        
        System.out.println("\nProductos del carrito de compras agrupados por tipo:" +
                            carrito.obtenerProductosAgrupadosPorTipo());
        
        System.out.println("\nPrecio promedio de lo que llevamos en el carrito: " +
                            carrito.obtenerPrecioPromedio());
        
    }   
}
