package carritodecompras;

public class Principal {
    public static void main(String[] args) {
        CarritoDeCompras carrito = new CarritoDeCompras();
        
        carrito.agregarProducto(new Producto("Coca-Cola 350ml", 10, TipoProducto.BEBIDA ));
        carrito.agregarProducto(new Producto("Doritos Nachos 150g", 12, TipoProducto.FRITURA));
        carrito.agregarProducto(new Producto("Mirinda 350ml", 8.5, TipoProducto.BEBIDA ));
        carrito.agregarProducto(new Producto("Pollo fresco 500g", 50, TipoProducto.CARNES_FRIAS ));
        carrito.agregarProducto(new Producto("Libreta Prof. 100 hojas Scribe", 20.5, TipoProducto.PAPELERIA ));
        carrito.agregarProducto(new Producto("Libreta Frac. 100 hojas Scribe", 25, TipoProducto.PAPELERIA ));
        
              
        System.out.println("Total del carrito: " + carrito.calcularTotal());                      
        
        System.out.println("Los artículos de papelería en el carrito son: " + 
                            carrito.filtrarProductosPorTipo(TipoProducto.PAPELERIA));
        
        System.out.println("Los tipos de producto distintos en el carrito son: " +
                            carrito.obtenerTiposDeProductoDistintos());
    }   
}
