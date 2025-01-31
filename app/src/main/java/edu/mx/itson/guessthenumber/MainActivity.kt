package edu.mx.itson.guessthenumber

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var minValue = 0
    private var maxValue = 100
    private var won = false
    private var num = 0
    private lateinit var guessings: Button
    private lateinit var down: Button
    private lateinit var up: Button
    private lateinit var guessed: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupVariables()
    }

    fun setupVariables() {
        guessings = findViewById(R.id.guessings)
        guessed = findViewById(R.id.guessed)
        down = findViewById(R.id.down)
        up = findViewById(R.id.up)
    }
}