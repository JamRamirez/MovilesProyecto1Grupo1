package com.example.movilesproyecto1grupo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class ControlAhorro : AppCompatActivity() {

    private lateinit var  user: EditText
    private lateinit var edita: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_ahorro)

        user = findViewById(R.id.user)
        edita = findViewById(R.id.editar)

        val helper = MyDatabaseHelper(applicationContext)
        val db = helper.readableDatabase

        edita.setOnClickListener {
            val selectionArgs = arrayOf(user.text.toString())
            val rs = db.rawQuery("SELECT * FROM cliente WHERE cliente_cedula = ?", selectionArgs)

            if(user.text.toString().isBlank()){
                Toast.makeText(applicationContext, "El Campo cédula,vacio", Toast.LENGTH_SHORT).show()
            }else if (rs.moveToNext()) {
                val intent = Intent(this, GestionarAhorro::class.java)
                intent.putExtra("clave", user.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext, "Ha ingresado una cedula incorrecta", Toast.LENGTH_SHORT).show()
            }
        }

    }
}