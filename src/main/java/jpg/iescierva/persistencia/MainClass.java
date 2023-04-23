package jpg.iescierva.persistencia;

import java.sql.Date;
import java.util.Scanner;

import jpg.iescierva.persistencia.dao.AlumnoDAO;
import jpg.iescierva.persistencia.dao.AlumnoMysqlImpl;
import jpg.iescierva.persistencia.dao.MatriculaDAO;
import jpg.iescierva.persistencia.dao.MatriculaMysqlImpl;
import jpg.iescierva.persistencia.database.mysql.AlumnoDB;
import jpg.iescierva.persistencia.model.dto.AlumnoDTO;
import jpg.iescierva.persistencia.model.dto.MatriculaDTO;

public class MainClass {

	public static void main(String[] args) {
		
		MatriculaDAO matriculaDAO = new MatriculaMysqlImpl();
		
		matriculaDAO.crear(new MatriculaDTO("121552", "2", "dam"));
		
		for (MatriculaDTO m : matriculaDAO.consultarTodo()) {
			System.out.println(m.toString());
		}
		

		
//		AlumnoDAO alumnoDAO = new AlumnoMysqlImpl();
//		Scanner sc = new Scanner(System.in);
//		int aux;
//		
//		System.out.println("Que operacion quiere realizar?");
//		
//		do {
//			aux = 0;
//			System.out.println("1. Crear usuario, 2. Actualizar usuario, 3. Eliminar usuario, 4. Consultar usuario");
//			aux = sc.nextInt();
//			switch (aux) {
//			case 1:
//				System.out.println("Introduzca nre");
//				
//				break;
//			case 2:
//				System.out.println(2);			
//				break;
//			case 3:
//				System.out.println(3);
//				break;
//			case 4:
//				System.out.println(4);
//				break;
//			case 5:
//				System.out.println(5);
//				break;
//			default:
//				break;
//			}
//			
//		} while (aux != 6);
		
		
//		AlumnoDTO alumno1 = new AlumnoDTO("12234", "Piqueras", "Pedro", "asdas@ds.cock", "2", "b", "c", new Date(1999, 1, 1), "los ramos", "222222222", "222222222");
//
//		alumnoDAO.crear(alumno1);
//		
//		for (AlumnoDTO x : alumnoDAO.consultarTodo()) {
//			System.out.println(x.toString());
//		}
//		
//		alumnoDAO.eliminar(alumno1);
		
	}
}
