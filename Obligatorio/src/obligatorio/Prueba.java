
package obligatorio;

import java.util.*;
import java.lang.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Federico Bello
 */
public class Prueba {

    public static void main(String[] args) {
        //Variables Menues
        int opc; 
        
        Scanner input = new Scanner(System.in);
        
        Arcoiris arcoiris = new Arcoiris();
        
        do {
            opc=menuPrincipal();
            switch(opc){
                case 1: 
                    altaJugador(arcoiris);
                    break;
                    
                case 2:
                    configurarPartida(arcoiris);
                    break;
                
                case 3:
                    jugar(arcoiris);
                    break;
                        
                case 4:
                    ranking(arcoiris);
                    break;
                            
                case 5:
                    replicarPartida(arcoiris);
                    break;
                
                case 97:
                    crearJugadores(arcoiris);
                    break;
                    
                case 98:
                    listarConfiguracion(arcoiris);
                    break;
                    
                case 99:
                    listarJugadores(arcoiris);
                    break;
                
                case 0:
                    break;
                    
                default:
                    caseDefault();
                    break;            
            }
        }
        while (opc!=0);
    }
    
    public static int menuPrincipal(){
        Scanner input = new Scanner(System.in);
        
        limpiarPantalla();
        System.out.print("Welcome to Arcoiris \n"
                            + "  1- Registrar jugador\n"
                            + "  2- Configurar partida\n"
                            + "  3- Jugar\n"
                            + "  4- Ranking\n"
                            + "  5- Replicar partida\n"
                            + "  97- Registrar 5 jugadores\n"
                            + "  98- Listar Configuraciones\n"
                            + "  99- Listar Jugadores\n"
                            + "  0- Salir\n"
                            + "Ingrese una opcion: ");
        int opcion = checkInt();
        
        return opcion;
    }
    
    public static void altaJugador(Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        String enter;
        
        arcoiris.agregarJugador(agregarJugador(arcoiris));
        System.out.print("Presione enter para continuar...");
        enter = input.nextLine();
    }
    
    public static Jugador agregarJugador(Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        String enter;
        String unNombre;
        String unAlias;
        int unaEdad;
        
        do{
            limpiarPantalla();
        
            System.out.println(   "\n  --------------------------------------------- "
                                + "\n |                NUEVO JUGADOR                |"
                                + "\n  --------------------------------------------- ");
            System.out.print("   Ingrese un alias: ");
            unAlias = checkStringVacio(input.nextLine());
            if(arcoiris.existeJugador(unAlias)){
                System.out.println(   "\n  --------------------------------------------- "
                                    + "\n |            EL JUGADOR YA EXISTE             |"
                                    + "\n  --------------------------------------------- ");
                System.out.print("Presione enter para continuar...");
                input.nextLine();
            }
        }while(arcoiris.existeJugador(unAlias));
        
        System.out.print("   Ingrese nombre del jugador: ");
        unNombre=checkStringVacio(input.nextLine());
        
        System.out.print("   Ingrese edad del jugador: ");
        unaEdad=checkInt();
        
        Jugador unJugador = new Jugador(unNombre, unAlias, unaEdad); 
        
        return unJugador;
    }
    
    public static Jugador elegirJugadorBlanco(ArrayList<Jugador> unaListaJugadores, Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        
        int opc;
        int i;
        
        do{
            System.out.println(   "\n  --------------------------------------------- "
                                + "\n |            ELEGIR JUGADOR BLANCO            |"
                                + "\n  --------------------------------------------- ");

            for (i=0;i<=unaListaJugadores.size()-1;i++){
                System.out.println("     " + i + " - " + unaListaJugadores.get(i).getAlias());
            }
            
            System.out.print("   Seleccione una opcion: ");
            opc=input.nextInt();
            
            if (opc<0 || opc >=i){
                System.out.println("   Opcion incorrecta");
            }
        }while(opc<0 || opc >=i);
        
        return arcoiris.buscarJugador(unaListaJugadores.get(opc).getAlias());
        
    }
    
