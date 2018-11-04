package polsl.pl.bartlomiejgladys.learnit.models;

import java.util.List;

/**
 * CardList model for keeping sorted state
 *
 * @author Bartlomiej Gladys
 * @Date 01/11/2018
 * @version 1.0
 */

public class CardList extends Base<Card> {
    /**
     * Sort cards and return them
     *
     * @return sorted list of cards
     */
    @Override
    public List<Card> getAll() {
        List<Card> cards = super.getAll();
        cards.sort(new SortBySelector());
        return cards;
    }
}
