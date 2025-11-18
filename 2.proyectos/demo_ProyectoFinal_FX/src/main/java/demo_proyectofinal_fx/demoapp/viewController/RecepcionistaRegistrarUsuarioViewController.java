package demo_proyectofinal_fx.demoapp.viewController;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.Externo;
import demo_proyectofinal_fx.demoapp.model.TrabajadorUQ;
import javafx.scene.control.ComboBox;
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
    private Button btnActualizarUsuario;

    @FXML
    private Button btnAgregarUsuario;

    @FXML
    private Button btnBorrarUsuario;

    @FXML
    private Button btnLimpiarUsuario;

    @FXML
    private ComboBox<String> comboBoxTipoUsuario;

    @FXML
    private TableView<Usuario> tableUsuario;

    @FXML
    private TableColumn<Usuario, String> tcApellido;

    @FXML
    private TableColumn<Usuario, String> tcEdad;

    @FXML
    private TableColumn<Usuario, String> tcIdentificacion;

    @FXML
    private TableColumn<Usuario, String> tcMembresia;

    @FXML
    private TableColumn<Usuario, String> tcNombre;

    @FXML
    private TableColumn<Usuario, String> tcTelefono;

    @FXML
    private TableColumn<Usuario, String> tcTipoDeUsuario;

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
        if(comboBoxTipoUsuario != null){
            comboBoxTipoUsuario.getItems().addAll("Estudiante", "Trabajador UQ", "Externo");
        }
    }
    private void initView() {
        initDataBinding();
        obtenerUsuario();
        listaUsuarios = ModelFactory.getInstancia().obtenerUsuariosObservable();
        tableUsuario.setItems(listaUsuarios);
        listenerSeleccion();
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tcTipoDeUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipo()));
    }

    private void obtenerUsuario() {
        listaUsuarios.addAll(usuarioController.obtenerUsuarios());
    }

    private void crearUsuario() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String identificacion = txtIdentificacion.getText();
        String edad = txtEdad.getText();
        String telefono = txtTelefono.getText();
        String tipoUsuario = comboBoxTipoUsuario.getValue();

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setIdentificacion(identificacion);
        nuevoUsuario.setEdad(Integer.parseInt(edad));
        nuevoUsuario.setTelefono(telefono);
        nuevoUsuario.setTipo(tipoUsuario);

        boolean datosValidos = validarCampos(nombre, apellido, identificacion, edad, telefono);

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
        if (usuarioSeleccionado != null) {
            try {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String identificacion = txtIdentificacion.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String telefono = txtTelefono.getText();
                String tipoSeleccionado = comboBoxTipoUsuario.getValue();

                usuarioSeleccionado.setNombre(nombre);
                usuarioSeleccionado.setApellido(apellido);
                usuarioSeleccionado.setIdentificacion(identificacion);
                usuarioSeleccionado.setEdad(edad);
                usuarioSeleccionado.setTelefono(telefono);
                usuarioSeleccionado.setTipo(tipoSeleccionado);

                boolean resultado = usuarioController.actualizarUsuario(
                        usuarioSeleccionado,
                        usuarioSeleccionado.getIdentificacion()
                );
                if (resultado) {
                    mostrarMensaje("Éxito", "Actualizar Usuario","Usuario actualizado existosamente", Alert.AlertType.CONFIRMATION);
                    tableUsuario.refresh();
                }
            } catch (NumberFormatException e) {
                mostrarMensaje("Error", "Actualizar Usuario","La edad debe ser un número válido", Alert.AlertType.ERROR);
            }
        }
    }

    private void lipiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtIdentificacion.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        comboBoxTipoUsuario.setValue(null);
    }
    private boolean validarCampos(String nombre, String apellido,
                                  String identificacion, String edad, String telefono) {

        if(nombre.isEmpty() || apellido.isEmpty() || identificacion.isEmpty() || edad.isEmpty() || telefono.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    private void listenerSeleccion() {
        tableUsuario.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacion(usuarioSeleccionado);
        });
    }
    private void mostrarInformacion(Usuario usuarioSeleccionado) {
        if(usuarioSeleccionado != null){
            txtNombre.setText(usuarioSeleccionado.getNombre());
            txtApellido.setText(usuarioSeleccionado.getApellido());
            txtIdentificacion.setText(usuarioSeleccionado.getIdentificacion());
            txtEdad.setText(String.valueOf(usuarioSeleccionado.getEdad()));
            txtTelefono.setText(usuarioSeleccionado.getTelefono());

            String tipoUsuario = "Desconocido";
            if (usuarioSeleccionado instanceof Estudiante) {
                tipoUsuario = "Estudiante";
            } else if (usuarioSeleccionado instanceof TrabajadorUQ) {
                tipoUsuario = "Trabajador UQ";
            } else if (usuarioSeleccionado instanceof Externo) {
                tipoUsuario = "Externo";
            }
            comboBoxTipoUsuario.setValue(tipoUsuario);
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
