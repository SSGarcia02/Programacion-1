package demo_proyectofinal_fx.demoapp.viewController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import demo_proyectofinal_fx.demoapp.controller.EntrenadorController;
import demo_proyectofinal_fx.demoapp.model.Entrenador;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdminGestionEntrenadoresViewController {
    EntrenadorController entrenadorController;
    ObservableList<Entrenador> listaEntrenadores = FXCollections.observableArrayList();
    Entrenador entrenadorSeleccionado;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAsignar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TableView<Entrenador> tableGestionEntrenadores;

    @FXML
    private TableColumn<Entrenador,String> tcApellido;

    @FXML
    private TableColumn<Entrenador, ArrayList<Entrenador>> tcClase;

    @FXML
    private TableColumn<Entrenador,String> tcEdad;

    @FXML
    private TableColumn<Entrenador,String> tcIdentificacion;

    @FXML
    private TableColumn<Entrenador,String> tcNombre;

    @FXML
    private TableColumn<Entrenador,String> tcTelefono;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtClase;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    void initialize() {
        entrenadorController = new EntrenadorController();
        initView();
    }
    private void initView() {
        initDataBinding();
        obtenerEntrenador();
        tableGestionEntrenadores.getItems().clear();
        tableGestionEntrenadores.setItems(listaEntrenadores);
        listenerSeleccion();
    }
    private void obtenerEntrenador() {
        listaEntrenadores.addAll(entrenadorController.obtenerEntrenadores());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));


    }

    private void listenerSeleccion() {
        tableGestionEntrenadores.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newSelection) -> {
            entrenadorSeleccionado = newSelection;
            mostrarInformacion(entrenadorSeleccionado);
        });
    }
    private void mostrarInformacion(Entrenador entrenadorSeleccionado) {
        if (entrenadorSeleccionado != null) {
            txtNombre.setText(entrenadorSeleccionado.getNombre());
            txtApellido.setText(entrenadorSeleccionado.getApellido());
            txtIdentificacion.setText(entrenadorSeleccionado.getIdentificacion());
            txtEdad.setText(String.valueOf(entrenadorSeleccionado.getEdad()));
            txtTelefono.setText(entrenadorSeleccionado.getTelefono());
        }
    }


    @FXML
    void onActualizarEntrenador(ActionEvent event) {

    }

    @FXML
    void onAsignarEntrenador(ActionEvent event) {

    }

    @FXML
    void onEliminarEntrenador(ActionEvent event) {

    }

    @FXML
    void onRegistrarEntrenador(ActionEvent event) {

    }



}
