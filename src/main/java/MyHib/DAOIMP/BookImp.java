package MyHib.DAOIMP;

import MyHib.DAO.Book;
import MyHib.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tu_gevelav on 22.09.2016.
 */
public class BookImp {
    private static SessionFactory sessionFactory;
    private Integer id;


    public void Shutdown() {
        HibernateUtil.shutdown();
    }

    public Integer add(Book book) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        id = (Integer) session.save(book);
        transaction.commit();
        session.close();
        return id;
    }

    public void delete(Book book) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.delete(book);
        transaction.commit();
        session.close();
        System.out.println("Book deleted");
    }

    public Book get(Integer integer) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Book book = (Book) session.get(Book.class, integer);
        session.close();
        return book;
    }

    public void update(Book book) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(book);
        transaction.commit();
        session.close();
    }

    public ArrayList<Book> getList() {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        ArrayList<Book> arrayList = (ArrayList<Book>) session.createQuery("FROM Book ").list();
        session.close();
        return arrayList;
    }

    public List<Book> CriteriaList() {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session  session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Book.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        ArrayList<Book> arrayList =(ArrayList<Book>)criteria.list();
        session.close();
        return arrayList;
    }

    public void deleteAll() {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.createQuery("delete from Book ").executeUpdate();
        transaction.commit();
        session.close();

    }


}
