package demo_proyectofinal_fx.demoapp.viewController;

import demo_proyectofinal_fx.demoapp.GimnasioApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class RecepcionistaMainViewController {

    @FXML
    void handleRegistrarUsuario(ActionEvent event) throws IOException {
        GimnasioApplication.cambiarEscena("RecepcionistaRegistrarUsuarioView.fxml", "Registrar Usuario");
    }

    @FXML
    void handleAsignarMembresia(ActionEvent event) throws IOException {
        GimnasioApplication.cambiarEscena("RecepcionistaAsignarmembresiaView.fxml", "Asignar Membresía");
    }

    @FXML
    void handleAsignarClase(ActionEvent event) throws IOException {
        GimnasioApplication.cambiarEscena("RecepcionistaAsignarClaseView.fxml", "Asignar Clase");
    }

    @FXML
    void handleReportes(ActionEvent event) throws IOException {
        GimnasioApplication.cambiarEscena("RecepcionistaReportesView.fxml", "Reportes de Recepción");
    }

    @FXML
    void handleLogout(ActionEvent event) throws IOException {
        GimnasioApplication.cambiarEscena("LoginView.fxml", "Login - Gimnasio UQ");
    }
}