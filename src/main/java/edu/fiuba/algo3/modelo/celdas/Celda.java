package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.interfaz.vistas.escenas.VistaTablero;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.excepcion.CoordenadaInvalidaError;
import javafx.scene.layout.StackPane;
import org.apache.logging.log4j.Logger;

public abstract class Celda {
    protected Celda siguiente;
    protected int x;
    protected int y;
    protected Logger logger;

    protected void coordenadasValidas(int x, int y) {
        if(x < 0 || y < 0) {
            throw new CoordenadaInvalidaError();
        }
    }

    public abstract Celda afectar(Gladiador gladiador);

    public abstract Celda celdaSiguiente();

    public void setSiguiente(Celda siguiente){ this.siguiente = siguiente;};

    public String nombreImagenFondo() { return "imagenCamino.png"; }

    //public abstract String nombreImagenPremio();    // TODO: Check

    //public abstract String nombreImagenObstaculo();   // TODO: Check

    public void ubicarEnGrillaInterfaz(VistaTablero vistaTablero, StackPane panelDeCelda) {
        vistaTablero.setConstraints(panelDeCelda, this.x, this.y);
    }
}
