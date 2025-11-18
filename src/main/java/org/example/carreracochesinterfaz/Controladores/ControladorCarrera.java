package org.example.carreracochesinterfaz.Controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.carreracochesinterfaz.clases.Carrera;
import org.example.carreracochesinterfaz.clases.Coche;

public class ControladorCarrera {

    @FXML
    private Button btn_iniciar;

    @FXML
    private Label recorrido1;
    @FXML
    private Label recorrido2;
    @FXML
    private Label recorrido3;
    @FXML
    private Label recorrido4;
    @FXML
    private Label recorrido5;

    @FXML
    private ImageView posicionMario;
    @FXML
    private ImageView posicionLuigi;
    @FXML
    private ImageView posicionBowser;
    @FXML
    private ImageView posicionToad;
    @FXML
    private ImageView posicionPeach;


    @FXML
    public void iniciar() {

        Carrera carrera = new Carrera();
        // Deshabilitar el botón para evitar múltiples carreras
        btn_iniciar.setDisable(true);
        btn_iniciar.setText("CARRERA EN CURSO...");


        Coche coche1 = new Coche("Mario", carrera, recorrido1, posicionMario);
        Coche coche2 = new Coche("Luigi", carrera, recorrido2, posicionLuigi);
        Coche coche3 = new Coche("Bowser", carrera, recorrido3, posicionBowser);
        Coche coche4 = new Coche("Toad", carrera, recorrido4, posicionToad);
        Coche coche5 = new Coche("Peach", carrera, recorrido5, posicionPeach);


        coche1.start();
        coche2.start();
        coche3.start();
        coche4.start();
        coche5.start();



        // Opcional: Monitorear cuando todos terminen
        new Thread(() -> {
            try {
                coche1.join();
                coche2.join();
                coche3.join();
                coche4.join();
                coche5.join();

                // Todos terminaron
                javafx.application.Platform.runLater(() -> {
                    btn_iniciar.setText("REINICIAR");
                    btn_iniciar.setDisable(false);
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}