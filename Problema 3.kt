/*
Descripción: Calculadora Elemental - Calculadora que realiza operaciones básicas como suma, resta, multiplicación y división
Autor: Fatima Florez
Fecha creación: 24/08/2025
Fecha última modificación: 24/08/2025
*/

// Función que recibe dos números y devuelve la suma
fun suma(num1:Double, num2:Double):Double{
    return num1+num2
}

// Función que recibe dos números y devuelve la resta
fun resta(num1: Double, num2: Double): Double{
    return num1 - num2
}

// Función que recibe dos números y devuelve la multiplicación
fun multiplicacion(num1: Double, num2: Double): Double {
    return num1*num2
}

// Función que realiza la división entre dos números
fun division(num1: Double, num2: Double): Double {
    return if (num2 != 0.0) num1/num2 else Double.NaN // Se devuelve NaN (Not a Number) para indicar que no se puede dividir entre 0
}

// Función que solicita al usuario ingresar dos números y los devuelve como un par (num1, num2)
fun leer(): Pair<Double, Double>{
    print("Ingrese el primer número: ")
    val num1 = readln().toDouble()
    print("Ingrese el segundo número: ")
    val num2 = readln().toDouble()
    return Pair(num1, num2)
}

fun main(){
    var opcion: Int
    // Ciclo que mantiene el menú activo hasta que el usuario elija la opción de salir
    do {
        println("\n----Menú----")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        println("Seleccione una opción: ")

        opcion = readln().toIntOrNull() ?: -1 // Se asigna -1 como valor por defecto cuando el usuario ingresa un valor inválido

        // Estructura para evaluar la opción ingresada y ejecutar la operación correspondiente
        when (opcion) {
            1 -> {
                val (num1, num2) = leer()
                println("Resultado: ${suma(num1, num2)}")
            }

            2 -> {
                val (num1, num2) = leer()
                println("Resultado: ${resta(num1, num2)}")
            }

            3 -> {
                val (num1, num2) = leer()
                println("Resultado: ${multiplicacion(num1, num2)}")
            }

            4 -> {
                val (num1, num2) = leer()
                val resultado = division(num1, num2)
                if (resultado.isNaN()) {
                    println("Error: No es posible dividir entre 0")
                } else {
                    println("Resultado: ${resultado}")
                }
            }

            5 -> println("Saliendo de la calculadora...")
            else -> println("Opción Inválida, intente nuevamente")
        }
    } while (opcion != 5)
}


