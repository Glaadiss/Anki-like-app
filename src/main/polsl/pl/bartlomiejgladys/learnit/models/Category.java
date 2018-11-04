package polsl.pl.bartlomiejgladys.learnit.models;

/**
 * @Author Bartłomiej Gładys
 * @Date 01/11/2018
 * @Version 1.0
 */

public class Category {
    private String name;
    private CardList cards = new CardList();

    public String getName() {
        return name;
    }

    public Category setName(String name) throws NameFormatException{
        if(name.length() > 15){
            throw new NameFormatException("Category's name has to be up to 15 characters");
        }
        if(name.length() < 2){
            throw new NameFormatException("Category's name has to have at least 2 characters");
        }
        this.name = name;
        return this;
    }

    public CardList getCards() {
        return cards;
    }
}
