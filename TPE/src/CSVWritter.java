import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWritter {

	public void writeNewFile(ArrayList<Book> books) {
		BufferedWriter bw = null;
		try {
			File file = new File("salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (Book book : books) {
				String contenidoLinea1 = book.getTitulo();
				bw.write(contenidoLinea1);
				bw.newLine();
			}
			long endTime = System.nanoTime();
			System.out.println("Tiempo Final: "+endTime);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}