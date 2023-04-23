package jpg.iescierva.persistencia.model.dto;

public class MatriculaDTO {
	private int id_matricula;
	private String nre;
	private String curso;
	private String titulacion;
	
	public MatriculaDTO(String pNre, String pCurso, String pTitulacion) {
		this.nre = pNre;
		this.curso = pCurso;
		this.titulacion = pTitulacion;
	}
	
	public MatriculaDTO(int pIdMatricula, String pNre, String pCurso, String pTitulacion) {
		this.id_matricula = pIdMatricula;
		this.nre = pNre;
		this.curso = pCurso;
		this.titulacion = pTitulacion;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MatriculaDTO [id_matricula=");
		builder.append(id_matricula);
		builder.append(",nre=");
		builder.append(nre);
		builder.append(",curso=");
		builder.append(curso);
		builder.append(",titulacion=");
		builder.append(titulacion);
		builder.append("]");
		
		return builder.toString();
	}

	public int getId_matricula() {
		return id_matricula;
	}

	public void setId_matricula(int id_matricula) {
		this.id_matricula = id_matricula;
	}

	public String getNre() {
		return nre;
	}

	public void setNre(String nre) {
		this.nre = nre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

}
