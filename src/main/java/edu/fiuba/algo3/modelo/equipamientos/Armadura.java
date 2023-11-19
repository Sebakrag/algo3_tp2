package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Equipamiento;
import edu.fiuba.algo3.modelo.Jugador;

public class Armadura implements Equipamiento, Afectante {
    private static final int DANIO = 10;
    public Equipamiento mejorarEquipamiento() {
        return new EscudoYEspada();
    }

    public void afectar(Jugador jugador) {

    }

    public int recibirAtaque(){
        return DANIO;
    }
}
