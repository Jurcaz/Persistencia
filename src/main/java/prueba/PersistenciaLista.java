package prueba;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PersistenciaLista {


	//Lista de nombres
	public static ArrayList<ClaseSerializable> datos = new ArrayList<>();

	public static void main(String[] args) {

		cargarDatosPrueba();
		guardarDatos();             //en fichero
		recuperarDatos();           //desde fichero
		System.out.println(ListarDatos());
	}

	/**
	 *  Carga datos de prueba.
	 */
	public static void cargarDatosPrueba() {
		//datos de prueba
		datos.add(new ClaseSerializable("Bernardino", 18, "Sánchez", 1.87f, 44, 55));
		datos.add(new ClaseSerializable("Ángel", 18, "Juliá", 1.84f, 45, 4000));
		datos.add(new ClaseSerializable("Francisco", 18, "Bartolomé", 1.85f, 44, 6000));
		datos.add(new ClaseSerializable("Daniel", 23, "Caballero", 1.73f, 42, 350000));
	}

	/**
	 *  Lista los datos.
	 *  @return String con los datos
	 */
	public static String ListarDatos() {

		StringBuilder aux = new StringBuilder();
		// Recorre la lista de datos.
		for (ClaseSerializable n: datos) {
			aux.append(n.getNombre() + " ");
			aux.append(n.getApellido1() + " ");
			aux.append(n.getAltura() + " ");
			aux.append(n.getSaldo() + "\n");

		}
		return aux.toString();
	}

	// Persistencia de objetos de una lista serializados en ficheros.

	/**
	 *  Guarda el arraylist de objetos nombresNombre en el fichero.
	 */
	public static void guardarDatos() {

		try {
			//1º
			// Configurar el fichero local de salida.
			FileOutputStream fNombres =
					new FileOutputStream("nombres.dat");

			//2º
			// Configurar el flujo de datos (stream) de salida.
			ObjectOutputStream osNombres =
					new ObjectOutputStream(fNombres);

			//3º
			// Volcar el arrayList al fichero.
			osNombres.writeObject(datos);

			osNombres.flush();          //vacía buffer
			osNombres.close();          //cierra flujo (stream)
			fNombres.close();           //cierra fichero

		} //try

		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Archivo " + "nombres.dat"
					+ " no encontrado");
		}
		catch (EOFException e) {
			e.printStackTrace();
			System.out.println("Fin de fichero");
		}
		catch (IOException eio) {
			eio.printStackTrace();
			System.out.println("Error de entrada/salida");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error general");
		}
		finally {
		}
	}

	/**
	 *  Recupera el arraylist de objetos Nombre almacenados en fichero.
	 */
	public static void recuperarDatos() {
		try {
			//Previo
			//Limpiar el ArrayList de posible basura
			datos.clear();

			//1º
			//Configurar el fichero de entrada
			FileInputStream fNombres =
					new FileInputStream("nombres.dat");

			//2º
			//Configurar el flujo de datos (stream) de entrada
			ObjectInputStream isNombres =
					new ObjectInputStream(fNombres);

			//3º
			//Cargar el arrayList desde el fichero
			datos = (ArrayList<ClaseSerializable>) isNombres.readObject();

			isNombres.close();             //cierra flujo (stream)
			fNombres.close();              //cierra fichero

		} //try

		catch (FileNotFoundException enf) {
			enf.printStackTrace();
			System.out.println("Archivo " + "nombres.dat"
					+ " no encontrado");
		}
		catch (EOFException eef) {
			eef.printStackTrace();
			System.out.println("Fin de fichero");
		}
		catch (IOException eio) {
			eio.printStackTrace();
			System.out.println("Error de entrada/salida");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error general");
		}
		finally {
		}
	}

} //class
