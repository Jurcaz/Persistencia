package prueba;

import java.io.Serializable;

public class ClaseSerializable implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public float getAltura() {
		return altura;
	}


	public void setAltura(float altura) {
		this.altura = altura;
	}


	public int getTalla() {
		return talla;
	}


	public void setTalla(int talla) {
		this.talla = talla;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	private String nombre;
	private String apellido1;
	private transient int edad;
	private transient float altura;
	private transient int talla;
	private transient double saldo;


	public ClaseSerializable(String nombre, int edad, String apellido1, float altura, int talla, double saldo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.apellido1 = apellido1;
		this.altura = altura;
		this.talla = talla;
		this.saldo = saldo;
	}



}
