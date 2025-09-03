/*
Descripción: Clase para Producto - Diseña una clase Producto que tenga un precio y un descuento aplicable.
Autor: Fatima Florez
Fecha creación: 31/08/2025
Fecha última modificación: 31/08/2025
*/

class Producto{
    private var precio: Double = 0.0
    private var descuento: Double = 0.0

    // Getter para precio
    fun getPrecio(): Double {
        return precio
    }

    // Setter para precio con validación
    fun setPrecio(nuevoPrecio: Double): Boolean {
        return if (nuevoPrecio >= 0) {
            precio = nuevoPrecio
            println("Precio establecido correctamente: $precio")
            true
        } else {
            println("Error: El precio no puede ser negativo")
            false
        }
    }

    // Getter para descuento
    fun getDescuento(): Double {
        return descuento
    }

    // Setter para descuento con validación
    fun setDescuento(nuevoDescuento: Double): Boolean {
        return if (nuevoDescuento in 0.0..100.0) {
            descuento = nuevoDescuento
            println("Descuento establecido correctamente: $descuento%")
            true
        } else {
            println("Error: El descuento debe estar entre 0% y 100%")
            false
        }
    }

    // Metodo para calcular el precio final con descuento
    fun calcularPrecioFinal(): Double {
        val descuentoAplicado = precio * (descuento / 100)
        val precioFinal = precio - descuentoAplicado
        return precioFinal
    }

    // Metodo para mostrar información del producto
    fun mostrarInformacion() {
        val precioFinal = calcularPrecioFinal()
        println("=== INFORMACIÓN DEL PRODUCTO ===")
        println("Precio original: $precio")
        println("Descuento aplicado: $descuento%")
        println("Ahorro: ${precio * (descuento / 100)}")
        println("Precio final: $precioFinal")
        println("================================")
    }

    // Metodo para mostrar el desglose del cálculo
    fun mostrarDesglosePrecio() {
        val descuentoMonto = precio * (descuento / 100)
        val precioFinal = calcularPrecioFinal()

        println("\n--- DESGLOSE DE PRECIO ---")
        println("Precio base: $precio")
        println("Descuento (${descuento}%): -$descuentoMonto")
        println("Precio final: $precioFinal")
        println("---------------------------")
    }
}

fun main() {
    val producto = Producto()

    // Configurar precio y descuento iniciales
    producto.setPrecio(250.0)
    producto.setDescuento(15.0)

    // Mostrar información general
    producto.mostrarInformacion()

    // Probar un descuento diferente
    println("\nAplicando 50% de descuento:")
    producto.setDescuento(50.0)
    producto.mostrarDesglosePrecio()

    // Probar validaciones rápidas
    println("\nProbando validaciones:")
    producto.setPrecio(-100.0)      // Precio negativo
    producto.setDescuento(-10.0)    // Descuento negativo
    producto.setDescuento(150.0)    // Descuento mayor a 100%

    // Estado final
    println("\nEstado final del producto:")
    producto.mostrarInformacion()
}
