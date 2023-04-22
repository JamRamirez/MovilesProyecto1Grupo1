package com.example.movilesproyecto1grupo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class PrincipalCliente : AppCompatActivity() {
    private lateinit var ahorros:Button
    private lateinit var informacion: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_cliente)



        /*val bundle = intent.extras
        val dat = bundle?.getString("username")
        Toast.makeText(this,dat,Toast.LENGTH_SHORT).show()*/

        ahorros = findViewById(R.id.btnGestionAhorros)

        informacion = findViewById(R.id.btnIformacionPersonal)

        ahorros.setOnClickListener {

        }
        informacion.setOnClickListener {
            startActivity(Intent(this,InformacionPersonal::class.java))
        }


    }
}