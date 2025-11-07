package com.example.hola_mundo

import kotlin.random.Random

class Cotizacion {
    var descripcion: String = ""
    var precio: Float = 0.0f
    var porPagInicial: Float = 0.0f
    var plazos: Int = 0

    fun generaFolio(): Int {
        return Random.nextInt(1000, 9999)
    }

    fun calcularPagoInicial(): Float {
        return precio * (porPagInicial / 100)
    }

    fun calcularTotalFin(): Float {
        return precio - calcularPagoInicial()
    }

    fun calcularPagoMensual(): Float {
        if (plazos == 0) {
            return 0f
        }
        return calcularTotalFin() / plazos
    }
}
