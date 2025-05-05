package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class Carregamento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_carregamento)
    }
    fun CarregarImagem(view: View)
    {
        var url = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Emirates_logo.svg/1934px-Emirates_logo.svg.png"
        var emirates = findViewById<ImageView>(R.id.emirates)
        Glide.with(this).load(url).into(emirates)
    }
}