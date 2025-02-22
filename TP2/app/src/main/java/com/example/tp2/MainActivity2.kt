package com.example.tp2

import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent = intent
        if (intent != null) {
            val textAffiche = findViewById<TextView>(R.id.textView3)
            val name = intent.getStringExtra(EXTRA_TEXT)?.uppercase()
            val birthday = intent.getStringExtra("age")
            val text = getString(R.string.hello_name, name, birthday)
            textAffiche.text = text
        }
    }
}