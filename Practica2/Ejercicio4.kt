/*
Descripción: Sistema de gestión de Biblioteca - Diseña un sistema de gestión de biblioteca que incluya las siguientes clases e interfaces: Material, libro, revista, usuario, IBiblioteca, Biblioteca
Autor: Fatima Florez
Fecha creación: 01/09/2025
Fecha última modificación: 02/09/2025
*/

abstract class Material(
    val titulo: String,
    val autor: String,
    val publicacion: Int
) {
    abstract fun mostrarDetalles()
}

// Subclase Libro
class Libro(
    titulo: String,
    autor: String,
    publicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, publicacion) {

    override fun mostrarDetalles() {
        println("=== DETALLES DEL LIBRO ===")
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año: $publicacion")
        println("Género: $genero")
        println("Páginas: $numeroPaginas")
        println("==========================")
    }
}
// Subclase Revista
class Revista(
    titulo: String,
    autor: String,
    publicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, publicacion) {

    override fun mostrarDetalles() {
        println("=== DETALLES DE LA REVISTA ===")
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año: $publicacion")
        println("ISSN: $issn")
        println("Volumen: $volumen")
        println("Número: $numero")
        println("Editorial: $editorial")
        println("==============================")
    }
}

// Data class Usuario
data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
) {
    override fun toString(): String {
        return "$nombre $apellido ($edad años)"
    }
}

// Interfaz IBiblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material): Boolean
    fun registrarUsuario(usuario: Usuario): Boolean
    fun prestamo(usuario: Usuario, material: Material): Boolean
    fun devolucion(usuario: Usuario, material: Material): Boolean
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

