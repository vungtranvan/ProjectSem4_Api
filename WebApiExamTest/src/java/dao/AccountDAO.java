package dao;

import dao.interfaces.IAccountDAO;
import db.DBManager;
import dto.ChangPasswordDto;
import dto.PagedAccountList;
import entities.Account;
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
public class AccountDAO implements IAccountDAO {

    @Override
    public PagedAccountList getAll(int pageIndex, int pageSize, String keySearch) {
        CallableStatement stm = null;
        ResultSet rs = null;
        Connection conn = DBManager.openConnection();
        int skip = (pageIndex - 1) * pageSize;
        if (keySearch == null) {
            keySearch = "";
        }
        try {
            stm = conn.prepareCall("{call App_Account_CountDataOfGetAll(?)}");
            stm.setString(1, keySearch);
            rs = stm.executeQuery();
            int total = 0;
            if (rs.next()) {
                total = rs.getInt(1);
            }
            if (total == 0) {
                return null;
            }
            stm = conn.prepareCall("{call App_Account_GetAll(?,?,?)}");
            stm.setInt(1, skip);
            stm.setInt(2, pageSize);
            stm.setString(3, keySearch);
            List<Account> lstData = new ArrayList<>();
            rs = stm.executeQuery();
            while (rs.next()) {
                Account item = new Account();
                item.setId(rs.getInt("id"));
                item.setUserName(rs.getString("userName"));
                item.setPassword(rs.getString("password"));
                item.setName(rs.getString("name"));
                item.setEmail(rs.getString("email"));
                item.setImage(rs.getString("image"));
                item.setAddress(rs.getString("address"));
                item.setSex(rs.getBoolean("sex"));
                item.setIsAdmin(rs.getBoolean("isAdmin"));
                lstData.add(item);
            }
            PagedAccountList pagedList = new PagedAccountList(total, lstData);
            return pagedList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(conn, stm, rs);
        }

        return null;
    }

    @Override
    public Account findById(int id) {
        CallableStatement stm = null;
        ResultSet rs = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_Account_GetById(?)}");
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                Account item = new Account();
                item.setId(rs.getInt("id"));
                item.setUserName(rs.getString("userName"));
                item.setPassword(rs.getString("password"));
                item.setName(rs.getString("name"));
                item.setEmail(rs.getString("email"));
                item.setImage(rs.getString("image"));
                item.setAddress(rs.getString("address"));
                item.setSex(rs.getBoolean("sex"));
                item.setIsAdmin(rs.getBoolean("isAdmin"));
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
    public Account findByUserName(String userName) {
        CallableStatement stm = null;
        ResultSet rs = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_Account_GetByUserName(?)}");
            stm.setString(1, userName);
            rs = stm.executeQuery();
            if (rs.next()) {
                Account item = new Account();
                item.setId(rs.getInt("id"));
                item.setUserName(rs.getString("userName"));
                item.setPassword(rs.getString("password"));
                item.setName(rs.getString("name"));
                item.setEmail(rs.getString("email"));
                item.setImage(rs.getString("image"));
                item.setAddress(rs.getString("address"));
                item.setSex(rs.getBoolean("sex"));
                item.setIsAdmin(rs.getBoolean("isAdmin"));
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
    public Account findByEmail(String email) {
        CallableStatement stm = null;
        ResultSet rs = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_Account_GetByEmail(?)}");
            stm.setString(1, email);
            rs = stm.executeQuery();
            if (rs.next()) {
                Account item = new Account();
                item.setId(rs.getInt("id"));
                item.setUserName(rs.getString("userName"));
                item.setPassword(rs.getString("password"));
                item.setName(rs.getString("name"));
                item.setEmail(rs.getString("email"));
                item.setImage(rs.getString("image"));
                item.setAddress(rs.getString("address"));
                item.setSex(rs.getBoolean("sex"));
                item.setIsAdmin(rs.getBoolean("isAdmin"));
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
    public boolean add(Account entity) {
        CallableStatement stm = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_Account_Insert(?,?,?,?,?,?,?,?)}");
            stm.setString(1, entity.getUserName());
            stm.setString(2, entity.getPassword());
            stm.setString(3, entity.getName());
            stm.setString(4, entity.getEmail());
            stm.setString(5, entity.getImage());
            stm.setString(6, entity.getAddress());
            stm.setBoolean(7, entity.isSex());
            stm.setBoolean(8, entity.isIsAdmin());

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
    public boolean edit(Account entity) {
        CallableStatement stm = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_Account_Update(?,?,?,?,?,?,?,?,?)}");
            stm.setInt(1, entity.getId());
            stm.setString(2, entity.getUserName());
            stm.setString(3, entity.getPassword());
            stm.setString(4, entity.getName());
            stm.setString(5, entity.getEmail());
            stm.setString(6, entity.getImage());
            stm.setString(7, entity.getAddress());
            stm.setBoolean(8, entity.isSex());
            stm.setBoolean(9, entity.isIsAdmin());

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
            stm = conn.prepareCall("{call App_Account_Delete(?)}");
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

    @Override
    public boolean updatePasswordByUsername(ChangPasswordDto input) {
        CallableStatement stm = null;
        Connection conn = DBManager.openConnection();

        try {
            stm = conn.prepareCall("{call App_Account_UpdatePassword(?,?)}");
            stm.setString(1, input.getUserName());
            stm.setString(2, input.getPassword());

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
