package classes;

public class Book{
    private String title;
    private Author author;
    private String ISBN;
    private String publicationDate;
    private int availableCopies;

    //Constructor
    public Book(String title, Author author, String ISBN, String publicationDate, int availableCopies){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationDate = publicationDate;
        this.availableCopies = availableCopies;
    }

    //Getters
    public String getTitle(){
        return title;
    }

    public Author getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }

    public String getPublicationDate(){
        return publicationDate;
    }

    public int getAvailableCopies(){
        return availableCopies;
    }

    //Setter
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public void setPublicationDate(String publicationDate){
        this.publicationDate = publicationDate;
    }

    public void setAvailableCopies(int availableCopies){
        this.availableCopies = availableCopies;
    }

    //Methods
    public void borrowBook(){
        if(availableCopies > 0){
            availableCopies--;
        }else{
            System.out.println("No Available Copies to Borrow");
        }
    }

    public void returnBook(){
        availableCopies++;
    }
}
