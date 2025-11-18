package demo_proyectofinal_fx.demoapp.viewController;

import demo_proyectofinal_fx.demoapp.GimnasioApplication;
import demo_proyectofinal_fx.demoapp.controller.ReporteController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class AdminReportesAvanzadosViewController {

    @FXML
    private ComboBox<String> reporteComboBox;

    @FXML
    private TextArea reporteTextArea;

    private ReporteController reporteController;

    @FXML
    void initialize() {
        reporteController = new ReporteController();
        reporteComboBox.getItems().addAll(
                "Reporte de Clases Populares",
                "Reporte de Ingresos por Membresía",
                "Reporte de Asistencia",
                "Reporte de Usuarios por Tipo"
        );
    }

    @FXML
    void generarReporte(ActionEvent event) {
        String tipoReporte = reporteComboBox.getValue();
        if (tipoReporte != null) {
            String reporte = reporteController.generarReporte(tipoReporte);
            reporteTextArea.setText(reporte);
        } else {
            reporteTextArea.setText("Por favor seleccione un tipo de reporte.");
        }
    }

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        GimnasioApplication.cambiarEscena("AdminMainView.fxml", "Panel de Administrador");
    }

    @FXML
    void handleLogout(ActionEvent event) throws IOException {
        GimnasioApplication.cambiarEscena("LoginView.fxml", "Login - Gimnasio UQ");
    }
}