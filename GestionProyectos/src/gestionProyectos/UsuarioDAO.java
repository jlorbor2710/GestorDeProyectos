package gestionProyectos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void guardar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nombre, apellido, correo, contraseña, rol) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getContrasena());
            stmt.setString(5, usuario.getRol().toString());
            stmt.executeUpdate();
        }
    }

    public Usuario buscarPorCorreo(String correo) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE correo = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        Rol.valueOf(rs.getString("rol").trim().toUpperCase())
                );
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> listar() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                		rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        Rol.valueOf(rs.getString("rol").trim().toUpperCase())
                );
                lista.add(usuario);
            }
        }
        return lista;
    }

    public void actualizar(Usuario usuario) throws SQLException {
    	String sql = "UPDATE usuario SET nombre=?, apellido=?, contraseña=?, rol=? WHERE correo=?";
    	try (Connection conn = ConexionBD.obtenerConexion();
    	     PreparedStatement stmt = conn.prepareStatement(sql)) {
    	    stmt.setString(1, usuario.getNombre());
    	    stmt.setString(2, usuario.getApellido());
    	    stmt.setString(3, usuario.getContrasena());
    	    stmt.setString(4, usuario.getRol().toString());
    	    stmt.setString(5, usuario.getCorreo());
    	    stmt.executeUpdate();
    	}
    }


    public void eliminarPorCorreo(String correo) throws SQLException {
        String sql = "DELETE FROM usuario WHERE correo = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.executeUpdate();
        }
    }
}