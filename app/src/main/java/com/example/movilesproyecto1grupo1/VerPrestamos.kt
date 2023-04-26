package com.example.movilesproyecto1grupo1

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class VerPrestamos : AppCompatActivity() {

    private lateinit var txtCed: TextView
    private lateinit var linearLayout: LinearLayout
    private var stringUser = ""
    private var userIsNull : Boolean = false
    lateinit var clienteDBHelper: MyDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_prestamos)

        linearLayout = findViewById<LinearLayout>(R.id.layoutPrestamos)
        txtCed = findViewById(R.id.txtTitlePrestamos)
        stringUser = intent.getStringExtra("stringUser").toString()

        if (stringUser == "null"){
            userIsNull = true
        }


        if(!userIsNull){
            getPrestamos()
        }

    }

    @SuppressLint("Range")
    private fun getPrestamos(){
        val helper = MyDatabaseHelper(applicationContext)
        val db = helper.readableDatabase

        // Obteniendo la CEDULA_Cliente de el Usuario logeado
        var selectionArgs = arrayOf(stringUser)
        var rs = db. rawQuery("SELECT * FROM cliente WHERE cliente_nombre = ?", selectionArgs)
        rs.moveToFirst()
        var cedulaDB = ""

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        params.setMargins(0, 16, 0, 0)

        val index = rs.getColumnIndex("cliente_cedula")

        if (index >= 0){
            cedulaDB = rs.getString(index)
        }

        //Obteniendo los Prestamos de este Cliente
        selectionArgs = arrayOf(cedulaDB)
        rs = db. rawQuery("SELECT * FROM PRESTAMO WHERE CEDULA = ?", selectionArgs)

        if (rs.moveToFirst()){
            linearLayout.removeAllViews()
            do {
                var button = Button(this)
                button.id = View.generateViewId()
                var PrestamoId = rs.getString(rs.getColumnIndex("ID"))
                var PrestamoPERIODO = rs.getString(rs.getColumnIndex("PERIODO"))
                var PrestamoRestantes = rs.getString(rs.getColumnIndex("RESTANTES"))
                var PrestamoPAGO = rs.getString(rs.getColumnIndex("PAGO"))

                button.setText("ID Prestamo: " + PrestamoId + " Pagos restantes: " + PrestamoPERIODO + " Total Restante: " + PrestamoRestantes + " Pago Mensual: " + PrestamoPAGO)
                button.setBackgroundColor(Color.parseColor("#f5812b"))
                button.setTextColor(Color.parseColor("#f1c8a0"))
                button.layoutParams = params
                linearLayout.addView(button)

                button.setOnClickListener{
                    cobrarPrestamo(PrestamoId, button.id)

                }

            } while(rs.moveToNext())
        }

        db.close()
    }

    @SuppressLint("Range")
    private fun cobrarPrestamo(idPrestamo: String, idBtn: Int){
        val helper = MyDatabaseHelper(applicationContext)
        val db = helper.readableDatabase
        var selectionArgs = arrayOf(idPrestamo)
        var rs = db. rawQuery("SELECT * FROM PRESTAMO WHERE ID = ?", selectionArgs)
        rs.moveToFirst()

        var strPERIODO = rs.getString(rs.getColumnIndex("PERIODO"))
        var strRestantes = rs.getString(rs.getColumnIndex("RESTANTES"))
        var strPAGO = rs.getString(rs.getColumnIndex("PAGO"))

        val restante = strRestantes.toString().toFloat() - strPAGO.toString().toFloat()
        val periodo = strPERIODO.toString().toInt() - 1

        if (periodo > 0){
            var button = Button(this)

            button = findViewById(idBtn)
            //Actualiza en la DB
            clienteDBHelper = MyDatabaseHelper(this)

            this.clienteDBHelper.prestamoPago(periodo,restante,idPrestamo.toInt())

            //Actualiza la Vista
            selectionArgs = arrayOf(idPrestamo)
            rs = db. rawQuery("SELECT * FROM PRESTAMO WHERE ID = ?", selectionArgs)

            rs.moveToFirst()
            var PrestamoId = rs.getString(rs.getColumnIndex("ID"))
            var PrestamoPERIODO = rs.getString(rs.getColumnIndex("PERIODO"))
            var PrestamoRestantes = rs.getString(rs.getColumnIndex("RESTANTES"))
            var PrestamoPAGO = rs.getString(rs.getColumnIndex("PAGO"))

            button.setText("ID Prestamo: " + PrestamoId + " Pagos restantes: " + PrestamoPERIODO + " Total Restante: " + PrestamoRestantes + " Pago Mensual: " + PrestamoPAGO)

            Toast.makeText(applicationContext,"Pago realizado con Exito",Toast.LENGTH_LONG).show()

        }else{
            selectionArgs = arrayOf(idPrestamo)
            rs = db. rawQuery("DELETE FROM PRESTAMO WHERE ID = ?", selectionArgs)

            var button = Button(this)
            button = findViewById(idBtn)

            //Elimina el prestamo de la DB
            clienteDBHelper = MyDatabaseHelper(this)
            this.clienteDBHelper.borrarPrestamo(idPrestamo.toInt())

            //Actualiza la View
            linearLayout.removeView(button)

            Toast.makeText(applicationContext,"Prestamo Pagado en su totalidad",Toast.LENGTH_LONG).show()

        }

        db.close()
    }

}