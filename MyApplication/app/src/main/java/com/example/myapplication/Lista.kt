package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.btn1 -> {
                Toast.makeText(this, "Eu sou o botão 1", Toast.LENGTH_LONG).show()
            }
            R.id.btn2 -> {
                Toast.makeText(this, "Eu sou o botão 2",Toast.LENGTH_LONG).show()
            }
            R.id.btn3 -> {
                Toast.makeText(this, "Eu sou o botão 3",Toast.LENGTH_LONG).show()
            }
            R.id.btn4 -> {
                Toast.makeText(this, "Eu sou o botão 4",Toast.LENGTH_LONG).show()
            }
            /* Exemplo voltando para o main */
            R.id.btn5 -> {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}