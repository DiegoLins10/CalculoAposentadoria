package com.example.calculoaposentadoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_Sexo = findViewById<Spinner>(R.id.spn_Sexo)
        val txt_Idade = findViewById<TextView>(R.id.txt_Idade)
        val btn_Calcular = findViewById<Button>(R.id.btn_Calcular)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)

        spn_Sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                listOf("Masculino", "Feminino"))


        //btn_Calcular_onclick
        btn_Calcular.setOnClickListener {
            if (txt_Idade.text.isEmpty()) {
                //validação de dados
                txt_Idade.error = "Digite a idade: "
                Toast.makeText(this, "CAMPO VAZIO",Toast.LENGTH_LONG).show();
            } else {
                val sexo = spn_Sexo.selectedItem as String
                val idade = txt_Idade.text.toString().toInt()
                var resultado = 0
                if (sexo == "Masculino") {
                    resultado = 65 - idade
                } else {
                    resultado = 62 - idade
                }

                txt_Resultado.text = "Faltam $resultado anos para você se aposentar"

            }
        }
    }
}