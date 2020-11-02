package datn.app;

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
    private static Stage beforeStage;

    @Override
    public void start(Stage stage) throws IOException {
        beforeStage = stage;
        scene = new Scene(loadFXML("layout/login"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Đăng nhập hệ thống");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void loadStage(String fxml) throws IOException {
        setRoot(fxml);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Hệ thống quản lý sinh viên");
        stage.show();
        beforeStage.close();
        beforeStage = stage;
    }

    public static void main(String[] args) {
        launch();
    }
}