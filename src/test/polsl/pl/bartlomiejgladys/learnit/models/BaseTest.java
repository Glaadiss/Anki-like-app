package polsl.pl.bartlomiejgladys.learnit.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for base model
 *
 * @author Bartlomiej Gladys
 * @Date 04/11/2018
 * @version 1.0
 */

public class BaseTest {
    Base<Integer> intWrapper;

    @Before
    public void setUp() {
        intWrapper = new Base<>();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllShouldReturnListOfObjects() {
        //given
        intWrapper.add(1);
        intWrapper.add(2);
        List<Integer> result;

        //when
        result = intWrapper.getAll();

        //then
        assertThat(result, is(Arrays.asList(1, 2)));
    }

    @Test
    public void remove() {
        //given
        Integer a = 1;
        Integer b = 1;
        intWrapper.add(a);
        intWrapper.add(b);

        //when
        intWrapper.remove(a);

        //then
        assertThat(intWrapper.getAll(), is(Arrays.asList(b)));
    }

    @Test
    public void add() {
        //given
        Integer a = 1;

        //when
        intWrapper.add(a);

        //then
        assertThat(intWrapper.getAll(), is(Arrays.asList(a)));
    }
}