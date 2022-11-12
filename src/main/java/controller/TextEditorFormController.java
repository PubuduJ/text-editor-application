package controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class TextEditorFormController {

    public AnchorPane pneContainer;
    public JFXTextArea txtEditor;
    public MenuItem mnuNew;
    public MenuItem mnuOpen;
    public MenuItem mnuSave;
    public MenuItem mnuPrint;
    public MenuItem mnuClose;
    public MenuItem mnuCut;
    public MenuItem mnuCopy;
    public MenuItem mnuPaste;
    public MenuItem mnuSelectAll;
    public MenuItem mnuAbout;

    public void initialize() {

    }

    public void mnuNew_OnAction(ActionEvent actionEvent) {

    }

    public void mnuOpen_OnAction(ActionEvent actionEvent) {

    }

    public void mnuSave_OnAction(ActionEvent actionEvent) {

    }

    public void mnuPrint_OnAction(ActionEvent actionEvent) {

    }

    public void mnuClose_OnAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void mnuCut_OnAction(ActionEvent actionEvent) {

    }

    public void mnuCopy_OnAction(ActionEvent actionEvent) {

    }

    public void mnuPaste_OnAction(ActionEvent actionEvent) {

    }

    public void mnuSelectAll_OnAction(ActionEvent actionEvent) {

    }

    public void mnuAbout_OnAction(ActionEvent actionEvent) {

    }
}
