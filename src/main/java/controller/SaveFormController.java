package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.File;

public class SaveFormController {

    public AnchorPane pneSaveForm;
    public ComboBox<String> cmbFormat;
    public JFXTextField txtFileName;
    public JFXTextField txtFilePath;
    public JFXButton btnOK;
    public JFXButton btnBrowsePath;
    private String content;

    private File file;

    public void initialize() {
        FadeTransition fd = new FadeTransition(Duration.millis(1500),pneSaveForm);
        fd.setFromValue(0);
        fd.setToValue(1);
        fd.playFromStart();

        ObservableList<String> items = cmbFormat.getItems();
        items.add(".txt");
        items.add(".encrypted");
    }

    public void setData(String editorContent) {
        content = editorContent;
    }

    public void btnOK_OnAction(ActionEvent actionEvent) {
        if (cmbFormat.getSelectionModel().getSelectedItem() == null) {
            System.out.println("null");
        }
        else if (cmbFormat.getSelectionModel().getSelectedItem().equals(".encrypted")) {
            System.out.println("encrypted");
        }
        else if (cmbFormat.getSelectionModel().getSelectedItem().equals(".txt")) {
            System.out.println("text");
        }
    }

    public void btnBrowsePath_OnAction(ActionEvent actionEvent) {
    }
}
