package test;

import org.junit.jupiter.api.Test;

import gestionProyectos.Comentario;

import static org.junit.jupiter.api.Assertions.*;

public class ComentarioTest {

    @Test
    void testGetSetContenido() {
        Comentario comentario = new Comentario(1, 2, "contenido");
        assertEquals("contenido", comentario.getContenido());
        comentario.setContenido("nuevo");
        assertEquals("nuevo", comentario.getContenido());
    }

    @Test
    void testSetFecha() {
        Comentario comentario = new Comentario(1, 2, "contenido");
        assertNotNull(comentario.getFecha());
    }
}