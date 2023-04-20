package jpg.iescierva.persistencia.model.dto;

import java.sql.Date;

public class AlumnoDTO {
	private String nre;
	private String apellidos;
	private String nombre;
	private String email;
	private String piso;
	private String escalera;
	private String letra;
	private Date fecha_nac;
	private String localidad;
	private String tlf1;
	private String tlf2;


	public AlumnoDTO(String nre, String apellidos, String nombre, String email, String piso, String escalera,
			String letra, Date fecha_nac, String localidad, String tlf1, String tlf2) {
		super();
		this.nre = nre;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.email = email;
		this.piso = piso;
		this.escalera = escalera;
		this.letra = letra;
		this.fecha_nac = fecha_nac;
		this.localidad = localidad;
		this.tlf1 = tlf1;
		this.tlf2 = tlf2;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AlumnoDTO [nre=");
		builder.append(nre);
		builder.append(", apellidos=");
		builder.append(apellidos);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", email=");
		builder.append(email);
		builder.append(", piso=");
		builder.append(piso);
		builder.append(", escalera=");
		builder.append(escalera);
		builder.append(", letra=");
		builder.append(letra);
		builder.append(", fecha_nac=");
		builder.append(fecha_nac);
		builder.append(", localidad=");
		builder.append(localidad);
		builder.append(", tlf1=");
		builder.append(tlf1);
		builder.append(", tlf2=");
		builder.append(tlf2);
		builder.append("]");
		return builder.toString();
	}


	public String getNre() {
		return nre;
	}


	public void setNre(String nre) {
		this.nre = nre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPiso() {
		return piso;
	}


	public void setPiso(String piso) {
		this.piso = piso;
	}


	public String getEscalera() {
		return escalera;
	}


	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}


	public String getLetra() {
		return letra;
	}


	public void setLetra(String letra) {
		this.letra = letra;
	}


	public Date getFecha_nac() {
		return fecha_nac;
	}


	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getTlf1() {
		return tlf1;
	}


	public void setTlf1(String tlf1) {
		this.tlf1 = tlf1;
	}


	public String getTlf2() {
		return tlf2;
	}


	public void setTlf2(String tlf2) {
		this.tlf2 = tlf2;
	}

}
