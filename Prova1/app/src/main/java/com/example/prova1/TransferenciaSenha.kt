package com.example.prova1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener


class TransferenciaSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transferencia_senha)

        val valorRecebido = intent.getStringExtra("valor")

        val campo01: EditText = findViewById(R.id.campo01)
        val campo02: EditText = findViewById(R.id.campo2)
        val campo03: EditText = findViewById(R.id.campo03)
        val campo04: EditText = findViewById(R.id.campo04)

        campo01.addTextChangedListener {
            if (campo01.text.length == 1) {
                campo02.requestFocus()
            }
        }

        campo02.addTextChangedListener {
            if (campo02.text.length == 1) {
                campo03.requestFocus()
            }
        }

        campo03.addTextChangedListener {
            if (campo03.text.length == 1) {
                campo04.requestFocus()
            }
        }

        val senhaDigitada : Button = findViewById(R.id.senhaDigitada)
        senhaDigitada.setOnClickListener {

            val digito01 = campo01.text.toString()
            val digito02 = campo02.text.toString()
            val digito03 = campo03.text.toString()
            val digito04 = campo04.text.toString()

            if (digito01.isEmpty() || digito02.isEmpty() || digito03.isEmpty() || digito04.isEmpty())
            {
                Toast.makeText(this, "É necessário preencher todos os campos", Toast.LENGTH_SHORT).show()
            }

            else
            {
                val senha = digito01 + digito02 + digito03 + digito04
                if (verifica(senha))
                {
                    var intent = Intent(this, TransferenciaConcluida::class.java)
                    intent.putExtra("valor", valorRecebido)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this, "Senha incorreta!", Toast.LENGTH_LONG).show()
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun verifica(senha: String): Boolean {
        return senha == "1234"
    }
}