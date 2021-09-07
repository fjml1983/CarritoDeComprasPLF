package carritodecompras;

enum TipoProducto{
    BEBIDA,
    FRITURA,
    PAPELERIA,
    CARNES_FRIAS
}

public class Producto {
    private String nombre;
    private double precio;
    private TipoProducto tipo;

    public Producto(String nombre, double precio, TipoProducto tipo){
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
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
        return getNombre(); 
    }
         
}
