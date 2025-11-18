package org.example.carreracochesinterfaz.clases;
import java.util.ArrayList;

public class Carrera {

    ArrayList<String> orden = new ArrayList<>();
    ArrayList<Integer> velocidades = new ArrayList<>();


    public synchronized String ordenDeLlegada(String nombre, int velocidadMax){

        orden.add(nombre);
        velocidades.add(velocidadMax);
        String posicion = "";

        if(orden.size()==5){

            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
            for (int i = 0; i < orden.size(); i++){
                System.out.println("----------------------------- " + (i+1) + "º POSICIÓN ---------------------------------" +
                        "\n"+orden.get(i).toUpperCase() + ", con una velocidad máxima de " + velocidades.get(i) + " km/h");
                System.out.println();
                posicion = String.valueOf(i+1);
            }
        }

        return posicion;

    }
}
