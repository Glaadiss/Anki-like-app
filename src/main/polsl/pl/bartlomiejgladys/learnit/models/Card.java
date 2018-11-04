package polsl.pl.bartlomiejgladys.learnit.models;

/**
 * @Author Bartłomiej Gładys
 * @Date 01/11/2018
 * @Version 1.0
 */

public class Card {
    private String question;
    private String answer;
    private Selector selector = new Selector();

    public String getQuestion() {
        return question;
    }

    public Card setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Card setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public Selector getSelector() {
        return selector;
    }
}
