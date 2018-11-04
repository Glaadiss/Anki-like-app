package polsl.pl.bartlomiejgladys.learnit.models;

/**
 * @Author Bartłomiej Gładys
 * @Date 01/11/2018
 * @Version 1.0
 */

public class CategoryList extends Base<Category> {
    public CategoryList() throws NameFormatException {
        Card card1 = new Card().setQuestion("Is z80 a proccessor?").setAnswer("Yes");
        Card card2 = new Card().setQuestion("2 + 2?").setAnswer("4");
        Card card3 = new Card().setQuestion("shouldFirst?").setAnswer("4");
        Card card4 = new Card().setQuestion("second").setAnswer("4");
        Card card5 = new Card().setQuestion("shoud be last").setAnswer("4");

        card5.getSelector().setAnswerType(Selector.AnswerType.CORRECT);
        card3.getSelector().setAnswerType(Selector.AnswerType.FAILURE);

        Category category1 = new Category().setName("SMIW");
        category1.getCards().add(card1);
        category1.getCards().add(card2);
        category1.getCards().add(card3);
        category1.getCards().add(card4);
        category1.getCards().add(card5);

        Category category2 = new Category().setName("JA");
        add(category1);
        add(category2);
    }
}
