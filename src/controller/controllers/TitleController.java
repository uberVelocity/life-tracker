package controller.controllers;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Entry;

import java.awt.event.ActionEvent;

public class TitleController {

    private Controller controller;

    @FXML
    Button confirmButton;

    @FXML
    TextField usernameField;

    @FXML
    TextField ageField;

    public TitleController(Controller controller) {
        this.controller = controller;
    }

    public void setConfirmButtonAction() {
        confirmButton.setOnAction(e -> {
            if(confirmButton.getId().equals("confirmButton")) {
                String username = usernameField.getText();
                int age = Integer.parseInt(ageField.getText());
                Entry entry = new Entry(Entry.Type.USER);
                entry.setUser(username, age);
                controller.getModel().getDatabase().openDataSource();
                controller.getModel().getDatabase().addEntry(entry);
                controller.getModel().getDatabase().closeDataSource();
            }
        });
    }

    public Controller getController() {
        return controller;
    }
}
