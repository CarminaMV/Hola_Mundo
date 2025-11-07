package com.example.hola_mundo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityImc : AppCompatActivity() {

    private lateinit var txtAltura: EditText
    private lateinit var txtPeso: EditText
    private lateinit var lblResultadoImc: TextView
    private lateinit var btnCalcularImc: Button
    private lateinit var btnLimpiarImc: Button
    private lateinit var btnCerrarImc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniciarComponentes()
        eventosClic()
    }

    private fun iniciarComponentes() {
        txtAltura = findViewById(R.id.txtAltura)
        txtPeso = findViewById(R.id.txtPeso)
        lblResultadoImc = findViewById(R.id.lblResultadoImc)
        btnCalcularImc = findViewById(R.id.btnCalcularImc)
        btnLimpiarImc = findViewById(R.id.btnLimpiarImc)
        btnCerrarImc = findViewById(R.id.btnCerrarImc)
    }

    private fun eventosClic() {
        btnCalcularImc.setOnClickListener {
            val alturaStr = txtAltura.text.toString()
            val pesoStr = txtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura = alturaStr.toFloat()
                val peso = pesoStr.toFloat()

                if (altura > 0 && peso > 0) {
                    // Fórmula del IMC: peso (kg) / [altura (m)]^2
                    val imc = peso / (altura * altura)
                    val resultado = String.format("Su IMC es: %.2f", imc)
                    lblResultadoImc.text = resultado
                } else {
                    Toast.makeText(this, "La altura y el peso deben ser mayores a cero", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, capture la altura y el peso", Toast.LENGTH_SHORT).show()
            }
        }

        btnLimpiarImc.setOnClickListener {
            txtAltura.text.clear()
            txtPeso.text.clear()
            lblResultadoImc.text = getString(R.string.resultado_aqui)
        }

        btnCerrarImc.setOnClickListener {
            finish()
        }
    }
}
