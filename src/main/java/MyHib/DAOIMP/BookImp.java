package MyHib.DAOIMP;

import MyHib.DAO.Book;
import MyHib.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by tu_gevelav on 22.09.2016.
 */
public class BookImp {
    private static SessionFactory sessionFactory;
    private Integer id;

    public Integer addBook (Book book){
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();
        id=(Integer)session.save(book);
        transaction.commit();
        session.close();
        return id;
    }

    public void deleteBook ( Book book){
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();
        session.delete(book);

        transaction.commit();
        session.close();

    }

    public Book getBook(Integer integer){
        sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction =session.getTransaction();
        transaction.begin();
        Book book=(Book)session.get(Book.class,integer);

        session.close();
        return book;
    }



    public void updateBook ( Book book){
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();
        session.update(book);
        transaction.commit();
        session.close();

    }
    public ArrayList<Book> getListBook (){
        sessionFactory =HibernateUtil.getSessionFactory();
        Session session =sessionFactory.openSession();
        Transaction transaction =session.getTransaction();
        transaction.begin();
        ArrayList<Book> arrayList =(ArrayList<Book>) session.createQuery("FROM Book where name like '%d%'").list();
        session.close();
        return arrayList;
    }
    public List<Book> CriteriaList (){
        sessionFactory=HibernateUtil.getSessionFactory();
        Session session =sessionFactory.openSession();
        Criteria criteria =session.createCriteria(Book.class);
        return criteria.list();
    }



}
