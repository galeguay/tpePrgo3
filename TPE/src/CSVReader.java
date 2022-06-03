import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "dataset4.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            Library b = new Library();
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                b.addBook(items);
            }
            //PEDIR POR CONSOLA EL GENERO A FILTRAR
            Scanner sc = new Scanner(System.in);
            String genero = sc.nextLine();
            //String genero = "thriller";
            //long startTime = System.nanoTime();
            ArrayList listaFiltrada = b.getFilterBooks(genero);
            //long endTime = System.nanoTime();
            //System.out.println("Tiempo inicial: "+startTime);
			//System.out.println("Tiempo Final: "+endTime);
            CSVWritter writter = new CSVWritter();
            writter.writeNewFile(listaFiltrada);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}