package dao;

import dao.interfaces.IQuestionDAO;
import db.DBManager;
import view_models.QuestionVm;
import entities.Question;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vungk
 */
public class QuestionDAO implements IQuestionDAO {

    @Override
    public List<QuestionVm> getAll(String keySearch) {
        CallableStatement stm = null;
        ResultSet rs = null;
        Connection conn = DBManager.openConnection();
        if (keySearch == null) {
            keySearch = "";
        }
        try {
            stm = conn.prepareCall("{call App_Question_GetAll(?)}");
            stm.setString(1, keySearch);
            List<QuestionVm> lstData = new ArrayList<>();
            rs = stm.executeQuery();
            while (rs.next()) {
                QuestionVm item = new QuestionVm();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCategoryExamName(rs.getString("categoryExamName"));
                lstData.add(item);
            }
            return lstData;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(conn, stm, rs);
        }

        return null;
    }

    @Override
    public Question findById(int id) {
        CallableStatement stm = null;
        ResultSet rs = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_Question_GetById(?)}");
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                Question item = new Question();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCategoryExamId(rs.getInt("categoryExamId"));
                item.setCategoryExamName(rs.getString("categoryExamName"));
                item.setAnswerA(rs.getString("answer_a"));
                item.setAnswerB(rs.getString("answer_b"));
                item.setAnswerC(rs.getString("answer_c"));
                item.setAnswerD(rs.getString("answer_d"));
                item.setAnswerCorrect(rs.getString("answerCorrect"));
                item.setImage(rs.getString("image"));

                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(conn, stm, rs);
        }
        return null;
    }

    @Override
    public boolean add(Question entity) {
        CallableStatement stm = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_Question_Insert(?,?,?,?,?,?,?,?)}");
            stm.setString(1, entity.getName());
            stm.setInt(2, entity.getCategoryExamId());
            stm.setString(3, entity.getAnswerA());
            stm.setString(4, entity.getAnswerB());
            stm.setString(5, entity.getAnswerC());
            stm.setString(6, entity.getAnswerD());
            stm.setString(7, entity.getAnswerCorrect());
            stm.setString(8, entity.getImage());

            int i = stm.executeUpdate();
            return i > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(conn, stm, null);
        }
        return false;
    }

    @Override
    public boolean edit(Question entity) {
        CallableStatement stm = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_Question_Update(?,?,?,?,?,?,?,?,?)}");
            stm.setInt(1, entity.getId());
            stm.setString(2, entity.getName());
            stm.setInt(3, entity.getCategoryExamId());
            stm.setString(4, entity.getAnswerA());
            stm.setString(5, entity.getAnswerB());
            stm.setString(6, entity.getAnswerC());
            stm.setString(7, entity.getAnswerD());
            stm.setString(8, entity.getAnswerCorrect());
            stm.setString(9, entity.getImage());

            int i = stm.executeUpdate();
            return i > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(conn, stm, null);
        }
        return false;
    }

    @Override
    public boolean đelete(int id) {
        CallableStatement stm = null;

        Connection conn = DBManager.openConnection();
        try {
            stm = conn.prepareCall("{call App_Question_Delete(?)}");
            stm.setInt(1, id);

            int i = stm.executeUpdate();
            return i > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(conn, stm, null);
        }
        return false;
    }

}
