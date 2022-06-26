package entities;

import java.io.Serializable;

/**
 *
 * @author vungk
 */
public class CategoryExam implements Serializable {

    private int _id;
    private String name;

    public CategoryExam() {
    }

    public CategoryExam(int _id) {
        this._id = _id;
    }

    public CategoryExam(int _id, String name) {
        this._id = _id;
        this.name = name;
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
}
