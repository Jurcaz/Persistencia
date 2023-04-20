package jpg.iescierva.persistencia;

import java.sql.Date;

import jpg.iescierva.persistencia.dao.AlumnoDAO;
import jpg.iescierva.persistencia.dao.AlumnoMysqlImpl;
import jpg.iescierva.persistencia.database.mysql.AlumnoDB;
import jpg.iescierva.persistencia.model.dto.AlumnoDTO;

public class MainClass {

	public static void main(String[] args) {
		AlumnoDB alumnodb = new AlumnoDB();
//		AlumnoDTO alumnoDTO = alumnodb.findByKey("234510");
//		System.out.println(alumnoDTO.toString());
		
		

		AlumnoDAO alumnoDAO = new AlumnoMysqlImpl();
		
//		AlumnoDTO alumno1 = new AlumnoDTO("12234", "Piqueras", "Pedro", "asdas@ds.cock", "2", "b", "c", new Date(1999, 1, 1), "los ramos", "222222222", "222222222");
		
		for (AlumnoDTO x : alumnoDAO.consultarTodo()) {
			System.out.println(x.toString());
		}
		
		
	}

}
