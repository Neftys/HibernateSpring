package MyHib.WorkSpace;


import MyHib.DAO.Book;

import MyHib.Util.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TransferQueue;


/**
 * Created by tu_gevelav on 22.09.2016.
 */
public class WorkSpace {
    public static void main(String[] args) {
       Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaction =session.beginTransaction();
        Criteria criteria =session.createCriteria(Book.class);
        criteria.add(Restrictions.between("id",5,10));
       criteria.add(Restrictions.isNotNull("name"));
        criteria.add(Restrictions.like("description", "des%"));

        System.out.println(criteria.list());



       // query.addEntity(Book.class);
      // query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        //List results =  query.list();


        /*
        String sql = "SELECT * FROM book WHERE id = 10";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Book.class);
       // query.setParameter("employee_id", 10);
        List results = query.list();
        System.out.println(results);
*/
    }
}
