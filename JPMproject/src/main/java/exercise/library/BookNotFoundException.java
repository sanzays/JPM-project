package exercise.library;

public class BookNotFoundException extends Exception
{
    public BookNotFoundException(String message) {

        super(message);
    }

    public BookNotFoundException(){

        super("Book not found");
    }
}
