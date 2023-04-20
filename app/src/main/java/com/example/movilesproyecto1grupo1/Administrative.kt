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
            val intent = Intent(this,Cliente::class.java)
            startActivity(intent)
            finish()
        }

        btnAssignLoan.setOnClickListener {
            val intent = Intent(this,AsignarPrestamo::class.java)
            startActivity(intent)
            finish()
        }

        btnLogout.setOnClickListener {
            val intent = Intent(this,IniciarSesion::class.java)
            startActivity(intent)
            finish()
        }
    }
}
