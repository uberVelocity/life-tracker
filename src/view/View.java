package view;

import controller.controllers.TitleController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class View {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Stage mainStage;

    private Parent titleScreenParent;

    private Scene titleScene;

    private TitleController titleController;

    public View() {
    }

    public void loadFXMLFiles() throws Exception {
        logger.log(Level.INFO, "LOADING FXML FILES ...");

        mainStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("titlescene.fxml"));
        loader.setController(titleController);
        titleScreenParent = loader.load();
        titleScene = new Scene(titleScreenParent);

        logger.log(Level.INFO, "FXML FILES LOADED ...");

        mainStage.setTitle("Life - by Mihai Popescu");

        logger.log(Level.INFO, "SHOWING PRIMARY STAGE ...");

        mainStage.setScene(titleScene);
        mainStage.show();
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public Scene getTitleScene() {
        return titleScene;
    }

    public Parent getTitleScreenParent() {
        return titleScreenParent;
    }

    public TitleController getTitleController() {
        return titleController;
    }

    public void setTitleController(TitleController titleController) {
        this.titleController = titleController;
    }
}
