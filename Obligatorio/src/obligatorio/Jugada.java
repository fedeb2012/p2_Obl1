
package obligatorio;

/**
 *
 * @author Federico Bello
 */
public class Jugada {
    private int columnaInicio;
    private int filaInicio;
    private int columnaDestino;
    private int filaDestino;
    private int accion;
    
    //Constructores
    public Jugada(){
        this.columnaInicio=0;
        this.filaInicio=0;
        this.columnaDestino=0;
        this.filaDestino=0;
        this.accion=0;
    }
    
    public Jugada(int unaColumnaInicio, int unaFilaInicio, int unaColumnaDestino, int unaFilaDestino/*, int unaAccion*/){
        this.setColumnaInicio(unaColumnaInicio);
        this.setFilaInicio(unaFilaInicio);
        this.setColumnaDestino(unaColumnaDestino);
        this.setFilaDestino(unaFilaDestino);
        //this.setAccion(unaAccion);
    }
    
    //Getter and Setter
    public int getColumnaInicio() {
        return columnaInicio;
    }

    public void setColumnaInicio(int columnaInicio) {
        this.columnaInicio = columnaInicio;
    }

    public int getFilaInicio() {
        return filaInicio;
    }

    public void setFilaInicio(int filaInicio) {
        this.filaInicio = filaInicio;
    }

    public int getColumnaDestino() {
        return columnaDestino;
    }

    public void setColumnaDestino(int columnaDestino) {
        this.columnaDestino = columnaDestino;
    }

    public int getFilaDestino() {
        return filaDestino;
    }

    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }

    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }
     
    public String toString(){
        return    " Movimiento: "
                + this.filaInicio
                + this.columnaInicio
                + "-"
                + this.filaDestino
                + this.columnaDestino
                + "\n Accion: "
                + this.accion;
    }
    
    
}
