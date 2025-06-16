package gestionProyectos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioProyDAO {
    public void guardar(UsuarioProy usuarioProy) throws SQLException {
        String sql = "INSERT INTO usuario_proy (id_usuario, id_proyecto, rol_asignado, fecha_asignación) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioProy.getIdUsuario());
            stmt.setInt(2, usuarioProy.getIdProyecto());
            stmt.setString(3, usuarioProy.getRolAsignado().toString());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(usuarioProy.getFechaAsignacion()));
            stmt.executeUpdate();
        }
    }
    
    public void eliminar(int idUsuario, int idProyecto) throws SQLException {
        String sql = "DELETE FROM usuario_proy WHERE idUsuario = ? AND idProyecto = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idProyecto);
            stmt.executeUpdate();
        }
    }
}