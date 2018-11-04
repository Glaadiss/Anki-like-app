package polsl.pl.bartlomiejgladys.learnit.models;

import polsl.pl.bartlomiejgladys.learnit.models.Selector.AnswerType;

import java.util.Comparator;
import java.util.Date;

/**
 * @Author Bartłomiej Gładys
 * @Date 04/11/2018
 * @Version 1.0
 */

public class SortBySelector implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        Selector first = o1.getSelector();
        Selector second = o2.getSelector();
        return compareSelectors(first, second);
    }

    private int compareSelectors(Selector first, Selector second){
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

    private int checkCycles(int first, int second) {
        return second - first;
    }

    private int checkUpdateDate(Date first, Date second) {
        return first.compareTo(second);
    }

    private int checkAnswerType(AnswerType first, AnswerType second) {
        if (first == second) {
            return 0;
        }
        boolean isFirstTheFailure = first == AnswerType.FAILURE;
        boolean isFirstWeaker = first == AnswerType.MEDIUM && second == AnswerType.CORRECT;
        return isFirstTheFailure || isFirstWeaker ? -1 : 1;
    }
}


