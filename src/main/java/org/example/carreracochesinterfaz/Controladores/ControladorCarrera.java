package org.example.carreracochesinterfaz.Controladores;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import org.example.carreracochesinterfaz.clases.Carrera;
import org.example.carreracochesinterfaz.clases.Coche;

public class ControladorCarrera {

    @FXML
    private Button btn_iniciar;
    @FXML
    private Button btn_salir;
    @FXML
    private VBox consola;
    @FXML
    Button btn_naranja;
    @FXML
    Button btn_azul;
    @FXML
    Button btn_verde;
    @FXML
    Button btn_amarillo;
    @FXML
    Button btn_rojo;


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
    private Label resultado1;
    @FXML
    private Label resultado2;
    @FXML
    private Label resultado3;
    @FXML
    private Label resultado4;
    @FXML
    private Label resultado5;


    @FXML
    public void iniciar() {

        Carrera carrera = new Carrera();

        resultado1.setText("");
        resultado2.setText("");
        resultado3.setText("");
        resultado4.setText("");
        resultado5.setText("");

        btn_iniciar.setDisable(true);
        btn_salir.setDisable(true);
        btn_iniciar.setText("CORRIENDO...");

        Coche coche1 = new Coche("Mario", carrera, recorrido1, resultado1);
        Coche coche2 = new Coche("Luigi", carrera, recorrido2, resultado2);
        Coche coche3 = new Coche("Bowser", carrera, recorrido3, resultado3);
        Coche coche4 = new Coche("Toad", carrera, recorrido4, resultado4);
        Coche coche5 = new Coche("Peach", carrera, recorrido5, resultado5);

        coche1.start();
        coche2.start();
        coche3.start();
        coche4.start();
        coche5.start();

        // VEr cuando todos los hilos terminen
        new Thread(() -> {
            try {
                coche1.join();
                coche2.join();
                coche3.join();
                coche4.join();
                coche5.join();

                // Todos los hilos terminaron
                javafx.application.Platform.runLater(() -> {
                    btn_iniciar.setDisable(false);
                    btn_salir.setDisable(false);
                    btn_iniciar.setText("REINICIAR");
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    void colorNaranja(){
        consola.setStyle("-fx-background-color: orange; -fx-background-radius: 25; -fx-border-radius: 20;" +
                "-fx-border-width: 5; -fx-border-color: black; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 8, 0.5 , 5 , 5 );");
    }
    @FXML
    void colorAzul(){
        consola.setStyle("-fx-background-color: blue; -fx-background-radius: 25; -fx-border-radius: 20;" +
                "-fx-border-width: 5; -fx-border-color: black; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 8, 0.5 , 5 , 5 );");
    }
    @FXML
    void colorVerde(){
        consola.setStyle("-fx-background-color: green; -fx-background-radius: 25; -fx-border-radius: 20;" +
                "-fx-border-width: 5; -fx-border-color: black; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 8, 0.5 , 5 , 5 );");
    }
    @FXML
    void colorAmarillo(){
        consola.setStyle("-fx-background-color: yellow; -fx-background-radius: 25; -fx-border-radius: 20;" +
                "-fx-border-width: 5; -fx-border-color: black; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 8, 0.5 , 5 , 5 );");
    }
    @FXML
    void colorRojo(){
        consola.setStyle("-fx-background-color: red; -fx-background-radius: 25; -fx-border-radius: 20;" +
                "-fx-border-width: 5; -fx-border-color: black; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 8, 0.5 , 5 , 5 );");
    }

    @FXML
    private void salirDelPrograma(){
        Platform.exit();
    }

}