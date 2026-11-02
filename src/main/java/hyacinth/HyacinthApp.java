package hyacinth;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HyacinthApp extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Hyacinth");
        stage.setScene(new Scene(new BorderPane(), 1280, 720));
        stage.show();
    }
}
