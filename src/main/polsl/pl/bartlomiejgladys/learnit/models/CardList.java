package polsl.pl.bartlomiejgladys.learnit.models;

import java.util.List;

/**
 * @Author Bartłomiej Gładys
 * @Date 01/11/2018
 * @Version 1.0
 */

public class CardList extends Base<Card> {
    @Override
    public List<Card> getAll() {
        List<Card> cards = super.getAll();
        cards.sort(new SortBySelector());
        return cards;
    }
}
