package com.example.hola_mundo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardHola = findViewById<CardView>(R.id.card_hola)
        val cardImc = findViewById<CardView>(R.id.card_imc)
        val cardConversion = findViewById<CardView>(R.id.card_conversion)
        val cardCotizacion = findViewById<CardView>(R.id.card_cotizacion)
        val cardMoneda = findViewById<CardView>(R.id.card_moneda)
        val cardSalir = findViewById<CardView>(R.id.card_salir)

        cardHola.setOnClickListener {
            val intent = Intent(this, HolaActivity::class.java)
            startActivity(intent)
        }

        cardImc.setOnClickListener {
            val intent = Intent(this, ActivityImc::class.java)
            startActivity(intent)
        }

        cardConversion.setOnClickListener {
            val intent = Intent(this, ActivityConvertidor::class.java)
            startActivity(intent)
        }

        cardCotizacion.setOnClickListener {
            val intent = Intent(this, ClienteActivity::class.java)
            startActivity(intent)
        }

        cardMoneda.setOnClickListener {
            val intent = Intent(this, ActivityMoneda::class.java)
            startActivity(intent)
        }

        cardSalir.setOnClickListener {
            finish() // Cierra la aplicación
        }
    }
}
