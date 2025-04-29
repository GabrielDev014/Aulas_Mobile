package com.example.prova1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TransferenciaConfirmacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transferencia_confirmacao)

        val valorRecebido = intent.getStringExtra("valor")
        val exibirValor : TextView = findViewById(R.id.exibirValor)

        exibirValor.text = "R$ $valorRecebido?"

        val confirmarTransferencia : Button = findViewById(R.id.confirmarTransferencia)
        confirmarTransferencia.setOnClickListener{
            var intent = Intent(this, TransferenciaOpcoes::class.java)
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