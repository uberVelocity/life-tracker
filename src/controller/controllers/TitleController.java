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
    private Button confirmButton;

    @FXML
    private Button dropButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField ageField;

    public TitleController(Controller controller) {
        this.controller = controller;
    }

    public void setConfirmButtonActions() {
        confirmButton.setOnAction(e -> {
            if(confirmButton.getId().equals("confirmButton")) {
                String username = usernameField.getText();
                int age = Integer.parseInt(ageField.getText());
                controller.getModel().getUser().setUsername(username);
                controller.getModel().getUser().setAge(age);
                controller.getModel().getDatabase().openDataSource();
                controller.getModel().getDatabase().addEntry(controller.getModel().getUser());
                controller.getModel().getDatabase().closeDataSource();
            }
        });

        dropButton.setOnAction(e -> {
            try {
                if(dropButton.getId().equals("dropButton")) {
                    controller.getModel().getDatabase().openDataSource();
                    controller.getModel().getDatabase().dropTables();
                    controller.getModel().getDatabase().closeDataSource();
                }
            }
            catch (Exception exc) {
                exc.printStackTrace();
            }

        });
    }

    public Controller getController() {
        return controller;
    }
}
