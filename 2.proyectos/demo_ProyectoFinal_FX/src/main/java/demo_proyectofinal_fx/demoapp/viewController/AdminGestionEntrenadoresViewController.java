package demo_proyectofinal_fx.demoapp.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import javafx.event.ActionEvent;

import demo_proyectofinal_fx.demoapp.controller.EntrenadorController;
import demo_proyectofinal_fx.demoapp.model.Entrenador;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class AdminGestionEntrenadoresViewController implements Initializable {

    EntrenadorController entrenadorController;
    ObservableList<Entrenador> listaEntrenadores = FXCollections.observableArrayList();
    Entrenador entrenadorSeleccionado;
    ModelFactory mfc = ModelFactory.getInstancia();

    @FXML
    private Label lblMensaje;
    @FXML
    private Button btnEliminarClase;
    @FXML
    private Button btnActualizar, btnAsignar, btnEliminar, btnRegistrar;
    @FXML
    private TableView<Entrenador> tableGestionEntrenadores;
    @FXML
    private TableColumn<Entrenador,String> tcApellido, tcEdad, tcIdentificacion, tcNombre, tcTelefono, tcClase;
    @FXML
    private TextField txtApellido, txtClase, txtEdad, txtIdentificacion, txtNombre, txtTelefono;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        entrenadorController = new EntrenadorController();
        initView();
    }

    private void initView() {
        initDataBinding();
        cargarEntrenadores();
        listenerSeleccion();
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNombre()));
        tcApellido.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getApellido()));
        tcIdentificacion.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getIdentificacion()));
        tcEdad.setCellValueFactory(cd -> new SimpleStringProperty(String.valueOf(cd.getValue().getEdad())));
        tcTelefono.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getTelefono()));

        // SOLUCIÓN TEMPORAL - mientras agregas los métodos a Entrenador
        tcClase.setCellValueFactory(cd -> {
            try {
                return new SimpleStringProperty(cd.getValue().getClasesAsString());
            } catch (Exception e) {
                return new SimpleStringProperty("Sin asignar");
            }
        });
    }

    private void cargarEntrenadores() {
        listaEntrenadores.clear();
        listaEntrenadores.addAll(entrenadorController.obtenerEntrenadores());
        tableGestionEntrenadores.setItems(listaEntrenadores);
    }

    private void listenerSeleccion() {
        tableGestionEntrenadores.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            entrenadorSeleccionado = newValue;
            mostrarInformacion();
        });
    }

    private void mostrarInformacion() {
        if (entrenadorSeleccionado != null) {
            txtNombre.setText(entrenadorSeleccionado.getNombre());
            txtApellido.setText(entrenadorSeleccionado.getApellido());
            txtIdentificacion.setText(entrenadorSeleccionado.getIdentificacion());
            txtEdad.setText(String.valueOf(entrenadorSeleccionado.getEdad()));
            txtTelefono.setText(entrenadorSeleccionado.getTelefono());
            if (!entrenadorSeleccionado.getClasesAsignadas().isEmpty()) {
                txtClase.setText(entrenadorSeleccionado.getClasesAsString());
            } else {
                txtClase.clear();
            }
        }
    }

    @FXML
    void onRegistrarEntrenador() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String id = txtIdentificacion.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String telefono = txtTelefono.getText();

        Entrenador nuevo = entrenadorController.registrarEntrenador(nombre, apellido, id, edad, telefono);
        listaEntrenadores.add(nuevo);
        tableGestionEntrenadores.refresh();
        mostrarAlerta("✅ Entrenador registrado con éxito.");
    }

    @FXML
    public void onAsignarEntrenador(ActionEvent event) {
        this.entrenadorSeleccionado = tableGestionEntrenadores.getSelectionModel().getSelectedItem();
        if (this.entrenadorSeleccionado == null) {
            mostrarAlerta("Selecciona un entrenador primero");
            return;
        }
        String nombreClase = txtClase.getText().trim();
        if (nombreClase.isEmpty()) {
            mostrarAlerta("Escribe el nombre de la clase para asignar");
            return;
        }

        // SOLUCIÓN TEMPORAL - verificar si ya tiene la clase
        try {
            if (this.entrenadorSeleccionado.getClasesAsignadas().contains(nombreClase)) {
                mostrarAlerta("⚠ Este entrenador ya tiene asignada la clase: " + nombreClase);
                return;
            }
        } catch (Exception e) {
            // Si no existe el método, continuar
        }

        boolean asignado = entrenadorController.asignarEntrenador(
                this.entrenadorSeleccionado.getIdentificacion(),
                nombreClase
        );

        if (asignado) {
            mostrarAlerta("✅ Clase '" + nombreClase + "' asignada correctamente.");

            // SOLUCIÓN TEMPORAL - mientras agregas el método agregarClase
            try {
                this.entrenadorSeleccionado.agregarClase(nombreClase);
            } catch (Exception e) {
                // Si no existe el método, no hacer nada
            }

            cargarEntrenadores();
            tableGestionEntrenadores.refresh();
            txtClase.clear();
        } else {
            mostrarAlerta("❌ No se pudo asignar la clase.");
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    public void onEliminarEntrenador(ActionEvent event) {
        if (entrenadorSeleccionado == null) {
            mostrarAlerta("⚠ Debe seleccionar un entrenador de la tabla.");
            return;
        }

        String id = entrenadorSeleccionado.getIdentificacion();
        boolean eliminado = entrenadorController.eliminarEntrenador(id);

        if (eliminado) {
            mostrarAlerta("✅ Entrenador eliminado correctamente.");
            cargarEntrenadores();
            limpiarCampos();
            entrenadorSeleccionado = null;
        } else {
            mostrarAlerta("❌ No existe un entrenador con ese ID.");
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtIdentificacion.clear();
        txtEdad.clear();
        txtTelefono.clear();
        txtClase.clear();
    }

    @FXML
    void onActualizarEntrenador() {
        if (entrenadorSeleccionado == null) {
            mostrarAlerta("Debe seleccionar un entrenador para actualizar.");
            return;
        }

        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String id = txtIdentificacion.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String telefono = txtTelefono.getText();

        boolean actualizado = entrenadorController.actualizarEntrenador(
                entrenadorSeleccionado.getIdentificacion(),
                nombre, apellido, id, edad, telefono
                // ELIMINAR el parámetro claseAsignada
        );

        if (actualizado) {
            mostrarAlerta("✅ Entrenador actualizado correctamente.");
            cargarEntrenadores();
            tableGestionEntrenadores.refresh();
        } else {
            mostrarAlerta("❌ No se pudo actualizar el entrenador.");
        }
    }

    @FXML
    public void onEliminarClase(ActionEvent event) {
        if (entrenadorSeleccionado == null) {
            mostrarAlerta("Selecciona un entrenador primero");
            return;
        }

        String nombreClase = txtClase.getText().trim();
        if (nombreClase.isEmpty()) {
            mostrarAlerta("Escribe el nombre de la clase a eliminar");
            return;
        }

        // SOLUCIÓN TEMPORAL - mientras agregas el método eliminarClase
        try {
            if (entrenadorSeleccionado.getClasesAsignadas().contains(nombreClase)) {
                entrenadorSeleccionado.eliminarClase(nombreClase);
                mostrarAlerta("✅ Clase '" + nombreClase + "' eliminada.");
                cargarEntrenadores();
                tableGestionEntrenadores.refresh();
                txtClase.clear();
            } else {
                mostrarAlerta("❌ El entrenador no tiene asignada la clase: " + nombreClase);
            }
        } catch (Exception e) {
            mostrarAlerta("❌ Error: Métodos de clases no implementados en Entrenador");
        }
    }
}