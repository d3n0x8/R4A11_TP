package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.MainActivity2

const val EXTRA_TEXT = "text_to_display"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutPrincipal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val premierBouton = findViewById<Button>(R.id.premierButton)
        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)
        val layoutPrincipal = findViewById<ConstraintLayout>(R.id.layoutPrincipal)
        premierBouton.setOnClickListener {
            if (editText.text.toString() == "afficher nouveau textView") {
                val deuxiemeTextView = TextView(this)
                deuxiemeTextView.text = editText.text
                layoutPrincipal.addView(deuxiemeTextView)
            } else {
                textView.text = editText.text
            }
        }

        //creer un bouton next
        val next = Button(this)
        next.text = "Next"
        layoutPrincipal.addView(next)

        next.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra(EXTRA_TEXT, textView.text.toString())
            startActivity(intent)
        }
    }
}