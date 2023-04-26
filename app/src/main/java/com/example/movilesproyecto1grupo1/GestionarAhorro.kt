package com.example.movilesproyecto1grupo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioGroup
import android.widget.Toast
class GestionarAhorro : AppCompatActivity() {

    lateinit var rbNavidena: RadioButton
    lateinit var rbEscolar: RadioButton
    lateinit var rbMarchamo: RadioButton
    lateinit var rbExtraordinaria: RadioButton
    lateinit var etMonto: EditText
    lateinit var btnActivar: Button
    lateinit var btnDesactivarAhorro: Button
    lateinit var tvNavidena: TextView
    lateinit var tvEscolar: TextView
    lateinit var tvMarchamo: TextView
    lateinit var tvExtraordinaria: TextView
    lateinit var tvNavidenaAcumulado: TextView
    lateinit var tvEscolarAcumulado: TextView
    lateinit var tvMarchamoAcumulado: TextView
    lateinit var tvExtraordinariaAcumulado: TextView
    lateinit var rgOpciones: RadioGroup
    lateinit var dbHelper: MyDatabaseHelper
    lateinit var tvEjemplo: TextView

    private var ahorroNavidena: Int = 0
    private var ahorroEscolar: Int = 0
    private var ahorroMarchamo: Int = 0
    private var ahorroExtraordinaria: Int = 0
    private var acumuladoNavidena: Int = 0
    private var acumuladoEscolar: Int = 0
    private var acumuladoMarchamo: Int = 0
    private var acumuladoExtraordinaria: Int = 0

    val TIPO_AHORRO_NAVIDENA = "Navideña"
    val TIPO_AHORRO_ESCOLAR = "Escolar"
    val TIPO_AHORRO_MARCHAMO = "Marchamo"
    val TIPO_AHORRO_EXTRAORDINARIO = "Extraordinaria"

    var stringIdCliente = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestionar_ahorro)

        stringIdCliente = intent.getStringExtra("clave").toString()
        dbHelper = MyDatabaseHelper(applicationContext)
        rbNavidena = findViewById(R.id.rbNavidena)
        rbEscolar = findViewById(R.id.rbEscolar)
        rbMarchamo = findViewById(R.id.rbMarchamo)
        rbExtraordinaria = findViewById(R.id.rbExtraordinaria)
        etMonto = findViewById(R.id.etMonto)
        btnActivar = findViewById(R.id.btnActivarAhorro)
        btnDesactivarAhorro = findViewById(R.id.btnDesactivarAhorro)
        tvNavidena = findViewById(R.id.tvNavidena)
        tvEscolar = findViewById(R.id.tvEscolar)
        tvMarchamo = findViewById(R.id.tvMarchamo)
        tvExtraordinaria = findViewById(R.id.tvExtraordinaria)
        rgOpciones = findViewById(R.id.rgOpciones)
        tvNavidenaAcumulado = findViewById(R.id.tvNavidenaAcumulado)
        tvEscolarAcumulado = findViewById(R.id.tvEscolarAcumulado)
        tvMarchamoAcumulado = findViewById(R.id.tvMarchamoAcumulado)
        tvExtraordinariaAcumulado = findViewById(R.id.tvExtraordinariaAcumulado)
        tvEjemplo = findViewById(R.id.tvEjemplo)

        btnActivar.setOnClickListener {
            activarAhorro()
        }

        btnDesactivarAhorro.setOnClickListener {
            desactivarAhorro()
        }

        tvEjemplo.text = stringIdCliente

    }


    private fun activarAhorro() {
        val monto = etMonto.text.toString().toIntOrNull()
        if (monto != null && monto >= 5000) {
            // Validamos que el monto ingresado sea un número válido y mayor o igual a 5000
            // Guardamos el monto en la base de datos
            val tipoAhorro = obtenerTipoAhorroSeleccionado()
            dbHelper.activarAhorro(monto, tipoAhorro, stringIdCliente.toInt())
            actualizarAhorros()
        } else {
            // Mostramos un mensaje de error si el monto no es válido
            Toast.makeText(this, "El monto mínimo de ahorro es de 5000 colones", Toast.LENGTH_SHORT).show()
        }
    }

    private fun obtenerTipoAhorroSeleccionado(): String {
        when (rgOpciones.checkedRadioButtonId) {
            R.id.rbNavidena -> return TIPO_AHORRO_NAVIDENA
            R.id.rbEscolar -> return TIPO_AHORRO_ESCOLAR
            R.id.rbMarchamo -> return TIPO_AHORRO_MARCHAMO
            R.id.rbExtraordinaria -> return TIPO_AHORRO_EXTRAORDINARIO
            else -> return ""
        }
    }

    private fun desactivarAhorro() {
        if (rbNavidena.isChecked) {
            rbNavidena.isChecked = false
            ahorroNavidena = 0
        }
        if (rbEscolar.isChecked) {
            rbEscolar.isChecked = false
            ahorroEscolar = 0
        }
        if (rbMarchamo.isChecked) {
            rbMarchamo.isChecked = false
            ahorroMarchamo = 0
        }
        if (rbExtraordinaria.isChecked) {
            rbExtraordinaria.isChecked = false
            ahorroExtraordinaria = 0
        }
        actualizarAhorros()
    }
    private fun actualizarAhorros() {
        tvNavidena.text = "Navideña: ₡$ahorroNavidena"
        tvEscolar.text = "Escolar: ₡$ahorroEscolar"
        tvMarchamo.text = "Marchamo: ₡$ahorroMarchamo"
        tvExtraordinaria.text = "Extraordinaria: ₡$ahorroExtraordinaria"

        tvNavidenaAcumulado.text = "Acumulado navideño: ₡$acumuladoNavidena"
        tvEscolarAcumulado.text = "Acumulado escolar: ₡$acumuladoEscolar"
        tvMarchamoAcumulado.text = "Acumulado marchamo: ₡$acumuladoMarchamo"
        tvExtraordinariaAcumulado.text = "Acumulado extraordinario: ₡$acumuladoExtraordinaria"

    }
}