package com.example.movilesproyecto1grupo1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 15
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
        var query = //Tabla CLIENTE
            "CREATE TABLE $TABLE_NAME ( $COLUMN_CEDULA INTEGER PRIMARY KEY, " +
                    "$COLUMN_NOMBRE TEXT, $COLUMN_SALARIO INTEGER, $COLUMN_TELEFONO TEXT, " +
                    "$COLUMN_CIVIL TEXT, $COLUMN_DIRECCION TEXT, $COLUMN_NACIMIENTO TEXT);"
        db.execSQL(query)
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('111','joseflores','100000','84748474','Soltero','Heredia, Costa Rica','1/1/1980')")

        //Tabla USUARIO
        db.execSQL("CREATE TABLE USUARIO( ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT,PRIVILEGIO TEXT, ESTADO INTEGER)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('marlenbadilla','mar123','administrador',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('jamramirez','jam456','administrador',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('fabianali','fabi789','administrador',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('joseflores','jose456','cliente',1)")

        //Tabla PRESTAMO
        db.execSQL("CREATE TABLE PRESTAMO( ID INTEGER PRIMARY KEY AUTOINCREMENT, CEDULA INTEGER, PRESTAMO INTEGER, PERIODO INTEGER, CREDITO FLOAT, PAGO FLOAT, RESTANTES FLOAT)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('111',4000,36,12,132.85,4000)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        db.execSQL("DROP TABLE IF EXISTS USUARIO")
        db.execSQL("DROP TABLE IF EXISTS PRESTAMO")
        onCreate(db)
    }

    fun addCliente(cedula: Int, nombre: String, salario: Int, telefono: String, civil: String, direccion: String, nacimiento: String){
        val cedulaString = cedula.toString()
        val datosCliente = ContentValues()
        datosCliente.put(COLUMN_CEDULA, cedula)
        datosCliente.put(COLUMN_NOMBRE, nombre)
        datosCliente.put(COLUMN_SALARIO, salario)
        datosCliente.put(COLUMN_TELEFONO, telefono)
        datosCliente.put(COLUMN_CIVIL, civil)
        datosCliente.put(COLUMN_DIRECCION, direccion)
        datosCliente.put(COLUMN_NACIMIENTO, nacimiento)

        val db = this.writableDatabase

        try {
            db.insert(TABLE_NAME, null, datosCliente)
            db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('" + nombre + "', '" + cedulaString + "', 'cliente', 1)")
        } catch (e: SQLiteConstraintException) {
            // Throw the exception here
            throw SQLiteConstraintException("Error: Primary key already exists.")
        }
        db.close()
    }

    fun modifica(cedula: Int, nombre: String, salario: Int,telefono: String ,estado: String,direccion: String,nacimiento: String){
        val args = arrayOf(cedula.toString())
        val datos = ContentValues()
        datos.put(COLUMN_NOMBRE, nombre)
        datos.put(COLUMN_SALARIO, salario)
        datos.put(COLUMN_TELEFONO, telefono)
        datos.put(COLUMN_CIVIL, estado)
        datos.put(COLUMN_DIRECCION, direccion)
        datos.put(COLUMN_NACIMIENTO, nacimiento)
        val db = this.writableDatabase
        db.update("cliente",datos,"cliente_cedula = ?",args)
        close()
    }

    fun prestamoPago(periodo:Int, restantes: Float, idPrestamo: Int){
        val args = arrayOf(idPrestamo.toString())
        val datos = ContentValues()
        datos.put("PERIODO",periodo)
        datos.put("RESTANTES",restantes)
        val db = this.writableDatabase
        db.update("PRESTAMO",datos,"ID = ?",args)
        close()
    }

    fun borrarPrestamo(idPrestamo: Int){
        val args = arrayOf(idPrestamo.toString())

        val db = this.writableDatabase
        db.delete("PRESTAMO","ID = ?",args)
        close()
    }

}