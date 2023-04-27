package com.example.movilesproyecto1grupo1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 23
        private const val DATABASE_NAME = "Proyecto1Grupo1.db"

        private const val TABLE_NAME = "cliente"
        private const val COLUMN_CEDULA = "cliente_cedula"
        private const val COLUMN_NOMBRE = "cliente_nombre"
        private const val COLUMN_SALARIO = "cliente_salario"
        private const val COLUMN_TELEFONO = "cliente_telefono"
        private const val COLUMN_CIVIL = "cliente_civil"
        private const val COLUMN_DIRECCION = "cliente_direccion"
        private const val COLUMN_NACIMIENTO = "cliente_nacimiento"


        private const val COLUMN_TIPO = "TIPOAHORRO"
        private const val COLUMN_MONTO = "MONTO"
        private const val TABLE_AHORRO = "AHORRO"
        private const val COLUMN_CLIENTE = "CLIENTEID"

    }

    override fun onCreate(db: SQLiteDatabase) {
        var query = //Tabla CLIENTE
            "CREATE TABLE $TABLE_NAME ( $COLUMN_CEDULA INTEGER PRIMARY KEY, " +
                    "$COLUMN_NOMBRE TEXT, $COLUMN_SALARIO INTEGER, $COLUMN_TELEFONO TEXT, " +
                    "$COLUMN_CIVIL TEXT, $COLUMN_DIRECCION TEXT, $COLUMN_NACIMIENTO TEXT);"
        db.execSQL(query)
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('1111','marlenbadilla','1000000','81715181','Soltero','Heredia, Costa Rica','1/1/1999')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('2222','jamramirez','1500000','82728272','Casado','San Jose, Costa Rica','1/1/1998')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('3333','fabianali','1800000','83738373','Soltero','Alajuela, Costa Rica','1/1/1997')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('4444','jazminalfaro','1000000','84748474','Casada','Cartago, Costa Rica','1/1/1996')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('5555','alexarojas','100000','85758575','Soltero','Guanacaste, Costa Rica','1/1/1995')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('6666','davidcorrales','100000','86768676','Casado','Limon, Costa Rica','1/1/1994')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('7777','sebastianvega','100000','87778777','Soltero','Heredia, Costa Rica','1/7/1993')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('8888','sofiavargas','100000','88788878','Casada','San jose, Costa Rica','1/6/1992')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('9999','thompsonbadilla','100000','89798979','Soltero','Limon, Costa Rica','1/5/1991')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('1010','vanessabarrantes','100000','80708070','Casada','Cartago, Costa Rica','1/1/1990')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('1212','cristianabarca','100000','88748975','Soltero','Heredia, Costa Rica','1/2/1980')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('1313','ceciliajimenez','100000','81818181','Cartago','Guanacaste, Costa Rica','1/3/1989')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('1414','melissanaranjo','100000','82728272','Soltero','Cartago, Costa Rica','1/5/1988')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('1515','monicagonzales','100000','83738373','Casada','Heredia, Costa Rica','1/6/1987')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('1616','abigailcontreras','100000','84746695','Soltera','Alajuela, Costa Rica','1/11/1986')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('1717','joseflores','100000','84748474','Soltero','Heredia, Costa Rica','1/1/1985')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('1818','gaelrobles','100000','85758575','Casado','Cartago, Costa Rica','1/12/1984')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('1919','valeriacruz','100000','83768676','Soltera','Limon, Costa Rica','1/5/1983')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('2020','juanrodriguez','100000','86895213','Casado','Heredia, Costa Rica','1/5/1982')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('2021','dylantorres','100000','85201374','Soltero','Cartago, Costa Rica','1/4/1981')")
        db.execSQL("INSERT INTO cliente(cliente_cedula,cliente_nombre,cliente_salario,cliente_telefono,cliente_civil,cliente_direccion,cliente_nacimiento) " +
                "VALUES('2022','josuemurillo','100000','89745623','Casado','Alajuela, Costa Rica','1/4/1980')")


        //Tabla USUARIO
        db.execSQL("CREATE TABLE USUARIO( ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT,PRIVILEGIO TEXT, ESTADO INTEGER)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('marlenbadilla','mar123','administrador',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('jamramirez','jam456','administrador',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('fabianali','fabi789','administrador',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('jazminalfaro','jazminalfaro1','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('alexarojas','alexarojas2','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('davidcorrales','davidcorrales3','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('sebastianvega','sebastianvega4','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('sofiavargas','sofiavargas5','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('thompsonbadilla','thompsonbadilla6','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('vanessabarrantes','vanessabarrantes7','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('cristianabarca','cristianabarca8','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('ceciliajimenez','ceciliajimenez9','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('melissanaranjo','melissanaranjo10','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('monicagonzales','monicagonzales11','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('abigailcontreras','abigailcontreras12','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('gaelrobles','gaelrobles13','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('valeriacruz','valeriacruz14','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('juanrodriguez','juanrodriguez15','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('dylantorres','dylantorres16','cliente',1)")
        db.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('josuemurillo','josuemurillo17','cliente',1)")

        //Tabla PRESTAMO
        db.execSQL("CREATE TABLE PRESTAMO( ID INTEGER PRIMARY KEY AUTOINCREMENT, CEDULA INTEGER, PRESTAMO INTEGER, PERIODO INTEGER, CREDITO FLOAT, PAGO FLOAT, RESTANTES FLOAT)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('4444',4000,36,12,132.85,4000)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('4444',3000,36,12,99.64,3000)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('4444',2500,36,8,78.34,2500)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('5555',4000,60,12,66.73,4000)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('4444',33333,120,12,478.23,33333)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('4444',4000,36,12,132.85,4000)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('4444',7777,36,7.5,241.91,7777)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('4444',11111,60,8,225.29,11111)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('9999',4000,36,12,132.85,4000)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('1515',4000,36,12,132.85,4000)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('1616',4000,36,12,132.85,4000)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('1717',4000,36,12,132.85,4000)")
        db.execSQL("INSERT INTO PRESTAMO(CEDULA,PRESTAMO,PERIODO,CREDITO, PAGO, RESTANTES) VALUES('9999',4000,36,12,132.85,4000)")


        //Table Ahorro
        db.execSQL("CREATE TABLE AHORRO( CEDULA INTEGER PRIMARY KEY, TIPOAHORRO TEXT, MONTO INTEGER, CLIENTEID INT)")
        db.execSQL("INSERT INTO AHORRO(CEDULA,TIPOAHORRO,MONTO, CLIENTEID) VALUES(111,'Escolar', 10000, '1111')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        db.execSQL("DROP TABLE IF EXISTS USUARIO")
        db.execSQL("DROP TABLE IF EXISTS PRESTAMO")
        db.execSQL("DROP TABLE IF EXISTS AHORRO")
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

    fun activarAhorro(monto: Int, tipoAhorro: String, cliente: Int) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TIPO, tipoAhorro)
        values.put(COLUMN_MONTO, monto)
        values.put(COLUMN_CLIENTE, cliente)
        db.insert(TABLE_AHORRO, null, values)
        db.close()
    }

    fun obtenerMontoAhorro(tipoAhorro: String, idCliente: Int): Int {
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT MONTO FROM AHORRO WHERE TIPOAHORRO = ? AND CLIENTEID = ?",
            arrayOf(tipoAhorro, idCliente.toString())
        )
        var monto = 0
        if (cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex("MONTO")
            if (columnIndex >= 0) {
                monto = cursor.getInt(columnIndex)
            }
        }
        cursor.close()
        return monto
    }
    fun eliminarAhorro(tipoAhorro: String, idCliente: Int) {
        val db = this.writableDatabase
        val deleteQuery = "DELETE FROM AHORRO WHERE TIPOAHORRO = ? AND CLIENTEID = ?"
        val whereArgs = arrayOf(tipoAhorro, idCliente.toString())

        db.execSQL(deleteQuery, whereArgs)
        db.close()
    }


}