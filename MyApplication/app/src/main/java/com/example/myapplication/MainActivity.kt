package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val botaoCalculadora : Button = findViewById(R.id.Calculadora)
        botaoCalculadora.setOnClickListener{
            var intent = Intent(this, Calculadora::class.java)
            startActivity(intent)
        }

        val botaoLogin : Button = findViewById(R.id.TelaDeLogin)
        botaoLogin.setOnClickListener{
            var intent = Intent(this, TelaLogin::class.java)
            startActivity(intent)
        }

        val botaoFormEnvio : Button = findViewById(R.id.FormEnvio)
        botaoFormEnvio.setOnClickListener{
            var intent = Intent(this, EnvioDados::class.java)
            startActivity(intent)
        }

        val botaoClone : Button = findViewById(R.id.Clone)
        botaoClone.setOnClickListener{
            var intent = Intent(this, TelaClone::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    //O fun também funciona assim como o setOnClickListener
    fun Lista(view: View)
    {
        var intent = Intent(this, Lista::class.java)
        startActivity(intent)
    }

    fun ListaFixa(view: View)
    {
        var intent = Intent(this, ListaFixa::class.java)
        startActivity(intent)
    }

    fun Carregamento(view: View)
    {
        var intent = Intent(this, Carregamento::class.java)
        startActivity(intent)
    }
}