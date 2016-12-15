package com.gestor.web.jdbc;

public class User {
	
	private int id;
	private String nombre;
	private String paternoApellido;
	private String maternoApellido;
	private String edad;
	private String ingresoMensual;
	private String email;
	
	
	public User(String nombre, String paternoApellido, String maternoApellido, String edad, String ingresoMensual,
			String email) {
		this.nombre = nombre;
		this.paternoApellido = paternoApellido;
		this.maternoApellido = maternoApellido;
		this.edad = edad;
		this.ingresoMensual = ingresoMensual;
		this.email = email;
	}


	public User(int id, String nombre, String paternoApellido, String maternoApellido, String edad,
			String ingresoMensual, String email) {
		this.id = id;
		this.nombre = nombre;
		this.paternoApellido = paternoApellido;
		this.maternoApellido = maternoApellido;
		this.edad = edad;
		this.ingresoMensual = ingresoMensual;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPaternoApellido() {
		return paternoApellido;
	}


	public void setPaternoApellido(String paternoApellido) {
		this.paternoApellido = paternoApellido;
	}


	public String getMaternoApellido() {
		return maternoApellido;
	}


	public void setMaternoApellido(String maternoApellido) {
		this.maternoApellido = maternoApellido;
	}


	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad = edad;
	}


	public String getIngresoMensual() {
		return ingresoMensual;
	}


	public void setIngresoMensual(String ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", paternoApellido=" + paternoApellido + ", maternoApellido="
				+ maternoApellido + ", edad=" + edad + ", ingresoMensual=" + ingresoMensual + ", email=" + email + "]";
	}

	
}
