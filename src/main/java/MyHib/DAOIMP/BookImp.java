package MyHib.DAOIMP;

import MyHib.DAO.Book;
import MyHib.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by tu_gevelav on 22.09.2016.
 */
public class BookImp {
    private static SessionFactory sessionFactory;
/*
    public Integer addBook (Book book){
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();

    }
    */
}
