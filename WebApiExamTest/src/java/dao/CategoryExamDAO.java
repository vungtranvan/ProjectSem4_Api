package dao;

import dao.interfaces.ICategoryExamDAO;
import db.DBManager;
import entities.CategoryExam;
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
public class CategoryExamDAO implements ICategoryExamDAO {

    @Override
    public List<CategoryExam> getAll() {
        List<CategoryExam> list = new ArrayList<>();
        CallableStatement stm = null;
        ResultSet rs = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_CategoryExam_GetAll()}");
            rs = stm.executeQuery();
            while (rs.next()) {
                CategoryExam item = new CategoryExam(rs.getInt("id"), rs.getString("name"));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(conn, stm, rs);
        }
        return list;
    }

    @Override
    public CategoryExam findById(int id) {
        CallableStatement stm = null;
        ResultSet rs = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_CategoryExam_GetById(?)}");
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new CategoryExam(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(conn, stm, rs);
        }
        return null;
    }
}
