package com.example.movilesproyecto1grupo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class InformacionPersonal : AppCompatActivity() {

    private lateinit var consulta: Button
    private lateinit var  user: EditText
    private lateinit var vista: TextView
    private lateinit var edita: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion_personal)

        consulta = findViewById(R.id.btnConsultar)
        user = findViewById(R.id.user)
        vista = findViewById(R.id.vistaInformacion)
        edita = findViewById(R.id.editar)

        val helper = MyDatabaseHelper(applicationContext)
        val db = helper.readableDatabase

        consulta.setOnClickListener {
            val selectionArgs = arrayOf(user.text.toString())
            val rs = db.rawQuery("SELECT * FROM cliente WHERE cliente_cedula = ?", selectionArgs)

            if (rs.moveToFirst()) {
                Toast.makeText(applicationContext, "Cliente Encontrado!", Toast.LENGTH_LONG).show()
                if (rs.moveToFirst()) {
                    do {
                        vista.append("Cédula: "+rs.getInt(0).toString()+"\n")
                        vista.append("Nombre: "+rs.getString(1).toString()+"\n")
                        vista.append("Salario: "+rs.getInt(2).toString()+"\n")
                        vista.append("Teléfono: "+rs.getString(3).toString()+"\n")
                        vista.append("Estado Civil: "+rs.getString(4).toString()+"\n")
                        vista.append("Dirección: "+rs.getString(5).toString()+"\n")

                    } while (rs.moveToNext())
                } else {
                    Toast.makeText(
                        applicationContext,
                        "ERROR, Cliente No Existe!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
        edita.setOnClickListener {
            val intent = Intent(this,EditaCliente::class.java)
            intent.putExtra("clave",user.text.toString())
            startActivity(intent)
        }

    }
}