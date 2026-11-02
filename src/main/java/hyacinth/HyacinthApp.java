package hyacinth;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HyacinthApp extends Application {
    private final String ANSI_WIPESCREEN = "\033[2J\033[H";

    @Override
    public void init() {
        System.out.println(ANSI_WIPESCREEN);
        System.out.println("Hello from initializer.");
    }

    @Override
    public void start(Stage stage) {
        buildUi(stage, "Hyacinth", 1280, 720);
        stage.show();

        System.out.println("Hello world!");
    }

    @Override
    public void stop() {
        System.out.println("Goodbye world!");
    }

    /**
     * Constructs the UI. Does not show the stage.
     * @param stage
     */
    public void buildUi(Stage stage, String windowTitle, int width, int height) {
        ImageView imageView = new ImageView();
        StackPane viewport = new StackPane(imageView);
        BorderPane root = new BorderPane(viewport);

        stage.setTitle(windowTitle);
        stage.setScene(new Scene(root, width, height));
    } 
}
