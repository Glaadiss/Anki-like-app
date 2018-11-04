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
 * @Author Bartłomiej Gładys
 * @Date 03/11/2018
 * @Version 1.0
 */

public class Controller implements Initializable {
    private Scene scene;
    private Router router;
    private Base model;

    public void moveToShowCard(CardList cardList) {
        router.moveToShowCard(cardList);
    }

    public void moveToEditCategory(Category category) {
        router.moveToEditCategory(category);
    }

    public Base getModel() {
        return model;
    }

    public void setModel(Base newModel) {
        model = newModel;
    }

    @FXML
    public void moveToCategoryList(ActionEvent event) {
        router.moveToCategoryList();
    }

    public void moveToCategoryList() {
        router.moveToCategoryList();
    }

    public Scene getScene() {
        return scene;
    }

    public Controller setScene(Scene newScene) {
        if (scene == null) {
            scene = newScene;
        }
        return this;
    }

    public void setRouter(Router newRouter) {
        router = newRouter;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setTitle(String name) {
    }
}