    public static Jugador elegirJugadorNegro(ArrayList<Jugador> unaListaJugadores, Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        
        int opc;
        int i;
        
        do{
            System.out.println(   "\n  --------------------------------------------- "
                                + "\n |            ELEGIR JUGADOR NEGRO             |"
                                + "\n  --------------------------------------------- ");

            for (i=0;i<=unaListaJugadores.size()-1;i++){
                System.out.println("     " + i + " - " + unaListaJugadores.get(i).getAlias());
            }
            
            System.out.print("   Seleccione una opcion: ");
            opc=input.nextInt();
            
            if (opc<0 || opc >=i){
                System.out.println("   Opcion incorrecta");
            }
        }while(opc<0 || opc >=i);
        
        return arcoiris.buscarJugador(unaListaJugadores.get(opc).getAlias());
    }
    
    public static void configurarPartida(Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        String enter;
        
        arcoiris.agregarConfiguracion(agregarConfiguracion(arcoiris));
        System.out.print("Presione enter para continuar...");
        enter = input.nextLine();
    }
    
    public static Configuracion agregarConfiguracion(Arcoiris arcoiris){
        Jugador unJugadorBlanco;
        Jugador unJugadorNegro;
        int unCuadradoConcentrico;
        int unaDistribucion;
        int unaTerminacion;
        int unaCantMovMax;        
    
        ArrayList<Jugador> auxJugadores = new ArrayList<Jugador>(arcoiris.devolverListaJugador());
        
        System.out.println(   "\n  --------------------------------------------- "
                            + "\n |             CONFIGURAR PARTIDA              |"
                            + "\n  --------------------------------------------- ");
        
        unJugadorBlanco = elegirJugadorBlanco(auxJugadores, arcoiris);
        auxJugadores.remove(unJugadorBlanco);
        unJugadorNegro = elegirJugadorNegro(auxJugadores, arcoiris);
        unCuadradoConcentrico = checkCuadradoConcentrico();
        unaDistribucion = checkDistribucion();
        unaTerminacion = checkTerminacion();
        if(unaTerminacion == 1){
            System.out.print("   Ingrese maxima cantidad de movimientos: ");
            unaCantMovMax=checkInt();
        }
        else{
            unaCantMovMax = -1;
        }
        
        Configuracion unaConfiguracion = new Configuracion(unJugadorBlanco, unJugadorNegro, unCuadradoConcentrico, unaDistribucion, unaTerminacion, unaCantMovMax);
        return unaConfiguracion;
    }
    
    public static void agregarPartida(Arcoiris arcoiris){
        Configuracion unaConfiguracion;
        Partida unaPartida;
        
        unaConfiguracion=arcoiris.devolverUltimaConfiguracion();
        
        unaPartida=new Partida(unaConfiguracion);
        
        arcoiris.agregarPartida(unaPartida);
    }
    
    public static void jugar(Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        String enter;
        
        
        limpiarPantalla();
        
        resetTablero(arcoiris);
        
        agregarPartida(arcoiris);
        
        if(arcoiris.devolverUltimaConfiguracion().getTerminacion()==1){
            jugarCantJugadas(arcoiris);
        }
        else{
            jugarConqCentro(arcoiris);
        }
        
    }
    
    public static void jugarCantJugadas(Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        String enter;
        int unTurno=1;
        
        limpiarPantalla();
        
        llenarTableroInicio(arcoiris);
        
        System.out.println("Jugar " + arcoiris.devolverUltimaConfiguracion().getCantMovMax() + " Movimientos");
        
        mostrarTablero(arcoiris);
        
        moverFicha(arcoiris, unTurno);
        
        mostrarTablero(arcoiris);
        
        System.out.print("Presione enter para continuar...");
        enter = input.nextLine();
    }
    
