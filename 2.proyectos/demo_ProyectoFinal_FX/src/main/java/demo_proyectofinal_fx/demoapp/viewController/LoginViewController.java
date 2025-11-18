package demo_proyectofinal_fx.demoapp.viewController;

import demo_proyectofinal_fx.demoapp.GimnasioApplication;
import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.Administrador;
import demo_proyectofinal_fx.demoapp.model.Recepcionista;
import demo_proyectofinal_fx.demoapp.model.UsuarioSistema;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable {

    @FXML
    private ComboBox<String> comboTipoUsuario;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblMensaje;

    private ModelFactory modelFactory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modelFactory = ModelFactory.getInstancia();
        comboTipoUsuario.getItems().addAll("Administrador", "Recepcionista");
        configurarEstilos();
    }

    private void configurarEstilos() {
        txtUsuario.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                txtUsuario.setStyle("-fx-border-color: #3498db; -fx-border-radius: 4; -fx-background-radius: 4; -fx-padding: 8;");
            } else {
                txtUsuario.setStyle("-fx-border-color: #bdc3c7; -fx-border-radius: 4; -fx-background-radius: 4; -fx-padding: 8;");
            }
        });

        txtPassword.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                txtPassword.setStyle("-fx-border-color: #3498db; -fx-border-radius: 4; -fx-background-radius: 4; -fx-padding: 8;");
            } else {
                txtPassword.setStyle("-fx-border-color: #bdc3c7; -fx-border-radius: 4; -fx-background-radius: 4; -fx-padding: 8;");
            }
        });
    }

    @FXML
    private void onLogin() {
        String tipoUsuario = comboTipoUsuario.getValue();
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();

        if (validarCampos(tipoUsuario, usuario, password)) {
            UsuarioSistema usuarioAutenticado = autenticarUsuario(usuario, password);

            if (usuarioAutenticado != null) {
                if (validarTipoUsuario(usuarioAutenticado, tipoUsuario)) {
                    lblMensaje.setText("✅ Acceso concedido, redirigiendo...");
                    redirigirSegunTipo(tipoUsuario);
                } else {
                    lblMensaje.setText("❌ Tipo de usuario incorrecto para las credenciales.");
                }
            } else {
                lblMensaje.setText("❌ Credenciales incorrectas. Verifique e intente nuevamente.");
            }
        }
    }

    private boolean validarCampos(String tipoUsuario, String usuario, String password) {
        lblMensaje.setText("");
        if (tipoUsuario == null) {
            lblMensaje.setText("⚠ Debe seleccionar un tipo de usuario");
            comboTipoUsuario.requestFocus();
            return false;
        }
        if (usuario.isEmpty()) {
            lblMensaje.setText("⚠ El campo usuario es obligatorio");
            txtUsuario.requestFocus();
            return false;
        }
        if (password.isEmpty()) {
            lblMensaje.setText("⚠ El campo contraseña es obligatorio");
            txtPassword.requestFocus();
            return false;
        }
        return true;
    }

    private UsuarioSistema autenticarUsuario(String usuario, String password) {
        return modelFactory.autenticarUsuario(usuario, password);
    }

    private boolean validarTipoUsuario(UsuarioSistema usuarioAutenticado, String tipoSeleccionado) {
        if ("Administrador".equals(tipoSeleccionado) && usuarioAutenticado instanceof Administrador) {
            return true;
        } else if ("Recepcionista".equals(tipoSeleccionado) && usuarioAutenticado instanceof Recepcionista) {
            return true;
        }
        return false;
    }

    private void redirigirSegunTipo(String tipoUsuario) {
        try {
            if ("Administrador".equals(tipoUsuario)) {
                GimnasioApplication.cambiarEscena("AdminMainView.fxml", "Panel de Administración - Gimnasio UQ");
            } else if ("Recepcionista".equals(tipoUsuario)) {
                GimnasioApplication.cambiarEscena("RecepcionistaMainView.fxml", "Panel de Recepción - Gimnasio UQ");
            }
        } catch (Exception e) {
            lblMensaje.setText("❌ Error al cargar el sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
}