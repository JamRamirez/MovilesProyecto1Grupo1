package com.example.movilesproyecto1grupo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class ControlAhorro : AppCompatActivity() {

    private lateinit var  user: EditText
    private lateinit var edita: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_ahorro)

        user = findViewById(R.id.user)
        edita = findViewById(R.id.editar)

        edita.setOnClickListener {
            if (user.text.toString().isNotBlank()) {
                val intent = Intent(this, GestionarAhorro::class.java)
                intent.putExtra("clave", user.text.toString())
                startActivity(intent)
            } else {
                user.setError("El campo cedula no puede estar vacío") // Establece el mensaje de error
                user.requestFocus() // Solicita el foco en el campo de texto vacío
            }
        }

    }
}