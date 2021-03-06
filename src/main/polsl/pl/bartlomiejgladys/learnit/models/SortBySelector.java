package polsl.pl.bartlomiejgladys.learnit.models;

import polsl.pl.bartlomiejgladys.learnit.models.Selector.AnswerType;

import java.util.Comparator;
import java.util.Date;

/**
 * Comparator class for sorting cards
 *
 * @author Bartlomiej Gladys
 * @Date 04/11/2018
 * @version 1.0
 */

public class SortBySelector implements Comparator<Card> {

    /**
     * Default compare method
     *
     * @param o1 first Card
     * @param o2 second Card
     * @return number indicating comparing result
     */
    @Override
    public int compare(Card o1, Card o2) {
        Selector first = o1.getSelector();
        Selector second = o2.getSelector();
        return compareSelectors(first, second);
    }

    /**
     * Default compare method
     *
     * @param first  Selector
     * @param second Selector
     * @return number indicating comparing result
     */
    private int compareSelectors(Selector first, Selector second) {
        int isFirstWeaker = checkAnswerType(first.getAnswerType(), second.getAnswerType());
        if (isFirstWeaker != 0) {
            return isFirstWeaker;
        }

        int hasFirstLessCycles = checkCycles(first.getCycle(), second.getCycle());
        if (hasFirstLessCycles != 0) {
            return hasFirstLessCycles;
        }

        return checkUpdateDate(first.getUpdatedAt(), second.getUpdatedAt());
    }

    /**
     * Comparing cycle's numbers
     *
     * @param first  cycle's number
     * @param second cycle's number
     * @return number indicating cycle's comparison
     */
    private int checkCycles(int first, int second) {
        return first - second;
    }


    /**
     * Comparing updateAt dates of given selectors
     *
     * @param first  updateAt date
     * @param second updateAt date
     * @return date's comparison result
     */
    private int checkUpdateDate(Date first, Date second) {
        return first.compareTo(second);
    }

    /**
     * Comparing AnswerTypes of given selectors
     *
     * @param first  AnswerType
     * @param second AnswerType
     * @return answerType's comparison result
     */
    private int checkAnswerType(AnswerType first, AnswerType second) {
        if (first == second) {
            return 0;
        }
        boolean isFirstTheFailure = first == AnswerType.FAILURE;
        boolean isFirstWeaker = first == AnswerType.MEDIUM && second == AnswerType.CORRECT;
        return isFirstTheFailure || isFirstWeaker ? -1 : 1;
    }
}


