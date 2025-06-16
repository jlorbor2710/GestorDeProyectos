package gestionProyectos;

import java.time.LocalDateTime;

public class Comentario {
	int idComentario;
	int idTarea;
	int idUsuario;
	String contenido;
	LocalDateTime fecha;
	/**
	 * @param idComentario
	 * @param idTarea
	 * @param idUsuario
	 * @param contenido
	 * @param fecha
	 */
	public Comentario(int idTarea, int idUsuario, String contenido) {
        this.idTarea = idTarea;
        this.idUsuario = idUsuario;
        this.contenido = contenido;
        this.fecha = LocalDateTime.now();
    }
	/**
	 * @return the idComentario
	 */
	public int getIdComentario() {
		return idComentario;
	}
	/**
	 * @param idComentario the idComentario to set
	 */
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	/**
	 * @return the idTarea
	 */
	public int getIdTarea() {
		return idTarea;
	}
	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
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
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}
	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	/**
	 * @return the fecha
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
}
