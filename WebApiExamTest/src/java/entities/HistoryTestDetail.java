/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author vungk
 */
@Entity
@Table(name = "HistoryTestDetail")
public class HistoryTestDetail implements Serializable {
    @EmbeddedId
    protected HistoryTestDetailPK historyTestDetailPK;
    
    @Size(max = 5)
    @Column(name = "AnswerChoice")
    private String answerChoice;
    
    @JoinColumn(name = "HistoryTestId", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HistoryTest historyTest;
    
    @JoinColumn(name = "QuestionId", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Question question;

    public HistoryTestDetail() {
    }

    public HistoryTestDetail(HistoryTestDetailPK historyTestDetailPK) {
        this.historyTestDetailPK = historyTestDetailPK;
    }

    public HistoryTestDetail(int historyTestId, int questionId) {
        this.historyTestDetailPK = new HistoryTestDetailPK(historyTestId, questionId);
    }

    public HistoryTestDetailPK getHistoryTestDetailPK() {
        return historyTestDetailPK;
    }

    public void setHistoryTestDetailPK(HistoryTestDetailPK historyTestDetailPK) {
        this.historyTestDetailPK = historyTestDetailPK;
    }

    public String getAnswerChoice() {
        return answerChoice;
    }

    public void setAnswerChoice(String answerChoice) {
        this.answerChoice = answerChoice;
    }

    public HistoryTest getHistoryTest() {
        return historyTest;
    }

    public void setHistoryTest(HistoryTest historyTest) {
        this.historyTest = historyTest;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    } 
}
