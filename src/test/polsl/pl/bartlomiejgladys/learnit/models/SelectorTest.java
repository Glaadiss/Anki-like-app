package polsl.pl.bartlomiejgladys.learnit.models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for Selector model
 *
 * @author Bartlomiej Gladys
 * @Date: 04/11/2018
 * @version: 1.0
 */

public class SelectorTest {
    Selector selector;

    @Before
    public void setUp() {
        selector = new Selector();
    }

    @Test
    public void updateSelectorIncrementsCycle() {
        //given
        selector.setCycle(0);

        //when
        selector.update(Selector.AnswerType.MEDIUM);

        //then
        assertThat(selector.getCycle(), is(1));

        //when
        selector.update(Selector.AnswerType.MEDIUM);

        //then
        assertThat(selector.getCycle(), is(2));
    }

    @Test
    public void updateSelectorChangeAnswerType() {
        //given
        selector.setAnswerType(Selector.AnswerType.MEDIUM);

        //when
        selector.update(Selector.AnswerType.CORRECT);

        //then
        assertThat(selector.getAnswerType(), is(Selector.AnswerType.CORRECT));

        //when
        selector.update(Selector.AnswerType.FAILURE);

        //then
        assertThat(selector.getAnswerType(), is(Selector.AnswerType.FAILURE));
    }
}