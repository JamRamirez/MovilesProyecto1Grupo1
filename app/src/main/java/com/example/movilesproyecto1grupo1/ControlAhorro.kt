package com.example.movilesproyecto1grupo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class ControlAhorro : AppCompatActivity() {

    lateinit var cbNavidena: CheckBox
    lateinit var cbEscolar: CheckBox
    lateinit var cbMarchamo: CheckBox
    lateinit var cbExtraordinaria: CheckBox
    lateinit var etMonto: EditText
    lateinit var btnActivarAhorro: Button
    lateinit var btnDesactivarAhorro: Button
    lateinit var tvNavidena: TextView
    lateinit var tvEscolar: TextView
    lateinit var tvMarchamo: TextView
    lateinit var tvExtraordinaria: TextView

    private var ahorroNavidena: Int = 0
    private var ahorroEscolar: Int = 0
    private var ahorroMarchamo: Int = 0
    private var ahorroExtraordinaria: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_ahorro)

        cbNavidena = findViewById(R.id.cbNavidena)
        cbEscolar = findViewById(R.id.cbEscolar)
        cbMarchamo = findViewById(R.id.cbMarchamo)
        cbExtraordinaria = findViewById(R.id.cbExtraordinaria)
        etMonto = findViewById(R.id.etMonto)
        btnActivarAhorro = findViewById(R.id.btnActivarAhorro)
        btnDesactivarAhorro = findViewById(R.id.btnDesactivarAhorro)
        tvNavidena = findViewById(R.id.tvNavidena)
        tvEscolar = findViewById(R.id.tvEscolar)
        tvMarchamo = findViewById(R.id.tvMarchamo)
        tvExtraordinaria = findViewById(R.id.tvExtraordinaria)

        btnActivarAhorro.setOnClickListener {
            activarAhorro()
        }

        btnDesactivarAhorro.setOnClickListener {
            desactivarAhorro()
        }
    }

    private fun activarAhorro() {
        val monto = etMonto.text.toString().toIntOrNull() ?: 0
        if (monto < 5000) {
            etMonto.error = "El monto mínimo es de 5000 colones."
            return
        }
        if (cbNavidena.isChecked) {
            ahorroNavidena = monto
        }
        if (cbEscolar.isChecked) {
            ahorroEscolar = monto
        }
        if (cbMarchamo.isChecked) {
            ahorroMarchamo = monto
        }
        if (cbExtraordinaria.isChecked) {
            ahorroExtraordinaria = monto
        }
        actualizarAhorros()
    }

    private fun desactivarAhorro() {
        cbNavidena.isChecked = false
        cbEscolar.isChecked = false
        cbMarchamo.isChecked = false
        cbExtraordinaria.isChecked = false
        ahorroNavidena = 0
        ahorroEscolar = 0
        ahorroMarchamo = 0
        ahorroExtraordinaria = 0
        actualizarAhorros()
    }
    private fun actualizarAhorros() {
        tvNavidena.text = "Navideña: ₡$ahorroNavidena"
        tvEscolar.text = "Escolar: ₡$ahorroEscolar"
        tvMarchamo.text = "Marchamo: ₡$ahorroMarchamo"
        tvExtraordinaria.text = "Extraordinaria: ₡$ahorroExtraordinaria"
    }
}