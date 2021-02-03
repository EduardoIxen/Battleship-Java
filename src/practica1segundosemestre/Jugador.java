/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1segundosemestre;

/**
 *
 * @author Dell
 */
public class Jugador {
    private String nombre;
    private int puntos;
    private int aciertos;
    private int fallos;
    private int ganador;
    //private boolean ganador;

    public Jugador(String nombre, int puntos, int aciertos, int fallos, int ganador) {
        setNombre(nombre);
        setPuntos(puntos);
        setAciertos(aciertos);
        setFallos(fallos);
        setGanador(ganador);
        //setGanador(ganador);
    }

    Jugador() {
        this("",0,0,0, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }
        public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }
    
//    public boolean getGanador(){
//        return ganador;
//    }
//    
//    public void setGanador(boolean ganador){
//        this.ganador = ganador;
//    }

    @Override
    public String toString() {
        return "{ " + "nombre=" + nombre + ", puntos=" + puntos + ", aciertos=" + aciertos + ", fallos=" + fallos + " "+'}';
    }
    
    
}
