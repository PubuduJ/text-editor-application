package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

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

    public void btnOK_OnAction(ActionEvent actionEvent) throws IOException {
        if (txtFileName.getText().isBlank()) {
            new Alert(Alert.AlertType.ERROR,"File name cannot be empty!").showAndWait();
            txtFileName.selectAll();
            txtFileName.requestFocus();
            txtFilePath.clear();
            return;
        }
        else if (!txtFileName.getText().matches("^[A-Za-z0-9][A-Za-z0-9 -]+$")) {
            new Alert(Alert.AlertType.ERROR,"Invalid file name format!").showAndWait();
            txtFileName.selectAll();
            txtFileName.requestFocus();
            txtFilePath.clear();
            return;
        }
        else if (cmbFormat.getSelectionModel().getSelectedItem() == null) {
            new Alert(Alert.AlertType.ERROR,"Please select a file extension").showAndWait();
            cmbFormat.requestFocus();
            return;
        }
        else if (txtFilePath.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Save location path is empty").showAndWait();
            btnBrowsePath.requestFocus();
            return;
        }
        else if (!txtFilePath.getText().contains(cmbFormat.getSelectionModel().getSelectedItem())) {
            new Alert(Alert.AlertType.ERROR,"File path extension is not match with the given file extension").showAndWait();
            cmbFormat.requestFocus();
            return;
        }
        else if (!txtFilePath.getText().substring(txtFilePath.getText().lastIndexOf("/")+1,txtFilePath.getText().lastIndexOf(".")).equals(txtFileName.getText())) {
            new Alert(Alert.AlertType.ERROR,"File path file name is not match with the given file name").showAndWait();
            txtFileName.requestFocus();
            System.out.println(txtFileName.getText());
            System.out.println(txtFilePath.getText().substring(txtFilePath.getText().lastIndexOf("/")+1,txtFilePath.getText().lastIndexOf(".")));
            return;
        }
        pneSaveForm.getScene().getWindow().hide();
        file.createNewFile();
        if (cmbFormat.getSelectionModel().getSelectedItem().equals(".txt")) {
            byte[] bytes = content.getBytes();
            FileOutputStream fos = new FileOutputStream(file);
            for (byte aByte : bytes) {
                fos.write(aByte);
            }
        }
        else if (cmbFormat.getSelectionModel().getSelectedItem().equals(".encrypted")) {
            byte[] bytes = content.getBytes();
            FileOutputStream fos = new FileOutputStream(file);
            for (byte aByte : bytes) {
                fos.write(aByte + 1);
            }
        }
        new Alert(Alert.AlertType.INFORMATION,"Files has been saved successfully").showAndWait();
    }

    public void btnBrowsePath_OnAction(ActionEvent actionEvent) {
        if (txtFileName.getText().isBlank()) {
            new Alert(Alert.AlertType.ERROR,"File name cannot be empty!").showAndWait();
            txtFileName.selectAll();
            txtFileName.requestFocus();
            txtFilePath.clear();
            return;
        }
        else if (!txtFileName.getText().matches("^[A-Za-z0-9][A-Za-z0-9 -]+$")) {
            new Alert(Alert.AlertType.ERROR,"Invalid file name format!").showAndWait();
            txtFileName.selectAll();
            txtFileName.requestFocus();
            txtFilePath.clear();
            return;
        }
        else if (cmbFormat.getSelectionModel().getSelectedItem() == null) {
            new Alert(Alert.AlertType.ERROR,"Please select a file extension").showAndWait();
            cmbFormat.requestFocus();
            return;
        }
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        directoryChooser.setTitle("Select a directory to save");
        File directory = directoryChooser.showDialog(pneSaveForm.getScene().getWindow());
        if (directory != null) {
            file = new File(directory.getAbsolutePath(), txtFileName.getText() + cmbFormat.getSelectionModel().getSelectedItem());
            if (file.exists()) {
                Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION,
                        file.getName()+ " file is already exists. Do you want to overwrite?",
                        ButtonType.YES, ButtonType.NO).showAndWait();
                if (result.get() == ButtonType.NO) {
                    return;
                }
            }
            txtFilePath.setText(file.getAbsolutePath());
        }
    }
}
