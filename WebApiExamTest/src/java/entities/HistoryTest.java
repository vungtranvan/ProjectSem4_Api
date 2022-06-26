package entities;

import java.io.Serializable;

/**
 *
 * @author vungk
 */
public class HistoryTest implements Serializable {

    private int _id;
    private int userId;
    private int categoryExamId;
    private int corectMark;
    private int totalMark;
    private boolean status;

    public HistoryTest() {
    }

    public HistoryTest(int userId, int categoryExamId, int corectMark, int totalMark, boolean status) {
        this.userId = userId;
        this.categoryExamId = categoryExamId;
        this.corectMark = corectMark;
        this.totalMark = totalMark;
        this.status = status;
    }

    public HistoryTest(int _id, int userId, int categoryExamId, int corectMark, int totalMark, boolean status) {
        this._id = _id;
        this.userId = userId;
        this.categoryExamId = categoryExamId;
        this.corectMark = corectMark;
        this.totalMark = totalMark;
        this.status = status;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryExamId() {
        return categoryExamId;
    }

    public void setCategoryExamId(int categoryExamId) {
        this.categoryExamId = categoryExamId;
    }

    public int getCorectMark() {
        return corectMark;
    }

    public void setCorectMark(int corectMark) {
        this.corectMark = corectMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
