package Modelo;

public class dto {

	private long cedula;
	private String email;
	private String nombre;	
	private String clave;
	private String usuario;
	
	public dto(long cedula, String email, String nombre, String clave, String usuario) {
		
		this.cedula = cedula;
		this.email = email;
		this.nombre = nombre;
		this.clave = clave;
		this.usuario = usuario;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}	

}
