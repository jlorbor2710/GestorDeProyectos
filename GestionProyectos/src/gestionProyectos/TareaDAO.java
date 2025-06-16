package gestionProyectos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {

    public void guardar(Tarea tarea) throws SQLException {
        String sql = "INSERT INTO tarea (id_tarea, id_proyecto, nombre, descripción, estado, fecha_limite, prioridad) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tarea.getIdTarea());
            stmt.setInt(2, tarea.getIdProyecto());
            stmt.setString(3, tarea.getNombre());
            stmt.setString(4, tarea.getDescripcion());
            stmt.setString(5, tarea.getEstado().toString());
            stmt.setDate(6, Date.valueOf(tarea.getFechaLimite()));
            stmt.setString(7, tarea.getPrioridad().toString());
            stmt.executeUpdate();
        }
    }

    public Tarea buscarPorId(int idTarea) throws SQLException {
        String sql = "SELECT * FROM tarea WHERE id_tarea = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTarea);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Tarea(
                        rs.getInt("id_proyecto"),
                        rs.getInt("id_tarea"),
                        rs.getString("nombre"),
                        rs.getString("descripción"),
                        rs.getDate("fecha_limite").toLocalDate(),
                        Prioridad.valueOf(rs.getString("prioridad"))
                );
            }
        }
        return null;
    }

    public List<Tarea> listarPorProyecto(int idProyecto) throws SQLException {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT * FROM tarea WHERE id_proyecto = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProyecto);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tarea tarea = new Tarea(
                        rs.getInt("id_proyecto"),
                        rs.getInt("id_tarea"),
                        rs.getString("nombre"),
                        rs.getString("descripción"),
                        rs.getDate("fecha_limite").toLocalDate(),
                        Prioridad.valueOf(rs.getString("prioridad"))
                );
                lista.add(tarea);
            }
        }
        return lista;
    }

    public void actualizar(Tarea tarea) throws SQLException {
        String sql = "UPDATE tarea SET nombre=?, descripción=?, estado=?, fecha_limite=?, prioridad=? WHERE id_tarea=?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tarea.getNombre());
            stmt.setString(2, tarea.getDescripcion());
            stmt.setString(3, tarea.getEstado().toString());
            stmt.setDate(4, Date.valueOf(tarea.getFechaLimite()));
            stmt.setString(5, tarea.getPrioridad().toString());
            stmt.setInt(6, tarea.getIdTarea());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int idTarea) throws SQLException {
        String sql = "DELETE FROM tarea WHERE id_tarea = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTarea);
            stmt.executeUpdate();
        }
    }
}
