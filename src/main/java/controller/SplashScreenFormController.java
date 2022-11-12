package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SplashScreenFormController {
    public Label lblStatus;

    public void initialize() {
        Timeline timeline = new Timeline();
        KeyFrame frameOne = new KeyFrame(Duration.millis(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("INITIALIZING ...");
            }
        });
        KeyFrame frameTwo = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("LOADING PLUGINS ...");
            }
        });
        KeyFrame frameThree = new KeyFrame(Duration.millis(2000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("SETTING UP UI ...");
            }
        });
        KeyFrame frameFour = new KeyFrame(Duration.millis(3500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Parent root = FXMLLoader.load(this.getClass().getResource("/view/TextEditorForm.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setMinWidth(700);
                    stage.setMinHeight(400);
                    stage.setTitle("Simple Text Editor");
                    stage.sizeToScene();
                    stage.centerOnScreen();
                    stage.show();
                    lblStatus.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        timeline.getKeyFrames().addAll(frameOne,frameTwo,frameThree,frameFour);
        timeline.playFromStart();
    }
}
