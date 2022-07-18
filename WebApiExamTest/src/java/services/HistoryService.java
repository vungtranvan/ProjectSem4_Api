package services;

import com.google.gson.Gson;
import dao.HistoryDAO;
import dao.interfaces.IHistoryDAO;
import view_models.HistoryUpdateVm;
import view_models.HistoryVm;
import view_models.QuestionHistoryVm;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vungk
 */
@Stateless
@Path("history")
public class HistoryService {

    private IHistoryDAO dao;

    public HistoryService() {
        dao = new HistoryDAO();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<HistoryVm> getAll(@QueryParam("keySearch") String keySearch) {
        return dao.getAll(keySearch);
    }
    
    @GET
    @Path("/getAllByUserIdAndCategoryExamId/{userId}/{categoryExamId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<HistoryVm> getAll(@PathParam("userId") int userId, @PathParam("categoryExamId") int categoryExamId) {
        return dao.getAll(userId, categoryExamId);
    }

    @GET
    @Path("/getDetail/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<QuestionHistoryVm> getDetail(@PathParam("id") int id) {
        return dao.getDetail(id);
    }

    @POST
    @Path("/addHistory/{userId}/{categoryExamId}")
    public String add(@PathParam("userId") int userId, @PathParam("categoryExamId") int categoryExamId) {
        Gson son = new Gson();
        boolean bl = dao.add(userId, categoryExamId);
        String result = son.toJson(bl);
        return result;
    }

    @PUT
    @Path("/editHistory")
    @Consumes(MediaType.APPLICATION_JSON)
    public String edit(HistoryUpdateVm model) {
        Gson son = new Gson();
        boolean bl = dao.edit(model);
        String result = son.toJson(bl);
        return result;
    }
}
