package org.example.carreracochesinterfaz.clases;

import org.example.carreracochesinterfaz.clases.Carrera;

import java.util.*;

public class Coche extends Thread{

    String nombre;
    int distanciaRecorrida;
    int distanciaTotal;
    Carrera carrera;
    ArrayList<String> carretera;

    public Coche(String nombre, Carrera carrera){
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
        this.distanciaTotal = 100;
        this.carrera = carrera;
        this.carretera = new ArrayList<>();
    }

    @Override
    public void run (){

        List<Integer> velocidades = new ArrayList<>();

        while(distanciaTotal >= distanciaRecorrida){

            // Tiempo de parones
            int tiempo = (int) (Math.random() * 500);
            try {
                Thread.sleep(tiempo);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Velocidad aleatoria 78
            int velocidad = (int) (Math.random()* 300);
            velocidades.add(velocidad);

            // Avance
            if (velocidad > 250) {
                carretera.add("================");
                distanciaRecorrida += 10;
            } else if (velocidad > 150){
                carretera.add("========");
                distanciaRecorrida += 6;
            } else if (velocidad > 3) {
                carretera.add("====");
                distanciaRecorrida += 3;
            } else {
                carretera.add("==");
                distanciaRecorrida += 1;
            }

            if (distanciaRecorrida <= 100) {
                System.out.println(String.join("",carretera) + " " + this.nombre);
            }
        }

        Collections.sort(velocidades);
        int velocidadMaxima = velocidades.reversed().get(0);

        carrera.ordenDeLlegada(this.nombre, velocidadMaxima);

    }

}
