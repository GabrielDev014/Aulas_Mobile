package com.example.prova1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TransferenciaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transferencia_principal)

        val valorTransferido : EditText = findViewById(R.id.valorTransferido)

        val botaoAvancar : Button = findViewById(R.id.botaoAvancar)

        botaoAvancar.setOnClickListener{
            val valorDigitado = valorTransferido.text.toString()

            if(valorDigitado.isEmpty()){
                Toast.makeText(this, "É necessário digitar um valor", Toast.LENGTH_SHORT).show()
            }
            else {
                var intent = Intent(this, TransferenciaContatos::class.java)
                intent.putExtra("valor", valorDigitado)
                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}