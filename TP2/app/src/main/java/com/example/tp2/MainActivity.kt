package com.example.tp2

import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import controller.AgeCalculator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val premierBouton = findViewById<Button>(R.id.button)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val editText = findViewById<EditText>(R.id.editText)
        editText.setText("")

        editText.doOnTextChanged() { text, start, before, count ->
            textView2.text = editText.text
        }


        premierBouton.setOnClickListener {
            if (textView2.text.isEmpty()) {
                Toast.makeText(this@MainActivity, "Veuillez saisir du texte", Toast.LENGTH_SHORT).show()
                return@setOnClickListener;
            }
            val birthday = findViewById<EditText>(R.id.birthdayEditText).text.toString().toInt()
            val intent = Intent(this, MainActivity2::class.java)
            val age = AgeCalculator().calculateAge(birthday)
            intent.putExtra(EXTRA_TEXT, textView2.text.toString())
            intent.putExtra("age", age.toString())
            startActivity(intent)
        }
    }
}