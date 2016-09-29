package MyHib.Constructor;

import MyHib.DAO.Author;
import MyHib.DAO.Book;
import MyHib.DAO.Genre;
import MyHib.DAOIMP.AuthorImp;
import MyHib.DAOIMP.BookImp;
import MyHib.DAOIMP.GenreIMP;
import com.sun.java.util.jar.pack.*;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by tu_gevelav on 27.09.2016.
 */
public class Constructor {
    AuthorImp authorImp = new AuthorImp();
    BookImp bookImp = new BookImp();
    GenreIMP genreImp = new GenreIMP();

    public Integer add(Object object) {
        if (object.getClass() == Author.class) {
            return authorImp.add((Author) object);
        }
        if (object.getClass() == Book.class) {
            return bookImp.add((Book) object);
        }
        if (object.getClass() == Genre.class) {
            return genreImp.add((Genre) object);
        }
        return -1;
    }

    public void Update(Object object) {
        if (object.getClass() == Author.class) {
            authorImp.update((Author) object);
        }
        if (object.getClass() == Book.class) {
            bookImp.update((Book) object);
        }
        if (object.getClass() == Genre.class) {
            genreImp.update((Genre) object);
        }
    }

    public void Delete(Class clas, Integer integer) {
        if (clas == Author.class) {
            Author author = authorImp.get(integer);
            authorImp.delete(author);
        }
        if (clas == Book.class) {
            Book book = bookImp.get(integer);
            bookImp.delete(book);
        }
        if (clas == Genre.class) {
            Genre genre = genreImp.get(integer);
            genreImp.delete(genre);
        }
    }

    public void delete(Object object) {
        if (object.getClass() == Author.class) {
            authorImp.delete((Author) object);
        }
        if (object.getClass() == Book.class) {
            bookImp.delete((Book) object);
        }
        if (object.getClass() == Genre.class) {
            genreImp.delete((Genre) object);
        }
    }
    public void addSomeBook(){
        Book book =new Book("book");

        for (int i=0;i<10;i++){
            book.getArrayList().add(new Genre("genre"));
        }
        bookImp.add(book);
    }
    public void DeleteAll(){
        ArrayList<Book>  arrayList=  (ArrayList<Book> )bookImp.CriteriaList();
        for (Object o :arrayList){
            delete(o);
        }
    }


}
