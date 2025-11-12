module org.example.carreracochesinterfaz {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.carreracochesinterfaz to javafx.fxml;
    exports org.example.carreracochesinterfaz.clases;
    opens org.example.carreracochesinterfaz.clases to javafx.fxml;
    exports org.example.carreracochesinterfaz.Controladores;
    opens org.example.carreracochesinterfaz.Controladores to javafx.fxml;
    exports org.example.carreracochesinterfaz.servicios;
    opens org.example.carreracochesinterfaz.servicios to javafx.fxml;
}