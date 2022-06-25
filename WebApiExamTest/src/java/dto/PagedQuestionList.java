package dto;

import entities.Question;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vungk
 */
public class PagedQuestionList implements Serializable{
    private int toalCount;
    private List<Question> Items;

    public PagedQuestionList() {
    }

    public PagedQuestionList(int toalCount, List<Question> Items) {
        this.toalCount = toalCount;
        this.Items = Items;
    }

    public int getToalCount() {
        return toalCount;
    }

    public void setToalCount(int toalCount) {
        this.toalCount = toalCount;
    }

    public List<Question> getItems() {
        return Items;
    }

    public void setItems(List<Question> Items) {
        this.Items = Items;
    }
}
