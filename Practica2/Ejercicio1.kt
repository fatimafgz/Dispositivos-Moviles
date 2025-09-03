/*
Descripción: Clase para Cuenta Bancaria -  Diseña una clase CuentaBancaria que tenga un saldo y un límite de retiro. Implementa métodos set y get para establecer y obtener el saldo, y añade un metodo para realizar retiros que tenga en cuenta el límite de retiro.
Autor: Fatima Florez
Fecha creación: 31/08/2025
Fecha última modificación: 31/08/2025
*/

class CuentaBancaria {
    private var saldo: Double = 0.0
    private var limiteRetiro: Double = 1000.0

    // Getter para saldo
    fun getSaldo(): Double {
        return saldo
    }

    // Setter para saldo
    fun setSaldo(nuevoSaldo: Double): Boolean {
        return if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
            true
        } else {
            println("Error: El saldo no puede ser negativo")
            false
        }
    }

    // Getter para límite de retiro
    fun getLimiteRetiro(): Double {
        return limiteRetiro
    }

    // Setter para límite de retiro
    fun setLimiteRetiro(nuevoLimite: Double): Boolean {
        return if (nuevoLimite >= 0) {
            limiteRetiro = nuevoLimite
            true
        } else {
            println("Error: El límite de retiro no puede ser negativo")
            false
        }
    }

    // Metodo para realizar retiros con validación del límite
    fun retirar(monto: Double): Boolean {
        if (monto <= 0) {
            println("Error: El monto a retirar debe ser mayor a cero")
            return false
        }

        if (monto > limiteRetiro) {
            println("Error: El monto excede el límite de retiro (${limiteRetiro})")
            return false
        }

        if (monto > saldo) {
            println("Error: Fondos insuficientes. Saldo actual: ${saldo}")
            return false
        }

        saldo -= monto
        println("Retiro exitoso: ${monto}. Saldo restante: ${saldo}")
        return true
    }

    // Metodo para depositar dinero
    fun depositar(monto: Double): Boolean {
        if (monto <= 0) {
            println("Error: El monto a depositar debe ser mayor a cero")
            return false
        }
        saldo += monto
        println("Depósito exitoso: ${monto}. Saldo actual: ${saldo}")
        return true
    }

    // Metodo para mostrar información de la cuenta
    fun mostrarInformacion() {
        println("=== INFORMACIÓN DE LA CUENTA ===")
        println("Saldo actual: ${saldo}")
        println("Límite de retiro: ${limiteRetiro}")
        println("================================")
    }
}


fun main() {
    val cuenta = CuentaBancaria()

    // Configurar saldo y límite de retiro
    cuenta.setSaldo(3000.0)
    cuenta.setLimiteRetiro(1500.0)

    // Mostrar estado inicial
    cuenta.mostrarInformacion()

    // Probar un depósito válido
    println("\n--- Depósito de \$500 ---")
    cuenta.depositar(500.0)

    // Probar un retiro válido
    println("\n--- Retiro de \$1200 ---")
    cuenta.retirar(1200.0)

    // Probar un retiro que excede el límite
    println("\n--- Retiro de \$2000 (excede límite) ---")
    cuenta.retirar(2000.0)

    // Probar un retiro con fondos insuficientes
    println("\n--- Retiro de \$5000 (fondos insuficientes) ---")
    cuenta.retirar(5000.0)

    // Mostrar estado final
    println()
    cuenta.mostrarInformacion()
}
