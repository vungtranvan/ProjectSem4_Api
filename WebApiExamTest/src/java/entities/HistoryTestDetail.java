package entities;

import java.io.Serializable;

/**
 *
 * @author vungk
 */
public class HistoryTestDetail implements Serializable {

    private int historyTestId;
    private int questionId;
    private String answerChoice;

    public HistoryTestDetail() {
    }

    public HistoryTestDetail(int historyTestId, int questionId) {
        this.historyTestId = historyTestId;
        this.questionId = questionId;
    }

    public HistoryTestDetail(int historyTestId, int questionId, String answerChoice) {
        this.historyTestId = historyTestId;
        this.questionId = questionId;
        this.answerChoice = answerChoice;
    }

    public int getHistoryTestId() {
        return historyTestId;
    }

    public void setHistoryTestId(int historyTestId) {
        this.historyTestId = historyTestId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswerChoice() {
        return answerChoice;
    }

    public void setAnswerChoice(String answerChoice) {
        this.answerChoice = answerChoice;
    }

}
