package com.example.hola_mundo

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class ActivityConvertidor : AppCompatActivity() {

    private lateinit var txtCantidad: TextInputEditText
    private lateinit var txtResultado: TextView
    private lateinit var rdbCel: RadioButton
    private lateinit var rdbFar: RadioButton
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_convertidor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        iniciarComponentes()
        eventosClic()
    }

    private fun iniciarComponentes() {
        txtCantidad = findViewById(R.id.txtCantidad)
        txtResultado = findViewById(R.id.txtResultado)
        rdbCel = findViewById(R.id.rdbCel)
        rdbFar = findViewById(R.id.rdbFar)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnCerrar = findViewById(R.id.btnCerrar)
        btnLimpiar = findViewById(R.id.btnLimpiar)
    }

    private fun eventosClic() {
        btnCalcular.setOnClickListener {
            if (txtCantidad.text.toString().isEmpty()) {
                Toast.makeText(this, "Falto capturar Cantidad", Toast.LENGTH_SHORT).show()
            } else {
                val cantidad = txtCantidad.text.toString().toFloat()
                if (rdbCel.isChecked) {
                    val fahrenheit = (cantidad * 9 / 5) + 32
                    txtResultado.text = fahrenheit.toString()
                } else if (rdbFar.isChecked) {
                    val celsius = (cantidad - 32) * 5 / 9
                    txtResultado.text = celsius.toString()
                }
            }
        }

        btnLimpiar.setOnClickListener {
            txtCantidad.text?.clear()
            txtResultado.text = ""
        }

        btnCerrar.setOnClickListener {
            finish()
        }
    }
}
