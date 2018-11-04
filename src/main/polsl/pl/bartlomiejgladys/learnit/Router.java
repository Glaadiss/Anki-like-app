package polsl.pl.bartlomiejgladys.learnit;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import polsl.pl.bartlomiejgladys.learnit.controllers.Controller;
import polsl.pl.bartlomiejgladys.learnit.models.*;

import java.io.IOException;

/**
 * Router class which handle controller's flow and pass particular models to them
 *
 * @author Bartlomiej Gladys
 * @Date 03/11/2018
 * @version 1.0
 */

public class Router {
    /**
     * First Controller showing CategoryList
     */
    private Controller categoryListView;

    /**
     * Controller for learning state
     */
    private Controller showCardView;

    /**
     * Controller for editing cardLists inside categories
     */
    private Controller editCategoryView;

    /**
     * Main stage
     */
    private Stage window;

    /**
     * Router's Constructor
     *
     * @param primaryStage passed from FX
     * @throws NameFormatException
     */
    public Router(Stage primaryStage) {
        window = primaryStage;
        CategoryList categoryList = new CategoryList();
        categoryListView = getController("CategoryListView", categoryList);
        setScene(categoryListView);
    }

    /**
     * Used to back to main view
     */
    public void moveToCategoryList() {
        setScene(categoryListView);
    }

    /**
     * Set new model for controller based on category
     *
     * @param cardList model passed to controller
     */
    public void moveToShowCard(CardList cardList) {
        showCardView = getController("ShowCardView", cardList);
        setScene(showCardView);
    }

    /**
     * Set new model for controller based on category
     *
     * @param category model passed to controller
     */
    public void moveToEditCategory(Category category) {
        editCategoryView = getController("EditCategoryView", category.getCards());
        editCategoryView.setTitle(category.getName());
        setScene(editCategoryView);
    }

    /**
     * Method for moving within controllers
     *
     * @param controller to active
     */
    private void setScene(Controller controller) {
        window.setScene(controller.getScene());
    }

    /**
     * Get controller based on chosen view
     *
     * @param viewName indicating FXML view
     * @param model    passed to controller
     * @return controller
     */
    private Controller getController(String viewName, Base model) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/" + viewName + ".fxml"));
        Parent view = getView(fxmlLoader);
        Controller controller = fxmlLoader.getController();
        controller.setModel(model);
        controller.setScene(new Scene(view, 600, 400));
        controller.setRouter(this);
        return controller;
    }

    /**
     * get FXML view
     *
     * @param fxmlLoader for fxml loading
     * @return FXML view
     */
    private Parent getView(FXMLLoader fxmlLoader) {
        Parent view;
        try {
            view = fxmlLoader.load();
        } catch (IOException e) {
            return null;
        }
        return view;
    }

}
