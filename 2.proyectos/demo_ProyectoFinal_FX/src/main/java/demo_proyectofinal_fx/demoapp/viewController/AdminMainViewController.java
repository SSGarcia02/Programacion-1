package demo_proyectofinal_fx.demoapp.viewController;

import demo_proyectofinal_fx.demoapp.GimnasioApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class AdminMainViewController {

    @FXML
    void handleGestionEntrenadores(ActionEvent event) throws IOException {
        GimnasioApplication.cambiarEscena("AdminGestionEntrenadoresView.fxml", "Gestión de Entrenadores");
    }

    @FXML
    void handleReportesAvanzados(ActionEvent event) throws IOException {
        GimnasioApplication.cambiarEscena("AdminReportesAvanzadosView.fxml", "Reportes Avanzados");
    }

    @FXML
    void handleLogout(ActionEvent event) throws IOException {
        GimnasioApplication.cambiarEscena("LoginView.fxml", "Login - Gimnasio UQ");
    }
}
