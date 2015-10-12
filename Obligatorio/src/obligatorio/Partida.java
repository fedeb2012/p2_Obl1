
package obligatorio;

import java.util.*;

/**
 *
 * @author Federico Bello
 */

public class Partida {
    private int id;
    private ArrayList<Jugada> listaJugadas;
    private Configuracion configuracion;
    private int movBlanco;
    private int movNegro;
    
    public static int increment = 0;
    
    //Constructores
    public Partida(){

        this.listaJugadas=new ArrayList<Jugada>();
        this.movBlanco=0;
        this.movNegro=0;
        this.id = increment++;
    }
    
    public Partida(Configuracion unaConfiguracion){
        this.setConfiguracion(unaConfiguracion);
        this.listaJugadas=new ArrayList<Jugada>();
        this.id = increment++;
    }
    
    //Getter and Setter
    public int getId(){
        return id;
    }

    public ArrayList<Jugada> getListaJugadas() {
        return listaJugadas;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public int getMovBlanco() {
        return movBlanco;
    }

    public int getMovRestNegro() {
        return movNegro;
    }

    public void setId(int unId){
        this.id=unId;
    }
    
    public void setMovNegro(int movNegro) {
        this.movNegro = movNegro;
    }
    
    public void setListaJugadas(ArrayList<Jugada> listaJugadas) {
        this.listaJugadas = listaJugadas;
    }
    
    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }
    
    public void setMovBlanco(int movBlanco) {
        this.movBlanco = movBlanco;
    }
    
    public void agregarJugada(Jugada unaJugada){
        this.listaJugadas.add(unaJugada);
    }
    
    public Jugada devolverUltimaJugada(){
        return listaJugadas.get(listaJugadas.size()-1);
    }
    
    public String toString(){
        return  "\n Lista Jugadas: "
                + this.getListaJugadas()
                + "\n Configuracion: "
                + this.getConfiguracion();
    }
    
    @Override
    public boolean equals(Object parm1) {
        // Es necesario hacer cast porque el parametro es Object
        return this.getId()==((Partida) parm1).getId();
    }

}
