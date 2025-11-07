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

    @FXML private Label lblMensaje;

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

        // si en Entrenador hay un método getClaseAsignada()
        //tcClase.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getClaseAsignada()));
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
            //txtClase.setText(entrenadorSeleccionado.getClaseAsignada());
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

        listaEntrenadores.add(nuevo); // ✅ ACTUALIZA TABLA AUTOMÁTICAMENTE
        tableGestionEntrenadores.refresh(); // OPCIONAL

        mostrarAlerta("✅ Entrenador registrado con éxito.");
    }
    @FXML
    void onAsignarEntrenador(ActionEvent event) {

        if (entrenadorSeleccionado == null) {
            mostrarAlerta("Debe seleccionar un entrenador de la tabla");
            return;
        }

        String nombreClase = txtClase.getText().trim();

        if (nombreClase.isEmpty()) {
            mostrarAlerta("Debe ingresar el nombre de la clase");
            return;
        }

        boolean asignado = entrenadorController.asignarEntrenadorAClase(
                entrenadorSeleccionado.getIdentificacion(),
                nombreClase
        );

        if (asignado) {
            mostrarAlerta("✅ Entrenador asignado correctamente.");
        } else {
            mostrarAlerta("❌ No se encontró la clase.");
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

            cargarEntrenadores();   // ⬅️ Recarga la tabla
            limpiarCampos();        // ⬅️ Limpia los campos de texto

            entrenadorSeleccionado = null; // ⬅️ Evita usar un entrenador ya eliminado
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

        // Obtener lo que escribe el usuario en los TextField
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String id = txtIdentificacion.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String telefono = txtTelefono.getText();

        boolean actualizado = entrenadorController.actualizarEntrenador(
                entrenadorSeleccionado.getIdentificacion(),
                nombre, apellido, id, edad, telefono
        );

        if (actualizado) {
            mostrarAlerta("✅ Entrenador actualizado correctamente.");
            cargarEntrenadores();   // <-- RECARGA LA TABLA
            tableGestionEntrenadores.refresh(); // <-- REFRESCA LA UI
        } else {
            mostrarAlerta("❌ No se pudo actualizar el entrenador.");
        }
    }
}