    public static void jugarConqCentro(Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        String enter;
        int unTurno=1;
        
        llenarTableroInicio(arcoiris);
        
        do{
        limpiarPantalla();
        
        System.out.println("Jugar Conquistar Centro");
        
        mostrarTablero(arcoiris);
        
        moverFicha(arcoiris, unTurno);
        
        checkMarco(arcoiris);
        
        unTurno++;
        
        }while(arcoiris.getTablero()[7][7].contains("o"));
        
        mostrarTablero(arcoiris);
        
        System.out.print("Presione enter para continuar...");
        enter = input.nextLine();
        
    }
    
    public static void llenarTableroInicio(Arcoiris arcoiris){
        Configuracion unaConfiguracion = arcoiris.devolverUltimaConfiguracion();
        int unCuadradoConcentrico = unaConfiguracion.getCuadradoConcentrico();
        int unaDistribucion = unaConfiguracion.getDistribucion();
        String [][] unTablero = arcoiris.getTablero();
        
        if (unaDistribucion==1){
            int j;
            Random ran = new Random();
            int [] maximo = {0, 0, 2, 4, 6};

            for (j = 1; j < (14-maximo[unCuadradoConcentrico]); j++) {
                //rand.nextInt((max - min) + 1) + min;
                int columnaRandom = ran.nextInt(((14-unCuadradoConcentrico) - unCuadradoConcentrico) + 1) + unCuadradoConcentrico;
                
                while(!unTablero[unCuadradoConcentrico][columnaRandom].equals("o")){                        
                    columnaRandom = ran.nextInt(((14-unCuadradoConcentrico) - unCuadradoConcentrico) + 1) + unCuadradoConcentrico;
                }
                if(j%2==0){
                    unTablero[unCuadradoConcentrico][columnaRandom]="B"; 
                }
                else {
                    unTablero[unCuadradoConcentrico][columnaRandom]="N";
                }
            }
            for (j = 2; j < (14-maximo[unCuadradoConcentrico]); j++) {
                int columnaRandom = ran.nextInt(((14-unCuadradoConcentrico) - unCuadradoConcentrico) + 1) + unCuadradoConcentrico;
                
                while(!unTablero[columnaRandom][unCuadradoConcentrico].equals("o")){
                    columnaRandom = ran.nextInt(((14-unCuadradoConcentrico) - unCuadradoConcentrico) + 1) + unCuadradoConcentrico;
                }
                if(j%2==0){
                    unTablero[columnaRandom][unCuadradoConcentrico]="B"; 
                }
                else {
                    unTablero[columnaRandom][unCuadradoConcentrico]="N";
                }
            }
            for (j = 1; j < (13-maximo[unCuadradoConcentrico]); j++) {
                int columnaRandom = ran.nextInt(((14-unCuadradoConcentrico) - unCuadradoConcentrico) + 1) + unCuadradoConcentrico;
                
                while(!unTablero[arcoiris.getTablero().length-unCuadradoConcentrico][columnaRandom].equals("o")){
                    columnaRandom = ran.nextInt(((14-unCuadradoConcentrico) - unCuadradoConcentrico) + 1) + unCuadradoConcentrico;
                }
                if(j%2==0){
                    unTablero[arcoiris.getTablero().length-unCuadradoConcentrico][columnaRandom]="B"; 
                }
                else {
                    unTablero[arcoiris.getTablero().length-unCuadradoConcentrico][columnaRandom]="N";
                }
            }
            for (j = 2; j < (13-maximo[unCuadradoConcentrico]); j++) {
                int columnaRandom = ran.nextInt(((14-unCuadradoConcentrico) - unCuadradoConcentrico) + 1) + unCuadradoConcentrico;
                
                while(!unTablero[columnaRandom][arcoiris.getTablero().length-unCuadradoConcentrico].equals("o")){
                    columnaRandom = ran.nextInt(((14-unCuadradoConcentrico) - unCuadradoConcentrico) + 1) + unCuadradoConcentrico;
                }
                if(j%2==0){
                    unTablero[columnaRandom][arcoiris.getTablero().length-unCuadradoConcentrico]="B"; 
                }
                else {
                    unTablero[columnaRandom][arcoiris.getTablero().length-unCuadradoConcentrico]="N";
                }
            }
        }
        else if (unaDistribucion==2){
            for (int j = unCuadradoConcentrico; j < arcoiris.getTablero()[1].length+1-unCuadradoConcentrico; j++) {
                unTablero[unCuadradoConcentrico][j]="N";   
                unTablero[j][unCuadradoConcentrico]="B";
                unTablero[arcoiris.getTablero().length-unCuadradoConcentrico][j]="N";
                unTablero[j][arcoiris.getTablero().length-unCuadradoConcentrico]="B";
            }
            unTablero[arcoiris.getTablero().length-unCuadradoConcentrico][unCuadradoConcentrico]="N";
            unTablero[2][2]="N";
            unTablero[2][12]="N";
            unTablero[12][2]="N";
        }
        else if (unaDistribucion==3){
            for (int j = unCuadradoConcentrico; j < arcoiris.getTablero()[1].length+1-unCuadradoConcentrico; j++) {
                unTablero[unCuadradoConcentrico][j]="N";   
                unTablero[j][unCuadradoConcentrico]="B";   
                unTablero[arcoiris.getTablero().length-unCuadradoConcentrico][j]="B";
                unTablero[j][arcoiris.getTablero().length-unCuadradoConcentrico]="N";
            }
        }                
    }
    
