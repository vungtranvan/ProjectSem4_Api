package services;

import com.google.gson.Gson;
import dao.interfaces.IQuestionDAO;
import dao.QuestionDAO;
import entities.Question;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vungk
 */
@Stateless
@Path("question")
public class QuestionService {

    private IQuestionDAO dao;

    public QuestionService() {
        dao = new QuestionDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> getAll() {
        return dao.getAll();
    }

    @GET
    @Path("/getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Question getById(@PathParam("id") int id) {
        return dao.findById(id);
    }

    @POST
    @Path("/addQuestion")
    @Consumes(MediaType.APPLICATION_JSON)
    public String add(String strData) {
        Gson son = new Gson();
        Question entity = son.fromJson(strData, Question.class);
        boolean bl = dao.add(entity);
        String result = son.toJson(bl);
        return result;
    }

    @PUT
    @Path("/editQuestion")
    @Consumes(MediaType.APPLICATION_JSON)
    public String edit(String strData) {
        Gson son = new Gson();
        Question entity = son.fromJson(strData, Question.class);
        boolean bl = dao.edit(entity);
        String result = son.toJson(bl);
        return result;
    }

    @DELETE
    @Path("/deleteQuestion/{id}")
    public String delete(@PathParam("id") int id) {
        boolean bl = dao.đelete(id);
        Gson son = new Gson();
        String result = son.toJson(bl);
        return result;
    }
}
