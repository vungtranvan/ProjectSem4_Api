package services;

import com.google.gson.Gson;
import dao.interfaces.IAccountDAO;
import dao.AccountDAO;
import view_models.ChangPasswordVm;
import entities.Account;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vungk
 */
@Stateless
@Path("account")
public class AccountService {

    private IAccountDAO dao;

    public AccountService() {
        dao = new AccountDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAll(@QueryParam("keySearch") String keySearch) {
        return dao.getAll(keySearch);
    }

    @GET
    @Path("/getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getById(@PathParam("id") int id) {
        return dao.findById(id);
    }

    @GET
    @Path("/getByUserName/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getByUserName(@PathParam("userName") String userName) {
        return dao.findByUserName(userName);
    }

    @GET
    @Path("/getByEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getByEmail(@PathParam("email") String email) {
        return dao.findByEmail(email);
    }

    @POST
    @Path("/addAccount")
    @Consumes(MediaType.APPLICATION_JSON)
    public String add(String strData) {
        Gson son = new Gson();
        Account entity = son.fromJson(strData, Account.class);
        boolean bl = dao.add(entity);
        String result = son.toJson(bl);
        return result;
    }
    
    @POST
    @Path("/registerAccount")
    @Consumes(MediaType.APPLICATION_JSON)
    public String register(String strData) {
        Gson son = new Gson();
        Account entity = son.fromJson(strData, Account.class);
        boolean bl = dao.add(entity);
        if (bl) {
            entity = dao.findByUserName(entity.getUserName());
            return son.toJson(entity.getId());
        }
        return "0";
    }

    @PUT
    @Path("/editAccount")
    @Consumes(MediaType.APPLICATION_JSON)
    public String edit(String strData) {
        Gson son = new Gson();
        Account entity = son.fromJson(strData, Account.class);
        boolean bl = dao.edit(entity);
        String result = son.toJson(bl);
        return result;
    }

    @DELETE
    @Path("/deleteAccount/{id}")
    public String delete(@PathParam("id") int id) {
        boolean bl = dao.đelete(id);
        Gson son = new Gson();
        String result = son.toJson(bl);
        return result;
    }

    @PUT
    @Path("/updatePasswordByUserId")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updatePasswordByUserId(String strData) {
        Gson son = new Gson();
        ChangPasswordVm entity = son.fromJson(strData, ChangPasswordVm.class);
        if (!entity.getPassword().equals(entity.getConfirmPassword())) {
            return "false";
        }
        boolean bl = dao.updatePasswordByUserId(entity);
        String result = son.toJson(bl);
        return result;
    }
}
