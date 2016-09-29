package MyHib.WorkSpace;


import MyHib.Constructor.Constructor;
import MyHib.DAO.Author;


/**
 * Created by tu_gevelav on 22.09.2016.
 */
public class WorkSpace {
    public static void main(String[] args) {
        Constructor constructor =new Constructor();
        constructor.Delete(Author.class,16);

        //constructor.addSomeBook();
        // constructor.DeleteAll();



    }
}
