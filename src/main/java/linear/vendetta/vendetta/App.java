package linear.vendetta.vendetta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        // Load the main interface
        FXMLLoader loader = new FXMLLoader(
                App.class.getResource("primary.fxml")
        );

        Parent root = loader.load();

        // Create the scene
        Scene scene = new Scene(root);

        // Configure the main window
        stage.setTitle("Vendetta - Linear Algebra Workbench");
        stage.setScene(scene);
        stage.setMinWidth(900);
        stage.setMinHeight(600);

        // Display the application
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
} 