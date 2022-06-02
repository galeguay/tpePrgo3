import java.util.ArrayList;
import java.util.LinkedList;

public class Library {
    private TreeWithNode genresTree; // hacer nodo
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
        this.genresTree = new TreeWithNode();
    }

    public void addBook(String[] book) {
        // SE GENERA UNA ARREGLO DE STRING CON LOS GENEROS A LOS QUE PERTENCE EL LIBRO
        String[] genresOfBook = book[3].split(" ");

        // SE CREA EL OBJETO LIBRO Y SE GUARDA EN EL ARREGLO DE LIBROS
        Book b = new Book(book[0], book[1], Integer.parseInt(book[2]), genresOfBook);
        books.add(b);

        // SE AGREGA EL LIBRO A LA LISTA DE CADA GENERO AL QUE PERTENECE
        for (int i = 0; i < genresOfBook.length; i++) {

            if (!genresTree.hasGenre(genresOfBook[i])) {
                genresTree.add(genresOfBook[i]);
            }

            TreeNode nodoGenero = genresTree.getGenre(genresOfBook[i]);
            if (!nodoGenero.hasIndexBook(books.indexOf(b))) {
                nodoGenero.addBook(books.indexOf(b)); // VER COSTO
            }
        }
    }

    public ArrayList<Book> getFilterBooks(String genero) {
        ArrayList<Book> listaFiltrada = new ArrayList<>();
        TreeNode nodoGenero = genresTree.getGenre(genero);
        if (nodoGenero != null) {
            LinkedList<Integer> a = nodoGenero.getbookIndexes();
            //System.out.println(a);
            for (int i = 0; i < a.size(); i++) {
                //System.out.println(a.get(i));
                int pos = a.get(i);
                Book b = books.get(pos);
                listaFiltrada.add(b);
            }
            for (Book b : listaFiltrada) {
                System.out.println(b.getTitulo());
            }
            
        }
        return listaFiltrada;
    }

    public void printGenresTree() {
        // genresTree.printInOrder();
        genresTree.printPreOrder();
    }

}
