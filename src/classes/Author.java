package classes;
import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    private int authorId;
    private List<Book> books;

    //Constructor w/ parameters, inheriting from Person Class
    public Author(String name, int age, String address, int authorId) {
        super(name, age, address);
        this.authorId = authorId;
        this.books = new ArrayList<>();
    }

    //Getter
    public int getAuthorId(){
        return authorId;
    }

    //Methods
    public void addBook(Book book){
        if(!books.contains(book)){
            books.add(book);
        }
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public List<Book> getBooks(){
        return books;
    }
}
