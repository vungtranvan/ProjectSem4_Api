/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_models;

import java.io.Serializable;

/**
 *
 * @author vungk
 */
public class QuestionVm implements Serializable{

    private int _id;
    private String name;
    private String categoryExamName;

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

    public String getCategoryExamName() {
        return categoryExamName;
    }

    public void setCategoryExamName(String categoryExamName) {
        this.categoryExamName = categoryExamName;
    }

}
