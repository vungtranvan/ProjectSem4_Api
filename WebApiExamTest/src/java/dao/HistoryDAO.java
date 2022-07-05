package dao;

import dao.interfaces.IHistoryDAO;
import db.DBManager;
import dto.HistoryUpdateVm;
import dto.HistoryVm;
import dto.QuestionHistoryVm;
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
public class HistoryDAO implements IHistoryDAO {

    @Override
    public List<HistoryVm> getAll(String keySearch) {
        CallableStatement stm = null;
        ResultSet rs = null;
        Connection conn = DBManager.openConnection();
        if (keySearch == null) {
            keySearch = "";
        }
        try {
            stm = conn.prepareCall("{call App_HistoryTest_GetAllByAdmin(?)}");
            stm.setString(1, keySearch);

            List<HistoryVm> lstData = new ArrayList<>();
            rs = stm.executeQuery();
            while (rs.next()) {
                HistoryVm item = new HistoryVm();
                item.setId(rs.getInt("id"));
                item.setCategoryExamName(rs.getString("categoryExamName"));
                item.setAccountName(rs.getString("accountName"));
                item.setCorrectMark(rs.getInt("correctMark"));
                item.setTotalMark(rs.getInt("totalMark"));
                item.setStatus(rs.getBoolean("status"));
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
    public List<HistoryVm> getAll(int userId, int categoryExamId) {
        CallableStatement stm = null;
        ResultSet rs = null;
        Connection conn = DBManager.openConnection();
        try {
            stm = conn.prepareCall("{call App_HistoryTest_GetAllByUseIdAndCategoryExamId(?,?)}");
            stm.setInt(1, userId);
            stm.setInt(2, categoryExamId);
            List<HistoryVm> lstData = new ArrayList<>();
            rs = stm.executeQuery();
            while (rs.next()) {
                HistoryVm item = new HistoryVm();
                item.setId(rs.getInt("id"));
                item.setCorrectMark(rs.getInt("correctMark"));
                item.setTotalMark(rs.getInt("totalMark"));
                item.setStatus(rs.getBoolean("status"));
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
    public boolean add(int userId, int categoryExamId) {
        CallableStatement stm = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_HistoryTest_Add(?,?)}");
            stm.setInt(1, userId);
            stm.setInt(2, categoryExamId);

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
    public List<QuestionHistoryVm> getDetail(int id) {
        CallableStatement stm = null;
        ResultSet rs = null;
        Connection conn = DBManager.openConnection();
        try {
            stm = conn.prepareCall("{call App_HistoryTestDetail_GetByHistoryTestId(?)}");
            stm.setInt(1, id);

            List<QuestionHistoryVm> lstData = new ArrayList<>();
            rs = stm.executeQuery();
            while (rs.next()) {
                QuestionHistoryVm item = new QuestionHistoryVm();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCategoryExamId(rs.getInt("categoryExamId"));
                item.setImage(rs.getString("image"));
                item.setAnswerA(rs.getString("answer_a"));
                item.setAnswerB(rs.getString("answer_b"));
                item.setAnswerC(rs.getString("answer_c"));
                item.setAnswerD(rs.getString("answer_d"));
                item.setAnswerCorrect(rs.getString("answerCorrect"));
                item.setAnswerChoice(rs.getString("answerChoice"));

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
    public boolean edit(HistoryUpdateVm model) {
        CallableStatement stm = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_HistoryTest_Update(?,?,?)}");
            stm.setInt(1, model.getId());
            stm.setInt(2, model.getCorectMark());
            stm.setInt(3, model.getTotalMark());
            stm.executeUpdate();

            for (QuestionHistoryVm item : model.getItems()) {
                stm = conn.prepareCall("{call App_HistoryTestDetail_Update(?,?,?)}");
                stm.setInt(1, model.getId());
                stm.setInt(2, item.getId());
                stm.setString(3, item.getAnswerChoice());
                stm.executeUpdate();
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(conn, stm, null);
        }
        return false;
    }
}
