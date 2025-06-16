package test;

import org.junit.jupiter.api.Test;

import gestionProyectos.Prioridad;
import gestionProyectos.Tarea;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TareaTest {

    @Test
    void testCrearTarea() {
        Tarea tarea = new Tarea(1, "nombre", "desc", LocalDate.now(), Prioridad.ALTA);
        assertEquals("nombre", tarea.getNombre());
        assertEquals("desc", tarea.getDescripcion());
        assertEquals(Prioridad.ALTA, tarea.getPrioridad());
    }

    @Test
    void testSetters() {
        Tarea tarea = new Tarea(1, "t", "d", LocalDate.now(), Prioridad.ALTA);
        tarea.setNombre("nuevo");
        tarea.setDescripcion("desc2");
        tarea.setPrioridad(Prioridad.BAJA);
        assertEquals("nuevo", tarea.getNombre());
        assertEquals("desc2", tarea.getDescripcion());
        assertEquals(Prioridad.BAJA, tarea.getPrioridad());
    }
}