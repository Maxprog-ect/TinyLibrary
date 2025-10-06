package products;

/**
 * a concrete product products.CD that implements products.LoanableItem
 * @author Mackenzie
 * @version 1
 */
public class CD implements LoanableItem {
    private String dueDate; //due date of the object
    private final String albumName; // name of album
    private final String artist; // album's artist
    private boolean borrowed; // boolean storing availability

    /**
     *
     * @param albumName sets the name of the album
     * @param artist sets the artist of the album
     * @param dueDate sets the due date fpr the album
     */
    public CD(String albumName, String artist, String dueDate) {
        this.albumName = albumName;
        this.artist = artist;
        this.dueDate = dueDate;
        borrowed = false;
    }

    /**
     *
     * @return the due date
     */
    @Override
    public String getDueDate() { return dueDate;}

    /**
     * displays the info of the products.CD object
     */
    @Override
    public void displayInfo() {
        System.out.println("Album name: " + albumName);
        System.out.println("Artist: " + artist);
        System.out.println("Due date: " + dueDate);
        if (borrowed) {System.out.println("Borrowed" + '\n');}
        else {System.out.println("Available" + '\n');}
    }

    /**
     *
     * @return the availability of the products.CD
     */
    @Override
    public boolean isAvailable() {
        return !borrowed;
    }

    /**
     *
     * @param borrowed a boolean providing the new state of the availability
     */
    @Override
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
