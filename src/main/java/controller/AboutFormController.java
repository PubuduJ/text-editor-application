package controller;

import javafx.animation.FadeTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class AboutFormController {
    public AnchorPane pneAboutForm;

    public void initialize() {
        FadeTransition fd = new FadeTransition(Duration.millis(1500),pneAboutForm);
        fd.setFromValue(0);
        fd.setToValue(1);
        fd.playFromStart();
    }
}
