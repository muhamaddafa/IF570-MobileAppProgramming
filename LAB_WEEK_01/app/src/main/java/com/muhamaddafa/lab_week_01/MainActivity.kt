package com.muhamaddafa.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nimDisplay = findViewById<TextView>(R.id.nim_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
                ?.text.toString().trim()
            val nimInput = findViewById<TextInputEditText>(R.id.nim_input)
                ?.text.toString().trim()

            if(nameInput.isNotEmpty() && nimInput.isNotEmpty()){
                if (nimInput.length != 11) {
                    Toast.makeText(this, getString(R.string.nim_error), Toast.LENGTH_LONG)
                        .apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
                } else {
                    nameDisplay?.text = getString(R.string.name_greet).plus(" ").plus(nameInput)
                    nimDisplay?.text = getString(R.string.nim_greet).plus(" ").plus(nimInput)
                }
            } else {
                Toast.makeText(this, getString(R.string.field_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
        }


    }
}