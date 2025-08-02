public class Book implements LendingMedia {
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String publisher;
    private int yearPublished;
    private boolean availabilty;
    public Book(String title, String authorFirstName, String authorLastName, String publisher, int yearPublished) {
        this.title= title;
        this.authorFirstName= authorFirstName;
        this.authorLastName = authorLastName;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.availabilty = true;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthorFirstName(){
        return authorFirstName;
    }
    public String getAuthorLastName() {
        return authorLastName;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public String getPublihser() {
        return publisher;
    }
    public boolean isAvailable() {
        return availabilty;
    }
    public String toString() {
        return authorFirstName + ", " + authorFirstName + ". " + title + ", " + publisher + ", " + yearPublished + ".";
    }
}