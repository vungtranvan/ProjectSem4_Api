package entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vungk
 */
public class HistoryTest implements Serializable {

    private Integer id;
    private int userId;
    private int categoryExamId;
    private Integer corectMark;
    private Integer totalMark;
    private boolean status;

    public HistoryTest() {
    }

    public HistoryTest(int userId, int categoryExamId, Integer corectMark, Integer totalMark, boolean status) {
        this.userId = userId;
        this.categoryExamId = categoryExamId;
        this.corectMark = corectMark;
        this.totalMark = totalMark;
        this.status = status;
    }

    public HistoryTest(Integer id, int userId, int categoryExamId, Integer corectMark, Integer totalMark, boolean status) {
        this.id = id;
        this.userId = userId;
        this.categoryExamId = categoryExamId;
        this.corectMark = corectMark;
        this.totalMark = totalMark;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCorectMark() {
        return corectMark;
    }

    public void setCorectMark(Integer corectMark) {
        this.corectMark = corectMark;
    }

    public Integer getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Integer totalMark) {
        this.totalMark = totalMark;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
