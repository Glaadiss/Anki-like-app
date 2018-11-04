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
import polsl.pl.bartlomiejgladys.learnit.views.DynamicView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for keeping connection with CardList model
 *
 * @author Bartlomiej Gladys
 * @Date 01/11/2018
 * @version 1.0
 */

public class EditCategoryController extends Controller {
    /**
     * Simplify dynamic buttons creation in table.
     */
    DynamicView dynamicView;

    /**
     * Text area for question input
     */
    @FXML
    private TextArea questionInput;

    /**
     * Text area for answer input
     */
    @FXML
    private TextArea answerInput;

    /**
     * Table for list of cards
     */
    @FXML
    private TableView<Card> tableView;

    /**
     * Column for cards's questions
     */
    @FXML
    private TableColumn<Card, String> question;

    /**
     * Column for cards's answers
     */
    @FXML
    private TableColumn<Card, String> answer;

    /**
     * Observable list for refreshing data in table
     */
    private ObservableList cardList;

    /**
     * Header of EditCategoryView with current category name
     */
    @FXML
    private Label categoryName;

    /**
     * Run after fxml file initialization
     *
     * @param location  include path to fxml file
     * @param resources include Resources objects
     */
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

    /**
     * Setter for title in FX.
     *
     * @param name to set.
     */
    public void setTitle(String name) {
        categoryName.setText(name);
    }

    /**
     * Handle user's actions on dynamic created buttons.
     */
    private void handleDynamicData() {
        dynamicView = new DynamicView<Card>().setTableView(tableView).setObservableList(cardList).setBase(getModel());
        dynamicView.addButtonToTable("delete", data -> {
            Card card = (Card) data;
            getModel().remove(card);
        });
    }

    /**
     * Move to ShowCardView and change controller.
     *
     * @param actionEvent user's click event
     */
    public void moveToShowCard(ActionEvent actionEvent) {
        moveToShowCard((CardList) getModel());
    }

    /**
     * Handle user's click on ADD button.
     *
     * @param actionEvent user's click event
     */
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
