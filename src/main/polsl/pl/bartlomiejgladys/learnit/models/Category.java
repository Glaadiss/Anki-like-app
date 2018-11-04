package polsl.pl.bartlomiejgladys.learnit.models;

/**
 * Category model for keeping name and cards
 *
 * @author Bartlomiej Gladys
 * @Date 01/11/2018
 * @version 1.0
 */

public class Category {
    /**
     * Category's name
     */
    private String name;

    /**
     * Category's cards
     */
    private CardList cards = new CardList();

    /**
     * Category's name getter
     *
     * @return category's name
     */
    public String getName() {
        return name;
    }

    /**
     * Category's name setter
     *
     * @param name passed by user
     * @return name if passed correctly
     * @throws NameFormatException if incorrect data
     */
    public Category setName(String name) throws NameFormatException {
        if (name == null) {
            throw new NameFormatException("Category's name can't be blank");
        }
        if (name.length() > 15) {
            throw new NameFormatException("Category's name has to be up to 15 characters");
        }
        if (name.length() < 2) {
            throw new NameFormatException("Category's name has to have at least 2 characters");
        }
        this.name = name;
        return this;
    }

    /**
     * Category's getter
     *
     * @return Category's cards
     */
    public CardList getCards() {
        return cards;
    }
}
