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
 * @Author Bartłomiej Gładys
 * @Date 01/11/2018
 * @Version 1.0
 */

public class CategoryListController extends Controller {
    DynamicView dynamicView;
    @FXML
    private TableView<Category> tableView;
    @FXML
    private TableColumn<Category, String> name;
    @FXML
    private TextField addCategoryInput;
    private ObservableList categoryList;

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

    private void showErrorNameAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Response from Application");
        alert.setHeaderText("Application encountered a problem with category's name");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void handleDynamicData() {
        dynamicView = new DynamicView<Category>(tableView, categoryList, getModel());
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
