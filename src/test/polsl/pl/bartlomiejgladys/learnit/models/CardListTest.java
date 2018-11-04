package polsl.pl.bartlomiejgladys.learnit.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for CardList model
 *
 * @author Bartlomiej Gladys
 * @Date: 04/11/2018
 * @version: 1.0
 */

public class CardListTest {
    CardList cardList;
    List<Card> cards;
    List<Selector> selectors;

    @Before
    public void setUp() {
        cardList = new CardList();
        cards = cardList.getAll();
        selectors = new ArrayList<>();
        IntStream.range(0, 3).forEach(i -> cards.add(new Card()));
        cardList.getAll().forEach(card -> selectors.add(card.getSelector()));
    }

    @Test
    public void getAllReturnCardsSortedByAnswerType() {
        //given
        selectors.get(0).setAnswerType(Selector.AnswerType.MEDIUM);
        selectors.get(1).setAnswerType(Selector.AnswerType.CORRECT);
        selectors.get(2).setAnswerType(Selector.AnswerType.FAILURE);
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        Card card3 = cards.get(2);

        //when
        List<Card> result = cardList.getAll();

        //then
        assertThat(result, is(Arrays.asList(card3, card1, card2)));
    }

    @Test
    public void getAllReturnCardsSortedByCycle() {
        //given
        selectors.get(0).setCycle(2);
        selectors.get(1).setCycle(4);
        selectors.get(2).setCycle(1);
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        Card card3 = cards.get(2);

        //when
        List<Card> result = cardList.getAll();

        //then
        assertThat(result, is(Arrays.asList(card3, card1, card2)));
    }

    @Test
    public void getAllReturnCardsSortedByDate() {
        //given
        selectors.get(0).setUpdatedAt(getTime(100000));
        selectors.get(1).setUpdatedAt(getTime(1000));
        selectors.get(2).setUpdatedAt(getTime(10));
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        Card card3 = cards.get(2);

        //when
        List<Card> result = cardList.getAll();

        //then
        assertThat(result, is(Arrays.asList(card3, card2, card1)));
    }

    private Date getTime(int time) {
        Date date = new Date();
        date.setTime(time);
        return date;
    }
}