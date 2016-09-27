package MyHib.WorkSpace;


import MyHib.TestDao.Address;

import MyHib.TestDao.User;
import MyHib.Util.HibernateUtil;

import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tu_gevelav on 22.09.2016.
 */
public class WorkSpace {
    public static void main(String[] args) {
        SessionFactory sessionFactory;


        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        transaction.begin();
        User user=new User("Vasya");
        Address address =new Address("Melnikova");
        address.setUser(user);
        session.save(address);
        transaction.commit();
       // session.close();

        List<Address> addresses =(ArrayList<Address>) session.createQuery("FROM Address ").list();
        session.close();
        System.out.println(addresses);
    }

}
