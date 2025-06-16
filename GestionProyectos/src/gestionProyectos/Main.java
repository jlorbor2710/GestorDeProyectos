package gestionProyectos;



import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static final UsuarioProyDAO usuarioProyDAO = new UsuarioProyDAO();
    private static final Scanner sc = new Scanner(System.in);
    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static final ProyectoDAO proyectoDAO = new ProyectoDAO();
    private static final TareaDAO tareaDAO = new TareaDAO();
    private static final ComentarioDAO comentarioDAO = new ComentarioDAO();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Crear usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Buscar usuario por correo");
            System.out.println("4. Actualizar perfil de usuario");
            System.out.println("5. Cambiar contraseña de usuario");
            System.out.println("6. Verificar credenciales de usuario");
            System.out.println("7. Crear proyecto");
            System.out.println("8. Listar proyectos");
            System.out.println("9. Asignar miembro a proyecto");
            System.out.println("10. Remover miembro de proyecto");
            System.out.println("11. Listar miembros de un proyecto");
            System.out.println("12. Crear tarea");
            System.out.println("13. Listar tareas de un proyecto");
            System.out.println("14. Cambiar estado de tarea");
            System.out.println("15. Cambiar prioridad de tarea");
            System.out.println("16. Comentar una tarea");
            System.out.println("17. Listar comentarios de una tarea");
            System.out.println("18. Eliminar comentario");
            System.out.println("19. Obtener porcentaje completado de proyecto");
            System.out.println("20. Eliminar tarea");
            System.out.println("21. Eliminar usuario");
            System.out.println("22. Eliminar proyecto");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            
            if (sc.hasNextInt()) {
            	opcion = sc.nextInt();
            	sc.nextLine();
            
            
            
            
            
            switch (opcion) {
                case 1 -> crearUsuario();
                case 2 -> listarUsuarios();
                case 3 -> buscarUsuarioPorCorreo();
                case 4 -> actualizarPerfilUsuario();
                case 5 -> cambiarContrasenaUsuario();
                case 6 -> verificarCredencialesUsuario();
                case 7 -> crearProyecto();
                case 8 -> listarProyectos();
                case 9 -> asignarMiembroProyecto();
                case 10 -> removerMiembroProyecto();
                case 11 -> listarMiembrosProyecto();
                case 12 -> crearTarea();
                case 13 -> listarTareasPorProyecto();
                case 14 -> cambiarEstadoTarea();
                case 15 -> cambiarPrioridadTarea();
                case 16 -> comentarTarea();
                case 17 -> listarComentariosTarea();
                case 18 -> eliminarComentario();
                case 19 -> eliminarTarea();
                case 20 -> eliminarUsuario();
                case 21 -> eliminarProyecto();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
            } else {
				System.out.println("Por favor, ingrese un número válido.");
				sc.nextLine();
				opcion = -1; 
			}
        } while (opcion != 0);
        
    }

    private static void crearUsuario() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Correo: ");
            String correo = sc.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = sc.nextLine();
            System.out.print("Rol (ADMINISTRADOR/COLABORADOR/CLIENTE): ");
            Rol rol = Rol.valueOf(sc.nextLine().toUpperCase());
            Usuario usuario = new Usuario(nombre, apellido, correo, contrasena, rol);
            usuarioDAO.guardar(usuario);
            System.out.println("Usuario creado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
        }
    }

    private static void listarUsuarios() {
        try {
            List<Usuario> usuarios = usuarioDAO.listar();
            if (usuarios.isEmpty()) {
                System.out.println("No hay usuarios.");
            } else {
                usuarios.forEach(u -> System.out.println(u.getNombre() + " " + u.getApellido() + " - " + u.getCorreo() + " (" + u.getRol() + ")"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
    }

    private static void buscarUsuarioPorCorreo() {
        try {
            System.out.print("Correo: ");
            String correo = sc.nextLine();
            Usuario usuario = usuarioDAO.buscarPorCorreo(correo);
            if (usuario != null) {
                System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getApellido() + " (" + usuario.getRol() + ")");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario: " + e.getMessage());
        }
    }

    private static void actualizarPerfilUsuario() {
        try {
            System.out.print("Correo (para identificar usuario): ");
            String correo = sc.nextLine();
            Usuario usuario = usuarioDAO.buscarPorCorreo(correo);
            if (usuario != null) {
                System.out.print("Nuevo nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Nuevo apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Nueva contraseña: ");
                String contrasena = sc.nextLine();
                usuario.actualizarPerfil(nombre, apellido, contrasena);
                usuarioDAO.actualizar(usuario);
                System.out.println("Perfil actualizado.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar perfil: " + e.getMessage());
        }
    }

    private static void cambiarContrasenaUsuario() {
        try {
            System.out.print("Correo: ");
            String correo = sc.nextLine();
            Usuario usuario = usuarioDAO.buscarPorCorreo(correo);
            if (usuario != null) {
                System.out.print("Contraseña actual: ");
                String passActual = sc.nextLine();
                System.out.print("Nueva contraseña: ");
                String passNueva = sc.nextLine();
                if (usuario.cambiarContrasena(passActual, passNueva)) {
                    usuarioDAO.actualizar(usuario);
                    System.out.println("Contraseña cambiada.");
                } else {
                    System.out.println("Contraseña actual incorrecta.");
                }
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cambiar contraseña: " + e.getMessage());
        }
    }

    private static void verificarCredencialesUsuario() {
        try {
            System.out.print("Correo: ");
            String correo = sc.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = sc.nextLine();
            Usuario usuario = usuarioDAO.buscarPorCorreo(correo);
            if (usuario != null && usuario.verificarCredenciales(correo, contrasena)) {
                System.out.println("Credenciales correctas.");
            } else {
                System.out.println("Credenciales incorrectas.");
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar credenciales: " + e.getMessage());
        }
    }

    private static void crearProyecto() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Descripción: ");
            String descripcion = sc.nextLine();
            System.out.print("Fecha inicio (YYYY-MM-DD): ");
            LocalDate fechaIni = LocalDate.parse(sc.nextLine());
            System.out.print("Fecha fin (YYYY-MM-DD): ");
            LocalDate fechaFin = LocalDate.parse(sc.nextLine());
            Proyecto proyecto = new Proyecto(nombre, descripcion, fechaIni, fechaFin);
            proyectoDAO.guardar(proyecto);
            System.out.println("Proyecto creado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al crear proyecto: " + e.getMessage());
        }
    }

    private static void listarProyectos() {
        try {
            List<Proyecto> proyectos = proyectoDAO.listar();
            if (proyectos.isEmpty()) {
                System.out.println("No hay proyectos.");
            } else {
                proyectos.forEach(p -> System.out.println("ID: " + p.getIdProyecto() + " - " + p.getNombre() + " (" + p.getDescripcion() + ")"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar proyectos: " + e.getMessage());
        }
    }

    private static void asignarMiembroProyecto() {
        try {
            System.out.print("ID Proyecto: ");
            int idProyecto = Integer.parseInt(sc.nextLine());
            System.out.print("Correo del usuario: ");
            String correo = sc.nextLine();
            System.out.print("Rol a asignar (ADMINISTRADOR/COLABORADOR/CLIENTE): ");
            Rol rol = Rol.valueOf(sc.nextLine().toUpperCase());
            Usuario usuario = usuarioDAO.buscarPorCorreo(correo);
            Proyecto proyecto = proyectoDAO.buscarPorId(idProyecto);
            if (usuario != null && proyecto != null) {
                UsuarioProy usuarioProy = new UsuarioProy(usuario.getIdUsuario(), idProyecto, rol);
                usuarioProyDAO.guardar(usuarioProy);
                System.out.println("Miembro asignado.");
            } else {
                System.out.println("Usuario o proyecto no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al asignar miembro: " + e.getMessage());
        }
    }

    private static void removerMiembroProyecto() {
        try {
            System.out.print("ID Proyecto: ");
            int idProyecto = Integer.parseInt(sc.nextLine());
            System.out.print("ID Usuario: ");
            int idUsuario = Integer.parseInt(sc.nextLine());
            usuarioProyDAO.eliminar(idUsuario, idProyecto);
            System.out.println("Miembro removido.");
        } catch (SQLException e) {
            System.out.println("Error al remover miembro: " + e.getMessage());
        }
    }

    private static void listarMiembrosProyecto() {
        try {
            System.out.print("ID Proyecto: ");
            int idProyecto = Integer.parseInt(sc.nextLine());
            Proyecto proyecto = proyectoDAO.buscarPorId(idProyecto);
            if (proyecto != null) {
                List<UsuarioProy> miembros = proyectoDAO.ListarMiembros(idProyecto);
                if (miembros.isEmpty()) {
                    System.out.println("No hay miembros en este proyecto.");
                } else {
                    miembros.forEach(m -> System.out.println("UsuarioID: " + m.getIdUsuario() + " - Rol: " + m.getRolAsignado()));
                }
            } else {
                System.out.println("Proyecto no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al listar miembros: " + e.getMessage());
        }
    }

    private static void crearTarea() {
        try {
            //System.out.print("ID Tarea: ");
            //int idTarea = Integer.parseInt(sc.nextLine());
            System.out.print("ID Proyecto: ");
            int idProyecto = Integer.parseInt(sc.nextLine());
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Descripción: ");
            String descripcion = sc.nextLine();
            System.out.print("Fecha límite (YYYY-MM-DD): ");
            LocalDate fechaLimite = LocalDate.parse(sc.nextLine());
            System.out.print("Prioridad (ALTA/MEDIA/BAJA): ");
            Prioridad prioridad = Prioridad.valueOf(sc.nextLine().toUpperCase());
            Tarea tarea = new Tarea(idProyecto, nombre, descripcion, fechaLimite, prioridad);
            tareaDAO.guardar(tarea);
            System.out.println("Tarea creada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al crear tarea: " + e.getMessage());
        }
    }

    private static void listarTareasPorProyecto() {
        try {
            System.out.print("ID Proyecto: ");
            int idProyecto = Integer.parseInt(sc.nextLine());
            List<Tarea> tareas = tareaDAO.listarPorProyecto(idProyecto);
            if (tareas.isEmpty()) {
                System.out.println("No hay tareas para ese proyecto.");
            } else {
                tareas.forEach(t -> System.out.println("ID: " + t.getIdTarea() + " - " + t.getNombre() + " (" + t.getDescripcion() + ") - Estado: " + t.getEstado() + " - Prioridad: " + t.getPrioridad()));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar tareas: " + e.getMessage());
        }
    }

    private static void cambiarEstadoTarea() {
        try {
            System.out.print("ID Tarea: ");
            int idTarea = Integer.parseInt(sc.nextLine());
            System.out.print("Nuevo estado (PENDIENTE/EN_PROCESO/COMPLETADO): ");
            EstadoTarea estado = EstadoTarea.valueOf(sc.nextLine().toUpperCase());
            Tarea tarea = tareaDAO.buscarPorId(idTarea);
            if (tarea != null) {
                tarea.setEstado(estado);
                System.out.println(tarea.getEstado());
                tareaDAO.actualizar(tarea);
                System.out.println("Estado de la tarea actualizado.");
            } else {
                System.out.println("Tarea no encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cambiar estado: " + e.getMessage());
        }
    }

    private static void cambiarPrioridadTarea() {
        try {
            System.out.print("ID Tarea: ");
            int idTarea = Integer.parseInt(sc.nextLine());
            System.out.print("Nueva prioridad (ALTA/MEDIA/BAJA): ");
            Prioridad prioridad = Prioridad.valueOf(sc.nextLine().toUpperCase());
            Tarea tarea = tareaDAO.buscarPorId(idTarea);
            if (tarea != null) {
                tarea.setPrioridad(prioridad);
                tareaDAO.actualizar(tarea);
                System.out.println("Prioridad de la tarea actualizada.");
            } else {
                System.out.println("Tarea no encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cambiar prioridad: " + e.getMessage());
        }
    }

    private static void comentarTarea() {
        try {
            System.out.print("ID Tarea: ");
            int idTarea = Integer.parseInt(sc.nextLine());
            System.out.print("ID Usuario: ");
            int idUsuario = Integer.parseInt(sc.nextLine());
            System.out.print("Comentario: ");
            String contenido = sc.nextLine();
            Comentario comentario = new Comentario(idTarea, idUsuario, contenido);
            comentarioDAO.guardar(comentario);
            System.out.println("Comentario agregado.");
        } catch (Exception e) {
            System.out.println("Error al comentar: " + e.getMessage());
        }
    }

    private static void listarComentariosTarea() {
        try {
            System.out.print("ID Tarea: ");
            int idTarea = Integer.parseInt(sc.nextLine());
            List<Comentario> comentarios = comentarioDAO.listarPorTarea(idTarea);
            if (comentarios.isEmpty()) {
                System.out.println("No hay comentarios para esa tarea.");
            } else {
                comentarios.forEach(c -> System.out.println("UsuarioID: " + c.getIdUsuario() + " - " + c.getContenido()));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar comentarios: " + e.getMessage());
        }
    }

    private static void eliminarComentario() {
        try {
            System.out.print("ID Comentario: ");
            int idComentario = Integer.parseInt(sc.nextLine());
            comentarioDAO.eliminar(idComentario);
            System.out.println("Comentario eliminado.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar comentario: " + e.getMessage());
        }
    }


    private static void eliminarTarea() {
        try {
            System.out.print("ID Tarea: ");
            int idTarea = Integer.parseInt(sc.nextLine());
            tareaDAO.eliminar(idTarea);
            System.out.println("Tarea eliminada.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar tarea: " + e.getMessage());
        }
    }

    private static void eliminarUsuario() {
        try {
            System.out.print("Correo del usuario a eliminar: ");
            String correo = sc.nextLine();
            usuarioDAO.eliminarPorCorreo(correo);
            System.out.println("Usuario eliminado.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    private static void eliminarProyecto() {
        try {
            System.out.print("ID Proyecto: ");
            int idProyecto = Integer.parseInt(sc.nextLine());
            proyectoDAO.eliminar(idProyecto);
            System.out.println("Proyecto eliminado.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar proyecto: " + e.getMessage());
        }
    }
}