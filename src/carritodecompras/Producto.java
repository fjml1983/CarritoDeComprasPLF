package carritodecompras;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

enum TipoProducto{
    BEBIDA,
    FRITURA,
    PAPELERIA,
    CARNES_FRIAS,
    PAQUETE
}

public class Producto {
    private String nombre;
    private double precio;
    private TipoProducto tipo;
    private List<Producto> subproductos;

    public Producto(String nombre, double precio, TipoProducto tipo){
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;  
    }
    
    public void agregarSubproducto(Producto p){
        if (subproductos == null) subproductos = new ArrayList<>();
        subproductos.add(p);
    }

    public List<Producto> getSubproductos() {
        return subproductos;
    }         
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }     

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return getNombre() + "[" + getPrecio() + "]"; 
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }
    
    
         
}
