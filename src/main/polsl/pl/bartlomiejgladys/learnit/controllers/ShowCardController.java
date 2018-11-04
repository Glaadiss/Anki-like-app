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
 * @Author Bartłomiej Gładys
 * @Date 02/11/2018
 * @Version 1.0
 */

public class ShowCardController extends Controller {
    private Iterator<Card> iterator;
    private Card current;
    private boolean isToggled;

    @FXML
    private Label cardText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            iterator = getModel().getAll().iterator();
            nextCard();
        });
    }

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


    public void nextCard() {
        if (!iterator.hasNext()) {
            moveToCategoryList();
            return;
        }
        isToggled = false;
        current = iterator.next();
        cardText.setText(current.getQuestion());
    }


    public void clickFailure(ActionEvent actionEvent) {
        current.getSelector().updateSelector(Selector.AnswerType.FAILURE);
        nextCard();
    }

    public void clickMedium(ActionEvent actionEvent) {
        current.getSelector().updateSelector(Selector.AnswerType.MEDIUM);
        nextCard();
    }

    public void clickCorrect(ActionEvent actionEvent) {
        current.getSelector().updateSelector(Selector.AnswerType.CORRECT);
        nextCard();
    }
}
