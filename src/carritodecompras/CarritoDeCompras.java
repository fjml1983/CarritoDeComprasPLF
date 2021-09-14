package carritodecompras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
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
        
       DoubleBinaryOperator suma = (acumulador , entrada) -> acumulador + entrada;
        
       return productos.stream()
                .mapToDouble(p -> p.getPrecio())
                //.sum();       
                //.reduce(0, Double::sum);
                .reduce(0, suma);
       
                //  0 + 10 = 10
                // 10 + 12 = 22
                // 22 + 10 = 32
                //...
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
        
        Predicate<Producto> predicado = p -> p.getTipo() == tipo;
        
        /*Paradigma Funcional*/
        return productos.stream()
                .filter(predicado)
                .collect(Collectors.toList());
                              
    }    

    List<TipoProducto> obtenerTiposDeProductoDistintos() {
        
        Function<Producto, TipoProducto> mapper = p -> p.getTipo();
        
        /*Paradigma Funcional*/
        return productos.stream()
                //.peek(p -> System.out.println("Antes del map:" + p))
                .map(mapper)
                //.peek(tp -> System.out.println("Después del map, antes del disctinct:" + tp))
                .distinct()
                //.peek(tp -> System.out.println("Después del disctinct:" + tp))
                .collect(Collectors.toList());
    }

    List<Producto> obtenerProductosDistintos() {        
        /*Paradigma Funcional*/
        return productos.stream()                
                .distinct()
                .collect(Collectors.toList());        
    }

    List<Producto> obtenerProductosOrdenados() {
        Comparator<Producto> comparador = 
                Comparator.comparing(Producto::getNombre)
                    .thenComparing(Producto::getPrecio);
        
        /*Paradigma Funcional*/
        return productos.stream()
                .sorted(comparador)
                .collect(Collectors.toList());        
    }

    List<Producto> obtenerProductosAplicandoDescuento(int pctDescuento, TipoProducto tipo) {
        return productos.stream()
                .peek(p -> {if(p.getTipo()== tipo) p.setPrecio(p.getPrecio() * (100-pctDescuento)/100);})
                .collect(Collectors.toList());        
                
    }

    String obtenerProductosFormatoJSON() {
        return productos.stream()
                .map(p -> { return "{ nombre:" + p.getNombre() + ", precio:" + p.getPrecio() + ", tipo:" + p.getTipo() + "}"; })
                .collect(Collectors.joining(","));        
    }

    Map<TipoProducto, List<Producto>> obtenerProductosAgrupadosPorTipo() {
        return productos.stream()
                .collect(Collectors.groupingBy(Producto::getTipo));
    }

    double obtenerPrecioPromedio() {
        return productos.stream()
                .collect(Collectors.averagingDouble(Producto::getPrecio))
                .doubleValue();
    }
    
       
    
    
}
