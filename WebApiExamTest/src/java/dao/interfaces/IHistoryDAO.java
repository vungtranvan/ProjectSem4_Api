package dao.interfaces;

import view_models.HistoryUpdateVm;
import view_models.HistoryVm;
import view_models.QuestionHistoryVm;
import java.util.List;

/**
 *
 * @author vungk
 */
public interface IHistoryDAO {

    public List<HistoryVm> getAll(String keySearch);

    public List<HistoryVm> getAll(int userId, int categoryExamId);

    public List<QuestionHistoryVm> getDetail(int id);

    public boolean add(int userId, int categoryExamId);

    public boolean edit(HistoryUpdateVm model);
}
