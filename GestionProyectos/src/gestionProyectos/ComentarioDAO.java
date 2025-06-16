package gestionProyectos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO {

    public void guardar(Comentario comentario) throws SQLException {
        String sql = "INSERT INTO comentario (id_tarea, id_usuario, contenido, fecha) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, comentario.getIdTarea());
            stmt.setInt(2, comentario.getIdUsuario());
            stmt.setString(3, comentario.getContenido());
            stmt.setTimestamp(4, Timestamp.valueOf(comentario.getFecha()));
            stmt.executeUpdate();
        }
    }

    public List<Comentario> listarPorTarea(int idTarea) throws SQLException {
        List<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT * FROM comentario WHERE id_tarea = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTarea);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Comentario c = new Comentario(
                        rs.getInt("id_tarea"),
                        rs.getInt("id_usuario"),
                        rs.getString("contenido")
                );
                comentarios.add(c);
            }
        }
        return comentarios;
    }

    public void eliminar(int idComentario) throws SQLException {
        String sql = "DELETE FROM comentario WHERE id_comentario = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idComentario);
            stmt.executeUpdate();
        }
    }
}