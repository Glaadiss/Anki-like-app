package polsl.pl.bartlomiejgladys.learnit.controllers;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import polsl.pl.bartlomiejgladys.learnit.models.Card;
import polsl.pl.bartlomiejgladys.learnit.models.Selector;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

/**
 * Controller for keeping connection with CardList model
 * Keep state of current user's game
 *
 * @author Bartlomiej Gladys
 * @Date 02/11/2018
 * @version 1.0
 */

public class ShowCardController extends Controller {
    /**
     * Iterator for keeping learning steps
     */
    private Iterator<Card> iterator;

    /**
     * Current Card, which iterator point on
     */
    private Card current;

    /**
     * Keeps information about toggleButton state
     */
    private boolean isToggled;

    /**
     * Label indicating question or answer depending from toggleState
     */
    @FXML
    private Label cardText;

    /**
     * Run after fxml file initialization
     *
     * @param location  include path to fxml file
     * @param resources include Resources objects
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            iterator = getModel().getAll().iterator();
            nextCard();
        });
    }

    /**
     * Handle user's click on Toggle button
     *
     * @param actionEvent user's click event
     */
    @FXML
    public void toggle(ActionEvent actionEvent) {
        if (isToggled) {
            cardText.setText(current.getQuestion());
            isToggled = false;
        } else {
            cardText.setText(current.getAnswer());
            isToggled = true;
        }
    }

    /**
     * Point on the next card
     */
    public void nextCard() {
        if (!iterator.hasNext()) {
            moveToCategoryList();
            return;
        }
        isToggled = false;
        current = iterator.next();
        cardText.setText(current.getQuestion());
    }


    /**
     * Handle user's click on "failure button"
     *
     * @param actionEvent user's click event
     */
    public void clickFailure(ActionEvent actionEvent) {
        current.getSelector().update(Selector.AnswerType.FAILURE);
        nextCard();
    }

    /**
     * Handle user's click on "medium button"
     *
     * @param actionEvent user's click event
     */
    public void clickMedium(ActionEvent actionEvent) {
        current.getSelector().update(Selector.AnswerType.MEDIUM);
        nextCard();
    }


    /**
     * Handle user's click on "correct button"
     *
     * @param actionEvent user's click event
     */
    public void clickCorrect(ActionEvent actionEvent) {
        current.getSelector().update(Selector.AnswerType.CORRECT);
        nextCard();
    }
}
