
package obligatorio;

/**
 *
 * @author Federico Bello
 */
public class Jugador {
    //Variables
    private String nombre;
    private String alias;
    private int edad;

    //Constructores
    public Jugador(){
        this.setAlias("Sin Definir");
        this.setNombre("Sin Definir");
        this.setEdad(0);
    }
    
    public Jugador(String unNombre, String unAlias, int unaEdad){
        this.setAlias(unAlias);
        this.setNombre(unNombre);
        this.setEdad(unaEdad);
    }    
    
    //Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString(){
        return    "\n   Alias: " 
                + this.getAlias() 
                + "\n   Nombre: " 
                + this.getNombre()
                + "\n   Edad: " 
                + this.getEdad() ;
        
    }
    
    @Override
    public boolean equals(Object parm1) {
        // Es necesario hacer cast porque el parametro es Object
        return this.getAlias().equals(((Jugador) parm1).getAlias());
    }
}
