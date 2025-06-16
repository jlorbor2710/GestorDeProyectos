# Sistema de Gestión de Proyectos

## Descripción del Proyecto

El **Sistema de Gestión de Proyectos** es una aplicación diseñada para facilitar la planificación, organización y seguimiento de proyectos. Este sistema permite a los equipos de trabajo gestionar tareas, colaborar en tiempo real y cumplir objetivos de manera eficiente. Con una sólida implementación de conceptos de programación orientada a objetos, el sistema integra operaciones CRUD, manejo de excepciones, estructuras dinámicas y conexión a bases de datos mediante JDBC.

El proyecto tiene como objetivo brindar una herramienta completa y funcional para gestionar proyectos mientras se demuestra la adquisición de conocimientos fundamentales de programación y desarrollo de software.



## Objetivo Principal

El objetivo principal del sistema es proporcionar una plataforma que permita a los usuarios (administradores, colaboradores y clientes) gestionar proyectos, tareas y recursos de manera eficiente, asegurando la colaboración fluida dentro del equipo y el cumplimiento de los plazos establecidos.



## Funcionalidades Principales

### Gestión de Usuarios:
- **Roles de Usuarios**: 
  - Administrador: Puede gestionar proyectos, asignar usuarios y supervisar el progreso.
  - Colaborador: Puede trabajar en tareas asignadas, añadir comentarios y subir archivos.
  - Cliente: Puede consultar el estado de los proyectos y realizar comentarios.
- Registro y autenticación de usuarios con validación de credenciales.

### Gestión de Proyectos:
- Crear, editar y eliminar proyectos.
- Asignar usuarios a proyectos con roles específicos.
- Seguimiento del estado de los proyectos (Planeado, En Proceso, Completado).

### Gestión de Tareas:
- Crear, asignar y gestionar tareas dentro de un proyecto.
- Establecer prioridades y fechas límite para las tareas.
- Actualizar el estado de las tareas (Pendiente, En Proceso, Completado).

### Colaboración:
- Comentarios en tareas para facilitar la comunicación entre los usuarios.

### Historial y Seguimiento:
- Registro de cambios en las tareas (historial de modificaciones).
- Consulta de progreso general de los proyectos.

### Manejo de Excepciones:
- Validación de datos y manejo de errores durante la ejecución.
- Mensajes claros y descriptivos para errores comunes (como intentos de acceso no autorizado o datos inválidos).

### Base de Datos:
- Conexión a base de datos mediante JDBC.
- Operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para la gestión de usuarios, proyectos, tareas y comentarios.

### Uso de Estructuras Dinámicas:
- Implementación de colecciones y mapas para la gestión de objetos, como listas de usuarios, tareas y proyectos.
- Uso de Streams de la API de Java para operaciones complejas como filtrado, búsqueda y agrupación.



## Tecnologías Utilizadas

- Lenguaje: Java
- Base de Datos: MySQL (Conexión mediante JDBC)
- Frameworks: Ninguno
- Estructuras de Datos: Colecciones y Streams de Java
- Entorno: IDEs como IntelliJ IDEA o Eclipse



## Requisitos de Instalación

1. **Java Development Kit (JDK)** versión 8 o superior.
2. **Base de Datos MySQL** instalada y configurada.
3. **Controlador JDBC** para MySQL.
4. IDE como IntelliJ IDEA, Eclipse o NetBeans.
