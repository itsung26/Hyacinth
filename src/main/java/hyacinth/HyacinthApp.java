package hyacinth;

import com.jayfella.jfx.embedded.SimpleJfxApplication;
import com.jme3.app.FlyCamAppState;
import com.jme3.app.StatsAppState;
import com.jme3.audio.AudioListenerState;
import com.jme3.system.AppSettings;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HyacinthApp extends Application {
    private final String ANSI_WIPESCREEN = "\033[2J\033[H";
    private volatile SimpleJfxApplication jmeApp;

    @Override
    public void init() {
        System.out.println(ANSI_WIPESCREEN);
        System.out.println("Hello from initializer.");
    }

    @Override
    public void start(Stage stage) throws Exception {
        new Thread(new ThreadGroup("LWJGL"), () -> {
            SimpleJfxApplication renderer = new JmeRenderer(
                    new StatsAppState(),
                    new AudioListenerState(),
                    new FlyCamAppState()
            );

            AppSettings appSettings = renderer.getSettings();
            appSettings.setUseJoysticks(false);
            appSettings.setGammaCorrection(true);
            appSettings.setSamples(16);

            jmeApp = renderer;
            renderer.start();
        }, "LWJGL Render").start();

        while (jmeApp == null || !jmeApp.isInitialized()) {
            Thread.sleep(10);
        }

        buildUi(stage, "Hyacinth", 1280, 720, jmeApp.getImageView());
        stage.show();

        System.out.println(ANSI_WIPESCREEN);
        System.out.println("Hello world!");
    }

    @Override
    public void stop() {
        if (jmeApp != null) {
            jmeApp.stop();
        }
        System.out.println("Goodbye world!");
    }

    /**
     * Constructs the UI. Does not show the stage.
     */
    public void buildUi(Stage stage, String windowTitle, int width, int height, ImageView imageView) {
        StackPane viewport = new StackPane(imageView);
        BorderPane root = new BorderPane(viewport);

        stage.setTitle(windowTitle);
        stage.setScene(new Scene(root, width, height));
    }
}
