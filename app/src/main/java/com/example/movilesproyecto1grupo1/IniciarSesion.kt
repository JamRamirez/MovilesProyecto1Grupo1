package com.example.movilesproyecto1grupo1

/* Estudiantes:
*  Jam Carlos Ramirez Chaves
*  Marlen Badilla Campos
*  Fabiana Barrantes Li
*/

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class IniciarSesion : AppCompatActivity() {
    private lateinit var iniciaSesion: Button
    private lateinit var usern:EditText
    private lateinit var passw: EditText
    private lateinit var close: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        iniciaSesion = findViewById(R.id.btnIniciaSesion)
        usern = findViewById(R.id.username)
        passw = findViewById(R.id.password)
        val helper = MyDatabaseHelper(applicationContext)
        val db = helper.readableDatabase
        close = findViewById(R.id.btncerrar)

        usern.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(usern)){
                usern.setError("Campo usuario requerido vacio")
            }
        }
        passw.setOnFocusChangeListener{ v : View, hasFocus->
            if(!hasFocus && noData(passw)){
                passw.setError("Campo contraseña requerido vacio")
            }
        }
        iniciaSesion.setOnClickListener {
            val args= listOf<String>(usern.text.toString(),passw.text.toString()).toTypedArray()
            val rs = db. rawQuery("SELECT * FROM USUARIO WHERE USERNAME=? AND PASSWORD=? AND PRIVILEGIO ='administrador' AND ESTADO=1",args)
            val rsc = db. rawQuery("SELECT * FROM USUARIO WHERE USERNAME=? AND PASSWORD=? AND PRIVILEGIO ='cliente' AND ESTADO=1",args)


            if(rs.moveToNext()){
                Toast.makeText(applicationContext,"Usuario Administrativo Ingresado",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,Administrative::class.java))

            }
            if(rsc.moveToNext()){
                Toast.makeText(applicationContext,"Cliente Ingresado",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,PrincipalCliente::class.java))
            }else{
                data( usern,passw)
            }
            rs.close()
            rsc.close()
        }
        close.setOnClickListener {
            finishAffinity()
        }
    }
    private fun noData(editText: EditText) : Boolean {
        return editText.text.toString().isEmpty()
    }
    private fun data(editText1: EditText,editText2: EditText){
        if(editText1.text.isBlank() && editText2.text.isBlank()){
           Toast.makeText(this,"Campos requeridos vacios",Toast.LENGTH_LONG).show()
        }
    }
}