    public static void mostrarTablero(Arcoiris arcoiris){
        String [][] unTablero=arcoiris.getTablero();
        String[] Letras={"0","A","B","C","D","E","F","G","H","I","J","K","L","M"};
        String[] Colores={"0","\033[31m","\033[35m","\033[33m","\033[32m","\033[36m","\033[34m","\033[37m"};
        
        System.out.println("  1 2 3 4 5 6 7 8 9 1 1 1 1");
        System.out.println("                    0 1 2 3");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+-+-+-+");
        for (int i = 1; i < unTablero.length; i++) {
            System.out.print(Letras[i]+"|");
            for (int j = 1; j < unTablero[i].length; j++) {
                if(unTablero[i][j].equals("o")){
                    int aux=i;
                    int aux2=j;
                    if(aux>7){
                        aux=14-aux;
                    }
                    if(aux2>7){
                        aux2=14-aux2;
                    }
                    if(aux>aux2){
                        System.out.print(Colores[aux2]);
                    }
                    else{
                        System.out.print(Colores[aux]);
                    }
                }
                System.out.print(unTablero[i][j]);
                System.out.print("\u001B[0m");
                System.out.print("|");
            }
            System.out.println();
            System.out.println(" +-+-+-+-+-+-+-+-+-+-+-+-+-+");
        }
    }
    
    public static void mostrarTablero2(Arcoiris arcoiris){
        String [][] unTablero=arcoiris.getTablero();
        String[] Letras={"0","A","B","C","D","E","F","G","H","I","J","K","L","M"};
        String[] Colores={"0","\033[31m","\033[35m","\033[33m","\033[32m","\033[36m","\033[34m","\033[37m"};
        
        System.out.println("   1   2   3   4   5   6   7   8   9   1   1   1   1");
        System.out.println("                                       0   1   2   3");
        System.out.println(" + - + - + - + - + - + - + - + - + - + - + - + - + - +");
        for (int i = 1; i < unTablero.length; i++) {
            System.out.print(Letras[i]+"|");
            for (int j = 1; j < unTablero[i].length; j++) {
                if(unTablero[i][j].equals("o")){
                    int aux=i;
                    int aux2=j;
                    if(aux>7){
                        aux=14-aux;
                    }
                    if(aux2>7){
                        aux2=14-aux2;
                    }
                    if(aux>aux2){
                        System.out.print(Colores[aux2]);
                    }
                    else{
                        System.out.print(Colores[aux]);
                    }
                }
                System.out.print(" " + unTablero[i][j] + " ");
                System.out.print("\u001B[0m");
                System.out.print("|");
            }
            System.out.println();
            //System.out.println(" +-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println(" + - + - + - + - + - + - + - + - + - + - + - + - + - +");
        }
    }
    
