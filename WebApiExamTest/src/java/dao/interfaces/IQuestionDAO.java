/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import view_models.QuestionVm;
import entities.Question;
import java.util.List;

/**
 *
 * @author vungk
 */
public interface IQuestionDAO {

    public List<QuestionVm> getAll(String keySearch);

    public Question findById(int id);

    public boolean add(Question entity);

    public boolean edit(Question entity);

    public boolean delete(int id);
}
