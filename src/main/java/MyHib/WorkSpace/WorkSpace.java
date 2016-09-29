package MyHib.WorkSpace;


import MyHib.Constructor.Constructor;
import MyHib.DAO.Author;
import MyHib.DAO.Book;
import MyHib.DAO.Genre;

/**
 * Created by tu_gevelav on 22.09.2016.
 */
public class WorkSpace {
    public static void main(String[] args) {

        Book book = new Book("FirstBook");
        book.getArrayList().add(new Genre("Comedy"));
        book.getArrayList().add(new Genre("Drama"));

        Constructor constructor =new Constructor();
        constructor.add(book);




    }
}
