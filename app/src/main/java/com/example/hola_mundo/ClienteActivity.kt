package com.example.hola_mundo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ClienteActivity : AppCompatActivity() {

    private lateinit var txtCliente: EditText
    private lateinit var btnEntrar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        iniciarComponentes()
        eventosClic()
    }

    private fun iniciarComponentes() {
        txtCliente = findViewById(R.id.txtCliente)
        btnEntrar = findViewById(R.id.btnEntrar)
        btnRegresar = findViewById(R.id.btnRegresar)
    }

    private fun eventosClic() {
        btnEntrar.setOnClickListener { 
            if (txtCliente.text.toString().isEmpty()) {
                Toast.makeText(this, getString(R.string.error_falta_nombre_cliente), Toast.LENGTH_SHORT).show()
                txtCliente.requestFocus()
            } else {
                val nombreCliente = txtCliente.text.toString()
                val intent = Intent(this, CotizacionActivity::class.java)
                intent.putExtra("cliente", nombreCliente)
                startActivity(intent)
            }
        }

        btnRegresar.setOnClickListener { 
            finish()
        }
    }
}
