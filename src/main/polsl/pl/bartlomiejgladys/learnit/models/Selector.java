package polsl.pl.bartlomiejgladys.learnit.models;

import java.util.Date;

/**
 * @Author Bartłomiej Gładys
 * @Date 01/11/2018
 * @Version 1.0
 */

public class Selector {
    public enum AnswerType {
        CORRECT, MEDIUM, FAILURE
    }

    private Date updatedAt = new Date();
    private AnswerType answerType = AnswerType.MEDIUM;
    private int cycle = 0;

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Selector setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public Selector setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
        return this;
    }

    public int getCycle() {
        return cycle;
    }

    public Selector setCycle(int cycle) {
        this.cycle = cycle;
        return this;
    }

    public void updateSelector(AnswerType type){
        setAnswerType(type);
        setUpdatedAt(new Date());
        cycle++;
    }

}