    public static void moverFicha(Arcoiris arcoiris, int unTurno){
        Scanner input = new Scanner(System.in);
        
        int columnaInicio;
        int filaInicio;
        int columnaDestino;
        int filaDestino;
        String movida;
        
        Jugada unaJugada;
        Partida unaPartida=arcoiris.devolverUltimaPartida();
        
        boolean flag;
        boolean flag2;
        
        String [] partes;
        
        String [][] unTablero=arcoiris.getTablero();
        String [][] aux=new String[1][1];
        
        do{
            
            System.out.print("Elija movida(Ej: A1-B2): ");
            movida=input.nextLine();

            partes=movida.split("-");
            
            flag=checkTurno(partes, unTurno, arcoiris);      
            
            flag2=checkMovimiento(partes, unTablero);
            
        }while (flag || flag2);
        
        columnaInicio=Integer.parseInt(partes[0].substring(1));
        filaInicio=convertFila(partes[0].charAt(0));
        columnaDestino=Integer.parseInt(partes[1].substring(1));
        filaDestino=convertFila(partes[1].charAt(0));
        
        aux[0][0]=unTablero[filaInicio][columnaInicio];
        unTablero[filaInicio][columnaInicio]=unTablero[filaDestino][columnaDestino];
        unTablero[filaDestino][columnaDestino]=aux[0][0];
        
        unaJugada=new Jugada(columnaInicio, filaInicio, columnaDestino, filaDestino);
        
        unaPartida.agregarJugada(unaJugada);
        
        arcoiris.setTablero(unTablero);
        
    }
    
    public static boolean checkTurno(String[] unaParte, int unTurno, Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        String enter;
        
        String [][] unTablero=arcoiris.getTablero();
        String [] bn={"B","N"};
        
        boolean flag=false;
        
        int columnaInicio;
        int filaInicio;
        
        columnaInicio=Integer.parseInt(unaParte[0].substring(1));
        filaInicio=convertFila(unaParte[0].charAt(0));
        
        unTurno=unTurno%2;
        
        if (!bn[unTurno].equals(unTablero[filaInicio][columnaInicio])){
            System.out.println("Debe mover ficha " + bn[unTurno]);
            flag = true;
        }
        
        return flag;
    }
    
    public static boolean checkMovimiento(String [] unaParte, String [][] unTablero){
        Scanner input = new Scanner(System.in);
        String enter;
        
        boolean flag=false;
        
        int columnaInicio;
        int filaInicio;
        int columnaDestino;
        int filaDestino;
        
        columnaInicio=Integer.parseInt(unaParte[0].substring(1));
        filaInicio=convertFila(unaParte[0].charAt(0));
        columnaDestino=Integer.parseInt(unaParte[1].substring(1));
        filaDestino=convertFila(unaParte[1].charAt(0));
        
        int unCuadranteInicio=checkCuadrado(columnaInicio, filaInicio);
        int unCuadranteDestino=checkCuadrado(columnaDestino, filaDestino);
        if(unCuadranteInicio>unCuadranteDestino){
            System.out.println("No puede mover hacia afuera");
            flag=true;
        }
        
        if(!unTablero[filaDestino][columnaDestino].equals("o")){
            System.out.println("El casillero está ocupado");
            flag=true;
        }
        
        return flag;
    }
    
    public static int checkCuadrado(int unaColumnaInicio, int unaFilaInicio){
        int unCuadrante;
        
        if (6 <= unaColumnaInicio && unaColumnaInicio <= 8 && 6 <= unaFilaInicio && unaFilaInicio <= 8){
           unCuadrante=6; 
        }
        else if (5 <= unaColumnaInicio && unaColumnaInicio <= 9 && 5 <= unaFilaInicio && unaFilaInicio <= 9){
           unCuadrante=5; 
        }
        else if (4 <= unaColumnaInicio && unaColumnaInicio <= 10 && 4 <= unaFilaInicio && unaFilaInicio <= 10){
           unCuadrante=4; 
        }
        else if (3 <= unaColumnaInicio && unaColumnaInicio <= 11 && 3 <= unaFilaInicio && unaFilaInicio <= 11){
           unCuadrante=3; 
        }
        else if (2 <= unaColumnaInicio && unaColumnaInicio <= 12 && 2 <= unaFilaInicio && unaFilaInicio <= 12){
           unCuadrante=2; 
        }
        else{
           unCuadrante=1; 
        }
        
        return unCuadrante;
    }
    
