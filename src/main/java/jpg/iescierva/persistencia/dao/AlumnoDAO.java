package jpg.iescierva.persistencia.dao;

import java.util.List;

import jpg.iescierva.persistencia.model.dto.AlumnoDTO;

public interface AlumnoDAO {
	public void crear(AlumnoDTO alumno);
	public void actualizar(AlumnoDTO alumno);
	public void eliminar(AlumnoDTO alumno);
	public AlumnoDTO consultar(String nre);
	public List<AlumnoDTO> consultarTodo();
}
