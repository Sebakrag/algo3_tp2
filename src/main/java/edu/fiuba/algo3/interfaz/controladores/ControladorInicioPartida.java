package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.escenas.VistaJuego;
import edu.fiuba.algo3.modelo.excepcion.ArchivoNoEncontradoError;
import edu.fiuba.algo3.parsers.TableroParser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;


public class ControladorInicioPartida implements EventHandler<ActionEvent> {

    private Stage ventana;
    private ArrayList<String> nombresJugadores;

    public ControladorInicioPartida(Stage ventana, ArrayList<String> nombresJugadores) {
        this.ventana = ventana;
        this.nombresJugadores = nombresJugadores;
    }

    @Override
    public void handle(ActionEvent evento) {
        String rutaJson = "/archivos/mapaPrueba.json";
        TableroParser tableroParser = new TableroParser();

        try {
            Tablero tablero = tableroParser.leerArchivo(rutaJson);

            Logger logger = LogManager.getLogger();;
            Juego juego = new Juego(logger, tablero);
            VistaJuego vistaJuego = new VistaJuego(juego, tablero, this.nombresJugadores, this.ventana);
            juego.iniciarPartida(this.nombresJugadores);

            /*
            gridPane.add(node, columnIndex, rowIndex, columnSpan, rowSpan);
            node: El nodo que se está agregando.
            columnIndex: La columna en la que se ubicará el nodo.
            rowIndex: La fila en la que se ubicará el nodo.
            columnSpan: La cantidad de columnas que el nodo ocupará.
            rowSpan: La cantidad de filas que el nodo ocupará.
            */

            Scene escenaJuego = new Scene(vistaJuego);
            vistaJuego.prefWidthProperty().bind(this.ventana.widthProperty());
            vistaJuego.prefHeightProperty().bind(this.ventana.heightProperty());
            this.ventana.setScene(escenaJuego);
            this.ventana.setResizable(true);

        } catch (IOException | ParseException | ArchivoNoEncontradoError e) {
            return;
        }
    }
}
