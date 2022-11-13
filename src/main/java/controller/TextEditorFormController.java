package controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.IndexRange;
import javafx.scene.control.MenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

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
        FadeTransition fd = new FadeTransition(Duration.millis(1500),pneContainer);
        fd.setFromValue(0);
        fd.setToValue(1);
        fd.playFromStart();
    }

    public void mnuNew_OnAction(ActionEvent actionEvent) {
        txtEditor.setText("");
    }

    public void mnuOpen_OnAction(ActionEvent actionEvent) {

    }

    public void mnuSave_OnAction(ActionEvent actionEvent) {

    }

    public void mnuPrint_OnAction(ActionEvent actionEvent) {
        if (Printer.getDefaultPrinter() == null) {
            new Alert(Alert.AlertType.ERROR,"No default printer has been selected").showAndWait();
            return;
        }
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null) {
            printerJob.showPageSetupDialog(pneContainer.getScene().getWindow());
            boolean success = printerJob.printPage(txtEditor);
            if (success) {
                printerJob.endJob();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Failed to print, try again").showAndWait();
            }
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Failed to initialize a new printer job").show();
        }
    }

    public void mnuClose_OnAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void mnuCut_OnAction(ActionEvent actionEvent) {
        if (txtEditor.getSelectedText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"First select a text to cut!").showAndWait();
            txtEditor.requestFocus();
            return;
        }
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        String segment = txtEditor.getSelectedText();
        content.putString(segment);
        clipboard.setContent(content);

        IndexRange range = txtEditor.getSelection();
        String originalText = txtEditor.getText();
        String firstPart = originalText.substring(0,range.getStart());
        String lastPart = originalText.substring(range.getEnd());
        txtEditor.setText(firstPart+lastPart);
    }

    public void mnuCopy_OnAction(ActionEvent actionEvent) {
        if (txtEditor.getSelectedText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"First select a text to copy!").showAndWait();
            txtEditor.requestFocus();
            return;
        }

        Clipboard clipboard = Clipboard.getSystemClipboard();
        String text = txtEditor.getSelectedText();
        ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
    }

    public void mnuPaste_OnAction(ActionEvent actionEvent) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        if (!clipboard.hasContent(DataFormat.PLAIN_TEXT) || clipboard.getString().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"First copy a text to clipboard to paste!").showAndWait();
            return;
        }
        if (txtEditor.getSelectedText().length() < 1) {
            new Alert(Alert.AlertType.INFORMATION,"Please select a text area to paste!").showAndWait();
            txtEditor.requestFocus();
            return;
        }
        String addText = clipboard.getString();
        IndexRange range = txtEditor.getSelection();
        String originalText = txtEditor.getText();
        String firstPart = originalText.substring(0,range.getStart());
        String lastPart = originalText.substring(range.getEnd(),originalText.length());
        txtEditor.setText(firstPart + addText + lastPart);
    }

    public void mnuSelectAll_OnAction(ActionEvent actionEvent) {

    }

    public void mnuAbout_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/AboutForm.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("About");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
