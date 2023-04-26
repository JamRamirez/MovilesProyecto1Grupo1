package com.example.movilesproyecto1grupo1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class PrincipalCliente : AppCompatActivity() {
    private lateinit var ahorros: Button
    private lateinit var informacion: Button
    private lateinit var verPrestamo: Button
    private var stringUser = ""
    private var stringCed = ""

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_cliente)

        stringUser = intent.getStringExtra("stringUser").toString()
        stringCed = intent.getStringExtra("stringPass").toString()

        ahorros = findViewById(R.id.btnGestionAhorros)
        verPrestamo = findViewById(R.id.btnPrestamos)

        ahorros.setOnClickListener {
            startActivity(Intent(this, ControlAhorro::class.java))
        }

        verPrestamo.setOnClickListener {
            val Intent = Intent(this, VerPrestamos::class.java)
                Intent.putExtra("stringUser",stringUser)
                Intent.putExtra("stringPass",stringCed)

            startActivity(Intent(this, VerPrestamos::class.java))
            startActivity(Intent)
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