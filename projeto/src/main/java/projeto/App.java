package projeto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scense = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scense);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();

    }

}
