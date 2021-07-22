package com.josimar.imcteste

import android.graphics.Color
import android.os.Bundle
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
            when{
                imc <= 18.5 -> {
                    resultado.text = "Seu IMC é $imcformatado e está abaixo do peso"
                    resultado.setBackgroundColor(Color.rgb(14, 228, 203))
                }
                imc in 18.6..24.9 -> {
                    resultado.text = "Seu IMC é $imcformatado e está no peso ideal"
                    resultado.setBackgroundColor(Color.rgb(50, 244, 6))
                }
                imc in 25.0..29.9 -> {
                    resultado.text = "Seu IMC é $imcformatado e está levemente acima do peso"
                    resultado.setBackgroundColor(Color.rgb(255, 235, 59))
                }
                imc in 30.0..34.9 -> {
                    resultado.text = "Seu IMC é $imcformatado e está com obesidade grau 1"
                    resultado.setBackgroundColor(Color.rgb(255, 193, 7))
                }
                imc in 35.0..39.9 -> {
                    resultado.text = "Seu IMC é $imcformatado e está com obesidade grau 2"
                    resultado.setBackgroundColor(Color.rgb(255, 152, 0))
                }
                imc  >= 40.0 -> {
                    resultado.text = "Seu IMC é $imcformatado e está com obesidade grau 3"
                    resultado.setBackgroundColor(Color.rgb(255, 87, 34))
                }
            }
        }
    }
}



