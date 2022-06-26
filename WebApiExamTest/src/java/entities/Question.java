package entities;

import java.io.Serializable;

/**
 *
 * @author vungk
 */
public class Question implements Serializable {

    private int _id;
    private String name;
    private int categoryExamId;
    private String categoryExamName;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String answerCorrect;
    private String image;

    public Question() {
    }

    public Question(int _id) {
        this._id = _id;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryExamId() {
        return categoryExamId;
    }

    public void setCategoryExamId(int categoryExamId) {
        this.categoryExamId = categoryExamId;
    }

    public String getCategoryExamName() {
        return categoryExamName;
    }

    public void setCategoryExamName(String categoryExamName) {
        this.categoryExamName = categoryExamName;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(String answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
