/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author vungk
 */
@Embeddable
public class HistoryTestDetailPK implements Serializable {
    @NotNull
    @Column(name = "HistoryTestId")
    private int historyTestId;
    
    @NotNull
    @Column(name = "QuestionId")
    private int questionId;

    public HistoryTestDetailPK() {
    }

    public HistoryTestDetailPK(int historyTestId, int questionId) {
        this.historyTestId = historyTestId;
        this.questionId = questionId;
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
}
