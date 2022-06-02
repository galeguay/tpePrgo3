import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "dataset1.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            Library b = new Library();
        
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                b.addBook(items);
            }
            //System.out.println("");
            //System.out.println("ARBOL:");
            //b.printGenresTree();
            //PREGUNTAR AL USUARIO EL GENERO
            String genero = "psicolog�a";
            b.getFilterBooks(genero);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}