package view_models;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vungk
 */
public class HistoryUpdateVm implements Serializable{
    private int _id;
    private int correctMark;
    private int totalMark;
    private List<QuestionHistoryVm> items;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getCorrectMark() {
        return correctMark;
    }

    public void setCorrectMark(int correctMark) {
        this.correctMark = correctMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public List<QuestionHistoryVm> getItems() {
        return items;
    }

    public void setItems(List<QuestionHistoryVm> items) {
        this.items = items;
    }   
    
}
