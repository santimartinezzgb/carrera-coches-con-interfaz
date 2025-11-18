package org.example.carreracochesinterfaz.clases;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;

public class Coche extends Thread {

    String nombre;
    int distanciaRecorrida;
    int distanciaTotal;
    Carrera carrera;
    ArrayList<String> carretera;
    Label recorridoEnCarrera; // Label del recorrido de cada coche
    Label resultado;

    public Coche(String nombre, Carrera carrera, Label recorridoEnCarrera, Label resultado) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
        this.distanciaTotal = 10;
        this.carrera = carrera;
        this.carretera = new ArrayList<>();
        this.recorridoEnCarrera = recorridoEnCarrera;
        this.resultado = resultado;
    }

    @Override
    public void run() {
        List<Integer> velocidades = new ArrayList<>();

        while (distanciaTotal >= distanciaRecorrida) {

            int tiempo = (int) (Math.random() * 500);
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Velocidad aleatoria
            int velocidad = (int) (Math.random() * 300);
            velocidades.add(velocidad);

            // Avance
                carretera.add("━━");
                distanciaRecorrida += 1;


            if (distanciaRecorrida <= 100) {
                // Actualizar la interfaz gráfica
                actualizarJavafx();

                // También imprimir en consola
                System.out.println(String.join("", carretera) +" " + this.nombre);
            }
        }

        Collections.sort(velocidades);
        int velocidadMaxima = velocidades.reversed().get(0);

        // Notificar finalización
        Platform.runLater(() -> {
            recorridoEnCarrera.setText(String.join("", carretera) + " " + this.nombre + " ¡LLEGÓ!");

            resultado.setText(String.valueOf(carrera.ordenDeLlegada(this.nombre, velocidadMaxima)) + "º");
        });

    }

    // Actualiza la interfaz gráfica de forma segura desde un Thread
    private void actualizarJavafx() {
        Platform.runLater(() -> {
            String avance = String.join("", carretera);
            recorridoEnCarrera.setText(avance);
        });
    }
}