    public static void checkMarco(Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        String enter;
        
        /*int[] cuadradoConcentricoMarcoMax = {0, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] cuadradoConcentricoMarcoMin = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        
        Jugada ultimaJugada = arcoiris.devolverUltimaPartida().devolverUltimaJugada();
        
        int columnaDestino = ultimaJugada.getColumnaDestino();
        int filaDestino = ultimaJugada.getFilaDestino();
        
        int fichaMin;
        int fichaMax;
        
        int cuadradoConcentricoMinimo = checkCuadrado(columnaDestino, filaDestino);
        int cuadradoConcentricoMaximo = cuadradoConcentricoMarcoMax[cuadradoConcentricoMinimo];
        
        if (columnaDestino==cuadradoConcentricoMinimo){
            fichaMin=cuadradoConcentricoMinimo;
            fichaMax=cuadradoConcentricoMarcoMax[fichaMin];
        }
        else{
            fichaMin=cuadradoConcentricoMinimo;
            fichaMax=cuadradoConcentricoMarcoMax[fichaMin];
        }
        System.out.println("cuadradoConcentricoMin: " + cuadradoConcentricoMinimo);
        System.out.println("cuadradoConcentricoMax: " + cuadradoConcentricoMaximo);
        System.out.println("fichaMax: " + fichaMax);
        System.out.println("fichaMin: " + fichaMin);
        */
        
        Jugada ultimaJugada = arcoiris.devolverUltimaPartida().devolverUltimaJugada();
        
        String [][] unTablero=arcoiris.getTablero();
        
        int columnaDestino=ultimaJugada.getColumnaDestino();
        int filaDestino=ultimaJugada.getFilaDestino();
        int unCuadradoConcentrico = checkCuadrado(columnaDestino, filaDestino);
        int cont=0;
        
        for (int j = unCuadradoConcentrico; j < unTablero[1].length+1-unCuadradoConcentrico; j++) {
            
            System.out.println("unTablero[filaDestino][columnaDestino]: "+ unTablero[filaDestino][columnaDestino]);
            
            if ((unTablero[unCuadradoConcentrico][j].equals(unTablero[filaDestino][columnaDestino])) && 
                    (((unCuadradoConcentrico+filaDestino)/2)==7) && 
                    (((j+columnaDestino)/2)==7)){
                cont++;
            }
            
            System.out.println("unTablero[unCuadradoConcentrico][j]: "+ unTablero[unCuadradoConcentrico][j]);
            System.out.println("(unCuadradoConcentrico+filaDestino)/2: " + (unCuadradoConcentrico+filaDestino)/2);
            System.out.println("(j+columnaDestino)/2: " + (j+columnaDestino)/2);
            System.out.print("Presione enter para continuar...");
            enter = input.nextLine();
            System.out.println("");
            
            if ((unTablero[j][unCuadradoConcentrico].equals(unTablero[filaDestino][columnaDestino])) && 
                    (((j+filaDestino)/2)==7) && 
                    (((unCuadradoConcentrico+columnaDestino)/2)==7)){
                cont++;
            }
            
            System.out.println("unTablero[j][unCuadradoConcentrico]: "+ unTablero[j][unCuadradoConcentrico]);
            System.out.println("(j+filaDestino)/2: " + (j+filaDestino)/2);
            System.out.println("(unCuadradoConcentrico+columnaDestino)/2: " + (unCuadradoConcentrico+columnaDestino)/2);
            System.out.print("Presione enter para continuar...");
            enter = input.nextLine();
            System.out.println("");
            
            if ((unTablero[unTablero.length-unCuadradoConcentrico][j].equals(unTablero[filaDestino][columnaDestino])) && 
                    (((unTablero.length-unCuadradoConcentrico+filaDestino))/2==7) && 
                    (((j+columnaDestino)/2)==7)){
                cont++;
            }
            
            System.out.println("unTablero[unTablero.length-unCuadradoConcentrico][j]: "+ unTablero[unTablero.length-unCuadradoConcentrico][j]);
            System.out.println("(unTablero.length-unCuadradoConcentrico+filaDestino))/2: " + (unTablero.length-unCuadradoConcentrico+filaDestino)/2);
            System.out.println("(j+columnaDestino)/2: " + (j+columnaDestino)/2);
            System.out.print("Presione enter para continuar...");
            enter = input.nextLine();
            System.out.println("");
            
            if ((unTablero[j][unTablero.length-unCuadradoConcentrico].equals(unTablero[filaDestino][columnaDestino])) && 
                    (((j+filaDestino)/2)==7) && 
                    (((unTablero.length-unCuadradoConcentrico+columnaDestino)/2)==7)){
                cont++;
            }
            
            System.out.println("unTablero[j][unTablero.length-unCuadradoConcentrico]: "+ unTablero[j][unCuadradoConcentrico]);
            System.out.println("(j+filaDestino)/2: " + (j+filaDestino)/2);
            System.out.println("(unTablero.length-unCuadradoConcentrico+columnaDestino)/2: " + (unTablero.length-unCuadradoConcentrico+columnaDestino)/2);
            System.out.print("Presione enter para continuar...");
            enter = input.nextLine();
            System.out.println("");
            
            
            
        }
        
        System.out.println("Cont: " + cont);
        if(cont>=4){
            unTablero[7][7]=unTablero[filaDestino][columnaDestino].toLowerCase();
            System.out.println("Conquisto el centro");
            System.out.print("Presione enter para continuar...");
            enter = input.nextLine();
        }
        System.out.print("Presione enter para continuar...");
        enter = input.nextLine();
    }
    
