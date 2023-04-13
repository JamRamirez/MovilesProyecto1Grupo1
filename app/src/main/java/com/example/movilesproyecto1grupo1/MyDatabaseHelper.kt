package com.example.movilesproyecto1grupo1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Proyecto1Grupo1.db"

        private const val TABLE_NAME = "cliente"
        private const val COLUMN_CEDULA = "cliente_cedula"
        private const val COLUMN_NOMBRE = "cliente_nombre"
        private const val COLUMN_SALARIO = "cliente_salario"
        private const val COLUMN_TELEFONO = "cliente_telefono"
        private const val COLUMN_CIVIL = "cliente_civil"
        private const val COLUMN_DIRECCION = "cliente_direccion"
        private const val COLUMN_NACIMIENTO = "cliente_nacimiento"

    }

    override fun onCreate(db: SQLiteDatabase) {
        var query =
            "CREATE TABLE $TABLE_NAME ( $COLUMN_CEDULA INTEGER, " +
                    "$COLUMN_NOMBRE TEXT, $COLUMN_SALARIO INTEGER, $COLUMN_TELEFONO TEXT, " +
                    "$COLUMN_CIVIL TEXT, $COLUMN_DIRECCION TEXT, $COLUMN_NACIMIENTO TEXT);"
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $DATABASE_NAME")
        onCreate(db)
    }

    fun addCliente(cedula: Int, nombre: String, salario: Int, telefono: String, civil: String, direccion: String, nacimiento: String){
        val datos = ContentValues()
        datos.put(COLUMN_CEDULA, cedula)
        datos.put(COLUMN_NOMBRE, nombre)
        datos.put(COLUMN_SALARIO, salario)
        datos.put(COLUMN_TELEFONO, telefono)
        datos.put(COLUMN_CIVIL, civil)
        datos.put(COLUMN_DIRECCION, direccion)
        datos.put(COLUMN_NACIMIENTO, nacimiento)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, datos)
        db.close()
    }

}