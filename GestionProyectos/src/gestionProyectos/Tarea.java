package gestionProyectos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tarea {
	int idTarea;
	int idProyecto;
	String nombre;
	String descripcion;
	EstadoTarea estado;
	LocalDate fechaLimite;
	Prioridad prioridad;
	List<Comentario> comentarios;
	
	public Tarea(int idProyecto, String nombre, String descripcion, LocalDate fechaLimite, Prioridad prioridad) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.prioridad = prioridad;
        this.estado = EstadoTarea.PENDIENTE;
        this.comentarios = new ArrayList<>();
    }
	
	public Tarea(int idProyecto,int idTarea, String nombre, String descripcion, LocalDate fechaLimite, Prioridad prioridad, EstadoTarea estado) {
        this.idProyecto = idProyecto;
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.prioridad = prioridad;
        this.estado = EstadoTarea.PENDIENTE;
        this.comentarios = new ArrayList<>();
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the estado
	 */
	public EstadoTarea getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaLimite
	 */
	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	/**
	 * @param fechaLimite the fechaLimite to set
	 */
	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	/**
	 * @return the prioridad
	 */
	public Prioridad getPrioridad() {
		return prioridad;
	}

	/**
	 * @param prioridad the prioridad to set
	 */
	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	/**
	 * @return the comentarios
	 */
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void agregarComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}
	
	public void eliminarComentario(Comentario comentario) {
		this.comentarios.remove(comentario);
	}
	
	public void listarComentarios() {
		for (Comentario comentario : comentarios) {
			System.out.println(comentario);
		}
	}
	
}
