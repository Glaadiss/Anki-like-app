package polsl.pl.bartlomiejgladys.learnit.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import polsl.pl.bartlomiejgladys.learnit.models.Category;
import polsl.pl.bartlomiejgladys.learnit.models.NameFormatException;
import polsl.pl.bartlomiejgladys.learnit.views.DynamicView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for keeping connection with CategoryList model and first user's view.
 *
 * @author Bartlomiej Gladys
 * @Date 01/11/2018
 * @version 1.0
 */

public class CategoryListController extends Controller {
    /**
     * Simplify dynamic buttons creation in table.
     */
    DynamicView dynamicView;

    /**
     * Table for keeping list of categories.
     */
    @FXML
    private TableView<Category> tableView;

    /**
     * Column for category name.
     */
    @FXML
    private TableColumn<Category, String> name;

    /**
     * TextField for new category name.
     */
    @FXML
    private TextField addCategoryInput;

    /**
     * Observable list for table's view refreshing.
     */
    private ObservableList categoryList;

    /**
     * Run after fxml file initialization.
     *
     * @param location  include path to fxml file
     * @param resources include Resources objects
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            tableView.setEditable(true);
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            categoryList = FXCollections.observableArrayList(getModel().getAll());
            handleDynamicData();
            tableView.setItems(categoryList);
        });
    }

    /**
     * Handle addCategory user's action.
     *
     * @param actionEvent event passed with user's click
     */
    @FXML
    private void addCategory(ActionEvent actionEvent) {
        String name = addCategoryInput.getText();
        try {
            getModel().add(new Category().setName(name));
        } catch (NameFormatException e) {
            showErrorNameAlert(e.getMessage());
            return;
        }
        categoryList.setAll(getModel().getAll());
        addCategoryInput.setText("");
    }

    /**
     * Show alert on client side informing about bad input data.
     *
     * @param message from NameFormatException
     */
    private void showErrorNameAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Response from Application");
        alert.setHeaderText("Application encountered a problem with category's name");
        alert.setContentText(message);
        alert.showAndWait();
    }


    /**
     * Handle user's click action on dynamic added buttons
     */
    private void handleDynamicData() {

        dynamicView = new DynamicView<Category>().setTableView(tableView).setObservableList(categoryList).setBase(getModel());

        dynamicView.addButtonToTable("GO", data -> {
            Category category = (Category) data;
            moveToShowCard(category.getCards());
        });
        dynamicView.addButtonToTable("modify", data -> {
            Category category = (Category) data;
            moveToEditCategory(category);
        });
        dynamicView.addButtonToTable("delete", data -> {
            Category category = (Category) data;
            getModel().remove(category);
        });
    }

}
