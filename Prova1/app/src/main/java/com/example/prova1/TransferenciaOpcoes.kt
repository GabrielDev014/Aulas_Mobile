package com.example.prova1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TransferenciaOpcoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transferencia_opcoes)

        val valorRecebido = intent.getStringExtra("valor")
        val exibirValor : TextView = findViewById(R.id.exibirValor)

        exibirValor.text = "R$ $valorRecebido?"

        val grupoOpcoes : RadioGroup = findViewById(R.id.grupoOpcoes)

        //São os botões que vão aparecer dinamicamente
        val saldoConta : Button = findViewById(R.id.saldoConta)
        val cartaoCredito : Button = findViewById(R.id.cartaoCredito)

        grupoOpcoes.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.botaoSaldo -> {
                    saldoConta.visibility = View.VISIBLE
                    cartaoCredito.visibility = View.GONE
                }
                R.id.botaoCartao -> {
                    saldoConta.visibility = View.GONE
                    cartaoCredito.visibility = View.VISIBLE
                }
            }
        }

        saldoConta.setOnClickListener {
            val intent = Intent(this, TransferenciaRevise::class.java)
            intent.putExtra("valor", valorRecebido)
            intent.putExtra("formaPgt", "Saldo da conta")
            startActivity(intent)
        }

        cartaoCredito.setOnClickListener {
            val intent = Intent(this, TransferenciaRevise::class.java)
            intent.putExtra("valor", valorRecebido)
            intent.putExtra("formaPgt", "Cartão de crédito")
            startActivity(intent)
        }

        //Recebendo a forma de pagamento para usar na alteração
        val formaPagamento = intent.getStringExtra("formaPgt")

        //Usando para se for alterar a opção escolhida
        val botaoSaldo : RadioButton = findViewById(R.id.botaoSaldo)
        val botaoCredito : RadioButton = findViewById(R.id.botaoCartao)

        if (formaPagamento == "Cartão de crédito") {
            //Deixa com check automático
            botaoCredito.isChecked = true
            saldoConta.visibility = View.GONE
            cartaoCredito.visibility = View.VISIBLE
        } else {
            //Deixa com check automático
            botaoSaldo.isChecked = true
            saldoConta.visibility = View.VISIBLE
            cartaoCredito.visibility = View.GONE
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}