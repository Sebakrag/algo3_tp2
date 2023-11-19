package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Equipamiento;

public class Casco implements Equipamiento, Afectante {
    private static final int DANIO = 15;
    public Equipamiento mejorarEquipamiento() {
        return new Armadura();
    }

    public void afectar(Jugador jugador) {

    }

    public int recibirAtaque(){
        return DANIO;
    }
}
