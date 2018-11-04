package polsl.pl.bartlomiejgladys.learnit.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import polsl.pl.bartlomiejgladys.learnit.models.Card;
import polsl.pl.bartlomiejgladys.learnit.models.CardList;
import polsl.pl.bartlomiejgladys.learnit.models.Category;
import polsl.pl.bartlomiejgladys.learnit.views.DynamicView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author Bartłomiej Gładys
 * @Date 01/11/2018
 * @Version 1.0
 */

public class EditCategoryController extends Controller {
    @FXML
    private TextArea questionInput;
    @FXML
    private TextArea answerInput;
    @FXML
    private TableView<Card> tableView;
    @FXML
    private TableColumn<Card, String> question;
    @FXML
    private TableColumn<Card, String> answer;
    private ObservableList cardList;
    DynamicView dynamicView;
    @FXML
    private Label categoryName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            tableView.setEditable(true);
            question.setCellValueFactory(new PropertyValueFactory<>("question"));
            answer.setCellValueFactory(new PropertyValueFactory<>("answer"));
            cardList = FXCollections.observableArrayList(getModel().getAll());
            handleDynamicData();
            tableView.setItems(cardList);
        });
    }

    public void setTitle(String name) {
        categoryName.setText(name);
    }


    private void handleDynamicData() {
        dynamicView = new DynamicView<Category>(tableView, cardList, getModel());
        dynamicView.addButtonToTable("delete", data -> {
            Card card = (Card) data;
            getModel().remove(card);
        });
    }

    public void moveToShowCard(ActionEvent actionEvent) {
        moveToShowCard((CardList) getModel());
    }

    @FXML
    public void addCard(ActionEvent actionEvent) {
        String question = questionInput.getText();
        String answer = answerInput.getText();
        Card card = new Card().setAnswer(answer).setQuestion(question);
        getModel().add(card);
        cardList.setAll(getModel().getAll());
        questionInput.setText("");
        answerInput.setText("");
    }
}
