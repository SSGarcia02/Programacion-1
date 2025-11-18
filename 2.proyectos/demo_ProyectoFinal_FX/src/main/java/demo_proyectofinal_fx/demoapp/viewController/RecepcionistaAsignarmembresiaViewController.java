package demo_proyectofinal_fx.demoapp.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

import demo_proyectofinal_fx.demoapp.controller.MembresiaController;
import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RecepcionistaAsignarmembresiaViewController {

    MembresiaController membresiaController;
    ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    Usuario usuarioSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ComboBoxPlan;

    @FXML
    private ComboBox<String> ComboBoxTipo;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAsignar;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Usuario> tableUsuario;
    @FXML
    private TableColumn<Usuario, String> tcNombre;

    @FXML
    private TableColumn<Usuario, String> tcApellido;

    @FXML
    private TableColumn<Usuario, String> tcIdentificacion;

    @FXML
    private TableColumn<Usuario, String> tcTipoMembresia;

    @FXML
    private TableColumn<Usuario, String> tcPlan;

    @FXML
    private TableColumn<Usuario, String> tcCosto;

    @FXML
    private TableColumn<Usuario, String> tcFechaCierre;

    @FXML
    private TableColumn<Usuario, String> tcFechaInicio;


    @FXML
    private TextField txtCosto;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtEstado;

    @FXML
    private TextField txtFechaCierre;

    @FXML
    private TextField txtFechaInicio;

    @FXML
    void onActualizar(ActionEvent event) {
        editarMembresia();
    }

    @FXML
    void onAsignar(ActionEvent event) {
        asignarMembresia();
    }

    @FXML
    void onBorrar(ActionEvent event) {
        borrarMembresia();
    }

    @FXML
    void onLimpiar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void initialize() {
        membresiaController = new MembresiaController();
        initView();
        ComboBoxTipo.getItems().addAll("BÁSICA", "PREMIUM", "VIP");
        ComboBoxPlan.getItems().addAll("MENSUAL", "TRIMESTRAL", "ANUAL");
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
        tcTipoMembresia.setCellValueFactory(cellData -> {
            Usuario usuario = cellData.getValue();
            if (usuario != null && usuario.getMembresia() != null) {
                return new SimpleStringProperty(usuario.getMembresia().getTipoMembresia());
            } else {
                return new SimpleStringProperty("Sin Asignar");
            }
        });
        tcPlan.setCellValueFactory(cellData -> {
            Usuario usuario = cellData.getValue();
            if(usuario != null && usuario.getMembresia() != null &&
                    usuario.getMembresia().getPeriodoMembresia() != null){

                PeriodoMembresia periodo = usuario.getMembresia().getPeriodoMembresia();
                String nombrePeriodo = convertirPeriodoMembresiaAString(periodo);
                return new SimpleStringProperty(nombrePeriodo);
            } else {
                return new SimpleStringProperty("Sin Asignar");
            }
        });
        tcCosto.setCellValueFactory(cellData -> {
            Usuario usuario = cellData.getValue();
            if (usuario != null && usuario.getMembresia() != null) {
                return new SimpleStringProperty(String.valueOf(usuario.getMembresia().getCosto()));
            } else {
                return new SimpleStringProperty("0.0");
            }
        });
        tcFechaInicio.setCellValueFactory(cellData -> {
            Usuario usuario = cellData.getValue();
            if (usuario != null && usuario.getMembresia() != null && usuario.getMembresia().getFechaInicio() != null) {
                return new SimpleStringProperty(
                        usuario.getMembresia().getFechaInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                );
            } else {
                return new SimpleStringProperty("--/--/----");
            }
        });
        tcFechaCierre.setCellValueFactory(cellData -> {
            Usuario usuario = cellData.getValue();
            if (usuario != null && usuario.getMembresia() != null && usuario.getMembresia().getFechaFinal() != null) {
                return new SimpleStringProperty(
                        usuario.getMembresia().getFechaFinal().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                );
            } else {
                return new SimpleStringProperty("--/--/----");
            }
        });
        tableUsuario.refresh();
    }
    private String convertirPeriodoMembresiaAString(PeriodoMembresia periodo) {
        if (periodo == null) return "Sin Asignar";

        switch (periodo) {
            case MENSUAL: return "Mensual";
            case TRIMESTRAL: return "Trimestral";
            case ANUAL: return "Anual";
            default: return periodo.name();
        }
    }

    private void asignarMembresia() {
        try {
            // Validar que todos los campos estén completos
            if (usuarioSeleccionado == null || ComboBoxTipo.getValue() == null || ComboBoxPlan.getValue() == null) {
                mostrarMensaje("Error", "Faltan datos",
                        "Complete todos los campos y seleccione un usuario", Alert.AlertType.WARNING);
                return;
            }

            // Crear la membresía
            Membresia membresia = crearMembresia();
            if (membresia == null) {
                return; // Ya se mostró mensaje de error en crearMembresia()
            }

            // Usar el método del controller que valida membresías existentes
            boolean exito = membresiaController.asignarMembresia(membresia, usuarioSeleccionado.getIdentificacion());

            if (exito) {
                mostrarMensaje("Éxito", "Membresía asignada",
                        "Membresía " + membresia.getTipoMembresia() + " asignada exitosamente a " +
                                usuarioSeleccionado.getNombre(), Alert.AlertType.INFORMATION);

                tableUsuario.refresh();
                ComboBoxTipo.setValue(null);
                ComboBoxPlan.setValue(null);

            } else {
                mostrarMensaje("Error", "No se pudo asignar",
                        "El usuario " + usuarioSeleccionado.getNombre() + " ya tiene una membresía activa.",
                        Alert.AlertType.WARNING);
            }

        } catch (Exception e) {
            mostrarMensaje("Error", "Error al asignar", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    private Membresia crearMembresia(){
        try {
            // Validar que todos los campos estén seleccionados
            if (ComboBoxPlan.getValue() == null || ComboBoxTipo.getValue() == null || usuarioSeleccionado == null) {
                mostrarMensaje("Error", "Crear Membresía",
                        "Debe completar todos los campos y seleccionar un usuario", Alert.AlertType.WARNING);
                return null;
            }

            // Obtener valores de los ComboBox
            String tipoMembresia = ComboBoxTipo.getValue();
            PeriodoMembresia periodoSeleccionado = PeriodoMembresia.valueOf(ComboBoxPlan.getValue());

            // Llamar al controller para calcular la membresía
            Membresia membresia = membresiaController.calcularCostoMembresia(tipoMembresia, periodoSeleccionado,
                    usuarioSeleccionado);

            if (membresia == null) {
                mostrarMensaje("Error", "Crear Membresía", "No se pudo calcular la membresía",
                        Alert.AlertType.ERROR);
                return null;
            }
            membresia.setEstado(true);

            return membresia;

        } catch (IllegalArgumentException e) {
            mostrarMensaje("Error", "Período inválido", "El período seleccionado no es válido",
                    Alert.AlertType.ERROR);
            return null;
        } catch (Exception e) {
            mostrarMensaje("Error", "Crear Membresía", "Error al crear membresía: " +
                    e.getMessage(), Alert.AlertType.ERROR);
            return null;
        }
    }
    private void editarMembresia() {
        if (usuarioSeleccionado != null && usuarioSeleccionado.getMembresia() != null) {
            try {
                // Validar que todos los campos estén completos
                if (ComboBoxTipo.getValue() == null || ComboBoxPlan.getValue() == null) {
                    mostrarMensaje("Error", "Faltan datos", "Complete todos los campos",
                            Alert.AlertType.WARNING);
                    return;
                }

                // Obtener nuevos valores de los ComboBox
                String nuevoTipo = ComboBoxTipo.getValue();
                PeriodoMembresia nuevoPeriodo = PeriodoMembresia.valueOf(ComboBoxPlan.getValue());

                // Calcular la nueva membresía con los datos actualizados
                Membresia membresiaEditada = membresiaController.calcularCostoMembresia(
                        nuevoTipo, nuevoPeriodo, usuarioSeleccionado
                );

                // Llamar al método del controller para editar
                boolean exito = membresiaController.editarMembresia(
                        membresiaEditada, usuarioSeleccionado.getIdentificacion()
                );

                if (exito) {
                    mostrarMensaje("Éxito", "Editar Membresía",
                            "Membresía actualizada exitosamente para " + usuarioSeleccionado.getNombre(),
                            Alert.AlertType.INFORMATION);

                    // Actualizar tabla
                    tableUsuario.refresh();

                    // Opcional: Limpiar campos
                    ComboBoxTipo.setValue(null);
                    ComboBoxPlan.setValue(null);

                } else {
                    mostrarMensaje("Error", "Editar Membresía",
                            "No se pudo actualizar la membresía", Alert.AlertType.ERROR);
                }

            } catch (Exception e) {
                mostrarMensaje("Error", "Error al editar", e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            String mensaje = "";
            if (usuarioSeleccionado == null) {
                mensaje = "Debe seleccionar un usuario";
            } else if (usuarioSeleccionado.getMembresia() == null) {
                mensaje = "El usuario no tiene una membresía asignada para editar";
            }
            mostrarMensaje("Advertencia", "Editar Membresía", mensaje, Alert.AlertType.WARNING);
        }
    }

    private void borrarMembresia() {
        if (usuarioSeleccionado != null) {
            try {
                // Confirmar con el usuario
                Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                confirmacion.setTitle("Confirmar Eliminación");
                confirmacion.setHeaderText("Eliminar Membresía");
                confirmacion.setContentText("¿Está seguro de que desea eliminar la membresía de " +
                        usuarioSeleccionado.getNombre() + " " +
                        usuarioSeleccionado.getApellido() + "?");

                Optional<ButtonType> resultado = confirmacion.showAndWait();

                if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                    // Llamar al controller para eliminar la membresía
                    boolean exito = membresiaController.borrarMembresia(usuarioSeleccionado.getIdentificacion());

                    if (exito) {
                        mostrarMensaje("Éxito", "Eliminar Membresía",
                                "Membresía eliminada exitosamente de " + usuarioSeleccionado.getNombre(),
                                Alert.AlertType.INFORMATION);

                        // Actualizar la tabla
                        tableUsuario.refresh();
                    } else {
                        mostrarMensaje("Error", "Eliminar Membresía",
                                "No se pudo eliminar la membresía",
                                Alert.AlertType.ERROR);
                    }
                }
            } catch (Exception e) {
                mostrarMensaje("Error", "Eliminar Membresía",
                        "Error al eliminar membresía: " + e.getMessage(),
                        Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Advertencia", "Eliminar Membresía",
                    "Debe seleccionar un usuario de la tabla",
                    Alert.AlertType.WARNING);
        }
    }
    private void limpiarCampos() {
        ComboBoxTipo.setValue(null);
        ComboBoxPlan.setValue(null);
        txtCosto.setText("");
        txtFechaInicio.setText("");
        txtFechaCierre.setText("");
        txtEstado.setText("");
    }


    private void obtenerUsuario() {
        listaUsuarios.addAll(membresiaController.obtenerUsuarios());

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

            String DescMembresia = "";
            Membresia membresiaUsuario = usuarioSeleccionado.getMembresia();

            if (usuarioSeleccionado.getMembresia() instanceof MembresiaBasica) {
                DescMembresia = ((MembresiaBasica) membresiaUsuario).getDescripcion();
            } else if (usuarioSeleccionado.getMembresia() instanceof MembresiaPremium) {
                DescMembresia = ((MembresiaPremium) membresiaUsuario).getDescripcion();
            } else if (usuarioSeleccionado.getMembresia() instanceof MembresiaVIP) {
                DescMembresia = ((MembresiaVIP) membresiaUsuario).getDescripcion();
            }

            String descripcion = "Usuario: " + usuarioSeleccionado.getNombre() + " "
                    + usuarioSeleccionado.getApellido() +
                    "\nTipo de membresia: " + usuarioSeleccionado.getMembresia().getTipoMembresia() +
                    "\nPlan: " + usuarioSeleccionado.getMembresia().getPeriodoMembresia() +
                    "\nCosto: $" + usuarioSeleccionado.getMembresia().getCosto() +
                    "\nFecha de inicio: " + usuarioSeleccionado.getMembresia().getFechaInicio() +
                    "\nFecha de cierre: " + usuarioSeleccionado.getMembresia().getFechaFinal() +
                    "\nEstado: " + (usuarioSeleccionado.getMembresia().isEstado() ? "ACTIVA" : "INACTIVA") +
                    "\n\n" + DescMembresia;

            txtDescripcion.setText(descripcion);

            String tipoMembresia = "Sin Asignar";
            if (usuarioSeleccionado.getMembresia() instanceof MembresiaBasica) {
                tipoMembresia = "Basica";
            } else if (usuarioSeleccionado.getMembresia() instanceof MembresiaVIP) {
                tipoMembresia = "VIP";
            } else if (usuarioSeleccionado.getMembresia() instanceof MembresiaPremium) {
                tipoMembresia = "PREMIUM";
            }
            ComboBoxTipo.setValue(tipoMembresia);
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

