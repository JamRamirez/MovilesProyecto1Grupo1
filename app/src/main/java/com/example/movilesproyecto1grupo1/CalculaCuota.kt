package com.example.movilesproyecto1grupo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class CalculaCuota : AppCompatActivity() {
    private lateinit var tipo:RadioGroup
    private lateinit var consul: Button
    private lateinit var tiempo: RadioGroup
    private lateinit var monto: EditText
    private lateinit var campo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcula_cuota)
        tipo = findViewById(R.id.radioGroup)
        consul = findViewById(R.id.btnCalcula)
        tiempo = findViewById(R.id.radioGroup2)
        monto = findViewById(R.id.edSalario)
        campo = findViewById(R.id.montoTotal)
    }

}