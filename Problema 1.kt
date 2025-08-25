/*
Descripción: Evaluación empleados: Programa que evalua el rendimiento de un empleado según su puntuación y calcula el dinero que va a recibir (salario*puntuación/10).
Autor: Fatima Florez
Fecha creación: 23/08/2025
Fecha última modificación: 23/08/2025
*/

// Función que calcula el dinero que recibe el empleado
fun calcularDinero(salario: Int, puntuacion: Int ): Int {
    return salario*puntuacion/10
}

// Función que calcula el dinero que recibe el empleado
fun rendimiento(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Su nivel es inaceptable"
        in 4..6 -> "Su nivel es aceptable"
        in 7..10 -> "Su nivel es meritorio!"
        else -> "Puntuación invalida"
    }
}

fun main(){
    print("Ingrese su salario: ")
    val salario= readln().toInt()

    print("Ingrese su puntación: ")
    val puntuacion= readln().toInt()

    val dinero=calcularDinero(salario,puntuacion)
    val nivel=rendimiento(puntuacion)

    println("\n--- Resultados de Evaluación ---")
    println("Su salario es: $salario")
    println("Su puntuacion es de: $puntuacion")
    println("Calculo de dinero a recibir: $salario * $puntuacion / 10 = $dinero")
    println("Resultado de rendimiento: $nivel ")
    println("El dinero por recibir es de: $dinero ")

}
