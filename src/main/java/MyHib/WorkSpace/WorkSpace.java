package MyHib.WorkSpace;


import MyHib.Constructor.Constructor;
import MyHib.DAO.Author;
import MyHib.DAO.Genre;

/**
 * Created by tu_gevelav on 22.09.2016.
 */
public class WorkSpace {
    public static void main(String[] args) {
        Author author =new Author();
        System.out.println(author.getBookList());
    }
}
