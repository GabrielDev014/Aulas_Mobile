package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Lista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)

        // val -> variável imutável. Var -> mutável

        val arrayAdapter: ArrayAdapter<*>
        val compras = arrayOf("Batata", "Feijão", "Ovo",
            "Carne", "Sabão em Pó")

        var listaCompras = findViewById<ListView>(R.id.listaCompras)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, compras)
        listaCompras.adapter = arrayAdapter
    }
}