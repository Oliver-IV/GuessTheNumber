package edu.mx.itson.guessthenumber

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var minValue = 0
    var maxValue = 100
    var won = false
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

         val guessings: TextView
         val down: Button
         val up: Button
         val guessed: Button
         val generate: Button
        guessings = findViewById(R.id.guessings)
        guessed = findViewById(R.id.guessed)
        down = findViewById(R.id.down)
        up = findViewById(R.id.up)
        generate = findViewById(R.id.generate)
        generate.setOnClickListener {
            num = Random.nextInt(minValue, maxValue)
            guessings.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }

        up.setOnClickListener {
            minValue = num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            } else {
                guessings.setText("No puede ser :( me ganaste")
            }
        }

        down.setOnClickListener {
            maxValue = num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            } else {
                guessings.setText(num.toString())
            }
        }

        guessed.setOnClickListener {
            if (!won) {
                guessings.setText("Adiviné tu número, es el " + num)
                guessed.setText("Volver a jugar")
                won = true
            } else {
                generate.visibility = View.VISIBLE
                generate.setText("Haz clic en generar para comenzar")
                guessed.visibility = View.GONE
                resetValues()
            }
        }

    }

    fun resetValues() {
        minValue = 0
        maxValue = 100
        won = false
        num = 0
    }

    fun checkingLimits(): Boolean {
        return minValue != maxValue
    }
}