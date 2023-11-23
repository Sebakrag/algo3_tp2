package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Gladiador;

public class MejorarEquipamiento implements Afectante {

    public void afectar(Gladiador gladiador) {
        gladiador.recibirImpacto(this);
    }
}
