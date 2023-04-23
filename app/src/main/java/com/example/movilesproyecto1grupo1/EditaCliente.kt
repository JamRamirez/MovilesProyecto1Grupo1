package com.example.movilesproyecto1grupo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditaCliente : AppCompatActivity() {

    private lateinit var actualiza:Button
    private lateinit var nom:EditText
    private lateinit var salario: EditText
    private lateinit var tele: EditText
    private lateinit var estado: EditText
    private lateinit var direcc: EditText
    private lateinit var naci: EditText

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edita_cliente)

        nom = findViewById(R.id.nombreM)
        salario = findViewById(R.id.salarioM)
        actualiza = findViewById(R.id.actualizaM)
        tele = findViewById(R.id.telefonoM)
        estado = findViewById(R.id.estadoM)
        direcc = findViewById(R.id.direccionM)
        naci = findViewById(R.id.nacimientoM)


        val bundle = intent.extras
        val dato = bundle?.getString("clave")
        Toast.makeText(this,dato,Toast.LENGTH_LONG).show()

        val helper = MyDatabaseHelper(applicationContext)


        actualiza.setOnClickListener {
            val aux = dato.toString().toInt()
            if(nom.text.isNotBlank() && salario.text.isNotBlank()){
                helper.modifica(aux,nom.text.toString(),salario.text.toString().toInt(),
                tele.text.toString(),estado.text.toString(),direcc.text.toString(),naci.toString())
                nom.text.clear()
                salario.text.clear()
                Toast.makeText(this,"Información Actualizada",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Información No Actualizada",Toast.LENGTH_SHORT).show()
            }

        }
    }



}