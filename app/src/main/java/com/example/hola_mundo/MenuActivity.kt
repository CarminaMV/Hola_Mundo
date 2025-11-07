package com.example.hola_mundo

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
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

        IniciarComponentes()
        eventosBotones()
    }

    fun IniciarComponentes() {
        // relacionar los componentes del layout con los objetos de kotlin
        lblSaludo= findViewById(R.id.LblSaludar) as TextView
        txtNombre = findViewById(R.id.txtNombre) as EditText
        btnSaludar = findViewById(R.id.btnSaludo)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)
    }

    fun eventosBotones() {

        btnSaludar.setOnClickListener(View.OnClickListener {
            // declarar variables
            var strNombre: String = ""
            if (txtNombre.text.toString().contentEquals("")) {
                Toast.makeText(
                    applicationContext,
                    "Falto capturar el Nombre",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                strNombre = "Hola " + txtNombre.text.toString() + " ¿Cómo estás?"
                // asignar nombre al EditText
                lblSaludo.text = strNombre
            }
        }) // termina btnSaludar

        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtNombre.setText("")
            lblSaludo.setText("")
        }) // termina btnLimpiar


        btnCerrar.setOnClickListener(View.OnClickListener {

            val builder = AlertDialog.Builder(this@MenuActivity)
            builder.setTitle("App Hola ")
            builder.setMessage(" ¿Deseas Salir de la aplicacion ?")
            builder.setPositiveButton("Aceptar") { dialog, _ ->
                finish()
            }
            builder.setNegativeButton("Cancelar") { dialog, _ ->
                Toast.makeText(
                    applicationContext,
                    "Cancelar",
                    Toast.LENGTH_SHORT
                ).show()
            }

            builder.setNeutralButton("Quizá") { dialog, _ ->
                Toast.makeText(
                    applicationContext,
                    "Quizá",
                    Toast.LENGTH_SHORT
                ).show()
            }

            builder.show()

        }) //termina btnCerrar

    }
}
