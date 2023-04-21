package com.example.movilesproyecto1grupo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AsignarPrestamo : AppCompatActivity() {

    private lateinit var continuar: Button
    private lateinit var cedula: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asignar_prestamo)

        cedula = findViewById(R.id.edTxtCedula)
        continuar = findViewById(R.id.btnContinuar)
        val helper = MyDatabaseHelper(applicationContext)
        val db = helper.readableDatabase

        continuar.setOnClickListener{
            val selectionArgs = arrayOf(cedula.text.toString())
            val rs = db. rawQuery("SELECT * FROM cliente WHERE cliente_cedula = ?", selectionArgs)

            if (rs.moveToNext()){
                Toast.makeText(applicationContext,"Cliente Encontrado!",Toast.LENGTH_LONG).show()
                val intent = Intent(this, AsignacionPrestamo::class.java).apply {
                    putExtra("StringCedula", cedula.text.toString())
                }
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"ERROR, Cliente No Existe!",Toast.LENGTH_LONG).show()
            }
        }

    }
}