package com.example.movilesproyecto1grupo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AsignacionPrestamo : AppCompatActivity() {

    private lateinit var cedText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asignacion_prestamo)
        val StringCed = intent.getStringExtra("StringCedula")

        cedText = findViewById(R.id.txtCed)

        cedText.setText(StringCed)
    }
}