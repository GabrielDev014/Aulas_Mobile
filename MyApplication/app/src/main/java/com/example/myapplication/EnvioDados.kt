package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EnvioDados : AppCompatActivity() {
    //Aqui inicia uma variável vazia que se relaciona com um campo texto
    lateinit var envioDados : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envio_dados)

        //crio uma variável, nomeada da função que quero chamar
        val botaoEnviar : Button = findViewById(R.id.EnvioInformacoes)
        //aqui a função aponta um click
        botaoEnviar.setOnClickListener{
            //aqui eu busco o id do botão (front)
            envioDados = findViewById(R.id.envioDados)
            //aqui eu tenho uma intenção de abrir uma tela (activity)
            var intent = Intent(this, RecepcaoDados::class.java)
            //aqui eu busco e guardo os dados digitados no campo texto
            intent.putExtra("", envioDados.text.toString())
            //aqui eu abro uma tela
            startActivity(intent)
        }

    }
}