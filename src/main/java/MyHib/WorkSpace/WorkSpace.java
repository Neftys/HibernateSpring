package MyHib.WorkSpace;

import MyHib.DAO.Book;
import MyHib.DAOIMP.BookImp;
import MyHib.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by tu_gevelav on 22.09.2016.
 */
public class WorkSpace {
    public static void main(String[] args) {
        BookImp bookImp = new BookImp();
        System.out.println(bookImp.getListBook());


    }
}
