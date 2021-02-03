/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1segundosemestre;

import java.util.Random;
import java.util.Scanner;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
/**
 *
 * @author Dell
 */
public class Practica1SegundoSemestre {
    public static String nomJugadorUno; //variable para el nombre del primer jugador
    public static String nomJugadorDos; //variable para el nombre del segundo jugador
    public static String letra = "";//caracter para letra de las filas de la matriz
    public static int puntosJugador1 ;//200
    public static int puntosJugador2 ;//200
    public static int aciertosJugador2;//0
    public static int fallosJugador2 ;//0
    public static int aciertosJugador1 ;//0
    public static int fallosJugador1;//0
    public static int tamanioMatrizParaReportes;
    public static int ganoJugador1;
    public static int ganoJugador2;
    public static final int tamanioArregloReportes = 20;
    public static Partida partidasJugadas[] = new Partida[tamanioArregloReportes];
    public static Jugador jugadorReporte[] = new Jugador[tamanioArregloReportes*2];
    public static Jugador jugadorReporteAcomulable[] = new Jugador[tamanioArregloReportes*2];
    
    public static final String rojo = "\033[31m";
    public static final String azul = "\033[34m";
    public static final String reset = "\u001B[0m";

    public static void main(String[] args) {
        //AnsiConsole.systemInstall(); //si se prueba en NetBeans, hay que comentar esta linea, si se prueba el .jar desar descomentada
        // TODO code application logic here

        int mostrarMenuPrincipal = 0;
        String opcionM = "";
        int opcionMenu = 0;
        int mostrarSubMenu = 0;
        String opcionSub = "";
        int opcionSubMenu = 0;
        int cont = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            do {
                try {
                    System.out.println("");
                    System.out.println("######################################################################################################");
                    System.out.println("############################################# MENU ###################################################");
                    System.out.println("OPCIONES:");
                    System.out.println("1. JUEGO");
                    System.out.println("2. REPORTES");
                    System.out.println("3. MOSTRAR INFORMACION DEL ESTUDIANTE");
                    System.out.println("4. SALIR");
                    System.out.println("");
                    System.out.println("INGRESE LA OPCION QUE DESEA SELECCIONAR");
                    System.out.print("->");
                    opcionM = scanner.nextLine(); // mandar string para verificar si es numero
                    if (Integer.parseInt(opcionM) > 0 && Integer.parseInt(opcionM) <= 4) { // si el String parseado es mayor a 0 ingresa al if
                        opcionMenu = Integer.parseInt(opcionM); // el String parseado se iguala a la variable
                    } else {
                        System.out.println("OPCION INVALIDA, INTENTE DE NUEVO"); //si es menor a 1 se muestra el error
                        opcionMenu = 0;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("");
                    System.out.println("ERROR// Ingresar solamente numeros"); //si el String no es numero se lanza la excepcion
                    System.out.println("//////////////////////////////////////////");
                    opcionMenu = 0; //si se lanza la excepcion, se iguala la variable a 0 para que muestre el menu nuevamente
                }
            } while (opcionMenu == 0); // muestra el menu siempre que la variable sea iguala 0

            switch (opcionMenu) { //se evalua el valor ingresado
                case 1:
                    do {
                        if (mostrarSubMenu == 1);

                        do {
                            try {
                                System.out.println("############################################# JUEGO ##################################################");
                                System.out.println("1. Nuevo juego");
                                System.out.println("2. <- Regresar");
                                System.out.println("INGRESE LA OPCION QUE DESEA SELECCIONAR");
                                System.out.print("->");
                                opcionSub = scanner.nextLine();
                                if (Integer.parseInt(opcionSub) > 0 && Integer.parseInt(opcionSub) <= 2) { //se valida el numero igual que arriba pero esta vez con rango
                                    opcionSubMenu = Integer.parseInt(opcionSub);
                                } else {
                                    System.out.println("");
                                    System.out.println("ERROR// Ingrese unicamente numeros positivos ó los numeros que aparecen en el menu.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println(" ");
                                System.out.println("ERROR// Ingrese solamente numeros.");
                                System.out.println("//////////////////////////////////////////");
                                opcionSubMenu = 0;
                            }
                            switch (opcionSubMenu) { // se vuelve a evaluar lo ingresado, en el submenu
                                case 1:
                                    puntosJugador1 = 200;
                                    puntosJugador2 = 200;
                                    aciertosJugador2 = 0;
                                    fallosJugador2 = 0;
                                    aciertosJugador1 = 0;
                                    fallosJugador1 = 0;
                                    iniciarJuego(); //llamada al metodo iniciarJuego()
                                    mostrarSubMenu = 1; //cuando termine el metodo de arriba, se seguira mostrando el submenu
                                    break;
                                case 2:
                                    System.out.println("<- Regresar");
                                    mostrarSubMenu = 0; // si se selecciona regresar, se cambia el valor de la variable para que ya no se muestre
                                    break;
                                default:
                                    System.out.println("Intente de nuevo");
                                    break;
                            }

                        } while (opcionSubMenu == 0); //el ciclo se repite mientras la variable sea igual a 0
                    } while (mostrarSubMenu == 1);//el ciclo se repite mientras la variable sea igual a 1
                    break;
                case 2:
                    String opcionRep;
                    int numRep = 0;
                    int mostrarMenuReportes = 1;
                    do {
                        //if (mostrarSubMenu == 1);
                        do {
                            try {
                                System.out.println("########################################### REPORTES #################################################");
                                System.out.println("   OPCIONES: ");
                                System.out.println("1. MOSTRAR HISTORIAL DE PARTIDAS.");
                                System.out.println("2. MOSTRAR PUNTUACIONES MAS ALTAS.");
                                System.out.println("3. MOSTRAR JUGADORES CON MAYOR CANTIDAD DE FALLOS.");
                                System.out.println("4. MOSTRAR JUGADORES CON MAYOR CANTIDAD DE ACIERTOS.");
                                System.out.println("5. TOP 3 DE JUGADORES QUE MAS HAN GANADO.");
                                System.out.println("6. <- REGRESAR.");
                                System.out.println("");
                                System.out.println("INGRESE LA OPCION QUE DESEA SELECCIONAR.");
                                System.out.print("->");
                                opcionRep = scanner.nextLine();
                                if (Integer.parseInt(opcionRep) > 0 && Integer.parseInt(opcionRep) <= 6) { //se valida el numero igual que arriba pero esta vez con rango
                                    numRep = Integer.parseInt(opcionRep);
                                } else {
                                    System.out.println("");
                                    System.out.println("ERROR// Ingrese unicamente numeros positivos ó los numeros que aparecen en el menu.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println(" ");
                                System.out.println("ERROR// Ingrese solamente numeros.");
                                System.out.println("//////////////////////////////////////////");
                                numRep = 0;
                            }

                            switch (numRep) { // se vuelve a evaluar lo ingresado, en el submenu
                                case 1:
                                    mostrarHistorialDePartidas();
                                    mostrarMenuReportes = 1; //cuando termine el metodo de arriba, se seguira mostrando el submenu
                                    break;
                                case 2:
                                    reporteDeTop(1);
                                    mostrarMenuReportes = 1;
                                    break;
                                case 3:
                                    reporteDeTop(2);
                                    mostrarMenuReportes = 1;
                                    break;
                                case 4:
                                    reporteDeTop(3);
                                    mostrarMenuReportes = 1;
                                    break;
                                case 5:
                                    reporteDeTop(4);
                                    mostrarMenuReportes = 1;
                                    break;
                                case 6:
                                    System.out.println(" <- Regresar");
                                    mostrarMenuReportes = 0; // si se selecciona regresar, se cambia el valor de la variable para que ya no se muestre
                                    break;
                            }

                        } while (numRep == 0); //el ciclo se repite mientras la variable sea igual a 0
                    } while (mostrarMenuReportes == 1);//el ciclo se repite mientras la variable sea igual a 1

                    break;
                case 3:
                    System.out.println("##########################################################");
                    System.out.println("##                                                      ##");
                    System.out.println("##             NOMBRE: EDUARDO TOMAS IXEN RUCUCH        ##");
                    System.out.println("##             CARNET: 201800524                        ##");
                    System.out.println("##             SECCION C                                ##");
                    System.out.println("##                                                      ##");
                    System.out.println("##########################################################");
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    System.exit(0); //termina de ejecutar el programa                    
                    break;
            }

        } while (mostrarMenuPrincipal == 0); //muestra el menu principal mientras que la variable sea igual a 0

    }

    private static void mostrarMatriz(String[][] matriz) {

        for (int fil = 0; fil < matriz.length; fil++) { //recorrer todas las filas de la matriz
            for (int col = 0; col < matriz.length; col++) { //recorrer todas las columnas de la matriz
                System.out.print("| " + matriz[fil][col] + " |"); //imprimir contenido de la matriz
            }
            System.out.println(""); //dejar un espacio por cada fila que se termina y continuar en la fila de abajo
        }
    }

    private static void iniciarJuego() {
        Scanner scanner = new Scanner(System.in); //entrada de datos
        String numeroStr = "";
        int numN = 0;  //numero de filas que tendrá la matriz n*n

        //apartir del do, se evalua el string para ver si es numero y cumple con el rango
        //establecido, si se cumple se captura el valor guardandolo en una variable,
        //de lo contrario se repite el siclo
        do {
            try {
                System.out.println("INGRESE EL NUMERO PARA LA MATRIZ CUADRADA DE AMBOS JUGADORES.");
                System.out.print("->");
                numeroStr = "";
                numN = 0;
                numeroStr = scanner.nextLine(); //capturar numero pero en string para evitar errores
                if (Integer.parseInt(numeroStr) > 0 && Integer.parseInt(numeroStr) <= 26) { //validar rango del numero
                    numN = Integer.parseInt(numeroStr); //asignar el valor evaluado a una variable int
                    tamanioMatrizParaReportes = numN;
                } else {
                    System.out.println("");//si no cumple con el rango, se muestra el mensaje
                    System.out.println("ERROR// Ingresar solo numeros positivos. O en el rango establecido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("");//si no se ingresa un numero, lanzar la excepcion
                System.out.println("ERROR//Ingrese solo numeros");
            }
        } while (numN == 0); //repetir mientrase sea 0

        String[][] matrizJugador1 = new String[numN + 1][numN + 1]; //se crea la matriz de lados n*n para el jugador 1
        String[][] matrizJugador2 = new String[numN + 1][numN + 1]; //se crea la matriz de lados n*n para el jugador 1
        String[][] matrizAuxiliar = new String[numN + 1][numN + 1];
        String[][] matrizAuxiliar2 = new String[numN + 1][numN + 1];
        llenarMatriz(matrizAuxiliar);
        llenarMatriz(matrizAuxiliar2);
        //se manda la matriz de cada jugador a llenar de espacios en blanco para presentarla como tablero
        llenarMatriz(matrizJugador1);
        llenarMatriz(matrizJugador2);
        System.out.println("");
        System.out.println("########################################################################");
        System.out.println("                    MODELO DEL TABLERO PARA AMBOS JUGADORES.");
        System.out.println("########################################################################");
        System.out.println("");
        mostrarMatriz(matrizJugador1);//se muestra una matriz modelo para ambos jugadores

            System.out.println("");
            System.out.println("########################################################################");
            System.out.println("                                  JUGADOR1 ");
            System.out.println("########################################################################");
           
        //verificar que no se agregue nombres vacios y no cerrar el programa al dar enter
        do {
            try {
                nomJugadorUno = "";
                System.out.println("INGRESE SU NOMBRE.");
                System.out.print("->");
                nomJugadorUno = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("No se puede dejar en blanco.");
            }
        } while (nomJugadorUno.equals(""));

        System.out.println("");
            System.out.println("########################################################################");
            System.out.println("                                  JUGADOR2 ");
            System.out.println("########################################################################");
        
        //verificar que no se agregue nombres vacios y no cerrar el programa al dar enter
        do {
            try {
                nomJugadorDos = "";
                System.out.println("INGRESE SU NOMBRE.");
                System.out.print("->");
                nomJugadorDos = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("No se puede dejar en blanco.");
            }
        } while (nomJugadorDos.equals(""));

        Random turnoAleatorio = new Random();
        int turno = turnoAleatorio.nextInt(2);//escoje un numero aleatorio entre 0 y 1

        if (turno == 0) { //si el random es 0, se escoje al jugador 1 primero
            System.out.println("");
            System.out.println("########################################################################");
            System.out.println("                        COMIENZA JUGADOR1: "+nomJugadorUno);
            System.out.println("########################################################################");
            System.out.println("");
            agregarBarco(matrizJugador1); //se llama al metodo agregar barco y se le manda la matriz para colocar los barcos
            
            System.out.println("  ");
            System.out.println("########################################################################");
            System.out.println("                              JUGADOR2: "+nomJugadorDos);
            System.out.println("########################################################################");               
            System.out.println("");
            agregarBarco(matrizJugador2);//cuando terminan de colocarse el primero, sigue el segundo

            //mostrar los tableros de los jugadores ya llenos con barcos
            System.out.println("###########################################################################################################");
            System.out.println("#################################### TABLERO LLENO DE: " + nomJugadorUno + " ####################################");
            mostrarMatriz(matrizJugador1);
            System.out.println("#################################### TABLERO LLENO DE: " + nomJugadorDos + " ####################################");
            mostrarMatriz(matrizJugador2);

            int seguirJugando = 0;
            int seguirJugando2 = 0;
            int cambiarDeTurno = 1;
            do {
                seguirJugando = 0;
                seguirJugando2 = 0;
                cambiarDeTurno++;
                if (cambiarDeTurno % 2 == 0) {
                    batallar(matrizJugador1, matrizJugador2, nomJugadorUno, nomJugadorDos,  matrizAuxiliar);
                
                }else if (cambiarDeTurno % 2 != 0) {
                    batallar(matrizJugador2, matrizJugador1, nomJugadorDos, nomJugadorUno, matrizAuxiliar2);
                    
                }

                for (int fil = 0; fil < matrizJugador1.length; fil++) {
                    for (int col = 0; col < matrizJugador1[fil].length; col++) {
                        if (matrizJugador1[fil][col].equals("*") || matrizJugador1[fil][col].equals("* ")) {
                            seguirJugando++;
                        }
                    }
                }

                for (int fil = 0; fil < matrizJugador2.length; fil++) {
                    for (int col = 0; col < matrizJugador2[fil].length; col++) {
                        if (matrizJugador2[fil][col].equals("*") || matrizJugador2[fil][col].equals("* ")) {
                            seguirJugando2++;
                        }
                    }
                }
                //System.out.println("contador1: "+seguirJugando+" contador2: "+seguirJugando2);

            } while (seguirJugando > 0 && seguirJugando2 > 0);
            
            System.out.println(rojo+"########################################################################"+reset);
            System.out.println(rojo+"############################ JUEGO TERMINADO ###########################"+reset);
            System.out.println(rojo+"##                                                                    ##"+reset);
            if (seguirJugando > 0) {
                System.out.println(rojo+"##"+reset+"       GANADOR: "+ nomJugadorUno+"   PUNTEO: "+puntosJugador1+"   ACIERTOS: "+aciertosJugador1+"   FALLOS: "+ fallosJugador1);
                System.out.println(rojo+"##                                                                    ##"+reset);
                System.out.println(rojo+"########################################################################"+reset);
                System.out.println("");
                System.out.println("");
                ganoJugador1 = 1;
                ganoJugador2 = 0;
                historialDePartidas();
            } else if (seguirJugando2 > 0) {
                System.out.println(rojo+"##"+reset+"      GANADOR: "+ nomJugadorDos+"   PUNTEO: "+puntosJugador2+"   ACIERTOS : "+aciertosJugador2+"   FALLOS : "+ fallosJugador2);
                System.out.println(rojo+"##                                                                    ##"+reset);
                System.out.println(rojo+"########################################################################"+reset);                
                System.out.println("");
                System.out.println("");
                ganoJugador2 = 1;
                ganoJugador1 = 0;
                historialDePartidas();
            }

        } else {
            System.out.println("  ");
            System.out.println("########################################################################");
            System.out.println("                       COMIENZA JUGADOR2: "+nomJugadorDos);
            System.out.println("########################################################################");               
            System.out.println("");
            agregarBarco(matrizJugador2); //si el numero random no es 0, el primer jugador que agregara barcos es el dos

            System.out.println("  ");
            System.out.println("########################################################################");
            System.out.println("                               JUGADOR1: "+nomJugadorUno);
            System.out.println("########################################################################");               
            System.out.println("");
            agregarBarco(matrizJugador1); //cuando el dos termine, sigue el 1

            System.out.println("###########################################################################################################");
            System.out.println("#################################### TABLERO LLENO DE: " + nomJugadorUno + " ####################################");
            mostrarMatriz(matrizJugador1);
            System.out.println("#################################### TABLERO LLENO DE: " + nomJugadorDos + " ####################################");
            mostrarMatriz(matrizJugador2);                        
            
            int seguirJugando = 0;
            int seguirJugando2 = 0;
            int cambiarDeTurno = 1;

            do {
                seguirJugando = 0;
                seguirJugando2 = 0 ;
                cambiarDeTurno++;
                if (cambiarDeTurno % 2 == 0) {
                    batallar(matrizJugador2, matrizJugador1, nomJugadorDos, nomJugadorUno, matrizAuxiliar2);
                    
                } else if (cambiarDeTurno % 2 != 0) {

                    batallar(matrizJugador1, matrizJugador2, nomJugadorUno, nomJugadorDos, matrizAuxiliar);
                    
                }

                for (int fil = 0; fil < matrizJugador1.length; fil++) {
                    for (int col = 0; col < matrizJugador1[fil].length; col++) {
                        if (matrizJugador1[fil][col].equals("*") || matrizJugador1[fil][col].equals("* ")) {
                            seguirJugando++;
                        }
                    }
                }

                for (int fil = 0; fil < matrizJugador2.length; fil++) {
                    for (int col = 0; col < matrizJugador2[fil].length; col++) {
                        if (matrizJugador2[fil][col].equals("*") || matrizJugador2[fil][col].equals("* ")) {
                            seguirJugando2++;
                        }
                    }
                }

            } while (seguirJugando > 0 && seguirJugando2 > 0);

            System.out.println(rojo+"########################################################################"+reset);
            System.out.println(rojo+"############################ JUEGO TERMINADO ###########################"+reset);
            System.out.println(rojo+"##                                                                    ##"+reset);
            if (seguirJugando > 0) {
                System.out.println(rojo+"##"+reset+"      GANADOR: "+ nomJugadorUno+"   PUNTEO: "+puntosJugador1+"   ACIERTOS: "+aciertosJugador1+"   FALLOS: "+ fallosJugador1);
                System.out.println(rojo+"##                                                                    ##"+reset);
                System.out.println(rojo+"########################################################################"+reset);
                System.out.println("");
                System.out.println("");
                ganoJugador1 = 1;
                ganoJugador2 = 0;
                historialDePartidas();
            } else if (seguirJugando2 > 0) {
                System.out.println(rojo+"##"+reset+"      GANADOR: "+ nomJugadorDos+"   PUNTEO: "+puntosJugador2+"   ACIERTOS: "+aciertosJugador2+"   FALLOS: "+ fallosJugador2);
                System.out.println(rojo+"##                                                                    ##"+reset);
                System.out.println(rojo+"########################################################################"+reset);                
                System.out.println("");
                System.out.println("");
                ganoJugador2 = 1;
                ganoJugador1 = 0;
                historialDePartidas();
            }

        }
    }

    private static void agregarBarco(String[][] matrizJugador) {
        //contadores para agregar barcos, en 0 ya no agrega
        int contadorBarco4C = 1;
        int contadorBarco3C = 2;//prueba 1, entrega 2
        int contadorBarco2C = 3;// prueba 1, entrega 3
        int contadorBarco1C = 4;//para pruebas usar 1.. entregar 4
        int tamanioBarco;
        boolean contadoresVacios = true;

        Scanner scanner = new Scanner(System.in);

        do { //ciclo que se repite hasta que los contadores de barcos queden en 0
            String selecOp = "";
            int seleccionarOpcion = 0;

            do {
                try {
                    System.out.println("OPCIONES:");
                    System.out.println("1. Colocar barco de 4 casillas (" + contadorBarco4C + " disponibles).");
                    System.out.println("2. Colocar barco de 3 casillas (" + contadorBarco3C + " disponibles).");
                    System.out.println("3. Colocar barco de 2 casillas (" + contadorBarco2C + " disponibles).");
                    System.out.println("4. Colocar barco de 1 casillas (" + contadorBarco1C + " disponibles).");
                    System.out.println("");

                    mostrarMatriz(matrizJugador);//mostrar la matriz
                    System.out.println("");
                    System.out.println("INGRESE EL NUMERO DE LA OPCION QUE SELECCIONARA.");
                    System.out.print("->");
                    //verificar que se agregue un numero que cumpla con lo requerido
                    selecOp = "";
                    seleccionarOpcion = 0;
                    selecOp = scanner.nextLine();
                    if (Integer.parseInt(selecOp) > 0 && Integer.parseInt(selecOp) <= 4) {
                        seleccionarOpcion = Integer.parseInt(selecOp);
                        System.out.println("OPCION "+seleccionarOpcion+ " SELECCIONADA.");
                        //scanner.nextLine();
                    } else {
                        System.out.println("");
                        System.out.println("ERROR// Vuelva a intentarlo");
                        //scanner.nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("");
                    System.out.println("ERROR//Ingrese solo numeros");
                }
            } while (seleccionarOpcion == 0); //se seguira mostrando el mensaje mientras no se capture un valor

            switch (seleccionarOpcion) { //evaluar opcion capturada
                case 1:
                    if (contadorBarco4C > 0) { //para ingresar, los contadores no deben de estar en 0
                        System.out.println("AGREGANDO BARCO DE 4 CASILLAS");
                        tamanioBarco = 4; //mandar el tamaño del barco que queremos agregar
                        validarPosicionDeBarcoEnMatriz(tamanioBarco, matrizJugador, contadorBarco4C); //mandar datos al metodo para que lo use
                        contadorBarco4C--; //reducir el contador en 1 cada vez que se agregue un barco
                    } else {
                        System.out.println("ERROR// Ya no cuenta con barcos de 4 espacios");
                    }
                    break;
                case 2:
                    if (contadorBarco3C > 0) { //verificar contador > 0
                        System.out.println("AGREGANDO BARCO DE 3 CASILLAS");
                        tamanioBarco = 3;
                        validarPosicionDeBarcoEnMatriz(tamanioBarco, matrizJugador, contadorBarco3C);
                        contadorBarco3C--;
                    } else {
                        System.out.println("ERROR// Ya no cuenta con barcos de 3 espacios");
                    }
                    break;
                case 3:
                    if (contadorBarco2C > 0) {
                        System.out.println("AGREGANDO BARCO DE 2 CASILLAS");
                        tamanioBarco = 2;
                        validarPosicionDeBarcoEnMatriz(tamanioBarco, matrizJugador, contadorBarco2C);
                        contadorBarco2C--;
                    } else {
                        System.out.println("ERROR// Ya no cuenta con barcos de 2 espacios.");
                    }
                    break;
                case 4:
                    if (contadorBarco1C > 0) {
                        System.out.println("AGREGANDO BARCO DE 1 CASILLA");
                        tamanioBarco = 1;
                        validarPosicionDeBarcoEnMatriz(tamanioBarco, matrizJugador, contadorBarco1C);
                        contadorBarco1C--;
                    } else {
                        System.out.println("ERROR// Ya no cuenta con barcos de 1 espacio.");
                    }
                    break;
                default:
                    System.out.println("No existe esa opcion.");
                    break;
            }
            if (contadorBarco1C == 0 && contadorBarco2C == 0 && contadorBarco3C == 0 && contadorBarco4C == 0) { //verificar si aun cuento con barcos para agregar
                contadoresVacios = false;
            }
        } while (contadoresVacios); //repetir ciclo hasta que los contadores queden vacios//while repite si es true
        
        
    }

    private static void llenarMatriz(String[][] matriz) {
        int contador = 0; //contador para los numeros de las columnas
        int contador2 = -1; //contador para las letras de las filas
        //System.out.println(" ");

        for (int fil = 0; fil < matriz.length; fil++) {  //siclo que recorre las filas de la matriz
            for (int col = 0; col < matriz.length; col++) { //siclo que recorre las columnas de la matriz
                if (fil == 0 && col > 0) {  //si el numero de la fila es == 0 y el numero de la columna es mayor a 0 (se tomara solo la primera fila con todas las columnas para agregar su numero)
                    contador++; //aumentar el contador en uno, para agregarselo a la matriz
                    String contadorString = Integer.toString(contador); //convertir contador que es int a string para usarlo como numero de columnas
                    matriz[fil][col] = contadorString; //agregar el numero convertido a string a la primera fila de la matriz
                } else if (col == 0 && fil > 0) { //verificar si la columna es == 0 y las filas son mayores a 0 para tomar solo la primera columna con todas las filas para agregar las letras identificadoras
                    contador2++; //contador para que las letras del abecedario aumenten de uno en uno
                    char le = (char) ('A' + contador2); //aumentar la variable en uno, comenzando con A (se casteó el char)
                    letra = Character.toString(le); //se convirtio de char a String

                    matriz[fil][col] = letra; //agregar las letras a la primera columna de la matriz, para identificar
                } else {
                    if (col > 9) { //si hay mas de nueve columnas, agregar dos espacios en las demas posiciones
                        matriz[fil][col] = "  ";
                    } else {
                        matriz[fil][col] = " "; //a todos los demas agregar solo un espacio
                    }
                }
            }
        }
        //mostratMatriz(matriz);
    }

    private static void validarPosicionDeBarcoEnMatriz(int tamanioBarco, String[][] matriz, int contadorBarco ) {
        int filaInicial = 0;
        int columnaInicial = 0;
        int filaFinal = 0;
        int columnaFinal = 0;
        boolean aceptado;
        int estaLleno;
        int estaVacio;
        String selecCol;
        String selecColFinal;
        Scanner scanner = new Scanner(System.in);

        do { //ciclo que se repetira cada vez que se quiera ingresar un barco con dimenciones incorrectas o sobre otro
            estaLleno = 0; //contador para verificar si un barco ocupa o no una posicion en la matriz
            estaVacio = 0;
                                
            System.out.println("################################## INICIO ######################################");

            do {//ciclo que se repite hasta que se ingrese la fila de manera correcta
                try {//bloque para intentar capturar el valor de la fila de inicio
                    System.out.println("INGRESE LA FILA DE INICIO (A-" + letra + ")");
                    System.out.print("->");
                    String mandarLetraFila;
                    filaInicial = 0;
                    mandarLetraFila = scanner.nextLine();
                    if (cambiarLetraANumero(mandarLetraFila) < matriz.length) { //se manda la letra recibida para que me regrese un numero
                        filaInicial = cambiarLetraANumero(mandarLetraFila); //si el numero es valido, se asigna a una variable int
                    } else {
                        System.out.println("ERROR// el valor es invalido, intente de nuevo.");
                        System.out.println("");
                    }
                } catch (Exception e) { //lanzar excepcion si se manda un valor incorrecto
                    System.out.println("ERROR// Intente de nuevo");
                    System.out.println("");
                }
            } while (filaInicial == 0); //ciclo que se repite mientras no se capture un valor

            int rangoDeColumnas = matriz.length - 1;

            do {
                try {
                    System.out.println("INGRESE LA COLUMNA DE INICIO (1-" + rangoDeColumnas + ")");
                    System.out.print("->");
                    selecCol = "";
                    columnaInicial = 0;
                    selecCol = scanner.nextLine();
                    if (Integer.parseInt(selecCol) > 0 && Integer.parseInt(selecCol) <= rangoDeColumnas) {
                        columnaInicial = Integer.parseInt(selecCol);
                    } else {
                        System.out.println("");
                        System.out.println("ERROR// Valor incorrecto, vuelva a intentarlo.");
                    }
                } catch (Exception e) {
                    System.out.println("");
                    System.out.println("ERROR//Ingrese solo numeros");
                    //scanner.nextLine();
                }
            } while (columnaInicial == 0); //se seguira mostrando el mensaje mientras no se capture un valor


            if (tamanioBarco == 1) { //condicional para barcos de tamaño 1, solo se piden los valores de inicio
                filaFinal = filaInicial;
                columnaFinal = columnaInicial;
            } else { //si no es de tamaño 1, tambien se piden los valores finales
                        System.out.println("################################## FINAL ######################################");
                do {
                    try {
                        System.out.println("INGRESE LA FILA FINAL (A-" + letra + ")");
                        System.out.print("->");
                        String mandarLetraF;
                        filaFinal = 0;
                        mandarLetraF = scanner.nextLine();
                        if (cambiarLetraANumero(mandarLetraF) < matriz.length) { //mandar letra para convertirlo a numero
                            filaFinal = cambiarLetraANumero(mandarLetraF);
                        } else {
                            System.out.println("ERROR// el valor es invalido, intente de nuevo.");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR// INTENTE DE NUEVO");
                    }

                } while (filaFinal == 0);
                
                do {

                    try {
                        System.out.println("INGRESE LA COLUMNA FINAL (1-" + rangoDeColumnas + ")");
                        System.out.print("->");
                        columnaFinal = 0;
                        selecColFinal = "";
                        selecColFinal = scanner.nextLine();
                        if (Integer.parseInt(selecColFinal) > 0 && Integer.parseInt(selecColFinal) <= rangoDeColumnas) {
                            columnaFinal = Integer.parseInt(selecColFinal);
                        } else {
                            System.out.println("ERROR// Debe estar en el rango permitido.");
                            System.out.println("");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR// Debe ingresar solo numeros.");
                    }
                } while (columnaFinal == 0);
            }

            int res = filaFinal - filaInicial + 1; //ver cuantos espacios ocupa el barco para ver si esta en horizontal o vertical
            int res2 = columnaFinal - columnaInicial + 1; //ver cuantas columnas ocupa el barco
            //System.out.println(" Filas: " + res + " Columnas: " + res2);

            for (int filVerifi = filaInicial; filVerifi <= filaFinal; filVerifi++) { //recorrer la matriz en las posiciones iniciales y finales que indicamos (filas)
                for (int colVerifi = columnaInicial; colVerifi <= columnaFinal; colVerifi++) { //recorrer las columnas indicadas
                    if (matriz[filVerifi][colVerifi].equals(" ") || matriz[filVerifi][colVerifi].equals("  ")) {//verificar que la matriz este vacia
                        estaVacio++; //aumentar en 1 el contador de vacios
                    } else {
                        estaLleno++;//aumentar en 1 el contador de llenos
                    }
                }
            }

            if (estaVacio > 0 && estaLleno == 0) { //si el contador de vacios es mayor a 0 y el contador de lleno es igual a 0, si se agregara el barco. de lo contrario se pedira de nuevo los valores de inicio y fin
                if (res == 1 && res2 == 4 || res2 == 1 && res == 4) {  //verifica si los barcos estan el posicion vertical u orizontal (si ocupa 1 fila y 4 culumnas ó 4 filas y una columna)
                    if (tamanioBarco == 4 && contadorBarco > 0) { //datos recibidos del otro metodo: si el tamaño es de 4 y aun cuenta con  barcos (contador > 0)
                        //System.out.println("Si se agregara un barco de 4");
                        for (int fil = filaInicial; fil <= filaFinal; fil++) { //recorrer la matriz en los limites indicados -fila-
                            for (int col = columnaInicial; col <= columnaFinal; col++) {//recorrer la matriz en los limites indicados -columnas-
                                if (col > 9) { //si la columna en que se agrega es > 0 
                                    int arriba = (filaFinal - filaInicial);
                                    int abajo = (columnaFinal - columnaInicial);//ver si se estan agregando de forma horizontal o vertical
                                    if (arriba == 0 || abajo == 0) { //si estan en horizontal o vertical
                                        matriz[fil][col] = "* "; //se agrega el simbolo del barco 
                                    }
                                } else { //si las columnas son < 9, agregar el simbolo sin un espacio (para que tenga buena viste al mostrar la matriz)
                                    int arriba = (filaFinal - filaInicial);
                                    int abajo = (columnaFinal - columnaInicial); //vertical u horizontal
                                    if (arriba == 0 || abajo == 0) {
                                        matriz[fil][col] = "*";
                                    }
                                }
                            }
                        }
                        aceptado = true; //igualar a verdadero para que no se vuelvan a pedir los datos
                    } else {
                        System.out.println("Error// El barco unicamente puede estar en posicion vertical u orizontal");
                        System.out.println("        O esta intentando agregar un barco de mayor longitud al permitido.");
                        aceptado = false; //si no se agrega, volver a pedir los datos
                    }

                } else if (res == 1 && res2 == 3 || res2 == 1 && res == 3) {
                    if (tamanioBarco == 3 && contadorBarco > 0) {
                        //System.out.println("Si se agregara un barco de 3");
                        for (int fil = filaInicial; fil <= filaFinal; fil++) {
                            for (int col = columnaInicial; col <= columnaFinal; col++) {
                                if (col > 9) {
                                    int arriba = (filaFinal - filaInicial);
                                    int abajo = (columnaFinal - columnaInicial);
                                    if (arriba == 0 || abajo == 0) {
                                        matriz[fil][col] = "* ";
                                    }
                                } else {
                                    int arriba = (filaFinal - filaInicial);
                                    int abajo = (columnaFinal - columnaInicial);
                                    if (arriba == 0 || abajo == 0) {
                                        matriz[fil][col] = "*";
                                    }
                                }
                            }
                        }
                        aceptado = true;
                    } else {
                        System.out.println("Error// El barco unicamente puede estar en posicion vertical u orizontal");
                        System.out.println("        O esta intentando agregar un barco de mayor longitud al permitido.");
                        aceptado = false;
                    }
                } else if (res == 1 && res2 == 2 || res2 == 1 && res == 2) {
                    if (tamanioBarco == 2 && contadorBarco > 0) {
                        //System.out.println("Si se agregara un barco de 2");
                        for (int fil = filaInicial; fil <= filaFinal; fil++) {
                            for (int col = columnaInicial; col <= columnaFinal; col++) {
                                if (col > 9) {
                                    int arriba = (filaFinal - filaInicial);
                                    int abajo = (columnaFinal - columnaInicial);
                                    if (arriba == 0 || abajo == 0) {
                                        matriz[fil][col] = "* ";
                                    }
                                } else {
                                    int arriba = (filaFinal - filaInicial);
                                    int abajo = (columnaFinal - columnaInicial);
                                    if (arriba == 0 || abajo == 0) {
                                        matriz[fil][col] = "*";
                                    }
                                }
                            }
                        }
                        aceptado = true;
                    } else {
                        System.out.println("Error// El barco unicamente puede estar en posicion vertical u orizontal");
                        System.out.println("        O esta intentando agregar un barco de mayor longitud al permitido.");
                        aceptado = false;
                    }
                } else if (tamanioBarco == 1 && contadorBarco > 0) {
                    if (res == 1 && res2 == 1 || res2 == 1 && res == 1) {
                        //System.out.println("Si se agregara un barco de 1");
                        for (int fil = filaInicial; fil <= filaFinal; fil++) {
                            for (int col = columnaInicial; col <= columnaFinal; col++) {
                                if (col > 9) {
                                    int arriba = (filaFinal - filaInicial);
                                    int abajo = (columnaFinal - columnaInicial);
                                    if (arriba == 0 || abajo == 0) {
                                        matriz[fil][col] = "* ";
                                    }
                                } else {
                                    int arriba = (filaFinal - filaInicial);
                                    int abajo = (columnaFinal - columnaInicial);
                                    if (arriba == 0 || abajo == 0) {
                                        matriz[fil][col] = "*";
                                    }
                                }
                            }
                        }
                        aceptado = true;
                    } else {
                        aceptado = false;
                    }
                } else { //si las filas o columnas ingresadas no cumplen los requisitos para agregar un barco
                    System.out.println("Error// El barco unicamente puede estar en posicion vertical u orizontal");
                    System.out.println("        O esta intentando agregar un barco de mayor longitud al permitido.");
                    aceptado = false;
                    scanner.nextLine();
                }
            }else{ //si estan ocupadas las posiciones donde se quiere agregar un barco
                System.out.println("ERROR// Alguna o varias posiciones estan ocupadas.");
                aceptado = false;
                //scanner.nextLine();
            }

            //scanner.nextLine();
        } while (aceptado != true); //repetir un ciclo si es igual a falso (no se pudo agregar el barco)
        System.out.println("");
        mostrarMatriz(matriz); //mostrar matriz
        System.out.println("");
    }

    private static int cambiarLetraANumero(String letraRecibida) {
        int regresarLetraANumero = 0; //numero que retornaremos de donde se llame
        if (letraRecibida.equals("A") || letraRecibida.endsWith("a")) { //validar lo recibido
            regresarLetraANumero = 1; // si lo recibido es lo esperado, agregar un valor a la variable que se retornara
        } else if (letraRecibida.equals("B") || letraRecibida.endsWith("b")) {
            regresarLetraANumero = 2;
        } else if (letraRecibida.equals("C") || letraRecibida.endsWith("c")) {
            regresarLetraANumero = 3;
        } else if (letraRecibida.equals("D") || letraRecibida.endsWith("d")) {
            regresarLetraANumero = 4;
        } else if (letraRecibida.equals("E") || letraRecibida.endsWith("e")) {
            regresarLetraANumero = 5;
        } else if (letraRecibida.equals("F") || letraRecibida.endsWith("f")) {
            regresarLetraANumero = 6;
        } else if (letraRecibida.equals("G") || letraRecibida.endsWith("g")) {
            regresarLetraANumero = 7;
        } else if (letraRecibida.equals("H") || letraRecibida.endsWith("h")) {
            regresarLetraANumero = 8;
        } else if (letraRecibida.equals("I") || letraRecibida.endsWith("i")) {
            regresarLetraANumero = 9;
        } else if (letraRecibida.equals("J") || letraRecibida.endsWith("j")) {
            regresarLetraANumero = 10;
        } else if (letraRecibida.equals("K") || letraRecibida.endsWith("k")) {
            regresarLetraANumero = 11;
        } else if (letraRecibida.equals("L") || letraRecibida.endsWith("l")) {
            regresarLetraANumero = 12;
        } else if (letraRecibida.equals("M") || letraRecibida.endsWith("m")) {
            regresarLetraANumero = 13;
        } else if (letraRecibida.equals("N") || letraRecibida.endsWith("n")) {
            regresarLetraANumero = 14;
        } else if (letraRecibida.equals("O") || letraRecibida.endsWith("o")) {
            regresarLetraANumero = 15;
        } else if (letraRecibida.equals("P") || letraRecibida.endsWith("p")) {
            regresarLetraANumero = 16;
        } else if (letraRecibida.equals("Q") || letraRecibida.endsWith("q")) {
            regresarLetraANumero = 17;
        } else if (letraRecibida.equals("R") || letraRecibida.endsWith("r")) {
            regresarLetraANumero = 18;
        } else if (letraRecibida.equals("S") || letraRecibida.endsWith("s")) {
            regresarLetraANumero = 19;
        } else if (letraRecibida.equals("T") || letraRecibida.endsWith("t")) {
            regresarLetraANumero = 20;
        } else if (letraRecibida.equals("U") || letraRecibida.endsWith("u")) {
            regresarLetraANumero = 21;
        } else if (letraRecibida.equals("V") || letraRecibida.endsWith("v")) {
            regresarLetraANumero = 22;
        } else if (letraRecibida.equals("W") || letraRecibida.endsWith("w")) {
            regresarLetraANumero = 23;
        } else if (letraRecibida.equals("X") || letraRecibida.endsWith("x")) {
            regresarLetraANumero = 24;
        } else if (letraRecibida.equals("Y") || letraRecibida.endsWith("y")) {
            regresarLetraANumero = 25;
        } else if (letraRecibida.equals("Z") || letraRecibida.endsWith("z")) {
            regresarLetraANumero = 26;
        }else if(Integer.parseInt(letraRecibida) >= 0 || Integer.parseInt(letraRecibida) < 0){ //si mandan un numero en vez de una letra
            regresarLetraANumero = 1000; //regresar un numero que una matriz nunca alcanzara, para que de error y vuelva a pedir el valor
        }
        return regresarLetraANumero; //retornar la letra convertida en numero
    }

    private static void batallar(String[][] matrizTurno, String[][] matrizOponete, String nombreTurno, String nombreRival, String[][] matrizAuxiliar) {
        String opcion;
        int opcionInt = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("########################################################################");
        System.out.println("                                  BATALLA ");
        System.out.println("########################################################################");
        System.out.println("");

        do {
            System.out.println("######################### MI TABLERO: " + nombreTurno + " ############################");
            //mostrarMatriz(matrizTurno);
            mostrarMatrizColoreada(matrizTurno);
            System.out.println("");
            System.out.println("######################### TABLERO OPONENTE: " + nombreRival + " #######################");
            mostrarMatrizColoreada(matrizAuxiliar);
            try {
                System.out.println("");
                System.out.println("1. AGREGAR POSICION DE ATAQUE");
                System.out.println("2. ATAQUE ALEATORIO");
                System.out.println("INGRESE LA OPCION QUE DESEA SELECCIONAR");
                System.out.print("->");
                opcion = scanner.nextLine();
                if (Integer.parseInt(opcion) > 0 && Integer.parseInt(opcion) <= 2) { //se valida el numero igual que arriba pero esta vez con rango
                    opcionInt = Integer.parseInt(opcion);
                } else {
                    System.out.println("");
                    System.out.println("ERROR// Ingrese unicamente numeros positivos ó los numeros que aparecen en el menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" ");
                System.out.println("ERROR// Ingrese solamente numeros.");
                System.out.println("//////////////////////////////////////////");
                opcionInt = 0;
            }
        } while (opcionInt == 0);

        
        if (opcionInt == 1) {
            boolean pasa;
            do {

                System.out.println("");
                System.out.println("JUGADOR: " + nombreTurno + " SELECCIONE LA POSICION DE ATAQUE.");

                int filaAtq = 0;
                do {//ciclo que se repite hasta que se ingrese la fila de manera correcta
                    try {//bloque para intentar capturar el valor de la fila de inicio
                        System.out.println("INGRESE LA FILA (A-" + letra + ")");
                        System.out.print("->");
                        String pedirFilaAtq;
                        filaAtq = 0;
                        pedirFilaAtq = scanner.nextLine();
                        if (cambiarLetraANumero(pedirFilaAtq) < matrizTurno.length) { //se manda la letra recibida para que me regrese un numero
                            filaAtq = cambiarLetraANumero(pedirFilaAtq); //si el numero es valido, se asigna a una variable int
                        } else {
                            System.out.println("ERROR// el valor es invalido, intente de nuevo.");
                            System.out.println("");
                        }
                    } catch (Exception e) { //lanzar excepcion si se manda un valor incorrecto
                        System.out.println("ERROR// Intente de nuevo");
                        System.out.println("");
                    }
                } while (filaAtq == 0); //ciclo que se repite mientras no se capture un valor

                String pedirColumnaAtq;
                int columnaAtq = 0;
                int rangoDeColumnas = matrizTurno.length - 1;
                do {
                    try {
                        System.out.println("INGRESE LA COLUMNA DE INICIO (1-" + rangoDeColumnas + ")");
                        System.out.println("->");
                        pedirColumnaAtq = "";
                        columnaAtq = 0;
                        pedirColumnaAtq = scanner.nextLine();
                        if (Integer.parseInt(pedirColumnaAtq) > 0 && Integer.parseInt(pedirColumnaAtq) <= rangoDeColumnas) {
                            columnaAtq = Integer.parseInt(pedirColumnaAtq);
                        } else {
                            System.out.println("");
                            System.out.println("ERROR// Valor incorrecto, vuelva a intentarlo.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("");
                        System.out.println("ERROR//Ingrese solo numeros");
                        //scanner.nextLine();
                    }
                } while (columnaAtq == 0); //se seguira mostrando el mensaje mientras no se capture un valor

                if (!matrizOponete[filaAtq][columnaAtq].equals("X") && !matrizOponete[filaAtq][columnaAtq].equals("X ") && !matrizOponete[filaAtq][columnaAtq].equals("O") && !matrizOponete[filaAtq][columnaAtq].equals("O ")) {
                    for (int fil = filaAtq; fil <= filaAtq; fil++) {
                        for (int col = columnaAtq; col <= columnaAtq; col++) {
                            if (matrizOponete[fil][col].equals(" ") || matrizOponete[fil][col].equals("  ")) {
                                if (col > 9) {
                                    matrizOponete[fil][col] = "O ";
                                    matrizAuxiliar[fil][col] = "O ";
                                    controlDePuntos(nombreTurno, "fallo");
//                        fallos++;
//                        puntos = puntos - 5;
                                } else {
                                    matrizOponete[fil][col] = "O";
                                    matrizAuxiliar[fil][col] = "O";
                                    controlDePuntos(nombreTurno, "fallo");
//                        fallos++;
//                        puntos = puntos - 5;
                                }
                            } else if (matrizOponete[fil][col].equals("*") || matrizOponete[fil][col].equals("* ")) {
                                if (col > 9) {
                                    matrizOponete[fil][col] = "X ";
                                    matrizAuxiliar[fil][col] = "X ";
                                    controlDePuntos(nombreTurno, "acierto");
//                        aciertos++;
//                        puntos = puntos + 50;
                                } else {
                                    matrizOponete[fil][col] = "X";
                                    matrizAuxiliar[fil][col] = "X";
                                    controlDePuntos(nombreTurno, "acierto");
//                        aciertos++;
//                        puntos = puntos + 50;
                                }
                            }
                        }
                    }
                    pasa = true;
                } else {
                    System.out.println("ERROR// Esta posicion ya fue atacada, intente de nuevo.");
                    pasa = false;
                }
            } while (pasa != true);
        } else {

            boolean pasa2;
            do {
                Random random = new Random();
                int rango = matrizAuxiliar.length - 1;
                int filaR = random.nextInt(rango);
                int columnaR = random.nextInt(rango);
                int filaAtq2, columnaAtq2;
                filaAtq2 = filaR + 1;
                columnaAtq2 = columnaR + 1;
                
                if (!matrizOponete[filaAtq2][columnaAtq2].equals("X") && !matrizOponete[filaAtq2][columnaAtq2].equals("X ") && !matrizOponete[filaAtq2][columnaAtq2].equals("O") && !matrizOponete[filaAtq2][columnaAtq2].equals("O ")) {
                    for (int fil = filaAtq2; fil <= filaAtq2; fil++) {
                        for (int col = columnaAtq2; col <= columnaAtq2; col++) {
                            if (matrizOponete[fil][col].equals(" ") || matrizOponete[fil][col].equals("  ")) {
                                if (col > 9) {
                                    matrizOponete[fil][col] = "O ";
                                    matrizAuxiliar[fil][col] = "O ";
                                    controlDePuntos(nombreTurno, "fallo");
                                } else {
                                    matrizOponete[fil][col] = "O";
                                    matrizAuxiliar[fil][col] = "O";
                                    controlDePuntos(nombreTurno, "fallo");
                                }
                            } else if (matrizOponete[fil][col].equals("*") || matrizOponete[fil][col].equals("* ")) {
                                if (col > 9) {
                                    matrizOponete[fil][col] = "X ";
                                    matrizAuxiliar[fil][col] = "X ";
                                    controlDePuntos(nombreTurno, "acierto");
                                } else {
                                    matrizOponete[fil][col] = "X";
                                    matrizAuxiliar[fil][col] = "X";
                                    controlDePuntos(nombreTurno, "acierto");
                                }
                            }
                        }
                    }
                    pasa2 = true;
                    System.out.println("JUGADOR: " + nombreTurno + " ha atacado.");
                } else {
                    //System.out.println("ERROR// Esta posicion ya fue atacada, intente de nuevo."); //no se muestra porque el random se repite automaticamente
                    pasa2 = false;
                }
                
            } while (pasa2 != true);
            
        }


        System.out.println("\"###################################### TABLERO RIVAL ATACADO ##################################");
        System.out.println("");
        mostrarMatrizColoreada(matrizAuxiliar);
        mostrarPuntos(nombreTurno);

    }

    private static void controlDePuntos(String nombreTurno, String operacion) {
        if (nombreTurno.equals(nomJugadorUno) && operacion.equals("acierto")) {
            aciertosJugador1++;
            puntosJugador1 = puntosJugador1 + 50;
        }else if (nombreTurno.equals(nomJugadorUno) && operacion.equals("fallo")) {
            fallosJugador1++;
            puntosJugador1 = puntosJugador1 -5;
        }else if (nombreTurno.equals(nomJugadorDos) && operacion.equals("acierto")) {
            aciertosJugador2++;
            puntosJugador2 = puntosJugador2 + 50;
        }else if (nombreTurno.equals(nomJugadorDos) && operacion.equals("fallo")) {
            fallosJugador2++;
            puntosJugador2 = puntosJugador2 - 5;
        }
    }

    private static void mostrarPuntos(String nombreTurno) {
        if (nombreTurno.equals(nomJugadorUno)) {
            System.out.println("");
            System.out.println("Jugador1: "+nombreTurno);
            System.out.println("PUNTEO JUGADOR1: "+puntosJugador1);
            System.out.println("ACIERTOS JUGADOR1: "+aciertosJugador1);
            System.out.println("FALLOS JUGADOR1: "+ fallosJugador1);
            System.out.println("");
        } else if (nombreTurno.equals(nomJugadorDos)) {
            System.out.println("");
            System.out.println("Jugador2: "+nombreTurno);
            System.out.println("PUNTEO JUGADOR2: " + puntosJugador2);
            System.out.println("ACIERTOS JUGADOR2: " + aciertosJugador2);
            System.out.println("FALLOS JUGADOR2: "+ fallosJugador2);
            System.out.println("");
        }
    }
    
    private static void mostrarMatrizColoreada(String[][] matriz) {
    
        for (int fil = 0; fil < matriz.length; fil++) { //recorrer todas las filas de la matriz
            for (int col = 0; col < matriz.length; col++) { //recorrer todas las columnas de la matriz
                if (matriz[fil][col].equals("X") || matriz[fil][col].equals("X ")) {
                    System.out.print("| ");
                    System.out.print(rojo + matriz[fil][col] + reset);
                    System.out.print(" |");
                }else if (matriz[fil][col].equals("O") || matriz[fil][col].equals("O ")) {
                    System.out.print("| ");
                    System.out.print(azul + matriz[fil][col] + reset);
                    System.out.print(" |");
                }else{
                    System.out.print("| "+matriz[fil][col]+" |"); //imprimir contenido de la matriz
                }
            }
            System.out.println(""); //dejar un espacio por cada fila que se termina y continuar en la fila de abajo
        }
    }
    
    private static void historialDePartidas(){
        
        Jugador jugador1 = new Jugador(nomJugadorUno, puntosJugador1, aciertosJugador1, fallosJugador1, ganoJugador1);
        Jugador jugador2 = new Jugador(nomJugadorDos, puntosJugador2, aciertosJugador2, fallosJugador2, ganoJugador2);
        Jugador jugador3 = new Jugador(nomJugadorUno, puntosJugador1, aciertosJugador1, fallosJugador1, ganoJugador1);
        Jugador jugador4 = new Jugador(nomJugadorDos, puntosJugador2, aciertosJugador2, fallosJugador2, ganoJugador2);

        Partida nuevaPartida2 = new Partida(jugador1, jugador2, tamanioMatrizParaReportes);
        

        for (int i = 0; i < jugadorReporte.length; i+=2) { //LLENAR ARREGLO DE JUGADORES NO ACOLUMABLES
            if (jugadorReporte[i] == null) {
                jugadorReporte[i] = jugador1;
                jugadorReporte[i + 1] = jugador2;       
                break;
            }
        }
        for (int i = 0; i < jugadorReporteAcomulable.length; i+=2) { //LLENAR ARREGLO DE JUGADORES NO ACOLUMABLES
            if (jugadorReporteAcomulable[i] == null) {
                jugadorReporteAcomulable[i] = jugador3;
                jugadorReporteAcomulable[i + 1] = jugador4;       
                break;
            }
        }        


        int contador = 1;

            for (int i = 0; i < (jugadorReporteAcomulable.length); i++) {  
                if (jugadorReporteAcomulable[i] != null /*&& jugAux[i + 1] != null*/) {
                    for (int j = 0; j < (jugadorReporteAcomulable.length); j++) {
                        if (jugadorReporteAcomulable[j] != null && jugadorReporteAcomulable[j + 1] != null) {
                            if (/*jugAux[i + 1] != null && jugAux[j + 1] != null &&*/jugadorReporteAcomulable[i].getNombre().equals(jugadorReporteAcomulable[j].getNombre()) && i != j) {
                                jugadorReporteAcomulable[i].setAciertos(jugadorReporteAcomulable[i].getAciertos() + jugadorReporteAcomulable[j].getAciertos());
                                jugadorReporteAcomulable[i].setFallos(jugadorReporteAcomulable[i].getFallos() + jugadorReporteAcomulable[j].getFallos());
                                jugadorReporteAcomulable[i].setGanador(jugadorReporteAcomulable[i].getGanador() + jugadorReporteAcomulable[j].getGanador());
                                jugadorReporteAcomulable[j] = null;
                            }
                        }
                    }
                }
            }


        for (int i = 0; i < partidasJugadas.length; i++) {
            if (partidasJugadas[i] == null) {
                partidasJugadas[i] = nuevaPartida2;
                break;
            }
        }
        
    }

    private static void mostrarHistorialDePartidas() {
        int llena = 0;
        for (int i = 0; i < partidasJugadas.length; i++) {
            if (partidasJugadas[i] != null) {
                llena++;
            }
        }
        //mostrar el reporte
        if (llena > 0) {
            int contador = 0;
            System.out.println("");
            System.out.println("##################################### HISTORIAL DE PARTIDAS ##########################################");
            for (int i = 0; i < partidasJugadas.length; i++) {
                if (partidasJugadas[i] != null) {
                    System.out.println("");
                    System.out.println("######################################################################################################");
                    System.out.println("");
                    System.out.println("PARTIDA NO." + ++contador + "   TAMANIO DEL TABLERO: " + partidasJugadas[i].getTamanioTablero());
                    if (partidasJugadas[i].getJugador1().getGanador() == 1) {
                        System.out.print("GANADOR: ");
                        System.out.println(partidasJugadas[i].getJugador1().toString());
                        //System.out.println(partidasJugadas[i].);
                        //System.out.println("");
                        System.out.print("PERDEDOR: ");
                        System.out.println(partidasJugadas[i].getJugador2().toString());
                        System.out.println("");
                        System.out.println("######################################################################################################");
                    } else if (partidasJugadas[i].getJugador2().getGanador() == 1) {
                        System.out.print("GANADOR: ");
                        System.out.println(partidasJugadas[i].getJugador2().toString());
                        //System.out.println("");
                        System.out.print("PERDEDOR: ");
                        System.out.println(partidasJugadas[i].getJugador1().toString());
                        System.out.println("");
                        System.out.println("######################################################################################################");
                    }
                }
            }
        }else{
            System.out.println("Aun no hay registros de batallas.");
        }
    }
    
    private static void reporteDeTop(int opcion){
        int llena = 0;
        for (int i = 0; i < jugadorReporte.length; i++) {
            if (jugadorReporte[i] != null) {
                llena++;
            }
        }
        //mostrar el reporte
        if (llena > 0) {
            Jugador jugAuxTop;
            switch (opcion) {
                //mostrar puntuaciones mas altas
                case 1:
                    for (int i = 0; i < (jugadorReporte.length - 1); i++) {
                        if (jugadorReporte[i] != null) {
                            for (int j = 0; j < (jugadorReporte.length - 1); j++) {
                                if (jugadorReporte[j] != null && jugadorReporte[j + 1] != null) {
                                    if ( jugadorReporte[j].getPuntos() < jugadorReporte[j + 1].getPuntos()) { 
                                        jugAuxTop = jugadorReporte[j];
                                        jugadorReporte[j] = jugadorReporte[j + 1];
                                        jugadorReporte[j + 1] = jugAuxTop;
                                    }
                                }

                            }
                        }

                    }
                    int contadorLugar = 0;
                    System.out.println("################################################ TOP PUNTOS ##########################################");
                    for (int i = 0; i < jugadorReporte.length; i++) {
                        if (i < 3) {
                            if (jugadorReporte[i] != null) {
                                System.out.println("");
                                System.out.println("LUGAR : " + ++contadorLugar);
                                System.out.println("NOMBRE: " + jugadorReporte[i].getNombre());
                                System.out.println("PUNTOS: " + jugadorReporte[i].getPuntos());
                                System.out.println("");
                                System.out.println("######################################################################################################");
                            }
                        }
                    }
                    break;
                //jugadores con mayor cantidad de fallos
                case 2:
                    for (int i = 0; i < (jugadorReporteAcomulable.length ); i++) {
                        if (jugadorReporteAcomulable[i] != null) {
                            for (int j = 0; j < (jugadorReporteAcomulable.length ); j++) {
                                if (jugadorReporteAcomulable[j] != null && jugadorReporteAcomulable[j + 1] != null) {
                                    if (jugadorReporteAcomulable[j + 1] != null && jugadorReporteAcomulable[j].getFallos() < jugadorReporteAcomulable[j + 1].getFallos()) { // < porque quiero al mayor primero
                                        jugAuxTop = jugadorReporteAcomulable[j];
                                        jugadorReporteAcomulable[j] = jugadorReporteAcomulable[j + 1];
                                        jugadorReporteAcomulable[j + 1] = jugAuxTop;
                                    }
                                }
                            }
                        }

                    }
                    int posicion = 0;
                    System.out.println("################################################ TOP FALLOS ##########################################");
                    for (int i = 0; i < jugadorReporteAcomulable.length; i++) {
                        if (i < 3) {
                            if (jugadorReporteAcomulable[i] != null) {
                            System.out.println("");
                            System.out.println("LUGAR : " + ++posicion);
                            System.out.println("NOMBRE: " + jugadorReporteAcomulable[i].getNombre());
                            System.out.println("FALLOS: " + jugadorReporteAcomulable[i].getFallos());
                            System.out.println("");
                            System.out.println("######################################################################################################");                                
                            }

                        }
                    }
                    break;
                //jugadores con mayor cantidad de aciertos
                case 3:
                    Jugador jugadorAux2;
                    for (int i = 0; i < (jugadorReporteAcomulable.length ); i++) {
                       if (jugadorReporteAcomulable[i] != null) {
                            for (int j = 0; j < (jugadorReporteAcomulable.length ); j++) {
                                if (jugadorReporteAcomulable[j] != null /*&& jugadorReporteAcomulable[j + 1] != null*/) {
                                    if (jugadorReporteAcomulable[j + 1] != null && jugadorReporteAcomulable[j].getAciertos() < jugadorReporteAcomulable[j + 1].getAciertos()) { // < porque quiero al mayor primero
                                        jugadorAux2 = jugadorReporteAcomulable[j];
                                        jugadorReporteAcomulable[j] = jugadorReporteAcomulable[j + 1];
                                        jugadorReporteAcomulable[j + 1] = jugadorAux2;
                                    }
                                }

                            }
                        }

                    }
                    int posicion2 = 0;
                    System.out.println("################################################ TOP ACIERTOS ##########################################");
                    for (int i = 0; i < jugadorReporteAcomulable.length; i++) {
                        if (i < 3) {
                            if (jugadorReporteAcomulable[i] != null) {
                            System.out.println("");
                            System.out.println("LUGAR   : " + ++posicion2);
                            System.out.println("NOMBRE  : " + jugadorReporteAcomulable[i].getNombre());
                            System.out.println("ACIERTOS: " + jugadorReporteAcomulable[i].getAciertos());
                            System.out.println("");
                            System.out.println("######################################################################################################");                                
                            }
                        }
                    }
                    break;
                //jugadores que mas han ganado
                case 4:
                    for (int i = 0; i < (jugadorReporteAcomulable.length - 1); i++) {
                        if (jugadorReporteAcomulable[i] != null) {
                            for (int j = 0; j < (jugadorReporteAcomulable.length - 1); j++) {
                                if (jugadorReporteAcomulable[j] != null && jugadorReporteAcomulable[j + 1] != null) {
                                    if (jugadorReporteAcomulable[j].getPuntos() < jugadorReporteAcomulable[j + 1].getPuntos()) {
                                        jugAuxTop = jugadorReporteAcomulable[j];
                                        jugadorReporteAcomulable[j] = jugadorReporteAcomulable[j + 1];
                                        jugadorReporteAcomulable[j + 1] = jugAuxTop;
                                    }
                                }

                            }
                        }

                    }
                    int contadorLugarG = 0;
                    System.out.println("################################################ TOP GANADORES ##########################################");
                    for (int i = 0; i < jugadorReporteAcomulable.length; i++) {
                        if (i < 3) {
                            if (jugadorReporteAcomulable[i] != null) {
                                System.out.println("");
                                System.out.println("LUGAR : " + ++contadorLugarG);
                                System.out.println("NOMBRE: " + jugadorReporteAcomulable[i].getNombre());
                                System.out.println(jugadorReporteAcomulable[i].getGanador()+" VECES GANADO");
                                System.out.println("");
                                System.out.println("######################################################################################################");
                            }
                        }
                    }
                    break;
            }

        } else {
            System.out.println("");
            System.out.println("NO SE ENCUENTRAN REGISTROS DE BATALLA.");
            System.out.println("");
        }
    }

}
