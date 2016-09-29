package MyHib.DAOIMP;

import MyHib.Constructor.Constructor;
import MyHib.DAO.Author;
import MyHib.DAO.Book;
import MyHib.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tu_gevelav on 27.09.2016.
 */
public class AuthorImp  {

    private static SessionFactory sessionFactory;
    private Integer id;

    public Integer add(Author author) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        id = (Integer) session.save(author);
        transaction.commit();
        session.close();
        return id;
    }

    public void delete(Author author) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.delete(author);
        transaction.commit();
        session.close();
    }

    public Author get(Integer integer) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Author author = (Author) session.get(Author.class, integer);

        session.close();
        return author;
    }


    public void update(Author author) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(author);
        transaction.commit();
        session.close();
    }

    public ArrayList<Author> getList() {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        ArrayList<Author> arrayList = (ArrayList<Author>) session.createQuery("FROM Author where name like '%d%'").list();
        session.close();
        return arrayList;
    }

    public List<Book> CriteriaList() {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Book.class);
        return criteria.list();
    }
}