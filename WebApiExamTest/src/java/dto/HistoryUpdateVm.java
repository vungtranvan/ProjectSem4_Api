package dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vungk
 */
public class HistoryUpdateVm implements Serializable{
    private int _id;
    private int corectMark;
    private int totalMark;
    private List<QuestionHistoryVm> items;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
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

    public List<QuestionHistoryVm> getItems() {
        return items;
    }

    public void setItems(List<QuestionHistoryVm> items) {
        this.items = items;
    }   
    
}