    public static void agregarJugada(Arcoiris arcoiris){
        
    }
    
    public static void ranking(Arcoiris arcoiris){
        
    }
    
    public static void replicarPartida(Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        String enter;
        Partida unaPartida;
        
        limpiarPantalla();
        
        unaPartida=elegirPartida(arcoiris);
        
        System.out.println(unaPartida);
        System.out.print("Presione enter para continuar...");
        input.nextLine();
    }
    
    public static Partida elegirPartida(Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        
        int opc;
        int i;
        
        do{
            System.out.println(   "\n  --------------------------------------------- "
                                + "\n |              LISTADO PARTIDAS               |"
                                + "\n  --------------------------------------------- ");

            for (i=0;i<=arcoiris.devolverListaPartidas().size()-1;i++){
                System.out.println("     " + i + " - " + arcoiris.devolverListaPartidas().get(i).getConfiguracion().getJugadorBlanco().getAlias() + " vs " + arcoiris.devolverListaPartidas().get(i).getConfiguracion().getJugadorNegro().getAlias());
            }
            
            System.out.print("   Seleccione una opcion: ");
            opc=input.nextInt();
            
            if (opc<0 || opc >=i){
                System.out.println("   Opcion incorrecta");
            }
        }while(opc<0 || opc >=i);
        
        return arcoiris.buscarPartida(arcoiris.devolverListaPartidas().get(opc).getId());
    }
    
    public static void crearJugadores(Arcoiris arcoiris){
        Jugador unJugador = new Jugador("Jugador 1", "J1" , 10);
        arcoiris.agregarJugador(unJugador);
        Jugador dosJugador = new Jugador("Jugador 2", "J2" , 20);
        arcoiris.agregarJugador(dosJugador);
        Jugador tresJugador = new Jugador("Jugador 3", "J3" , 30);
        arcoiris.agregarJugador(tresJugador);
        Jugador cuatroJugador = new Jugador("Jugador 4", "J4" , 40);
        arcoiris.agregarJugador(cuatroJugador);
        Jugador cincoJugador = new Jugador("Jugador 5", "J5" , 50);
        arcoiris.agregarJugador(cincoJugador);
        
    }
    
