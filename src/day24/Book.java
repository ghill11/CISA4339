package day24;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private String genre;
	private int pages;
	private int yearPublished;

	public Book(String title, String author, String isbn, String genre, int pages, int yearPublished) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.genre = genre;
		this.pages = pages;
		this.yearPublished = yearPublished;
	} // end ctor

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", genre=" + genre + ", pages="
				+ pages + ", yearPublished=" + yearPublished + "]";
	} // end toString
} // end Book