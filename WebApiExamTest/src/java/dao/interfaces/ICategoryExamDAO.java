/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import entities.CategoryExam;
import java.util.List;

/**
 *
 * @author vungk
 */
public interface ICategoryExamDAO {
    public List<CategoryExam> getAll();
    public CategoryExam findById(int id);
}
