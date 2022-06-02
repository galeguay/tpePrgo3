import java.util.ArrayList;

public class Library {
    private TreeWithNode genresTree; //hacer nodo
    private ArrayList<Book> books;


    public Library() {
        this.books = new ArrayList<>();
        this.genresTree = new TreeWithNode();
    }


    public void addBook(String[] book){
        //SE GENERA UNA ARREGLO DE STRING CON LOS GENEROS A LOS QUE PERTENCE EL LIBRO
        String[] genresOfBook = book[3].split(" ");
        
        //SE CREA EL OBJETO LIBRO Y SE GUARDA EN EL ARREGLO DE LIBROS
        Book b = new Book(book[0],book[1],Integer.parseInt(book[2]), genresOfBook);
        books.add(b);

        //SE AGREGA EL LIBRO A LA LISTA DE CADA GENERO AL QUE PERTENECE
        for (int i = 0; i < genresOfBook.length; i++) {
            System.out.println("");
            System.out.println("esta el genero? --"+genresTree.hasGenre(genresOfBook[i]));
            System.out.println("");

            genresTree.printInOrder();
            
            if (!genresTree.hasGenre(genresOfBook[i])){
                genresTree.add(genresOfBook[i]);
            }
            
            genresTree.printInOrder();

            TreeNode nodoGenero = genresTree.getGenre(genresOfBook[i]);
            System.out.println(nodoGenero);

            if(!nodoGenero.hasBook(b)){
                nodoGenero.addBook(books.indexOf(b)); // VER COSTO
            }
        }
    }

    public ArrayList<Book> obtenerLibrosFiltrados(String genero) {
        ArrayList<Book> listaFiltrada = new ArrayList<>();
        TreeNode nodoGenero = genresTree.getGenre(genero);
        if (nodoGenero != null){

        }
        return listaFiltrada;
    }

    public void printGenresTree(){
        //genresTree.printInOrder();
        genresTree.printPreOrder();
    }


}
