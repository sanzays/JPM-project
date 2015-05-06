package exercise.library;

public interface BookRepository {
	Book retrieveBook(String isbn) throws BookNotFoundException, BookNameNotCorrectException;
	public String getBookSummary(String isbn) throws BookNotFoundException, BookNameNotCorrectException;
}
