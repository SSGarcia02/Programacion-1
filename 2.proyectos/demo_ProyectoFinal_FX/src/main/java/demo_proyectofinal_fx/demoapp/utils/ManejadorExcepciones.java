package demo_proyectofinal_fx.demoapp.utils;

import demo_proyectofinal_fx.demoapp.exceptions.GimnasioException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

public class ManejadorExcepciones {

    private ManejadorExcepciones() {
    }

    public static void manejarExcepcion(Throwable excepcion, String contexto) {
        System.err.println("❌ Error en: " + contexto);
        System.err.println("Mensaje: " + excepcion.getMessage());

        if (excepcion instanceof GimnasioException) {
            mostrarAlertaError("Error del Sistema", excepcion.getMessage());
        } else {
            String mensajeUsuario = "Ocurrió un error inesperado en: " + contexto +
                    "\n\nDetalle: " + excepcion.getMessage() +
                    "\n\nPor favor contacte al administrador del sistema.";
            mostrarAlertaErrorConDetalles("Error Inesperado", mensajeUsuario, excepcion);
        }
        excepcion.printStackTrace();
    }

    public static void manejarAdvertencia(String titulo, String mensaje) {
        System.out.println("⚠ Advertencia: " + titulo + " - " + mensaje);
        mostrarAlertaAdvertencia(titulo, mensaje);
    }

    public static void manejarInformacion(String titulo, String mensaje) {
        System.out.println("ℹ Información: " + titulo + " - " + mensaje);
        mostrarAlertaInformacion(titulo, mensaje);
    }

    public static boolean manejarConfirmacion(String titulo, String mensaje) {
        System.out.println("❓ Confirmación: " + titulo + " - " + mensaje);
        return mostrarAlertaConfirmacion(titulo, mensaje);
    }

    private static void mostrarAlertaError(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private static void mostrarAlertaErrorConDetalles(String titulo, String mensaje, Throwable excepcion) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        excepcion.printStackTrace(pw);
        String detallesExcepcion = sw.toString();

        TextArea textArea = new TextArea(detallesExcepcion);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);

        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane contenidoExpandible = new GridPane();
        contenidoExpandible.setMaxWidth(Double.MAX_VALUE);
        contenidoExpandible.add(textArea, 0, 0);

        alerta.getDialogPane().setExpandableContent(contenidoExpandible);
        alerta.showAndWait();
    }

    private static void mostrarAlertaAdvertencia(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private static void mostrarAlertaInformacion(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private static boolean mostrarAlertaConfirmacion(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        Optional<ButtonType> resultado = alerta.showAndWait();
        return resultado.isPresent() && resultado.get() == ButtonType.OK;
    }
}