package com.example.movilesproyecto1grupo1

/* Estudiantes:
*  Jam Carlos Ramirez Chaves
*  Marlen Badilla Campos
*  Fabiana Barrantes Li
*/

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class IniciarSesion : AppCompatActivity() {
    private lateinit var iniciaSesion: Button
    private lateinit var usern:EditText
    private lateinit var passw: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        iniciaSesion = findViewById(R.id.btnIniciaSesion)
        usern = findViewById(R.id.username)
        passw = findViewById(R.id.password)
        val helper = MyDatabaseHelper(applicationContext)
        val db = helper.readableDatabase



        iniciaSesion.setOnClickListener {
            val args= listOf<String>(usern.text.toString(),passw.text.toString()).toTypedArray()
            val rs = db. rawQuery("SELECT * FROM USUARIO WHERE USERNAME=? AND PASSWORD=? AND PRIVILEGIO ='administrador' AND ESTADO=1",args)
            val rsc = db. rawQuery("SELECT * FROM USUARIO WHERE USERNAME=? AND PASSWORD=? AND PRIVILEGIO ='cliente' AND ESTADO=1",args)
            if(rs.moveToNext()){
                Toast.makeText(applicationContext,"Usuario Administrativo",Toast.LENGTH_LONG).show()
                startActivity(Intent(this,Administrative::class.java))

            }
            if(rsc.moveToNext()){
                Toast.makeText(applicationContext,"Cliente",Toast.LENGTH_LONG).show()
                 startActivity(Intent(this,PrincipalCliente::class.java))

            }else{
                Toast.makeText(applicationContext,"El usuario no existe",Toast.LENGTH_LONG).show()
            }
        }
    }
}