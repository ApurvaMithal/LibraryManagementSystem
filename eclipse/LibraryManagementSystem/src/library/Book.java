package library;

public class Book {
	private String isbn;
	private String title;
	private String name;
	private String availability;
	public Book(String isbn, String title, String name, String availability){
		this.isbn = isbn;
		this.title = title;
		this.name = name;
		this.availability = availability;
	}
	public Book(){
		
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getAvailability() {
		return availability;
	}
	
}

