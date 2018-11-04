package polsl.pl.bartlomiejgladys.learnit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import polsl.pl.bartlomiejgladys.learnit.Router;
import polsl.pl.bartlomiejgladys.learnit.models.Base;
import polsl.pl.bartlomiejgladys.learnit.models.CardList;
import polsl.pl.bartlomiejgladys.learnit.models.Category;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Base class for all controllers
 *
 * @author Bartlomiej Gladys
 * @Date 03/11/2018
 * @version 1.0
 */

public class Controller implements Initializable {
    /**
     * FX scene field
     */
    private Scene scene;

    /**
     * Router for model's data passing and view's changing.
     */
    private Router router;

    /**
     * Base model's field
     */
    private Base model;

    /**
     * Move to ShowCardView and turn on ShowCard controller
     *
     * @param cardList model passed from higher Controller
     */
    public void moveToShowCard(CardList cardList) {
        router.moveToShowCard(cardList);
    }

    /**
     * Move to EditCategoryVIew and turn on EditCategory controller
     *
     * @param category model passed from higher Controller
     */
    public void moveToEditCategory(Category category) {
        router.moveToEditCategory(category);
    }

    /**
     * Basic getter for base model
     *
     * @return base model.
     */
    public Base getModel() {
        return model;
    }

    /**
     * Setter for model
     *
     * @param newModel to set.
     */
    public void setModel(Base newModel) {
        model = newModel;
    }

    /**
     * Move to categoryListView from FX
     *
     * @param event passed with user's click
     */
    @FXML
    public void moveToCategoryList(ActionEvent event) {
        router.moveToCategoryList();
    }

    /**
     * Move to categoryListView from FX
     */
    public void moveToCategoryList() {
        router.moveToCategoryList();
    }

    /**
     * Scene getter
     *
     * @return FX Scene object
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Check if scene exists, if not -> assign newScene to field.
     *
     * @param newScene to assign
     * @return Controller object
     */
    public Controller setScene(Scene newScene) {
        if (scene == null) {
            scene = newScene;
        }
        return this;
    }

    /**
     * Router setter
     *
     * @param newRouter to set.
     */
    public void setRouter(Router newRouter) {
        router = newRouter;
    }

    /**
     * Run after fxml file initialization
     *
     * @param location  include path to fxml file
     * @param resources include Resources objects
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Blank method to override
     *
     * @param name to set.
     */
    public void setTitle(String name) {
    }
}