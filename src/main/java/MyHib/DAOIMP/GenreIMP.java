package MyHib.DAOIMP;


import MyHib.DAO.Genre;
import MyHib.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tu_gevelav on 28.09.2016.
 */
public class GenreIMP {
    private static SessionFactory sessionFactory;
    private Integer id;

    public Integer add (Genre genre){
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();
        id=(Integer)session.save(genre);
        transaction.commit();
        session.close();
        return id;
    }

    public void delete ( Genre genre){
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();
        session.delete(genre);

        transaction.commit();
        session.close();

    }

    public Genre get(Integer integer){
        sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction =session.getTransaction();
        transaction.begin();
        Genre genre=(Genre )session.get(Genre.class,integer);

        session.close();
        return genre;
    }



    public void update ( Genre genre){
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();
        session.update(genre);
        transaction.commit();
        session.close();

    }
    public ArrayList<Genre> getList (){
        sessionFactory =HibernateUtil.getSessionFactory();
        Session session =sessionFactory.openSession();
        Transaction transaction =session.getTransaction();
        transaction.begin();
        ArrayList<Genre> arrayList =(ArrayList<Genre>) session.createQuery("FROM Genre where name like '%d%'").list();
        session.close();
        return arrayList;
    }
    public List<Genre> CriteriaList (){
        sessionFactory=HibernateUtil.getSessionFactory();
        Session session =sessionFactory.openSession();
        Criteria criteria =session.createCriteria(Genre.class);
        return criteria.list();
    }
}
