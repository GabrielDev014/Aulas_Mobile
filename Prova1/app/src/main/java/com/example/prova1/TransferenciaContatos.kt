package com.example.prova1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TransferenciaContatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transferencia_contatos)

        val valorRecebido = intent.getStringExtra("valor")
        val exibirValor : TextView = findViewById(R.id.exibirValor)

        exibirValor.text = "R$ $valorRecebido?"

        val botaoContato : Button = findViewById(R.id.botaoContato)
        botaoContato.setOnClickListener {
            var intent = Intent(this, TransferenciaConfirmacao::class.java)
            intent.putExtra("valor", valorRecebido)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}