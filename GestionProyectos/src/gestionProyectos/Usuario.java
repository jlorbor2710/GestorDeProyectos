package gestionProyectos;

public class Usuario {
	int idUsuario;
	String nombre;
	String apellido;
	String correo;
	String contrasena;
	Rol rol;
	
	public Usuario(int idUsuario, String nombre, String apellido, String correo, String contrasena, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }
	
	public Usuario(String nombre, String apellido, String correo, String contrasena, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public boolean verificarCredenciales(String correo, String contrasena) {
		if (this.correo.equals(correo) && this.contrasena.equals(contrasena)) {
			return true;
		}
		return false;
	}
	
	public void actualizarPerfil(String nombre, String apellido, String contrasena) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contrasena;
	}
	
	public boolean cambiarContrasena(String contrasenaActual, String nuevaContrasena) {
		if (this.contrasena.equals(contrasenaActual)) {
			this.contrasena = nuevaContrasena;
			return true;
		}
		return false;
	}

}
