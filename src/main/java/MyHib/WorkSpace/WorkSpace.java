package MyHib.WorkSpace;

import MyHib.DAO.Book;
import MyHib.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by tu_gevelav on 22.09.2016.
 */
public class WorkSpace {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer developerId = null;

        transaction = session.beginTransaction();
        Book book = new Book("Book","description");
        developerId = (Integer) session.save(book);
        System.out.println(developerId);
        transaction.commit();
        session.close();

    }
}
