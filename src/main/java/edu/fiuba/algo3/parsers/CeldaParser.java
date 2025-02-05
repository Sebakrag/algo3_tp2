package edu.fiuba.algo3.parsers;

import edu.fiuba.algo3.modelo.afectantes.Afectante;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import edu.fiuba.algo3.modelo.celdas.Celda;
import edu.fiuba.algo3.modelo.celdas.*;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.excepcion.*;
import org.apache.logging.log4j.Logger;

public class CeldaParser {

    public Celda parse(JSONObject celda) {

        Logger logger = LogManager.getLogger();
        int coorX = (int) ((long) celda.get("x"));
        int coorY = (int) ((long) celda.get("y"));

        String tipo = (String) celda.get("tipo");
        String premio = (String) celda.get("premio");
        String obstaculo = (String) celda.get("obstaculo");
        premio = premio.toLowerCase();
        obstaculo = obstaculo.toLowerCase();
        tipo = tipo.toLowerCase();

        switch(tipo) {
            case "salida":
                return new CeldaInicial(coorX, coorY, logger);
            case "camino":
                Afectante afectantePremio = this.parsearPremio(premio);
                Afectante afectanteObstaculo = this.parsearObstaculo(obstaculo);
                return new CeldaComun(coorX, coorY, afectantePremio, afectanteObstaculo, logger);
            case "llegada":
                return new CeldaFinal(coorX, coorY, logger);
            default:
                throw new TipoDeCeldaEnArchivoNoValidaError();
        }
    }

    private Afectante parsearPremio(String afectante) throws AfectanteInvalidoError{
        switch (afectante){
            case "equipamiento":
                return new Potenciador();
            case "comida":
                return new Comida();
            case "":
                return new Vacio();
            default:
                throw new AfectanteInvalidoError();
        }
    }

    private Afectante parsearObstaculo(String afectante){
        /*Logger logger = LogManager.getLogger();*/
        switch (afectante){
            case "lesion":
                return new Lesion();
            case "bacanal":
                return new Bacanal();
            case "fiera":
                return new Fiera();
            case "":
                return new Vacio();
            default:
                throw new AfectanteInvalidoError();
        }
    }
}
