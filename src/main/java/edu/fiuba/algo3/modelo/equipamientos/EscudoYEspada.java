package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.afectantes.Potenciador;

import edu.fiuba.algo3.modelo.afectantes.Potenciador;

public class EscudoYEspada extends Equipamiento {
    public EscudoYEspada() {
        this.danio = 2;
        this.id = "EscudoYEspada";
    }
    @Override
    public Equipamiento mejorarEquipamiento(Potenciador potenciador) {
        return potenciador.equipamientoSiguiente(this);
    }
    @Override
    public boolean equipoCompleto(){
        return false;
    }
}
