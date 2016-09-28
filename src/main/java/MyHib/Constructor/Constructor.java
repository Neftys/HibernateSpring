package MyHib.Constructor;

import MyHib.DAO.Author;
import MyHib.DAO.Book;
import MyHib.DAO.Genre;
import MyHib.DAOIMP.AuthorImp;
import MyHib.DAOIMP.BookImp;
import MyHib.DAOIMP.GenreIMP;

import java.util.Objects;

/**
 * Created by tu_gevelav on 27.09.2016.
 */
public class Constructor {
    AuthorImp authorImp = new AuthorImp();
    BookImp bookImp = new BookImp();
    GenreIMP genreImp = new GenreIMP();

    public Integer add(Object object){
        if (object.getClass()==Author.class){
            return authorImp.add((Author)object);
        }
        if (object.getClass()==Book.class){
            return bookImp.add((Book)object);
        }
        if (object.getClass()==Genre.class){
            return genreImp.add((Genre)object);
        }
        return -1;
    }

}
