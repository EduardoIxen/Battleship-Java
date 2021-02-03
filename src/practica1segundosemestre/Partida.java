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
public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private int tamanioTablero;

    public Partida(Jugador jugador1, Jugador jugador2, int tamanioTablero) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tamanioTablero = tamanioTablero;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public int getTamanioTablero() {
        return tamanioTablero;
    }

    public void setTamanioTablero(int tamanioTablero) {
        this.tamanioTablero = tamanioTablero;
    }

    @Override
    public String toString() {
        return "Partida{" + "jugador1=" + jugador1 + ", jugador2=" + jugador2 + ", tamanioTablero=" + tamanioTablero + '}';
    }

 
}
