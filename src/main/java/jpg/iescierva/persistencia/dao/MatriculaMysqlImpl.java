package jpg.iescierva.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jpg.iescierva.persistencia.model.dto.AlumnoDTO;
import jpg.iescierva.persistencia.model.dto.MatriculaDTO;
import jpg.iescierva.persistencia.util.PropertiesUtilSingleton;

public class MatriculaMysqlImpl implements MatriculaDAO {

	@Override
	public void crear(MatriculaDTO matricula) {

		String query = "INSERT INTO `matricula`(`nre`, `curso`, `titulacion`) VALUES (?,?,?)";
		
		try {
			Connection conn = DriverManager.getConnection(
					PropertiesUtilSingleton.getInstance().getConnectionString(),
					PropertiesUtilSingleton.getInstance().getDatabaseUser(),
					PropertiesUtilSingleton.getInstance().getDatabasePass()
					);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			preparedStmt.setString(1, matricula.getNre());
			preparedStmt.setString(2, matricula.getCurso());
			preparedStmt.setString(3, matricula.getTitulacion());
			
			preparedStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizar(MatriculaDTO matricula) {

		String query = "UPDATE `matricula` "
				+ "SET nre=?,curso=?,titulacion=? "
				+ "WHERE idMatricula = "+matricula.getId_matricula();
		
		try {
			Connection conn = DriverManager.getConnection(
					PropertiesUtilSingleton.getInstance().getConnectionString(),
					PropertiesUtilSingleton.getInstance().getDatabaseUser(),
					PropertiesUtilSingleton.getInstance().getDatabasePass()
					);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			preparedStmt.setString(1, matricula.getNre());
			preparedStmt.setString(2, matricula.getCurso());
			preparedStmt.setString(3, matricula.getTitulacion());
			
			preparedStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminar(MatriculaDTO matricula) {

		String query = "DELETE FROM `matricula` WHERE idMatricula = ?";
		
		try {
			Connection conn = DriverManager.getConnection(
					PropertiesUtilSingleton.getInstance().getConnectionString(),
					PropertiesUtilSingleton.getInstance().getDatabaseUser(),
					PropertiesUtilSingleton.getInstance().getDatabasePass()
					);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			preparedStmt.setInt(1, matricula.getId_matricula());
			
			preparedStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public MatriculaDTO consultar(int nre) {

		String query = "SELECT * FROM `matricula` WHERE idMatricula = ?";
		MatriculaDTO matricula = null;
		
		try {
			Connection conn = DriverManager.getConnection(
					PropertiesUtilSingleton.getInstance().getConnectionString(),
					PropertiesUtilSingleton.getInstance().getDatabaseUser(),
					PropertiesUtilSingleton.getInstance().getDatabasePass()
					);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			preparedStmt.setInt(1, nre);
			
			ResultSet rs = preparedStmt.executeQuery();
			rs.next();
			
			matricula = new MatriculaDTO(
					rs.getString("nre"),
					rs.getString("curso"),
					rs.getString("titulacion"));
			
			matricula.setId_matricula(rs.getInt("idMatricula"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return matricula;
	}

	@Override
	public List<MatriculaDTO> consultarTodo() {

		String query = "SELECT * FROM `matricula`";
		MatriculaDTO matricula = null;
		List <MatriculaDTO> matriculas = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(
					PropertiesUtilSingleton.getInstance().getConnectionString(),
					PropertiesUtilSingleton.getInstance().getDatabaseUser(),
					PropertiesUtilSingleton.getInstance().getDatabasePass()
					);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			ResultSet rs = preparedStmt.executeQuery();
			
			while (rs.next()) {
				matricula = new MatriculaDTO(
						rs.getInt("idMatricula"), 
						rs.getString("nre"), 
						rs.getString("curso"), 
						rs.getString("titulacion"));

				matriculas.add(matricula);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matriculas;
	}

	

}
