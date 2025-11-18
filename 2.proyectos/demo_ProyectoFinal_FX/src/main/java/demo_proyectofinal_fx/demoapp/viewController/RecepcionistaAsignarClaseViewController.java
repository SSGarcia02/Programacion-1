package demo_proyectofinal_fx.demoapp.viewController;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import demo_proyectofinal_fx.demoapp.controller.AsignarClaseController;
import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.Clase;
import demo_proyectofinal_fx.demoapp.model.Entrenador;
import demo_proyectofinal_fx.demoapp.model.TipoClases;
import demo_proyectofinal_fx.demoapp.model.Usuario;
import demo_proyectofinal_fx.demoapp.utils.DataUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RecepcionistaAsignarClaseViewController {
    AsignarClaseController asignarClaseController;
    ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    Usuario usuarioSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAsignar;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ComboBox<String> comboBoxClase;

    @FXML
    private ComboBox<String> comboBoxEntrenador;

    @FXML
    private ComboBox<String> comboBoxHorario;

    @FXML
    private TableView<Usuario> tableUsuario;

    @FXML
    private TableColumn<Usuario, String> tcApellido;

    @FXML
    private TableColumn<Usuario, String> tcClase;

    @FXML
    private TableColumn<Usuario, String> tcEntrenador;

    @FXML
    private TableColumn<Usuario, String> tcEstadoMembresia;

    @FXML
    private TableColumn<Usuario, String> tcHorario;

    @FXML
    private TableColumn<Usuario, String> tcIdentificacion;

    @FXML
    private TableColumn<Usuario, String> tcNombre;

    @FXML
    private TextField txtCupoDisponible;

    @FXML
    void onActualizar(ActionEvent event) {
        editarClaseDeUsuario();
    }

    @FXML
    void onAsignar(ActionEvent event) {
        asignarClaseAUsuario();
    }

    @FXML
    void onBorrar(ActionEvent event) {
        borrarClaseDeUsuario();
    }

    @FXML
    void onLimpiar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void initialize() {
        asignarClaseController = new AsignarClaseController();
        DataUtil.inicializarDatos();
        initView();
        cargarEntrenadores();
        comboBoxClase.getItems().addAll("YOGA", "SPINNING", "RUMBA");
        comboBoxHorario.getItems().addAll("8:00 - 10:00", "10:00 - 12:00",
                "14:00 - 16:00", "16:00 - 18:00");

    }

    private void initView() {
        initDataBinding();
        obtenerUsuario();
        listaUsuarios = ModelFactory.getInstancia().obtenerUsuariosObservable();
        tableUsuario.setItems(listaUsuarios);
        listenerSeleccion();
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getApellido()));
        tcIdentificacion.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tcEstadoMembresia.setCellValueFactory(cellData -> {
            Usuario usuario = cellData.getValue();
            if (usuario == null || usuario.getMembresia() == null) {
                return new SimpleStringProperty("NO ACTIVA");
            }
            return new SimpleStringProperty(usuario.getMembresia().isEstado() ? "Activa" : "Inactiva");
        });
        tcClase.setCellValueFactory(cellData -> {
            Usuario usuario = cellData.getValue();
            if (usuario != null && usuario.getClase() != null && usuario.getClase().getTipoClase() != null) {
                return new SimpleStringProperty(usuario.getClase().getNombre());
            } else {
                return new SimpleStringProperty("Sin Asignar");
            }
        });
        tcHorario.setCellValueFactory(cellData -> {
            Usuario usuario = cellData.getValue();
            if (usuario != null && usuario.getClase() != null && usuario.getClase().getHoraInicio() != null) {
                return new SimpleStringProperty(
                        usuario.getClase().getHoraInicio().format(DateTimeFormatter.ofPattern("HH:mm"))
                );
            } else {
                return new SimpleStringProperty("Sin Asignar");
            }
        });
        tcEntrenador.setCellValueFactory(cellData -> {
            Usuario usuario = cellData.getValue();
            if (usuario != null && usuario.getClase() != null && usuario.getClase().getEntrenadorAsignado() != null) {
                return new SimpleStringProperty(usuario.getClase().getEntrenadorAsignado().getNombre());
            } else {
                return new SimpleStringProperty("Sin Asignar");
            }
        });
    }
    private void asignarClaseAUsuario() {
        if (usuarioSeleccionado == null) {
            mostrarMensaje("Error", "Usuario no seleccionado",
                    "Por favor seleccione un usuario de la tabla", Alert.AlertType.WARNING);
            return;
        }

        if (comboBoxClase.getValue() == null || comboBoxHorario.getValue() == null ||
                comboBoxEntrenador.getValue() == null) {
            mostrarMensaje("Error", "Datos incompletos",
                    "Por favor seleccione clase, horario y entrenador", Alert.AlertType.WARNING);
            return;
        }

        // Llamar al método del Gimnasio
        try {
            // ✅ CORREGIDO - Usar la instancia del controller
            boolean asignacionExitosa = AsignarClaseController.asignarClaseAUsuario(
                    usuarioSeleccionado.getIdentificacion(),
                    comboBoxClase.getValue(),
                    comboBoxHorario.getValue(),
                    comboBoxEntrenador.getValue()
            );

            if (asignacionExitosa) {
                mostrarMensaje("Éxito", "Clase asignada",
                        "La clase ha sido asignada exitosamente al usuario " +
                                usuarioSeleccionado.getNombre(), Alert.AlertType.INFORMATION);

                tableUsuario.refresh();
                limpiarCampos();;

            } else {
                mostrarMensaje("Error", "No se pudo asignar la clase",
                        "Verifique que:\n- El usuario tenga membresía activa\n- Haya cupo disponible",
                        Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            mostrarMensaje("Error", "Error inesperado",
                    "Ocurrió un error: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
    private void borrarClaseDeUsuario() {
        if (usuarioSeleccionado == null) {
            mostrarMensaje("Error", "Usuario no seleccionado",
                    "Por favor seleccione un usuario de la tabla", Alert.AlertType.WARNING);
            return;
        }

        // Validar que el usuario tenga una clase asignada
        if (usuarioSeleccionado.getClase() == null) {
            mostrarMensaje("Información", "Sin clase asignada",
                    "El usuario " + usuarioSeleccionado.getNombre() +
                            " no tiene una clase asignada para eliminar", Alert.AlertType.INFORMATION);
            return;
        }

        // Confirmación antes de eliminar
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminación");
        confirmacion.setHeaderText("Eliminar clase asignada");
        confirmacion.setContentText("¿Está seguro de que desea eliminar la clase \"" +
                usuarioSeleccionado.getClase().getNombre() +
                "\" del usuario " + usuarioSeleccionado.getNombre() + "?");

        Optional<ButtonType> resultado = confirmacion.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            try {
                // Llamar al método del controller para borrar la clase
                boolean eliminacionExitosa = asignarClaseController.borrarClaseDeUsuario(usuarioSeleccionado.getIdentificacion());

                if (eliminacionExitosa) {
                    mostrarMensaje("Éxito", "Clase eliminada",
                            "La clase ha sido eliminada exitosamente del usuario " +
                                    usuarioSeleccionado.getNombre(), Alert.AlertType.INFORMATION);

                    // Actualizar la tabla y limpiar campos
                    tableUsuario.refresh();
                    limpiarCampos();

                } else {
                    mostrarMensaje("Error", "No se pudo eliminar la clase",
                            "Ocurrió un error al intentar eliminar la clase",
                            Alert.AlertType.ERROR);
                }
            } catch (Exception e) {
                mostrarMensaje("Error", "Error inesperado",
                        "Ocurrió un error: " + e.getMessage(), Alert.AlertType.ERROR);
                e.printStackTrace();
            }
        }
    }

    private void editarClaseDeUsuario() {
        if (usuarioSeleccionado == null || usuarioSeleccionado.getClase() == null) {
            mostrarMensaje("Error", "Seleccione un usuario con clase asignada", "", Alert.AlertType.WARNING);
            return;
        }

        if (comboBoxClase.getValue() == null || comboBoxHorario.getValue() == null || comboBoxEntrenador.getValue() == null) {
            mostrarMensaje("Error", "Complete todos los campos", "", Alert.AlertType.WARNING);
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setContentText("¿Cambiar clase del usuario?");

        if (confirmacion.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            boolean exito = asignarClaseController.editarClaseDeUsuario(
                    usuarioSeleccionado.getIdentificacion(),
                    comboBoxClase.getValue(),
                    comboBoxHorario.getValue(),
                    comboBoxEntrenador.getValue()
            );

            if (exito) {
                mostrarMensaje("Éxito", "Clase actualizada", "", Alert.AlertType.INFORMATION);
                tableUsuario.refresh();
            } else {
                mostrarMensaje("Error", "No se pudo actualizar la clase", "Verifique membresía y cupo", Alert.AlertType.ERROR);
            }
        }
    }
    private void cargarEntrenadores() {
        comboBoxEntrenador.getItems().clear();

        // Verificar que la lista no sea null
        if (AsignarClaseController.getListaEntrenadores() != null) {
            List<Entrenador> entrenadores = AsignarClaseController.obtenerEntrenadoresDisponibles();
            comboBoxEntrenador.getItems().addAll(
                    entrenadores.stream()
                            .map(Entrenador::getNombre)
                            .collect(Collectors.toList())
            );
        } else {
            System.err.println("Error: Lista de entrenadores es null");
        }
    }

    private void limpiarCampos() {
        comboBoxClase.setValue(null);
        comboBoxHorario.setValue(null);
        comboBoxEntrenador.setValue(null);
    }

    private void obtenerUsuario() {
        listaUsuarios.addAll(asignarClaseController.obtenerUsuarios());

    }

    private void listenerSeleccion() {
        tableUsuario.getSelectionModel().selectedItemProperty().addListener((observable,
                                                                             oldValue, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacion(usuarioSeleccionado);
        });
    }

    private void mostrarInformacion(Usuario usuarioSeleccionado) {
        if (usuarioSeleccionado != null) {
            if (usuarioSeleccionado.getClase() != null) {
                Clase clase = usuarioSeleccionado.getClase();

                if (clase.getTipoClase() != null) {
                    comboBoxClase.setValue(clase.getTipoClase().name());
                }

                if (clase.getHoraInicio() != null) {
                    String horarioFormateado = clase.getHoraInicio().format(DateTimeFormatter.ofPattern("H:mm")) + " - " +
                            clase.getHoraInicio().plusHours(2).format(DateTimeFormatter.ofPattern("H:mm"));
                    comboBoxHorario.setValue(horarioFormateado);
                }

                if (clase.getEntrenadorAsignado() != null) {
                    comboBoxEntrenador.setValue(clase.getEntrenadorAsignado().getNombre());
                }
            } else {
                limpiarCampos();
            }
            int cupoMaximo = usuarioSeleccionado.getClase().getCupoMaximo();
            int usuariosInscritos = asignarClaseController.obtenerCantidadUsuariosEnClase(usuarioSeleccionado.getClase());
            int cupoDisponible = cupoMaximo - usuariosInscritos;

            txtCupoDisponible.setText(cupoDisponible + " / " + cupoMaximo);

        } else {
            limpiarCampos();
            txtCupoDisponible.setText(""); // Limpiar cupo si no tiene clase
        }

    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
}
