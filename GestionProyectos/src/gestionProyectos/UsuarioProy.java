package gestionProyectos;

import java.time.LocalDateTime;

public class UsuarioProy {
	int idUsuario;
	int idProyecto;
	Rol rolAsignado;
	LocalDateTime fechaAsignacion;
	public UsuarioProy(int idUsuario, int idProyecto, Rol rolAsignado) {
	    this.idUsuario = idUsuario;
	    this.idProyecto = idProyecto;
	    this.rolAsignado = rolAsignado;
	    this.fechaAsignacion = LocalDateTime.now();
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
	 * @return the idProyecto
	 */
	public int getIdProyecto() {
		return idProyecto;
	}
	/**
	 * @param idProyecto the idProyecto to set
	 */
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	/**
	 * @return the rolAsignado
	 */
	public Rol getRolAsignado() {
		return rolAsignado;
	}
	/**
	 * @param rolAsignado the rolAsignado to set
	 */
	public void setRolAsignado(Rol rolAsignado) {
		this.rolAsignado = rolAsignado;
	}
	/**
	 * @return the fechaAsignacion
	 */
	public LocalDateTime getFechaAsignacion() {
		return fechaAsignacion;
	}
	/**
	 * @param fechaAsignacion the fechaAsignacion to set
	 */
	public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	
}
