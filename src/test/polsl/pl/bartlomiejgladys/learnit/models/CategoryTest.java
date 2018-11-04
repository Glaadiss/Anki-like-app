package polsl.pl.bartlomiejgladys.learnit.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for Category model
 *
 * @author Bartlomiej Gladys
 * @Date: 04/11/2018
 * @version: 1.0
 */

public class CategoryTest {
    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test(expected = NameFormatException.class)
    public void setNameWithLessThanTwoChars() throws NameFormatException {
        category.setName("a");
    }

    @Test(expected = NameFormatException.class)
    public void setNameWithNull() throws NameFormatException {
        category.setName(null);
    }

    @Test(expected = NameFormatException.class)
    public void setNameWithMoreThanFifteenChars() throws NameFormatException {
        category.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test
    public void setNameBetweenTwoAndFourteenChars() throws NameFormatException {
        //given
        String expectedName = "Good name";
        String expectedName2 = "Go";
        String expectedName3 = "Good name  14";

        //when
        category.setName(expectedName);
        //then
        assertEquals(expectedName, category.getName());

        category.setName(expectedName2);
        //then
        assertEquals(expectedName2, category.getName());

        category.setName(expectedName3);
        //then
        assertEquals(expectedName3, category.getName());
    }

}