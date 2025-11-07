package com.example.hola_mundo

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HolaActivity : AppCompatActivity() {
    private lateinit var lblSaludo: TextView
    private lateinit var txtNombre: EditText
    private lateinit var btnSaludar: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hola)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniciarComponentes()
        eventosBotones()
    }

    private fun iniciarComponentes() {
        lblSaludo = findViewById(R.id.LblSaludar)
        txtNombre = findViewById(R.id.txtNombre)
        btnSaludar = findViewById(R.id.btnSaludo)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)
    }

    private fun eventosBotones() {
        btnSaludar.setOnClickListener { 
            if (txtNombre.text.toString().isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Falto capturar el Nombre",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val strNombre = "Hola " + txtNombre.text.toString() + " ¿Cómo estás?"
                lblSaludo.text = strNombre
            }
        }

        btnLimpiar.setOnClickListener { 
            txtNombre.setText("")
            lblSaludo.text = ""
        } 

        btnCerrar.setOnClickListener { 
            val builder = AlertDialog.Builder(this@HolaActivity)
            builder.setTitle("App Hola ")
            builder.setMessage(" ¿Deseas Salir de la aplicacion ?")
            builder.setPositiveButton("Aceptar") { _, _ ->
                finish()
            }
            builder.setNegativeButton("Cancelar") { _, _ ->
                Toast.makeText(
                    applicationContext,
                    "Cancelar",
                    Toast.LENGTH_SHORT
                ).show()
            }
            builder.setNeutralButton("Quizá") { _, _ ->
                Toast.makeText(
                    applicationContext,
                    "Quizá",
                    Toast.LENGTH_SHORT
                ).show()
            }
            builder.show()
        } 
    }
}
