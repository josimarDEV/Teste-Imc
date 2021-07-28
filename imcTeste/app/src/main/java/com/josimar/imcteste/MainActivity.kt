package com.josimar.imcteste

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    calcularBtn.setOnClickListener {
        calcularImc(pesoEDT.text.toString(), alturaEDT.text.toString())
    }
    }

    private fun calcularImc(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            val imcformatado = String.format("%.2f", imc)

            abaixo.visibility = View.GONE
            abaixo2.visibility = View.GONE
            ideal.visibility = View.GONE
            ideal2.visibility = View.GONE
            acima.visibility = View.GONE
            acima2.visibility = View.GONE
            grau1.visibility = View.GONE
            grau1_1.visibility = View.GONE
            grau2.visibility = View.GONE
            grau2_1.visibility = View.GONE
            grau3.visibility = View.GONE
            grau3_1.visibility = View.GONE


            abaixo3.visibility = View.VISIBLE
            abaixo4.visibility = View.VISIBLE
            ideal3.visibility = View.VISIBLE
            ideal4.visibility = View.VISIBLE
            acima3.visibility = View.VISIBLE
            acima4.visibility = View.VISIBLE
            grau1_2.visibility = View.VISIBLE
            grau1_3.visibility = View.VISIBLE
            grau2_2.visibility = View.VISIBLE
            grau2_3.visibility = View.VISIBLE
            grau3_2.visibility = View.VISIBLE
            grau3_3.visibility = View.VISIBLE

            when {
                imc <= 18.5 -> {
                    resultado.text = "IMC = $imcformatado"
                    resultado.setBackgroundColor(Color.rgb(14, 228, 203))
                    abaixo.visibility = View.VISIBLE
                    abaixo2.visibility = View.VISIBLE
                    abaixo3.visibility = View.INVISIBLE
                    abaixo4.visibility = View.INVISIBLE
                }
                imc in 18.6..24.9 -> {
                    resultado.text = "IMC = $imcformatado"
                    resultado.setBackgroundColor(Color.rgb(50, 244, 6))
                    ideal.visibility = View.VISIBLE
                    ideal2.visibility = View.VISIBLE
                    ideal3.visibility = View.INVISIBLE
                    ideal4.visibility = View.INVISIBLE
                }
                imc in 25.0..29.9 -> {
                    resultado.text = "IMC = $imcformatado"
                    resultado.setBackgroundColor(Color.rgb(255, 235, 59))
                    acima.visibility = View.VISIBLE
                    acima2.visibility = View.VISIBLE
                    acima3.visibility = View.INVISIBLE
                    acima4.visibility = View.INVISIBLE
                }
                imc in 30.0..34.9 -> {
                    resultado.text = "IMC = $imcformatado"
                    resultado.setBackgroundColor(Color.rgb(255, 193, 7))
                    grau1.visibility = View.VISIBLE
                    grau1_1.visibility = View.VISIBLE
                    grau1_2.visibility = View.INVISIBLE
                    grau1_3.visibility = View.INVISIBLE
                }
                imc in 35.0..39.9 -> {
                    resultado.text = "IMC = $imcformatado"
                    resultado.setBackgroundColor(Color.rgb(255, 152, 0))
                    grau2.visibility = View.VISIBLE
                    grau2_1.visibility = View.VISIBLE
                    grau2_2.visibility = View.INVISIBLE
                    grau2_3.visibility = View.INVISIBLE
                }
                else -> {
                    resultado.text = "IMC = $imcformatado"
                    resultado.setBackgroundColor(Color.rgb(255, 87, 34))
                    grau3.visibility = View.VISIBLE
                    grau3_1.visibility = View.VISIBLE
                    grau3_2.visibility = View.INVISIBLE
                    grau3_3.visibility = View.INVISIBLE
                }
            }
        }
    }
}



