package com.example.movilesproyecto1grupo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class PrincipalCliente : AppCompatActivity() {
    private lateinit var ahorros: Button
    private lateinit var informacion: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_cliente)

        ahorros = findViewById(R.id.btnGestionAhorros)

        ahorros.setOnClickListener {
            startActivity(Intent(this, ControlAhorro::class.java))
        }

        /*val bundle = intent.extras
        val dat = bundle?.getString("username")
        Toast.makeText(this,dat,Toast.LENGTH_SHORT).show()*/

        informacion = findViewById(R.id.btnIformacionPersonal)

        informacion.setOnClickListener {
            startActivity(Intent(this,InformacionPersonal::class.java))
        }


    }
}