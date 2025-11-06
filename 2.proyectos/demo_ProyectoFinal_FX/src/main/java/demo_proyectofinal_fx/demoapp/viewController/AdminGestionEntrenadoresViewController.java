package demo_proyectofinal_fx.demoapp.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import demo_proyectofinal_fx.demoapp.controller.EntrenadorController;
import demo_proyectofinal_fx.demoapp.model.Entrenador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdminGestionEntrenadoresViewController {
    EntrenadorController entrenadorController;
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
    private TableColumn<Entrenador,String> tcClase;

    @FXML
    private TableColumn<Entrenador,String> tcEdad;

    @FXML
    private TableColumn<Entrenador,String> tcIdentificacion;

    @FXML
    private TableColumn<?, ?> tcNombre;

    @FXML
    private TableColumn<?, ?> tcTelefono;

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
        obtenerUsuario();
        tableUsuario.getItems().clear();
        tableUsuario.setItems(listaUsuarios);
        listenerSeleccion();
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
