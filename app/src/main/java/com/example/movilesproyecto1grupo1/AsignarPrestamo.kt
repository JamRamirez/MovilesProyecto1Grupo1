package com.example.movilesproyecto1grupo1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AsignarPrestamo : AppCompatActivity() {

    private lateinit var continuar: Button
    private lateinit var cedula: EditText

    @SuppressLint("Range")
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

            if (rs.moveToFirst()){
                Toast.makeText(applicationContext,"Cliente Encontrado!",Toast.LENGTH_LONG).show()
                val intent = Intent(this, AsignacionPrestamo::class.java).apply {

                    val cedulaDB = rs.getString(rs.getColumnIndex("cliente_cedula"))
                    val nombreDB = rs.getString(rs.getColumnIndex("cliente_nombre"))
                    val salarioDB = rs.getString(rs.getColumnIndex("cliente_salario"))

                    putExtra("StringCedula", cedulaDB)
                    putExtra("StringNombre", nombreDB)
                    putExtra("StringSalario", salarioDB)
                }
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"ERROR, Cliente No Existe!",Toast.LENGTH_LONG).show()
            }
        }

    }
}