package jpg.iescierva.persistencia.dao;

import java.util.List;

import jpg.iescierva.persistencia.model.dto.MatriculaDTO;

public interface MatriculaDAO {
	public void crear(MatriculaDTO matricula);
	public void actualizar(MatriculaDTO matricula);
	public void eliminar(MatriculaDTO matricula);
	public MatriculaDTO consultar(int nre);
	public List<MatriculaDTO> consultarTodo();
}
