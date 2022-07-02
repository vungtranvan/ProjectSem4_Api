package dao.interfaces;

import dto.HistoryUpdateVm;
import dto.HistoryVm;
import dto.QuestionHistoryVm;
import java.util.List;

/**
 *
 * @author vungk
 */
public interface IHistoryDAO {
    public List<HistoryVm> getAll(int userId, int categoryExamId);
    public List<QuestionHistoryVm> getDetail(int id);
    public boolean add(int userId, int categoryExamId);
    public boolean edit(HistoryUpdateVm model);
}
