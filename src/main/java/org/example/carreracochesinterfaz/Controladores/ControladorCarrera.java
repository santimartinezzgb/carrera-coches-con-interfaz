package org.example.carreracochesinterfaz.Controladores;

import org.example.carreracochesinterfaz.clases.Carrera;
import org.example.carreracochesinterfaz.clases.Coche;

public class ControladorCarrera {

        void main() {
            Carrera nuevaCarrera = new Carrera();

            Coche c1 = new Coche("Ferrari", nuevaCarrera);
            Coche c2 = new Coche("Aston Martin", nuevaCarrera);
            Coche c3 = new Coche("Red Bull", nuevaCarrera);
            Coche c4 = new Coche("Mclaren", nuevaCarrera);

            c1.start();
            c2.start();
            c3.start();
            c4.start();
        }
    }
