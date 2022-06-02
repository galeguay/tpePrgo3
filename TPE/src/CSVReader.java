import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "dataset1 copy.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            Library b = new Library();
        
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                b.addBook(items);

                //TESTEOS
                System.out.print("ITEMS LIBRO: ");
                for (int i = 0; i < items.length; i++) {
                    System.out.print(items[i] + ", ");
                }



                /*
                for(int i=0; i< items.length; i++){
                    System.out.println(items.length);
                }
                */
                // ---------------------------------------------
                // Poner el codigo para cargar los datos
                // ---------------------------------------------
            
            }
            System.out.println("");
            System.out.println("ARBOL:");
            b.printGenresTree();

            //PREGUNTAR AL USUARIO EL GENERO
            //b.getFilterBooks(genero);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}