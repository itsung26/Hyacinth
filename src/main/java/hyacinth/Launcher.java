package hyacinth;

import javafx.application.Application;

/**
 * Process entry point. This class must not extend {@link Application};
 * otherwise the JVM requires JavaFX on the module path and IDE Run fails.
 */
public final class Launcher {
    public static void main(String[] args) {
        Application.launch(HyacinthApp.class, args);
    }
}
