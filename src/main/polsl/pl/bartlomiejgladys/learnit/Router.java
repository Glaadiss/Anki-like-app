package polsl.pl.bartlomiejgladys.learnit;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import polsl.pl.bartlomiejgladys.learnit.controllers.Controller;
import polsl.pl.bartlomiejgladys.learnit.models.*;

import java.io.IOException;

/**
 * @Author Bartłomiej Gładys
 * @Date 03/11/2018
 * @Version 1.0
 */

public class Router {
    private Controller categoryListView;
    private Controller showCardView;
    private Controller editCategoryView;
    private Stage window;

    public Router(Stage primaryStage) throws IOException, NameFormatException {
        window = primaryStage;
        CategoryList categoryList = new CategoryList();
        categoryListView = getView("CategoryListView", categoryList);

        setScene(categoryListView);
    }

    public void moveToCategoryList() {
        setScene(categoryListView);
    }

    public void moveToShowCard(CardList cardList) {
        showCardView = getView("ShowCardView", cardList);
        setScene(showCardView);
    }

    public void moveToEditCategory(Category category) {
        editCategoryView = getView("EditCategoryView", category.getCards());
        editCategoryView.setTitle(category.getName());
        setScene(editCategoryView);
    }

    private void setScene(Controller controller) {
        window.setScene(controller.getScene());
    }

    Controller getView(String viewName, Base model) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/" + viewName + ".fxml"));
        Parent view;
        try {
            view = fxmlLoader.load();
        } catch (IOException e) {
            return null;
        }
        Controller controller = fxmlLoader.getController();
        controller.setModel(model);
        controller.setScene(new Scene(view, 600, 400));
        controller.setRouter(this);
        return controller;
    }


}
