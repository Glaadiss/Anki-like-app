package polsl.pl.bartlomiejgladys.learnit.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @Author Bartłomiej Gładys
 * @Date: 04/11/2018
 * @Version: 1.0
 */

public class SortBySelectorTest {
    Card card1;
    Card card2;
    Selector first;
    Selector second;
    SortBySelector comparator;

    @Before
    public void setUp(){
        card1 = new Card();
        card2 = new Card();
        first = card1.getSelector();
        second = card2.getSelector();
        comparator = new SortBySelector();
    }

    @Test
    public void compareReturnNegativeIfFirstHasWeakerAnswer() {
        //given
        first.setAnswerType(Selector.AnswerType.FAILURE);
        second.setAnswerType(Selector.AnswerType.MEDIUM);

        //when
        int result = comparator.compare(card1, card2);

        //then
        assertThat(result, is(-1));
    }

    @Test
    public void compareReturnPositiveIfFirstHasStrongerAnswer() {
        //given
        first.setAnswerType(Selector.AnswerType.CORRECT);
        second.setAnswerType(Selector.AnswerType.MEDIUM);

        //when
        int result = comparator.compare(card1, card2);

        //then
        assertThat(result, is(1));
    }

    @Test
    public void compareReturnNegativeIfFirstHasMoreCycles() {
        //given
        setTheSameAnswerTypes();
        first.setCycle(5);
        second.setCycle(3);

        //when
        int result = comparator.compare(card1, card2);

        //then
        assertTrue(result < 0);
    }

    @Test
    public void compareReturnPositiveIfFirstHasLessCycles() {
        //given
        setTheSameAnswerTypes();
        first.setCycle(1);
        second.setCycle(3);

        //when
        int result = comparator.compare(card1, card2);

        //then
        assertTrue(result > 0);
    }

    @Test
    public void compareReturnNegativeIfFirstWasUpdatedEarlier() {
        //given
        setTheSameAnswerTypes();
        setTheSameCycles();
        first.setUpdatedAt(getTime(2018, 5, 3));
        second.setUpdatedAt(getTime(2018, 5, 4));

        //when
        int result = comparator.compare(card1, card2);

        //then
        assertThat(result, is(-1));
    }

    @Test
    public void compareReturnPositiveIfFirstWasUpdatedLater() {
        //given
        setTheSameAnswerTypes();
        setTheSameCycles();
        first.setUpdatedAt(getTime(2018, 5, 10));
        second.setUpdatedAt(getTime(2018, 5, 4));

        //when
        int result = comparator.compare(card1, card2);

        //then
        assertThat(result, is(1));
    }

    @Test
    public void compareReturnZeroIfDatesAreTheSame() {
        //given
        setTheSameAnswerTypes();
        setTheSameCycles();
        setTheSameDates();

        //when
        int result = comparator.compare(card1, card2);

        //then
        assertThat(result, is(0));
    }


    private Date getTime(int y, int m, int d) {
        Calendar c = Calendar.getInstance();
        c.set(y, m, d);
        return c.getTime();
    }

    private void setTheSameAnswerTypes() {
        first.setAnswerType(Selector.AnswerType.MEDIUM);
        second.setAnswerType(Selector.AnswerType.MEDIUM);
    }

    private void setTheSameDates() {
        Date date = getTime(2018, 5, 4);
        first.setUpdatedAt(date);
        second.setUpdatedAt(date);
    }

    private void setTheSameCycles() {
        first.setCycle(1);
        second.setCycle(1);
    }


}
