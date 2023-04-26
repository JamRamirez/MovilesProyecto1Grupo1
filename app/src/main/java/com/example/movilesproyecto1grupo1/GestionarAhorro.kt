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
    lateinit var rgOpciones: RadioGroup
    lateinit var dbHelper: MyDatabaseHelper


    private var ahorroNavidena: Int = 0
    private var ahorroEscolar: Int = 0
    private var ahorroMarchamo: Int = 0
    private var ahorroExtraordinaria: Int = 0


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


        btnActivar.setOnClickListener {
            activarAhorro()
        }

        btnDesactivarAhorro.setOnClickListener {
            desactivarAhorro()
        }


        val idCliente = stringIdCliente.toInt()
        ahorroNavidena = dbHelper.obtenerMontoAhorro(TIPO_AHORRO_NAVIDENA, idCliente)
        ahorroEscolar = dbHelper.obtenerMontoAhorro(TIPO_AHORRO_ESCOLAR, idCliente)
        ahorroMarchamo = dbHelper.obtenerMontoAhorro(TIPO_AHORRO_MARCHAMO, idCliente)
        ahorroExtraordinaria = dbHelper.obtenerMontoAhorro(TIPO_AHORRO_EXTRAORDINARIO, idCliente)

        tvNavidena.text = "Monto Navideña: $ahorroNavidena"
        tvEscolar.text = "Monto Escolar: $ahorroEscolar"
        tvMarchamo.text = "Monto Marchamo: $ahorroMarchamo"
        tvExtraordinaria.text = "Monto Extraordinaria: $ahorroExtraordinaria"
    }


    private fun activarAhorro() {
        val monto = etMonto.text.toString().toIntOrNull()
        if (monto != null && monto >= 5000) {
            // Validamos que el monto ingresado sea un número válido y mayor o igual a 5000
            // Guardamos el monto en la base de datos
            val tipoAhorro = obtenerTipoAhorroSeleccionado()
            dbHelper.activarAhorro(monto, tipoAhorro, stringIdCliente.toInt())

            // Actualizar los TextView con los montos de ahorro
            ahorroNavidena = dbHelper.obtenerMontoAhorro(TIPO_AHORRO_NAVIDENA, stringIdCliente.toInt())
            ahorroEscolar = dbHelper.obtenerMontoAhorro(TIPO_AHORRO_ESCOLAR, stringIdCliente.toInt())
            ahorroMarchamo = dbHelper.obtenerMontoAhorro(TIPO_AHORRO_MARCHAMO, stringIdCliente.toInt())
            ahorroExtraordinaria = dbHelper.obtenerMontoAhorro(TIPO_AHORRO_EXTRAORDINARIO, stringIdCliente.toInt())

            tvNavidena.text = "Monto Navideña: $ahorroNavidena"
            tvEscolar.text = "Monto Escolar: $ahorroEscolar"
            tvMarchamo.text = "Monto Marchamo: $ahorroMarchamo"
            tvExtraordinaria.text = "Monto Extraordinaria: $ahorroExtraordinaria"
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
                tvNavidena.text = "Monto Navideña: 0"
                dbHelper.eliminarAhorro(TIPO_AHORRO_NAVIDENA, stringIdCliente.toInt())
            }
            if (rbEscolar.isChecked) {
                rbEscolar.isChecked = false
                tvEscolar.text = "Monto Escolar: 0"
                dbHelper.eliminarAhorro(TIPO_AHORRO_ESCOLAR, stringIdCliente.toInt())
            }
            if (rbMarchamo.isChecked) {
                rbMarchamo.isChecked = false
                tvMarchamo.text = "Monto Marchamo: 0"
                dbHelper.eliminarAhorro(TIPO_AHORRO_MARCHAMO, stringIdCliente.toInt())
            }
            if (rbExtraordinaria.isChecked) {
                rbExtraordinaria.isChecked = false
                tvExtraordinaria.text = "Monto Extraordinaria: 0"
                dbHelper.eliminarAhorro(TIPO_AHORRO_EXTRAORDINARIO, stringIdCliente.toInt())
            }
        }


    }