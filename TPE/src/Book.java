public class Book {

	private String title;
	private String author;
	private int pages;
	private String[] genres;
	
	public Book(String titulo, String autor, int paginas, String[] generos) {
		super();
		this.title = titulo;
		this.author = autor;
		this.pages = paginas;
		this.genres = generos;
	}

	@Override
	public String toString() {
		return this.title + this.author + this.pages + this.genres;
	}

}
