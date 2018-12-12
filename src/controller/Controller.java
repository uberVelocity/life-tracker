package controller;

import controller.controllers.TitleController;
import model.Model;
import view.View;

import java.util.logging.Logger;

public class Controller {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Model model;
    private View view;

    private TitleController titleController;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        initializeFXMLControllers();
        initializeInterface();
    }

    private void initializeFXMLControllers() {
        titleController = new TitleController(this);

        view.setTitleController(titleController);
    }

    private void initializeInterface() {
        try {
            view.loadFXMLFiles();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TitleController getTitleController() {
        return titleController;
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

}
