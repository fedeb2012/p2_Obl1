
package obligatorio;

import java.util.*;

/**
 *
 * @author Federico Bello
 */
public class Arcoiris {
    private String [][] tablero;
    private ArrayList<Jugador> listaJugador;
    private ArrayList<Partida> listaPartidas;
    private ArrayList<Configuracion> listaConfiguracion;
    
    //Constructores
    public Arcoiris(){
        tablero = new String[14][14];
        listaJugador = new ArrayList<Jugador>();
        listaPartidas = new ArrayList<Partida>();
        listaConfiguracion = new ArrayList<Configuracion>();
        for (int i = 0; i < this.tablero.length; i++) {  
            for (int j = 0; j < this.tablero[i].length; j++) {
                this.tablero[i][j]="o";
            }
        }
    }
    
    //Getter and Setter
    public void setTablero(String [][] unTablero){
        this.tablero=unTablero;
    }
    
    public void agregarJugador(Jugador unJugador){
        this.listaJugador.add(unJugador);
    }
    
    public void agregarConfiguracion(Configuracion unaConfiguracion){
        this.listaConfiguracion.add(unaConfiguracion);
    }
    
    public void agregarPartida(Partida unaPartida){
        this.listaPartidas.add(unaPartida);
    }
    
    public ArrayList<Jugador> devolverListaJugador(){
        return listaJugador;
    }
    
    public ArrayList<Configuracion> devolverListaConfiguracion(){
        return listaConfiguracion;
    }
    
    public ArrayList<Partida> devolverListaPartidas(){
        return listaPartidas;
    }
    
    public String[][] getTablero(){
        return this.tablero;
    }
    
    public Configuracion devolverUltimaConfiguracion(){
        return listaConfiguracion.get(listaConfiguracion.size()-1);
    }
    
    public Partida devolverUltimaPartida(){
        return listaPartidas.get(listaPartidas.size()-1);
    }
    
    public Partida buscarPartida(int unId) {
        Partida unaPartida;
        int aux;
        
        unaPartida = new Partida();
        unaPartida.setId(unId);
        
        aux = this.devolverListaPartidas().indexOf(unaPartida);
        
        if(aux == -1){
            return null;
        }
        else{
            return this.devolverListaPartidas().get(aux);
        }
    }
    
    public boolean existeJugador(String unAlias) {
        Jugador dosJugador;

        dosJugador = new Jugador();
        dosJugador.setAlias(unAlias);
        
        return (this.devolverListaJugador().contains(dosJugador));
    }
    
    public Jugador buscarJugador(String unAlias) {
        Jugador unJugador;
        int aux;
        
        unJugador = new Jugador();
        unJugador.setAlias(unAlias);
        
        aux = this.devolverListaJugador().indexOf(unJugador);
        
        if(aux == -1){
            return null;
        }
        else{
            return this.devolverListaJugador().get(aux);
        }
    }
}
