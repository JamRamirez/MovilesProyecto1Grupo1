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
            val args= listOf<String>(usern.text.toString().lowercase(),passw.text.toString().lowercase()).toTypedArray()
            val rs = db. rawQuery("SELECT * FROM USUARIO WHERE USERNAME=? AND PASSWORD=? AND PRIVILEGIO ='administrador' AND ESTADO=1",args)
            val rsc = db. rawQuery("SELECT * FROM USUARIO WHERE USERNAME=? AND PASSWORD=? AND PRIVILEGIO ='cliente' AND ESTADO=1",args)


            if(rs.moveToNext()){
                Toast.makeText(applicationContext,"Usuario Administrativo Ingresado",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,Administrative::class.java))

            }else if(rsc.moveToNext()){
                val Intent = Intent(this, PrincipalCliente::class.java)
                    val stringUser = usern.text.toString()
                    val stringPass = passw.text.toString()
                    Intent.putExtra("stringUser",stringUser)
                    Intent.putExtra("stringPass",stringPass)

                Toast.makeText(applicationContext,"Cliente",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,PrincipalCliente::class.java))
                startActivity(Intent)
            }else if(usern.text.toString().isBlank() && passw.text.toString().isBlank()){
                Toast.makeText(applicationContext,"Los campos son Requeridos ",Toast.LENGTH_SHORT).show()
            }else if(usern.text.toString().isBlank()){
                Toast.makeText(applicationContext,"El campo username esta vacio",Toast.LENGTH_SHORT).show()
            }else if(passw.text.toString().isBlank()){
                Toast.makeText(applicationContext,"El password esta vacio",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"La información ingresada es incorrecta",Toast.LENGTH_SHORT).show()
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

}