package carritodecompras;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarritoDeCompras {
    private ArrayList<Producto> productos = new ArrayList<>();
    
    public void agregarProducto(Producto p){
        productos.add(p);
    }
    
    public double calcularTotal(){
        /* Paradigma Imperativo
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
         return total;
        */
       
        /*Paradigma Funcional*/
       return productos.stream()
                .mapToDouble(p -> p.getPrecio())
                .sum();       
    }    
    
    public List<Producto> filtrarProductosPorTipo(TipoProducto tipo){
        /* Paradigma Imperativo     
        ArrayList<Producto> filtrados = new ArrayList<Producto>();
        for (Producto producto : productos) {
            if( producto.getTipo() == tipo){
                filtrados.add(producto);
            }               
        }
        return filtrados;       
        */
        
        /*Paradigma Funcional*/
        return productos.stream()
                .filter(p -> p.getTipo() == tipo )
                .collect(Collectors.toList());
                              
    }    

    List<TipoProducto> obtenerTiposDeProductoDistintos() {
        /*Paradigma Funcional*/
        return productos.stream()
                .map(p -> p.getTipo())
                .distinct()
                .collect(Collectors.toList());
    }
}
