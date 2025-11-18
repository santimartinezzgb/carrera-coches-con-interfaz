package org.example.carreracochesinterfaz.clases;
import java.util.ArrayList;

public class Carrera {

    ArrayList<String> orden = new ArrayList<>();
    //ArrayList<Integer> velocidades = new ArrayList<>();
    int contador = 0;

    public synchronized int ordenDeLlegada(String nombre, int velocidadMax){

        orden.add(nombre);
        //velocidades.add(velocidadMax);
        contador+=1;

        // if(orden.size()==5){
        //
        //     for (int i = 0; i < orden.size(); i++){
//
        //         System.out.println("----------------------------- " + (i) + "º POSICIÓN ---------------------------------" +
        //                 "\n"+orden.get(i).toUpperCase() + ", con una velocidad máxima de " + velocidades.get(i) + " km/h");
        //         System.out.println();
        //     }
        // }

        // Para que el metodo devuelva la posición según vayan llegando

        return contador;
   }
}
