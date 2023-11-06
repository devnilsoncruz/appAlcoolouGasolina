package com.example.appalcoolgasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var edit_alcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var edit_Gasolina: TextInputEditText


    private lateinit var btnCalcular: Button
    private lateinit var textResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentesDeInterface()
        btnCalcular.setOnClickListener {
            calcularMelhorpreco()
        }

    }

    private fun inicializarComponentesDeInterface() {
        textInputAlcool = findViewById(R.id.text_input_alcool)
        edit_alcool = findViewById(R.id.edit_alcool)

        textInputGasolina = findViewById(R.id.text_input_gasolina)
        edit_Gasolina = findViewById(R.id.edit_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.text_resultado)
    }

    private fun calcularMelhorpreco() {
       val precoAlcool = edit_alcool.text.toString()
       val precoGasolina = edit_Gasolina.text.toString()

        val resultadoValidacao = validarCampos(precoAlcool,precoGasolina)
        if(resultadoValidacao){

            val precoAlcoolNumero = precoAlcool.toDouble()
            val precoGasolinalNumero = precoGasolina.toDouble()
            val resultado = precoAlcoolNumero/precoGasolinalNumero

            if(resultado >= 0.7){
                textResultado.text ="Melhor Ultilizar Gasolina"
            }else{
                textResultado.text="Melhor Ultizar Alcool"
            }


        }
    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error = null


        if(pAlcool.isEmpty()){
           textInputAlcool.error="Digite o preco do Alcool"
            return false

        }else if(pGasolina.isEmpty()){
            textInputGasolina.error = "Digite o preco da Gasolina"
            return false
        }

        return true
    }

    }
