package com.example.movilesproyecto1grupo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class AsignacionPrestamo : AppCompatActivity() {

    private lateinit var txtCed: TextView
    private lateinit var txtSalario: TextView
    private lateinit var txtPago: TextView
    private lateinit var edTxtPrestamo: EditText
    private lateinit var rdGroupPeriodo: RadioGroup
    private lateinit var rdGroupInteres: RadioGroup
    lateinit var btnConfirmar: Button
    lateinit var btnCalcular: Button
    private var limiteCredito = 0
    private var interes = 0.0f
    private var pagoMensual = 0.0f
    private var meses = 0
    private var credito = 0
    private var stringCed = ""
    private var stringNombre = ""
    private var stringSalario = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asignacion_prestamo)

        //Obteniendo los datos de el cliente Ingresado
        stringCed = intent.getStringExtra("StringCedula").toString()
        stringNombre = intent.getStringExtra("StringNombre").toString()
        stringSalario = intent.getStringExtra("StringSalario").toString()

        //Conectando con el View
        txtCed = findViewById(R.id.txtCed)
        txtSalario = findViewById(R.id.txtSalario)
        txtPago = findViewById(R.id.txtPago)
        edTxtPrestamo = findViewById(R.id.edTxtPrestamo)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnCalcular = findViewById(R.id.btnCalcular)
        rdGroupPeriodo = findViewById<RadioGroup>(R.id.rdGroupPeriodo)
        rdGroupInteres = findViewById<RadioGroup>(R.id.rdGroupInteres)

        // Calculando el Maximo limite de credito
        limiteCredito = (stringSalario.toString().toInt() * 0.45).toInt()

        //Seteando el Texto con los datos de el Cliente
        txtCed.setText("Cedula: "+ stringCed +" | Nombre: "+ stringNombre)
        txtSalario.setText("Salario: "+ stringSalario+ " | Limite de Prestamo: "+ limiteCredito)

        //Listener de el EditText
        edTxtPrestamo.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(edTxtPrestamo)){
                edTxtPrestamo.setError("Este campo debe ser llenado!")
            }else if (!hasFocus && !isInLimiteCredito(edTxtPrestamo.text.toString().toInt())){
                edTxtPrestamo.setError("Credito no puede superar "+ limiteCredito +"!")
            }
        }

        rdGroupPeriodo.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.rdBut3Anio){
                meses = 3 * 12
            }else if (checkedId == R.id.rdBut5Anio){
                meses = 5 * 12
            }else if (checkedId == R.id.rdBut10Anio){
                meses =  10 * 12
            }
        }

        rdGroupInteres.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.radBtnHipotecario){
                interes = 7.5f
            }else if (checkedId == R.id.radBtnEducacion){
                interes = 8f
            }else if (checkedId == R.id.radBtnPersonal){
                interes =  10f
            }else if(checkedId == R.id.radBtnViajes){
                interes = 12f
            }
        }

    }

    //Metodo que devuelve True si el Prestamo es menor que el Limite de credito
    private fun isInLimiteCredito(prestamo : Int): Boolean { return prestamo < limiteCredito }

    private fun noData(editText: EditText) : Boolean {
        return editText.text.toString().isEmpty()
    }

    private fun calcularPago() {
        val tasaMensual = interes / 1200
        var pagoTrim = ""
        pagoMensual = (credito * tasaMensual) / (1 - (1 + tasaMensual).pow(-meses))
        pagoTrim = String.format("%.2f", pagoMensual)
        pagoMensual = pagoTrim.toFloat()
    }
    fun continuar(vista:View){

        if(pagoMensual == 0.0f){
            Toast.makeText(this, "Para Confirmar el prestamo Primero Tiene que ser Calculado", Toast.LENGTH_SHORT).show()
            return
        }

        val helper = MyDatabaseHelper(applicationContext)
        val db = helper.readableDatabase

        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO) VALUES('" + stringCed + "'," + credito +","+ meses +","+ interes +","+ pagoMensual +")")
        db.close()

        Toast.makeText(this, "EXITO Prestamo Registrado", Toast.LENGTH_SHORT).show()

    }

    fun calcular(vista: View){

        if(noData(edTxtPrestamo)){
            edTxtPrestamo.setError("Este campo debe ser llenado!")
        }else if(!isInLimiteCredito(edTxtPrestamo.text.toString().toInt())){
            edTxtPrestamo.setError("Credito no puede superar "+ limiteCredito +"!")
        }

        if (edTxtPrestamo.error == null){
            credito = edTxtPrestamo.text.toString().toInt()
        }

        if (credito != 0 && meses != 0 && interes != 0.0f){
            calcularPago()
            txtPago.setText("Pago Mensual: " + pagoMensual)
        }else{
            Toast.makeText(this, "No todos los campos han sido correctamente llenados", Toast.LENGTH_SHORT).show()
        }

    }

}