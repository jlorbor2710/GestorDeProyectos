package gestionProyectos;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO {

    public void guardar(Proyecto proyecto) throws SQLException {
        String sql = "INSERT INTO proyecto (id_proyecto, nombre, descripción, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, proyecto.getIdProyecto());
            stmt.setString(2, proyecto.getNombre());
            stmt.setString(3, proyecto.getDescripcion());
            stmt.setDate(4, Date.valueOf(proyecto.getFechaInicio()));
            stmt.setDate(5, Date.valueOf(proyecto.getFechaFin()));
            stmt.setString(6, proyecto.getEstado().toString());
            stmt.executeUpdate();
        }
    }

    public Proyecto buscarPorId(int idProyecto) throws SQLException {
        String sql = "SELECT * FROM proyecto WHERE id_proyecto = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProyecto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Proyecto(
                        rs.getInt("id_proyecto"),
                        rs.getString("nombre"),
                        rs.getString("descripción"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate()
                        , rs.getString("estado") != null ? EstadoProyecto.valueOf(rs.getString("estado").toUpperCase()) : EstadoProyecto.PENDIENTE
                );
            }
        }
        return null;
    }

    public List<Proyecto> listar() throws SQLException {
        List<Proyecto> lista = new ArrayList<>();
        String sql = "SELECT * FROM proyecto";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Proyecto proyecto = new Proyecto(
                        rs.getInt("id_proyecto"),
                        rs.getString("nombre"),
                        rs.getString("descripción"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate(),
                        rs.getString("estado") != null ? EstadoProyecto.valueOf(rs.getString("estado").toUpperCase()) : EstadoProyecto.PENDIENTE
                );
                lista.add(proyecto);
            }
        }
        return lista;
    }

    public void actualizar(Proyecto proyecto) throws SQLException {
        String sql = "UPDATE proyecto SET nombre=?, descripcion=?, fecha_inicio=?, fecha_fin=?, estado=? WHERE id_proyecto=?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, proyecto.getNombre());
            stmt.setString(2, proyecto.getDescripcion());
            stmt.setDate(3, Date.valueOf(proyecto.getFechaInicio()));
            stmt.setDate(4, Date.valueOf(proyecto.getFechaFin()));
            stmt.setString(5, proyecto.getEstado().toString());
            stmt.setInt(6, proyecto.getIdProyecto());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int idProyecto) throws SQLException {
        String sql = "DELETE FROM proyecto WHERE id_proyecto = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProyecto);
            stmt.executeUpdate();
        }
    }
    
    public List<UsuarioProy> ListarMiembros(int idProyecto) throws SQLException {
    	List<UsuarioProy> lista = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO_PROY WHERE id_proyecto = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProyecto);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UsuarioProy usuario = new UsuarioProy(
                		rs.getInt("id_usuario"),
                        rs.getInt("id_proyecto"),
                        Rol.valueOf(rs.getString("rol_asignado"))
                        
                );
                lista.add(usuario);
            }
        }
        return lista;
    }
}