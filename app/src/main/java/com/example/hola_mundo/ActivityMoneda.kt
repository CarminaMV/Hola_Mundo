package com.example.hola_mundo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityMoneda : AppCompatActivity() {

    private lateinit var txtCantidad: EditText
    private lateinit var spnMonedas: Spinner
    private lateinit var txtResultado: TextView
    private lateinit var btnConvertir: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnSalir: Button

    // Tasas de conversión (ejemplo: 1 Peso Mexicano a...)
    private val MXN_TO_USD_RATE = 0.059 // 1 MXN = 0.059 USD
    private val MXN_TO_EUR_RATE = 0.054 // 1 MXN = 0.054 EUR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moneda)

        iniciarComponentes()
        eventosClic()
    }

    private fun iniciarComponentes() {
        txtCantidad = findViewById(R.id.txtCantidad)
        spnMonedas = findViewById(R.id.spnMonedas)
        txtResultado = findViewById(R.id.txtResultado)
        btnConvertir = findViewById(R.id.btnConvertir)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnSalir = findViewById(R.id.btnSalir)

        // Configurar el Spinner
        val monedas = arrayOf("Dólar (USD)", "Euro (EUR)")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, monedas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnMonedas.adapter = adapter
    }

    private fun eventosClic() {
        btnConvertir.setOnClickListener {
            val cantidadStr = txtCantidad.text.toString()
            if (cantidadStr.isNotEmpty()) {
                val cantidad = cantidadStr.toDouble()
                val monedaSeleccionada = spnMonedas.selectedItem.toString()
                var resultado = 0.0

                if (monedaSeleccionada == "Dólar (USD)") {
                    resultado = cantidad * MXN_TO_USD_RATE
                    txtResultado.text = getString(R.string.formato_resultado_usd, resultado)
                } else if (monedaSeleccionada == "Euro (EUR)") {
                    resultado = cantidad * MXN_TO_EUR_RATE
                    txtResultado.text = getString(R.string.formato_resultado_eur, resultado)
                }
            } else {
                Toast.makeText(this, getString(R.string.error_falta_cantidad), Toast.LENGTH_SHORT).show()
            }
        }

        btnLimpiar.setOnClickListener {
            txtCantidad.text.clear()
            txtResultado.text = getString(R.string.strResultadoM)
        }

        btnSalir.setOnClickListener {
            finish() // Cierra esta pantalla y regresa al menú
        }
    }
}
