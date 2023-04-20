package jpg.iescierva.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jpg.iescierva.persistencia.model.dto.AlumnoDTO;
import jpg.iescierva.persistencia.model.dto.MatriculaDTO;
import jpg.iescierva.persistencia.util.PropertiesUtilSingleton;

public class MatriculaMysqlImpl implements MatriculaDAO {

	@Override
	public void crear(MatriculaDTO matricula) {

		String query = "INSERT INTO `alumno`() VALUES (?,?,?)";
		
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

		
		
	}

	@Override
	public void eliminar(MatriculaDTO matricula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MatriculaDTO consultar(int nre) {

		String query = "SELECT * FROM `MATRICULA` WHERE ID_MATRICULA = ?";
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
					rs.getString("NRE"),
					rs.getString("CURSO"),
					rs.getString("TITULACION"));
			
			matricula.setId_matricula(rs.getInt("ID_MATRICULA"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return matricula;
	}

	@Override
	public List<MatriculaDTO> consultarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
