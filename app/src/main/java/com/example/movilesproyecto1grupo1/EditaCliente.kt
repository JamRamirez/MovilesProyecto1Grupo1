package com.example.movilesproyecto1grupo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditaCliente : AppCompatActivity() {

    private lateinit var actualiza:Button
    private lateinit var nom:EditText
    private lateinit var salario: EditText
    private lateinit var tele: EditText
    private lateinit var estado: EditText
    private lateinit var direcc: EditText
    private lateinit var naci: EditText
    lateinit var cumple:String

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edita_cliente)

        nom = findViewById(R.id.nombreM)
        salario = findViewById(R.id.salarioM)
        actualiza = findViewById(R.id.actualizaM)
        tele = findViewById(R.id.telefonoM)
        estado = findViewById(R.id.estadoM)
        direcc = findViewById(R.id.direccionM)
        naci = findViewById(R.id.nacimientoM)
        cumple = "Null"


        val bundle = intent.extras
        val dato = bundle?.getString("clave")
        Toast.makeText(this,dato,Toast.LENGTH_LONG).show()

        val helper = MyDatabaseHelper(applicationContext)
        naci.setOnClickListener{ showDatePickerDialog()}


        actualiza.setOnClickListener {
            val aux = dato.toString().toInt()
            if(nom.text.isNotBlank() && salario.text.isNotBlank() && tele.text.isNotBlank() && estado.text.isNotBlank()
                && direcc.text.isNotBlank() && cumple.isNotBlank()){
                helper.modifica(aux,nom.text.toString(),salario.text.toString().toInt(),
                tele.text.toString(),estado.text.toString(),direcc.text.toString(),cumple)
                nom.text.clear()
                salario.text.clear()
                tele.text.clear()
                estado.text.clear()
                direcc.text.clear()
                cumple=""
                Toast.makeText(this,"Información Actualizada",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"No debe dejar campos vacios",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun onDateSelected(day:Int, month:Int, year: Int){
        naci.setText("$month/$day/$year")
        cumple = "$month/$day/$year"
    }
    fun showDatePickerDialog() {
        val datePicker = DatePickerFragment({day, month, year -> onDateSelected(day, month, year)})

        datePicker.show(supportFragmentManager, "datePicker")
    }
}