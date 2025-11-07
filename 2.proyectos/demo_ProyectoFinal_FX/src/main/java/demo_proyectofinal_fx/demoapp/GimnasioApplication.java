package demo_proyectofinal_fx.demoapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GimnasioApplication extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        cambiarEscena("RecepcionistaMainView.fxml", "App Gimnasio UQ");
    }
    public static void cambiarEscena(String fxml, String tituloVentana) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(GimnasioApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load());
            primaryStage.setTitle(tituloVentana);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch();
    }
}

/*   @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GimnasioApplication.class.getResource("RecepcionistaMainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App Gimnasio UQ");
        stage.setScene(scene);
         stage.show();
     }*/