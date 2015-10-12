
package obligatorio;

/**
 *
 * @author Federico Bello
 */
public class Configuracion {
    private int cuadradoConcentrico;
    private int distribucion;
    private int terminacion;
    private int cantMovMax;
    private Jugador jugadorBlanco;
    private Jugador jugadorNegro;
    
    //Constructores
    public Configuracion(){
        this.jugadorBlanco=new Jugador();
        this.jugadorNegro=new Jugador();
        this.cuadradoConcentrico=0;
        this.distribucion=0;
        this.terminacion=0;
        this.cantMovMax=0;
    }
    
    public Configuracion( Jugador unJugadorBlanco, Jugador unJugadorNegro, int unCuadradoConcentrico, int unaDistribucion, int unaTerminacion, int unaCantMovMax){
        this.setJugadorBlanco(unJugadorBlanco);
        this.setJugadorNegro(unJugadorNegro);
        this.setCuadradoConcentrico(unCuadradoConcentrico);
        this.setDistribucion(unaDistribucion);
        this.setTerminacion(unaTerminacion);
        this.setCantMovMax(unaCantMovMax);
    }
    
    //Getter and Setter
    public Jugador getJugadorBlanco() {
        return jugadorBlanco;
    }
    
    public void setJugadorBlanco(Jugador jugadorBlanco) {
        this.jugadorBlanco = jugadorBlanco;
    }
     
    public Jugador getJugadorNegro() {
        return jugadorNegro;
    }
    
    public void setJugadorNegro(Jugador jugadorNegro) {
        this.jugadorNegro = jugadorNegro;
    }
        
    public int getCuadradoConcentrico() {
        return cuadradoConcentrico;
    }

    public void setCuadradoConcentrico(int cuadradoConcentrico) {
        this.cuadradoConcentrico = cuadradoConcentrico;
    }

    public int getDistribucion() {
        return distribucion;
    }

    public void setDistribucion(int distribucion) {
        this.distribucion = distribucion;
    }

    public int getTerminacion() {
        return terminacion;
    }

    public void setTerminacion(int terminacion) {
        this.terminacion = terminacion;
    }

    public int getCantMovMax() {
        return cantMovMax;
    }

    public void setCantMovMax(int cantMovMax) {
        this.cantMovMax = cantMovMax;
    }
    
    @Override
    public String toString(){
        return    "     Jugador blanco: "
                + this.getJugadorBlanco().getAlias()
                + "\n   Jugador Negro: "
                + this.getJugadorNegro().getAlias()
                + "\n   Cuadrado Concentrico: " 
                + this.getCuadradoConcentrico()
                + "\n   Distribucion: " 
                + this.getDistribucion()
                + "\n   Terminacion: " 
                + this.getTerminacion()
                + "\n   Cantidad maxima movimientos: " 
                + this.getCantMovMax();
    }
}
