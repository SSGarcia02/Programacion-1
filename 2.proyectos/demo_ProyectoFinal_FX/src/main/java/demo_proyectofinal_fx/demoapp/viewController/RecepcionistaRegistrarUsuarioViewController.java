package demo_proyectofinal_fx.demoapp.viewController;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import demo_proyectofinal_fx.demoapp.controller.UsuarioController;
import demo_proyectofinal_fx.demoapp.model.Estudiante;
import demo_proyectofinal_fx.demoapp.model.Usuario;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

public class RecepcionistaRegistrarUsuarioViewController {

    UsuarioController usuarioController;
    ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    Usuario usuarioSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<?> ChoiseBoxMembresia;

    @FXML
    private Button btnActualizarUsuario;

    @FXML
    private Button btnAgregarUsuario;

    @FXML
    private Button btnBorrarUsuario;

    @FXML
    private Button btnLimpiarUsuario;

    @FXML
    private TableView<Usuario> tableUsuario;

    @FXML
    private TableColumn<Usuario, String> tcApellido;

    @FXML
    private TableColumn<Usuario, String> tcEdad;

    @FXML
    private TableColumn<Usuario, String> tcIdentificacion;

    @FXML
    private TableColumn<?, ?> tcMembresia;

    @FXML
    private TableColumn<Usuario, String> tcNombre;

    @FXML
    private TableColumn<Usuario, String> tcTelefono;

    @FXML
    private TableColumn<?, ?> tcTipoDeUsuario;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    void onActualizarUsuario(ActionEvent event) {
        actualizarUsuario();
    }

    @FXML
    void onAgregarUsuario(ActionEvent event) {
        crearUsuario();
    }

    @FXML
    void onBorrarUsuario(ActionEvent event) {
        borrarusuario();
    }

    @FXML
    void onLimpiarUsuario(ActionEvent event) {
        lipiarCampos();
    }

    @FXML
    void initialize() {
       usuarioController = new UsuarioController();
       initView();
    }

    private void crearUsuario() {
        //1. Captura los datos del formulario
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String identificacion = txtIdentificacion.getText();
        String edad = txtEdad.getText();
        String telefono = txtTelefono.getText();

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setIdentificacion(identificacion);
        nuevoUsuario.setEdad(Integer.parseInt(edad));
        nuevoUsuario.setTelefono(telefono);


        //2. Validar datos
        boolean datosValidos = validarCampos(nombre, apellido, identificacion, edad, telefono);

        //3. Realizar la solictud de crear el estudiante

        if(datosValidos){
            Usuario usuario = usuarioController.crearUsuario(nuevoUsuario);
            if(usuario != null){
                mostrarMensaje("Notificacion", "Creacion de Usuario", "Usuario Creado Exitosamente",Alert.AlertType.CONFIRMATION);
                listaUsuarios.add(usuario);
            }else{
                mostrarMensaje("Notificacion", "Creacion de Usuario", "No es posible crear Usuario",Alert.AlertType.WARNING);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Datos no Validos");
        }
    }
    private void borrarusuario() {
        if(usuarioSeleccionado != null){
            boolean resultado = usuarioController.borrarusuario(usuarioSeleccionado.getIdentificacion());
            if(resultado){
                mostrarMensaje("Notificacion", "Borrar Usuario", "Usuario Borrado Exitosamente",Alert.AlertType.CONFIRMATION);
                listaUsuarios.remove(usuarioSeleccionado);
            }else{
                mostrarMensaje("Notificacion", "Borrar Usuario", "No es posible borrar Usuario",Alert.AlertType.WARNING);
            }
        }else{
            mostrarMensaje("Notificacion", "Borrar Usuario", "Debe seleccionario a un usuario",Alert.AlertType.WARNING);

        }
    }
    private void actualizarUsuario() {
        if(usuarioSeleccionado != null){
            Usuario usuarioEditar = new Usuario();
            usuarioEditar.setNombre(usuarioSeleccionado.getNombre());
            usuarioEditar.setApellido(usuarioSeleccionado.getApellido());
            usuarioEditar.setIdentificacion(usuarioSeleccionado.getIdentificacion());
            usuarioEditar.setEdad(usuarioSeleccionado.getEdad());
            usuarioEditar.setTelefono(usuarioSeleccionado.getTelefono());

            boolean resultado = usuarioController.actualizarUsuario(usuarioEditar, usuarioSeleccionado.getIdentificacion());
            if(resultado){
                mostrarMensaje("Notificacion", "Editar Usuario", "Usuario editado Exitosamente",Alert.AlertType.CONFIRMATION);
            }else{
                mostrarMensaje("Notificacion", "Editar Usuario", "No es posible editar Usuario",Alert.AlertType.WARNING);

            }
        }else{
            mostrarMensaje("Notificacion", "Editar Usuario", "Debe seleccionario a un usuario",Alert.AlertType.WARNING);

        }
    }

    private void lipiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtIdentificacion.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");

    }
    private boolean validarCampos(String nombre, String apellido,
                                  String identificacion, String edad, String telefono) {

        if(nombre.isEmpty() || apellido.isEmpty() || identificacion.isEmpty() || edad.isEmpty() || telefono.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    private void initView() {
        initDataBinding();
        obtenerUsuario();
        tableUsuario.getItems().clear();
        tableUsuario.setItems(listaUsuarios);
        listenerSeleccion();
    }

    private void obtenerUsuario() {
        listaUsuarios.addAll(usuarioController.obtenerUsuarios());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));


    }

    private void listenerSeleccion() {
        tableUsuario.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacion(usuarioSeleccionado);
        });
    }
    private void mostrarInformacion(Usuario estudianteSeleccionado) {
        if(estudianteSeleccionado != null){
            txtNombre.setText(estudianteSeleccionado.getNombre());
            txtApellido.setText(estudianteSeleccionado.getApellido());
            txtIdentificacion.setText(estudianteSeleccionado.getIdentificacion());
            txtEdad.setText(String.valueOf(estudianteSeleccionado.getEdad()));
            txtTelefono.setText(estudianteSeleccionado.getTelefono());
        }
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}
