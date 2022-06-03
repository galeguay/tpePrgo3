import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "dataset1.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            Library b = new Library();
            br.readLine();
            long startTime = System.nanoTime();
            System.out.println("Tiempo inicial: "+startTime);
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                b.addBook(items);
            }
            // PREGUNTAR AL USUARIO EL GENERO
            String genero = "thriller";
            ArrayList listaFiltrada = b.getFilterBooks(genero);
            CSVWritter writter = new CSVWritter();
            writter.writeNewFile(listaFiltrada);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}