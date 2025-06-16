package test;

import org.junit.jupiter.api.Test;

import gestionProyectos.Rol;
import gestionProyectos.Usuario;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testVerificarCredenciales() {
        Usuario usuario = new Usuario("Juan", "Perez", "juan@mail.com", "1234", Rol.ADMINISTRADOR);
        assertTrue(usuario.verificarCredenciales("juan@mail.com", "1234"));
        assertFalse(usuario.verificarCredenciales("juan@mail.com", "wrong"));
    }

    @Test
    void testActualizarPerfil() {
        Usuario usuario = new Usuario("Juan", "Perez", "juan@mail.com", "1234", Rol.ADMINISTRADOR);
        usuario.actualizarPerfil("Nuevo", "Apellido", "nuevaPass");
        assertEquals("Nuevo", usuario.getNombre());
        assertEquals("Apellido", usuario.getApellido());
        assertEquals("nuevaPass", usuario.getContrasena());
    }

    @Test
    void testCambiarContrasena() {
        Usuario usuario = new Usuario("Juan", "Perez", "juan@mail.com", "1234", Rol.ADMINISTRADOR);
        assertTrue(usuario.cambiarContrasena("1234", "abcd"));
        assertEquals("abcd", usuario.getContrasena());
        assertFalse(usuario.cambiarContrasena("wrong", "otro"));
    }
}