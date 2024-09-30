package projeto.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {
    private static Stage stage;

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Principal.fxml"));
        Scene scense = new Scene(root);
        stage.setTitle("Inicio");
        stage.setScene(scense);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();
        setStage(stage);

    }

    @SuppressWarnings("exports")
    public static Stage getStage() {
        return stage;

    }

    public static void setStage(@SuppressWarnings("exports") Stage stage) {
        Principal.stage = stage;

    }

}