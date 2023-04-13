package com.example.movilesproyecto1grupo1

/* Estudiantes:
*  Jam Carlos Ramirez Chaves
*  Marlen Badilla Campos
*  Fabiana Barrantes Li
*/

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var cedula: EditText
    lateinit var nombre: EditText
    lateinit var salario: EditText
    lateinit var telefono: EditText
    lateinit var civil: EditText
    lateinit var direccion: EditText
    lateinit var registrar:Button
    lateinit var etDate:EditText
    lateinit var cumple:String

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

        etDate.setOnClickListener{ showDatePickerDialog()}

        cedula.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(cedula)){
                cedula.setError("ERROR1, Este campo debe ser llenado!")
            }
        }

        nombre.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(nombre)){
                nombre.setError("ERROR1, Este campo debe ser llenado!")
            }
        }

        salario.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(salario)){
                salario.setError("ERROR1, Este campo debe ser llenado!")
            }
        }

        telefono.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(telefono)){
                telefono.setError("ERROR1, Este campo debe ser llenado!")
            }
        }

        civil.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(civil)){
                civil.setError("ERROR1, Este campo debe ser llenado!")
            }
        }

        direccion.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(direccion)){
                direccion.setError("ERROR1, Este campo debe ser llenado!")
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
            cedula.setError("ERROR1, Este campo debe ser llenado!")
        }
        if(noData(nombre)){
            nombre.setError("ERROR1, Este campo debe ser llenado!")
        }
        if(noData(salario)){
            salario.setError("ERROR1, Este campo debe ser llenado!")
        }
        if(noData(telefono)){
            telefono.setError("ERROR1, Este campo debe ser llenado!")
        }
        if(noData(civil)){
            civil.setError("ERROR1, Este campo debe ser llenado!")
        }
        if(noData(direccion)){
            direccion.setError("ERROR1, Este campo debe ser llenado!")
        }

        if (cedula.error != null || nombre.error != null || salario.error != null || telefono.error != null || civil.error != null || direccion.error != null || cumple == "Null") {
            Toast.makeText(this, "Por favor, corrija los errores antes de continuar", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "EXITO", Toast.LENGTH_LONG).show()

    }

}