package gestionProyectos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	int idProyecto;
	String nombre;
	String descripcion;
	LocalDate fechaInicio;
	LocalDate fechaFin;
	EstadoProyecto estado;
	List<Tarea> tareas;
	List<UsuarioProy> miembros;
	
	 public Proyecto(int idProyecto, String nombre, String descripcion, LocalDate fechaIni, LocalDate fechaFin, EstadoProyecto estado) {
	        this.idProyecto = idProyecto;
	        this.nombre = nombre;
	        this.descripcion = descripcion;
	        this.fechaInicio = fechaIni;
	        this.fechaFin = fechaFin;
	        this.estado = estado;
	        this.tareas = new ArrayList<>();
	        this.miembros = new ArrayList<>();
	    }
	 
	 public Proyecto(String nombre, String descripcion, LocalDate fechaIni, LocalDate fechaFin) {
	        this.nombre = nombre;
	        this.descripcion = descripcion;
	        this.fechaInicio = fechaIni;
	        this.fechaFin = fechaFin;
	        this.estado = EstadoProyecto.PENDIENTE;
	        this.tareas = new ArrayList<>();
	        this.miembros = new ArrayList<>();
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
	 * @return the fechaInicio
	 */
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the estado
	 */
	public EstadoProyecto getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoProyecto estado) {
		this.estado = estado;
	}

	/**
	 * @return the tareas
	 */
	public List<Tarea> getTareas() {
		return tareas;
	}

	/**
	 * @param tareas the tareas to set
	 */
	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	/**
	 * @return the miembros
	 */
	public List<UsuarioProy> getMiembros() {
		return miembros;
	}

	/**
	 * @param miembros the miembros to set
	 */
	public void setMiembros(List<UsuarioProy> miembros) {
		this.miembros = miembros;
	}
	
	public void agregarTarea(Tarea tarea) {
		this.tareas.add(tarea);
	}
	
	public void eliminarTarea(Tarea tarea) {
		this.tareas.remove(tarea);
	}
	public void asignarMiembro(UsuarioProy miembro, Rol rol) {
			if (!miembros.contains(miembro)) {
			miembro.setRolAsignado(rol);
			this.miembros.add(miembro);
		} else {
			System.out.println("El miembro ya está asignado al proyecto.");
		}
	}
	
	public void eliminarMiembro(UsuarioProy miembro) {
		this.miembros.remove(miembro);
	}
	
	public List<Tarea> ListarTareas() {
		return tareas;
	}
	
	

}
