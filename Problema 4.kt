/*
Descripción: Adivina Número - Programa que genera un número aleatorio entre 1 y 30, el usuario debe adivinar el número, únicamente tiene 5 intentos.
Autor: Fatima Florez
Fecha creación: 24/08/2025
Fecha última modificación: 24/08/2025
*/
import kotlin.random.Random

fun main(){
    val numeroPorAdivinar = Random.nextInt(1,31) //Genera un número aleatoio entre 1 y 30
    var intentos: Int = 0
    val intentosMaximos = 5
    var adivinado = false // Variable para saber si el jugador adivinó

    println("Adivina el número, está entre 1 y 30. Tienes $intentosMaximos intentos. Suerte!")

    //Ciclo mientras no se supera el máximo de intentos y no se adivine el número
    while(intentos < intentosMaximos && !adivinado){
        print("Intento ${intentos + 1}: Ingresa un número -> ")
        val numeroUsuario = readln().toIntOrNull()

    //Validación del número que ingresa el usuario
    if (numeroUsuario == null) {
        println("Entrada inválida, por favor ingresa un número.")
        continue  // vuelve a pedir sin gastar intento
    }

    intentos++

        //Comparación entre el número ingresado y el número por adivinar
        when {
            numeroUsuario < numeroPorAdivinar -> println("El número por adivinar es mayor.")
            numeroUsuario > numeroPorAdivinar -> println("El número por adivinar es menor.")
            else -> {
                println("Felicidades! Adivinaste el número.")
                adivinado = true
            }
        }
    }

    if (!adivinado) {
        println("Game Over :( El número era $numeroPorAdivinar")
    }
}
