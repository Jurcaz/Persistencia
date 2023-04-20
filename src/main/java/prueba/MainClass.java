package prueba;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainClass {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {

			 fos = new FileOutputStream("fichero.dat");
			FileInputStream fis = new FileInputStream("fichero.dat");

			ObjectOutputStream out = new ObjectOutputStream(fos);
			ObjectInputStream in = new ObjectInputStream(fis);

			ClaseSerializable o1 = new ClaseSerializable("Bernardino", 18, "Sánchez", 1.87f, 44, 55);
			ClaseSerializable o2 = new ClaseSerializable("Ángel", 18, "Juliá", 1.84f, 45, 4000);

			// Escribe el objeto serializado en el fichero
			out.writeObject(o1);
			out.writeObject(o2);
			// . . .

			// Lee bytes desde el fichero y deserializa en el mismo orden
			ClaseSerializable o3 = (ClaseSerializable) in.readObject();
			ClaseSerializable o4 = (ClaseSerializable) in.readObject();
			int kk =0;

		} catch (FileNotFoundException fnfe) {
		} catch (IOException ioe) { ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
		}


		 try (FileOutputStream fos2 = new FileOutputStream("fichero.dat");



				 )  {
			 	fos2.flush();
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}

}
