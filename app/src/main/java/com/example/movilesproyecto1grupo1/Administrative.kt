package com.example.movilesproyecto1grupo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class Administrative : AppCompatActivity() {

    lateinit var btnAddClient: Button
    lateinit var btnAssignLoan: Button
    lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administrative)

        btnAddClient = findViewById<Button>(R.id.btnAddClient)
        btnAssignLoan = findViewById<Button>(R.id.btnAssignLoan)
        btnLogout = findViewById<Button>(R.id.btnLogout)

        btnAddClient.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnAssignLoan.setOnClickListener {
            // Acción para el botón de Asignar un Préstamo a un cliente, esperar a que verifiquemos cm se va a gestionar
        }

        btnLogout.setOnClickListener {
            val intent = Intent(this,Home::class.java)
            startActivity(intent)
            finish()
        }
    }
}
