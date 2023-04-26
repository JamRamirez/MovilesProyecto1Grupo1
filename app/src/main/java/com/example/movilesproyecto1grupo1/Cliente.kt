package com.example.movilesproyecto1grupo1

import android.database.sqlite.SQLiteConstraintException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Cliente : AppCompatActivity() {

    lateinit var cedula: EditText
    lateinit var nombre: EditText
    lateinit var salario: EditText
    lateinit var telefono: EditText
    lateinit var civil: EditText
    lateinit var direccion: EditText
    lateinit var registrar:Button
    lateinit var etDate:EditText
    lateinit var cumple:String
    lateinit var clienteDBHelper: MyDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cedula = findViewById(R.id.editTxtCed)
        nombre = findViewById(R.id.editTxtNombre)
        salario = findViewById(R.id.editTxtSalario)
        telefono = findViewById(R.id.editTxtTelefono)
        civil = findViewById(R.id.editTxtCivil)
        direccion = findViewById(R.id.editTxtDireccion)
        registrar = findViewById(R.id.btnRegistrar)
        etDate = findViewById(R.id.etDate)
        cumple = "Null"
        clienteDBHelper = MyDatabaseHelper(this)

        etDate.setOnClickListener{ showDatePickerDialog()}

        cedula.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(cedula)){
                cedula.setError("Este campo debe ser llenado!")
            }
        }

        nombre.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(nombre)){
                nombre.setError("Este campo debe ser llenado!")
            }
        }

        salario.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(salario)){
                salario.setError("Este campo debe ser llenado!")
            }
        }

        telefono.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(telefono)){
                telefono.setError("Este campo debe ser llenado!")
            }
        }

        civil.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(civil)){
                civil.setError("Este campo debe ser llenado!")
            }
        }

        direccion.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(direccion)){
                direccion.setError("Este campo debe ser llenado!")
            }
        }

    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment({day, month, year -> onDateSelected(day, month, year)})

        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day:Int, month:Int, year: Int){
        etDate.setText("$month/$day/$year")
        cumple = "$month/$day/$year"
    }

    private fun noData(editText: EditText) : Boolean {
        return editText.text.toString().isEmpty()
    }

    fun registrar(vista: View){

        if(noData(cedula)){
            cedula.setError("Este campo debe ser llenado!")
        }
        if(noData(nombre)){
            nombre.setError("Este campo debe ser llenado!")
        }
        if(noData(salario)){
            salario.setError("Este campo debe ser llenado!")
        }
        if(noData(telefono)){
            telefono.setError("Este campo debe ser llenado!")
        }
        if(noData(civil)){
            civil.setError("Este campo debe ser llenado!")
        }
        if(noData(direccion)){
            direccion.setError("Este campo debe ser llenado!")
        }

        if (cedula.error != null || nombre.error != null || salario.error != null || telefono.error != null || civil.error != null || direccion.error != null || cumple == "Null") {
            Toast.makeText(this, "Por favor, corrija los errores antes de continuar", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "EXITO Cedula: "+ cedula.text.toString(), Toast.LENGTH_LONG).show()

        var dbCed = cedula.text.toString().toInt()
        var dbNom = nombre.text.toString()
        var dbsal = salario.text.toString().toInt()
        var dbTel = telefono.text.toString()
        var dbCiv = civil.text.toString()
        var dbDir = direccion.text.toString()

        try {
            this.clienteDBHelper.addCliente(dbCed, dbNom, dbsal,dbTel, dbCiv,dbDir, cumple)
        } catch (e: SQLiteConstraintException){
            Toast.makeText(this, "ERROR Cedula: "+ cedula.text.toString() + " Ya Existe", Toast.LENGTH_LONG).show()
        }catch (e: Exception) {
            // Handle other exceptions here
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }

        Toast.makeText(this, "Cedula: "+ cedula.text.toString(), Toast.LENGTH_LONG).show()


    }

}