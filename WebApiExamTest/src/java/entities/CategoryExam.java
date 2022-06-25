package entities;

import java.io.Serializable;

/**
 *
 * @author vungk
 */
public class CategoryExam implements Serializable {

    private Integer id;
    private String name;

    public CategoryExam() {
    }

    public CategoryExam(Integer id) {
        this.id = id;
    }

    public CategoryExam(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
