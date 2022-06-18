package dao;

import dao.interfaces.ICategoryExamDAO;
import entities.CategoryExam;
import hiberNate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vungk
 */
public class CategoryExamDAO implements ICategoryExamDAO {

    @Override
    public List<CategoryExam> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from CategoryExam").list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public CategoryExam findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            CategoryExam category = (CategoryExam) session.get(CategoryExam.class, id);
            session.getTransaction().commit();
            return category;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }
}