    public static void listarJugadores(Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        String enter;
        
        System.out.println(arcoiris.devolverListaJugador());
        System.out.print("Presione enter para continuar...");
        enter = input.nextLine();
    }
    
    public static void listarConfiguracion(Arcoiris arcoiris){
        Scanner input = new Scanner(System.in);
        String enter;
        
        System.out.println(arcoiris.devolverListaConfiguracion());
        System.out.print("Presione enter para continuar...");
        enter = input.nextLine();
    }
    
    public static void resetTablero(Arcoiris arcoiris){
        String [][] unTablero = arcoiris.getTablero();
        for (String[] unTablero1 : unTablero) {
            for (int j = 0; j < unTablero1.length; j++) {
                unTablero1[j] = "o";
            }
        }
        
        arcoiris.setTablero(unTablero);
    }
    
    public static int checkInt(){
        Scanner input = new Scanner(System.in);
        int unInt;
        
        while (!input.hasNextInt()) {
            System.out.print("   Debe ingresar un numero: ");
            input.next();
        }
        unInt = input.nextInt();
        
        return unInt;
    }
    
    public static String checkStringVacio(String unString){
        Scanner input = new Scanner(System.in);
        
        while(unString.equals("")){
            System.out.println("   Este campo no puede ser vacio");
            System.out.println("   Ingrese otro valor: ");
            unString=input.nextLine();
        }
        
        return unString;
    }
    
    public static int checkCuadradoConcentrico(){
        Scanner input = new Scanner(System.in);
        
        int unInt=-1;
        
        do {
            System.out.print("   Ingrese cuadrado concentrico(1-4): ");
            unInt = checkInt();
            if((unInt < 1) || (unInt > 4))
                System.out.println("   El cuadrado concentrico debe estar entre 1 y 4");
        } while ((unInt < 1) || (unInt > 4));
        
        return unInt;
    }
    
    public static int checkDistribucion(){
        Scanner input = new Scanner(System.in);
        
        int unaDistribucion;
        do{
           System.out.print("   Distribucion\n"
                   + "     1- Al azar\n"
                   + "     2- Prestablecida I\n"
                   + "     3- Prestablecida L\n"
                   + "   Ingrese una opcion: ");
           unaDistribucion=checkInt();
           if (unaDistribucion < 1 || unaDistribucion > 3){
                System.out.println("   Opcion incorrecta");
                System.out.print("Presione enter para continuar...");
                input.nextLine();
                String enter = input.nextLine();
           }
        }while(unaDistribucion < 1 || unaDistribucion > 3);
        
        return unaDistribucion;
    }
    
    public static int checkTerminacion(){
        Scanner input = new Scanner(System.in);
        
        int unaTerminacion;
        do{
           System.out.print("   Distribucion\n"
                   + "     1- Cantidad jugadas\n"
                   + "     2- Conquistar centro\n"
                   + "   Ingrese una opcion: ");
           unaTerminacion=checkInt();
           if (unaTerminacion < 1 || unaTerminacion > 2){
                System.out.println("   Opcion incorrecta");
                System.out.print("Presione enter para continuar...");
                input.nextLine();
                String enter = input.nextLine();
           }
        }while(unaTerminacion < 1 || unaTerminacion > 2);
        
        return unaTerminacion;
    }
    
    public static int convertFila(char unString){

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);
        map.put("G", 7);
        map.put("H", 8);
        map.put("I", 9);
        map.put("J", 10);
        map.put("K", 11);
        map.put("L", 12);
        map.put("M", 13);
            
        int unInt=map.get(Character.toString(unString));
        
        return unInt;
    }
    
    public static void caseDefault(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("   Opcion incorrecta");
        System.out.print("Presione enter para continuar...");
        String enter = input.nextLine();
    }
    
    public static void limpiarPantalla(){
        for(int clear = 0; clear < 1000; clear++)
                {
                   System.out.println("\b") ;
                }
    }
}
