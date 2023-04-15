package com.example.movilesproyecto1grupo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Administrative : AppCompatActivity() {

    lateinit var btnAddClient: Button
    lateinit var btnAssignLoan: Button
    lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddClient = findViewById<Button>(R.id.btnAddClient)
        btnAssignLoan = findViewById<Button>(R.id.btnAssignLoan)
        btnLogout = findViewById<Button>(R.id.btnLogout)
        btnAddClient.setOnClickListener {
            // Acción para el botón de Agregar un cliente nuevo
        }

        btnAssignLoan.setOnClickListener {
            // Acción para el botón de Asignar un Préstamo a un cliente
        }

        btnLogout.setOnClickListener {
            // Acción para el botón de Cerrar sesión
        }
    }
}
