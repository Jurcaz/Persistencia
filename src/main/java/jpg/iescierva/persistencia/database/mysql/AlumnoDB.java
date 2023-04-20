package jpg.iescierva.persistencia.database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jpg.iescierva.persistencia.model.dto.AlumnoDTO;
import jpg.iescierva.persistencia.util.PropertiesUtilSingleton;

public class AlumnoDB {

	public List<AlumnoDTO> findAll () {
		List <AlumnoDTO> alumnos = new ArrayList<>();


		try (Connection conn = DriverManager.getConnection(
				PropertiesUtilSingleton.getInstance().getConnectionString(),
				PropertiesUtilSingleton.getInstance().getDatabaseUser(),
				PropertiesUtilSingleton.getInstance().getDatabasePass()
				);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM alumno;");){

			while (rs.next()) {
				AlumnoDTO alumno = new AlumnoDTO(
						rs.getString("nre"),
						rs.getString("apellidos"),
						rs.getString("nombre"),
						rs.getString("email"),
						rs.getString("piso"), 
						rs.getString("escalera"),
						rs.getString("letra"), 
						rs.getDate("fecha_nac"), 
						rs.getString("localidad"),
						rs.getString("tlf1"), 
						rs.getString("tlf1"));
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnos;
	}

	public AlumnoDTO findByKey (String nre) {
		AlumnoDTO alumno = null;

		try (Connection conn = DriverManager.getConnection(
				PropertiesUtilSingleton.getInstance().getConnectionString(),
				PropertiesUtilSingleton.getInstance().getDatabaseUser(),
				PropertiesUtilSingleton.getInstance().getDatabasePass()
				);
			Statement stm = conn.createStatement ();
			ResultSet rs = stm.executeQuery("SELECT * FROM alumno WHERE nre='"+nre+"';");){
			rs.next();
			alumno = new AlumnoDTO(
						rs.getString("nre"),
						rs.getString("apellidos"), 
						rs.getString("nombre"),
						rs.getString("email"), 
						rs.getString("piso"), 
						rs.getString("escalera"),
						rs.getString("letra"), 
						rs.getDate("fecha_nac"),
						rs.getString("localidad"),
						rs.getString("tlf1"), 
						rs.getString("tlf1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumno;
	}

}
