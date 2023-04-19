package com.example.movilesproyecto1grupo1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class IniciaSesionHelperDB(context: Context) : SQLiteOpenHelper(context,"Proyecto1Grupo1",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USUARIO( ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT,PRIVILEGIO TEXT, ESTADO INTEGER)")
        db?.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('marlenbadilla','mar123','administrador',1)")
        db?.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('jamramirez','jam456','administrador',1)")
        db?.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILlEGIO,ESTADO) VALUES('fabianali','fabi789','administrador',1)")
        db?.execSQL("INSERT INTO USUARIO(USERNAME,PASSWORD,PRIVILEGIO,ESTADO) VALUES('joseflores','jose456','cliente',1)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}