package dao.interfaces;

import dto.ChangPasswordDto;
import dto.PagedAccountList;
import entities.Account;

/**
 *
 * @author vungk
 */
public interface IAccountDAO {

    public PagedAccountList getAll(int pageIndex, int pageSize, String keySearch);

    public Account findById(int id);

    public Account findByUserName(String userName);

    public Account findByEmail(String email);

    public boolean add(Account entity);

    public boolean edit(Account entity);

    public boolean đelete(int id);

    public boolean updatePasswordByUsername(ChangPasswordDto input);
}
