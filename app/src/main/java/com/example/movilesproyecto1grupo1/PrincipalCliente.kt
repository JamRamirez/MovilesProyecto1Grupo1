package com.example.movilesproyecto1grupo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PrincipalCliente : AppCompatActivity() {
    private lateinit var ahorros:Button
    private lateinit var informacion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_cliente)

        ahorros = findViewById(R.id.btnGestionAhorros)
        informacion = findViewById(R.id.btnIformacionPersonal)

        ahorros.setOnClickListener {
            startActivity(Intent(this,GestionarAhorros::class.java))
        }

        informacion.setOnClickListener {
            startActivity(Intent(this,InformacionPersonal::class.java))
        }
    }
}