package dto;

import entities.Account;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vungk
 */
public class PagedAccountList implements Serializable {

    private int toalCount;
    private List<Account> Items;

    public PagedAccountList() {
    }

    public PagedAccountList(int toalCount, List<Account> Items) {
        this.toalCount = toalCount;
        this.Items = Items;
    }

    public int getToalCount() {
        return toalCount;
    }

    public void setToalCount(int toalCount) {
        this.toalCount = toalCount;
    }

    public List<Account> getItems() {
        return Items;
    }

    public void setItems(List<Account> Items) {
        this.Items = Items;
    }

}
