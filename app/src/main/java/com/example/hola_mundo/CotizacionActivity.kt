package com.example.hola_mundo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs

class CotizacionActivity : AppCompatActivity() {

    private lateinit var txtCliente: TextView
    private lateinit var txtFolio: TextView
    private lateinit var txtDescripcion: EditText
    private lateinit var txtPrecio: EditText
    private lateinit var txtPorPag1: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var txtPagoInicial: TextView
    private lateinit var txtTotalFin: TextView
    private lateinit var txtPagoMensual: TextView

    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotizacion)

        iniciarComponentes()
        eventosClic()
    }

    private fun iniciarComponentes() {
        txtCliente = findViewById(R.id.txtCliente)
        txtFolio = findViewById(R.id.txtFolio)
        txtDescripcion = findViewById(R.id.txtDescripcion)
        txtPrecio = findViewById(R.id.txtPrecio)
        txtPorPag1 = findViewById(R.id.txtPorPag1)
        radioGroup = findViewById(R.id.radioGroup)
        txtPagoInicial = findViewById(R.id.txtPagoInicial)
        txtPagoMensual = findViewById(R.id.txtPagoMensual)
        txtTotalFin = findViewById(R.id.txtTotalFin)

        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)

        val strCliente: String = intent.getStringExtra("cliente") ?: getString(R.string.cliente_no_especificado)
        txtCliente.text = getString(R.string.cliente_label_format, strCliente)

        val folio: Int = abs(Cotizacion().generaFolio())
        txtFolio.text = getString(R.string.folio_format, folio)
    }

    private fun eventosClic() {
        btnCalcular.setOnClickListener {
            if (txtDescripcion.text.isEmpty() || txtPrecio.text.isEmpty() || txtPorPag1.text.isEmpty()) {
                Toast.makeText(this, getString(R.string.error_datos_faltantes), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val cotizacion = Cotizacion().apply {
                descripcion = txtDescripcion.text.toString()
                precio = txtPrecio.text.toString().toFloat()
                porPagInicial = txtPorPag1.text.toString().toFloat()
                plazos = when (radioGroup.checkedRadioButtonId) {
                    R.id.rdb12 -> 12
                    R.id.rdb24 -> 24
                    R.id.rdb36 -> 36
                    R.id.rdb48 -> 48
                    else -> 0
                }
            }

            txtPagoInicial.text = getString(R.string.pago_inicial_format, cotizacion.calcularPagoInicial())
            txtTotalFin.text = getString(R.string.total_financiar_format, cotizacion.calcularTotalFin())
            txtPagoMensual.text = getString(R.string.pago_mensual_format, cotizacion.calcularPagoMensual())
        }

        btnLimpiar.setOnClickListener {
            txtDescripcion.text.clear()
            txtPrecio.text.clear()
            txtPorPag1.text.clear()
            txtPagoInicial.text = getString(R.string.pago_inicial_label)
            txtTotalFin.text = getString(R.string.total_financiar_label)
            txtPagoMensual.text = getString(R.string.pago_mensual_label)
            radioGroup.check(R.id.rdb12)
        }

        btnCerrar.setOnClickListener {
            finish()
        }
    }
}
