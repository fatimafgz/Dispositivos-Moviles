/*
Descripción: Figuras - Cree una clase abstracta “shape” la cual contenga las propiedades área, perímetro y las funciones para calcular estos valores e imprimir el resultado de cada operación.
Autor: Fatima Florez
Fecha creación: 31/08/2025
Fecha última modificación: 01/09/2025
*/

// Clase abstracta Shape
abstract class Shape {
    abstract val area: Double
    abstract val perimetro: Double

    // Métodos para calcular (abstractos, deben ser implementados por las subclases)
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    // Métodos para imprimir resultados
    fun imprimirArea() {
        println("Área: $area")
    }

    fun imprimirPerimetro() {
        println("Perímetro: $perimetro")
    }

    fun imprimirInformacion() {
        println("=== INFORMACIÓN DE LA FIGURA ===")
        imprimirArea()
        imprimirPerimetro()
        println("================================")
    }
}

// Subclase Cuadrado
class Cuadrado(val lado: Double) : Shape() {
    override val area: Double
        get() = calcularArea()

    override val perimetro: Double
        get() = calcularPerimetro()

    // Constructor secundario que recibe Int
    constructor(lado: Int) : this(lado.toDouble())

    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}

// Subclase Círculo
class Circulo(val radio: Double) : Shape() {
    override val area: Double
        get() = calcularArea()

    override val perimetro: Double
        get() = calcularPerimetro()

    // Constructor secundario que recibe Int
    constructor(radio: Int) : this(radio.toDouble())

    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}

// Subclase Rectángulo
class Rectangulo(val base: Double, val altura: Double) : Shape() {
    override val area: Double
        get() = calcularArea()

    override val perimetro: Double
        get() = calcularPerimetro()

    // Constructor secundario que recibe Int
    constructor(base: Int, altura: Int) : this(base.toDouble(), altura.toDouble())

    override fun calcularArea(): Double {
        return base * altura
    }

    override fun calcularPerimetro(): Double {
        return 2 * (base + altura)
    }
}

fun main() {
    println("=== PRUEBA DE FIGURAS GEOMÉTRICAS ===")

    val cuadrado = Cuadrado(5.0)
    val circulo = Circulo(3.0)
    val rectangulo = Rectangulo(4.0, 6.0)

    println("\n1. Cuadrado de lado 5.0")
    cuadrado.imprimirInformacion()

    println("\n2. Círculo de radio 3.0")
    circulo.imprimirInformacion()

    println("\n3. Rectángulo de base 4.0 y altura 6.0")
    rectangulo.imprimirInformacion()
}