// Clase Biblioteca que implementa la interfaz
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuariosRegistrados = mutableListOf<Usuario>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material): Boolean {
        return if (!materialesDisponibles.contains(material)) {
            materialesDisponibles.add(material)
            println("✅ Material registrado: ${material.titulo}")
            true
        } else {
            println("❌ El material '${material.titulo}' ya está registrado")
            false
        }
    }

    override fun registrarUsuario(usuario: Usuario): Boolean {
        return if (!usuariosRegistrados.contains(usuario)) {
            usuariosRegistrados.add(usuario)
            prestamos[usuario] = mutableListOf()
            println("✅ Usuario registrado: $usuario")
            true
        } else {
            println("❌ El usuario $usuario ya está registrado")
            false
        }
    }

    override fun prestamo(usuario: Usuario, material: Material): Boolean {
        if (!usuariosRegistrados.contains(usuario)) {
            println("❌ Usuario no registrado: $usuario")
            return false
        }

        if (!materialesDisponibles.contains(material)) {
            println("❌ Material no disponible: ${material.titulo}")
            return false
        }

        val materialesUsuario = prestamos[usuario] ?: mutableListOf()

        if (materialesUsuario.contains(material)) {
            println("❌ El usuario ya tiene prestado: ${material.titulo}")
            return false
        }

        // Realizar préstamo
        materialesDisponibles.remove(material)
        materialesUsuario.add(material)
        prestamos[usuario] = materialesUsuario

        println("✅ Préstamo exitoso: ${usuario.nombre} -> ${material.titulo}")
        return true
    }

    override fun devolucion(usuario: Usuario, material: Material): Boolean {
        if (!usuariosRegistrados.contains(usuario)) {
            println("❌ Usuario no registrado: $usuario")
            return false
        }

        val materialesUsuario = prestamos[usuario] ?: mutableListOf()

        if (!materialesUsuario.contains(material)) {
            println("❌ El usuario no tiene prestado: ${material.titulo}")
            return false
        }

        // Realizar devolución
        materialesUsuario.remove(material)
        materialesDisponibles.add(material)
        prestamos[usuario] = materialesUsuario

        println("✅ Devolución exitosa: ${usuario.nombre} -> ${material.titulo}")
        return true
    }

    override fun mostrarMaterialesDisponibles() {
        println("\n=== MATERIALES DISPONIBLES ===")
        if (materialesDisponibles.isEmpty()) {
            println("No hay materiales disponibles")
        } else {
            materialesDisponibles.forEachIndexed { index, material ->
                println("${index + 1}. ${material.titulo} - ${material.autor}")
            }
        }
        println("==============================")
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("\n=== MATERIALES PRESTADOS A: $usuario ===")
        val materialesUsuario = prestamos[usuario] ?: mutableListOf()

        if (materialesUsuario.isEmpty()) {
            println("El usuario no tiene materiales prestados")
        } else {
            materialesUsuario.forEachIndexed { index, material ->
                println("${index + 1}. ${material.titulo} - ${material.autor}")
            }
        }
        println("========================================")
    }

    // Metodo adicional para mostrar todos los préstamos
    fun mostrarTodosLosPrestamos() {
        println("\n=== TODOS LOS PRÉSTAMOS ===")
        if (prestamos.all { it.value.isEmpty() }) {
            println("No hay préstamos activos")
        } else {
            prestamos.forEach { (usuario, materiales) ->
                if (materiales.isNotEmpty()) {
                    println("$usuario tiene prestados:")
                    materiales.forEachIndexed { index, material ->
                        println("  ${index + 1}. ${material.titulo}")
                    }
                    println()
                }
            }
        }
        println("==========================")
    }
}
// Función main para probar el sistema
fun main() {
    println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===\n")

    val biblioteca = Biblioteca()

    // Crear materiales
    val libro1 = Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico", 432)
    val libro2 = Libro("1984", "George Orwell", 1949, "Ciencia ficción", 328)
    val libro3 = Libro("El Quijote", "Miguel de Cervantes", 1605, "Novela", 863)

    val revista1 = Revista("National Geographic", "Varios autores", 2023, "ISSN-1234", 145, 3, "National Geographic Society")
    val revista2 = Revista("Science Today", "Varios autores", 2023, "ISSN-5678", 22, 7, "Science Publishers")

    // Crear usuarios
    val usuario1 = Usuario("María", "González", 25)
    val usuario2 = Usuario("Carlos", "Rodríguez", 32)
    val usuario3 = Usuario("Ana", "Martínez", 28)

    // Registrar usuarios
    println("--- REGISTRANDO USUARIOS ---")
    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)
    biblioteca.registrarUsuario(usuario3)

    // Registrar materiales
    println("\n--- REGISTRANDO MATERIALES ---")
    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(libro2)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarMaterial(revista2)

    // Mostrar materiales disponibles
    biblioteca.mostrarMaterialesDisponibles()

    // Realizar préstamos
    println("\n--- REALIZANDO PRÉSTAMOS ---")
    biblioteca.prestamo(usuario1, libro1)
    biblioteca.prestamo(usuario1, revista1)
    biblioteca.prestamo(usuario2, libro2)


    // Intentar préstamo duplicado
    println("\n--- INTENTANDO PRÉSTAMO DUPLICADO ---")
    biblioteca.prestamo(usuario1, libro1)

    // Mostrar materiales prestados por usuario
    println("\n--- MATERIALES PRESTADOS ---")
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario2)
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario3)

    // Mostrar materiales disponibles después de préstamos
    biblioteca.mostrarMaterialesDisponibles()

    // Realizar devoluciones
    println("\n--- REALIZANDO DEVOLUCIONES ---")
    biblioteca.devolucion(usuario1, libro1)
    biblioteca.devolucion(usuario2, libro2)

    // Intentar devolución incorrecta
    println("\n--- INTENTANDO DEVOLUCIÓN INCORRECTA ---")
    biblioteca.devolucion(usuario1, libro2) // Usuario no tiene este libro

    // Mostrar estado final
    println("\n--- ESTADO FINAL ---")
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarTodosLosPrestamos()

    // Mostrar detalles de algunos materiales
    println("\n--- DETALLES DE MATERIALES ---")
    libro1.mostrarDetalles()
    revista1.mostrarDetalles()

    // Probar con usuario no registrado
    println("\n--- PRUEBA CON USUARIO NO REGISTRADO ---")
    val usuarioNoRegistrado = Usuario("Juan", "Pérez", 40)
    biblioteca.prestamo(usuarioNoRegistrado, libro1)
}
