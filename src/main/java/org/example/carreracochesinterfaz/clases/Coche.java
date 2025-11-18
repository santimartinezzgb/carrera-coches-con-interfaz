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
    ImageView posicion;

    public Coche(String nombre, Carrera carrera, Label recorridoEnCarrera, ImageView posicion) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
        this.distanciaTotal = 100;
        this.carrera = carrera;
        this.carretera = new ArrayList<>();
        this.recorridoEnCarrera = recorridoEnCarrera;
        this.posicion = posicion;
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
            if (velocidad > 250) {
                carretera.add("━━━━");
                distanciaRecorrida += 10;
            } else if (velocidad > 150) {
                carretera.add("━━━");
                distanciaRecorrida += 6;
            } else if (velocidad > 3) {
                carretera.add("━━");
                distanciaRecorrida += 3;
            } else {
                carretera.add("━");
                distanciaRecorrida += 1;
            }

            if (distanciaRecorrida <= 100) {
                // Actualizar la interfaz gráfica en el hilo de JavaFX
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


            switch (carrera.ordenDeLlegada(this.nombre, velocidadMaxima)){
                case "1":{
                    posicion.setImage(new Image("images/oro.jpg"));
                } break;
                case "2":{
                    posicion.setImage(new Image("images/plata.jpg"));
                } break;
                case "3":{
                    posicion.setImage(new Image("images/bronce.jpg"));
                } break;
                case "4":{
                    posicion.setImage(new Image("images/hoja.jpg"));
                } break;
                case "5":{
                    posicion.setImage(new Image("images/goomba.jpg"));
                } break;

            }



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