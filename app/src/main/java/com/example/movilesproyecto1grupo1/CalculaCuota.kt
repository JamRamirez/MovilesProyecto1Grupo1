package com.example.movilesproyecto1grupo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow
import kotlin.math.roundToInt

class CalculaCuota : AppCompatActivity(){
    private lateinit var tipo:RadioGroup
    private lateinit var consul: Button
    private lateinit var tiempo: RadioGroup
    private lateinit var mont: EditText
    private lateinit var hipo: RadioButton
    private lateinit var esco: RadioButton
    private lateinit var perso: RadioButton
    private lateinit var viaje: RadioButton
    private lateinit var mostrar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcula_cuota)
        tipo = findViewById<RadioGroup>(R.id.radioGroup)
        consul = findViewById(R.id.btnCalcula)
        tiempo = findViewById<RadioGroup>(R.id.radioGroup2)
        mont = findViewById(R.id.edSalario)
        hipo = findViewById(R.id.rdHipotecario)
        esco = findViewById(R.id.rdEducacion)
        perso = findViewById(R.id.Personal)
        viaje = findViewById(R.id.Viajes)
        mostrar = findViewById(R.id.CalculaCuota)



        consul.setOnClickListener {
            if(mont.text.toString().isEmpty()){
                Toast.makeText(applicationContext,"el campo monto no puede estar vacio",Toast.LENGTH_LONG).show()
            }else{
            var tipo = tipo.checkedRadioButtonId
            var auxT = findViewById<RadioButton>(tipo)

            var tiempo = tiempo.checkedRadioButtonId
            var auxTem = findViewById<RadioButton>(tiempo)
            var axuMonto = mont.text.toString().toDouble()

            if(auxT.text == "Hipotecario" && auxTem.text == "3"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.075,axuMonto)

            }else if(auxT.text == "Educacion" && auxTem.text == "3"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.08,axuMonto)

            }else if(auxT.text == "Personal" && auxTem.text == "3"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.1,axuMonto)

            }else if(auxT.text == "Viajes" && auxTem.text == "3"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.012,axuMonto)

            }else if(auxT.text == "Hipotecario" && auxTem.text == "5"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.075,axuMonto)

            }else if(auxT.text == "Educacion" && auxTem.text == "5"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.08,axuMonto)

            }else if(auxT.text == "Personal" && auxTem.text == "5"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.1,axuMonto)

            }else if(auxT.text == "Viajes" && auxTem.text == "5"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.012,axuMonto)

            }else if(auxT.text == "Hipotecario" && auxTem.text == "10"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.075,axuMonto)

            }else if(auxT.text == "Educacion" && auxTem.text == "10"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.08,axuMonto)

            }else if(auxT.text == "Personal" && auxTem.text == "10"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.1,axuMonto)

            }else if(auxT.text == "Viajes" && auxTem.text == "10"){
                val transformaAnio= (auxTem.text.toString().toInt())*12
                calculaCuota(transformaAnio,0.012,axuMonto)
            }

        }
        }
    }
    fun calculaCuota(mes:Int,porcentaje: Double, monto: Double){
        var meses = mes;
        var porcentaje = porcentaje;
        var saldo= monto;
        var sec1 = ((1-(1+porcentaje).pow(-meses))*1000).roundToInt().toDouble()/1000
        var cuota =  (saldo / (sec1 / porcentaje)*100).roundToInt().toDouble()/100
        Toast.makeText(applicationContext,cuota.toString(),Toast.LENGTH_LONG).show()
    }


}