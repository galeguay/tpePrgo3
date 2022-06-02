import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String csvFile = "dataset1.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);
                for(int i=0; i< items.length; i++){
                    System.out.println(items[i]);
                }
                // ---------------------------------------------
                // Poner el codigo para cargar los datos
                // ---------------------------------------------

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
