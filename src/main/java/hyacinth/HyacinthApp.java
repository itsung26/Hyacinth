package hyacinth;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HyacinthApp extends Application {
    private final String ANSI_WIPESCREEN = "\033[2J\033[H";

    @Override
    public void init() {
        System.out.println(ANSI_WIPESCREEN);
        System.out.println("Hello from initializer.");
        Parameters params = getParameters();
        System.out.println(params.getNamed());
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hyacinth");
        stage.setScene(new Scene(new BorderPane(), 1280, 720));
        stage.show();

        System.out.println("Hello world!");
    }

    @Override
    public void stop() {
        System.out.println("Goodbye world!");
    }
}
