package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Afectante;

public interface Equipamiento extends Afectante {
    public Equipamiento mejorarEquipamiento();
    public int recibirAtaque();
}
