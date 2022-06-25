package services;

import dao.CategoryExamDAO;
import dao.interfaces.ICategoryExamDAO;
import entities.CategoryExam;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vungk
 */
@Stateless
@Path("categoryExam")
public class CategoryExamService {

    private ICategoryExamDAO dao;

    public CategoryExamService() {
        dao = new CategoryExamDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryExam> getAll() {
        return dao.getAll();
    }

    @GET
    @Path("/getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryExam getbyId(@PathParam("id") int id) {
        return dao.findById(id);
    }
}
