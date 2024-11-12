package classes;
import java.util.ArrayList;
import java.util.List;

public class Member extends Person{
    private int memberID;
    private List<Book> borrowedBooks;

    //Constructor
    public Member(String name, int age, String address, int memberId){
        super(name, age, address);
        this.memberID = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    //Getter
    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    //Method
    public void borrowBook(Book book){
        if(!borrowedBooks.contains(book) && book.getAvailableCopies() > 0){
            borrowedBooks.add(book);
            book.borrowBook();
            System.out.println("Borrowed Book");
        }else{
            System.out.println("No book available");
        }
    }

    public void returnBook(Book book){
        if(borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            book.returnBook();
            System.out.println("Returned book");
        }else{
            System.out.println("No book in your list");
        }
    }
}
