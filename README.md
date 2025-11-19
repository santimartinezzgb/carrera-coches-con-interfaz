# Mario Kart Race Emulator

Emulador simplificado de una carrera de Mario Kart desarrollado en Java con JavaFX. Simulación de carreras con programación concurrente utilizando hilos.

## 📋 Descripción

Simulador de carreras entre cinco personajes icónicos del universo Mario Kart: **Mario**, **Luigi**, **Bowser**, **Toad** y **Peach**. Cada corredor avanza a velocidades aleatorias, haciendo que cada carrera sea única e impredecible.

## Pantallas

- **Inicio**: Vista previa con todos los corredores en la línea de salida
  
  <img width="1717" height="914" alt="pantalla-inicio" src="https://github.com/user-attachments/assets/bf950f6e-bb17-4483-b871-fa045d9be648" />

- **Carrera**: Visualización en tiempo real del avance de cada participante
  
  <img width="1717" height="914" alt="pantalla-durante-carrera" src="https://github.com/user-attachments/assets/c72dfafc-b8ea-4cef-92e3-cbe80dad4cc2" />

- **Finalización**: Clasificación final con el ganador destacado 🏆
  
  <img width="1717" height="914" alt="pantalla-terminada" src="https://github.com/user-attachments/assets/3c92155a-13d8-4862-b6bf-a34f80105f8c" />

## Características

- **Interfaz gráfica** desarrollada con JavaFX
- **Visualización en tiempo real** del avance de cada corredor
- **5 corredores** ejecutándose en hilos paralelos independientes
- **Velocidades aleatorias** para simular la incertidumbre de una carrera real
- **Pistas de colores** personalizadas para cada personaje
- **Sistema de clasificación** que muestra el orden de llegada
- **Tema visual** inspirado en Super Mario

## Tecnologías Utilizadas

- **Java** - Lenguaje de programación
- **JavaFX** - Framework para la interfaz gráfica
- **Threads** - Programación concurrente (cada corredor es un hilo)
- **synchronized** - Sincronización para el método de orden de llegada
- **Platform.runLater()** - Actualización segura de la UI desde hilos secundarios

## Funcionamiento

1. Cada corredor es una instancia de la clase `Coche` que extiende `Thread`
2. Al iniciar la carrera, los 5 hilos se ejecutan en paralelo
3. El método `ordenDeLlegada()` gestiona la clasificación final usando `synchronized`
4. Las actualizaciones visuales se realizan mediante `Platform.runLater()` para evitar errores de concurrencia

## Ejecución

1. Clona el repositorio
2. Abre el proyecto en tu IDE favorito
3. Ejecuta la clase principal
4. Haz click en el botón **INICIO** para comenzar la carrera

## Autor

**Santi Martínez**

---

*Proyecto desarrollado para la asignatura de Programación de Servicios y Procesos*
