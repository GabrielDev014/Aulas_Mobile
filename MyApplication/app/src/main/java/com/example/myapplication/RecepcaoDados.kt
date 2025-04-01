package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecepcaoDados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recepcao_dados)

        //crio variável que recebe info da outra activity
        val retornoDigitacao = intent.getStringExtra("")
        //Aqui um toast simples com interpolação de variável
        Toast.makeText(this, "Retorno: $retornoDigitacao",
            Toast.LENGTH_LONG).show()
    }
}