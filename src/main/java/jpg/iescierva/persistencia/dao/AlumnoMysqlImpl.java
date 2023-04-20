package jpg.iescierva.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jpg.iescierva.persistencia.model.dto.AlumnoDTO;
import jpg.iescierva.persistencia.util.PropertiesUtilSingleton;

public class AlumnoMysqlImpl implements AlumnoDAO {

	@Override
	public void crear(AlumnoDTO alumno) {

		String query = "INSERT INTO `alumno`() VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Connection conn = DriverManager.getConnection(
					PropertiesUtilSingleton.getInstance().getConnectionString(),
					PropertiesUtilSingleton.getInstance().getDatabaseUser(),
					PropertiesUtilSingleton.getInstance().getDatabasePass()
					);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			preparedStmt.setString(1, alumno.getNre());
			preparedStmt.setString(2, alumno.getApellidos());
			preparedStmt.setString(3, alumno.getNombre());
			preparedStmt.setString(4, alumno.getEmail());
			preparedStmt.setString(5, alumno.getPiso());
			preparedStmt.setString(6, alumno.getEscalera());
			preparedStmt.setString(7, alumno.getLetra());
			preparedStmt.setDate(8, alumno.getFecha_nac());
			preparedStmt.setString(9, alumno.getLocalidad());
			preparedStmt.setString(10, alumno.getTlf1());
			preparedStmt.setString(11, alumno.getTlf2());
			
			preparedStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
	}

	@Override
	public void actualizar(AlumnoDTO alumno) {
		
		String query = "UPDATE `alumno` "
				+ "SET apellidos=?,nombre=?,email=?,piso=?,escalera=?,letra=?,fecha_nac=?,localidad=?,tlf1=?,tlf2=? "
				+ "WHERE nre = "+alumno.getNre();
		
		try {
			Connection conn = DriverManager.getConnection(
					PropertiesUtilSingleton.getInstance().getConnectionString(),
					PropertiesUtilSingleton.getInstance().getDatabaseUser(),
					PropertiesUtilSingleton.getInstance().getDatabasePass()
					);
			PreparedStatement preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, alumno.getApellidos());
			preparedStmt.setString(2, alumno.getNombre());
			preparedStmt.setString(3, alumno.getEmail());
			preparedStmt.setString(4, alumno.getPiso());
			preparedStmt.setString(5, alumno.getEscalera());
			preparedStmt.setString(6, alumno.getLetra());
			preparedStmt.setDate(7, alumno.getFecha_nac());
			preparedStmt.setString(8, alumno.getLocalidad());
			preparedStmt.setString(9, alumno.getTlf1());
			preparedStmt.setString(10, alumno.getTlf2());
			
			preparedStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void eliminar(AlumnoDTO alumno) {

		String query = "DELETE FROM `alumno` WHERE nre = ?";
		
		try {
			Connection conn = DriverManager.getConnection(
					PropertiesUtilSingleton.getInstance().getConnectionString(),
					PropertiesUtilSingleton.getInstance().getDatabaseUser(),
					PropertiesUtilSingleton.getInstance().getDatabasePass()
					);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			preparedStmt.setString(1, alumno.getNre());
			
			preparedStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public AlumnoDTO consultar(String nre) {

		String query = "SELECT * FROM `alumno` WHERE nre = ?";
		AlumnoDTO alumno = null;
		
		try {
			Connection conn = DriverManager.getConnection(
					PropertiesUtilSingleton.getInstance().getConnectionString(),
					PropertiesUtilSingleton.getInstance().getDatabaseUser(),
					PropertiesUtilSingleton.getInstance().getDatabasePass()
					);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			preparedStmt.setString(1, nre);
			
			ResultSet rs = preparedStmt.executeQuery();
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
			e.printStackTrace();
		}
		
		return alumno;
	}

	@Override
	public List<AlumnoDTO> consultarTodo() {

		String query = "SELECT * FROM `alumno`";
		AlumnoDTO alumno = null;
		List <AlumnoDTO> alumnos = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(
					PropertiesUtilSingleton.getInstance().getConnectionString(),
					PropertiesUtilSingleton.getInstance().getDatabaseUser(),
					PropertiesUtilSingleton.getInstance().getDatabasePass()
					);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			ResultSet rs = preparedStmt.executeQuery();
			
			while (rs.next()) {
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
				alumnos.add(alumno);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alumnos;
	}

}
